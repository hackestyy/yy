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

<script type="text/javascript" language="JavaScript1.2">
<!--
stm_bm(["menu0d69",700,"","images/blank.gif",0,"","",2,0,0,0,1000,1,0,0,"","100%",0,0,1,1,"hand","hand","images/js/"],this);
stm_bp("p0",[0,4,0,0,3,3,0,0,100,"",-2,"",-2,90,0,0,"#000000","transparent","",3,0,0,"#000000"]);
stm_ai("p0i0",[0,"数据统计","","",-1,-1,0,"<%=contextpath%>/logout.do","_self","","","","",0,0,0,"","",0,0,0,0,1,"#F1F2EE",1,"#93A070",1,"","",3,3,0,0,"#FFFFF7","#000000","#000000","#0000FF","8pt 'Tahoma','Arial'","8pt 'Tahoma','Arial'",0,0],50,0);
stm_bp("p1",[1,4,0,0,2,3,6,0,100,"",-2,"",-2,100,2,3,"#999999","#FFFFFF","",3,1,1,"#ACA899"]);
stm_aix("p1i0","p0i0",[0,"信息汇总统计","","",-1,-1,0,"<%=contextpath%>/logout.do","_self","","","","",6,0,0,"","",0,0,0,0,1,"#FFFFFF",0,"#CCCCCC",0]);
stm_aix("p1i1","p1i0",[0,"人数分类统计分析","","",-1,-1,0,"<%=contextpath%>/vipmembershipstat.do"]);
stm_aix("p1i2","p1i0",[0,"性别情况分类统计分析","","",-1,-1,0,"<%=contextpath%>/logout.do"]);
stm_aix("p1i3","p1i0",[0,"民族情况分类统计分析","","",-1,-1,0,"<%=contextpath%>/logout.do"]);
stm_aix("p1i4","p1i0",[0,"国籍情况分类统计分析","","",-1,-1,0,"<%=contextpath%>/logout.do"]);
stm_aix("p1i5","p1i4",[0,"年龄结构分类统计分析","","",-1,-1,0,"<%=contextpath%>/logout.do"]);
stm_aix("p1i6","p1i4",[0,"学历情况分类统计分析","","",-1,-1,0,"<%=contextpath%>/logout.do"]);
stm_aix("p1i7","p1i4",[0,"技术职称情况分类统计分析","","",-1,-1,0,"<%=contextpath%>/logout.do"]);
stm_aix("p1i8","p1i4",[0,"政治面貌分类统计分析","","",-1,-1,0,"<%=contextpath%>/logout.do"]);
stm_aix("p1i9","p1i4",[0,"学会专业委员会情况分类统计分析","","",-1,-1,0,"<%=contextpath%>/logout.do"]);
stm_ep();
stm_aix("p0i1","p0i0",[0,"        ","","",-1,-1,0,"","_self","","","","",0,0,0,"","",0,0,0,0,1,"#F1F2EE",1,"#93A070",1,"","",3,3,0,0,"#FFFFF7","#000000","#000000","#FFFFFF"]);
stm_aix("p0i2","p0i0",[0,"数据查询","","",-1,-1,0,"<%=contextpath%>/vipsystemquerylist.do"],50,0);
stm_aix("p0i3","p0i1",[]);
stm_aix("p0i4","p0i0",[0,"退出系统","","",-1,-1,0,"<%=contextpath%>/logout.do"],50,0);
stm_aix("p0i5","p0i1",[0,"    "]);
stm_ep();
stm_em();
//-->

</script>
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
                  <td width="185" height="24" align="left" valign="top"><img src="images/left_01.gif" width="185" height="24"></td>
                </tr>
                <tr>
                  <td align="left" valign="top" bgcolor="#F2F5FA">
                    <table width="100%" height="250" border="0" cellPadding=0 cellSpacing=0 style="border-TOP:1px solid #C4C4C4">
                      <tr>
                        <td align="center" valign="top" bgcolor="#F2F5FA"><div align="left">
                            <table width="100%" height="200" border="0" cellPadding=0 cellSpacing=0 align="center">
                            <logic:iterate id="op" name="ACADGROUPLIST" type="com.cssrc.bean.admin.Acadgroup">
                              <tr>
                             <BR>
             <div align="left"> <html:link page="/vipacademybaseinfolist.do" paramId="shai_id" paramName="op" paramProperty="shai_id" onclick="return warn()" >
                                &nbsp;&nbsp;&nbsp;<img src="<%=contextpath%>/images/add.jpg" width="9" height="9" alt="" align="middle" border="0">
                                 </html:link>
                                 <html:link page="/vipacademybaseinfolist.do" paramId="shai_id" paramName="op" paramProperty="shai_id" onclick="return warn()" styleClass="style14">
                                 <b> <bean:write name="op" property="assoname" scope="page"/></b>
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
                                <td align="left"> <span class="QXR01">&nbsp;<font color="red">宁波市科协学会会员人数统计表</font></span> <br>
                                    <hr color="#008000" size="3"></td>
                              </tr>
                              <tr>
                                <td valign="top">
                                  <table width="100%" border="0" cellpadding="0" cellspacing="0">
                                    <tr bgcolor="white">
                                      <td height="20" colspan="5">
                                      <table width="100%" border="0">
                    <tr align="center" bgcolor="#b2b2b2" class="tabletop">
                       <td>
                        <div align="center" class="style14">序号&nbsp;&nbsp;&nbsp;</div>
                      </td>

                      <td>
                        <div align="center" class="style14">学会群名称&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
                      </td>                    
                      <td>
                        <div align="center" class="style14">人数(万名)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
                      </td>
                      <td>
                        <div align="center" class="style14">备注</div>
                      </td>
 

                    </tr>
                    <logic:iterate id="op" name="MEMBERSHIPSTATLIST" type="com.cssrc.bean.stat.MembershipStat">
                      <tr bgcolor="white" class="tabletext" onmouseout="this.className='tabletext'" onmouseover="this.className='tabletextover'">
                        <td>
                          <div align="center">
                            <bean:write name="op" property="serialnumber" scope="page"/>
                          </div>
                        </td>
                        <td>
                          <div align="left">
                            &nbsp;&nbsp;<bean:write name="op" property="acadgroupname" scope="page"/>
                          </div>
                        </td>                    
                        <td>
                          <div align="center">
                            <bean:write name="op" property="personnumber" scope="page" format="#.####"/>
                          </div>
                        </td>
                        <td>
                          &nbsp;
                        </td>

                      </tr>
                    </logic:iterate>
                     <tr class=BlackText-9p>
                      <td>&nbsp;                      </td>
                      <td>&nbsp;                      </td>
                      <td>&nbsp;                      </td>
 
                      <td align="right" colspan="2">&nbsp;

                      </td>
                    </tr>
                    <tr class=BlackText-9p>
                      <td>&nbsp;                      </td>
                      <td>&nbsp;                      </td>
                      <td>&nbsp;                      </td>
                    
                      <td align="right" colspan="2">
                        <input type="button" class="button" name="strutsButton" value="下载报表" onclick="location.href='acadgroupadd.do'">
                        &nbsp;&nbsp;&nbsp;&nbsp;
                         <input type="button" class="button" name="strutsButton" value="返回" onclick="location.href='history.back()'">
                      </td>
                    </tr>
                  </table>
                </td>
              </tr>
            </TABLE>

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
