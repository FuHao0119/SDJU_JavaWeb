package cn.edu.sdju.soft.test;

import cn.edu.sdju.soft.bean.Course;
import cn.edu.sdju.soft.bean.Student;
import cn.edu.sdju.soft.bean.StudentCourse;
import cn.edu.sdju.soft.bean.StudentWithCourse;
import cn.edu.sdju.soft.dao.CourseMapper;
import cn.edu.sdju.soft.dao.StudentCourseMapper;
import cn.edu.sdju.soft.dao.StudentMapper;
import cn.edu.sdju.soft.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class StudentCourseTest {

    @Test
    public void testSelectByNo() throws FileNotFoundException {
        SqlSession session = MybatisUtil.getSession();
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);
        StudentWithCourse stuCourse = studentMapper.getStuCourse(1);
        System.out.println(stuCourse);
        session.close();
    }

    @Test
    public void insertDataBatch() throws IOException {
        SqlSession sqlSession = MybatisUtil.getSession();
        // 获取Mapper
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);
        StudentCourseMapper studentCourseMapper = sqlSession.getMapper(StudentCourseMapper.class);

        Student student1 = new Student(null, "张三", "计算机科学", "A101");
        Student student2 = new Student(null, "李四", "软件工程", "A102");
        Student student3 = new Student(null, "王五", "数据科学", "B201");
        Student student4 = new Student(null, "赵六", "人工智能", "B202");

        studentMapper.insertStudent(student1);
        studentMapper.insertStudent(student2);
        studentMapper.insertStudent(student3);
        studentMapper.insertStudent(student4);

        System.out.println("学生数据插入完成！");

        // 插入课程数据
        Course course1 = new Course(null, "Java程序设计");
        Course course2 = new Course(null, "数据库原理");
        Course course3 = new Course(null, "数据结构");
        Course course4 = new Course(null, "操作系统");
        Course course5 = new Course(null, "计算机网络");

        courseMapper.insertCourse(course1);
        courseMapper.insertCourse(course2);
        courseMapper.insertCourse(course3);
        courseMapper.insertCourse(course4);
        courseMapper.insertCourse(course5);

        System.out.println("课程数据插入完成！");

        // 插入学生选课关系数据
        // 张三选Java和数据库
        studentCourseMapper.insertStudentCourse(new StudentCourse(null, student1.getId(), course1.getId()));
        studentCourseMapper.insertStudentCourse(new StudentCourse(null, student1.getId(), course2.getId()));

        // 李四选数据结构、操作系统和计算机网络
        studentCourseMapper.insertStudentCourse(new StudentCourse(null, student2.getId(), course3.getId()));
        studentCourseMapper.insertStudentCourse(new StudentCourse(null, student2.getId(), course4.getId()));
        studentCourseMapper.insertStudentCourse(new StudentCourse(null, student2.getId(), course5.getId()));

        // 王五选Java和数据结构
        studentCourseMapper.insertStudentCourse(new StudentCourse(null, student3.getId(), course1.getId()));
        studentCourseMapper.insertStudentCourse(new StudentCourse(null, student3.getId(), course3.getId()));

        // 赵六选所有课程
        studentCourseMapper.insertStudentCourse(new StudentCourse(null, student4.getId(), course1.getId()));
        studentCourseMapper.insertStudentCourse(new StudentCourse(null, student4.getId(), course2.getId()));
        studentCourseMapper.insertStudentCourse(new StudentCourse(null, student4.getId(), course3.getId()));
        studentCourseMapper.insertStudentCourse(new StudentCourse(null, student4.getId(), course4.getId()));
        studentCourseMapper.insertStudentCourse(new StudentCourse(null, student4.getId(), course5.getId()));

        System.out.println("选课关系数据插入完成！");

        sqlSession.commit();
        sqlSession.close();
    }

}
