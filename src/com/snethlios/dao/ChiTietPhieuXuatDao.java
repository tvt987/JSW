/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snethlios.dao;

import com.snethlios.entity.ChiTietPhieuXuat;
import com.snethlios.entity.KhachHang;
import com.snethlios.utils.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class ChiTietPhieuXuatDao extends SnethliosDAO<ChiTietPhieuXuat, Integer> {

    String insert = "insert into CTPX (SOPX,MASP,GIABAN,SOLUONG) values(?,?,?,?);";
    String update = "UPDATE CTPX set MASP =?, GIABAN=?,SOLUONG=? WHERE SOPX=? ";
    String delete = "DELETE FROM PHIEUXUAT WHERE SOPX=?";
    String selectAll = "SELECT * FROM PHIEUXUAT";
    String selectByID = "select SOPX,MASP,GIABAN,SOLUONG,sum(GIABAN* SOLUONG) as N'Thành Tiền' from CTPX\n"
            + "where SOPX= ? group by SOPX,MASP,GIABAN,SOLUONG;";

    @Override
    public void insert(ChiTietPhieuXuat entity) {
        try {
            JdbcHelper.update(insert, entity.getSoPX(), entity.getMaSp(), entity.getGiaBan(), entity.getSoLuong());
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietPhieuXuatDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(ChiTietPhieuXuat entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ChiTietPhieuXuat> selectAll() {
        return selectBySQL(selectAll);
    }

    @Override
    public ChiTietPhieuXuat selectByID(Integer key) {
        List<ChiTietPhieuXuat> ctpx = selectBySQL(selectByID, key);
        return ctpx.size() > 0 ? ctpx.get(0) : null;
    }

    @Override
    protected List<ChiTietPhieuXuat> selectBySQL(String sql, Object... args) {
        List<ChiTietPhieuXuat> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.query(sql, args);
                while (rs.next()) {
                    ChiTietPhieuXuat model = readFromResultSet(rs);
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (Exception e) {
        }
        return list;
    }

    private ChiTietPhieuXuat readFromResultSet(ResultSet rs) throws SQLException {
        ChiTietPhieuXuat ctpx = new ChiTietPhieuXuat();
        ctpx.setSoPX(rs.getInt("SOPX"));
        ctpx.setMaSp(rs.getString("MASP"));
        ctpx.setGiaBan(rs.getDouble("GIABAN"));
        ctpx.setSoLuong(rs.getInt("SOLUONG"));
        return ctpx;
    }

}
