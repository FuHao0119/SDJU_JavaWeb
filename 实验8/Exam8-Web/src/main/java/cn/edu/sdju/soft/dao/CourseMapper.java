package cn.edu.sdju.soft.dao;

import cn.edu.sdju.soft.bean.Course;

import java.util.List;

public interface CourseMapper {
    int insertCourse(Course course);
    List<Course> selectAllCourses();
}
