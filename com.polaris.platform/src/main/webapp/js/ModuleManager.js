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
			$(document.body).append("<script type='text/javascript' src='" + jsPath + "'></script>");
		}
	};

	/**
	 * 注册一个Module <br>
	 * {id:"moduleId",create:function,destroy:function}
	 */
	function registModule(module) {
		var obj = moduleMap[module.id];
		if (obj != null) {
			console.log("Module is exists! id:" + module.id);
			return;
		}
		moduleMap[module.id] = module;
	}
};