/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.snethlios.dao;

import com.snethlios.entity.KhuyenMai;
import com.snethlios.entity.SanPham;
import com.snethlios.utils.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class KhuyenMaiDAO extends SnethliosDAO<KhuyenMai, String>{

    @Override
    public void insert(KhuyenMai entity) {
        String INSERT_SQL = "INSERT INTO KHUYENMAI(MAKM, TENKM, MUCGIAMGIA, TRANGTHAI, BATDAUKM, KETTHUCKM) VALUES(?,?,?,?,?,?)";
        try {
            JdbcHelper.update(INSERT_SQL, entity.getMAKM(), entity.getTENKM(), entity.getMUCGIAMGIA(), entity.isTRANGTHAI(), entity.getBATDAUKM(), entity.getKETTHUCKM());
        } catch (SQLException ex) {
            Logger.getLogger(KhuyenMaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(KhuyenMai entity) {
        String UPDATE_SQL = "UPDATE KhuyenMai SET TENKM =?, MUCGIAMGIA =?, TRANGTHAI =?, BATDAUKM =?, KETTHUCKM=? WHERE MAKM=?";
        try {
            JdbcHelper.update(UPDATE_SQL, entity.getTENKM(), entity.getMUCGIAMGIA(), entity.isTRANGTHAI(), entity.getBATDAUKM(), entity.getKETTHUCKM(), entity.getMAKM());
        } catch (SQLException ex) {
            Logger.getLogger(KhuyenMaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<KhuyenMai> selectAll() {
        String SELECT_ALL_SQL = "SELECT * FROM khuyenmai";
        return selectBySQL(SELECT_ALL_SQL);
    }

    @Override
    public KhuyenMai selectByID(String key) {
        String SELECT_BY_ID_SQL = "SELECT * FROM KhuyenMai WHERE MaKM =?";
        List<KhuyenMai> list = this.selectBySQL(SELECT_BY_ID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<KhuyenMai> selectBySQL(String sql, Object... args) {
        List<KhuyenMai> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.query(sql, args);
                while (rs.next()) {
                    KhuyenMai km = new KhuyenMai();
                    km.setMAKM(rs.getString("MAKM"));
                    km.setTENKM(rs.getString("TENKM"));
                    km.setMUCGIAMGIA(rs.getInt("MUCGIAMGIA"));
                    km.setTRANGTHAI(rs.getBoolean("TRANGTHAI"));
                    km.setBATDAUKM(rs.getDate("BATDAUKM"));
                    km.setKETTHUCKM(rs.getDate("KETTHUCKM"));
                    list.add(km);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }
    
    public List<String> fillKhuyenMai(){
        String sql = "SELECT DISTINCT km.MAKM FROM KHUYENMAI km";
        List<String> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql);
            while (rs.next()) {
                list.add(rs.getString(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
