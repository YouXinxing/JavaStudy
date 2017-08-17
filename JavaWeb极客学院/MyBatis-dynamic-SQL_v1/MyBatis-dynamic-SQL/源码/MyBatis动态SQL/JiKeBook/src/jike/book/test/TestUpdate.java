package jike.book.test;

import java.io.IOException;
import java.io.Reader;

import jike.book.map.InterfaceJiKeUserMap;
import jike.book.pojo.JiKeUser;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
/**
 * 测试 增删改操作
 * @author wsdhr
 *
 */
public class TestUpdate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String resource = "jike/book/map/MyBatisConfig.xml";
		Reader reader = null;
		SqlSession session;
		try {
			reader = Resources.getResourceAsReader(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder()
				.build(reader);
		session = sqlMapper.openSession();
		try{
			//测试增加
			JiKeUser jku=new JiKeUser(); 
			jku.setUserName("jike002");
			jku.setPassword("123456");
			session.insert("insertUser", jku);
			System.out.println(jku.getId());
			//测试更新
			/*JiKeUser jku2=new JiKeUser();
			jku2.setUserName("jike00100");
			jku2.setPassword("666666");
			jku2.setId(2);
			session.update("updateUser", jku2);*/
			//测试删除
			/*InterfaceJiKeUserMap ijum=session.getMapper(InterfaceJiKeUserMap.class);
			ijum.deleteUser(1);*/
			session.commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		
	}
}
