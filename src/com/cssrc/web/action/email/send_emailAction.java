package com.cssrc.web.action.email;

import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.User;
import com.cssrc.bean.admin.Stemp;
import com.cssrc.dao.admin.IStempDAO;
import com.cssrc.web.form.email.EmailForm;

public class send_emailAction extends Action {
	public send_emailAction() {
	}

	private IStempDAO stempDAO;

	public ActionForward execute(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception {
		EmailForm formemail = (EmailForm) actionForm;
//		final String pwd = formemail.getPwd();
//		final String smtp_from = formemail.getFrom();
		String subjects = formemail.getSubject();
		String texts = formemail.getText();
		String email_to = formemail.getTo();

		try {

			Properties props = new Properties();

			Session sendMailSession;

			Store store;

			Transport transport;

//			int j = 0;
//			/* 获取邮箱的后缀，生成smtp */
//			for (int i = 0; i < smtp_from.length(); i++) {
//				if (smtp_from.substring(i, i + 1).equals("@")) {
//					j = i + 1;
//					break;
//				}
//			}
//			User user = (User) request.getSession().getAttribute("USER");
//			String username = user.getUseraccount();
//			List stemplist = stempDAO.findStemp(username);

			// String smtpfrom = (String) request.getParameter("smtp");
//			if (stemplist.size() == 0) {
//				response.setContentType("text/html;charset=GBK");
//				PrintWriter out = response.getWriter();
//				String alertmsg = "请先设置您的邮件服务器地址";
//				out.println("<script>alert('" + alertmsg + "')</script>");
//				out.println(("<script> window.close();</script>"));
//				out.println("<script>history.back()</script>");
//				out.println("<script>location.reload()</script>");
//				out.flush();
//				return null;
//			} else {
//				Stemp bean = (Stemp) stemplist.get(0);
				props.put("mail.smtp.host", "smtp.nbidc.gov.cn");
//			}

			props.put("mail.smtp.auth", "true");
			/* 发送邮件 */
			Session session = Session.getInstance(props, new Authenticator() {
				@Override
				public PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("xh@nbast.org.cn", "nbkx8774");
				}
			});
			Message newMessage = new MimeMessage(session);

			newMessage.setFrom(new InternetAddress("xh@nbast.org.cn"));

			String[] email_team = null;
			email_team = email_to.split(";");
			/* 如果接收邮箱是多个，那么就循环发送 */
			for (int i = 0; i < email_team.length; i++) {
				String email = null;
				email = email_team[i];
				newMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
				newMessage.setSubject(subjects);

				newMessage.setSentDate(new Date());

				newMessage.setText(texts);

				transport = session.getTransport("smtp");

				transport.send(newMessage);
				
//				transport.close();
			}

		}

		catch (MessagingException m)

		{
			response.setContentType("text/html;charset=GBK");
			PrintWriter out = response.getWriter();
			String alertmsg = "发送邮件失败！您的邮箱可能不支持客户端的smtp协议";
			out.println("<script>alert('" + alertmsg + "')</script>");
			out.println(("<script> window.close();</script>"));
			out.println("<script>history.back()</script>");
			out.println("<script>location.reload()</script>");
			out.flush();
			return null;

		}
		response.setContentType("text/html;charset=GBK");
		PrintWriter out = response.getWriter();
		String alertmsg = "发送邮件成功！";
		out.println("<script>alert('" + alertmsg + "')</script>");
		out.println(("<script> window.close();</script>"));
		out.println("<script>history.back()</script>");
		out.println("<script>location.reload()</script>");
		out.flush();
		
		return null;

	}

	public IStempDAO getStempDAO() {
		return stempDAO;
	}

	public void setStempDAO(IStempDAO stempDAO) {
		this.stempDAO = stempDAO;
	}

}
