Ext.require([ '*' ]);

Ext.onReady(function() {
	Ext.create('Ext.container.Viewport', {
		layout : 'border',
		items : [ {
			region : 'north',
			html : '<h1 class="x-panel-header">����������ƽ̨����ʵ����</h1>',
			border : false,
			margin : '0',
			split : true
		}, {
			region : 'west',
			collapsible : true,
			title : '������',
			width : 150,
			split : true
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
