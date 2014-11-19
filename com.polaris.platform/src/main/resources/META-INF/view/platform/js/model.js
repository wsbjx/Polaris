Ext.require([ "Ext.data.*" ]);

/**
 * 定义用户模型
 */
Ext.define("User", {
	extend : "Ext.data.Model",
	fields : [ "id", "username", "name", "remark" ]
});