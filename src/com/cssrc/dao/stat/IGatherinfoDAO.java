package com.cssrc.dao.stat;

import java.util.List;

public interface IGatherinfoDAO {

	public List getSysgatherinfo();

	public Integer getSysgatherinfototalpeo();

	public List getAcadgatherinfo(Integer shai_id);

	public Integer getAcadgatherinfototalpeo(Integer shai_id);

	public List getAcademygatherinfo(Integer abi_id);

	public Integer getAcademygatherinfototalpeo(Integer abi_id);
}
