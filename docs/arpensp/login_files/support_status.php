//<Script>
var _chat_support_window;

function start_chat_support_window21324(operator, dept) {

	var querystring = "";

	var _chat_support_variables;

	try {
		_chat_support_variables = parent._chat_support_variables;
	} catch(e) {
		_chat_support_variables = {};
	}
	//alert(_chat_support_variables);
	if (dept)
		querystring += "&DEPT_STATUS["+dept+"]=1&DEPT=" + dept;
	
	if (operator)
		querystring += "&info[invited_by_operator]="+operator;
		
	var show_dept_list = "";
	if (show_dept_list)
		querystring += "&SHOW_DEPT_LIST=" + show_dept_list;

	try {
		if  (typeof(_chat_support_variables)!='object') {
			var _chat_support_variables = new Array();
		}
	
		var _WTK_appName;
		
		if (navigator.userAgent.indexOf("Opera") != -1)
			_WTK_appName = "Opera";
		else if (navigator.userAgent.indexOf("Firefox") != -1)
			_WTK_appName = "Firefox";
		else if (navigator.userAgent.indexOf("Netscape") != -1)
			_WTK_appName = "Netscape";
		else if (navigator.userAgent.indexOf("MSIE") != -1)
			_WTK_appName = "Microsoft Internet Explorer";
		else if (navigator.userAgent.indexOf("Chrome") != -1)
			_WTK_appName = "Google Chrome";
		else
			_WTK_appName = navigator.appName;
	
		_chat_support_variables['appName']		= _WTK_appName;
		_chat_support_variables['appVersion']	= navigator.appVersion;
	//	_chat_support_variables['appUserAgent']	= navigator.userAgent;
	
		if (navigator.platform)
		_chat_support_variables['platform']		= navigator.platform;
	
		for (var infoname in _chat_support_variables) {
			var value_type = typeof(_chat_support_variables[infoname]);
			if ((value_type != 'object') && (value_type != 'function')) {
				querystring += "&info[" + escape(infoname) + "]=" + escape(_chat_support_variables[infoname]);
			}
		}
	} catch(e) { /*alert(e.description);*/ }

		
	var uid = _webtrack_getCookie("WEBTRACK_USER_ID");
	var supp_window = window.open("https://www.chatcomercial.com.br/livehelp/www/visitor/?userId=" + uid + "&COMPANY_ID=18053&SITE_ID=21324" + querystring, "_chat_support_window", "width=450,height=400,resizable=yes,status=no");
	try {supp_window.focus();}  catch(e) {}
}

function _webtrack_getCookie(WTKNameOfCookie){
	if (document.cookie.length > 0){
		var WTKbegin = document.cookie.indexOf(WTKNameOfCookie+"=");
	    if (WTKbegin != -1) {
			WTKbegin += WTKNameOfCookie.length+1; 
			WTKend = document.cookie.indexOf(";", WTKbegin);
			if (WTKend == -1) WTKend = document.cookie.length;
    	  	return unescape(document.cookie.substring(WTKbegin, WTKend));
		}
		return ""; 
  	}
	return ""; 
}
document.write("<a href='javascript:void(0)' target='_self' class=chatcomercial_link_class  onclick='start_chat_support_window21324()'><img src='https://www.chatcomercial.com.br/livehelp/lib/system/icon_status/on_icon_status4.gif' border=0></a>");