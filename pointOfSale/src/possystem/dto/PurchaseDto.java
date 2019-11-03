/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open 
 *the template in the editor.
 */
package possystem.dto;

/**
 * @author Home
 */
public class PurchaseDto extends SuperDTO{

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PurchaseDto(int itemId, int userId, double qty, double price, double cost, String remark, double warranty, String groupNo, int id) {
        this.itemId = itemId;
        this.userId = userId;
        this.qty = qty;
        this.price = price;
        this.cost = cost;
        this.remark = remark;
        this.warranty = warranty;
        this.groupNo = groupNo;
        this.id = id;
    }

    public double getWarranty() {
        return warranty;
    }

    public void setWarranty(double warranty) {
        this.warranty = warranty;
    }

    public String getGroupNo() {
        return groupNo;
    }

    public void setGroupNo(String groupNo) {
        this.groupNo = groupNo;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

  private int itemId;
  private int userId;
  private double qty;
  private double price;
  private double cost;
  private String remark;
  private double warranty;
  private String groupNo;
  private int id;
}
