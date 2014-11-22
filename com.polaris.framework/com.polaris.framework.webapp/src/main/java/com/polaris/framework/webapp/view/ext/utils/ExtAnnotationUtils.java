package com.polaris.framework.webapp.view.ext.utils;

import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.polaris.framework.webapp.common.exception.DockedException;
import com.polaris.framework.webapp.common.utils.ReflectUtils;
import com.polaris.framework.webapp.common.utils.WebUtils;
import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.ext.annotation.Ext;
import com.polaris.framework.webapp.view.ext.annotation.ExtChild;
import com.polaris.framework.webapp.view.ext.annotation.ExtChildren;
import com.polaris.framework.webapp.view.ext.annotation.ExtField;
import com.polaris.framework.webapp.view.ext.annotation.TagContent;
import com.polaris.framework.webapp.view.ext.annotation.TagDocked;
import com.polaris.framework.webapp.view.ext.annotation.VarType;
import com.polaris.framework.webapp.view.ext.api.EDefine;
import com.polaris.framework.webapp.view.ext.api.EModule;
import com.polaris.framework.webapp.view.ext.api.EReference;
import com.polaris.framework.webapp.view.ext.api.EUxObject;
import com.polaris.framework.webapp.view.ext.jsp.BaseTagSupport;

/**
 * EXT Annotation的工具类
 * 
 * @author wang.sheng
 */
public final class ExtAnnotationUtils
{
    static Log log = LogFactory.getLog(ExtAnnotationUtils.class);
    
    private ExtAnnotationUtils()
    {
    }
    
    private static boolean isEmptyCollection(Object obj)
    {
        if(obj == null)
        {
            return true;
        }
        if(obj instanceof List)
        {
            return ((List<?>) obj).size() == 0;
        }
        else if(obj instanceof Map)
        {
            return ((Map<?, ?>) obj).size() == 0;
        }
        else
        {
            return true;
        }
    }
    
    /**
     * 将EXT对象实例输出为JavaScript脚本
     * 
     * @param object
     * @param out
     * @param isRoot
     *            脚本元素是否是根节点
     * @throws Exception
     */
    public static void writeJavaScript(Object object, Writer out, boolean isRoot) throws Exception
    {
        if(object == null)
        {
            log.warn("object is null,do nothing and return!");
            return;
        }
        if(isRoot)
        {
            // 根节点,则object必须实现Module接口
            if(!(object instanceof EModule))
            {
                log.error("object is not instanceof Module,class=" + object.getClass());
                return;
            }
            EModule module = (EModule) object;
            if(!module.getClass().isAnnotationPresent(Ext.class))
            {
                // 没有找到@Ext注释
                log.error("module not contains @Ext,class=" + module.getClass());
                return;
            }
            boolean hasVar = module.getVarName() != null;
            if(hasVar)
            {
                out.write(module.getVarName() + " = ");
            }
            writeJavaScript(module, out, false);// 递归调用
            out.write(";\n");
        }
        else
        {
            // 非根节点
            if(object.getClass().isAnnotationPresent(Ext.class))
            {
                Ext ext = object.getClass().getAnnotation(Ext.class);
                if(ext.type() == VarType.CREATE)
                {
                    out.write(" Ext.create(\"" + ext.name() + "\",");
                    writeObject(object, out, 0);
                    out.write(")");
                }
                else if(ext.type() == VarType.DEFINE)
                {
                    if(object instanceof EDefine)
                    {
                        EDefine define = (EDefine) object;
                        out.write(" Ext.define(\"" + define.getDefine() + "\",");
                        writeObject(object, out, 0);
                        out.write(")");
                    }
                    else
                    {
                        log.warn("Ext.define is failed! Class:" + object.getClass() + " is not instanceof EDefine!");
                    }
                }
                else if(ext.type() == VarType.CONFIG)
                {
                    writeObject(object, out, 0);
                }
                else if(ext.type() == VarType.UX)
                {
                    // 自定义扩展的ext组件
                    if(object instanceof EUxObject)
                    {
                        EUxObject ux = (EUxObject) object;
                        out.write(" Ext.create(\"" + ux.getName() + "\",");
                        out.write(ux.getConfig());
                        out.write(")");
                    }
                    else
                    {
                        // 和普通的create创建流程相同
                        out.write(" Ext.create(\"" + ext.name() + "\",");
                        writeObject(object, out, 0);
                        out.write(")");
                    }
                }
            }
        }
    }
    
