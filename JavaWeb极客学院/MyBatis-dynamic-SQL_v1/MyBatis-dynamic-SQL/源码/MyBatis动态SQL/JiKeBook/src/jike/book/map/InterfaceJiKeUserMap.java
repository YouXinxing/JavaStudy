package jike.book.map;

import org.apache.ibatis.annotations.Delete;
/**
 * 接口映射方式
 * @author wsdhr
 *
 */
public interface InterfaceJiKeUserMap {
	@Delete("delete from JiKeUser where id=#{id}")
	public void deleteUser(Integer id);
}
