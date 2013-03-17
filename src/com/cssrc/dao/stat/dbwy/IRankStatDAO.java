package com.cssrc.dao.stat.dbwy;

import java.util.List;

public interface IRankStatDAO {
	public List getAllRankStat(String assoduty_s);

	public List getWYRankStat(String assoduty_s);

	public List getCWRankStat(String assoduty_s);

}
