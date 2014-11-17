Ext.require([ '*' ]);

Ext.onReady(function() {

	Ext.create('Ext.container.Viewport', {
		layout : 'border',
		items : [ {
			region : 'north',
			html : '<h1 class="x-panel-header">北极星智能平台联合实验室</h1>',
			border : true,
			margin : '0',
			split : true
		}, {
			region : 'west',
			collapsible : true,
			title : '导航树',
			width : 150,
			split : true,
			border : true,
			xtype : "treepanel",
			rootVisible : false,
			store : Ext.create('Ext.data.TreeStore', {
				root : {
					id : "root",
					expanded : true,
					children : [ {
						id : "node1",
						text : "百度",
						url : "http://www.baidu.com",
						leaf : true
					}, {
						id : "node2",
						text : "homework",
						expanded : true,
						children : [ {
							id : "node3",
							text : "华为官网",
							url : "http://www.huawei.com",
							leaf : true
						}, {
							id : "node4",
							text : "新浪",
							url : "http://www.sina.com",
							leaf : true
						} ]
					}, {
						id : "node5",
						text : "Google",
						url : "http://www.google.cn",
						leaf : true
					} ]
				}
			}),
			listeners : {
				itemclick : function(view, record) {
					var id = record.get("id");
					var text = record.get("text");
					var url = record.get("url");
					if (url != null) {
						var tabPanel = Ext.getCmp("tabpanel1");
						var panel = tabPanel.getComponent(id);
						if (panel == null) {
							panel = Ext.create("Ext.panel.Panel", {
								id : id,
								title : text,
								closable : true,
								html : "<iframe src='" + url + "' width='100%' height='100%'></iframe>"
							});
							tabPanel.add(panel);
						}
						tabPanel.setActiveTab(panel);
					}
				}
			}
		}, {
			id : "tabpanel1",
			region : 'center',
			xtype : 'tabpanel',
			autoScroll : true,
			items : [ {
				id : "root",
				title : '首页',
				html : '<p>wanglei is a dog! 1</p>'
			} ]
		} ]
	});
});
