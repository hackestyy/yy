package com.cssrc.web.action.note;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Notecharge;
import com.cssrc.bean.admin.Sendnote;
import com.cssrc.dao.admin.INotechargeDAO;
import com.cssrc.dao.admin.ISendnoteDAO;
import com.cssrc.util.DateUtil;

public class send_noteAction extends Action {
	public send_noteAction() {
	}

	private INotechargeDAO notechargeDAO;
	private ISendnoteDAO sendnoteDAO;

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Integer shai_id = (Integer) request.getSession().getAttribute("shai_id");
		Integer abi_id = (Integer) request.getSession().getAttribute("abi_id");
		Integer num = 0;
		Notecharge ncbean = new Notecharge();
		if (shai_id == 107) {
			abi_id = 10000;
		}
		String data = DateUtil.getCalendarString(Calendar.getInstance(), "yyyy-MM");
		List nclist = notechargeDAO.findNotecharge(abi_id, data);

		Dllnote dllnote = new Dllnote();
		String note_to = (String) request.getParameter("to");
		String text = (String) request.getParameter("text");

		List list = sendnoteDAO.findSendnoteAll();
		Sendnote bean = (Sendnote) list.get(0);

		String url = bean.getUrl();
		String tablename = bean.getTablename();
		String phone = bean.getPhone();
		String driverName = "com.microsoft.jdbc.sqlserver.SQLServerDriver";
		String dbURL = "jdbc:microsoft:sqlserver://" + url + ":1433;DatabaseName=" + tablename;
		String userName = bean.getUsername();
		String userPwd = bean.getUserpsw();
		Connection dbConn;

		try {
			Class.forName(driverName);
			dbConn = DriverManager.getConnection(dbURL, userName, userPwd);
			Statement stmt = dbConn.createStatement();
			String[] note_team = null;
			note_team = note_to.split(";");
			for (int i = 0; i < note_team.length; i++) {
				String phonetest = note_team[i];
				if (phonetest.length() != 11) {
					int j = i + 1;
					response.setContentType("text/html;charset=GBK");
					PrintWriter out = response.getWriter();
					String alertmsg = "第" + j + "位，手机号码有误！";
					out.println("<script>alert('" + alertmsg + "')</script>");
					out.println(("<script> window.close();</script>"));
					out.println("<script>history.back()</script>");
					out.println("<script>location.reload()</script>");
					out.flush();
					return null;
				}
			}
			for (int i = 0; i < note_team.length; i++) {

				String phonetest = note_team[i];
				num++;
				String sql = "insert into tb_queue (id,pno,phone,msg,userid,pwd) values(" + i + ",-1,'" + phonetest + "','" + text + "','" + phone + "','')";
				stmt.execute(sql);
			}
			/*
			 * if (text == null || text.equals("")) {
			 * response.setContentType("text/html;charset=GBK"); PrintWriter out
			 * = response.getWriter(); String alertmsg = "请输入发送文本内容！";
			 * out.println("<script>alert('" + alertmsg + "')</script>");
			 * out.println(("<script> window.close();</script>"));
			 * out.println("<script>history.back()</script>");
			 * out.println("<script>location.reload()</script>"); out.flush();
			 * return null; }
			 */
			/*
			 * String[] note_team = null; note_team = note_to.split(";"); int
			 * length = note_team.length; for (int i = 0; i < note_team.length;
			 * i++) { String phone = null; String phonetest = note_team[i];
			 * phone = note_team[i] + "," + i + "," + i;
			 * if(phonetest.length()!=11) {
			 * response.setContentType("text/html;charset=GBK"); PrintWriter out
			 * = response.getWriter(); String alertmsg = "第"+i+"位，手机号码有误！";
			 * out.println("<script>alert('" + alertmsg + "')</script>");
			 * out.println(("<script> window.close();</script>"));
			 * out.println("<script>history.back()</script>");
			 * out.println("<script>location.reload()</script>"); out.flush();
			 * return null; } long f = dllnote.sendnote(phone, text); if (f > 8)
			 * { response.setContentType("text/html;charset=GBK"); PrintWriter
			 * out = response.getWriter();
			 * out.println("<script>alert('发送失败，错误代码为 " + f + "！')</script>");
			 * out.println(("<script> window.close();</script>"));
			 * out.println("<script>history.back()</script>");
			 * out.println("<script>location.reload()</script>"); out.flush();
			 * return null; } }
			 */

		}

		catch (Exception m)

		{
			response.setContentType("text/html;charset=GBK");
			PrintWriter out = response.getWriter();
			String alertmsg = "发送失败！";
			out.println("<script>alert('" + alertmsg + "')</script>");
			out.println(("<script> window.close();</script>"));
			out.println("<script>history.back()</script>");
			out.println("<script>location.reload()</script>");
			out.flush();
			return null;

		}

		if (nclist.size() > 0) {
			ncbean = (Notecharge) nclist.get(0);
			ncbean.setNum(ncbean.getNum() + num);
			notechargeDAO.updateNotecharge(ncbean);

		} else {
			ncbean.setData(data);
			ncbean.setAbi_id(abi_id);
			ncbean.setData(data);
			ncbean.setNum(num);
			notechargeDAO.saveNotecharge(ncbean);
		}
		response.setContentType("text/html;charset=GBK");
		PrintWriter out = response.getWriter();
		String alertmsg = "发送成功！";
		out.println("<script>alert('" + alertmsg + "')</script>");
		out.println(("<script> window.close();</script>"));
		out.println("<script>history.back()</script>");
		out.println("<script>location.reload()</script>");
		out.flush();
		return null;

	}

	public ISendnoteDAO getSendnoteDAO() {
		return sendnoteDAO;
	}

	public void setSendnoteDAO(ISendnoteDAO sendnoteDAO) {
		this.sendnoteDAO = sendnoteDAO;
	}

	public INotechargeDAO getNotechargeDAO() {
		return notechargeDAO;
	}

	public void setNotechargeDAO(INotechargeDAO notechargeDAO) {
		this.notechargeDAO = notechargeDAO;
	}

}
