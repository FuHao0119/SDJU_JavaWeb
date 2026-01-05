package cn.edu.sdju.soft.dao;

import cn.edu.sdju.soft.bean.StudentCourse;

import java.util.List;

public interface StudentCourseMapper {
    int insertStudentCourse(StudentCourse studentCourse);
    List<StudentCourse> selectAllStudentCourses();
}
