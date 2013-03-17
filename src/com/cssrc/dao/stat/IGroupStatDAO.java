package com.cssrc.dao.stat;

import java.util.List;

public interface IGroupStatDAO {

	public List getGroupStat();

	public List getAcadgroupstat(Integer shai_id);

	public List getAcademygroupstat(Integer abi_id);

	public List getAcadgroupstatacadename(Integer shai_id);

	public List list(String condition);

	public List getAllgroupstat();

	public List getallgroupstatacadename();

	public List list();
}
