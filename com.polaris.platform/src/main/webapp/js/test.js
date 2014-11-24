$(function() {
	alert("wanglei is a dog!");

	var gridPanel = Ext.create("Ext.grid.Panel", {
		closable : true,
		closeAction : "destroy",
		frame : false,
		title : text,
		store : userStore,
		preventHeader : true,
		selModel : Ext.create("Ext.selection.CheckboxModel", {}),
		columns : [ Ext.create("Ext.grid.RowNumberer", {}), {
			header : "ID",
			width : 250,
			dataIndex : "id",
			field : {
				xtype : "textfield"
			}
		}, {
			text : "用户名",
			width : 250,
			sortable : true,
			dataIndex : "username",
			field : {
				xtype : "textfield"
			}
		}, {
			header : "密码",
			width : 250,
			dataIndex : "password",
			field : {
				xtype : "passwordfield"
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
		plugins : [ Ext.create("Ext.grid.plugin.CellEditing", {
			clicksToEdit : 1
		}) ],
		dockedItems : [ {
			xtype : "toolbar",
			items : [ {
				text : "刷新",
				handler : function() {
					userStore.load();
				}
			}, {
				text : "添加",
				handler : function() {
					var user = new User();
					user.set("id", "");
					userStore.insert(0, user);
				}
			}, {
				text : "保存",
				handler : function() {
					userStore.sync();
				}
			}, "-", {
				text : "删除",
				handler : function() {
					var grid = Ext.getCmp("userGrid");
					var selection = grid.getView().getSelectionModel().getSelection()[0];
					if (selection) {
						store.remove(selection);
					}
				}
			} ]
		}, {
			xtype : "pagingtoolbar",
			store : userStore,
			displayInfo : true,
			dock : "bottom"
		} ]
	});

	// 注册模块
	moduleManager.registModule({
		id : "test",
		create : function() {
			return gridPanel;
		},
		destroy : function() {
			if (gridPanel != null) {
				gridPanel.close();
				gridPanel = null;
			}
		}
	});
});