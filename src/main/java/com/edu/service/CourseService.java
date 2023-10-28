package com.edu.service;

import com.edu.mapper.CourseMapper;
import com.edu.mapper.UserMapper;
import com.edu.pojo.Course;
import com.edu.pojo.PageBean;
import com.edu.pojo.User;
import com.edu.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class CourseService {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * 查询所有课程信息
     * @return
     */
    public List<Course> selectAll(){
        //获取sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取UserMapper
        CourseMapper coursemapper = sqlSession.getMapper(CourseMapper.class);
        //调用方法
        List<Course> courseList = coursemapper.selectAll();
        sqlSession.close();
        return courseList;
    }

    /**
     * 删除课程
     * @param cid
     */
    public void deleteCourse(String cid){
        //获取sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取UserMapper
        CourseMapper coursemapper = sqlSession.getMapper(CourseMapper.class);
        //调用方法
        coursemapper.deleteCourse(cid);
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 新增课程
     * @param course
     */
    public void addCourse(Course course){
        //获取sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取UserMapper
        CourseMapper coursemapper = sqlSession.getMapper(CourseMapper.class);
        //调用方法
        coursemapper.addCourse(course);
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 查询对应课程编号的课程
     * @param cid
     * @return
     */
    public Course selectByCid(String cid){
        //获取sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取UserMapper
        CourseMapper coursemapper = sqlSession.getMapper(CourseMapper.class);
        //调用方法
        Course course = coursemapper.selectByCid(cid);
        sqlSession.close();
        return course;
    }

    /**
     * 分页查询
     * @param currentPage 当前页码
     * @param pageSize 每页显示条数
     * @return
     */
    public PageBean<Course> selectByPage(int currentPage, int pageSize){
        //获取sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取UserMapper
        CourseMapper coursemapper = sqlSession.getMapper(CourseMapper.class);

        int begin = (currentPage - 1) *pageSize;
        int size = pageSize;

        List<Course> courseList = coursemapper.selectByPage(begin,size);

        int totalCount = coursemapper.selectTotalCount();

        //封装pageBean对象
        PageBean<Course> pageBean = new PageBean<Course>();
        pageBean.setRows(courseList);
        pageBean.setTotalCount(totalCount);

        return pageBean;
    }



}
