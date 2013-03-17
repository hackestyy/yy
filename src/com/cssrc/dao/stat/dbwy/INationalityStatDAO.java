package com.cssrc.dao.stat.dbwy;

import java.util.List;

public interface INationalityStatDAO {

	public List getAllNationalityStat(String assoduty_s);

	public List getWYNationalityStat(String assoduty_s);

	public List getCWNationalityStat(String assoduty_s);

}
