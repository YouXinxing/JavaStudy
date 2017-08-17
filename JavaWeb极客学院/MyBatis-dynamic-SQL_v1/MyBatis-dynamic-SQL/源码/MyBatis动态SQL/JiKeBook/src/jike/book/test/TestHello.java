package jike.book.test;

import java.io.IOException;
import java.io.Reader;

import jike.book.pojo.JiKeUser;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
/**
 * 测试hello
 * @author wsdhr
 *
 */
public class TestHello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String resource = "jike/book/map/MyBatisConfig.xml";//基本配置文件相对路径
		Reader reader = null;
		SqlSession session;
		try {
			reader = Resources.getResourceAsReader(resource);//读取基本配置文件
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder()
				.build(reader);//建立session工厂
		session = sqlMapper.openSession();//打开session
		JiKeUser temp = session.selectOne("findById", 1);//单行查询
		System.out.println(temp.getUserName());
		session.close();
	}

}
