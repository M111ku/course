package com.edu.service;

import com.edu.mapper.ProcessMapper;
import com.edu.pojo.Process;
import com.edu.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class ProcessService {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * 创建默认审批流
     * @param process
     */
    public void addDefault(Process process){
        //获取sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取UserMapper
        ProcessMapper processmapper = sqlSession.getMapper(ProcessMapper.class);
        //调用方法
        processmapper.addDefault(process);
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }


    /**
     * 更新审批流
     * @param process
     */
    public void updateProcess(Process process){
        //获取sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取UserMapper
        ProcessMapper processmapper = sqlSession.getMapper(ProcessMapper.class);
        //调用方法
        processmapper.updateProcess(process);
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    public Process selectByCid(String cid) {
        //获取sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取UserMapper
        ProcessMapper processmapper = sqlSession.getMapper(ProcessMapper.class);
        //调用方法
        Process process =  processmapper.selectBycid(cid);
        //提交事务
        sqlSession.close();
        return process;
    }
}