    private static void writeObject(Object object, Writer out, int level) throws Exception
    {
        Class<?> cl = object.getClass();
        Field[] fields = ReflectUtils.getAllFields(cl);
        boolean first = true;
        out.write("\n");
        for(int i = 0; i < level; i++)
        {
            out.write("    ");
        }
        out.write("{\n");
        if(cl.isAnnotationPresent(Ext.class))
        {
            // Config类型注释的需要加上xtype的头
            Ext ext = cl.getAnnotation(Ext.class);
            if(ext.type() == VarType.CONFIG)
            {
                String xtype = ext.name();
                if(xtype != null && xtype.length() > 0)
                {
                    first = false;
                    for(int i = 0; i < level; i++)
                    {
                        out.write("    ");
                    }
                    out.write("  xtype : " + WebUtils.quote(xtype));
                }
            }
            else if(ext.type() == VarType.DEFINE)
            {
                String extend = ext.name();
                if(extend != null && extend.length() > 0)
                {
                    first = false;
                    for(int i = 0; i < level; i++)
                    {
                        out.write("    ");
                    }
                    out.write("  extend : " + WebUtils.quote(extend));
                }
            }
        }
        for(Field field : fields)
        {
            if(field.isAnnotationPresent(ExtChild.class))
            {
                ExtChild extChild = field.getAnnotation(ExtChild.class);
                String fieldName = field.getName();
                if(extChild.name() != null && extChild.name().length() > 0)
                {
                    fieldName = extChild.name();
                }
                field.setAccessible(true);
                Object childValue = field.get(object);
                if(childValue == null)
                {
                    continue;
                }
                if(first)
                {
                    first = false;
                }
                else
                {
                    out.write(",\n");
                }
                for(int i = 0; i < level; i++)
                {
                    out.write("    ");
                }
                out.write("  " + fieldName + " : ");
                if(childValue instanceof String)
                {
                    // 说明是对象的引用
                    String content = (String) childValue;
                    out.write(WebUtils.convertToScript(content));
                }
                else if(childValue instanceof EReference)
                {
                    // 变量的引用
                    EReference ref = (EReference) childValue;
                    out.write(ref.getName());
                }
                else
                {
                    writeJavaScript(childValue, out, false);
                }
            }
            else if(field.isAnnotationPresent(ExtField.class))
            {
                ExtField extField = field.getAnnotation(ExtField.class);
                String fieldName = field.getName();
                if(extField.name() != null && extField.name().length() > 0)
                {
                    fieldName = extField.name();
                }
                field.setAccessible(true);
                Object value = field.get(object);
                if(value == null)
                {
                    continue;
                }
                String strValue = null;
                if(extField.isJson())
                {
                    strValue = WebUtils.toJson(value);
                }
                else
                {
                    strValue = WebUtils.valueToString(value);
                }
                if(first)
                {
                    first = false;
                }
                else
                {
                    out.write(",\n");
                }
                for(int i = 0; i < level; i++)
                {
                    out.write("    ");
                }
                out.write("  " + fieldName + " : " + strValue);
            }
            else if(field.isAnnotationPresent(ExtChildren.class))
            {
                ExtChildren extChildren = field.getAnnotation(ExtChildren.class);
                String fieldName = field.getName();
                if(extChildren.name() != null && extChildren.name().length() > 0)
                {
                    fieldName = extChildren.name();
                }
                field.setAccessible(true);
                Object value = field.get(object);
                if(value == null || isEmptyCollection(value))
                {
                    // 为空,或者是空的集合类型则不予考虑
                    continue;
                }
                if(first)
                {
                    first = false;
                }
                else
                {
                    out.write(",\n");
                }
                for(int i = 0; i < level; i++)
                {
                    out.write("    ");
                }
                
                if(value instanceof List)
                {
                    // 内容将会是一个数组
                    out.write("  " + fieldName + " : [");
                    List<?> children = (List<?>) value;
                    boolean firstChild = true;
                    for(Object child : children)
                    {
                        // 对子元素进行递归调用
                        if(firstChild)
                        {
                            firstChild = false;
                        }
                        else
                        {
                            out.write(",");
                        }
                        if(child.getClass().isAnnotationPresent(Ext.class))
                        {
                            Ext ext = child.getClass().getAnnotation(Ext.class);
                            if(ext.type() == VarType.CREATE)
                            {
                                out.write(" Ext.create(\"" + ext.name() + "\",");
                                writeObject(child, out, level + 1);
                                out.write(")");
                            }
                            else if(ext.type() == VarType.CONFIG)
                            {
                                writeObject(child, out, level + 1);
                            }
                            else if(ext.type() == VarType.DEFINE)
                            {
                                log.warn("Define is not supported in child Object!");
                            }
                            else if(ext.type() == VarType.UX)
                            {
                                // 自定义扩展的ext组件
                                if(child instanceof EUxObject)
                                {
                                    EUxObject ux = (EUxObject) child;
                                    out.write(" Ext.create(\"" + ux.getName() + "\",");
                                    out.write(ux.getConfig());
                                    out.write(")");
                                }
                                else
                                {
                                    // 和普通的create创建流程相同
                                    out.write(" Ext.create(\"" + ext.name() + "\",");
                                    writeObject(child, out, level + 1);
                                    out.write(")");
                                }
                            }
                        }
                        else if(child instanceof String)
                        {
                            // 是字符串
                            String content = (String) child;
                            out.write(WebUtils.convertToScript(content));
                        }
                        else if(child instanceof EReference)
                        {
                            // 变量的引用
                            EReference ref = (EReference) child;
                            out.write(ref.getName());
                        }
                    }
                    out.write("]");
                }
                else if(value instanceof Map)
                {
                    out.write("  " + fieldName + " : {");
                    boolean firstChild = true;
                    for(Map.Entry<?, ?> entry : ((Map<?, ?>) value).entrySet())
                    {
                        // 对子元素进行递归调用
                        if(firstChild)
                        {
                            firstChild = false;
                        }
                        else
                        {
                            out.write(",");
                        }
                        String key = String.valueOf(entry.getKey());
                        out.write(key + " : ");
                        Object child = entry.getValue();
                        if(child.getClass().isAnnotationPresent(Ext.class))
                        {
                            // 是子对象
                            Ext ext = child.getClass().getAnnotation(Ext.class);
                            if(ext.type() == VarType.CREATE)
                            {
                                out.write(" Ext.create(\"" + ext.name() + "\",");
                                writeObject(child, out, level + 1);
                                out.write(")");
                            }
                            else if(ext.type() == VarType.CONFIG)
                            {
                                writeObject(child, out, level + 1);
                            }
                            else if(ext.type() == VarType.DEFINE)
                            {
                                log.warn("Define is not supported in child Object!");
                            }
                            else if(ext.type() == VarType.UX)
                            {
                                // 自定义扩展的ext组件
                                if(child instanceof EUxObject)
                                {
                                    EUxObject ux = (EUxObject) child;
                                    out.write(" Ext.create(\"" + ux.getName() + "\",");
                                    out.write(ux.getConfig());
                                    out.write(")");
                                }
                                else
                                {
                                    // 和普通的create创建流程相同
                                    out.write(" Ext.create(\"" + ext.name() + "\",");
                                    writeObject(child, out, level + 1);
                                    out.write(")");
                                }
                            }
                        }
                        else if(child instanceof String)
                        {
                            // 是字符串
                            String content = (String) child;
                            out.write(WebUtils.convertToScript(content));
                        }
                        else if(child instanceof EReference)
                        {
                            // 变量的引用
                            EReference ref = (EReference) child;
                            out.write(ref.getName());
                        }
                    }
                    out.write("}");
                }
                else
                {
                    throw new RuntimeException("UnSupported Collection type:" + value.getClass());
                }
            }
        }
        out.write("\n");
        for(int i = 0; i < level; i++)
        {
            out.write("    ");
        }
        out.write("}");
    }
    
