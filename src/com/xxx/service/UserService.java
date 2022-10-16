package com.xxx.service;

import com.xxx.entity.User;
import com.xxx.entity.vo.MessageModel;
import com.xxx.mapper.UserMapper;
import com.xxx.util.GetsqlSession;
import com.xxx.util.StringUtil;
import org.apache.ibatis.session.SqlSession;

public class UserService {
    public MessageModel userLogin(String uname,String upwd){
        MessageModel messageModel = new MessageModel();
        //参数的非空判断
        if (StringUtil.isEmpty(uname)||StringUtil.isEmpty(upwd)){
            //将状态吗、提示信息、回显数据设置到消息模型对象中，返回消息模型对象
            messageModel.setCode(0);
            messageModel.setMsg("用户姓名和密码不能为空");
            //回显数据
            User u=new User();
            u.setUserName(uname);
            u.setUserPwd(upwd);
            return messageModel;
        }

        //调用dao层的查询方法，通过用户名查询用户对象
        SqlSession session= GetsqlSession.createSqlSession();
        UserMapper userMapper=session.getMapper(UserMapper.class);
        User user=userMapper.queryUserByName(uname);
        //判断用户对象是否为空
        if (user==null){
            //将状态码、提示信息、回显数据设置到消息模型对象中，返回消息模型对象
            messageModel.setCode(0);
            messageModel.setMsg("用户不存在");
            User u=new User();
            u.setUserName(uname);
            u.setUserPwd(upwd);
            return messageModel;
        }
        //判断数据库中查询到的用户密码与前台传递过来的密码作比较
        if (!upwd.equals(user.getUserPwd())){
            messageModel.setCode(0);
            messageModel.setMsg("用户密码不正确");
            return messageModel;
        }
        //登录成功，将用户信息设置到消息模型中
        messageModel.setObject(user);
        return messageModel;
    }
}
