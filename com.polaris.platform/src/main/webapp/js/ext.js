var currentUserId = "";
function saveRoleDataStore(roleIds) {
	Ext.Ajax.request({
		url : "/jsjty/system/user/updateUserRole.json",
		params : {
			roleIds : roleIds,
			userId : currentUserId
		},
		success : function(response, opts) {
			var obj = Ext.decode(response.responseText);
			Ext.MessageBox.show({
				title : '消息',
				msg : obj.message,
				buttons : Ext.Msg.OK,
				icon : Ext.Msg.INFO
			});
		},
		failure : function(response, opts) {
			Ext.MessageBox.show({
				title : '错误',
				msg : "操作失败!",
				buttons : Ext.Msg.OK,
				icon : Ext.Msg.ERROR
			});
		}
	});
}
var addUserWindow;
var editUserWindow;
var roleDataStore1;
var roleDataStore2;
var userRoleRelWindow;
var userDataStore;
Ext.require([ '*' ]);
Ext.onReady(function() {
	Ext.QuickTips.init();
	Ext.define("System.User", {
		extend : "Ext.data.Model",
		idProperty : "id",
		proxy : {
			type : "ajax",
			reader : {
				root : "results",
				totalProperty : "totalCount",
				successProperty : "success"
			},
			api : {
				read : "/jsjty/common/paging/hibernate.json",
				create : "/jsjty/system/user/create.json",
				update : "/jsjty/system/user/update.json",
				destroy : "/jsjty/system/user/destroy.json"
			},
			writer : {
				type : "json",
				writeAllFields : true,
				allowSingle : false
			}
		},
		fields : [ {
			name : "id"
		}, {
			name : "username"
		}, {
			name : "name"
		}, {
			name : "remark"
		} ]
	});
	Ext.define("System.Role", {
		extend : "Ext.data.Model",
		idProperty : "id",
		fields : [ {
			name : "id"
		}, {
			name : "name"
		}, {
			name : "remark"
		} ]
	});
	addUserWindow = Ext.create("Ext.window.Window", {
		animateTarget : "button_addUserWindow",
		constrain : true,
		modal : true,
		title : "添加用户",
		closeAction : "hide",
		buttonAlign : "center",
		buttons : [ {
			xtype : "button",
			text : "保存",
			title : "保存",
			handler : function() {
				var form = Ext.getCmp("addUserForm").getForm();
				if (form.isValid()) {
					form.submit({
						success : function(form, action) {
							userDataStore.load();
							Ext.MessageBox.show({
								title : '操作成功',
								msg : action.result.message,
								buttons : Ext.Msg.OK,
								icon : Ext.Msg.INFO
							});
						},
						failure : function(form, action) {
							Ext.MessageBox.show({
								title : '操作失败',
								msg : action.result.message,
								buttons : Ext.Msg.OK,
								icon : Ext.Msg.ERROR
							});
						}
					});
				}
			}
		}, {
			xtype : "button",
			text : "重置",
			handler : function() {
				var form = Ext.getCmp("addUserForm").getForm();
				form.reset();
			}
		}, {
			xtype : "button",
			text : "关闭",
			handler : function() {
				addUserWindow.setVisible(false);
				userDataStore.load();
			}
		} ],
		layout : "fit",
		items : [ Ext.create("Ext.form.Panel", {
			fieldDefaults : {
				labelAlign : 'left',
				labelWidth : 50,
				anchor : '100%'
			},
			url : "/jsjty/system/user/save.json",
			anchor : "100% 100%",
			preventHeader : true,
			items : [ {
				xtype : "hidden",
				name : "id",
				value : ""
			}, {
				xtype : "textfield",
				allowBlank : false,
				blankText : "用户名不可以为空!",
				name : "username",
				fieldLabel : "用户名"
			}, {
				xtype : "textfield",
				allowBlank : false,
				blankText : "姓名不可以为空!",
				name : "name",
				fieldLabel : "姓名"
			}, {
				xtype : "textfield",
				inputType : "password",
				allowBlank : false,
				blankText : "密码不可以为空!",
				name : "password",
				fieldLabel : "密码"
			}, {
				xtype : "textareafield",
				name : "remark",
				fieldLabel : "备注",
				height : 80
			} ],
			autoScroll : true,
			frame : true,
			id : "addUserForm"
		}) ],
		width : 450,
		height : 250,
		minHeight : 200,
		minWidth : 400
	});
	editUserWindow = Ext.create("Ext.window.Window", {
		animateTarget : "button_editUserWindow",
		constrain : true,
		modal : true,
		title : "修改用户",
		closeAction : "hide",
		buttonAlign : "center",
		buttons : [ {
			xtype : "button",
			text : "保存",
			handler : function() {
				var form = Ext.getCmp("editUserForm").getForm();
				if (form.isValid()) {
					form.submit({
						success : function(form, action) {
							form.setValues(action.result.data.user);
							userDataStore.load();
							Ext.MessageBox.show({
								title : '操作成功',
								msg : action.result.message,
								buttons : Ext.Msg.OK,
								icon : Ext.Msg.INFO
							});
						},
						failure : function(form, action) {
							Ext.MessageBox.show({
								title : '操作失败',
								msg : action.result.message,
								buttons : Ext.Msg.OK,
								icon : Ext.Msg.ERROR
							});
						}
					});
				}
			},
			iconCls : "framework_save"
		}, {
			xtype : "button",
			text : "重置",
			handler : function() {
				var form = Ext.getCmp("editUserForm").getForm();
				var field = form.findField("id");
				var userId = field.getValue();
				form.reset();
				form.load({
					url : '/jsjty/system/user/load.json',
					params : {
						userId : userId
					},
					failure : function(form, action) {
						Ext.Msg.show({
							title : "加载失败",
							msg : action.result.errorMessage,
							buttons : Ext.MessageBox.OK,
							icon : Ext.MessageBox.ERROR
						});
					}
				});
			}
		}, {
			xtype : "button",
			text : "关闭",
			handler : function() {
				editUserWindow.setVisible(false);
				userDataStore.load();
			}
		} ],
		layout : "fit",
		items : [ Ext.create("Ext.form.Panel", {
			fieldDefaults : {
				labelAlign : 'left',
				labelWidth : 50,
				anchor : '100%'
			},
			url : "/jsjty/system/user/save.json",
			anchor : "100% 100%",
			preventHeader : true,
			items : [ {
				xtype : "hidden",
				name : "id",
				value : ""
			}, {
				xtype : "textfield",
				allowBlank : false,
				name : "username",
				fieldLabel : "用户名",
				readOnly : true
			}, {
				xtype : "textfield",
				allowBlank : false,
				blankText : "姓名不可以为空!",
				name : "name",
				fieldLabel : "姓名"
			}, {
				xtype : "textareafield",
				name : "remark",
				fieldLabel : "备注",
				height : 80
			} ],
			autoScroll : true,
			frame : true,
			id : "editUserForm"
		}) ],
		width : 450,
		height : 250,
		minHeight : 200,
		minWidth : 400
	});
	roleDataStore1 = Ext.create("Ext.data.Store", {
		autoDestroy : true,
		pageSize : 200,
		autoLoad : false,
		model : "System.Role",
		proxy : {
			type : "ajax",
			reader : {
				root : "results",
				totalProperty : "totalCount",
				successProperty : "success"
			},
			api : {
				read : "/jsjty/system/role/readUserRole.json"
			},
			writer : {
				type : "json",
				writeAllFields : true,
				allowSingle : false
			}
		}
	});
	roleDataStore2 = Ext.create("Ext.data.Store", {
		autoDestroy : true,
		pageSize : 200,
		autoLoad : false,
		model : "System.Role",
		proxy : {
			type : "ajax",
			reader : {
				root : "results",
				totalProperty : "totalCount",
				successProperty : "success"
			},
			api : {
				read : "/jsjty/system/role/readOtherUserRole.json"
			},
			writer : {
				type : "json",
				writeAllFields : true,
				allowSingle : false
			}
		}
	});
	userRoleRelWindow = Ext.create("Ext.window.Window", {
		animateTarget : "button_userrolerelUserWindow",
		constrain : true,
		maximizable : true,
		modal : true,
		title : "用户角色",
		closeAction : "hide",
		buttonAlign : "center",
		buttons : [ {
			xtype : "button",
			text : "保存",
			handler : function() {
				var count = roleDataStore1.getCount();
				var roleIds = "";
				for ( var i = 0; i < count; i++) {
					if (i > 0) {
						roleIds += ",";
					}
					var data = roleDataStore1.getAt(i);
					roleIds += data.getId();
				}
				saveRoleDataStore(roleIds);
			}
		}, {
			xtype : "button",
			text : "关闭",
			handler : function() {
				userRoleRelWindow.setVisible(false);
			}
		} ],
		layout : {
			type : 'border',
			padding : 2
		},
		defaults : {
			split : true
		},
		items : [ Ext.create("Ext.grid.Panel", {
			store : roleDataStore1,
			columns : [ {
				header : "角色",
				dataIndex : "name",
				flex : 1
			}, {
				header : "备注",
				dataIndex : "remark",
				flex : 2
			} ],
			viewConfig : {
				plugins : {
					ptype : 'gridviewdragdrop',
					dragGroup : 'firstGridDDGroup',
					dropGroup : 'secondGridDDGroup'
				}
			},
			region : "west",
			title : "已选角色",
			anchor : "100% 100%",
			autoScroll : true,
			flex : 1,
			id : "firstRoleGridPanel"
		}), Ext.create("Ext.grid.Panel", {
			store : roleDataStore2,
			columns : [ {
				header : "角色",
				dataIndex : "name",
				flex : 1
			}, {
				header : "备注",
				dataIndex : "remark",
				flex : 2
			} ],
			viewConfig : {
				plugins : {
					ptype : 'gridviewdragdrop',
					dragGroup : 'secondGridDDGroup',
					dropGroup : 'firstGridDDGroup'
				}
			},
			region : "center",
			title : "备选角色",
			anchor : "100% 100%",
			autoScroll : true,
			flex : 1,
			id : "secondRoleGridPanel"
		}) ],
		width : 600,
		height : 350,
		minHeight : 200,
		minWidth : 400
	});
	userDataStore = Ext.create("Ext.data.Store", {
		autoDestroy : true,
		pageSize : 20,
		autoLoad : true,
		model : "System.User",
		listeners : {
			write : function(store, operation, eOpts) {
				store.load();
			}
		}
	});
	Ext.create("Ext.Viewport", {
		layout : {
			type : 'border',
			padding : 2
		},
		defaults : {
			split : true
		},
		items : [ Ext.create("Ext.form.Panel", {
			fieldDefaults : {
				labelAlign : 'left',
				labelWidth : 60
			},
			url : "/jsjty/system/user/query.json",
			region : "north",
			anchor : "90% 90%",
			buttonAlign : "center",
			preventHeader : true,
			items : [ {
				xtype : "fieldset",
				title : "查询条件",
				layout : "hbox",
				padding : "0 0 5 0",
				items : [ {
					xtype : "textfield",
					name : "username",
					fieldLabel : "用户名",
					flex : 1
				}, {
					xtype : "textfield",
					name : "name",
					fieldLabel : "姓名",
					flex : 1
				}, {
					xtype : "textfield",
					name : "remark",
					fieldLabel : "备注",
					flex : 2
				} ]
			} ],
			autoScroll : true,
			minHeight : 80,
			maxHeight : 120,
			frame : true,
			id : "queryUserForm"
		}), Ext.create("Ext.grid.Panel", {
			store : userDataStore,
			columns : [ Ext.create("Ext.grid.RowNumberer", {

			}), {
				header : "用户名",
				dataIndex : "username",
				flex : 1
			}, {
				header : "姓名",
				dataIndex : "name",
				flex : 1,
				field : "textfield"
			}, {
				header : "备注",
				dataIndex : "remark",
				flex : 4,
				field : "textfield",
				sortable : false
			} ],
			dockedItems : [ {
				xtype : "pagingtoolbar",
				store : userDataStore,
				displayInfo : true,
				items : [ "-", {
					xtype : "combobox",
					store : Ext.create("Ext.data.ArrayStore", {
						data : [ [ 10 ], [ 20 ], [ 30 ], [ 40 ], [ 50 ] ],
						fields : [ {
							name : "value",
							type : "int"
						} ]
					}),
					displayField : "value",
					valueField : "value",
					labelWidth : 65,
					fieldLabel : "每页显示",
					width : 125,
					value : "20",
					listeners : {
						select : function(combo, records, eOpts) {
							var number = combo.getValue() * 1.0;
							if (number > 0) {
								userDataStore.pageSize = number;
								userDataStore.loadPage(1);
							}
						}
					}
				} ],
				dock : "bottom"
			}, {
				xtype : "toolbar",
				items : [ {
					xtype : "button",
					tooltip : "刷新",
					text : "刷新",
					handler : function() {
						userDataStore.load();
					}
				}, {
					xtype : "button",
					tooltip : "查询",
					handler : function() {
						var form = Ext.getCmp("queryUserForm").getForm();
						form.submit({
							success : function(form, action) {
								System.User.getProxy().setExtraParam("pagingParam", action.result.data.pagingParam);
								userDataStore.load();
							}
						});
					}
				}, "-", {
					xtype : "button",
					tooltip : "添加",
					handler : function() {
						addUserWindow.setVisible(true);
					},
					id : "button_addUserWindow"
				}, {
					xtype : "button",
					tooltip : "修改",
					handler : function() {
						var gridPanel = Ext.getCmp("userGridPanel");
						var selection = gridPanel.getView().getSelectionModel().getSelection();
						if (selection.length < 1) {
							Ext.Msg.show({
								title : "注意",
								msg : "请选择需要修改的用户!",
								buttons : Ext.MessageBox.OK,
								icon : Ext.MessageBox.WARNING,
								animateTarget : "button_editUserWindow"
							});
							return;
						}
						var userId = selection[0].getId();
						editUserWindow.setVisible(true);
						var editUserForm = Ext.getCmp("editUserForm");
						editUserForm.getForm().load({
							url : '/jsjty/system/user/load.json',
							params : {
								userId : userId
							},
							failure : function(form, action) {
								Ext.Msg.show({
									title : "加载失败",
									msg : action.result.errorMessage,
									buttons : Ext.MessageBox.OK,
									icon : Ext.MessageBox.ERROR
								});
							}
						});
					},
					id : "button_editUserWindow"
				}, {
					xtype : "button",
					tooltip : "删除",
					handler : function() {
						var gridPanel = Ext.getCmp("userGridPanel");
						var selection = gridPanel.getView().getSelectionModel().getSelection();
						if (selection.length < 1) {
							Ext.Msg.show({
								title : "注意",
								msg : "请选择需要删除的用户!",
								buttons : Ext.MessageBox.OK,
								icon : Ext.MessageBox.WARNING,
								animateTarget : "button_deleteUser"
							});
							return;
						}
						Ext.Msg.confirm("确认", "确定删除选中的用户?", function(btn) {
							if (btn == "yes") {
								userDataStore.remove(selection);
								userDataStore.sync();
							}
						});
					},
					id : "button_deleteUser"
				}, {
					xtype : "button",
					tooltip : "保存",
					handler : function() {
						userDataStore.sync();
					}
				}, "-", {
					xtype : "button",
					tooltip : "角色",
					handler : function() {
						var gridPanel = Ext.getCmp("userGridPanel");
						var selection = gridPanel.getView().getSelectionModel().getSelection();
						if (selection.length < 1) {
							Ext.Msg.show({
								title : "注意",
								msg : "请选择需要设置角色的用户!",
								buttons : Ext.MessageBox.OK,
								icon : Ext.MessageBox.WARNING,
								animateTarget : "button_userrolerelUserWindow"
							});
							return;
						}
						var userId = selection[0].getId();
						var userName = selection[0].get("username");
						roleDataStore1.getProxy().setExtraParam("userId", userId);
						roleDataStore2.getProxy().setExtraParam("userId", userId);
						roleDataStore1.load();
						roleDataStore2.load();
						currentUserId = userId;
						userRoleRelWindow.setTitle("设置用户:<font color=red>" + userName + "</font>的角色");
						userRoleRelWindow.setVisible(true);
					},
					id : "button_userrolerelUserWindow"
				} ]
			} ],
			selModel : Ext.create("Ext.selection.CheckboxModel", {}),
			invalidateScrollerOnRefresh : true,
			region : "center",
			anchor : "100% 100%",
			preventHeader : true,
			autoScroll : true,
			plugins : [ Ext.create("Ext.grid.plugin.CellEditing", {
				clicksToEdit : 1
			}) ],
			id : "userGridPanel"
		}) ]
	});
});
