/**
 * 前端与后端交互的对象
 */
var Ajax = function() {

	this.GET = function(uri) {
		return sendRequest(uri, {}, "GET");
	};

	this.POST = function(uri, data) {
		return sendRequest(uri, data, "POST");
	};

	this.DELETE = function(uri) {
		return sendRequest(uri, {}, "DELETE");
	};

	this.PUT = function(uri) {
		return sendRequest(uri, {}, "PUT");
	};

	function sendRequest(uri, data, method) {
		var json = JSON.stringify(data);
		$.ajax({
			type : method,
			async : false,
			url : "api" + uri,
			data : json,
			contentType : "application/json; charset=UTF-8",
			dataType : "json",
			cache : false,
			error : function(obj) {
				console.log("sendRequest failed! URI:" + uri + ", JSON:" + json);
			}
		});
	}
};

var ajax = new Ajax();

/**
 * Ext模块管理器
 */
var ModuleManager = function() {
	var moduleMap = {};

	/**
	 * 根据moduleId加载指定模块
	 */
	this.loadModule = function(moduleId) {
		var module = moduleMap[moduleId];
		if (module != null) {
			return module;
		}
		var moduleInfo = ajax.GET("/view/module/" + moduleId);
		var jsPath = moduleInfo.jsPath;
		if (jsPath != null) {
			// 动态加载JS文件
			$(document.body).append("<script type='text/javascript' src='" + jsPath + "'></script>");
		}
		console.log("loadModule: " + moduleId);
	};

	/**
	 * 注册一个Module. 在动态加载的JS中进行注册 <br>
	 * {id:"moduleId",create:function,destroy:function}
	 */
	this.registModule = function(module) {
		var obj = moduleMap[module.id];
		if (obj != null) {
			console.log("Module is exists! id:" + module.id);
			return;
		}
		moduleMap[module.id] = module;
	};
};

/**
 * 表格属性管理器
 */
var GridManager = function() {
	var gridMap = {};

	/**
	 * 获得表格的属性集合
	 */
	this.getFields = function(className) {
		if (gridMap[className] != null) {
			return gridMap[className];
		}
		var response = ajax.GET("/view/support/extjs/grid/" + className);
		if (response.success) {
			var grid = response.data;
			gridMap[className] = grid;
			return grid;
		} else {
			Ext.Msg.show({
				title : "错误",
				message : "数据模型加载失败!",
				buttons : Ext.Msg.OK,
				icon : Ext.Msg.ERROR
			});
		}
	};
};

/**
 * Model数据类型管理器
 */
var ModelManager = function() {
	var modelMap = {};

	/**
	 * 加载一个模型
	 */
	this.require = function(className) {
		if (modelMap[className] != null) {
			return;// 已经完成加载
		}
		var response = ajax.GET("/view/support/extjs/model/" + className);
		if (response.success) {
			var model = response.data;
			Ext.define(model.name, {
				extend : "Ext.data.Model",
				idProperty : model.idProperty,
				fields : model.modelFields
			});
			modelMap[className] = model;
		} else {
			Ext.Msg.show({
				title : "错误",
				message : "数据模型加载失败!",
				buttons : Ext.Msg.OK,
				icon : Ext.Msg.ERROR
			});
		}
	};

};