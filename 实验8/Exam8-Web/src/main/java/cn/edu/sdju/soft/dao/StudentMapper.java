package cn.edu.sdju.soft.dao;

import cn.edu.sdju.soft.bean.Student;
import cn.edu.sdju.soft.bean.StudentWithCourse;

import java.util.List;

public interface StudentMapper {
    int insertStudent(Student student);
    List<Student> selectAllStudents();
    // 根据指定的学生学号，查找出该学生的基本信息及其所选所有课程。
    StudentWithCourse getStuCourse (int stuNo);
}
