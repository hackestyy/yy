package com.cssrc.dao.impl;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cssrc.dao.admin.ISendnoteDAO;

public class SendnoteDAOImpl extends HibernateDaoSupport implements ISendnoteDAO {
	private static final String LOAD_ALL = "from Sendnote sendnote order by sendnote.id desc";

	public List findSendnoteAll() {
		try {
			return this.getHibernateTemplate().find(LOAD_ALL);
		} catch (DataAccessException ex) {
			logger.error(ex);
			return null;
		}
	}

}
