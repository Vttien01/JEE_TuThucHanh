package com.ute.jee_tuthuchanh.models;

import com.ute.jee_tuthuchanh.beans.Category;
import com.ute.jee_tuthuchanh.utils.DbUtils;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class CategoryModel {
//    public static List<Category> findAll(){
//        return new ArrayList<>(
//                Arrays.asList(
//                        new Category(1,"Sách"),
//                        new Category(2,"Quần"),
//                        new Category(3,"Áo"),
//                        new Category(4,"Laptop"),
//                        new Category(5,"TV")
//                )
//        );

    public static List<Category> findAll() {
        Sql2o sql2o = new Sql2o("jdbc:mysql://localhost:3306/qlbh", "root", "");
        try (Connection con = sql2o.open()) {
            final String query = "SELECT * from categories";
            return con.createQuery(query)
                    .executeAndFetch(Category.class);
        }
    }
    public static void add(Category c) {
        String insertSql = "insert into categories(CatName) values (:CatName)";
        try (Connection con = DbUtils.getConnection()) {
            con.createQuery(insertSql)
                    .addParameter("CatName", c.getCatName())
                    .executeUpdate();
        }
    }
}
