package com.cssrc.dao.stat.dbwy;

import java.util.List;

public interface IScholarStatDAO {
	public List getAllScholarStat(String assoduty_s);

	public List getWYScholarStat(String assoduty_s);

	public List getCWScholarStat(String assoduty_s);

}
