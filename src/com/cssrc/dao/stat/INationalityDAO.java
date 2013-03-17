package com.cssrc.dao.stat;

import java.util.List;

public interface INationalityDAO {

	public List getSysnationalitystat();

	public List getAcadnationalitystat(Integer shai_id);

	public List getAcademynationalitystat(Integer abi_id);

}