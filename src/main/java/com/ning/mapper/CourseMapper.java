package com.ning.mapper;

import com.ning.pojo.Course;
import com.ning.utils.MyMapper;

import java.util.List;

public interface CourseMapper extends MyMapper<Course> {
    List<Course> queryThreeCoursesByTime();
    List<Course> queryThreeCoursesByDZ();
    List<Course> queryThreeCoursesByGZ();
}