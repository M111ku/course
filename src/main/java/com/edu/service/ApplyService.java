package com.edu.service;

import com.edu.mapper.ApplyMapper;
import com.edu.mapper.CourseMapper;
import com.edu.pojo.Apply;
import com.edu.pojo.Course;
import com.edu.pojo.PageBean;
import com.edu.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.ArrayList;
import java.util.List;

public class ApplyService {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();


    /**
     * 新增申请
     * @param apply
     */
    public void addApply(Apply apply){
        //获取sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取UserMapper
        ApplyMapper mapper = sqlSession.getMapper(ApplyMapper.class);
        //调用方法
        mapper.addApply(apply);
        sqlSession.commit();
        sqlSession.close();
    }


    /**
     * 查找学生的所有申请
     * @param studentid
     * @return
     */
    public List<Apply> selectByStudentId(String studentid){
        //获取sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取UserMapper
        ApplyMapper mapper = sqlSession.getMapper(ApplyMapper.class);
        //调用方法
        List<Apply> applyList = mapper.selectApplyByStudentid(studentid);
        sqlSession.close();
        return applyList;
    }

    /**
     * 进度查询状态为2-6
     * @param studentId
     * @return
     */
    public List<Apply> selectStudentApplyStateIsTwoToSix(String studentId){
        List<Apply> applyList = selectByStudentId(studentId);
        List<Apply> list = new ArrayList<Apply>();
        for(Apply apply: applyList){
            if(apply.getState().equals("2")
                    ||apply.getState().equals("3")
                    ||apply.getState().equals("4")
                    ||apply.getState().equals("5")
                    ||apply.getState().equals("6")
            ){
                list.add(apply);
            }
        }
        return list;
    }

    /**
     *进度查询状态为2-4
     * @param studentId
     * @return
     */
    public List<Apply> selectStudentApplyStateIsTwoToFour(String studentId){
        List<Apply> applyList = selectByStudentId(studentId);
        List<Apply> list = new ArrayList<Apply>();
        for(Apply apply: applyList){
            if(apply.getState().equals("2")
                    ||apply.getState().equals("3")
                    ||apply.getState().equals("4")
            ){
                list.add(apply);
            }
        }
        return list;
    }

    /**
     * 进度查询状态为5/6
     * @param studentId
     * @return
     */
    public List<Apply> selectStudentApplyStateIsFiveToSix(String studentId){
        List<Apply> applyList = selectByStudentId(studentId);
        List<Apply> list = new ArrayList<Apply>();
        for(Apply apply: applyList){
            if(apply.getState().equals("5")
                    ||apply.getState().equals("6")
            ){
                list.add(apply);
            }
        }
        return list;
    }




    /**
     * 删除
     * @param studentId
     * @param courseId
     */
    public void deleteApply(String studentId,String courseId){
        //获取sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取UserMapper
        ApplyMapper mapper = sqlSession.getMapper(ApplyMapper.class);
        //调用方法
        mapper.deleteApply(studentId,courseId);
        sqlSession.commit();
        sqlSession.close();
    }


