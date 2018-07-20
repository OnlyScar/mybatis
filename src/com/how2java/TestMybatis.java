package com.how2java;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.how2java.pojo.Category;

/** 
 * @author  xiaomingHe
 * @date 创建时间：2018年7月20日 上午9:46:17 
 * @description
 */
public class TestMybatis {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = ssf.openSession();
        
       /* Category c = new Category();
        c.setName("addCategory4");
        session.insert("addCategory",c);
        
        c.setId(1);
        session.delete("delCategory",c);
        
        Category cc = session.selectOne("getCategory",3);
        System.out.println(cc.getName());
        
        cc.setName("modify name");
        session.update("updateCategory",cc);*/
        
        //listAll(session);
        
        /*List<Category> cs = session.selectList("listCategoryByName","cat");
        for (Category c : cs) {
            System.out.println(c.getName());
        }*/
        
        Map<String,Object> params = new HashMap<>();
        params.put("id", 7);
        params.put("name", "cat");
        List<Category> cs = session.selectList("listCategoryByIdAndName",params);
        for (Category c : cs) {
            System.out.println(c.getName());
        }
        
        session.commit();
        session.close();
        
     /*   List<Product> ps = session.selectList("listProduct");
        for (Product p : ps) {
            System.out.println("name: "+p.getName() +" price: "+ p.getPrice());
        }*/
    }
    
    private static void listAll(SqlSession session) {
        List<Category> cs = session.selectList("listCategory");
        for (Category c : cs) {
            System.out.println(c.getName());
        }        
    }
    
}
