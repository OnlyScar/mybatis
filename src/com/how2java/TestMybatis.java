package com.how2java;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.how2java.pojo.Category;
import com.how2java.pojo.Order;
import com.how2java.pojo.OrderItem;

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
        
        //更多查询
        /*List<Category> cs = session.selectList("listCategoryByName","cat");
        for (Category c : cs) {
            System.out.println(c.getName());
        }*/
        
       /* Map<String,Object> params = new HashMap<>();
        params.put("id", 7);
        params.put("name", "cat");
        List<Category> cs = session.selectList("listCategoryByIdAndName",params);
        for (Category c : cs) {
            System.out.println(c.getName());
        }*/
        
        //一对多关系
      /*  List<Category> cs = session.selectList("listCategoryJoinProduct");
        for (Category c : cs) {
            System.out.println(c);
            List<Product> ps = c.getProducts();
            for (Product p : ps) {
                System.out.println("\t" + p);
            }
        }*/
        
        //多对多关系
        listOrder(session);
        
        
        
        session.commit();
        session.close();
        
     /*   List<Product> ps = session.selectList("listProduct");
        for (Product p : ps) {
            System.out.println("name: "+p.getName() +" price: "+ p.getPrice());
        }*/
    }
    
    private static void listOrder(SqlSession session) {
    	List<Order> os = session.selectList("listOrder");
		for (Order o : os) {
			System.out.println(o.getCode());
			List<OrderItem> ois = o.getOrderItems();
			for (OrderItem oi : ois) {
				System.out.format("\t%s\t%f\t%d%n", oi.getProduct().getName(),oi.getProduct().getPrice(),oi.getNumber());
			}
			
		}
    	
	}

	private static void listAll(SqlSession session) {
        List<Category> cs = session.selectList("listCategory");
        for (Category c : cs) {
            System.out.println(c.getName());
        }        
    }
    
}
