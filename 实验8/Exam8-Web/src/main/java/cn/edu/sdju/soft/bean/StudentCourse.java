package cn.edu.sdju.soft.bean;

public class StudentCourse {
    private Integer id;
    private Integer stuId;
    private Integer courseId;

    public StudentCourse() {
    }

    public StudentCourse(Integer id, Integer stuId, Integer courseId) {
        this.id = id;
        this.stuId = stuId;
        this.courseId = courseId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "StudentCourse{" +
                "id=" + id +
                ", stuId=" + stuId +
                ", courseId=" + courseId +
                '}';
    }
}