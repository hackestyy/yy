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
<%Integer smemberabi_id = (Integer)session.getAttribute("abi_id");%>
<%String acadname = (String)session.getAttribute("acadname");%>
<%String assoduty_s = (String)session.getAttribute("assoduty_s");%>
<%request.setAttribute("assoduty_s",assoduty_s); %>
<%Integer modifyshadbi_id = (Integer)session.getAttribute("shadbi_id");%>
<html:form method="post" action="/searchalldbwybaseinfoupdate2.do" enctype="multipart/form-data" onsubmit="return validateShadeputybaseinfoForm(this);">
<html:hidden property="shadbi_id" name="shadeputybaseinfoForm"/>
<html:hidden property="deputyno" name="shadeputybaseinfoForm"/>
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
<script language="javascript">
function change()
{
	//获得控件值


	var obj = document.shadeputybaseinfoForm.deputyparty_s;
	var colls = document.shadeputybaseinfoForm.deputyparty_f.options;
	var party = "";
	//申请数组
	partylist = new Array("民革","民盟","民建","民进","农工党","致公党","九三学社","台盟");
	partylist2 = new Array("","民革","民盟","民建","民进","农工党","致公党","九三学社","台盟");
	//获得radio的值


	for(var i=0; i<obj.length; i++)
	{
		if(obj[i].checked)
		{
   			party = obj[i].value;
  		}
	}
	
	if(party=="民主党派")
	{
		document.shadeputybaseinfoForm.deputyparty_f.disabled=false;
		var index = colls.selectedIndex;
		colls.length=null;//清空下拉菜单
		for(var i=0; i<partylist.length; i++)
		{
			opt = document.createElement("OPTION");
			opt.value = partylist[i];
			opt.text = partylist[i];
			document.shadeputybaseinfoForm.deputyparty_f.add(opt);
		}
		if(index>0){
			colls.selectedIndex = index;
		}
	}
	if(party=="中共党员"||party=="无党派")
	{
		document.smemberbaseinfoForm.deputyparty_f.disabled=true;
		colls.length=null;
		for(var i=0; i<partylist2.length; i++)
		{
			opt = document.createElement("OPTION");
			opt.value = partylist2[i];
			opt.text = partylist2[i];
			document.shadeputybaseinfoForm.deputyparty_f.add(opt);
		}
	}

}
	
