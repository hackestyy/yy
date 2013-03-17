<%@page contentType="text/html; charset=utf-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
<%String contextpath = request.getContextPath();%>
<%String academybaseinfoassoname = (String)session.getAttribute("academybaseinfoassoname");%>
<%Integer modifyabi_id = (Integer)session.getAttribute("abi_id");%>
<%Integer modifysmbi_id = (Integer)session.getAttribute("smbi_id");%>
<%String acadname = (String)session.getAttribute("acadname");%>
<html:form method="post" action="/searchacademysmemberrelationview.do" >
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
<script src = "<%=contextpath%>/js/global.js"></script>
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
                  <td align="left" valign="top" bgcolor="#F2F5FA">
                    <table width="100%" height="250" border="0" cellPadding=0 cellSpacing=0 style="border-TOP:1px solid #C4C4C4">
                      <tr>
                        <td align="center" valign="top" bgcolor="#e6f0fa"><div align="left">
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

                            <p>　</p>
                        </div></td>
                      </tr>
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

                                <td align="left"><font face="华文新魏" size="3"><font color="red">个人会员详细信息</font></font><font color="red" style="float:right">参加会议（活动）情况 </font><br>
                                    <hr color="#008000" size="3"></td>
                              </tr>
                              <tr>
                  <td align="center" valign="top">
                    <p>　</p>
                   <tr>
                                <td height="30" align="left">
								  <table width="100%" height="30" cellpadding="0" cellspacing="0" border="0">
                                    <tr>
                                      <td width="10"><img src="<%=contextpath%>/images/academybase/CONTENT_CL.jpg" width="10" height="30"></td>
                                      <td width="10%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF" style="BORDER-TOP:#c4c4c4 1px solid">
                                          <tr>
                                            <td background="<%=contextpath%>/images/academybase/CONTENT_10.jpg"><div align="center" class="style14 style17"> 基本信息 </div></td>
                                          </tr>
                                      </table></td>
                                      <td width="19"><img src="<%=contextpath%>/images/academybase/CONTENT_CL_CR.jpg" width="19" height="30"></td>
                                      <td width="11%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF" style="BORDER-TOP:#c4c4c4 1px solid">
                                          <tr>
                                            <td background="<%=contextpath%>/images/academybase/CONTENT_10.jpg"><div align="center" class="style14 style17"> 代表委员信息 </div></td>
                                          </tr>
                                      </table></td>
                                      <td width="19"><img src="<%=contextpath%>/images/academybase/CONTENT_CL_WR.jpg" width="19" height="30"></td>
                                      <td width="11%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#e6f0fa" style="BORDER-TOP:#c4c4c4 1px solid">
                                          <tr>
                                            <td ><div align="center" class="style14 style17">参加学会信息</div></td>
                                          </tr>
                                      </table></td>
                                      <td width="19"><img src="<%=contextpath%>/images/academybase/CONTENT_WL_CR.jpg" width="19" height="30"></td>
                                      <td width="11%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF" style="BORDER-TOP:#c4c4c4 1px solid">
                                          <tr>
                                            <td background="<%=contextpath%>/images/academybase/CONTENT_10.jpg"><div align="center" class="style14 style17">主要工作经历</div></td>
                                          </tr>
                                      </table></td>
                                      <td width="19"><img src="<%=contextpath%>/images/academybase/CONTENT_CL_CR.jpg" width="19" height="30"></td>
                                      <td width="11%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF" style="BORDER-TOP:#c4c4c4 1px solid">
                                          <tr>
                                            <td background="<%=contextpath%>/images/academybase/CONTENT_10.jpg"><div align="center" class="style14 style17">主要科研成果</div></td>
                                          </tr>
                                      </table></td>
                                      <td width="19"><img src="<%=contextpath%>/images/academybase/CONTENT_CL_CR.jpg" width="19" height="30"></td>
                                      <td width="16%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF" style="BORDER-TOP:#c4c4c4 1px solid">
                                          <tr>
                                            <td background="<%=contextpath%>/images/academybase/CONTENT_10.jpg"><div align="center" class="style14 style17">主要学术科普论著</div></td>
                                          </tr>
                                      </table></td>
                                      <td width="19"><img src="<%=contextpath%>/images/academybase/CONTENT_CL_CR.jpg" width="19" height="30"></td>
                                      <td width="21%"><table width="100%" height="30" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF" style="BORDER-TOP:#c4c4c4 1px solid">
                                          <tr>
                                            <td background="<%=contextpath%>/images/academybase/CONTENT_10.jpg"><div align="center" class="style14 style17">专利（软件著作权）情况</div></td>
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


                                      <table width="95%" border="0"  bordercolor="#000000">
                                        <tr>
                                          <td width="15%" height="25" align="center" bgcolor="#93C0E1">学（协）会名称</td>
                                          <td width="39%" height="25" bgcolor="#CDE2F1"><div align="center"><bean:write property="acadname"name="academysmemberrelationForm"/></div></td>
                                          <td height="25" align="center" bgcolor="#93C0E1">入会时间</td>
                                          <td width="26%" height="25" bgcolor="#CDE2F1"><div align="center"><bean:write property="tempjoindate"name="academysmemberrelationForm" /></div></td>
                                        </tr>
                                        <tr align="right">
                                          <td height="25" align="center" bgcolor="#93C0E1">会员类别</td>
                                          <td height="25" align="right" bgcolor="#CDE2F1"><div align="center"><bean:write property="memtype"name="academysmemberrelationForm"/></div></td>
                                          <td  width="17%" height="25" align="center" bgcolor="#93C0E1">年度注册</td>
                                          <td height="25"  align="right" bgcolor="#CDE2F1"><div align="center"><bean:write property="isannualregister"name="academysmemberrelationForm"/></div></td>
										  </tr>
                                        <tr align="right">
                                          <td height="25" rowspan="2" align="center" bgcolor="#93C0E1">所在学会<br>
                                            专业委员会</td>
                                          <td height="25" align="left" bgcolor="#CDE2F1">1.
                                            <bean:write property="belongcommittee1"name="academysmemberrelationForm"/></td>
                                          <td height="25" colspan="2" align="left" bgcolor="#CDE2F1">2.<bean:write property="belongcommittee2"name="academysmemberrelationForm"/></td>
										  </tr>
                                        <tr align="right">
                                          <td height="25" align="left" bgcolor="#CDE2F1">3.
                                              <bean:write property="belongcommittee3"name="academysmemberrelationForm"/>
                                          </td>
                                          <td height="25" colspan="2" align="left" bgcolor="#CDE2F1">4.<bean:write property="belongcommittee4"name="academysmemberrelationForm"/></td>
										  </tr>
                                        <tr>
                                          <td height="25" align="center" bgcolor="#93C0E1"><div align="center">学会职务</div></td>
                                          <td height="25" colspan="3" bgcolor="#CDE2F1"> <html:multibox property="academyduty1" name="academysmemberrelationForm"  value="理事（会）长"/>理事（会）长
                                            <html:multibox property="academyduty2" name="academysmemberrelationForm"  value="常务副理事（会）长"/>常务副理事（会）长






                                            <html:multibox property="academyduty3" name="academysmemberrelationForm"  value="副理事（会）长"/>副理事（会）长






                                            <html:multibox property="academyduty4" name="academysmemberrelationForm"  value="常务理事"/>常务理事
                                            <html:multibox property="academyduty5" name="academysmemberrelationForm"  value="理事"/>理事
                                            <html:multibox property="academyduty6" name="academysmemberrelationForm"  value="秘书长"/>秘书长






                                            <br> <html:multibox property="academyduty7" name="academysmemberrelationForm"  value="副秘书长"/>副秘书长
                                            <html:multibox property="academyduty8" name="academysmemberrelationForm"  value="专业委员会主任"/>专业委员会主任






                                            <html:multibox property="academyduty9" name="academysmemberrelationForm"  value="专业委员会副主任"/>专业委员会副主任
                                             <html:multibox property="academyduty10" name="academysmemberrelationForm"  value="工作委员会主任"/>工作委员会主任






                                            <html:multibox property="academyduty11" name="academysmemberrelationForm"  value="工作委员会副主任"/>工作委员会副主任</td>
                                        </tr>

                                      </table>
                <tr>
                  <td height="60" align="right">
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