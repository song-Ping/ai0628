package com.example.test0703.Controller;

import com.example.test0703.dao.PeopleRepository;
import com.example.test0703.dao.PostsRepository;
import com.example.test0703.dao.ProductsRepository;
import com.example.test0703.dto.People;
import com.example.test0703.dto.Product;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

@Controller
public class AController {

    @Autowired
    DataSource ds;//autowired는 객체가져오는 것

    @Autowired
    ProductsRepository productsRepository;

    @Autowired
    PeopleRepository peopleRepository;

    @Autowired
    PostsRepository postsRepository;

    @Autowired
    SqlSession sqlSession;

    @GetMapping("/")
    public String index(Model model) throws IOException {

//        System.out.println(sqlSession.selectList("product.select"));
//        sqlSession.insert("product.insert", new Product(3,"사과우유",1600,3));
//        System.out.println(sqlSession.selectList("product.select"));

//        ArrayList<People> al = new ArrayList<>();//people 테이블
//        ArrayList<Product> products = new ArrayList<>();//products 테이블
//        Connection conn = null;
//        try {
//            conn = ds.getConnection();
//            PreparedStatement pstmt = conn.prepareStatement("select * from people");
//            ResultSet rs = pstmt.executeQuery();
//            while (rs.next()) {
//                String name = rs.getString("name");
//                String age = rs.getString("age");
//                People temp = new People(name, age);
////                temp.setAge(age);
////                temp.setName(name);
//                al.add(temp);
//            }
//            pstmt = conn.prepareStatement("select * from products");
//            rs = pstmt.executeQuery();
//            while (rs.next()) {
//                int idx = rs.getInt("idx");
//                String name = rs.getString("name");
//                int price = rs.getInt("price");
//                int quantity = rs.getInt("quantity");
//                Product p = new Product(idx, name, price, quantity);
//                products.add(p);
//            }
//            pstmt = conn.prepareStatement("select * from posts");
//            rs = pstmt.executeQuery();
//            while (rs.next()) {
//                int idx = rs.getInt("idx");
//                String content = rs.getString("content");
//                Post post = new Post(idx, content);
//                posts.add(post);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (conn != null) try {
//                conn.close();
//            } catch (Exception e) {
//
//            }
//        }
        model.addAttribute("al", peopleRepository.doselect());
        model.addAttribute("products", productsRepository.doSelect());
        model.addAttribute("posts", postsRepository.doSelect());

        return "index";
    }

    @PostMapping("/post")
    public String post(String content, HttpServletRequest request){
        System.out.println("여기로~");
        System.out.println(content);
        postsRepository.doInsert(content);
        return "redirect:/";
    }
}
