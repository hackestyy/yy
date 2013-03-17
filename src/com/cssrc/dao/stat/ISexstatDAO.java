package com.cssrc.dao.stat;

import java.util.List;

public interface ISexstatDAO {

	public List getSyssexstat();

	public List getAcadsexstat(Integer shai_id);

	public List getAcademysexstat(Integer abi_id);

}