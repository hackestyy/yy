<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
<%String contextpath = request.getContextPath();%>
<script language=JavaScript src="<%=contextpath%>/js/Calendar.js" type=""></script>
<script Language="JavaScript" type="">
</script>
<%String academybaseinfoassoname = (String)session.getAttribute("academybaseinfoassoname");%>
<%Integer viewabi_id = (Integer)session.getAttribute("abi_id");%>
<%String acadname = (String)session.getAttribute("acadname");%>
<%Integer modifysmbi_id = (Integer)session.getAttribute("smbi_id");%>
<%Integer modifyasmr_id = (Integer)session.getAttribute("asmr_id");%>
<html:form method="post" action="/acadesearchsmemberupdate.do" enctype="multipart/form-data" onsubmit="return validateSmemberbaseinfoForm(this);">
 <html:hidden property="smbi_id" name="smemberbaseinfoForm"/>
 <html:hidden property="asmr_id" name="smemberbaseinfoForm"/>
<HTML>
<HEAD>
<TITLE>宁波市科学技术协会会员会籍动态管理系统</TITLE>
<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=gb2312">
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
<script language="javascript">
  window.moveTo(0,0);
  window.resizeTo(screen.availWidth,screen.availHeight);
</script>
<base target="_self">
<link href="css/style_cssrc.css" rel="stylesheet" type="text/css">
<style type="text/css">
<!--
.style1 {
	color: #0000FF;
	font-weight: bold;
}
-->
</style>
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
                        <td height="30" align="right" class=""><strong><a href="<%=contextpath%>/logout.do" target="_top">退出系统</a></strong></td>
                      </tr>
                  </table></td>
                  <td width="21"><img src="images/top_06.gif" width="21" height="113"></td>
                </tr>
              </table></td>
            </tr>
            <tr>
              <td width="185" align="left" valign="middle" bgcolor="#F2F5FA"><table width="185" height="100%" border="0" cellSpacing=0 cellPadding=0 align="left">
                <tr>
                  <td width="185" height="24" align="left" valign="top"><img src="images/left_01.gif" width="185" height="24"></td>
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
             		<div align="left"> <logic:equal name="op" property="assoname" value="<%=academybaseinfoassoname%>" >
                                &nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/sub.jpg" width="9" height="9" alt="" align="middle">
                                 <html:link page="/academybaseinfolist.do" paramId="shai_id" paramName="op" paramProperty="shai_id" onclick="return warn()" styleClass="style14">
                                <font color="blue"> <b> <font face="cursive" size="2"><bean:write name="op" property="assoname" scope="page"/></font></b></font>
                                  </html:link>
                                </logic:equal>
                                 <logic:notEqual name="op" property="assoname" value="<%=academybaseinfoassoname%>" >
                                 &nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/add.jpg" width="9" height="9" alt="" align="middle">
                                 <html:link page="/academybaseinfolist.do" paramId="shai_id" paramName="op" paramProperty="shai_id" onclick="return warn()" styleClass="style14">
                                   <b><font face="cursive" size="2"><bean:write name="op" property="assoname" scope="page"/></font></b>
                                  </html:link>
                                  </logic:notEqual>
                                  </div>
                              </tr>
                               <logic:equal name="op" property="assoname" value="<%=academybaseinfoassoname%>" >
                                               <logic:iterate id="academyop" name="ACADEMYBASEINFOLIST" type="com.cssrc.bean.admin.Academybaseinfo">
                                              <logic:equal name="academyop" property="acadname" value="<%=acadname%>" >
                                              <tr>
                                               <br>
                                                 <div align="left">
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/sub.jpg" width="9" height="9" alt="" align="middle">
                                                     <html:link page="/smemberbaseinfolist.do" paramId="abi_id" paramName="academyop" paramProperty="abi_id" onclick="return warn()">
                                                          <bean:write name="academyop" property="acadname" scope="page"/>
                                                        </html:link>
                                            </tr>
                                            <tr>

                                                      <logic:equal name="academyop" property="acadname" value="<%=acadname%>" >
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/point.gif" width="9" height="9" alt="" align="middle">
                                                     <html:link page="/smemberbaseinfomainlist.do" paramId="abi_id" paramName="academyop" paramProperty="abi_id" onclick="return warn()">
                                                          个人会员
                                                        </html:link>
                                                   </logic:equal>
                                                </tr>
                                                <% if(acadname==null||!(acadname=acadname.trim()).endsWith("届")){%>
                                                <tr>
                                                      <logic:equal name="academyop" property="acadname" value="<%=acadname%>" >
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/point.gif" width="9" height="9" alt="" align="middle">
                                                     <html:link page="/gmemberbaseinfomainlist.do" paramId="abi_id" paramName="academyop" paramProperty="abi_id" onclick="return warn()">
                                                          团体会员
                                                        </html:link>
                                                   </logic:equal>
                                                </tr>
                                                 <% } %>
                                                </logic:equal>
                                                
                                                
                                                
                                                <logic:notEqual name="academyop" property="acadname" value="<%=acadname%>" >
                                                
                                                <tr>
                                               <br>
                                                 <div align="left">
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/add.jpg" width="9" height="9" alt="" align="middle">
                                                     <html:link page="/smemberbaseinfolist.do" paramId="abi_id" paramName="academyop" paramProperty="abi_id" onclick="return warn()">
                                                          <bean:write name="academyop" property="acadname" scope="page"/>
                                                        </html:link>
                                            </tr>
                                            <tr>
                                                </logic:notEqual>  
                                              </logic:iterate>
                                      </logic:equal>
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
                                <td align="left"><font face="华文新魏" size="3"><%=(String)request.getSession().getAttribute("academybaseinfoassoname")%>&nbsp;&gt;&gt;&nbsp;<%=(String)request.getSession().getAttribute("acadname")%>&nbsp;&gt;&gt;&nbsp;<font color="red">修改个人会员信息</font></font><br>
                                    <hr color="#008000" size="3"></td>
                              </tr>
                              <tr>
                  <td align="center" valign="top">
                    <p>&nbsp;</p>
                   <tr>
                                <td height="30" align="left">
								<table width="100%" height="30" cellpadding="0" cellspacing="0" border="0">
                                  <tr>
                                    <td width="10"><img src="<%=contextpath%>/images/academybase/CONTENT_WL.jpg" width="10" height="30"></td>
                                    <td width="10%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#e6f0fa" style="BORDER-TOP:#c4c4c4 1px solid">
                                      <tr>
                                        <td><div align="center" class="style14 style17">
                                        <a href='acadesmemberbaseinfomodify.do?asmr_id=<%=modifyasmr_id%>'>
                                          基本信息
                                          </a>
                                          </div>
                                        </td>
                                      </tr>
                                    </table></td>
                                    <td width="19"><img src="<%=contextpath%>/images/academybase/CONTENT_WL_CR.jpg" width="19" height="30"></td>
                                    <td width="11%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF" style="BORDER-TOP:#c4c4c4 1px solid">
                                      <tr>
                                        <td background="<%=contextpath%>/images/academybase/CONTENT_10.jpg"><div align="center" class="style14 style17">
                                          <a href='smemberdeputyinfomodifylist.do?smbi_id=<%=modifysmbi_id%>'>
                                           代表委员信息
                                          </a>
                                        </div></td>
                                      </tr>
                                    </table></td>
                                    <td width="19"><img src="<%=contextpath%>/images/academybase/CONTENT_CL_CR.jpg" width="19" height="30"></td>
                                    <td width="11%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF" style="BORDER-TOP:#c4c4c4 1px solid">

                                      <tr>
                                        <td background="<%=contextpath%>/images/academybase/CONTENT_10.jpg"><div align="center" class="style14 style17">
                                          <a href='academysmemberrelationmodifylist.do?smbi_id=<%=modifysmbi_id%>'>
                                          参加学会信息
                                          </a>
                                          </div></td>
                                      </tr>
                                    </table></td>
                                    <td width="19"><img src="<%=contextpath%>/images/academybase/CONTENT_CL_CR.jpg" width="19" height="30"></td>
                                    <td width="11%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF" style="BORDER-TOP:#c4c4c4 1px solid">
                                      <tr>
                                        <td background="<%=contextpath%>/images/academybase/CONTENT_10.jpg"><div align="center" class="style14 style17">
                                          <a href='smemberpastjobmodifylist.do?smbi_id=<%=modifysmbi_id%>'>
                                          主要工作经历
                                          </a>
                                         </div></td>
                                      </tr>
                                    </table></td>
                                    <td width="19"><img src="<%=contextpath%>/images/academybase/CONTENT_CL_CR.jpg" width="19" height="30"></td>
                                    <td width="11%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF" style="BORDER-TOP:#c4c4c4 1px solid">
                                      <tr>
                                        <td background="<%=contextpath%>/images/academybase/CONTENT_10.jpg"><div align="center" class="style14 style17">
                                          <a href='smemberresearchproductionmodifylist.do?smbi_id=<%=modifysmbi_id%>'>主要科研成果</a></div></td>
                                      </tr>
                                    </table></td>
                                    <td width="19"><img src="<%=contextpath%>/images/academybase/CONTENT_CL_CR.jpg" width="19" height="30"></td>
                                    <td width="16%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF" style="BORDER-TOP:#c4c4c4 1px solid">
                                      <tr>
                                        <td background="<%=contextpath%>/images/academybase/CONTENT_10.jpg"><div align="center" class="style14 style17">
                                          <a href='smemberacademicliteraturemodifylist.do?smbi_id=<%=modifysmbi_id%>'>主要学术科普论著</a></div></td>
                                      </tr>
                                    </table></td>
                                    <td width="19"><img src="<%=contextpath%>/images/academybase/CONTENT_CL_CR.jpg" width="19" height="30"></td>
                                    <td width="21%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF" style="BORDER-TOP:#c4c4c4 1px solid">
                                      <tr>
                                        <td background="<%=contextpath%>/images/academybase/CONTENT_10.jpg"><div align="center" class="style14 style17">
                                          <a href='smemberpatentinfomodifylist.do?smbi_id=<%=modifysmbi_id%>'>专利（软件著作权）情况</a></div></td>
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
                                            <table width="97%"  border="0">
                                      <tr align="center" bgcolor="#93C0E1">
                                        <td height="25" colspan="7" align="left"><span class="style1">（一）基本信息</span></td>
                                      </tr>
                                      <tr>
                                        <td height="25" colspan="2" align="center" bgcolor="#93C0E1">姓名</td>
                                        <td width="26%" height="25" bgcolor="#CDE2F1"><html:text property="memname" name="smemberbaseinfoForm" size="21"/></td>
                                        <td width="13%" height="25" align="center" bgcolor="#93C0E1">身份证号</td>
                                        <td height="25" colspan="2" bgcolor="#CDE2F1"><html:text property="memidentity" name="smemberbaseinfoForm" size="23" readonly="true" /></td>
                                        <td width="21%" height="25" rowspan="4" bgcolor="#CDE2F1"><div align="center"><img src="<%=contextpath%>/smemberbaseinfoshowobj.do" align="middle" width="100" height="100"></td>
                                      </tr>
                                      <tr>
                                        <td height="25" colspan="2" align="center" bgcolor="#93C0E1">性别</td>
                                        <td height="25" bgcolor="#CDE2F1"><html:select property="memsex" name="smemberbaseinfoForm" >
                                          <html:option value="男"></html:option>
                                          <html:option value="女"></html:option>
                                          </html:select></td>
                                        <td height="25" align="center" bgcolor="#93C0E1">出生年月</td>
                                        <td height="25" colspan="2" bgcolor="#CDE2F1"><html:text property="tempmembirthday"name="smemberbaseinfoForm" readonly="true" size="19"/>
                                                <img src="<%=contextpath%>/images/showdate.gif" align="bottom" width="16" height="16" onClick="fPopUpCalendarDlg(tempmembirthday);return false" onmouseover="this.style.cursor='hand';" alt="选择日期"></td>
                                      </tr>
                                      <tr>
                                        <td height="25" colspan="2" align="center" bgcolor="#93C0E1">民族</td>
                                        <td height="25" bgcolor="#CDE2F1"><html:radio property="memnation_s" name="smemberbaseinfoForm" value="汉族"></html:radio>汉族<br />
                                          <html:radio property="memnation_s" name="smemberbaseinfoForm" value="少数民族"></html:radio>少数民族
                                          <html:text property="memnation_f" name="smemberbaseinfoForm" size="8"/></td>
                                        <td height="25" align="center" bgcolor="#93C0E1">政治面貌</td>
                                        <td height="25" colspan="2" bgcolor="#CDE2F1"><html:radio property="memparty_s" name="smemberbaseinfoForm" value="中共党员"></html:radio>中共党员
                                          <html:radio property="memparty_s" name="smemberbaseinfoForm" value="无党派" ></html:radio>无党派<br>
                                          <html:radio property="memparty_s" name="smemberbaseinfoForm" value="民主党派" ></html:radio>民主党派
                                        <html:select property="memparty_f" name="smemberbaseinfoForm">
                                                    <html:option value="">
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
                                          </html:select></td>
                                      </tr>
                                      <tr>
                                        <td height="25" colspan="2" align="center" bgcolor="#93C0E1">学历</td>
                                        <td height="25" bgcolor="#CDE2F1"><html:select property="memscholar" name="smemberbaseinfoForm" >
                                          <html:option value="研究生"></html:option>
                                          <html:option value="本科"></html:option>
                                          <html:option value="大专"></html:option>
                                          <html:option value="其他"></html:option>
                                          </html:select></td>
                                        <td height="25" align="center" bgcolor="#93C0E1">学位</td>
                                        <td height="25" colspan="2" bgcolor="#CDE2F1"><html:select property="memdegree" name="smemberbaseinfoForm" >
                                          <html:option value="博士"></html:option>
                                          <html:option value="硕士"></html:option>
                                          <html:option value="学士"></html:option>
                                          <html:option value="无"></html:option>
                                          </html:select></td>
                                      </tr>
                                      <tr>
                                        <td height="25" colspan="2" align="center" bgcolor="#93C0E1">国籍</td>
                                        <td height="25" bgcolor="#CDE2F1"><html:radio property="memnationality_s" name="smemberbaseinfoForm" value="中国籍"></html:radio>中国籍<br />
                                          <html:radio property="memnationality_s" name="smemberbaseinfoForm" value="外国籍" ></html:radio>外国籍






                                          <html:text property="memnationality_f" name="smemberbaseinfoForm" size="10"/></td>
                                        <td height="25" align="center" bgcolor="#93C0E1">是否在职</td>
                                        <td height="25" colspan="2" bgcolor="#CDE2F1">
										<html:select property="isemployee" name="smemberbaseinfoForm" >
                                          <html:option value="在职"></html:option>
                                          <html:option value="不在职"></html:option>
                                          </html:select></td>
                                        <td height="25" bgcolor="#CDE2F1">上传个人照片<br>
                                          <html:file property="memphoto" name="smemberbaseinfoForm" size="5">
                                        </html:file> </td>

                                      </tr>
                                      <tr>
                                        <td height="25" colspan="2" align="center" bgcolor="#93C0E1">工作单位</td>
                                        <td height="25" colspan="5" bgcolor="#CDE2F1"><html:text property="meminstitute" name="smemberbaseinfoForm" size="67"/></td>
                                      </tr>
                                      <tr>
                                        <td height="25" colspan="2" align="center" bgcolor="#93C0E1">工作部门</td>
                                        <td height="25" bgcolor="#CDE2F1"><html:text property="memdept" name="smemberbaseinfoForm" size="21"/></td>
                                        <td height="25" align="center" bgcolor="#93C0E1">技术职称</td>
                                        <td height="25" colspan="3" bgcolor="#CDE2F1">
										<table width="100%" height="25" border="0" cellpadding="0" cellspacing="0">
                                          <tr>
                                            <td width="60">
										<html:select property="memrank_s" name="smemberbaseinfoForm" >
										<html:option value="正高职"></html:option>
										<html:option value="高职"></html:option>
										  <html:option value="中职"></html:option>
										  <html:option value="初职"></html:option>
										  <html:option value="其它"></html:option>
										</html:select>											</td>
                                            <td>
											&nbsp;<html:text property="memrank_f" name="smemberbaseinfoForm" size="9"/>
											</td>
                                          </tr>
                                        </table>
									  </td>
                                      </tr>
                                      <tr>
                                        <td height="25" colspan="2" align="center" bgcolor="#93C0E1">现任职务</td>
                                        <td height="25" bgcolor="#CDE2F1"><html:text property="memduty" name="smemberbaseinfoForm" size="21"/></td>
                                        <td height="25" align="center" bgcolor="#93C0E1">现从事专业</td>
                                        <td height="25" colspan="3" bgcolor="#CDE2F1"><html:text property="memspeciality" name="smemberbaseinfoForm" /></td>
                                      </tr>
                                      <tr>
                                        <td height="25" colspan="2" align="center" bgcolor="#93C0E1">主要技术专长</td>
                                        <td height="25" bgcolor="#CDE2F1"><html:text property="memskill" name="smemberbaseinfoForm" size="21"/></td>
                                        <td height="25" align="center" bgcolor="#93C0E1">懂何种外语 <br>
                                        及熟练程度</td>
                                        <td height="25" colspan="3" bgcolor="#CDE2F1"><html:text property="foreignlanguage" name="smemberbaseinfoForm"/></td>
                                      </tr>
                                      <tr>
                                        <td height="25" colspan="2" align="center" bgcolor="#93C0E1">主要社会职务</td>
                                        <td height="25" colspan="5" bgcolor="#CDE2F1"><html:multibox property="socialduty1" name="smemberbaseinfoForm" value="全国人大代表"/>1全国人大代表
                                          <html:multibox property="socialduty2" name="smemberbaseinfoForm" value="省人大代表"/>2省人大代表














                                          <html:multibox property="socialduty3" name="smemberbaseinfoForm" value="市人大代表"/>3市人大代表
                                          <html:multibox property="socialduty4" name="smemberbaseinfoForm" value="县级人大代表"/>4县级人大代表














                                          <html:multibox property="socialduty5" name="smemberbaseinfoForm" value="全国政协委员"/>5全国政协委员
                                          <html:multibox property="socialduty6" name="smemberbaseinfoForm" value="省政协委员"/>6省政协委员
                                          <html:multibox property="socialduty7" name="smemberbaseinfoForm" value="市政协委员"/>7市政协委员
                                          <html:multibox property="socialduty8" name="smemberbaseinfoForm" value="县级政协委员"/>8县级政协委员</td>
                                      </tr>
                                      <tr>
                                        <td height="25" colspan="2" align="center" bgcolor="#93C0E1">主要社会荣誉</td>
                                        <td height="25" colspan="5" bgcolor="#CDE2F1"><html:multibox property="socialhonour1" name="smemberbaseinfoForm" value="中国科学院院士" /> 1. 中国科学院院士 <html:multibox property="socialhonour2" name="smemberbaseinfoForm" value="中国工程院院士" /> 2. 中国工程院院士 <html:multibox property="socialhonour3" name="smemberbaseinfoForm" value="享受国务院政府特殊津贴" /> 3. 享受国务院政府特殊津贴<br/>
