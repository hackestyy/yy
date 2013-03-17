<%@ page language="java" pageEncoding="UTF-8"%>

<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
<head>
	<html:base />

	<title>note.jsp</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<html:form action="/send_note.do" method="post" >
		<table width="410" height="310" border="0"  bgcolor="#e6f0fa">
			<tr>
				<th width="410" scope="col">
					<table width="400" height="300" border="0">
						<tr>
							<td width="200" height="29" scope="col">
								<div align="left">
									收信手机号人:
								</div>
							</td>
							<td width="200" scope="col">
								<div align="left">
									
								</div>
							</td>
						</tr>
						<tr>
							<td height="31">
								<div align="center">
									<html:text property="to" name="noteForm" size="25"/>
								</div>
							</td>
							<td>
								<div align="center">
									
								</div>
							</td>
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
									<html:textarea  property="text"  name="noteForm" cols="55"
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
