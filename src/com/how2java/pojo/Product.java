package com.how2java.pojo;
/** 
 * @author  xiaomingHe
 * @date 创建时间：2018年7月20日 上午9:58:23 
 * @description
 */
public class Product {
    int id;
    String name;
    float price;
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
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
    }
    
}