<html:multibox property="socialhonour4" name="smemberbaseinfoForm" value="全国百千万人才工程人选" /> 4. 全国百千万人才工程人选 <html:multibox property="socialhonour5" name="smemberbaseinfoForm" value="省特聘专家" /> 5. 省特聘专家<br/>
6. 突出贡献中青年专家： <html:multibox property="socialhonour6" name="smemberbaseinfoForm" value="突出贡献中青年专家国家级" /> 国家级 <html:multibox property="socialhonour7" name="smemberbaseinfoForm" value="突出贡献中青年专家省级" /> 省级 <html:multibox property="socialhonour8" name="smemberbaseinfoForm" value="突出贡献中青年专家市级" /> 市级<br/>
7. 青年科技进步奖：<html:multibox property="socialhonour9" name="smemberbaseinfoForm" value="青年科技进步奖全国" /> 全国 <html:multibox property="socialhonour10" name="smemberbaseinfoForm" value="青年科技进步奖浙江省" /> 浙江省 <html:multibox property="socialhonour11" name="smemberbaseinfoForm" value="青年科技进步奖宁波市" /> 宁波市<br/>
8. 优秀科技工作者：<html:multibox property="socialhonour12" name="smemberbaseinfoForm" value="优秀科技工作者全国" /> 全国 <html:multibox property="socialhonour13" name="smemberbaseinfoForm" value="优秀科技工作者浙江省" /> 浙江省 <html:multibox property="socialhonour14" name="smemberbaseinfoForm" value="优秀科技工作者宁波市" /> 宁波市<br/>
9. 151人才工程： <html:multibox property="socialhonour15" name="smemberbaseinfoForm" value="151人才工程第一层次人选" /> 第一层次人选 <html:multibox property="socialhonour16" name="smemberbaseinfoForm" value="151人才工程第二层次人选" /> 第二层次人选 <html:multibox property="socialhonour17" name="smemberbaseinfoForm" value="151人才工程第三层次人选" /> 第三层次人选<br/>
10. 宁波市领军和拔尖人才培养工程：<br/>
<html:multibox property="socialhonour18" name="smemberbaseinfoForm" value="宁波市领军和拔尖人才培养工程第一层次人选" /> 第一层次人选 <html:multibox property="socialhonour19" name="smemberbaseinfoForm" value="宁波市领军和拔尖人才培养工程第二层次人选" /> 第二层次人选 <html:multibox property="socialhonour20" name="smemberbaseinfoForm" value="宁波市领军和拔尖人才培养工程第三层次人选" /> 第三层次人选</td>
                                      </tr>
																								<tr>
																									<td height="25" colspan="2" align="center" bgcolor="#93C0E1">喜欢参与的文体活动</td>
																									<td height="25" colspan="6" bgcolor="#CDE2F1"><html:multibox property="sports1" name="" value="球类" />1 球类<html:multibox property="sports2" name="smemberbaseinfoForm" value="棋类" />2 棋类<html:multibox property="sports3" name="smemberbaseinfoForm" value="歌舞" />3 歌舞<html:multibox property="sports4" name="smemberbaseinfoForm" value="书画" />4 书画<br/><html:multibox property="sports5" name="smemberbaseinfoForm" value="摄影" />5 摄影<html:multibox property="sports6" name="smemberbaseinfoForm" value="登山" />6 登山<html:multibox property="sports7" name="smemberbaseinfoForm" value="游泳" />7 游泳<html:multibox property="sports8" name="smemberbaseinfoForm" value="跑步" />8 跑步</td>
																								</tr>
                                      <tr>
                                        <td height="25" colspan="2" align="center" bgcolor="#93C0E1">参加国际学术<br>
                                          社团及任职<br>
                                        情况</td>
                                        <td height="25" bgcolor="#CDE2F1"><html:radio property="interduty_s" name="smemberbaseinfoForm" value="是"></html:radio>是














                                          <html:text property="interduty_f" name="smemberbaseinfoForm"  size="14"/><br>
                                        <html:radio property="interduty_s" name="smemberbaseinfoForm" value="否"></html:radio>否</td>
                                        <td height="25" align="center" bgcolor="#93C0E1">参加全国性<br>
                                          学术社团及<br>
                                        任职情况</td>
                                        <td height="25" colspan="3" bgcolor="#CDE2F1"><html:radio property="nationduty_s" name="smemberbaseinfoForm" value="是"></html:radio>是














                                          <html:text property="nationduty_f" name="smemberbaseinfoForm" size="14"/><br>
                                        <html:radio property="nationduty_s" name="smemberbaseinfoForm" value="否"></html:radio>否</td>
                                      </tr>
                                      <tr>
                                        <td width="4%" height="25" rowspan="5" align="center" valign="middle" bgcolor="#93C0E1">通<br>
                                          讯<br>
                                          联<br>
                                          系<br>
                                          方<br>
                                        式</td>
                                        <td width="10%" height="25" rowspan="2" align="center" bgcolor="#93C0E1">单位地址</td>
                                        <td height="25" rowspan="2" bgcolor="#CDE2F1"><html:text property="instituteaddress" name="smemberbaseinfoForm" size="21"/></td>
                                        <td height="25" align="center" bgcolor="#93C0E1">邮政编码</td>
                                        <td height="25" colspan="3" bgcolor="#CDE2F1"><html:text property="institutepostcode" name="smemberbaseinfoForm"/></td>
                                      </tr>
                                      <tr>
                                        <td height="25" align="center" bgcolor="#93C0E1">联系电话</td>
                                        <td height="25" colspan="3" bgcolor="#CDE2F1"><html:text property="institutetelephone" name="smemberbaseinfoForm"/></td>
                                      </tr>
                                      <tr>
                                        <td width="10%" height="25" rowspan="2" align="center" bgcolor="#93C0E1">家庭地址</td>
                                        <td height="25" rowspan="2" bgcolor="#CDE2F1"><html:text property="homeaddress" name="smemberbaseinfoForm" size="21"/></td>
                                        <td height="25" align="center" bgcolor="#93C0E1">邮政编码</td>
                                        <td height="25" colspan="3" bgcolor="#CDE2F1"><html:text property="homepostcode" name="smemberbaseinfoForm"/></td>
                                      </tr>
                                      <tr>
                                        <td height="25" align="center" bgcolor="#93C0E1">联系电话</td>
                                        <td height="25" colspan="3" bgcolor="#CDE2F1"><html:text property="hometelephone" name="smemberbaseinfoForm"/></td>
                                      </tr>
                                      <tr>
                                        <td width="10%" height="25" align="center" bgcolor="#93C0E1">电子信箱</td>
                                        <td height="25" bgcolor="#CDE2F1"><html:text property="useremail" name="smemberbaseinfoForm" size="21"/></td>
                                        <td height="25" align="center" bgcolor="#93C0E1">手机</td>
                                        <td height="25" colspan="3" bgcolor="#CDE2F1"><html:text property="usermobile" name="smemberbaseinfoForm"/></td>
                                      </tr>
                                      <tr align="center" bgcolor="#93C0E1">
                                        <td height="25" colspan="7" align="left"><span class="style1">（二）最高学历</span></td>
                                      </tr>
                                      <tr align="center" bgcolor="#93C0E1">
                                        <td height="25" colspan="3">学校名称</td>
                                        <td height="25">专业</td>
                                        <td height="25" colspan="3" bgcolor="#93C0E1">起止年月</td>
                                      </tr>
                                      <tr>
                                        <td height="25" colspan="2" align="center" bgcolor="#93C0E1">国内</td>
                                        <td height="25" bgcolor="#CDE2F1"><html:text property="university" name="smemberbaseinfoForm" size="21"/></td>
                                        <td height="25" bgcolor="#CDE2F1"><html:text property="universityspec" name="smemberbaseinfoForm" size="10"/></td>
                                        <td width="18%" height="25" align="center" bgcolor="#CDE2F1"><html:text property="tempuniversitystartdate"name="smemberbaseinfoForm" readonly="true" size="8"/>
                                        <img src="<%=contextpath%>/images/showdate.gif" align="bottom" width="16" height="16" onClick="fPopUpCalendarDlg(tempuniversitystartdate);return false" onmouseover="this.style.cursor='hand';" alt="选择日期"></td>
                                        <td width="10%" height="25" align="center" bgcolor="#93C0E1">至</td>
                                        <td width="21%" height="25" align="center" bgcolor="#CDE2F1"><html:text property="tempuniversityenddate"name="smemberbaseinfoForm" readonly="true" size="13"/>
                                        <img src="<%=contextpath%>/images/showdate.gif" align="bottom" width="16" height="16" onClick="fPopUpCalendarDlg(tempuniversityenddate);return false" onmouseover="this.style.cursor='hand';" alt="选择日期"></td>
                                      </tr>
                                      <tr>
                                        <td height="25" colspan="2" align="center" bgcolor="#93C0E1">国外</td>
                                        <td height="25" bgcolor="#CDE2F1"><html:text property="seasuniversity" name="smemberbaseinfoForm" size="21"/></td>
                                        <td height="25" bgcolor="#CDE2F1"><html:text property="seasuniversityspec" name="smemberbaseinfoForm" size="10"/></td>
                                        <td height="25" align="center" bgcolor="#CDE2F1"><html:text property="tempseasuniversitystartdate"name="smemberbaseinfoForm" readonly="true" size="8"/>
                                        <img src="<%=contextpath%>/images/showdate.gif" align="bottom" width="16" height="16" onClick="fPopUpCalendarDlg(tempseasuniversitystartdate);return false" onmouseover="this.style.cursor='hand';" alt="选择日期"></td>
                                        <td height="25" align="center" bgcolor="#93C0E1">至</td>
                                        <td height="25" align="center" bgcolor="#CDE2F1"><html:text property="tempseasuniversityenddate"name="smemberbaseinfoForm" readonly="true" size="13"/>
                                        <img src="<%=contextpath%>/images/showdate.gif" align="bottom" width="16" height="16" onClick="fPopUpCalendarDlg(tempseasuniversityenddate);return false" onmouseover="this.style.cursor='hand';" alt="选择日期"></td>
                                      </tr>
                                      <tr align="center" bgcolor="#93C0E1">
                                        <td height="25" colspan="7" align="left"><span class="style1">（三）代表委员信息</span></td>
                                      </tr>
                                      <tr align="center">
                                        <td height="25" colspan="2" bgcolor="#93C0E1">市科协<br>现任职务</td>
                                        <td height="25" bgcolor="#CDE2F1" align="left"><html:select property="assoduty_f" name="smemberbaseinfoForm" >
                                        <html:option value=""></html:option>
                                           <html:option value="0">主席</html:option>
                                          <html:option value="1">驻会副主席</html:option>
                                          <html:option value="2">副主席</html:option>
                                          <html:option value="3">常委会委员</html:option>
                                          <html:option value="4">委员</html:option>
                                          <html:option value="5">代表</html:option>
                                          </html:select></td>
                                        <td height="25" align="center" bgcolor="#93C0E1">届次</td>
                                        <td height="25" colspan="3" bgcolor="#CDE2F1" align="left"><html:select property="assoduty_s" name="smemberbaseinfoForm" >
                                          <html:option value=""></html:option>
                                          <html:option value="8"></html:option>
                                          <html:option value="9"></html:option>
                                          <html:option value="10"></html:option>
                                          <html:option value="11"></html:option>
                                          <html:option value="12"></html:option>
                                          </html:select></td>
                                      </tr>
                                      <tr align="center" bgcolor="#93C0E1">
                                      <td height="25" colspan="7" align="left"><span class="style1">（四）参加<%=(String)request.getSession().getAttribute("acadname")%>信息</span></td>
                                      </tr>
                                      <tr>
                                        <td height="25" colspan="2" align="center" bgcolor="#93C0E1">入会时间</td>
                                        <td height="25" align="left" bgcolor="#CDE2F1"><html:text property="tempjoindate"name="smemberbaseinfoForm" readonly="true" size="17"/>
                                        <img src="<%=contextpath%>/images/showdate.gif" align="bottom" width="16" height="16" onClick="fPopUpCalendarDlg(tempjoindate);return false" onmouseover="this.style.cursor='hand';" alt="选择日期"></td>
                                        <td height="25" align="center" bgcolor="#93C0E1">会员类别</td>
                                        <td height="25" align="left" bgcolor="#CDE2F1"><html:select property="memtype" name="smemberbaseinfoForm" >
                                          <html:option value="荣誉会员"></html:option>
                                          <html:option value="高级会员"></html:option>
                                          <html:option value="普通会员"></html:option>
                                          </html:select></td>
                                        <td height="25" align="center" bgcolor="#93C0E1">年度注册</td>
                                        <td height="25" align="left" bgcolor="#CDE2F1"><html:select property="isannualregister" name="smemberbaseinfoForm" >
                                          <html:option value="注册"></html:option>
                                          <html:option value="未注册"></html:option>
                                          </html:select>
                                        </td>
                                      </tr>
                                      <tr>
                                        <td height="25" colspan="2" rowspan="2" align="center" bgcolor="#93C0E1">所在学会<br>
                                        专业委员会<br></td>
                                       <td height="25" colspan="2" align="left" bgcolor="#CDE2F1"><div align="left">1.
                                        <html:text property="belongcommittee1"name="smemberbaseinfoForm" size="20"/></div></td>
                                          <td height="25" colspan="3" align="left" bgcolor="#CDE2F1">2.<html:text property="belongcommittee2"name="smemberbaseinfoForm" size="20"/></td>
                                        </tr>
                                        <tr align="right">
                                          <td height="25" colspan="2" align="left" bgcolor="#CDE2F1"><div align="left">3.
                                          <html:text property="belongcommittee3"name="smemberbaseinfoForm"/></div></td>
                                          <td height="25" colspan="3" align="left" bgcolor="#CDE2F1">4.<html:text property="belongcommittee4"name="smemberbaseinfoForm"/></td>
                                        </tr>
                                        <td height="25" colspan="2" align="center" bgcolor="#93C0E1">学会职务</td>
                                        <td height="25" colspan="5" bgcolor="#CDE2F1"> <html:multibox property="academyduty1" name="smemberbaseinfoForm" value="理事（会）长"/>理事（会）长
                                          <html:multibox property="academyduty2" name="smemberbaseinfoForm" value="常务副理事（会）长"/>常务副理事（会）长













                                          <html:multibox property="academyduty3" name="smemberbaseinfoForm" value="副理事（会）长"/>副理事（会）长













                                          <html:multibox property="academyduty4" name="smemberbaseinfoForm" value="常务理事"/>常务理事
                                          <html:multibox property="academyduty5" name="smemberbaseinfoForm" value="理事"/>理事
                                          <html:multibox property="academyduty6" name="smemberbaseinfoForm" value="秘书长"/>秘书长<br>
                                          <html:multibox property="academyduty7" name="smemberbaseinfoForm" value="副秘书长"/>副秘书长
                                          <html:multibox property="academyduty8" name="smemberbaseinfoForm" value="专业委员会主任"/>专业委员会主任













                                          <html:multibox property="academyduty9" name="smemberbaseinfoForm" value="专业委员会副主任"/>专业委员会副主任
                                          <html:multibox property="academyduty10" name="smemberbaseinfoForm" value="工作委员会主任"/>工作委员会主任













                                          <html:multibox property="academyduty11" name="smemberbaseinfoForm" value="工作委员会副主任"/>工作委员会副主任</td>
                                      
                                    </table>

                                            <table width="97%" align="center">
                <tr>
				 <td width="35%" >&nbsp;</td>
                  <td width="29%" align="center" bgcolor="#93C0E1">数据恢复 （把1置为0为数据恢复）</td>
                  <td width="20%" align="center"><html:text property="isdelete"name="smemberbaseinfoForm" size="20"/></td>
                  <td width="16%" height="39" align="right">
				  
				  
                    <input name="submit" type="submit" class="button"
value="更新">
                    &nbsp;&nbsp;
                    <input name="button" type="button" class="button"
onclick="history.back()" value="返回">

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
<html:javascript formName="smemberbaseinfoForm"/>
