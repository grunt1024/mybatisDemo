package com.github.mybatisDemo;

import com.github.mybatisDemo.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

/**
 * @author : zhanghua
 * @date : 2023/1/29
 */
public class MybatisDemo {

	public static void main(String[] args) throws IOException {
		String resourcePath = "./Mybatis-config.xml";

		InputStream inputStream = Resources.getResourceAsStream(resourcePath);

		SqlSessionFactoryBuilder sessionFactoryBuilder = new SqlSessionFactoryBuilder();

		//读取配置信息, 构建sqlSessionFactory实例
		SqlSessionFactory sqlSessionFactory = sessionFactoryBuilder.build(inputStream);

		//创建一次会话
		SqlSession sqlSession = sqlSessionFactory.openSession();

		Long id = 1L;
		List<User> list = sqlSession.selectList("com.github.mybatisDemo.mapper.UserMapper.selectByPrimaryKey",id);
		for (User user : list){
			System.out.println("username : " + user.getName());
		}

		sqlSession.close();
	}
}
