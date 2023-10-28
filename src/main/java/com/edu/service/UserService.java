package com.edu.service;

import com.edu.mapper.UserMapper;
import com.edu.pojo.User;
import com.edu.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserService {

    //调用Usermapper
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();


    /**
     * 查询用户名对应用户信息
     * @param username
     * @return
     */
    public User selectByUsername(String username){


        //获取sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取UserMapper
        UserMapper usermapper = sqlSession.getMapper(UserMapper.class);
        //调用方法
        User user = usermapper.selectByUsername(username);

        sqlSession.close();

        return user;
    }

    /**
     * 查询用户id的信息
     * @param username
     * @return
     */
    public User selectByUid(String username){


        //获取sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取UserMapper
        UserMapper usermapper = sqlSession.getMapper(UserMapper.class);
        //调用方法
        User user = usermapper.selectByUid(username);

        sqlSession.close();

        return user;
    }


    public User selectTeacherByUid(String uid){


        //获取sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取UserMapper
        UserMapper usermapper = sqlSession.getMapper(UserMapper.class);
        //调用方法
        User user = usermapper.selectTeacherByUid(uid);

        sqlSession.close();

        return user;
    }



    /**
     * 查找所有用户
     * @return
     */
    public List<User> selectAllUsers(){
        //获取sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取UserMapper
        UserMapper usermapper = sqlSession.getMapper(UserMapper.class);
        //调用方法
        List<User> userList = usermapper.selectAllUsers();

        sqlSession.close();

        return userList;
    }

    /**
     * 删除对应id用户
     * @param uid
     */
    public void deleteById(String uid){
        //获取sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取UserMapper
        UserMapper usermapper = sqlSession.getMapper(UserMapper.class);
        //调用方法
        usermapper.deleteById(uid);
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 新增用户
     * @param user
     */
    public void addUser(User user){
        //获取sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取UserMapper
        UserMapper usermapper = sqlSession.getMapper(UserMapper.class);
        //调用方法
        usermapper.addUser(user);
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }



    /**
     * 查找教师用户
     * @return
     */
    public List<User> selectTeacher(){
        //获取sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取UserMapper
        UserMapper usermapper = sqlSession.getMapper(UserMapper.class);
        //调用方法
        List<User> userList = usermapper.selectTeacher();

        sqlSession.close();

        return userList;
    }



}
