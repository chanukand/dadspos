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

/**
 *
 * @author Home
 */
public class categoryModel {
    
    public static boolean add(CategoryDto dto) throws Exception {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO category (code, name,description, remark, date, user"
                    + ") VALUES(?,?,?,?,?,?);";
        PreparedStatement p = con.prepareStatement(sql);
        p.setObject(1, dto.getCode());
        p.setObject(2, dto.getName());
        p.setObject(3, dto.getDesc());
        p.setObject(4, dto.getRemark());
        p.setObject(5, dto.getDate());
        p.setObject(6, dto.getUser());
        int rowsaffected = p.executeUpdate();
        return (rowsaffected > 0);
    }
    
    public static boolean update(CategoryDto dto) throws Exception {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "UPDATE category SET code=?, name=?,description=?, remark=?, date=?, user=? WHERE id=?";
        PreparedStatement p = con.prepareStatement(sql);
        p.setObject(1, dto.getCode());
        p.setObject(2, dto.getName());
        p.setObject(3, dto.getDesc());
        p.setObject(4, dto.getRemark());
        p.setObject(5, dto.getDate());
        p.setObject(6, dto.getUser());
        p.setObject(7, dto.getId());
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
