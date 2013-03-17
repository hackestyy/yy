/*
 * common.js - common javascript
 * Author: Zhaogang
 */

/*
 * example:
 * <input type="button" value="test" onClick="openWindow('http://168.2.4.95:8080', '', 500,300,'')">
 * <input type="button" value="fffdfd" onClick="openWindow('http://168.2.4.95:8080', 'Input', 600, 480,'toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=yes,resizable=yes,copyhistory=no')">
 * <input type="button" value="fffdfd" onClick="openNestWindow('http://168.2.4.95:8080')">
*/
function openWindow(mypage, myname, w, h, config) {
var winl = (screen.width - w) / 2;
var wint = (screen.height - h) / 2;
winprops = 'height='+h+',width='+w+',top='+wint+',left='+winl+','+config+''
win = window.open(mypage, myname, winprops)
if (parseInt(navigator.appVersion) >= 4) { win.window.focus(); }
return win;
}

function openNestWindow(mypage) {
var winl = (screen.width - 700) / 2;
var wint = (screen.height - 580) / 2;
winprops = 'height=580,width=700,top='+wint+',left='+winl+',toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=yes,resizable=yes,copyhistory=no'
win = window.open(mypage, '', winprops)
if (parseInt(navigator.appVersion) >= 4) { win.window.focus(); }
return win;
}
function openNestWindow_email(mypage) {
var winl = (screen.width - 700) / 2;
var wint = (screen.height - 580) / 2;
winprops = 'height=500,width=450,top='+wint+',left='+winl+',toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=yes,resizable=yes,copyhistory=no'
win = window.open(mypage, '', winprops)
if (parseInt(navigator.appVersion) >= 4) { win.window.focus(); }
return win;
}

function openMaxWindow(mypage) {
var winl = screen.width -20;
var wint = screen.height -90;
winprops = 'height='+wint+',width='+winl+',top=0,left=0,toolbar=no,location=no,directories=no,status=yes,menubar=no,scrollbars=yes,resizable=yes,copyhistory=no'
win = window.open(mypage, '', winprops)
if (parseInt(navigator.appVersion) >= 4) { win.window.focus(); }
return win;
}


//全屏
function fullScreen() {
	if(top.frameset1.rows == "0,*,0"){
			top.frameset1.rows = "98,*,25";
			top.frameset2.cols = "161,*";
		}else{
			top.frameset1.rows = "0,*,0";
			top.frameset2.cols = "0,*";
		}
}


//跑马灯的函数；

  var scrtxt="";
  var lentxt=scrtxt.length;
  var width=100;
  var pos=1-width;
  
  function scroll() {
  pos++;
  
  var scroller="";
  if (pos==lentxt) {
    pos=1-width;
  }
  if (pos<0) {
    for (var i=1; i<=Math.abs(pos); i++) {
      scroller=scroller+" ";}
    scroller=scroller+scrtxt.substring(0,width-i+1);
  }
  else {
    scroller=scroller+scrtxt.substring(pos,width+pos);
  }
  window.status = scroller;
  setTimeout("scroll()",150);
  }

  function scrolltxt(inputtxt) {
  scrtxt=inputtxt;
  lentxt=scrtxt.length;
  scroll();
  return true;
  }
