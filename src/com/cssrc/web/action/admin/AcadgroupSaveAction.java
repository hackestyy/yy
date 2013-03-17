package com.cssrc.web.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cssrc.bean.admin.Acadgroup;
import com.cssrc.dao.admin.IAcadgroupDAO;
import com.cssrc.dao.admin.IShassociationDAO;
import com.cssrc.web.form.admin.AcadgroupForm;

/**
 * <p>
 * Copyright: Copyright (c) 2007
 * </p>
 * <p>
 * Company:CSSRC
 * </p>
 * 
 * @author not attributable
 * @version 1.0
 */
public class AcadgroupSaveAction extends Action {
	public AcadgroupSaveAction() {
	}

	private IAcadgroupDAO acadgroupDAO;
	private IShassociationDAO shassociationDAO;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		AcadgroupForm form = (AcadgroupForm) actionForm;
		// form.setAcadgroup_no(form.getAcadgroup_no()+1);

		String sql = "select * from t_shassociationinfo where assoname= '" + form.getAssoname() + "'";

		if (shassociationDAO.selectAssonName(sql)) {
			Acadgroup bean = new Acadgroup();
			try {
				org.apache.commons.beanutils.BeanUtils.copyProperties(bean, form);
			} catch (Exception ex) {
			}
			if (!acadgroupDAO.saveAcadgroup(bean)) {
				return actionMapping.findForward("smiderrorAdd");
			}
			return actionMapping.findForward("success");
		} else {
			return actionMapping.findForward("alreadyexist");
		}

	}

	public IAcadgroupDAO getAcadgroupDAO() {
		return acadgroupDAO;
	}

	public void setAcadgroupDAO(IAcadgroupDAO acadgroupDAO) {
		this.acadgroupDAO = acadgroupDAO;
	}

	public IShassociationDAO getShassociationDAO() {
		return shassociationDAO;
	}

	public void setShassociationDAO(IShassociationDAO shassociationDAO) {
		this.shassociationDAO = shassociationDAO;
	}

}
