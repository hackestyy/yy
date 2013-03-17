package com.cssrc.dao.stat.dbwy;

import java.util.List;

public interface IGatherInfoStatDAO {

	public List getAllGatherInfoStat(String assoduty_s);

	public Integer getDBWYAllGatherInfoTotalPeo(String assoduty_s);

	public List getWYGatherInfoStat(String assoduty_s);

	public Integer getDBWYWYGatherInfoTotalPeo(String assoduty_s);

	public List getCWGatherInfoStat(String assoduty_s);

	public Integer getDBWYCWGatherInfoTotalPeo(String assoduty_s);

}
