<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
<%String contextpath = request.getContextPath();%>
<%String academybaseinfoassoname = (String)session.getAttribute("academybaseinfoassoname");%>
<%Integer modifyabi_id = (Integer)session.getAttribute("abi_id");%>
<html:form method="post" action="/systemacademysearchprincipalupdate.do" onsubmit="return validateAcademybaseinfoprincipalForm(this);">
 <html:hidden property="abi_id" name="academybaseinfoprincipalForm"/>
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
                                <td align="left"><font face="华文新魏" size="3">修改<font color="red"><%=(String)request.getSession().getAttribute("acadname")%></font>信息</font><br>
                                    <hr color="#008000" size="3"></td>
                              </tr>
                              <tr>
                  <td align="center" valign="top">
                    <p>&nbsp;</p>
                   <tr>
                                <td height="30" align="left">
								<table width="100%" height="30" cellpadding="0" cellspacing="0" border="0">
                                  <tr>
                                    <td width="10"><img src="<%=contextpath%>/images/academybase/CONTENT_CL.jpg" width="10" height="30"></td>
                                    <td width="11%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#f4f4f4" style="BORDER-TOP:#c4c4c4 1px solid">
                                      <tr>
                                        <td background="<%=contextpath%>/images/academybase/CONTENT_10.jpg"><div align="center" class="style14 style17">
                                          <a href='systemacademysearchmodify.do?abi_id=<%=modifyabi_id%>'>
                                          基本信息
                                          </a>
                                          </div></td>
                                      </tr>
                                    </table></td>
                                    <td width="19"><img src="<%=contextpath%>/images/academybase/CONTENT_CL_WR.jpg" width="19" height="30"></td>
                                    <td width="11%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#e6f0fa" style="BORDER-TOP:#c4c4c4 1px solid">
                                      <tr>
                                        <td><div align="center" class="style14 style17">
                                          <a href='systemacademysearchprincipalmodify.do?abi_id=<%=modifyabi_id%>'>
                                           负责人信息






                                           </a>
                                        </div></td>
                                      </tr>
                                    </table></td>
                                    <td width="19"><img src="<%=contextpath%>/images/academybase/CONTENT_WL_CR.jpg" width="19" height="30"></td>
                                    <td width="11%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF" style="BORDER-TOP:#c4c4c4 1px solid">
                                      <tr>
                                        <td background="<%=contextpath%>/images/academybase/CONTENT_10.jpg"><div align="center" class="style14 style17">
                                        <a href='systemacademysearchcouncilmodify.do?abi_id=<%=modifyabi_id%>'>
                                          理事会






                                        </a>
                                        </div></td>
                                      </tr>
                                    </table></td>
                                    <td width="19"><img src="<%=contextpath%>/images/academybase/CONTENT_CL_CR.jpg" width="19" height="30"></td>
                                    <td width="17%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF" style="BORDER-TOP:#c4c4c4 1px solid">
                                      <tr>
                                        <td background="<%=contextpath%>/images/academybase/CONTENT_10.jpg"><div align="center" class="style14 style17">
                                        <a href='systemacademysearchorganizationinfolist.do?abi_id=<%=modifyabi_id%>'>
                                          学会组织机构设置
                                         </a>
                                        </div></td>
                                      </tr>
                                    </table></td>
                                    <td width="19"><img src="<%=contextpath%>/images/academybase/CONTENT_CL_CR.jpg" width="19" height="30"></td>
                                    <td width="11%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF" style="BORDER-TOP:#c4c4c4 1px solid">
                                      <tr>
                                        <td background="<%=contextpath%>/images/academybase/CONTENT_10.jpg"><div align="center" class="style14 style17">
                                          <a href='systemacademysearchspecialitycommitteelist.do?abi_id=<%=modifyabi_id%>'>
                                          专业委员会






                                          </a>
                                          </div></td>
                                      </tr>
                                    </table></td>
                                    <td width="19"><img src="<%=contextpath%>/images/academybase/CONTENT_CL_CR.jpg" width="19" height="30"></td>
                                    <td width="11%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF" style="BORDER-TOP:#c4c4c4 1px solid">
                                      <tr>
                                        <td background="<%=contextpath%>/images/academybase/CONTENT_10.jpg"><div align="center" class="style14 style17">
                                          <a href='systemacademysearchworkcommitteemodifylist.do?abi_id=<%=modifyabi_id%>'>
                                          工作委员会






                                          </a>
                                          </div></td>
                                      </tr>
                                    </table></td>
                                    <td width="19"><img src="<%=contextpath%>/images/academybase/CONTENT_CL_CR.jpg" width="19" height="30"></td>
                                    <td width="16%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF" style="BORDER-TOP:#c4c4c4 1px solid">
                                      <tr>
                                        <td background="<%=contextpath%>/images/academybase/CONTENT_10.jpg"><div align="center" class="style14 style17">
                                          <a href='systemacademysearchjournalbrandinfomodifylist.do?abi_id=<%=modifyabi_id%>'>
                                          会刊与品牌建设






                                          </a>
                                          </div></td>
                                      </tr>
                                    </table></td>
                                    <td width="19"><img src="<%=contextpath%>/images/academybase/CONTENT_CL_CR.jpg" width="19" height="30"></td>
                                    <td width="11%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF" style="BORDER-TOP:#c4c4c4 1px solid">
                                      <tr>
                                        <td background="<%=contextpath%>/images/academybase/CONTENT_10.jpg"><div align="center" class="style14 style17">
                                          <a href='systemacademysearchpartybuildmodify.do?abi_id=<%=modifyabi_id%>'>
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
                                          <td align="center" valign="top">
                                          <p>&nbsp;</p>
                                            <table width="90%" border="0" bordercolor="#000000">
                                          <b>(一) 法定代表人情况</b>
                                             <tr align="right">
                                                <td width="15%" height="25" align="right" bgcolor="#93C0E1"><font color="#FF0000">*</font>姓名:</td>
                                                  <td width="15%" align="left" bgcolor="#CDE2F1">
                                                   <html:text property="chargemanname"name="academybaseinfoprincipalForm" size="15"/>
                                                    </td>
                                                <td width="15%" height="25" align="right" bgcolor="#93C0E1"><font color="#FF0000">#</font>政治面貌:</td>
                                                   <td width="15%" height="25" align="left" bgcolor="#CDE2F1"><html:select property="chargemanparty" name="academybaseinfoprincipalForm">
					               <html:option value="中共党员">

					               </html:option>
					            <html:option value="民革">

					            </html:option>
                                                    <html:option value="民盟">

					            </html:option>
                                                      <html:option value="民建">

					               </html:option>
					            <html:option value=" 民进">

					            </html:option>
                                                    <html:option value="农工党">

					            </html:option>
                                                     <html:option value="致公党">

					            </html:option>
                                                    <html:option value="九三学社">

					            </html:option>
                                                     <html:option value="台盟">

					            </html:option>
                                                    <html:option value="无党派">

					            </html:option>
				                     </html:select></td>
                                                <td width="15%" height="25" align="right" bgcolor="#93C0E1"><font color="#FF0000">#</font>性别:</td>
                                                   <td width="13%" height="25" colspan="2" align="left" bgcolor="#CDE2F1">
                                                    <html:select property="chargemansex" name="academybaseinfoprincipalForm" >
					               <html:option value="男">
					               </html:option>
					            <html:option value="女">
					            </html:option>
				                     </html:select></td>
                                            </tr>
                                            <tr align="right">
                                               <td width="15%" height="25" align="right" bgcolor="#93C0E1"><font color="#FF0000">#</font>学历:</td>
                                                  <td height="25" align="left" bgcolor="#CDE2F1">
                                                  <html:select property="chargemanscholar" name="academybaseinfoprincipalForm" >
					               <html:option value="研究生">
					               </html:option>
					            <html:option value="本科">
					            </html:option>
                                                    <html:option value="大专">
					            </html:option>
                                                     <html:option value="其他">
					            </html:option>
				                     </html:select>
                                                  </td>
                                               <td height="25" align="right" bgcolor="#93C0E1"><font color="#FF0000">#</font>离退休否:</td>
                                                  <td align="left" bgcolor="#CDE2F1">
                                                  <html:select property="chargemanisretire" name="academybaseinfoprincipalForm" >
					               <html:option value="已经退休">
					               </html:option>
					            <html:option value="未退休">
					            </html:option>
				                     </html:select>
                                                  </td>
                                               <td align="right" bgcolor="#93C0E1">身份证号:</td>
                                                  <td align="center" bgcolor="#CDE2F1"><html:text property="chargemanidentity"name="academybaseinfoprincipalForm" size="15"/></td>
                                            </tr>
                                          <tr align="right">
                                              <td width="15%" height="26" align="right" bgcolor="#93C0E1"><font color="#FF0000">#</font>专职/兼职:</td>
                                                 <td height="26" align="left" bgcolor="#CDE2F1">
                                                 <html:select property="chargemanisfulltime" name="academybaseinfoprincipalForm" >
					               <html:option value="专职">
					               </html:option>
					            <html:option value="兼职">
					            </html:option>
				                     </html:select></td>
                                             <td height="26" align="right" bgcolor="#93C0E1">固定电话:</td>
                                                 <td align="left" bgcolor="#CDE2F1"><html:text property="chargemantelephone"name="academybaseinfoprincipalForm" size="15"/></td>
                                             <td align="right" bgcolor="#93C0E1">手机:</td>
                                                <td align="center" bgcolor="#CDE2F1"><html:text property="chargemanmobile"name="academybaseinfoprincipalForm" size="15"/></td>
                                          </tr>
                                         <tr align="right">
                                            <td height="25" align="right" bgcolor="#93C0E1">工作单位:</td>
                                              <td height="25" colspan="6" align="left" bgcolor="#CDE2F1"><html:text property="chargemaninstitute"name="academybaseinfoprincipalForm" size="67"/></td>
                                       </tr>
                                       <tr align="right">
                                        <td height="25" align="right" bgcolor="#93C0E1">其他社会职务:</td>
                                          <td height="25" colspan="6" align="left" bgcolor="#CDE2F1"><html:text property="chargemansocialduty"name="academybaseinfoprincipalForm" size="67" /></td>
                                       </tr>
                                       </table>
                                      <table width="90%" border="0" bordercolor="#000000">
                                        <b>(二) 会长（理事长、主席）情况</b>
                                            <tr align="right">
                                                <td width="15%" height="25" align="right" bgcolor="#93C0E1"><font color="#FF0000">*</font>姓名:</td>
                                                  <td width="15%" align="left" bgcolor="#CDE2F1">
                                                   <html:text property="chairmanname"name="academybaseinfoprincipalForm" size="15"/>
                                                    </td>
                                                <td width="15%" height="25" align="right" bgcolor="#93C0E1"><font color="#FF0000">#</font>政治面貌:</td>
                                                   <td width="15%" height="25" align="left" bgcolor="#CDE2F1"><html:select property="chairmanparty" name="academybaseinfoprincipalForm">
					               <html:option value="中共党员">

					               </html:option>
					            <html:option value="民革">

					            </html:option>
                                                    <html:option value="民盟">

					            </html:option>
                                                      <html:option value="民建">

					               </html:option>
					            <html:option value=" 民进">

					            </html:option>
                                                    <html:option value="农工党">

					            </html:option>
                                                     <html:option value="致公党">

					            </html:option>
                                                    <html:option value="九三学社">

					            </html:option>
                                                     <html:option value="台盟">

					            </html:option>
                                                    <html:option value="无党派">

					            </html:option>
				                     </html:select></td>
                                                <td width="15%" height="25" align="right" bgcolor="#93C0E1"><font color="#FF0000">#</font>性别:</td>
                                                   <td width="13%" height="25" colspan="2" align="left" bgcolor="#CDE2F1">
                                                    <html:select property="chairmansex" name="academybaseinfoprincipalForm" >
					               <html:option value="男">
					               </html:option>
					            <html:option value="女">
					            </html:option>
				                     </html:select></td>
                                            </tr>
                                            <tr align="right">
                                               <td width="15%" height="25" align="right" bgcolor="#93C0E1"><font color="#FF0000">#</font>学历:</td>
                                                  <td height="25" align="left" bgcolor="#CDE2F1">
                                                  <html:select property="chairmanscholar" name="academybaseinfoprincipalForm" >
					               <html:option value="研究生">
					               </html:option>
					            <html:option value="本科">
					            </html:option>
                                                    <html:option value="大专">
					            </html:option>
                                                     <html:option value="其他">
					            </html:option>
				                     </html:select>
                                                  </td>
                                               <td height="25" align="right" bgcolor="#93C0E1"><font color="#FF0000">#</font>离退休否:</td>
                                                  <td align="left" bgcolor="#CDE2F1">
                                                  <html:select property="chairmanisretire" name="academybaseinfoprincipalForm" >
					               <html:option value="已经退休">
					               </html:option>
					            <html:option value="未退休">
					            </html:option>
				                     </html:select>
                                                  </td>
                                               <td align="right" bgcolor="#93C0E1">身份证号:</td>
                                                  <td align="center" bgcolor="#CDE2F1"><html:text property="chairmanidentity"name="academybaseinfoprincipalForm" size="15"/></td>
                                            </tr>
                                          <tr align="right">
                                              <td width="15%" height="26" align="right" bgcolor="#93C0E1"><font color="#FF0000">#</font>专职/兼职:</td>
                                                 <td height="26" align="left" bgcolor="#CDE2F1"><html:select property="chairmanisfulltime" name="academybaseinfoprincipalForm" >
					               <html:option value="专职">
					               </html:option>
					            <html:option value="兼职">
					            </html:option>
				                     </html:select></td>
                                             <td height="26" align="right" bgcolor="#93C0E1">固定电话:</td>
                                                 <td align="left" bgcolor="#CDE2F1"><html:text property="chairmantelephone"name="academybaseinfoprincipalForm" size="15"/></td>
                                             <td align="right" bgcolor="#93C0E1">手机:</td>
                                                <td align="center" bgcolor="#CDE2F1"><html:text property="chairmanmobile"name="academybaseinfoprincipalForm" size="15"/></td>
                                          </tr>
                                         <tr align="right">
                                            <td height="25" align="right" bgcolor="#93C0E1">工作单位:</td>
                                              <td height="25" colspan="6" align="left" bgcolor="#CDE2F1"><html:text property="chairmaninstitute"name="academybaseinfoprincipalForm" size="67"/></td>
                                       </tr>
                                       <tr align="right">
                                        <td height="25" align="right" bgcolor="#93C0E1">其他社会职务:</td>
                                          <td height="25" colspan="6" align="left" bgcolor="#CDE2F1"><html:text property="chairmansocialduty"name="academybaseinfoprincipalForm" size="67" /></td>
                                       </tr>
                                        </table>
                                        <table width="90%" border="0"  bordercolor="#000000">
                                        <b>(三) 秘书长情况</b>
                                             <tr align="right">
                                                <td width="15%" height="25" align="right" bgcolor="#93C0E1"><font color="#FF0000">*</font>姓名:</td>
                                                  <td width="15%" align="left" bgcolor="#CDE2F1">
                                                   <html:text property="secretaryname"name="academybaseinfoprincipalForm" size="15"/>
                                                    </td>
                                                <td width="15%" height="25" align="right" bgcolor="#93C0E1"><font color="#FF0000">#</font>政治面貌:</td>
                                                   <td width="15%" height="25" align="left" bgcolor="#CDE2F1"><html:select property="secretaryparty" name="academybaseinfoprincipalForm">
					               <html:option value="中共党员">

					               </html:option>
					            <html:option value="民革">

					            </html:option>
                                                    <html:option value="民盟">

					            </html:option>
                                                      <html:option value="民建">

					               </html:option>
					            <html:option value=" 民进">

					            </html:option>
                                                    <html:option value="农工党">

					            </html:option>
                                                     <html:option value="致公党">

					            </html:option>
                                                    <html:option value="九三学社">

					            </html:option>
                                                     <html:option value="台盟">

					            </html:option>
                                                    <html:option value="无党派">

					            </html:option>
				                     </html:select></td>
                                                <td width="15%" height="25" align="right" bgcolor="#93C0E1"><font color="#FF0000">#</font>性别:</td>
                                                   <td width="13%" height="25" colspan="2" align="left" bgcolor="#CDE2F1">
                                                    <html:select property="secretarysex" name="academybaseinfoprincipalForm" >
					               <html:option value="男">
					               </html:option>
					            <html:option value="女">
					            </html:option>
				                     </html:select></td>
                                            </tr>
                                            <tr align="right">
                                               <td width="15%" height="25" align="right" bgcolor="#93C0E1"><font color="#FF0000">#</font>学历:</td>
                                                  <td height="25" align="left" bgcolor="#CDE2F1">
                                                  <html:select property="secretaryscholar" name="academybaseinfoprincipalForm" >
					               <html:option value="研究生">
					               </html:option>
					            <html:option value="本科">
					            </html:option>
                                                    <html:option value="大专">
					            </html:option>
                                                     <html:option value="其他">
					            </html:option>
				                     </html:select>
                                                  </td>
                                               <td height="25" align="right" bgcolor="#93C0E1"><font color="#FF0000">#</font>离退休否:</td>
                                                  <td align="left" bgcolor="#CDE2F1">
                                                  <html:select property="secretaryisretire" name="academybaseinfoprincipalForm" >
					               <html:option value="已经退休">
					               </html:option>
					            <html:option value="未退休">
					            </html:option>
				                     </html:select>
                                                  </td>
                                               <td align="right" bgcolor="#93C0E1">身份证号:</td>
                                                  <td align="center" bgcolor="#CDE2F1"><html:text property="secretaryidentity"name="academybaseinfoprincipalForm" size="15"/></td>
                                            </tr>
                                          <tr align="right">
                                              <td width="15%" height="26" align="right" bgcolor="#93C0E1"><font color="#FF0000">#</font>专职/兼职:</td>
                                                 <td height="26" align="left" bgcolor="#CDE2F1">
                                                 <html:select property="secretaryisfulltime" name="academybaseinfoprincipalForm" >
					               <html:option value="专职">
					               </html:option>
					            <html:option value="兼职">
					            </html:option>
				                     </html:select></td>
                                             <td height="26" align="right" bgcolor="#93C0E1">固定电话:</td>
                                                 <td align="left" bgcolor="#CDE2F1"><html:text property="secretarytelephone"name="academybaseinfoprincipalForm" size="15"/></td>
                                             <td align="right" bgcolor="#93C0E1">手机:</td>
                                                <td align="center" bgcolor="#CDE2F1"><html:text property="secretarymobile"name="academybaseinfoprincipalForm" size="15"/></td>
                                          </tr>
                                         <tr align="right">
                                            <td height="25" align="right" bgcolor="#93C0E1">工作单位:</td>
                                              <td height="25" colspan="6" align="left" bgcolor="#CDE2F1"><html:text property="secretaryinstitute"name="academybaseinfoprincipalForm" size="67"/></td>
                                       </tr>
                                       <tr align="right">
                                        <td height="25" align="right" bgcolor="#93C0E1">其他社会职务:</td>
                                          <td height="25" colspan="6" align="left" bgcolor="#CDE2F1"><html:text property="secretarysocialduty"name="academybaseinfoprincipalForm" size="67" /></td>
                                       </tr>
                                            </table>
                                            <table width="100%" align="center">
                <tr>
                  <td height="60" align="right">
                    <input name="submit" type="submit" class="button"
value="更新">
                    &nbsp;&nbsp;
                    <input name="button" type="button" class="button"
onclick="location.href='systemacademysearchlist.do'" value="返回">

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  </td>
                </tr>
              </table>

                                        </tr>
                                      </table></td>
                                  </tr>

              </table></td>
            </tr>
          </table>
        </TR>
    </TABLE>
  </body>
</html>
  </html:form>
<html:javascript formName="academybaseinfoprincipalForm"/>
