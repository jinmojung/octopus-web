function doIframe(){
	o = document.getElementsByTagName('iframe');
	for(i=0;i<o.length;i++){
		alert('111')
		if (/\bautoHeight\b/.test(o[i].className)){
			alert('sadf')
			setHeight(o[i]);
			addEvent(o[i],'load', doIframe);
		}
	}
}

function setHeight(e){
	if(e.contentDocument){
		e.height = e.contentDocument.body.offsetHeight + 35;
		alert(e.height)
	} else {
		e.height = e.contentWindow.document.body.scrollHeight;
		alert(e.height)
	}
}

function addEvent(obj, evType, fn){
	if(obj.addEventListener)
	{
	obj.addEventListener(evType, fn,false);
	return true;
	} else if (obj.attachEvent){
	var r = obj.attachEvent("on"+evType, fn);
	return r;
	} else {
	return false;
	}
}

if (document.getElementById && document.createTextNode){
 addEvent(window,'load', doIframe);	
}