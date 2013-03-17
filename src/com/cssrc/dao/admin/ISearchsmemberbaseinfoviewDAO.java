package com.cssrc.dao.admin;

import java.util.List;

public interface ISearchsmemberbaseinfoviewDAO {
	/**
	 * @param user
	 *            User
	 * @return boolean
	 */

	public Integer getSize(Integer shai_id);

	/**
	 * @param id
	 *            long
	 * @return User
	 */

	/**
	 * @return List
	 */
	public List findSearchsmemberbaseinfoviewAll();

	/**
	 * @param user
	 *            User
	 * @return boolean
	 */

	/**
	 * @param user
	 *            User
	 * @return boolean
	 */

	/**
	 * @param userid
	 * @return List
	 */
	public List findSearchsmemberbaseinfoview(Integer abi_id);

	/**
	 * @param condition
	 * @return List
	 */
	public Integer getSize();

	/**
	 * @param
	 * @return Integer
	 */
	public Integer getquerySize(String condition);

	/**
	 * @param
	 * @return int
	 */
	public Integer getquerySize(String condition, Object[] obj);

	/**
	 * @param condition
	 * @return List
	 */
	public List list(String condition, Object[] obj);

	public List listquery(String condition, int offset, int pagesize);

	public List searchlistquery(String condition, int offset, int pagesize);

	/**
	 * @param condition
	 * @return List
	 */
	public List list(String condition);

	/**
	 * @return List
	 */
	public List list(String condition, int offset, int pagesize);

	/**
	 * @return List
	 */
	public List list(String condition, int offset, int pagesize, Object[] obj);

	/**
	 * @param userid
	 *            String,password String
	 * @return boolean
	 */

	public List getlistquery(String condition, int offset, int pagesize);

	public boolean deleteSearchsmemberbaseinfoview(Integer smbi_id);

	public List findSearchsmemberbaseinfoviewBySmbiId(Integer smbi_id);

}