    /**
     * 查找符合条件的具备@TagDocked注释的方法
     * 
     * @param target
     * @param dockedChild
     * @return
     */
    public static Method findDockedMethod(Object target, Object dockedChild)
    {
        if(target == null || dockedChild == null)
        {
            throw new IllegalArgumentException("target or dockedType is null! target=" + target + ",dockedChild="
                            + dockedChild);
        }
        Class<?> dockedType = dockedChild.getClass();
        boolean isRef = false;
        if(dockedChild instanceof EReference)
        {
            // 为变量的引用
            EReference ref = (EReference) dockedChild;
            dockedType = ref.getTarget().getClass();
            isRef = true;
        }
        Method[] methods = ReflectUtils.getAllMethods(target.getClass());
        for(Method method : methods)
        {
            if(method.isAnnotationPresent(TagDocked.class))
            {
                if(method.getParameterTypes().length != 1)
                {
                    // 方法参数不唯一,是个错误的情况
                    log.warn("Target:" + target.getClass() + " method:" + method.getName()
                                    + ", params number is not 1!");
                    continue;
                }
                TagDocked tagDocked = method.getAnnotation(TagDocked.class);
                Class<?> requireType = tagDocked.dockType();
                Class<?> paramType = method.getParameterTypes()[0];
                if(requireType == Object.class)
                {
                    requireType = paramType;
                }
                if(isRef)
                {
                    // 是变量引用
                    if(requireType.isAssignableFrom(dockedType) && paramType == EReference.class)
                    {
                        // 参数类型必须是引用类型EReference对象
                        return method;
                    }
                }
                else
                {
                    // 不是变量引用,需要的类型和参数类型一致即可
                    if(requireType.isAssignableFrom(dockedType) && paramType != EReference.class)
                    {
                        return method;
                    }
                }
            }
        }
        throw new DockedException("Class:" + target.getClass() + ",dockType:" + dockedType + " is not found!");
    }
    
