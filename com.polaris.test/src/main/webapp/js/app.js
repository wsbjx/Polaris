Ext.require([ '*' ]);

Ext.onReady(function() {
	Ext.create('Ext.container.Viewport', {
		layout : 'border',
		items : [ {
			region : 'north',
			html : '<h1 class="x-panel-header">北极星智能平台联合实验室</h1>',
			border : false,
			margin : '0',
			split : true
		}, {
			region : 'west',
			collapsible : true,
			title : '导航树',
			width : 150,
			split : true
		}, {
			region : 'center',
			xtype : 'tabpanel',
			items : [ {
				rtl : false,
				title : '首页',
				html : '<p>wanglei is a dog!</p>'
			}, {
				title : '模块管理',
				html : 'Hello world 2',
				closable : true
			}, {
				title : '用户管理',
				html : 'Hello world 3',
				closable : true
			} ]
		} ]
	});
});
