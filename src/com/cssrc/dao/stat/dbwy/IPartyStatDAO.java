package com.cssrc.dao.stat.dbwy;

import java.util.List;

public interface IPartyStatDAO {

	public List getAllPartyStat(String assoduty_s);

	public List getWYPartyStat(String assoduty_s);

	public List getCWPartyStat(String assoduty_s);

}
