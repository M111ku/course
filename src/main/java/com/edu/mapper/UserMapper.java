package com.edu.mapper;

import com.edu.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    /**
     * 查询所有用户
     * @return
     */
    List<User> selectAllUsers();

    /**
     * 查询用户名对应用户信息
     * @param username
     * @return
     */
    User selectByUsername(String username);

    /**
     * 删除对应id的用户
     */
    void deleteById(String uid);

    /**
     * 新增用户
     */
    void addUser(User user);

    /**
     * 更新信息
     * @param user
     */
    void updateUser(User user);

    /**
     * 查找所有教师
     * @return
     */
    List<User> selectTeacher();

    /**
     * 用用户uid寻找用户信息
     * @param uid
     * @return
     */
    User selectByUid(String uid);


    /**
     * 查询教师
     * @param uid
     * @return
     */
    User selectTeacherByUid(String uid);
}
