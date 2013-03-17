package com.cssrc.dao.stat;

import java.util.List;

public interface IRankstatDAO {

	public List getRankstat();

	public List getAcadrankstat(Integer shai_id);

	public List getAcademyrankstat(Integer abi_id);

}
