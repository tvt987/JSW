/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.snethlios.dao;

import com.snethlios.entity.Hinh;
import com.snethlios.utils.JdbcHelper;
import form.ThemAnhJDialog;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thankhou
 */
public class HinhDAO extends SnethliosDAO<Hinh, String> {

    String insert_sql = "insert into Hinh(mahinh, hinha, hinhb) values(?,?,?)";

    @Override
    public void insert(Hinh entity) {
        try {
            JdbcHelper.update(insert_sql, entity.getMahinh(), entity.getHinha(), entity.getHinhb());
        } catch (SQLException ex) {
            Logger.getLogger(HinhDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Hinh entity) {
        String sql = "UPDATE Hinh set HINHA=?, HINHB = ? WHERE MAHINH = ?";
        try {
            JdbcHelper.update(sql, entity.getHinha(), entity.getHinhb(), entity.getMahinh());
        } catch (SQLException ex) {
            Logger.getLogger(HinhDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String key) {
        String delete = "DELETE FROM HINH WHERE MAHINH = ?";
        try {
            JdbcHelper.update(delete, key);
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Hinh> selectAll() {
        String sql = "Select * from Hinh";
        return selectBySQL(sql);
    }

    @Override
    public Hinh selectByID(String key) {
        String sql = "select * from hinh where mahinh = ?";
        List<Hinh> list = selectBySQL(sql, key);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    protected List<Hinh> selectBySQL(String sql, Object... args) {
        List<Hinh> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.query(sql, args);
                while (rs.next()) {
                    Hinh model = readFromResultSet(rs);
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (Exception e) {
        }
        return list;
    }

    private Hinh readFromResultSet(ResultSet rs) throws SQLException {
        Hinh nv = new Hinh();
        nv.setMahinh(rs.getString("mahinh"));
        nv.setHinha(rs.getString("hinha"));
        nv.setHinhb(rs.getString("hinhb"));
        return nv;
    }

    public List<String> selectAllHinh() {
        String select_sql_loai = "Select MAHINH from hinh group by MAHINH";
        List<String> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(select_sql_loai);
            while (rs.next()) {
                list.add(rs.getString("MAHINH"));
            }
            return list;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
