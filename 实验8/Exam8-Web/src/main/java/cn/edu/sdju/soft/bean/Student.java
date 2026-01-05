package cn.edu.sdju.soft.bean;

public class Student {
    private Integer id;
    private String stuName;
    private String major;
    private String dormitory;

    public Student() {
    }

    public Student(Integer id, String stuName, String major, String dormitory) {
        this.id = id;
        this.stuName = stuName;
        this.major = major;
        this.dormitory = dormitory;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getDormitory() {
        return dormitory;
    }

    public void setDormitory(String dormitory) {
        this.dormitory = dormitory;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", stuName='" + stuName + '\'' +
                ", major='" + major + '\'' +
                ", dormitory='" + dormitory + '\'' +
                '}';
    }
}
