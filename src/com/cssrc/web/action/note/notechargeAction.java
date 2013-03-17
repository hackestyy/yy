package com.cssrc.web.action.note;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Academybaseinfo;
import com.cssrc.bean.admin.Notecharge;
import com.cssrc.dao.admin.IAcademybaseinfoDAO;
import com.cssrc.dao.admin.INotechargeDAO;
import com.cssrc.util.DateUtil;
import com.cssrc.web.form.common.QueryForm;

public class notechargeAction extends Action {
	public notechargeAction() {
	}

	private INotechargeDAO notechargeDAO;
	private IAcademybaseinfoDAO academybaseinfoDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		String data = String.valueOf(httpServletRequest.getParameter("data"));
		if (data.equals("now")) {
			data = DateUtil.getCalendarString(Calendar.getInstance(), "yyyy-MM");
		} else {
			QueryForm form = (QueryForm) actionForm;
		}
		try {
			List list = new ArrayList();
			List nclist = notechargeDAO.findNotecharge(data);
			for (int i = 0; i < nclist.size(); i++) {
				Notecharge bean = (Notecharge) nclist.get(i);
				List alist = academybaseinfoDAO.findAcademybaseinfo(bean.getAbi_id());
				Academybaseinfo abean = (Academybaseinfo) alist.get(0);
				bean.setName(abean.getAcadname());
				Double pprice = bean.getNum() * 0.1;
				DecimalFormat df = new DecimalFormat("#.00");
				Double price = Double.valueOf(df.format(pprice));
				bean.setPrice(price);
				list.add(bean);
			}
			httpServletRequest.setAttribute("list", list);
		} catch (Exception e) {
			return actionMapping.findForward("failure");
		}

		return actionMapping.findForward("success");

	}

	public INotechargeDAO getNotechargeDAO() {
		return notechargeDAO;
	}

	public void setNotechargeDAO(INotechargeDAO notechargeDAO) {
		this.notechargeDAO = notechargeDAO;
	}

	public IAcademybaseinfoDAO getAcademybaseinfoDAO() {
		return academybaseinfoDAO;
	}

	public void setAcademybaseinfoDAO(IAcademybaseinfoDAO academybaseinfoDAO) {
		this.academybaseinfoDAO = academybaseinfoDAO;
	}

}
