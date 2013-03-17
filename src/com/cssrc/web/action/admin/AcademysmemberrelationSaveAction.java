package com.cssrc.web.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Academysmemberrelation;
import com.cssrc.dao.admin.IAcademysmemberrelationDAO;
import com.cssrc.util.DateUtil;
import com.cssrc.web.form.admin.AcademysmemberrelationForm;

public class AcademysmemberrelationSaveAction extends Action {
	public AcademysmemberrelationSaveAction() {
	}

	private IAcademysmemberrelationDAO academysmemberrelationDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		AcademysmemberrelationForm form = (AcademysmemberrelationForm) actionForm;
		Academysmemberrelation bean = new Academysmemberrelation();

		Integer smbi_id = (Integer) httpServletRequest.getSession().getAttribute("smbi_id");
		form.setSmbi_id(smbi_id);
		Integer abi_id = (Integer) httpServletRequest.getSession().getAttribute("abi_id");
		form.setAbi_id(abi_id);
		try {
			bean.setIsdelete(form.getIsdelete());
			org.apache.commons.beanutils.BeanUtils.copyProperties(bean, form);
		} catch (Exception ex) {
		}

		String tempjoindate = form.getTempjoindate();
		if (tempjoindate.equals("")) {
			tempjoindate = null;
		}
		bean.setJoindate(DateUtil.getCalendar(tempjoindate).getTime());

		if (!academysmemberrelationDAO.saveAcademysmemberrelation(bean)) {
			return actionMapping.findForward("smiderrorAdd");
		}
		httpServletRequest.getSession().setAttribute("asmr_id", bean.getAsmr_id());
		return actionMapping.findForward("success");
	}

	public IAcademysmemberrelationDAO getAcademysmemberrelationDAO() {
		return academysmemberrelationDAO;
	}

	public void setAcademysmemberrelationDAO(IAcademysmemberrelationDAO academysmemberrelationDAO) {
		this.academysmemberrelationDAO = academysmemberrelationDAO;
	}

}
