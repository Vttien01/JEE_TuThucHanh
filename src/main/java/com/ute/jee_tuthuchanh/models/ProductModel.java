package com.ute.jee_tuthuchanh.models;

import com.ute.jee_tuthuchanh.beans.Category;
import com.ute.jee_tuthuchanh.beans.Product;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class ProductModel {

    public static List<Product> findAll() {
        Sql2o sql2o = new Sql2o("jdbc:mysql://localhost:3306/qlbh", "root", "");
        try (Connection con = sql2o.open()) {
            final String query = "SELECT * from products";
            return con.createQuery(query)
                    .executeAndFetch(Product.class);
        }
    }



}
