<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
<%String contextpath = request.getContextPath();%>
<%String academybaseinfoassoname = (String)session.getAttribute("academybaseinfoassoname");%>
<%Integer smemberabi_id = (Integer)session.getAttribute("abi_id");%>
<%String acadname = (String)session.getAttribute("acadname");%>
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

						<%@include file = "/WEB-INF/jsp/navigation/navigation_vip_academy.txt"%>
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
             		<div align="left"> <logic:equal name="op" property="assoname" value="<%=academybaseinfoassoname%>" >
                                &nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/sub.jpg" width="9" height="9" alt="" align="middle">
                                 <html:link page="/vipacademybaseinfolist.do" paramId="shai_id" paramName="op" paramProperty="shai_id" onclick="return warn()" styleClass="style14">
                                <font color="blue"> <b><font face="cursive" size="2"> <bean:write name="op" property="assoname" scope="page"/></font></b></font>
                                  </html:link>
                                </logic:equal>
                                 <logic:notEqual name="op" property="assoname" value="<%=academybaseinfoassoname%>" >
                                 &nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/add.jpg" width="9" height="9" alt="" align="middle">
                                 <html:link page="/vipacademybaseinfolist.do" paramId="shai_id" paramName="op" paramProperty="shai_id" onclick="return warn()" styleClass="style14">
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
                                                     <html:link page="/vipsmemberbaseinfolist.do" paramId="abi_id" paramName="academyop" paramProperty="abi_id" onclick="return warn()">
                                                          <bean:write name="academyop" property="acadname" scope="page"/>
                                                        </html:link>
                                            </tr>
                                            <tr>

                                                      <logic:equal name="academyop" property="acadname" value="<%=acadname%>" >
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/point.gif" width="9" height="9" alt="" align="middle">
                                                     <html:link page="/vipsmemberbaseinfomainlist.do" paramId="abi_id" paramName="academyop" paramProperty="abi_id" onclick="return warn()">
                                                          个人会员
                                                        </html:link>
                                                   </logic:equal>
                                                </tr>
                                                <% if(acadname==null||!(acadname=acadname.trim()).endsWith("届")){%>
                                                <tr>
                                                      <logic:equal name="academyop" property="acadname" value="<%=acadname%>" >
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/point.gif" width="9" height="9" alt="" align="middle">
                                                     <html:link page="/vipgmemberbaseinfomainlist.do" paramId="abi_id" paramName="academyop" paramProperty="abi_id" onclick="return warn()">
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
                                                     <html:link page="/vipsmemberbaseinfolist.do" paramId="abi_id" paramName="academyop" paramProperty="abi_id" onclick="return warn()">
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
                                <td height="30" align="right" valign="top"></td>
                              </tr>
                              <tr>
                                <td align="left"><font face="华文新魏" size="3">&nbsp;<%=(String)request.getSession().getAttribute("academybaseinfoassoname")%>&nbsp;&gt;&gt;&nbsp;<%=(String)request.getSession().getAttribute("acadname")%>&nbsp;&gt;&gt;&nbsp;<font color="red">政治面貌统计表</font></font><br>
                                    <hr color="#008000" size="3"></td>
                              </tr>
                              <tr>
                                <td valign="top">
                                  <table width="100%" border="0" cellpadding="0" cellspacing="0">
                                    <tr bgcolor="white">
                                      <td height="20" colspan="5">
                                      <table width="100%" border="0">
                    <tr align="center" bgcolor="#b2b2b2" class="tabletop">
                       <td width="8%">
                        <div align="center" class="style14">序号</div>
                      </td>

                      <td colspan="2">
                        <div align="center" class="style14">政治面貌</div>
                      </td>
                      <td width="20%">
                        <div align="center" class="style14">人数（名）</div>
                      </td>
                      <td width="20%">
                        <div align="center" class="style14">百分比(%)</div>
                      </td>
                      <td width="20%">
                        <div align="center" class="style14">备注</div>
                      </td>


                    </tr>
                    
                      <tr class=BlackText-9p>
                        <td bgcolor="#93C0E1">
                          <div align="center">1
                            
                          </div>
                        </td>
                        <td colspan="2" bgcolor="#93C0E1">
                          <div align="center">中共党员</div>
                        </td>
                        <td bgcolor="#CDE2F1">
                          <div align="center"><bean:write property="number1" name="partystatForm"/> </div>
                        </td>
                        <td bgcolor="#CDE2F1">
                          <div align="center">
                            <bean:write property="ratio1" format="0.00" name="partystatForm"/>%
                          </div>
                        </td>
                        <td bgcolor="#CDE2F1">&nbsp;
                          
                        </td>
                        </tr>
                    
                     <tr class=BlackText-9p>
                      <td rowspan="9" bgcolor="#93C0E1"><div align="center">2</div></td>
                      <td width="6%" rowspan="9" bgcolor="#93C0E1"><div align="center">民<br>主<br>党<br>派</div></td>
                      <td width="26%" class="tabletop"><div align="center"><strong>小计</strong></div></td>
                      <td bgcolor="#93C0E1"><div align="center"><bean:write property="number11" name="partystatForm"/></div></td>
                      <td bgcolor="#93C0E1"><div align="center"><bean:write property="ratio11" format="0.00" name="partystatForm"/>%</div></td>
                      <td colspan="2" align="right" bgcolor="#93C0E1">

                        <div align="center"></div></td>
                    </tr>
                     <tr class=BlackText-9p>
                       <td bgcolor="#93C0E1"><div align="center">民革</div></td>
                       <td bgcolor="#CDE2F1">
                         <div align="center"><bean:write property="number2" name="partystatForm"/> </div></td>
                       <td bgcolor="#CDE2F1"><div align="center"><bean:write property="ratio2" format="0.00" name="partystatForm"/>%</div></td>
                       <td colspan="2" align="right" bgcolor="#CDE2F1"><div align="center"></div></td>
                     </tr>
                     <tr class=BlackText-9p>
                       <td bgcolor="#93C0E1"><div align="center">民盟</div></td>
                       <td bgcolor="#CDE2F1"><div align="center"><bean:write property="number3" name="partystatForm"/> </div></td>
                       <td bgcolor="#CDE2F1"><div align="center"><bean:write property="ratio3" format="0.00" name="partystatForm"/>%</div></td>
                       <td colspan="2" align="right" bgcolor="#CDE2F1"><div align="center"></div></td>
                     </tr>
                     <tr class=BlackText-9p>
                       <td bgcolor="#93C0E1"><div align="center">民建</div></td>
                       <td bgcolor="#CDE2F1"><div align="center"><bean:write property="number4" name="partystatForm"/> </div></td>
                       <td bgcolor="#CDE2F1"><div align="center"><bean:write property="ratio4" format="0.00" name="partystatForm"/>%</div></td>
                       <td colspan="2" align="right" bgcolor="#CDE2F1"><div align="center"></div></td>
                     </tr>
                     <tr class=BlackText-9p>
                       <td bgcolor="#93C0E1"><div align="center">民进</div></td>
                       <td bgcolor="#CDE2F1"><div align="center"><bean:write property="number5" name="partystatForm"/> </div></td>
                       <td bgcolor="#CDE2F1"><div align="center"><bean:write property="ratio5" format="0.00" name="partystatForm"/>%</div></td>
                       <td colspan="2" align="right" bgcolor="#CDE2F1"><div align="center"></div></td>
                     </tr>
                     <tr class=BlackText-9p>
                       <td bgcolor="#93C0E1"><div align="center">农工党</div></td>
                       <td bgcolor="#CDE2F1"><div align="center"><bean:write property="number6" name="partystatForm"/> </div></td>
                       <td bgcolor="#CDE2F1"><div align="center"><bean:write property="ratio6" format="0.00" name="partystatForm"/>%</div></td>
                       <td colspan="2" align="right" bgcolor="#CDE2F1"><div align="center"></div></td>
                     </tr>
                     <tr class=BlackText-9p>
                       <td bgcolor="#93C0E1"><div align="center">致公党</div></td>
                       <td bgcolor="#CDE2F1"><div align="center"><bean:write property="number7" name="partystatForm"/> </div></td>
                       <td bgcolor="#CDE2F1"><div align="center"><bean:write property="ratio7" format="0.00" name="partystatForm"/>%</div></td>
                       <td colspan="2" align="right" bgcolor="#CDE2F1"><div align="center"></div></td>
                     </tr>
                     <tr class=BlackText-9p>
                       <td bgcolor="#93C0E1"><div align="center">九三学社</div></td>
                       <td bgcolor="#CDE2F1"><div align="center"><bean:write property="number8" name="partystatForm"/> </div></td>
                       <td bgcolor="#CDE2F1"><div align="center"><bean:write property="ratio8" format="0.00" name="partystatForm"/>%</div></td>
                       <td colspan="2" align="right" bgcolor="#CDE2F1"><div align="center"></div></td>
                     </tr>
                     <tr class=BlackText-9p>
                       <td bgcolor="#93C0E1"><div align="center">台盟</div></td>
                       <td bgcolor="#CDE2F1"><div align="center"><bean:write property="number9" name="partystatForm"/> </div></td>
                       <td bgcolor="#CDE2F1"><div align="center"><bean:write property="ratio9" format="0.00" name="partystatForm"/>%</div></td>
                       <td colspan="2" align="right" bgcolor="#CDE2F1"><div align="center"></div></td>
                     </tr>
					<tr class=BlackText-9p>
                      <td bgcolor="#93C0E1"><div align="center">3</div></td>
                      <td colspan="2" bgcolor="#93C0E1"><div align="center">无党派</div></td>
                      <td bgcolor="#CDE2F1"><div align="center"><bean:write property="number10" name="partystatForm"/> </div></td>
                      <td bgcolor="#CDE2F1"><div align="center"><bean:write property="ratio10" format="0.00" name="partystatForm"/>% </div></td>
                      <td align="right" colspan="2" bgcolor="#CDE2F1">

                        <div align="center"></div></td>
                    </tr>
					<tr class=BlackText-9p>
                      <td bgcolor="#93C0E1"><div align="center"></div></td>
                      <td colspan="2" class="tabletop"><div align="center"><strong>合计</strong></div></td>
                      <td bgcolor="#93C0E1"><div align="center"><bean:write property="number12" name="partystatForm"/></div></td>
                      <td bgcolor="#93C0E1"><div align="center"><bean:write property="ratio12" format="0.00" name="partystatForm"/>%</div></td>
                      <td align="right" colspan="2" bgcolor="#93C0E1">

                        <div align="center"></div></td>
                    </tr>
                    <tr class=BlackText-9p>
                      <td colspan="7" align="right">                                                                                        
                        <input type="button" class="button" name="strutsButton" value="下载报表" onClick="location.href='reportdownload.do?writeExcelClass=POLITICS'">
&nbsp;&nbsp;&nbsp;&nbsp;
                         <input type="button" class="button" value="返回" onclick="location.href='vipsmemberbaseinfomainlist.do'">                    </td>
                      </tr>
                  </table>
                </td>
              </tr>
            </TABLE>
<img src="<%=contextpath%>/CreateImage?infoClass=party" align="middle" >
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
