Ext.require([ "Ext.grid.*" ]);

Ext.onReady(function() {

	var userStore = Ext.create("Ext.data.Store", {
		autoLoad : true,
		autoSync : true,
		model : "User",
		proxy : {
			type : "rest",
			url : "../../platform/system/user"
		}
	});
	Ext.create('Ext.container.Viewport', {
		layout : 'border',
		items : [ Ext.create("Ext.grid.Panel", {
			id : "userGrid",
			region : "center",
			frame : true,
			title : "用户管理",
			store : userStore,
			columns : [ {
				text : "用户ID",
				width : 250,
				sortable : true,
				dataIndex : "id"
			}, {
				text : "用户名",
				width : 250,
				sortable : true,
				dataIndex : "username",
				field : {
					xtype : "textfield"
				}
			}, {
				header : "姓名",
				width : 200,
				sortable : true,
				dataIndex : "name",
				field : {
					xtype : "textfield"
				}
			}, {
				text : "备注",
				flex : 1,
				sortable : true,
				dataIndex : "remark",
				field : {
					xtype : "textfield"
				}
			} ],
			dockedItems : [ {
				xtype : "toolbar",
				items : [ {
					text : "添加",
					handler : function() {
						store.insert(0, new User());
					}
				}, "-", {
					text : "删除",
					disabled : true,
					handler : function() {
						var grid = Ext.getCmp("userGrid");
						var selection = grid.getView().getSelectionModel().getSelection()[0];
						if (selection) {
							store.remove(selection);
						}
					}
				} ]
			} ]
		}) ]
	});
});