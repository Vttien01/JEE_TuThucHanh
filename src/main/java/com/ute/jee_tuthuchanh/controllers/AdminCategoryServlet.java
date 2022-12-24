package com.ute.jee_tuthuchanh.controllers;

import com.ute.jee_tuthuchanh.beans.Category;
import com.ute.jee_tuthuchanh.models.CategoryModel;
import com.ute.jee_tuthuchanh.utils.ServletUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminCategoryServlet", value = "/Admin/Category/*")
public class AdminCategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getPathInfo();//lay thong nguoi dung go
        if (path == null || path.equals("/")){
            path = "/Index";
        }
        switch (path) {
            case "/Index":
//                request.setAttribute("category",c);
//                Đẩy dữ liệu bất kì ra ngoài view
                List<Category> list = CategoryModel.findAll();
                request.setAttribute("categories",list);
                ServletUtils.forward("/views/vwCategory/Index.jsp",request,response);
                break;
            case "/Add":
                ServletUtils.forward("/views/vwCategory/Add.jsp",request,response);
                break;
                default:
                    ServletUtils.forward("/views/404.jsp",request,response);
                    break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getPathInfo();//lay thong nguoi dung go
        switch (path) {
            case "/Add":
                String name = request.getParameter("CatName");
                Category c = new Category(name);
                CategoryModel.add(c);
                ServletUtils.forward("/views/vwCategory/Index.jsp",request,response);
                break;
            default:
                ServletUtils.forward("/views/404.jsp",request,response);
                break;
        }
    }
}
