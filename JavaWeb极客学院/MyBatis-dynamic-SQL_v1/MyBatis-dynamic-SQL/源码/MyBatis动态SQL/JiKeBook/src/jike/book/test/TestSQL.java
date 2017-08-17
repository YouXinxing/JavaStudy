package jike.book.test;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import jike.book.pojo.JiKeReader;
import jike.book.pojo.JiKeUser;

public class TestSQL {

	public static void main(String[] args) {
		String resource = "jike/book/map/mybatisConfig.xml";
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
			//动态SQL if
			/*JiKeReader oneReader=new JiKeReader();
			//oneReader.setMoney(200);
			List<JiKeReader> ap=
					session.selectList("selectReaderMoney",oneReader);
			for(JiKeReader temp:ap) {		
				System.out.println("用户ID="+temp.getReaderID());
			}*/
			//动态SQL之 choose 与where
			/*JiKeUser oneUser=new JiKeUser();
			//oneUser.setUserName("%j%");
			oneUser.setId(10);
			//List<JiKeUser> ap=session.selectList("selectJiKeUserChoose",oneUser);
			//where标记
			List<JiKeUser> ap=session.selectList("selectJiKeUserWhere",oneUser);
			for(JiKeUser temp:ap) {		
				System.out.println("用户ID="+temp.getId()+"用户名="+temp.getUserName());
			}*/
			
			//动态SQL之set与trim
			/*JiKeUser oneUser=new JiKeUser();
			oneUser.setId(10);
			oneUser.setUserName("setchange");
			oneUser.setPassword("8899");
			//set标记
			//session.update("updateJiKeUserSet",oneUser);
			//trim标记
			session.update("updateUserTrim",oneUser);
			session.commit();*/
			
			//动态SQL之foreach 循环查询
			/*ArrayList<Integer> ides=new ArrayList();
			ides.add(2);
			ides.add(8);
			ides.add(9);
			List<JiKeUser> ap=session.selectList("selectJiKeUserForeach", ides);
			for(JiKeUser temp:ap) {		
				System.out.println("用户ID="+temp.getId()+"用户名="+temp.getUserName());
			}*/
			//动态SQL之foreach 循环赋值
			ArrayList<JiKeUser> jkuList=new ArrayList();
			JiKeUser one=new JiKeUser("jt1","8866");
			JiKeUser two=new JiKeUser("jt2","8866");
			jkuList.add(one);
			jkuList.add(two);
			session.insert("insertJiKeUserForeach",jkuList);
			session.commit();
		
		}
		finally
		{
			session.close();	
		}

	}

}
