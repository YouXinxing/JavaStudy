package jike.book.test;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;

import jike.book.pojo.JiKeUser;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 测试简单查询
 * @author wsdhr
 *
 */
public class TestSelect {

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
			//hashmap传入参数测试
			/*HashMap<String,String> hm=new HashMap();
			hm.put("userName", "jike00100");
			hm.put("password","666666");
			JiKeUser temp=session.selectOne("loginSelect",hm);
			if(temp!=null)
			{
				System.out.println("登陆成功！");
			}*/
			//对象传入参数测试
			/*JiKeUser jku=new JiKeUser();
			jku.setUserName("jike00100");
			jku.setPassword("666666");
			JiKeUser temp=session.selectOne("login2",jku);
			if(temp!=null)
			{
				System.out.println("登陆成功！");
			}*/
			//多行记录查询测试
			//List<JiKeUser> ap=session.selectList("selectJiKeUserList");
			List<JiKeUser> ap=session.selectList("selectUsers");
			for(JiKeUser temp:ap) {
				System.out.println("用户名="+temp.getUserName()); 
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
