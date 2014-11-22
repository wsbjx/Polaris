package com.polaris.framework.webapp.view.ext.api;

import java.util.ArrayList;
import java.util.List;

import com.polaris.framework.webapp.view.ext.annotation.TagDocked;


/**
 * 构成ext界面中的body内容
 * 
 * @author wang.sheng
 */
public class ERootBody
{
    private List<Object> children = new ArrayList<Object>();
    
    @TagDocked
    public void docked(Object child)
    {
        children.add(child);
    }
    
    public Object[] getChildren()
    {
        return children.toArray();
    }
    
    /**
     * 根据varName查找模块<br>
     * 返回null表示没有找到<br>
     * 
     * @param varName
     * @return
     */
    public EModule findModule(String varName)
    {
        for(Object obj : children)
        {
            if(obj instanceof EModule)
            {
                EModule module = (EModule) obj;
                if(module.getVarName() != null && module.getVarName().equals(varName))
                {
                    return module;
                }
            }
        }
        return null;
    }
}
