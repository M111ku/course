package com.edu.service;

import com.edu.mapper.TakesMapper;
import com.edu.mapper.UserMapper;
import com.edu.pojo.Takes;
import com.edu.pojo.User;
import com.edu.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class TakesService {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public List<Takes> selectApplyCourse(String studentid){
        //获取sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取UserMapper
        TakesMapper mapper = sqlSession.getMapper(TakesMapper.class);
        //调用方法
        List<Takes> takesList = mapper.selectCourseByUid(studentid);

        sqlSession.close();

        return takesList;
    }
}
