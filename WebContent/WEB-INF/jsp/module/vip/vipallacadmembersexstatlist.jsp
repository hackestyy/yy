<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
<%String contextpath = request.getContextPath();%>
<HTML>
<HEAD>
<TITLE>宁波市科学技术协会会员会籍动态管理系统</TITLE>
<script type="text/javascript" language="JavaScript1.2" src="<%=contextpath%>/images/smenu/stmenu.js"></script>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
-->
</style>
<style type="text/css">
<!--
a:link {
	color: #000000;
	text-decoration: none;
}
a:visited {
	color: #000000;
	text-decoration: none;
}
a:hover {
	color: #000000;
	text-decoration: none;
}
a:active {
	color: #000000;
	text-decoration: none;
}
-->
</style>
<script language="javascript" type="">
  window.moveTo(0,0);
  window.resizeTo(screen.availWidth,screen.availHeight);
  function warndelete(value)
{
  return confirm('确实要删除吗？');
}
</script>
<base target="_self">
<link href="css/style_cssrc.css" rel="stylesheet" type="text/css">
</HEAD>
<BODY>
<div align="center">
  <div align="left">
        <TR>
          <TD width="0" height="100%" align="left" valign="top">
          <TD width="185" align="left" valign="top" bgcolor="#FFFFFF">
		  <table width="100%" height="100%" border="0" cellSpacing=0 cellPadding=0 align="left">
            <tr>
              <td height="113" colspan="2" align="left" valign="top"><table width="100%" height="113" border="0" cellPadding=0 cellSpacing=0 background="images/top_03.gif">
                <tr>
                  <td width="218" valign="top"><img src="images/top_01.gif" width="218" height="83"></td>
                  <td>&nbsp;</td>
                  <td width="465" valign="top"><table width="465" cellPadding=0 cellSpacing=0 border="0">
                      <tr>
                        <td height="83"><img src="images/top_05.gif" width="465" height="83"></td>
                      </tr>
                      <tr>
                        <td height="30" align="right" class="">

						<%@include file = "/WEB-INF/jsp/navigation/navigation_vip_sys.txt"%>

                        </td>
                      </tr>
                  </table></td>
                  <td width="21"><img src="images/top_06.gif" width="21" height="113"></td>
                </tr>
              </table></td>
            </tr>
            <tr>
              <td width="185" align="left" valign="middle" bgcolor="#F2F5FA"><table width="185" height="100%" border="0" cellSpacing=0 cellPadding=0 align="left">
                <tr>
                  <td width="185" height="24" align="left" valign="top"><html:link page="/vipacadgrouplist.do">
                  <img src="<%=contextpath%>/images/left_01.gif" width="185" height="24" border="0" alt="科协系统首页"></html:link></td>
                </tr>
                <tr>
                  <td align="left" valign="top" bgcolor="#e6f0fa">
                    <table width="100%" height="250" border="0" cellPadding=0 cellSpacing=0 style="border-TOP:1px solid #C4C4C4">
                      <tr>
                        <td align="center" valign="top" bgcolor="#e6f0fa"><div align="left">
                            <table width="100%" height="200" border="0" cellPadding=0 cellSpacing=0 align="center">
                            <logic:iterate id="op" name="ACADGROUPLIST" type="com.cssrc.bean.admin.Acadgroup">
                              <tr>
                             <BR>
             <div align="left"> <html:link page="/vipacademybaseinfolist.do" paramId="shai_id" paramName="op" paramProperty="shai_id" onclick="return warn()" >
                                &nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/add.jpg" width="9" height="9" alt="" align="middle" border="0">
                                 </html:link>
                                 <html:link page="/vipacademybaseinfolist.do" paramId="shai_id" paramName="op" paramProperty="shai_id" onclick="return warn()" styleClass="style14">
                                 <b><font face="cursive" size="2"> <bean:write name="op" property="assoname" scope="page"/></font></b>
                                  </html:link>
                                  </div>
                              </tr>
                              </logic:iterate>
                            </table>
                            <p>&nbsp;</p>
                        </div></td>
                      </tr>
                  </table></td>
                </tr>
              </table></td>
              <td width="100%" align="left" valign="middle" bgcolor="#FFFFFF"><table width="100%" height="100%" cellSpacing="0" cellPadding="0" border="0">
                <tr valign="top">
                  <td align="center">
                    <table width="100%" height="100%" cellSpacing="0" cellPadding="0" border="0">
                      <tr>
                        <td align="center" valign="top"> <br>
                            <table width="90%"  border="0" cellpadding="0" cellspacing="0">
                              <tr>
                                <td height="30" align="right" valign="top"></td>
                              </tr>
                              <tr>
                                <td align="left"> <font face="华文新魏" size="3">&nbsp;宁波市科协学会会员<font color="red">性别统计表</font></font> <br>
                                    <hr color="#008000" size="3"></td>
                              </tr>
                              <tr>
                                <td valign="top">
                                  <table width="100%" border="0" cellpadding="0" cellspacing="0">
                                    <tr bgcolor="white">
                                      <td height="20" colspan="5">
                                      <table width="100%" border="0">
                    <tr align="center" bgcolor="#b2b2b2" class="tabletop">
                       <td width="8%" rowspan="2">
                        <div align="center" class="style14">序号</div>
                      </td>

                      <td width="18%" rowspan="2">
                        <div align="center" class="style14">学会群名称</div>
                      </td>
                      <td width="18%" rowspan="2">
                        <div align="center" class="style14">
                           总人数


                           (名)</div>
                      </td>
                      <td colspan="2">
                        <div align="center" class="style14"><b>男性</b></div>
                      </td>
                      <td colspan="2">
                        <div align="center" class="style14"><b>女性</b></div>
                      </td>


                    </tr>
                    <tr align="center" class="tabletop" >
                      <td width="10%"> 人数</td>
                      <td width="10%">百分比(%)</td>
                      <td width="10%">人数 </td>
                      <td width="10%"> 百分比(%)</td>
                    </tr>
                    <logic:iterate id="op" name="LIST" type="com.cssrc.bean.view.TempBean">
                      <tr bgcolor="white" class="tabletext" onMouseOut="this.className='tabletext'" onMouseOver="this.className='tabletextover'">
                        <td>
                          <div align="center">
                            <bean:write name="op" property="serialnumber" scope="page"/>
                          </div>
                        </td>
                        <td>
                          <div align="center">
                            <bean:write name="op" property="assoname" scope="page"/>
                          </div>
                        </td>
                        <td>
                          <div align="center">
                            <bean:write name="op" property="countshai_id" scope="page"/>
                          </div>
                        </td>
                        <td>
                          <div align="center">
                            <bean:write name="op" property="male" scope="page"/>
                          </div>
                        </td>
                        <td>
                          <div align="center">
                            <bean:write name="op" property="maleratio" format="0.00" scope="page"/>%
                          </div>
                        </td>
                        <td><div align="center">
                            <bean:write name="op" property="female" scope="page"/>
                          </div></td>
                        <td><div align="center">
                            <bean:write name="op" property="femaleratio" format="0.00" scope="page"/>%
                          </div>                  
                        </td>
                        
                      </tr>
                    </logic:iterate>
                     <tr class=BlackText-9p>
                      <td>&nbsp;                      </td>
                      <td>&nbsp;                      </td>
                      <td>&nbsp;                      </td>
                      <td colspan="2">&nbsp;                      </td>
                      <td align="right" colspan="3">&nbsp;

                      </td>
                    </tr>
                    <tr class=BlackText-9p>
                      <td colspan="8" align="right">                                                                                        
                        <input type="button" class="button" name="strutsButton" value="下载报表" onClick="location.href='reportdownload.do?writeExcelClass=SEX'">
&nbsp;&nbsp;&nbsp;&nbsp;
                         <input type="button" class="button" value="返回" onclick="location.href='vipacadgrouplist.do'">                      </td>
                      </tr>
                  </table>
                </td>
              </tr>
            </TABLE>
<tr>
         <td><img src="<%=contextpath%>/CreateImage?infoClass=syssex" align="middle" >
         </td>
         </tr>
        </td>
      </tr>
    </table></td>
                      </tr>

              </table></td>
            </tr>
          </table>        </TR>
    </TABLE>
  </div>
</div>
</BODY>
</HTML>
