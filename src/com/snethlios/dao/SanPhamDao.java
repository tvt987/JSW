/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snethlios.dao;

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
 * @author ASUS
 */
public class SanPhamDao extends SnethliosDAO<SanPham, String> {

    String insert = "insert into SANPHAM (MASP,TENSP,LOAI,DONGIA,SOLUONG,MAUSAC,KICHTHUOC,HANG,NgayNhap,MAHINH,MANV,MAKM) values(?,?,?,?,?,?,?,?,?,?,?,?);";
    String update = "UPDATE SANPHAM SET TENSP=?, LOAI=?, DONGIA=?, SOLUONG=?, MAUSAC=?, KICHTHUOC=?, HANG=?, NGAYNHAP=?,MAHINH=?, MANV=?,MAKM=? WHERE MASP=?";
    String delete = "DELETE FROM SANPHAM WHERE MASP=?";
    String selectAll = "SELECT * FROM SANPHAM";
    String selectByID = "SELECT * FROM SANPHAM WHERE MASP=?";

    @Override
    public void insert(SanPham entity) {
        try {
            JdbcHelper.update(insert, entity.getMaSp(), entity.getTenSp(), entity.getLoai(), entity.getDonGia(), entity.getSoLuong(), entity.getMau(), entity.getKichThuoc(), entity.getHang(), entity.getNgayNhap(), entity.getMaHinh(), entity.getMaNV(),entity.getMaKM());
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(SanPham entity) {
        try {
            JdbcHelper.update(update, entity.getTenSp(), entity.getLoai(), entity.getDonGia(), entity.getSoLuong(), entity.getMau(), entity.getKichThuoc(), entity.getHang(), entity.getNgayNhap(), entity.getMaHinh(), entity.getMaNV(),entity.getMaKM(),  entity.getMaSp());
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void update1(SanPham entity) {
        String update1 = "UPDATE SANPHAm SET TENSP=?, LOAI=?, DONGIA=?, SOLUONG=?, MAUSAC=?, KICHTHUOC=?, HANG=?, MAKM=? WHERE MASP=?";
        try {
            JdbcHelper.update(update1, entity.getTenSp(), entity.getLoai(), entity.getDonGia(), entity.getSoLuong(), entity.getMau(), entity.getKichThuoc(), entity.getHang(), entity.getMaKM(), entity.getMaSp());
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void delete(String key) {
        try {
            JdbcHelper.update(delete, key);
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public List<SanPham> selectAll() {
        String sql = "select * from SanPham";
        return this.selectBySQL(sql);
    }

    public List<String> selectAllHang() {
        String select_sql_loai = "Select hang from sanpham group by hang";
        List<String> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(select_sql_loai);
            while (rs.next()) {
                list.add(rs.getString("hang"));
            }
            return list;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    
     public List<String> selectAllHinh() {
        String select_sql_loai = "Select MAHINH from sanpham group by MAHINH";
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
 public List<String> selectAllMAKM() {
        String select_sql_loai = "Select MAKM from sanpham group by MAKM";
        List<String> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(select_sql_loai);
            while (rs.next()) {
                list.add(rs.getString("MAKM"));
            }
            return list;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    public List<SanPham> selectByCBO(String hang) {
        String sql = "SELECT * FROM sanpham WHERE hang = ?";
        return selectBySQL(sql, hang);
    }

    @Override
    public SanPham selectByID(String key) {
        String sql = "select * from SanPham where MASP=?";
        List<SanPham> list = selectBySQL(sql, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<SanPham> selectBySQL(String sql, Object... args) {
        List<SanPham> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.query(sql, args);
                while (rs.next()) {
                    SanPham model = readFromResultSet(rs);
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }

    private SanPham readFromResultSet(ResultSet rs) throws SQLException {
        SanPham model = new SanPham();
        model.setMaSp(rs.getString("MASP"));
        model.setTenSp(rs.getString("TENSP"));
        model.setLoai(rs.getString("LOAI"));
        model.setDonGia(rs.getDouble("DONGIA"));
        model.setSoLuong(rs.getInt("SOLUONG"));
        model.setMau(rs.getString("MAUSAC"));
        model.setKichThuoc(rs.getInt("KICHTHUOC"));
        model.setHang(rs.getString("HANG"));
        model.setMaHinh(rs.getString("MAHINH"));
        model.setNgayNhap(rs.getDate("NgayNhap"));
        model.setMaNV(rs.getString("MANV"));
        model.setMaKM(rs.getString("MAKM"));
        return model;
    }

}
