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
import possystem.dto.ItemDto;

/**
 *
 * @author Home
 */
public class ItemModel {

    public static boolean add(ItemDto dto) throws Exception {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO item(CODE,NAME,description,remark,USER,cat_id,cost,price)"
                + "VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement p = con.prepareStatement(sql);
        p.setObject(1, dto.getCode());
        p.setObject(2, dto.getName());
        p.setObject(3, dto.getDescription());
        p.setObject(4, dto.getRemark());
        p.setObject(5, dto.getUser());
        p.setObject(6, dto.getCateId());
        p.setObject(7, dto.getCost());
        p.setObject(8, dto.getPrice());
        int rowsaffected = p.executeUpdate();
        return (rowsaffected > 0);
    }

    public static boolean update(ItemDto dto) throws Exception {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "UPDATE item SET "
                + "CODE =?, NAME=? ,description=? ,remark=?,USER=?,cat_id=?,cost=?,price=? WHERE id=?";
        PreparedStatement p = con.prepareStatement(sql);
        p.setObject(1, dto.getCode());
        p.setObject(2, dto.getName());
        p.setObject(3, dto.getDescription());
        p.setObject(4, dto.getRemark());
        p.setObject(5, dto.getUser());
        p.setObject(6, dto.getCateId());
        p.setObject(7, dto.getCost());
        p.setObject(8, dto.getPrice());
        p.setObject(9, dto.getId());
        int rowsaffected = p.executeUpdate();
        return (rowsaffected > 0);
    }

    public static ArrayList getAll() throws Exception {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM item i INNER JOIN category c ON i.cat_id = c.id WHERE i.isDeleted='0'";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rst = pst.executeQuery();
        ArrayList<ItemDto> itemArr = new ArrayList<>();
        while (rst.next()) {
            ItemDto itemObj = new ItemDto(rst.getString("code"), rst.getString("name"),
                    rst.getString("description"), rst.getString("remark"), rst.getInt("user"),
                    rst.getInt("cat_id"), rst.getDouble("cost"), rst.getDouble("price"),
                     rst.getInt("id"), rst.getString("c.name"));
            itemArr.add(itemObj);
        }
        return itemArr;
    }

    public static boolean delete(int id) throws Exception {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "UPDATE item SET isDeleted='1' WHERE id = ? ";
        PreparedStatement p = con.prepareStatement(sql);
        p.setObject(1, id);
        int rowsaffected = p.executeUpdate();
        return (rowsaffected > 0);
    }

    public static ArrayList search(String id) throws Exception {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "select * from item i INNER JOIN category c ON i.cat_id = c.id "
                + "WHERE i.isDeleted='0' AND i.name LIKE '%" + id + "%'";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rst = pst.executeQuery();
        ArrayList<ItemDto> itemArr = new ArrayList<>();
        while (rst.next()) {
            ItemDto itemObj = new ItemDto(rst.getString("code"), rst.getString("name"),
                    rst.getString("description"), rst.getString("remark"), rst.getInt("user"),
                    rst.getInt("cat_id"), rst.getDouble("cost"), rst.getDouble("price"), rst.getInt("id"),
                     rst.getString("c.name"));
            itemArr.add(itemObj);
        }
        return itemArr;
    }

    public static int getItemId(String id) throws Exception {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "select * from item WHERE name ='" + id + "'";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rst = pst.executeQuery();
        int itemId = 0;
        if (rst.next()) {
            itemId = rst.getInt("id");
        }
        return itemId;
    }
}
