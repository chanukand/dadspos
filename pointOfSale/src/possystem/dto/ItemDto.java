/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package possystem.dto;

/**
 *
 * @author Lochana
 */
public class ItemDto extends SuperDTO{

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public ItemDto(String code, String name, String description, String remark, int user, int cateId, double cost, double price, int id, String categoryName) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.remark = remark;
        this.user = user;
        this.cateId = cateId;
        this.cost = cost;
        this.price = price;
        this.id = id;
        this.categoryName = categoryName;
    }

    public ItemDto(String code, String name, String description, String remark, int user, int cateId, double cost, double price, int id) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.remark = remark;
        this.user = user;
        this.cateId = cateId;
        this.cost = cost;
        this.price = price;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getCateId() {
        return cateId;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    private String code;
    private String name;
    private String description;
    private String remark;
    private int user;
    private int cateId;
    private double cost;
    private double price;
    private int id;
    private String categoryName;
}

    