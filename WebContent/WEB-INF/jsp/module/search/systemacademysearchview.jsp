<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
<%String contextpath = request.getContextPath();%>
<%String academybaseinfoassoname = (String)session.getAttribute("academybaseinfoassoname");%>
<%Integer viewabi_id = (Integer)session.getAttribute("abi_id");%>
  <html:hidden property="abi_id" name="academybaseinfoForm"/>
<HTML>
<HEAD>
<TITLE>宁波市科学技术协会会员会籍动态管理系统</TITLE>
<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=gb2312">
<script type="text/javascript" language="JavaScript1.2" src="<%=contextpath%>/images/smenu/stmenu.js"></script>
<script Language="JavaScript" type="">

function submitForm(act)
{
    document.queryForm.searchaction.value=act;
    document.queryForm.submit();
}
function dosearch(){
  if(event.keyCode==13){
  submitForm('search');
  }
}
function dogoto(){
  if(event.keyCode==13){
    submitForm('goto');
  }
}
</script>
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

						<%@include file = "/WEB-INF/jsp/navigation/navigation_admin_sys.txt"%>

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
                  <td width="185" height="24" align="left" valign="top"><html:link page="/acadgrouplist.do">
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
             		<div align="left"> <html:link page="/academybaseinfolist.do" paramId="shai_id" paramName="op" paramProperty="shai_id" onclick="return warn()" >
                                &nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/add.jpg" width="9" height="9" alt="" align="middle" border="0">
                                 </html:link>
                                 <html:link page="/academybaseinfolist.do" paramId="shai_id" paramName="op" paramProperty="shai_id" onclick="return warn()" styleClass="style14">
                                 <b> <font face="cursive" size="2"><bean:write name="op" property="assoname" scope="page"/></font></b>
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
                                   <p>&nbsp;</p>
                              </tr>
                              <tr>
                                <font face="华文新魏" size="3"><font color="red"><%=(String)request.getSession().getAttribute("acadname")%>详细信息</font></font><br>
                                    <hr color="#008000" size="3">
                              </tr>
                              <tr>
                    <td align="center" valign="top">

                       <p>&nbsp;</p>
                    <tr>
                                <td height="30" align="left">
								<table width="100%" height="30" cellpadding="0" cellspacing="0" border="0">
                                  <tr>
                                    <td width="10"><img src="<%=contextpath%>/images/academybase/CONTENT_WL.jpg" width="10" height="30"></td>
                                    <td width="11%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#e6f0fa" style="BORDER-TOP:#c4c4c4 1px solid">
                                      <tr>
                                        <td><div align="center" class="style14 style17">
                                            <a href='systemacademysearchview.do?abi_id=<%=viewabi_id%>'>
                                          基本信息
                                          </a>
                                        </div></td>
                                      </tr>
                                    </table></td>
                                    <td width="19"><img src="<%=contextpath%>/images/academybase/CONTENT_WL_CR.jpg" width="19" height="30"></td>
                                    <td width="11%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF" style="BORDER-TOP:#c4c4c4 1px solid">
                                      <tr>
                                        <td background="<%=contextpath%>/images/academybase/CONTENT_10.jpg"><div align="center" class="style14 style17">
                                          <a href='systemacademysearchprincipalview.do?abi_id=<%=viewabi_id%>'>
                                          负责人信息





                                          </a>
                                         </div></td>
                                      </tr>
                                    </table></td>
                                    <td width="19"><img src="<%=contextpath%>/images/academybase/CONTENT_CL_CR.jpg" width="19" height="30"></td>
                                    <td width="11%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF" style="BORDER-TOP:#c4c4c4 1px solid">
                                      <tr>
                                        <td background="<%=contextpath%>/images/academybase/CONTENT_10.jpg"><div align="center" class="style14 style17">
                                        <a href='systemacademysearchcouncilview.do?abi_id=<%=viewabi_id%>'>
                                          理事会





                                        </a>
                                        </div></td>
                                      </tr>
                                    </table></td>
                                    <td width="19"><img src="<%=contextpath%>/images/academybase/CONTENT_CL_CR.jpg" width="19" height="30"></td>
                                    <td width="17%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF" style="BORDER-TOP:#c4c4c4 1px solid">
                                      <tr>
                                        <td background="<%=contextpath%>/images/academybase/CONTENT_10.jpg"><div align="center" class="style14 style17">
                                          <a href='systemacademysearchorganizationinfoview.do?abi_id=<%=viewabi_id%>'>
                                          学会组织机构设置
                                          </a>
                                          </div></td>
                                      </tr>
                                    </table></td>
                                    <td width="19"><img src="<%=contextpath%>/images/academybase/CONTENT_CL_CR.jpg" width="19" height="30"></td>
                                    <td width="11%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF" style="BORDER-TOP:#c4c4c4 1px solid">
                                      <tr>
                                        <td background="<%=contextpath%>/images/academybase/CONTENT_10.jpg"><div align="center" class="style14 style17">
                                          <a href='systemacademysearchspecialitycommitteeview.do?abi_id=<%=viewabi_id%>'>
                                          专业委员会





                                          </a>
                                          </div></td>
                                      </tr>
                                    </table></td>
                                    <td width="19"><img src="<%=contextpath%>/images/academybase/CONTENT_CL_CR.jpg" width="19" height="30"></td>
                                    <td width="11%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF" style="BORDER-TOP:#c4c4c4 1px solid">
                                      <tr>
                                        <td background="<%=contextpath%>/images/academybase/CONTENT_10.jpg"><div align="center" class="style14 style17">
                                          <a href='systemacademysearchworkcommitteeviewlist.do?abi_id=<%=viewabi_id%>'>
                                          工作委员会





                                          </a>
                                          </div></td>
                                      </tr>
                                    </table></td>
                                    <td width="19"><img src="<%=contextpath%>/images/academybase/CONTENT_CL_CR.jpg" width="19" height="30"></td>
                                    <td width="16%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF" style="BORDER-TOP:#c4c4c4 1px solid">
                                      <tr>
                                        <td background="<%=contextpath%>/images/academybase/CONTENT_10.jpg"><div align="center" class="style14 style17">
                                          <a href='systemacademysearchjournalbrandinfoviewlist.do?abi_id=<%=viewabi_id%>'>
                                          会刊与品牌建设





                                          </a>
                                        </div></td>
                                      </tr>
                                    </table></td>
                                    <td width="19"><img src="<%=contextpath%>/images/academybase/CONTENT_CL_CR.jpg" width="19" height="30"></td>
                                    <td width="11%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF" style="BORDER-TOP:#c4c4c4 1px solid">
                                      <tr>
                                        <td background="<%=contextpath%>/images/academybase/CONTENT_10.jpg"><div align="center" class="style14 style17">
					<a href='systemacademysearchpartybuildview.do?abi_id=<%=viewabi_id%>'>
					党建信息
					</a>
					</div></td>
                                      </tr>
                                    </table></td>
                                    <td width="10"><img src="<%=contextpath%>/images/academybase/CONTENT_CR.jpg" width="10" height="30"></td>
                                  </tr>
                                </table></td>
                              </tr>
                              <tr>
                                <td valign="top">
                                  <table width="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#e6f0fa">
                                  <tr>
                                    <td height="100"> <table width="100%" height="100" cellpadding="0" cellspacing="0" border="0" style="BORDER-LEFT:#c4c4c4 1px solid; BORDER-RIGHT:#c4c4c4 1px solid; BORDER-BOTTOM:#c4c4c4 1px solid">
                                        <tr>
                                          <td align="center" valign="top"> <p>&nbsp;</p>
                                            <table width="90%" border="0" bordercolor="#000000">
                                              <tr align="right">
                                                <td height="25" colspan="2" align="right" bgcolor="#93C0E1">学（协）会名称:</td>
                                                <td height="25" colspan="2" align="center" bgcolor="#CDE2F1"><bean:write property="acadname"name="academybaseinfoForm" /></td>
                                                <td height="25" colspan="2" align="right" bgcolor="#93C0E1">学会代码:</td>
                                                <td height="25" colspan="2" align="center" bgcolor="#CDE2F1"><bean:write property="acadno"name="academybaseinfoForm" /></td>
                                              </tr>
                                              <tr align="right">
                                                <td height="25" colspan="2" align="right" bgcolor="#93C0E1">登记日期:</td>
                                                <td height="25" colspan="2" align="center" bgcolor="#CDE2F1"><bean:write property="tempregisterdate"name="academybaseinfoForm" /></td>
                                                <td height="25" colspan="2" align="right" bgcolor="#93C0E1">注册资金:</td>
                                                <td height="25" colspan="2" align="center" bgcolor="#CDE2F1"><bean:write property="registerfund"name="academybaseinfoForm" /></td>
                                              </tr>
                                              <tr align="right">
                                                <td width="15%" rowspan="2" align="right" bgcolor="#93C0E1">办公地址:</td>
                                                <td width="5%" align="right" bgcolor="#93C0E1">1.</td>
                                                <td height="25" colspan="2" align="center" bgcolor="#CDE2F1"><bean:write property="address1"name="academybaseinfoForm" /></td>
                                                <td width="15%" rowspan="2" align="right" bgcolor="#93C0E1">邮政编码:</td>
                                                <td width="5%" align="right" bgcolor="#93C0E1">1.</td>
                                                <td height="25" colspan="2" align="center" bgcolor="#CDE2F1"><bean:write property="postcode1"name="academybaseinfoForm" /></td>
                                              </tr>
                                              <tr>
                                                <td width="5%" align="right" bgcolor="#93C0E1">2.</td>
                                                <td height="25" colspan="2" align="center" bgcolor="#CDE2F1"><bean:write property="address2"name="academybaseinfoForm" /></td>
                                                <td width="5%" align="right" bgcolor="#93C0E1">2.</td>
                                                <td height="25" colspan="2" align="center" bgcolor="#CDE2F1"><bean:write property="postcode2"name="academybaseinfoForm" /></td>
                                              </tr>
                                              <tr align="right">
                                                <td height="25" colspan="2" align="right" bgcolor="#93C0E1">联系人姓名:</td>
                                                <td width="15%" height="25" align="center" bgcolor="#CDE2F1"><bean:write property="contactperson"name="academybaseinfoForm" /></td>
                                                <td width="15%" height="25" align="right" bgcolor="#93C0E1">联系电话:</td>
                                                <td height="25" colspan="2" align="center" bgcolor="#CDE2F1"><bean:write property="contactphone"name="academybaseinfoForm" /></td>
                                                <td width="15%" height="25" align="right" bgcolor="#93C0E1">传真:</td>
                                                <td width="15%" height="25" align="center" bgcolor="#CDE2F1"><bean:write property="contactfax"name="academybaseinfoForm"/></td>
                                              </tr>
                                              <tr align="right">
                                                <td height="25" colspan="2" align="right" bgcolor="#93C0E1">学会星级评定:</td>
                                                <td height="25" colspan="2" align="center" bgcolor="#CDE2F1"><bean:write property="starlevel"name="academybaseinfoForm"/></td>
                                                <td height="25" colspan="2" align="right" bgcolor="#93C0E1">主管单位:</td>
                                                <td height="25" colspan="2" align="center" bgcolor="#CDE2F1"><bean:write property="is311"name="academybaseinfoForm"/></td>
                                              </tr>
                                              <tr align="right">
                                                <td height="25" colspan="2" align="right" bgcolor="#93C0E1">业务范围:</td>
                                                <td height="25" colspan="6" align="center" bgcolor="#CDE2F1"><bean:write property="operationrange"name="academybaseinfoForm"/></td>
                                              </tr>
                                              <tr align="right">
                                                <td height="25" colspan="2" align="right" bgcolor="#93C0E1">工作人员总数:</td>
                                                <td width="15%" height="25" align="center" bgcolor="#CDE2F1"><bean:write property="staffcount"name="academybaseinfoForm"/></td>
                                                <td width="15%" height="25" align="left" bgcolor="#93C0E1">人</td>
                                                <td height="25" colspan="2" align="right" bgcolor="#93C0E1">其中兼职人数:</td>
                                                <td width="15%" height="25" align="center" bgcolor="#CDE2F1"><bean:write property="parttimecount"name="academybaseinfoForm"/></td>
                                                <td width="15%" height="25" align="left" bgcolor="#93C0E1">人</td>
                                              </tr>

                                            </table>
                                            <table width="100%" align="center">
                <tr>
                  <td height="60" align="right">

                    &nbsp;&nbsp;
                    <input name="button" type="button" class="button"
onclick="location.href='systemacademysearchlist.do'" value="返回">

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  </td>
                </tr>
            </table>

                           </tr>
                      </TABLE></td>
                    </tr>
                  </table>

              </tr>
            </TABLE>

</BODY>
</HTML>

