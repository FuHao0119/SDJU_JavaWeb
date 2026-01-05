package cn.edu.sdju.soft.bean;

import java.util.List;

public class StudentWithCourse extends Student {
    private List<Course> courses;

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "StudentWithCourse{" +
                "id=" + getId() +
                ", stuName='" + getStuName() + '\'' +
                ", major='" + getMajor() + '\'' +
                ", dormitory='" + getDormitory() + '\'' +
                ", courses=" + courses +
                '}';
    }
}