    /**
     * 自动装配一个Ext对象,通常用于从tag向ui映射
     * 
     * @param target
     * @param source
     * @param request
     */
    public static void assembleyExtObject(Object target, BaseTagSupport source, ServletRequest request)
    {
        if(target == null || source == null)
        {
            throw new IllegalArgumentException("objct is null! target=" + target + ",source=" + source);
        }
        Method[] methods = ReflectUtils.getAllMethods(target.getClass());
        for(Method method : methods)
        {
            if(method.isAnnotationPresent(TagContent.class))
            {
                String content = source.getBodyContent().getString();
                if(content != null && content.trim().length() > 0)
                {
                    method.setAccessible(true);
                    try
                    {
                        method.invoke(target, content);
                    }
                    catch(Exception e)
                    {
                        // TODO Auto-generated catch block
                        log.error("method invoke failed! target:" + target + ",method:" + method.getName(), e);
                        continue;
                    }
                }
            }
            if(method.isAnnotationPresent(TagAttribute.class))
            {
                TagAttribute attribute = method.getAnnotation(TagAttribute.class);
                String fieldName = attribute.name();
                if(fieldName == null || fieldName.length() < 1)
                {
                    fieldName = ReflectUtils.getFieldNameByMethod(method);
                }
                Object fieldValue = ReflectUtils.getFieldValue(source, fieldName);
                if(fieldValue == null)
                {
                    // 取值为空不要进行设置
                    continue;
                }
                if(attribute.isURL())
                {
                    String url = String.valueOf(fieldValue);
                    fieldValue = WebUtils.toRealURL(url, request.getServletContext());
                }
                try
                {
                    method.setAccessible(true);
                    method.invoke(target, fieldValue);
                }
                catch(Exception e)
                {
                    // TODO Auto-generated catch block
                    log.error("method invoke failed! target:" + target + ",method:" + method.getName(), e);
                    continue;
                }
            }
        }
    }
}
