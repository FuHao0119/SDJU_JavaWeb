package cn.edu.sdju.soft.emp.servlet;

import cn.edu.sdju.soft.emp.bean.Emp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ListEmpServlet")
public class ListEmpServlet extends HttpServlet {

    static List<Emp> empList = new ArrayList<>();

    // 添加数据到列表中
    boolean add(Emp... emps){
        this.empList.clear(); // 每次刷新页面清空原数组 不然会无限增加数据
        for (Emp emp : emps) {
            empList.add(emp);
        }
        return true;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");

        // 添加数据进去
        Emp emp1= new Emp(1,"libai","M","hr");
        Emp emp2= new Emp(2,"Dufu","F","finance");
        Emp emp3= new Emp(3,"Baijuyi","M","trade");
        Emp emp4= new Emp(4,"Liuzongyuan","F","trade");
        this.add(emp1,emp2,emp3,emp4);

        req.setAttribute("empList",empList);

        req.getRequestDispatcher("/listEmp.jsp").forward(req,resp);
    }
}
