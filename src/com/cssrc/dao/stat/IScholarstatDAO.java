package com.cssrc.dao.stat;

import java.util.List;

public interface IScholarstatDAO {

	public List getSysscholarstat();

	public List getAcadscholarstat(Integer shai_id);

	public List getAcademyscholarstat(Integer abi_id);

}
