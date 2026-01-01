package cn.edu.sdju.soft.emp.bean;

public class Emp {
    private int id;
    private String name;
    private String sex;
    private String dept;

    public Emp(int id, String name, String sex, String dept) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.dept = dept;
    }

    public Emp() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
}
