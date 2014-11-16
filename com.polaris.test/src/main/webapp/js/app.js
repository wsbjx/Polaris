Ext.require([ '*' ]);

Ext.onReady(function() {

	Ext.create('Ext.container.Viewport', {
		layout : 'border',
		items : [ {
			region : 'north',
			html : '<h1 class="x-panel-header">����������ƽ̨����ʵ����</h1>',
			border : true,
			margin : '0',
			split : true
		}, {
			region : 'west',
			collapsible : true,
			title : '������',
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
						text : "detention",
						leaf : true
					}, {
						id : "node2",
						text : "homework",
						expanded : true,
						children : [ {
							id : "node3",
							text : "book report",
							leaf : true
						}, {
							id : "node4",
							text : "algebra",
							leaf : true
						} ]
					}, {
						id : "node5",
						text : "buy lottery tickets",
						leaf : true
					} ]
				}
			}),
			listeners : {
				itemclick : function(view, record) {
					var nodeId = record.get("id");
					alert("nodeId=" + nodeId);
				}
			}
		}, {
			region : 'center',
			xtype : 'tabpanel',
			items : [ {
				rtl : false,
				title : '��ҳ',
				html : '<p>wanglei is a dog!</p>'
			}, {
				title : 'ģ�����',
				html : 'Hello world 2',
				closable : true
			}, {
				title : '�û�����',
				html : 'Hello world 3',
				closable : true
			} ]
		} ]
	});
});
