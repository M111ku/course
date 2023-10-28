package com.edu.mapper;

import com.edu.pojo.Takes;

import java.util.List;

public interface TakesMapper {
    List<Takes> selectCourseByUid(String studentid);
}
