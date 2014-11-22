package com.polaris.framework.webapp.view.ext.jsp.tab;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.annotation.TagLib;
import com.polaris.framework.webapp.view.ext.api.tab.ETabPanel;
import com.polaris.framework.webapp.view.ext.jsp.panel.AbstractPanelTag;

@TagLib(name = "tabpanel", component = ETabPanel.class)
public class TabPanelTag extends AbstractPanelTag
{
    private static final long serialVersionUID = 1L;
    @TagAttribute
    protected String          layout;
    @TagAttribute
    protected Integer         minTabWidth;
    @TagAttribute
    protected Integer         maxTabWidth;
    @TagAttribute
    protected String          activeTab;
    @TagAttribute
    protected Boolean         plain;
    @TagAttribute
    protected Boolean         removePanelHeader;
    @TagAttribute
    protected String          tabPosition;
    
    public void setLayout(String layout)
    {
        this.layout = layout;
    }
    
    public void setMinTabWidth(Integer minTabWidth)
    {
        this.minTabWidth = minTabWidth;
    }
    
    public void setMaxTabWidth(Integer maxTabWidth)
    {
        this.maxTabWidth = maxTabWidth;
    }
    
    public void setActiveTab(String activeTab)
    {
        this.activeTab = activeTab;
    }
    
    public void setPlain(Boolean plain)
    {
        this.plain = plain;
    }
    
    public void setRemovePanelHeader(Boolean removePanelHeader)
    {
        this.removePanelHeader = removePanelHeader;
    }
    
    public void setTabPosition(String tabPosition)
    {
        this.tabPosition = tabPosition;
    }
    
}
