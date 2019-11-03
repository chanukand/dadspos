/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package possystem.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import possystem.db.DBConnection;
import possystem.dto.CategoryDto;
import possystem.dto.PurchaseDto;

/**
 *
 * @author Home
 */
public class PurchaseModel {
    
    public static boolean add(PurchaseDto dto) throws Exception {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO purchase(itemId, userId, qty, price, cost, remark, warranty, groupNo"
                    + ") VALUES(?,?,?,?,?,?,?,?)";
        PreparedStatement p = con.prepareStatement(sql);
        p.setObject(1, dto.getItemId());
        p.setObject(2, dto.getUserId());
        p.setObject(3, dto.getQty());
        p.setObject(4, dto.getPrice());
        p.setObject(5, dto.getCost());
        p.setObject(6, dto.getRemark());
        p.setObject(7, dto.getWarranty());
        p.setObject(8, dto.getGroupNo());
        int rowsaffected = p.executeUpdate();
        return (rowsaffected > 0);
    }
    
    public static boolean update(PurchaseDto dto) throws Exception {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "UPDATE purchase SET itemId=?, userId=?, qty=?, price=?, cost=?, remark=?,"
                + " warranty=?, groupNo=? WHERE id=?";
        PreparedStatement p = con.prepareStatement(sql);
        p.setObject(1, dto.getItemId());
        p.setObject(2, dto.getUserId());
        p.setObject(3, dto.getQty());
        p.setObject(4, dto.getPrice());
        p.setObject(5, dto.getCost());
        p.setObject(6, dto.getRemark());
        p.setObject(7, dto.getWarranty());
        p.setObject(8, dto.getGroupNo());
        p.setObject(9, dto.getId());
        int rowsaffected = p.executeUpdate();
        return (rowsaffected > 0);
    }
    
    public static ArrayList getAll() throws Exception {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "select * from category where isDeleted='0'";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rst = pst.executeQuery();
        ArrayList<CategoryDto> crt1 = new ArrayList<>();
        while (rst.next()) {            
            CategoryDto crt = new CategoryDto(rst.getString("description"), rst.getString("name"), rst.getString("code"), rst.getString("date"), rst.getString("remark"), rst.getInt("user"), rst.getInt("id"));
            crt1.add(crt);
        }
        return crt1;
    }
    
    public static boolean delete(int id) throws Exception {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "UPDATE category SET isDeleted='1' WHERE id = ? ";
        PreparedStatement p = con.prepareStatement(sql);
        p.setObject(1, id);
        int rowsaffected = p.executeUpdate();
        return (rowsaffected > 0);
    }
    
    public static ArrayList search(String id) throws Exception {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "select * from category where isDeleted='0' and name LIKE '%"+id+"%'";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rst = pst.executeQuery();
        ArrayList<CategoryDto> crt1 = new ArrayList<>();
        while (rst.next()) {            
            CategoryDto crt = new CategoryDto(rst.getString("description"), rst.getString("name"), rst.getString("code"), rst.getString("date"), rst.getString("remark"), rst.getInt("user"), rst.getInt("id"));
            crt1.add(crt);
        }
        return crt1;
    }
    
     public static int getCatId(String id) throws Exception {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM category WHERE NAME='"+id+"'";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rst = pst.executeQuery();
        int catgoryId=0;
        if (rst.next()) {            
            catgoryId = rst.getInt("id");
        }
        return catgoryId;
    }
}
