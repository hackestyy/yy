package com.cssrc.dao.stat;

import java.util.List;

public interface IAgestatDAO {

	public List getSysagestat();

	public List getAcadagestat(Integer shai_id);

	public List getAcademyagestat(Integer abi_id);

}
