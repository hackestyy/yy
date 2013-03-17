<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html>
<head>
	

	<title>email.jsp</title>

</head>

<body>
	<html:form action="/send_email.do" method="post" enctype="multipart/form-data" >
		<table width="410" height="310" border="0"  bgcolor="#e6f0fa">
			<tr>
				<th width="410" scope="col">
					<table width="400" height="300" border="0">
						<tr>
							<td width="200" height="29" scope="col">
								<div align="left">
									收件人:
								</div>
							</td>
							<!--td width="200" scope="col">
								<div align="left">
									发件人:
								</div>
							</td-->
						</tr>
						<tr>
							<td height="31">
								<div align="center">
									<html:text property="to" name="emailForm" size="25"/>
								</div>
							</td>
							<!--td>
								<div align="center">
									<html:text property="from"  name="emailForm" size="25" />
								</div>
							</td-->
						</tr>
						<tr>
							<td height="28">
								<div align="left">
									主题:
								</div>
							</td>
							<!--td>
								<div align="left">
									发件人邮箱密码:
								</div>
						  </td-->
						</tr>
						<tr>
							<td height="29">
								<div align="center">
									<html:text property="subject"  name="emailForm" size="25"/>
								</div>
							</td>
							<!--td>
								<div align="center">
									<html:text property="pwd"  name="emailForm" size="25"/>
								</div>
						  </td-->
						</tr>
						
						<tr>
							<td height="20">
								内容:
							</td>
							<td>&nbsp;
								
						  </td>
						</tr>
						<tr>
							<td  colspan="2">
								<div>
									<html:textarea  property="text"  name="emailForm" cols="55"
										rows="15" />
								</div>
							</td>
						</tr>
						<tr>
							<td height="49" colspan="2">
								<input type="submit"  class="button" name="button" 
									value="发送">
								<input type="reset"  class="button" name="button" 
									 value="清空">
							</td>
						</tr>
					</table>
				</th>
			</tr>
	</table>
	</html:form>
</body>
</html:html>
