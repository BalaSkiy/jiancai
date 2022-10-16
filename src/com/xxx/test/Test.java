package com.xxx.test;

import com.xxx.entity.User;
import com.xxx.mapper.UserMapper;
import com.xxx.util.GetsqlSession;
import org.apache.ibatis.session.SqlSession;

public class Test {
    public static void main(String[] args) {
        //获取sqlSession对象
        SqlSession session = GetsqlSession.createSqlSession();
        //得到对应Mapper
        UserMapper userMapper = session.getMapper(UserMapper.class);
        //调用方法，返回用户对象
        User user = userMapper.queryUserByName("admin");
        System.out.println(user);
    }
}
