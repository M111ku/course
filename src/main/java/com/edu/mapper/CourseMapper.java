package com.edu.mapper;

import com.edu.pojo.Course;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CourseMapper{
    /**
     * 查询所有课程信息
     * @return
     */
    public List<Course> selectAll();

    /**
     * 删除课程
     * @param cid
     */
    void deleteCourse(String cid);


    /**
     * 新增课程
     * @param course
     */
    void addCourse(Course course);

    /**
     * 查找课程
     * @param cid
     * @return
     */
    Course selectByCid(String cid);

    /**
     * 分页查询
     * @param begin
     * @param size
     * @return
     */
    @Select("select * from course limit #{begin} ,#{size}")
    List<Course> selectByPage(@Param("begin") int begin, @Param("size") int size);

    /**
     * 查询总记录数
     * @return
     */
    @Select("select count(*) from course")
    int selectTotalCount();


}