</script>
<script language=JavaScript src="<%=contextpath%>/js/jquery-1.4.2.min.js"></script>
<script language=JavaScript>
$(function(){
change();
});
</script>
<script type="text/javascript" language="JavaScript1.2" src="<%=contextpath%>/images/smenu/stmenu.js"></script>

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
                        
                        <%@include file = "/WEB-INF/jsp/navigation/navigation_dbwy_all.txt"%>
                        
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
             				<div align="left"> 
             					<logic:equal name="op" property="assoname" value="<%=academybaseinfoassoname%>" >
                                &nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/sub.jpg" width="9" height="9" alt="" align="middle">
                                 <html:link page="/academybaseinfolist.do" paramId="shai_id" paramName="op" paramProperty="shai_id"  styleClass="style14">
                                <font color="blue"> <b><font face="cursive" size="2"> <bean:write name="op" property="assoname" scope="page"/></font></b></font>
                                  </html:link>
                                </logic:equal>
                                 <logic:notEqual name="op" property="assoname" value="<%=academybaseinfoassoname%>" >
                                 &nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/add.jpg" width="9" height="9" alt="" align="middle">
                                 <html:link page="/academybaseinfolist.do" paramId="shai_id" paramName="op" paramProperty="shai_id"  styleClass="style14">
                                   <b><font face="cursive" size="2"><bean:write name="op" property="assoname" scope="page"/></font></b>
                                  </html:link>
                                  </logic:notEqual>
                                  </div>
                       </tr>
                               
                               <logic:equal name="op" property="assoname" value="<%=academybaseinfoassoname%>" >
									
									<br>
                                        
                                       
                                             <tr>
                                                 <div align="left">
                                                 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/add.jpg" width="9" height="9" alt="" align="middle">
                                                 <a href="<%=contextpath%>/shadeputybaseinfolist.do?assoduty_s=8">
                                                        第8届




                                                 </a>
                                             </tr>
                                      
                                        	 
                                    <br>
                                     			
                                    
                                    
												<tr>

                                                 <div align="left">
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/add.jpg" width="9" height="9" alt="" align="middle">
                                                      <a href="<%=contextpath%>/shadeputybaseinfolist.do?assoduty_s=9">
                                                          第9届




                                                      </a>

                                            </tr>
                                            
                                              <br>
                                                 
                                                 
                                              
                                              
                                                 <tr>
                                                 <div align="left">
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/add.jpg" width="9" height="9" alt="" align="middle">
                                                    <a href="<%=contextpath%>/shadeputybaseinfolist.do?assoduty_s=10">
                                                          第10届




                                                    </a>
                                              	 </tr>
                                            
                                                <br>
                                                 
                                              
                                                 <tr>
                                                 <div align="left">
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/add.jpg" width="9" height="9" alt="" align="middle">
                                                    <a href="<%=contextpath%>/shadeputybaseinfolist.do?assoduty_s=11">
                                                          第11届




                                                    </a>
                                              	 </tr>
                                              
                                              <br>
                                                 
                                                 
                                                 <tr>
                                                 <div align="left">
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/add.jpg" width="9" height="9" alt="" align="middle">
                                                    <a href="<%=contextpath%>/shadeputybaseinfolist.do?assoduty_s=12">
                                                          第12届




                                                    </a>
                                              	 </tr>
                                              

                                      </logic:equal>
                              </logic:iterate>
                            	
                            </table>
                            <p>　</p>
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
                                <p>　</p>
                              </tr>
                              <tr>
                                <td align="left"><font face="华文新魏" size="3"><font color="red">修改代表、委员信息</font></font><br>
                                    <hr color="#008000" size="3"></td>
                              </tr>
                              <tr>
                  <td align="center" valign="top">
                    <p>　</p>
                   <tr>
                                <td height="30" align="left">
								<table width="100%" height="30" cellpadding="0" cellspacing="0" border="0">
                          <tr>
                            <td width="10"><img src="<%=contextpath%>/images/academybase/CONTENT_WL.jpg" width="10" height="30"></td>
                            <td width="11%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#e6f0fa" style="BORDER-TOP:#c4c4c4 1px solid">
                                <tr>
                                  <td><div align="center" class="style14 style17">
                                      <a href='searchalldbwybaseinfomod2.do?shadbi_id=<%=modifyshadbi_id%>'>
                                      基本信息 </a> </div></td>
                                </tr>
                              </table></td>
                            <td width="19"><img src="<%=contextpath%>/images/academybase/CONTENT_WL_CR.jpg" width="19" height="30"></td>
                            <td width="11%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF" style="BORDER-TOP:#c4c4c4 1px solid">
                                <tr>
                                  <td background="<%=contextpath%>/images/academybase/CONTENT_10.jpg"><div align="center" class="style14 style17">
                                     <a href='searchalldbwydeputyinfomodlist2.do?shadbi_id=<%=modifyshadbi_id%>'>
                                      代表委员信息  </a></div></td>
                                </tr>
                              </table></td>
                            <td width="19"><img src="<%=contextpath%>/images/academybase/CONTENT_CL_CR.jpg" width="19" height="30"></td>
                            <td width="13%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF" style="BORDER-TOP:#c4c4c4 1px solid">
                                <tr>
                                  <td background="<%=contextpath%>/images/academybase/CONTENT_10.jpg"><div align="center" class="style14 style17">
                                    <a href='searchalldbwypastjobmodlist2.do?shadbi_id=<%=modifyshadbi_id%>'>
                                      主要工作经历 </a> </div></td>
                                </tr>
                              </table></td>
                            <td width="19"><img src="<%=contextpath%>/images/academybase/CONTENT_CL_CR.jpg" width="19" height="30"></td>
                            <td width="13%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF" style="BORDER-TOP:#c4c4c4 1px solid">
                                <tr>
                                  <td background="<%=contextpath%>/images/academybase/CONTENT_10.jpg"><div align="center" class="style14 style17">
                                  <a href='searchalldbwyrespromodlist2.do?shadbi_id=<%=modifyshadbi_id%>'>
                                     主要科研成果</a></div></td>
                                </tr>
                              </table></td>
                            <td width="19"><img src="<%=contextpath%>/images/academybase/CONTENT_CL_CR.jpg" width="19" height="30"></td>
                            <td width="18%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF" style="BORDER-TOP:#c4c4c4 1px solid">
                                <tr>
                                  <td background="<%=contextpath%>/images/academybase/CONTENT_10.jpg"><div align="center" class="style14 style17">
                                  <a href='searchalldbwyacademicliteraturemodifylist2.do?shadbi_id=<%=modifyshadbi_id%>'>
                                      主要学术科普论著</a></div></td>
                                </tr>
                              </table></td>
                            <td width="19"><img src="<%=contextpath%>/images/academybase/CONTENT_CL_CR.jpg" width="19" height="30"></td>
                            <td width="23%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF" style="BORDER-TOP:#c4c4c4 1px solid">
                                <tr>
                                  <td background="<%=contextpath%>/images/academybase/CONTENT_10.jpg"><div align="center" class="style14 style17">
                                  <a href='searchalldbwypatentinfomodlist2.do?shadbi_id=<%=modifyshadbi_id%>'>
                                      专利（软件著作权）情况</a></div></td>
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
                                          <td align="center" valign="top"> <p>　</p>
                                            <table width="90%"  border="0">
                                      <tr align="center" bgcolor="#93C0E1">
                                        <td height="25" colspan="7" align="left">（一）基本信息</td>
                                      </tr>

                                      <tr>
                                        <td height="25" colspan="2" align="center" bgcolor="#93C0E1">姓名<font color="#FF0000">*</font></td>
                                        <td width="4%" height="25" bgcolor="#CDE2F1"><html:text property="deputyname" name="shadeputybaseinfoForm" size="21"/></td>

                                        <td width="9%" height="25" align="center" bgcolor="#93C0E1">身份证号</td>
                                        <td height="25" bgcolor="#CDE2F1" colspan="2"><html:text property="deputyidentity" name="shadeputybaseinfoForm" size="21" readonly="true"/></td>

                                        <td width="25%" height="25" rowspan="4" bgcolor="#CDE2F1"><div align="center"><img src="<%=contextpath%>/shadeputybaseinfoshowobj.do" align="middle" width="100" height="100"></td>
                                      </tr>
                                      
                                      <tr>
                                        <td height="25" colspan="2" align="center" bgcolor="#93C0E1">性别<font color="#FF0000">*</font></td>
                                        <td height="25" bgcolor="#CDE2F1"><html:select property="deputysex" name="shadeputybaseinfoForm" >
                                          <html:option value="男"></html:option>
                                          <html:option value="女"></html:option>
                                          </html:select></td>
                                        <td height="25" align="center" bgcolor="#93C0E1">出生年月<font color="#FF0000">*</font></td>
                                        <td height="25" colspan="2" bgcolor="#CDE2F1"><html:text property="tempdeputybirthday"name="shadeputybaseinfoForm" readonly="true" size="17"/>
                                                <img src="<%=contextpath%>/images/showdate.gif" align="bottom" width="16" height="16" onClick="fPopUpCalendarDlg(tempdeputybirthday);return false" onmouseover="this.style.cursor='hand';" alt="选择日期"></td>
                                      </tr>
                                      <tr>
                                        <td height="25" colspan="2" align="center" bgcolor="#93C0E1">民族<font color="#FF0000">*</font></td>
                                        <td height="25" bgcolor="#CDE2F1"><html:radio property="deputynation_s" name="shadeputybaseinfoForm" value="汉族"></html:radio>汉族<br />
                                          <html:radio property="deputynation_s" name="shadeputybaseinfoForm" value="少数民族"></html:radio>少数民族
                                          <html:text property="deputynation_f" name="shadeputybaseinfoForm" size="8"/></td>
                                        <td height="25" align="center" bgcolor="#93C0E1">政治面貌<font color="#FF0000">*</font></td>
                                        <td height="25" colspan="2" bgcolor="#CDE2F1"><html:radio property="deputyparty_s" name="shadeputybaseinfoForm" value="中共党员" onclick="change()"></html:radio>中共党员
                                          <html:radio property="deputyparty_s" name="shadeputybaseinfoForm" value="无党派" onclick="change()"></html:radio>无党派<br>
                                          <html:radio property="deputyparty_s" name="shadeputybaseinfoForm" value="民主党派" onclick="change()"></html:radio>民主党派
                                        <html:select property="deputyparty_f" name="shadeputybaseinfoForm">
                                                    <html:option value="">
					            </html:option>
                                                    <html:option value="民革">
					            </html:option>
                                                    <html:option value="民盟">
					            </html:option>
                                                    <html:option value="民建">
                                                    </html:option>
					            <html:option value="民进">
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
                                        <td height="25" colspan="2" align="center" bgcolor="#93C0E1">学历<font color="#FF0000">*</font></td>
                                        <td height="25" bgcolor="#CDE2F1"><html:select property="deputyscholar" name="shadeputybaseinfoForm" >
                                          <html:option value="研究生"></html:option>
                                          <html:option value="本科"></html:option>
                                          <html:option value="大专"></html:option>
                                          <html:option value="其他"></html:option>
                                          </html:select></td>
                                        <td height="25" align="center" bgcolor="#93C0E1">学位<font color="#FF0000">*</font></td>
                                        <td height="25" colspan="2" bgcolor="#CDE2F1"><html:select property="deputydegree" name="shadeputybaseinfoForm" >
                                          <html:option value="博士"></html:option>
                                          <html:option value="硕士"></html:option>
                                          <html:option value="学士"></html:option>
                                          <html:option value="无"></html:option>
                                          </html:select></td>
                                      </tr>
                                      <tr>
                                        <td height="25" colspan="2" align="center" bgcolor="#93C0E1">国籍<font color="#FF0000">*</font></td>
                                        <td height="25" bgcolor="#CDE2F1"><html:radio property="deputynationality_s" name="shadeputybaseinfoForm" value="中国籍"></html:radio>中国籍<br />
                                          <html:radio property="deputynationality_s" name="shadeputybaseinfoForm" value="外国籍" ></html:radio>外国籍










                                          <html:text property="deputynationality_f" name="shadeputybaseinfoForm" size="10"/></td>
                                        <td height="25" align="center" bgcolor="#93C0E1">是否在职<font color="#FF0000">*</font></td>
                                        <td height="25" colspan="2" bgcolor="#CDE2F1">
										<html:select property="isemployee" name="shadeputybaseinfoForm" >
                                          <html:option value="在职"></html:option>
                                          <html:option value="不在职"></html:option>
                                        </html:select></td>
                                        <td height="25" bgcolor="#CDE2F1">上传个人照片<br>
                                          <html:file property="deputyphoto" name="shadeputybaseinfoForm" size="5">
                                        </html:file></td>
                                      </tr>
                                      <tr>
                                        <td height="25" colspan="2" align="center" bgcolor="#93C0E1">工作单位</td>
                                        <td height="25" colspan="5" bgcolor="#CDE2F1"><html:text property="deputyinstitute" name="shadeputybaseinfoForm" size="65"/></td>
                                      </tr>
                                      <tr>
                                        <td height="25" colspan="2" align="center" bgcolor="#93C0E1">工作部门</td>
                                        <td height="25" bgcolor="#CDE2F1"><html:text property="deputydept" name="shadeputybaseinfoForm" size="21"/></td>
                                        <td height="25" align="center" bgcolor="#93C0E1">技术职称<font color="#FF0000">*</font></td>
                                        <td height="25" colspan="3" bgcolor="#CDE2F1">
										<table width="100%" height="25" border="0" cellpadding="0" cellspacing="0">
                                          <tr>
                                            <td width="60">
										<html:select property="deputyrank_s" name="shadeputybaseinfoForm" >
										<html:option value="正高职"></html:option>
										<html:option value="高职"></html:option>
										  <html:option value="中职"></html:option>
										  <html:option value="初职"></html:option>
										  <html:option value="其它"></html:option>
										</html:select>											</td>
                                            <td>
                                            &nbsp;<html:text property="deputyrank_f" name="shadeputybaseinfoForm" size="9"/>
											</td>
                                          </tr>
                                        </table>

									    </td>
                                      </tr>
                                      <tr>
                                        <td height="25" colspan="2" align="center" bgcolor="#93C0E1">现任职务</td>
                                        <td height="25" bgcolor="#CDE2F1"><html:text property="memduty" name="shadeputybaseinfoForm" size="21"/></td>
                                        <td height="25" align="center" bgcolor="#93C0E1">现从事专业</td>
                                        <td height="25" colspan="3" bgcolor="#CDE2F1"><html:text property="memspeciality" name="shadeputybaseinfoForm" /></td>
                                      </tr>
                                      <tr>
                                        <td height="25" colspan="2" align="center" bgcolor="#93C0E1">主要技术专长</td>
                                        <td height="25" bgcolor="#CDE2F1"><html:text property="memskill" name="shadeputybaseinfoForm" size="21"/></td>
                                        <td height="25" align="center" bgcolor="#93C0E1">懂何种外语 <br>
                                        及熟练程度</td>
                                        <td height="25" colspan="3" bgcolor="#CDE2F1"><html:text property="foreignlanguage" name="shadeputybaseinfoForm"/></td>
                                      </tr>
                                      <tr>
                                        <td height="25" colspan="2" align="center" bgcolor="#93C0E1">主要社会职务</td>
                                        <td height="25" colspan="5" bgcolor="#CDE2F1"><html:multibox property="socialduty1" name="shadeputybaseinfoForm" value="全国人大代表"/>1全国人大代表
                                          <html:multibox property="socialduty2" name="shadeputybaseinfoForm" value="省人大代表"/>2省人大代表









                                          <html:multibox property="socialduty3" name="shadeputybaseinfoForm" value="市人大代表"/>3市人大代表
                                          <html:multibox property="socialduty4" name="shadeputybaseinfoForm" value="县级人大代表"/>4县级人大代表









                                          <html:multibox property="socialduty5" name="shadeputybaseinfoForm" value="全国政协委员"/>5全国政协委员
                                          <html:multibox property="socialduty6" name="shadeputybaseinfoForm" value="省政协委员"/>6省政协委员
                                          <html:multibox property="socialduty7" name="shadeputybaseinfoForm" value="市政协委员"/>7市政协委员
                                          <html:multibox property="socialduty8" name="shadeputybaseinfoForm" value="县级政协委员"/>8县级政协委员</td>
                                      </tr>
                                      <tr>
                                        <td height="25" colspan="2" align="center" bgcolor="#93C0E1">主要社会荣誉</td>
                                        <td height="25" colspan="5" bgcolor="#CDE2F1"><html:multibox property="socialhonour1" name="shadeputybaseinfoForm" value="中国科学院院士" /> 1. 中国科学院院士 <html:multibox property="socialhonour2" name="shadeputybaseinfoForm" value="中国工程院院士" /> 2. 中国工程院院士 <html:multibox property="socialhonour3" name="shadeputybaseinfoForm" value="享受国务院政府特殊津贴" /> 3. 享受国务院政府特殊津贴<br/>
