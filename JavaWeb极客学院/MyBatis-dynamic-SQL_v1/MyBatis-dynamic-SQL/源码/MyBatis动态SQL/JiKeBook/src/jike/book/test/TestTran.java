package jike.book.test;

import java.io.IOException;
import java.io.Reader;

import jike.book.pojo.Author;
import jike.book.pojo.JiKeUser;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
/**
 * 事务测试
 * @author wsdhr
 *
 */
public class TestTran {

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
		session = sqlMapper.openSession(false);//不使用自动提交
		try{
			JiKeUser one=new JiKeUser();
			one.setUserName("author001");
			one.setPassword("123456");
			session.insert("insertUser",one);
			System.out.println("新加入的user id="+one.getId());
			
			Author at=new Author();
			at.setJikeUser(one);
			at.setRealName("一个大牛");
			session.insert("insertAuthor", at);
			session.commit();//事务提交

		}
		catch(Exception e)
		{
			e.printStackTrace();
			session.rollback();//回滚
		}
		finally
		{
			session.close();//关闭session
		}
	}

}
