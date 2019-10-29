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
    
    
        public ItemDto(String billNo,String actionTime,double qty,double amt,double discount,double money,int userId,int itemId,int id) {
        this.billNo = billNo;
        this.actionTime = actionTime;
        this.qty = qty;
        this.amt = amt;
        this.discount = discount;
        this.money = money;
        this.userId = userId;
        this.itemId = itemId;
        this.id = id;
        
    }
    

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public String getActionTime() {
        return actionTime;
    }

    public void setActionTime(String actionTime) {
        this.actionTime = actionTime;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public double getAmt() {
        return amt;
    }

    public void setAmt(double amt) {
        this.amt = amt;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    private String billNo;
    private String actionTime;
    private double qty;
    private double amt;
    private double discount;
    private double money;
    private int userId;
    private int itemId;
    private int id;
    
}

    