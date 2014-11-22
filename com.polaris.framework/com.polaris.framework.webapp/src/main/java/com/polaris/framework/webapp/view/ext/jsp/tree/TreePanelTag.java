package com.polaris.framework.webapp.view.ext.jsp.tree;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.annotation.TagLib;
import com.polaris.framework.webapp.view.ext.api.tree.ETreePanel;
import com.polaris.framework.webapp.view.ext.jsp.panel.AbstractPanelTag;

@TagLib(name = "treepanel", component = ETreePanel.class)
public class TreePanelTag extends AbstractPanelTag
{
    private static final long serialVersionUID = 1L;
    @TagAttribute
    protected Boolean         animate;
    @TagAttribute
    protected String          displayField;
    @TagAttribute
    protected Boolean         folderSort;
    @TagAttribute
    protected Boolean         hideHeaders;
    @TagAttribute
    protected Boolean         lines;
    @TagAttribute
    protected Object          root;
    @TagAttribute
    protected Boolean         rootVisible;
    @TagAttribute
    protected Boolean         singleExpand;
    @TagAttribute
    protected Boolean         useArrows;
    @TagAttribute
    protected String          store;
    
    public void setStore(String store)
    {
        this.store = store;
    }
    
    public void setAnimate(Boolean animate)
    {
        this.animate = animate;
    }
    
    public void setDisplayField(String displayField)
    {
        this.displayField = displayField;
    }
    
    public void setFolderSort(Boolean folderSort)
    {
        this.folderSort = folderSort;
    }
    
    public void setHideHeaders(Boolean hideHeaders)
    {
        this.hideHeaders = hideHeaders;
    }
    
    public void setLines(Boolean lines)
    {
        this.lines = lines;
    }
    
    public void setRoot(Object root)
    {
        this.root = root;
    }
    
    public void setRootVisible(Boolean rootVisible)
    {
        this.rootVisible = rootVisible;
    }
    
    public void setSingleExpand(Boolean singleExpand)
    {
        this.singleExpand = singleExpand;
    }
    
    public void setUseArrows(Boolean useArrows)
    {
        this.useArrows = useArrows;
    }
    
}
