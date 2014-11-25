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

var moduleManager = new ModuleManager();

/**
 * Model数据类型管理器
 */
var ModelManager = function() {
	var modelMap = {};
	

};