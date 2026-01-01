package cn.edu.sdju.soft.emp.servlet;

import cn.edu.sdju.soft.emp.bean.Emp;
import cn.edu.sdju.soft.emp.dao.EmpDao;
import cn.edu.sdju.soft.emp.dao.impl.EmpDaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ListEmpServlet")
public class ListEmpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        EmpDao empDao = new EmpDaoImpl();
        List<Emp> list = new ArrayList<>();
        try {
            list = empDao.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        req.setAttribute("empList",list);

        req.getRequestDispatcher("/listEmp.jsp").forward(req,resp);
    }
}
