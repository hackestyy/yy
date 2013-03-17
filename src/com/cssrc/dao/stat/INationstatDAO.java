package com.cssrc.dao.stat;

import java.util.List;

public interface INationstatDAO {

	public List getSysnationstat();

	public List getAcadnationstat(Integer shai_id);

	public List getAcademynationstat(Integer abi_id);

}