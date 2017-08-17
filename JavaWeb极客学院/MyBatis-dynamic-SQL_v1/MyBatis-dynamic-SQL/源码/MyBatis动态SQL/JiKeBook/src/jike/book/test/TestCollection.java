package jike.book.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import jike.book.pojo.Author;
import jike.book.pojo.JiKeUser;
import jike.book.pojo.Visit;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
/**
 * 测试集合查询
 * @author wsdhr
 *
 */
public class TestCollection {

	public static void main(String[] args) {
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
			List<JiKeUser> ap=session.selectList("selectVisit"); 
			for(JiKeUser temp:ap) {
				System.out.println("用户名="+temp.getUserName());
				for(Visit oneVisit:temp.getVisitList())
				{
					System.out.println("登录时间="+oneVisit.getVisitDate()+
							"登录IP="+oneVisit.getVisitIP());
				}	
			}
			
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
