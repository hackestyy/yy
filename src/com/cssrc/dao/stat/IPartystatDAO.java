package com.cssrc.dao.stat;

import java.util.List;

public interface IPartystatDAO {

	public List getPartystat();

	public List getAcadpartystat(Integer shai_id);

	public List getAcademypartystat(Integer abi_id);

}
