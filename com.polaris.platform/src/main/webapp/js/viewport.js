Ext.require([ '*' ]);

var moduleManager = new ModuleManager();// 定义模块管理器

Ext.define("User", {
	extend : "Ext.data.Model",
	idProperty : "id",
	fields : [ "id", "username", "password", "name", "remark" ]
});

Ext.onReady(function() {

	var userStore = Ext.create("Ext.data.Store", {
		autoLoad : true,
		model : "User",
		proxy : {
			type : "rest",
			url : "api/platform/system/user",
			reader : {
				type : "json",
			},
			writer : {
				type : "json",
				writeAllFields : true,
				allowSingle : false
			}
		}
	});

	Ext.create('Ext.container.Viewport', {
		layout : 'border',
		items : [ {
			region : 'west',
			collapsible : true,
			title : '导航树',
			width : 220,
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
						}, {
							id : "node41",
							text : "用户管理",
							url : "user.html",
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
					var url = record.get("url");
					var text = record.get("text");
					if (url != null) {
						var tabPanel = Ext.getCmp("tabpanel1");
						var panel = tabPanel.getComponent(id);
						if (panel == null) {
							panel = Ext.create("Ext.grid.Panel", {
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
			items : []
		} ]
	});
});