    /**
     * 更新
     * @param apply
     */
    public void updateApply(Apply apply){
        //获取sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取UserMapper
        ApplyMapper mapper = sqlSession.getMapper(ApplyMapper.class);
        //调用方法
        mapper.updateApply(apply);
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 找到对应申请
     * @param cid
     * @param sid
     * @return
     */
    public Apply selectByCidAndSid(String cid ,String sid){
        //获取sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取UserMapper
        ApplyMapper mapper = sqlSession.getMapper(ApplyMapper.class);
        //调用方法
        Apply apply = mapper.selectByCidAndSid(cid,sid);

        sqlSession.close();

        return apply;
    }

    /**
     * 查询学生所有申请
     * @param uid
     * @return
     */
    public List<Apply> selectStudentApply(String uid) {
        //获取sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取UserMapper
        ApplyMapper mapper = sqlSession.getMapper(ApplyMapper.class);
        //调用方法
        List <Apply> applyList = mapper.selectAllApply(uid);

        sqlSession.close();

        return applyList;
    }

    public PageBean<Apply> selectStudentApplyByPage(String uid,int currentPage, int pageSize) {
        //获取sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取UserMapper
        ApplyMapper mapper = sqlSession.getMapper(ApplyMapper.class);

        int begin = (currentPage - 1) *pageSize;
        int size = pageSize;

        List<Apply> courseList = mapper.selectStudentApplyByPage(uid,begin,size);

        int totalCount = mapper.selectStudentApplyTotalCount(uid);

        //封装pageBean对象
        PageBean<Apply> pageBean = new PageBean<Apply>();
        pageBean.setRows(courseList);
        pageBean.setTotalCount(totalCount);

        return pageBean;
    }


    /**
     * 查询教师审批列表
     * @param first
     * @param second
     * @return
     */
    public List<Apply> selectTeacherApply(String first,String second) {
        //获取sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取UserMapper
        ApplyMapper mapper = sqlSession.getMapper(ApplyMapper.class);
        //调用方法
        List <Apply> applyList = mapper.selectTeacherApply(first,second);


        List <Apply> applyList1 = new ArrayList<Apply>();
        for(Apply apply:applyList){
            if(apply.getFirst().equals(first) && apply.getState().equals("2")){
                applyList1.add(apply);
            }else if(apply.getSecond().equals(first) && apply.getState().equals("3")){
                applyList1.add(apply);
                continue;
            }
        }
        sqlSession.close();
        return applyList1;
    }


    /**
     * 查询申请完成的课程，用于教师的申请查看
     * @param first
     * @param second
     * @return
     */
    public List<Apply> selectTeacherApplyStateIsEight(String first,String second) {
        //获取sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取UserMapper
        ApplyMapper mapper = sqlSession.getMapper(ApplyMapper.class);
        //调用方法
        List <Apply> applyList = mapper.selectTeacherApply(first,second);

        //循环找到驳回已确认的课程
        List <Apply> applyList1 = new ArrayList<Apply>();
        for(Apply apply:applyList){
            if(apply.getState().equals("8")){
                applyList1.add(apply);
            }
        }
        sqlSession.close();
        return applyList1;
    }


    /**
     * 教师的分页查询，可查询所有与该教师相关的申请
     * @param uid
     * @param currentPage
     * @param pageSize
     * @return
     */
    public PageBean<Apply> selectTeacherApplyByPage(String uid,int currentPage, int pageSize){
        //获取sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取UserMapper
        ApplyMapper mapper = sqlSession.getMapper(ApplyMapper.class);

        int begin = (currentPage - 1) *pageSize;
        int size = pageSize;

        List<Apply> courseList = mapper.selectTeacherApplyByPage(uid,begin,size);

        int totalCount = mapper.selectTeacherApplyTotalCount(uid);

        //封装pageBean对象
        PageBean<Apply> pageBean = new PageBean<Apply>();
        pageBean.setRows(courseList);
        pageBean.setTotalCount(totalCount);

        return pageBean;
    }

    /**
     * 管理员查询所有的申请
     * @return
     */
    public List<Apply> selectAll(){
        //获取sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取UserMapper
        ApplyMapper mapper = sqlSession.getMapper(ApplyMapper.class);

        //调用
        List<Apply> applyList = mapper.selectAll();

        sqlSession.close();
        return applyList;
    }


    /**
     * 多条件查询
     * @return
     */
    public List<Apply> selectMultip(String cid,String uid,String state){
        //获取sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取UserMapper
        ApplyMapper mapper = sqlSession.getMapper(ApplyMapper.class);
        if(cid == null){
            cid = "";
        }
        if(uid == null){
            uid = "";
        }
        if(state == null){
            state = "";
        }
        cid = "%" + cid + "%";
        uid = "%" + uid + "%";
        state = "%" + state + "%";
        //调用
        List<Apply> applyList = mapper.selectMultip(cid,uid,state);

        sqlSession.close();
        return applyList;
    }

    /**
     * 导出已申请通过记录
     * @return
     */
    public List<Apply> selectStateIsFiveOrSeven(){
        //获取sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取UserMapper
        ApplyMapper mapper = sqlSession.getMapper(ApplyMapper.class);

        //调用
        List<Apply> applyList = mapper.selectStateIsFiveOrSeven();

        sqlSession.close();
        return applyList;
    }

}
