package com.cssrc.dao.view;

import java.util.List;

public interface IV_peoplenumcountDAO {

	public List getPeopleNumCount();

	public Integer getPeoplePureNumCount();

	public List getAcadPeopleNumCount(Integer shai_id);

	public List getAcademyPeopleNumCount(Integer abi_id);

	public List listalltime(int shai_id);
}
