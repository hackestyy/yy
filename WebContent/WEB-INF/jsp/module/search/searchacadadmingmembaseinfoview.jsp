<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
<%String contextpath = request.getContextPath();%>
<%Integer viewgmbi_id = (Integer)session.getAttribute("gmbi_id");%>
<%Integer viewagmr_id = (Integer)session.getAttribute("agmr_id");%>
<%Integer smemberabi_id = (Integer)session.getAttribute("abi_id");%>
<%String academybaseinfoassoname = (String) session.getAttribute("academybaseinfoassoname");%>
<%Integer searchshai_id = (Integer) session.getAttribute("shai_id");%>
<%String acadname = (String)session.getAttribute("acadname");%>
<HTML>
<HEAD>
<TITLE>宁波市科学技术协会会员会籍动态管理系统</TITLE>
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
                  <td width="185" height="24" align="left" valign="top"><html:link page="/academyadminacadgrouplist.do">
                  <img src="<%=contextpath%>/images/left_01.gif" width="185" height="24" border="0" alt="科协系统首页"></html:link></td>
                </tr>
                <tr>
                  <td align="left" valign="top" bgcolor="#e6f0fa">
                    <table width="100%" height="250" border="0" cellPadding=0 cellSpacing=0 style="border-TOP:1px solid #C4C4C4">
                      <tr>
                        <td align="center" valign="top" bgcolor="#e6f0fa"><div align="left">
                            <table width="100%" height="200" border="0" cellPadding=0 cellSpacing=0 align="center">
                            <logic:iterate id="op" name="ACADGROUPLIST" type="com.cssrc.bean.admin.Acadgroup">
	                         <logic:equal name="op" property="assoname" value="<%=academybaseinfoassoname%>" >
                              <tr>
                             <BR>
             		<div align="left"> 
                                &nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/sub.jpg" width="9" height="9" alt="" align="middle">
                                 <html:link page="/academyadminacademybaseinfolist.do" paramId="shai_id" paramName="op" paramProperty="shai_id" onclick="return warn()" styleClass="style14">
                                <font color="blue"> <b><font face="cursive" size="2"> <bean:write name="op" property="assoname" scope="page"/></font></b></font>
                                  </html:link>
                                
                                 
                                  </div>
                              </tr>
                              </logic:equal>
                               <logic:equal name="op" property="assoname" value="<%=academybaseinfoassoname%>" >
                                               <logic:iterate id="academyop" name="ACADEMYBASEINFOLIST" type="com.cssrc.bean.admin.Academybaseinfo">
                                              <logic:equal name="academyop" property="acadname" value="<%=acadname%>" >
                                              <tr>
                                               <br>
                                                 <div align="left">
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/sub.jpg" width="9" height="9" alt="" align="middle">
                                                     <html:link page="/academyadminsmemberbaseinfolist.do" paramId="abi_id" paramName="academyop" paramProperty="abi_id" onclick="return warn()">
                                                          <bean:write name="academyop" property="acadname" scope="page"/>
                                                        </html:link>
                                            </tr>
                                            <tr>

                                                      <logic:equal name="academyop" property="acadname" value="<%=acadname%>" >
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/point.gif" width="9" height="9" alt="" align="middle">
                                                     <html:link page="/academyadminsmemberbaseinfomainlist.do" paramId="abi_id" paramName="academyop" paramProperty="abi_id" onclick="return warn()">
                                                          个人会员
                                                        </html:link>
                                                   </logic:equal>
                                                </tr>
                                                <% if(acadname==null||!(acadname=acadname.trim()).endsWith("届")){%>
                                                <tr>
                                                      <logic:equal name="academyop" property="acadname" value="<%=acadname%>" >
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/point.gif" width="9" height="9" alt="" align="middle">
                                                     <html:link page="/academyadmingmemberbaseinfomainlist.do" paramId="abi_id" paramName="academyop" paramProperty="abi_id" onclick="return warn()">
                                                          团体会员
                                                        </html:link>
                                                   </logic:equal>
                                                </tr>
                                                 <% } %>
                                                </logic:equal>
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
                                <td align="left"><font face="华文新魏" size="3"><%=(String)request.getSession().getAttribute("academybaseinfoassoname")%>&nbsp;&gt;&gt;&nbsp;<%=(String)request.getSession().getAttribute("acadname")%>&nbsp;&gt;&gt;&nbsp;<font color="red">团体会员详细信息</font></font><br>
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
                                    <td width="33%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#e6f0fa" style="BORDER-TOP:#c4c4c4 1px solid">
                                      <tr>
                                        <td><div align="center" class="style14 style17">
                                          <a href='searchacadadmingmembaseinfoview.do?agmr_id=<%=viewagmr_id%>'>基本信息</a>
                                          </div>
                                        </td>
                                      </tr>
                                    </table></td>
                                    <td width="19"><img src="<%=contextpath%>/images/academybase/CONTENT_WL_CR.jpg" width="19" height="30"></td>
                                    <td width="33%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF" style="BORDER-TOP:#c4c4c4 1px solid">
                                      <tr>
                                        <td background="<%=contextpath%>/images/academybase/CONTENT_10.jpg"><div align="center" class="style14 style17">
                                          <a href='searchacadadmingmemresprolist.do?gmbi_id=<%=viewgmbi_id%>'>主要产品（科研成果）信息</a></div></td>
                                      </tr>
                                    </table></td>
                                    <td width="19"><img src="<%=contextpath%>/images/academybase/CONTENT_CL_CR.jpg" width="19" height="30"></td>
                                    <td width="34%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF" style="BORDER-TOP:#c4c4c4 1px solid">
                                      <tr>
                                        <td background="<%=contextpath%>/images/academybase/CONTENT_10.jpg"><div align="center" class="style14 style17">
                                          <a href='searchacadadmingmempatentlist.do?gmbi_id=<%=viewgmbi_id%>'>专利、标准信息</a></div></td>
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
                                              <tr>
                                                <td height="25" width="15%" align="center" bgcolor="#93C0E1">单位名称</td>
                                                <td height="25" colspan="2" align="center" bgcolor="#CDE2F1"><bean:write property="institutename" name="gmemberbaseinfoForm"/></td>
                                                <td height="25" width="22%" align="center" bgcolor="#93C0E1">组织代码</td>
                                                <td height="25" colspan="2" align="center" bgcolor="#CDE2F1"><bean:write property="institutecode" name="gmemberbaseinfoForm"/></td>
                                              </tr>
                                              <tr>
                                                <td height="25" align="center" bgcolor="#93C0E1">法定代表人</td>
                                                <td height="25" width="21%" align="center" bgcolor="#CDE2F1"><bean:write property="contactname" name="gmemberbaseinfoForm"/></td>
                                                <td height="25" align="center" width="9%" bgcolor="#93C0E1">入会时间</td>
                                                <td height="25" align="center" bgcolor="#CDE2F1"><bean:write property="tempjoindate" name="gmemberbaseinfoForm"/></td>
                                                <td height="25" align="center" width="11%" bgcolor="#93C0E1">年度注册</td>
                                                <td height="25" align="center" width="22%" bgcolor="#CDE2F1"><bean:write property="isannualregister" name="gmemberbaseinfoForm" /> </td>
                                              </tr>
                                              <tr>
                                                <td height="25" align="center" bgcolor="#93C0E1">单位性质</td>
                                                <td height="25" align="center" colspan="2" bgcolor="#CDE2F1"><bean:write property="institutetype" name="gmemberbaseinfoForm" /> </td>
                                                <td height="25" align="center" bgcolor="#93C0E1">办公地址</td>
                                                <td height="25" align="center" colspan="2" bgcolor="#CDE2F1"><bean:write property="contactaddress" name="gmemberbaseinfoForm"/></td>
                                              </tr>
                                              <tr>
                                                <td height="25" align="center" bgcolor="#93C0E1">邮政编码</td>
                                                <td height="25" align="center" colspan="2" bgcolor="#CDE2F1"><bean:write property="contactpostcode" name="gmemberbaseinfoForm"/></td>
                                                <td height="25" align="center" bgcolor="#93C0E1">联系部门</td>
                                                <td height="25" align="center" colspan="2" bgcolor="#CDE2F1"><bean:write property="contactdepartment" name="gmemberbaseinfoForm"/></td>
                                              </tr>
                                              <tr>
                                                <td height="25" align="center" bgcolor="#93C0E1">联系人姓名</td>
                                                <td height="25" align="center" colspan="2" bgcolor="#CDE2F1"><bean:write property="contactperson" name="gmemberbaseinfoForm"/></td>
                                                <td height="25" align="center" bgcolor="#93C0E1">联系电话</td>
                                                <td height="25" align="center" colspan="2" bgcolor="#CDE2F1"><bean:write property="contacttelephone" name="gmemberbaseinfoForm"/></td>
                                              </tr>
                                              <tr>
                                                <td height="25" align="center" bgcolor="#93C0E1">传真</td>
                                                <td height="25" align="center" colspan="2" bgcolor="#CDE2F1"><bean:write property="contactfax" name="gmemberbaseinfoForm"/></td>
                                                <td height="25" align="center" bgcolor="#93C0E1">单位网站名称</td>
                                                <td height="25" align="center" colspan="2" bgcolor="#CDE2F1"><bean:write property="contacturl" name="gmemberbaseinfoForm"/></td>
                                              </tr>
                                              <tr>
                                                <td height="25" align="center" bgcolor="#93C0E1">电子邮箱</td>
                                                <td height="25" align="center" colspan="2" bgcolor="#CDE2F1"><bean:write property="contactemail" name="gmemberbaseinfoForm"/></td>
                                                <td height="25" align="center" bgcolor="#93C0E1">职工总数</td>
                                                <td height="25" align="center" colspan="2" bgcolor="#CDE2F1"><bean:write property="contactstaffcount" name="gmemberbaseinfoForm"/></td>
                                              </tr>
                                              <tr>
                                                <td height="25" align="center" bgcolor="#93C0E1">其中中、高职<br>以上人数</td>
                                                <td height="25" align="center" colspan="2" bgcolor="#CDE2F1"><bean:write property="contacthigherstaffcount" name="gmemberbaseinfoForm"/></td>
                                                <td height="25" align="center" bgcolor="#93C0E1">业务经营范围</td>
                                                <td height="25" align="center" colspan="2" bgcolor="#CDE2F1"><bean:write property="contactoperationrange" name="gmemberbaseinfoForm"/></td>
                                              </tr>
                                              <!--<tr>
                                                <td bgcolor="#93C0E1">入会时间</td>
                                                <td colspan="2" bgcolor="#CDE2F1"></td>
                                                <td bgcolor="#93C0E1">年度注册</td>
                                                <td colspan="2" bgcolor="#CDE2F1"></td>
                                              </tr>-->
                                            </table>


                                            <table width="100%" align="center">
                <tr>
                  <td height="60" align="right">
                    &nbsp;&nbsp;
                    <input name="button" type="button" class="button"
onclick="location.href='academyadmingmemquerylist.do'" value="返回">

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
