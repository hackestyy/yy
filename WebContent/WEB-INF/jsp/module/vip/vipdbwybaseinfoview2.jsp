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
<%Integer viewshadbi_id = (Integer)session.getAttribute("shadbi_id");%>
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

						<%@include file = "/WEB-INF/jsp/navigation/navigation_dbwy_vipall.txt"%>

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
             				<div align="left"> 
             					<logic:equal name="op" property="assoname" value="<%=academybaseinfoassoname%>" >
                                &nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/sub.jpg" width="9" height="9" alt="" align="middle">
                                 <html:link page="/vipacademybaseinfolist.do" paramId="shai_id" paramName="op" paramProperty="shai_id"  styleClass="style14">
                                <font color="blue"> <b><font face="cursive" size="2"> <bean:write name="op" property="assoname" scope="page"/></font></b></font>
                                  </html:link>
                                </logic:equal>
                                 <logic:notEqual name="op" property="assoname" value="<%=academybaseinfoassoname%>" >
                                 &nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/add.jpg" width="9" height="9" alt="" align="middle">
                                 <html:link page="/vipacademybaseinfolist.do" paramId="shai_id" paramName="op" paramProperty="shai_id"  styleClass="style14">
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
                                                 <a href="<%=contextpath%>/vipshadeputybaseinfolist.do?assoduty_s=8">
                                                        第8届




                                                 </a>
                                             </tr>
                                      
                                        	 
                                    <br>
                                     			
                                    
                                    
												<tr>

                                                 <div align="left">
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/add.jpg" width="9" height="9" alt="" align="middle">
                                                      <a href="<%=contextpath%>/vipshadeputybaseinfolist.do?assoduty_s=9">
                                                          第9届




                                                      </a>

                                            </tr>
                                            
                                              <br>
                                                 
                                                 
                                              
                                              
                                                 <tr>
                                                 <div align="left">
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/add.jpg" width="9" height="9" alt="" align="middle">
                                                    <a href="<%=contextpath%>/vipshadeputybaseinfolist.do?assoduty_s=10">
                                                          第10届




                                                    </a>
                                              	 </tr>
                                            
                                                <br>
                                                 
                                              
                                                 <tr>
                                                 <div align="left">
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/add.jpg" width="9" height="9" alt="" align="middle">
                                                    <a href="<%=contextpath%>/vipshadeputybaseinfolist.do?assoduty_s=11">
                                                          第11届




                                                    </a>
                                              	 </tr>
                                              
                                              <br>
                                                 
                                                 
                                                 <tr>
                                                 <div align="left">
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/add.jpg" width="9" height="9" alt="" align="middle">
                                                    <a href="<%=contextpath%>/vipshadeputybaseinfolist.do?assoduty_s=12">
                                                          第12届




                                                    </a>
                                              	 </tr>
                                              

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
                                <td align="left"><font face="华文新魏" size="3"><font color="red">代表、委员详细信息</font></font><br>
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
                            <td width="11%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#e6f0fa" style="BORDER-TOP:#c4c4c4 1px solid">
                                <tr>
                                  <td><div align="center" class="style14 style17">
                                      <a href='vipsearchallshadeputybaseinfoview.do?shadbi_id=<%=viewshadbi_id%>'>
                                      基本信息 </a> </div></td>
                                </tr>
                              </table></td>
                            <td width="19"><img src="<%=contextpath%>/images/academybase/CONTENT_WL_CR.jpg" width="19" height="30"></td>
                            <td width="11%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF" style="BORDER-TOP:#c4c4c4 1px solid">
                                <tr>
                                  <td background="<%=contextpath%>/images/academybase/CONTENT_10.jpg"><div align="center" class="style14 style17">
                                  <a href='vipsearchallshadeputyinfoview.do?shadbi_id=<%=viewshadbi_id%>'>
                                      代表委员信息 </a> </div></td>
                                </tr>
                              </table></td>
                            <td width="19"><img src="<%=contextpath%>/images/academybase/CONTENT_CL_CR.jpg" width="19" height="30"></td>
                            <td width="13%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF" style="BORDER-TOP:#c4c4c4 1px solid">
                                <tr>
                                  <td background="<%=contextpath%>/images/academybase/CONTENT_10.jpg"><div align="center" class="style14 style17">
                                  <a href='vipsearchallshadeputypastjobview.do?shadbi_id=<%=viewshadbi_id%>'>
                                      主要工作经历 </a> </div></td>
                                </tr>
                              </table></td>
                            <td width="19"><img src="<%=contextpath%>/images/academybase/CONTENT_CL_CR.jpg" width="19" height="30"></td>
                            <td width="13%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF" style="BORDER-TOP:#c4c4c4 1px solid">
                                <tr>
                                  <td background="<%=contextpath%>/images/academybase/CONTENT_10.jpg"><div align="center" class="style14 style17">
                                  <a href='vipsearchallshadeputyresearchproductionview.do?shadbi_id=<%=viewshadbi_id%>'>
                                     主要科研成果</a></div></td>
                                </tr>
                              </table></td>
                            <td width="19"><img src="<%=contextpath%>/images/academybase/CONTENT_CL_CR.jpg" width="19" height="30"></td>
                            <td width="18%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF" style="BORDER-TOP:#c4c4c4 1px solid">
                                <tr>
                                  <td background="<%=contextpath%>/images/academybase/CONTENT_10.jpg"><div align="center" class="style14 style17">
                                  <a href='vipsearchallshadeputyacademicliteratureview.do?shadbi_id=<%=viewshadbi_id%>'>
                                      主要学术科普论著</a></div></td>
                                </tr>
                              </table></td>
                            <td width="19"><img src="<%=contextpath%>/images/academybase/CONTENT_CL_CR.jpg" width="19" height="30"></td>
                            <td width="23%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF" style="BORDER-TOP:#c4c4c4 1px solid">
                                <tr>
                                  <td background="<%=contextpath%>/images/academybase/CONTENT_10.jpg"><div align="center" class="style14 style17">
                                  <a href='vipsearchallshadeputypatentinfoview.do?shadbi_id=<%=viewshadbi_id%>'>
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
                                          <td align="center" valign="top"> <p>&nbsp;</p>
                                            <table width="90%"  border="0">
                                      <tr align="center">
                                        <td height="20" colspan="7" align="left">（一）基本信息</td>
                                      </tr>
                                      <tr>
                                        <td colspan="2" height="25" bgcolor="#93C0E1"><div align="center">姓名</div></td>
                                        <td width="26%" height="25" bgcolor="#CDE2F1"><div align="center"><bean:write property="deputyname" name="shadeputybaseinfoForm"/></div></td>
                                        <td width="13%" height="25" bgcolor="#93C0E1"><div align="center">身份证号</div></td>
                                        <td colspan="2" height="25" bgcolor="#CDE2F1"><div align="center"><bean:write property="deputyidentity" name="shadeputybaseinfoForm"/></div></td>
                                        <td width="21%" height="25" rowspan="5" align="right" bgcolor="#CDE2F1"><div align="center"><img src="<%=contextpath%>/shadeputybaseinfoshowobj.do" align="middle" width="100" height="100"></div></td>
                                      </tr>
                                      <tr>
                                        <td colspan="2" height="25" bgcolor="#93C0E1"><div align="center">性别</div></td>
                                        <td height="25" bgcolor="#CDE2F1"><div align="center"><bean:write property="deputysex" name="shadeputybaseinfoForm" /></div></td>
                                        <td height="25" bgcolor="#93C0E1"><div align="center">出生年月</div></td>
                                        <td height="25" colspan="2" bgcolor="#CDE2F1"><div align="center"><bean:write property="tempdeputybirthday" name="shadeputybaseinfoForm"/></div></td>
                                      </tr>
                                      <tr>
                                        <td height="25" colspan="2" bgcolor="#93C0E1"><div align="center">民族</div></td>
                                        <td height="25" bgcolor="#CDE2F1"><div align="center"><logic:equal name="shadeputybaseinfoForm"  property="deputynation_s" value="汉族">汉族</logic:equal>
                                        <logic:equal name="shadeputybaseinfoForm"  property="deputynation_s" value="少数民族"><bean:write property="deputynation_f" name="shadeputybaseinfoForm"/></logic:equal>
                                         </div></td>
                                        <td height="25" bgcolor="#93C0E1"><div align="center">政治面貌</div></td>
                                        <td height="25" colspan="2" bgcolor="#CDE2F1"><div align="center"><logic:equal name="shadeputybaseinfoForm"  property="deputyparty_s" value="中共党员">中共党员</logic:equal>
                                        <logic:equal name="shadeputybaseinfoForm"  property="deputyparty_s" value="无党派">无党派</logic:equal>
                                        <logic:equal name="shadeputybaseinfoForm"  property="deputyparty_s" value="民主党派"><bean:write property="deputyparty_f" name="shadeputybaseinfoForm"/></logic:equal>
                                        </div></td>
                                      </tr>
                                      <tr>
                                        <td height="25" colspan="2" bgcolor="#93C0E1"><div align="center">学历</div></td>
                                        <td height="25" bgcolor="#CDE2F1"><div align="center"><bean:write property="deputyscholar" name="shadeputybaseinfoForm" />
                                        </div></td>
                                        <td height="25" bgcolor="#93C0E1"><div align="center">学位</div></td>
                                        <td height="25" colspan="2" bgcolor="#CDE2F1"><div align="center"><bean:write property="deputydegree" name="shadeputybaseinfoForm" />
                                        </div></td>
                                      </tr>
                                      <tr>
                                        <td height="25" colspan="2" bgcolor="#93C0E1"><div align="center">国籍</div></td>
                                        <td height="25" bgcolor="#CDE2F1"><div align="center"><div align="center"><logic:equal name="shadeputybaseinfoForm"  property="deputynationality_s" value="中国籍">中国籍</logic:equal>
                                        <logic:equal name="shadeputybaseinfoForm"  property="deputynationality_s" value="外国籍"><bean:write property="deputynationality_f" name="shadeputybaseinfoForm"/></logic:equal>
                                        </div></td>
                                        <td height="25" bgcolor="#93C0E1"><div align="center">是否在职</div></td>
                                        <td height="25" colspan="2" bgcolor="#CDE2F1"><div align="center"><bean:write property="isemployee" name="shadeputybaseinfoForm" />
                                        </div></td>
                                      </tr>
                                      <tr>
                                        <td height="25" colspan="2" bgcolor="#93C0E1"><div align="center">工作单位</div></td>
                                        <td height="25" colspan="5" bgcolor="#CDE2F1"><div align="center"><bean:write property="deputyinstitute" name="shadeputybaseinfoForm"/></div></td>
                                      </tr>
                                      <tr>
                                        <td height="25" colspan="2" bgcolor="#93C0E1"><div align="center">工作部门</div></td>
                                        <td height="25" bgcolor="#CDE2F1"><div align="center"><bean:write property="deputydept" name="shadeputybaseinfoForm"/></div></td>
                                        <td height="25" bgcolor="#93C0E1"><div align="center">技术职称</div></td>
                                        <td height="25" colspan="3" bgcolor="#CDE2F1"><div align="center">  
                                        <bean:write property="deputyrank_s" name="shadeputybaseinfoForm"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        <bean:write property="deputyrank_f" name="shadeputybaseinfoForm"/>
                                        </div>
                                        </td>
                                      </tr>
                                      <tr>
                                        <td height="25" colspan="2" bgcolor="#93C0E1"><div align="center">现任职务</div></td>
                                        <td height="25" bgcolor="#CDE2F1"><div align="center"><bean:write property="memduty" name="shadeputybaseinfoForm"/></div></td>
                                        <td height="25" bgcolor="#93C0E1"><div align="center">现从事专业</div></td>
                                        <td height="25" colspan="3" bgcolor="#CDE2F1"><div align="center"><bean:write property="memspeciality" name="shadeputybaseinfoForm" /></div></td>
                                      </tr>
                                      <tr>
                                        <td height="25" colspan="2" bgcolor="#93C0E1"><div align="center">主要技术专长</div></td>
                                        <td height="25" bgcolor="#CDE2F1"><div align="center"><bean:write property="memskill" name="shadeputybaseinfoForm"/></div></td>
                                        <td height="25" bgcolor="#93C0E1"><div align="center">懂何种外语








                                            <br>
                                            及熟练程度</div></td>
                                        <td height="25" colspan="3" bgcolor="#CDE2F1"><div align="center"><bean:write property="foreignlanguage" name="shadeputybaseinfoForm"/></div></td>
                                      </tr>
                                      <tr>
                                        <td height="25" colspan="2" bgcolor="#93C0E1"><div align="center">主要社会职务</div></td>
                                        <td height="25" colspan="5" bgcolor="#CDE2F1">
                                        <html:multibox property="socialduty1" name="shadeputybaseinfoForm"  value="全国人大代表"/>1全国人大代表
                                          <html:multibox property="socialduty2" name="shadeputybaseinfoForm"  value="省人大代表"/>2省人大代表








                                          <html:multibox property="socialduty3" name="shadeputybaseinfoForm"  value="市人大代表"/>3市人大代表
                                          <html:multibox property="socialduty4" name="shadeputybaseinfoForm"  value="县级人大代表"/>4县级人大代表








                                          <html:multibox property="socialduty5" name="shadeputybaseinfoForm"  value="全国政协委员"/>5全国政协委员
                                          <html:multibox property="socialduty6" name="shadeputybaseinfoForm"  value="省政协委员"/>6省政协委员
                                          <html:multibox property="socialduty7" name="shadeputybaseinfoForm"  value="市政协委员"/>7市政协委员
                                          <html:multibox property="socialduty8" name="shadeputybaseinfoForm"  value="县级政协委员"/>8县级政协委员</td>
                                      </tr>
                                      <tr>
                                        <td height="25" colspan="2" bgcolor="#93C0E1"><div align="center">主要社会荣誉</div></td>
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
                                        <td height="25" colspan="2" bgcolor="#93C0E1"><div align="center">参加国际学术<br>
                                            社团及任职<br>
                                            情况</div></td>
                                        <td height="25" bgcolor="#CDE2F1"><div align="center"><logic:equal name="shadeputybaseinfoForm"  property="interduty_s" value="是"><bean:write property="interduty_f" name="shadeputybaseinfoForm"/></logic:equal>
                                        <logic:equal name="shadeputybaseinfoForm"  property="interduty_s" value="否">否</logic:equal>
                                          </div></td>
                                        <td height="25" bgcolor="#93C0E1"><div align="center">参加全国性<br>
                                            学术社团及<br>
                                            任职情况</div></td>
                                        <td height="25" colspan="3" bgcolor="#CDE2F1"><div align="center"><logic:equal name="shadeputybaseinfoForm"  property="nationduty_s" value="是"><bean:write property="nationduty_f" name="shadeputybaseinfoForm"/></logic:equal>
                                        <logic:equal name="shadeputybaseinfoForm"  property="nationduty_s" value="否">否</logic:equal>
                                          </div>
                                          </td>
                                      </tr>
                                      <tr>
                                        <td height="25" width="3%" rowspan="5" align="center" valign="middle" bgcolor="#93C0E1"><div align="center">通<br>
                                            讯<br>
                                            联<br>
                                            系<br>
                                            方<br>
                                            式</div></td>
                                        <td height="25" width="10%" rowspan="2" align="center" bgcolor="#93C0E1"><div align="center">单位地址</div></td>
                                        <td height="25" rowspan="2" bgcolor="#CDE2F1"><div align="center"><bean:write property="instituteaddress" name="shadeputybaseinfoForm"/></div></td>
                                        <td height="25" bgcolor="#93C0E1"><div align="center">邮政编码</div></td>
                                        <td height="25" colspan="3" bgcolor="#CDE2F1"><div align="center"><bean:write property="institutepostcode" name="shadeputybaseinfoForm"/></div></td>
                                      </tr>
                                      <tr>
                                        <td height="25" bgcolor="#93C0E1"><div align="center">联系电话</div></td>
                                        <td height="25" colspan="3" bgcolor="#CDE2F1"><div align="center"><bean:write property="institutetelephone" name="shadeputybaseinfoForm"/></div></td>
                                      </tr>
                                      <tr>
                                        <td height="25" width="9%" rowspan="2" align="center" bgcolor="#93C0E1"><div align="center">家庭地址</div></td>
                                        <td height="25" rowspan="2" bgcolor="#CDE2F1"><div align="center"><bean:write property="hometelephone" name="shadeputybaseinfoForm"/></div></td>
                                        <td height="25" bgcolor="#93C0E1"><div align="center">邮政编码</div></td>
                                        <td height="25" colspan="3" bgcolor="#CDE2F1"><div align="center"><bean:write property="homepostcode" name="shadeputybaseinfoForm"/></div></td>
                                      </tr>
                                      <tr>
                                        <td height="25" bgcolor="#93C0E1"><div align="center">联系电话</div></td>
                                        <td height="25" colspan="3" bgcolor="#CDE2F1"><div align="center"><bean:write property="hometelephone" name="shadeputybaseinfoForm"/></div></td>
                                      </tr>
                                      <tr>
                                        <td height="25" width="9%" align="center" bgcolor="#93C0E1"><div align="center">电子信箱</div></td>
                                        <td height="25" bgcolor="#CDE2F1"><div align="center"><bean:write property="useremail" name="shadeputybaseinfoForm"/></div></td>
                                        <td height="25" bgcolor="#93C0E1"><div align="center">手机</div></td>
                                        <td height="25" colspan="3" bgcolor="#CDE2F1"><div align="center"><bean:write property="usermobile" name="shadeputybaseinfoForm"/></div></td>
                                      </tr>
                                      <tr align="center">
                                        <td height="20" colspan="7" align="left">（二）最高学历</td>
                                      </tr>
                                      <tr align="center">
                                        <td  height="25" colspan="3" bgcolor="#93C0E1">学校名称</td>
                                        <td height="25" bgcolor="#93C0E1">专业</td>
                                        <td height="25" colspan="3" bgcolor="#93C0E1">起止年月</td>
                                      </tr>
                                      <tr>
                                        <td height="25" colspan="2" bgcolor="#93C0E1"><div align="center">国内</div></td>
                                        <td height="25" bgcolor="#CDE2F1"><div align="center"><bean:write property="university" name="shadeputybaseinfoForm"/></div></td>
                                        <td height="25" bgcolor="#CDE2F1"><div align="center"><bean:write property="universityspec" name="shadeputybaseinfoForm" /></div></td>
                                        <td width="20%" height="25" align="center" bgcolor="#CDE2F1"><div align="center"><bean:write property="tempuniversitystartdate" name="shadeputybaseinfoForm" /></div></td>
                                        <td height="25" width="10%" align="center" bgcolor="#93C0E1"><div align="center">至</div></td>
                                        <td width="20%" height="25" align="center" bgcolor="#CDE2F1"><div align="center"><bean:write property="tempuniversityenddate" name="shadeputybaseinfoForm" /></div></td>
                                      </tr>
                                      <tr>
                                        <td height="25" colspan="2" bgcolor="#93C0E1"><div align="center">国外</div></td>
                                        <td height="25" bgcolor="#CDE2F1"><div align="center"><bean:write property="seasuniversity" name="shadeputybaseinfoForm"/></div></td>
                                        <td height="25" bgcolor="#CDE2F1"><div align="center"><bean:write property="seasuniversityspec" name="shadeputybaseinfoForm"/></div></td>
                                        <td height="25" align="center" bgcolor="#CDE2F1"><div align="center"><bean:write property="tempseasuniversitystartdate" name="shadeputybaseinfoForm" /></div></td>
                                        <td height="25" align="center" bgcolor="#93C0E1"><div align="center">至</div></td>
                                        <td height="25" align="center" bgcolor="#CDE2F1"><div align="center"><bean:write property="tempseasuniversityenddate" name="shadeputybaseinfoForm" /></div></td>
                                      </tr>
                                      <tr align="center">
                                        <td height="20" colspan="7" align="left">（三）代表委员信息</td>
                                      </tr>
                                      <tr align="center">
                                        <td height="25" colspan="2" bgcolor="#93C0E1"><div align="center">市科协<br>
                                            现任职务</div></td>
                                        <td height="25" bgcolor="#CDE2F1" align="left"><div align="center">
                                        <logic:equal name="shadeputybaseinfoForm" property="assoduty_f" value="0" >主席</logic:equal>
                                          <logic:equal name="shadeputybaseinfoForm" property="assoduty_f" value="1" >驻会副主席</logic:equal>
                                          <logic:equal name="shadeputybaseinfoForm" property="assoduty_f" value="2" >副主席</logic:equal>
                                          <logic:equal name="shadeputybaseinfoForm" property="assoduty_f" value="3" >常委会委员</logic:equal>
                                          <logic:equal name="shadeputybaseinfoForm" property="assoduty_f" value="4" >委员</logic:equal>
                                          <logic:equal name="shadeputybaseinfoForm" property="assoduty_f" value="5" >代表</logic:equal>
                                          </div></td>
                                        <td height="25" align="right" bgcolor="#93C0E1"><div align="center">届次</div></td>
                                        <td height="25" colspan="3" bgcolor="#CDE2F1" align="left"><div align="center">
                                        <bean:write property="assoduty_s" name="shadeputybaseinfoForm" />
                                          </div></td>
                                      </tr>
                                    </table>

                                            <table width="100%" align="center">
                <tr>
                                      <td height="60" align="right">
                                        &nbsp;&nbsp;
                                        <input name="button" type="button" class="button"
onclick="location.href='vipdbwyquerylist.do'" value="返回">

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