<html:multibox property="socialhonour4" name="shadeputybaseinfoForm" value="全国百千万人才工程人选" /> 4. 全国百千万人才工程人选 <html:multibox property="socialhonour5" name="shadeputybaseinfoForm" value="省特聘专家" /> 5. 省特聘专家<br/>
6. 突出贡献中青年专家： <html:multibox property="socialhonour6" name="shadeputybaseinfoForm" value="突出贡献中青年专家国家级" /> 国家级 <html:multibox property="socialhonour7" name="shadeputybaseinfoForm" value="突出贡献中青年专家省级" /> 省级 <html:multibox property="socialhonour8" name="shadeputybaseinfoForm" value="突出贡献中青年专家市级" /> 市级<br/>
7. 青年科技进步奖：<html:multibox property="socialhonour9" name="shadeputybaseinfoForm" value="青年科技进步奖全国" /> 全国 <html:multibox property="socialhonour10" name="shadeputybaseinfoForm" value="青年科技进步奖浙江省" /> 浙江省 <html:multibox property="socialhonour11" name="shadeputybaseinfoForm" value="青年科技进步奖宁波市" /> 宁波市<br/>
8. 优秀科技工作者：<html:multibox property="socialhonour12" name="shadeputybaseinfoForm" value="优秀科技工作者全国" /> 全国 <html:multibox property="socialhonour13" name="shadeputybaseinfoForm" value="优秀科技工作者浙江省" /> 浙江省 <html:multibox property="socialhonour14" name="shadeputybaseinfoForm" value="优秀科技工作者宁波市" /> 宁波市<br/>
9. 151人才工程： <html:multibox property="socialhonour15" name="shadeputybaseinfoForm" value="151人才工程第一层次人选" /> 第一层次人选 <html:multibox property="socialhonour16" name="shadeputybaseinfoForm" value="151人才工程第二层次人选" /> 第二层次人选 <html:multibox property="socialhonour17" name="shadeputybaseinfoForm" value="151人才工程第三层次人选" /> 第三层次人选<br/>
10. 宁波市领军和拔尖人才培养工程：<br/>
<html:multibox property="socialhonour18" name="shadeputybaseinfoForm" value="宁波市领军和拔尖人才培养工程第一层次人选" /> 第一层次人选 <html:multibox property="socialhonour19" name="shadeputybaseinfoForm" value="宁波市领军和拔尖人才培养工程第二层次人选" /> 第二层次人选 <html:multibox property="socialhonour20" name="shadeputybaseinfoForm" value="宁波市领军和拔尖人才培养工程第三层次人选" /> 第三层次人选</td>
                                      </tr>
																								<tr>
																									<td height="25" colspan="2" align="center" bgcolor="#93C0E1">喜欢参与的文体活动</td>
																									<td height="25" colspan="6" bgcolor="#CDE2F1"><html:multibox property="sports1" name="shadeputybaseinfoForm" value="球类" />1 球类<html:multibox property="sports2" name="shadeputybaseinfoForm" value="棋类" />2 棋类<html:multibox property="sports3" name="shadeputybaseinfoForm" value="歌舞" />3 歌舞<html:multibox property="sports4" name="shadeputybaseinfoForm" value="书画" />4 书画<br/><html:multibox property="sports5" name="shadeputybaseinfoForm" value="摄影" />5 摄影<html:multibox property="sports6" name="shadeputybaseinfoForm" value="登山" />6 登山<html:multibox property="sports7" name="shadeputybaseinfoForm" value="游泳" />7 游泳<html:multibox property="sports8" name="shadeputybaseinfoForm" value="跑步" />8 跑步</td>
																								</tr>
                                      <tr>
                                        <td height="25" colspan="2" align="center" bgcolor="#93C0E1">参加国际学术<br>
                                          社团及任职<br>
                                        情况</td>
                                        <td height="25" bgcolor="#CDE2F1"><html:radio property="interduty_s" name="shadeputybaseinfoForm" value="是"></html:radio>是









                                          <html:text property="interduty_f" name="shadeputybaseinfoForm"  size="14"/><br>
                                        <html:radio property="interduty_s" name="shadeputybaseinfoForm" value="否"></html:radio>否</td>
                                        <td height="25" align="center" bgcolor="#93C0E1">参加全国性<br>
                                          学术社团及<br>
                                        任职情况</td>
                                        <td height="25" colspan="3" bgcolor="#CDE2F1"><html:radio property="nationduty_s" name="shadeputybaseinfoForm" value="是"></html:radio>是









                                          <html:text property="nationduty_f" name="shadeputybaseinfoForm" size="14"/><br>
                                        <html:radio property="nationduty_s" name="shadeputybaseinfoForm" value="否"></html:radio>否</td>
                                      </tr>
                                      <tr>
                                        <td width="3%" height="25" rowspan="5" align="center" valign="middle" bgcolor="#93C0E1">通<br>
                                          讯<br>
                                          联<br>
                                          系<br>
                                          方<br>
                                        式</td>
                                        <td width="74%" height="25" rowspan="2" align="center" bgcolor="#93C0E1">单位地址</td>
                                        <td height="25" rowspan="2" bgcolor="#CDE2F1"><html:text property="instituteaddress" name="shadeputybaseinfoForm" size="21"/></td>
                                        <td height="25" align="center" bgcolor="#93C0E1">邮政编码</td>
                                        <td height="25" colspan="3" bgcolor="#CDE2F1"><html:text property="institutepostcode" name="shadeputybaseinfoForm"/></td>
                                      </tr>
                                      <tr>
                                        <td height="25" align="center" bgcolor="#93C0E1">联系电话</td>
                                        <td height="25" colspan="3" bgcolor="#CDE2F1"><html:text property="institutetelephone" name="shadeputybaseinfoForm"/></td>
                                      </tr>
                                      <tr>
                                        <td width="74%" height="25" rowspan="2" align="center" bgcolor="#93C0E1">家庭地址</td>
                                        <td height="25" rowspan="2" bgcolor="#CDE2F1"><html:text property="homeaddress" name="shadeputybaseinfoForm" size="21"/></td>
                                        <td height="25" align="center" bgcolor="#93C0E1">邮政编码</td>
                                        <td height="25" colspan="3" bgcolor="#CDE2F1"><html:text property="homepostcode" name="shadeputybaseinfoForm"/></td>
                                      </tr>
                                      <tr>
                                        <td height="25" align="center" bgcolor="#93C0E1">联系电话</td>
                                        <td height="25" colspan="3" bgcolor="#CDE2F1"><html:text property="hometelephone" name="shadeputybaseinfoForm"/></td>
                                      </tr>
                                      <tr>
                                        <td width="74%" height="25" align="center" bgcolor="#93C0E1">电子信箱</td>
                                        <td height="25" bgcolor="#CDE2F1"><html:text property="useremail" name="shadeputybaseinfoForm" size="21"/></td>
                                        <td height="25" align="center" bgcolor="#93C0E1">手机</td>
                                        <td height="25" colspan="3" bgcolor="#CDE2F1"><html:text property="usermobile" name="shadeputybaseinfoForm"/></td>
                                      </tr>
                                      <tr align="center" bgcolor="#93C0E1">
                                        <td height="25" colspan="7" align="left">（二）最高学历</td>
                                      </tr>
                                      <tr align="center" bgcolor="#93C0E1">
                                        <td height="25" colspan="3">学校名称</td>
                                        <td height="25">专业</td>
                                        <td height="25" colspan="3" bgcolor="#93C0E1">起止年月</td>
                                      </tr>
                                      <tr>
                                        <td height="25" colspan="2" align="center" bgcolor="#93C0E1">国内</td>
                                        <td height="25" bgcolor="#CDE2F1"><html:text property="university" name="shadeputybaseinfoForm" size="21"/></td>
                                        <td height="25" bgcolor="#CDE2F1"><html:text property="universityspec" name="shadeputybaseinfoForm" size="10"/></td>
                                        <td width="3%" height="25" align="left" bgcolor="#CDE2F1"><html:text property="tempuniversitystartdate"name="shadeputybaseinfoForm" readonly="true" size="6"/>
                                        <img src="<%=contextpath%>/images/showdate.gif" align="bottom" width="16" height="16" onClick="fPopUpCalendarDlg(tempuniversitystartdate);return false" onmouseover="this.style.cursor='hand';" alt="选择日期"></td>
                                        <td width="2%" height="25" align="center" bgcolor="#93C0E1">至</td>
                                        <td width="13%" height="25" align="left" bgcolor="#CDE2F1"><html:text property="tempuniversityenddate"name="shadeputybaseinfoForm" readonly="true" size="13"/>
                                        <img src="<%=contextpath%>/images/showdate.gif" align="bottom" width="16" height="16" onClick="fPopUpCalendarDlg(tempuniversityenddate);return false" onmouseover="this.style.cursor='hand';" alt="选择日期"></td>
                                      </tr>
                                      <tr>
                                        <td height="25" colspan="2" align="center" bgcolor="#93C0E1">国外</td>
                                        <td height="25" bgcolor="#CDE2F1"><html:text property="seasuniversity" name="shadeputybaseinfoForm" size="21"/></td>
                                        <td height="25" bgcolor="#CDE2F1"><html:text property="seasuniversityspec" name="shadeputybaseinfoForm" size="10"/></td>
                                        <td height="25" align="left" bgcolor="#CDE2F1"><html:text property="tempseasuniversitystartdate"name="shadeputybaseinfoForm" readonly="true" size="6"/>
                                        <img src="<%=contextpath%>/images/showdate.gif" align="bottom" width="16" height="16" onClick="fPopUpCalendarDlg(tempseasuniversitystartdate);return false" onmouseover="this.style.cursor='hand';" alt="选择日期"></td>
                                        <td height="25" align="center" bgcolor="#93C0E1">至</td>
                                        <td height="25" align="left" bgcolor="#CDE2F1"><html:text property="tempseasuniversityenddate"name="shadeputybaseinfoForm" readonly="true" size="13"/>
                                        <img src="<%=contextpath%>/images/showdate.gif" align="bottom" width="16" height="16" onClick="fPopUpCalendarDlg(tempseasuniversityenddate);return false" onmouseover="this.style.cursor='hand';" alt="选择日期"></td>
                                      </tr>
                                      <tr align="center" bgcolor="#93C0E1">
                                        <td height="25" colspan="7" align="left">（三）代表委员信息</td>
                                      </tr>
                                      <tr align="center">
                                        <td height="25" colspan="2" bgcolor="#93C0E1">市科协<br>现任职务</td>
                                        <td height="25" bgcolor="#CDE2F1" align="left"><html:select property="assoduty_f" name="shadeputybaseinfoForm" >
                                        <html:option value="5">代表</html:option>
                                        <html:option value="4">委员</html:option>
                                        <html:option value="3">常委会委员</html:option>
                                        <html:option value="2">副主席</html:option>
                                        <html:option value="1">驻会副主席</html:option>
                                        <html:option value="0">主席</html:option>
 
                                          </html:select>
                                          </td>
                                        <td height="25" align="center" bgcolor="#93C0E1">届次</td>
                                        <td height="25" colspan="3" bgcolor="#CDE2F1" align="left">
                                        <html:select property="assoduty_s" name="shadeputybaseinfoForm" >                                  
                                          <html:option value="8">8</html:option>
                                          <html:option value="9">9</html:option>
                                          <html:option value="10">10</html:option>
                                          <html:option value="11">11</html:option>
                                          <html:option value="12">12</html:option>
                                        </html:select>

                                        </td>
                                      </tr>
                                    </table>


                                            <table width="100%" align="center">
                <tr>
                  <td height="60" align="right">
                    <input name="submit" type="submit" class="button"
value="更新">
                    &nbsp;&nbsp;
                    <input name="button" type="button" class="button"
onclick="location.href='dbwyquerylist.do'" value="返回">

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
  <html:javascript formName="shadeputybaseinfoForm"/>