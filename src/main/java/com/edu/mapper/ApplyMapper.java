package com.edu.mapper;

import com.edu.pojo.Apply;
import com.edu.pojo.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ApplyMapper {
    /**
     * 申请课程
     * @param apply
     */
    void addApply(Apply apply);

    /**
     *查询对应uid的全部申请
     * @return
     */
    List<Apply> selectApplyByStudentid(String studentid);

    /**
     * 学生删除申请
     * @param studentid
     */
    void deleteApply(@Param("studentid") String studentid, @Param("courseid") String courseid);

    /**
     * 更新申请原因状态证明
     * @param apply
     */
    void updateApply(Apply apply);

    /**
     * 找到对应申请
     * @param courseid
     * @param studentid
     * @return
     */
    Apply selectByCidAndSid(@Param("courseid") String courseid,@Param("studentid") String studentid);

    /**
     * 学生的所有申请查询
     * @param studentid
     * @return
     */
    List<Apply> selectAllApply(String studentid);

    /**
     * 找到老师的申请
     * @param first
     * @param second
     * @return
     */
    List<Apply> selectTeacherApply(@Param("first") String first,@Param("second") String second);

    /**
     * 教师分页查询
     * @param name
     * @param begin
     * @param size
     * @return
     */
    List<Apply> selectTeacherApplyByPage(@Param("name") String name, @Param("begin") int begin, @Param("size") int size);

    /**
     * 教师总数查询
     * @return
     */
    int selectTeacherApplyTotalCount(String name);


    /**
     * 管理员查询所有
     */
    List<Apply> selectAll();


    /**
     * 学生分页查询
     * @param studentid
     * @param begin
     * @param size
     * @return
     */
    List<Apply> selectStudentApplyByPage(@Param("studentid") String studentid, @Param("begin")int begin, @Param("size")int size);
    /**
     * 学生查询申请总数
     * @param studentid
     * @return
     */
    int selectStudentApplyTotalCount(String studentid);

    /**
     * 多条件查询
     * @param courseid
     * @param studentid
     * @return
     */
    List<Apply> selectMultip(@Param("courseid") String courseid,@Param("studentid") String studentid,@Param("state") String state);

    /**
     * 导出已通过申请
     * @return
     */
    List<Apply> selectStateIsFiveOrSeven();
}
