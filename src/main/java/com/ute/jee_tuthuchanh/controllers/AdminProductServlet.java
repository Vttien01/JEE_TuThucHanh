package com.ute.jee_tuthuchanh.controllers;

import com.ute.jee_tuthuchanh.beans.Category;
import com.ute.jee_tuthuchanh.beans.Product;
import com.ute.jee_tuthuchanh.models.CategoryModel;
import com.ute.jee_tuthuchanh.models.ProductModel;
import com.ute.jee_tuthuchanh.utils.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminProductServlet", value = "/Admin/Product/*")
public class AdminProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getPathInfo();//lay thong nguoi dung go
        if (path == null || path.equals("/")){
            path = "/Index";
        }
        switch (path) {
            case "/Index":
                List<Product> list = ProductModel.findAll();
                request.setAttribute("products",list);
                ServletUtils.forward("/views/vwProducts/Index.jsp",request,response);
                break;
                default:
                    ServletUtils.forward("/views/404.jsp",request,response);
                    break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
