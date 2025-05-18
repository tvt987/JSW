/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.snethlios.dao;

import com.snethlios.entity.NhanVien;
import com.snethlios.utils.JdbcHelper;
import com.snethlios.utils.MD5;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HUYNH DUC HOAN
 */
public class NhanVienDAO extends SnethliosDAO<NhanVien, String> {

    @Override
    public void insert(NhanVien entity) {
        String sql = "INSERT INTO NhanVien (MANV, HOTEN, VAITRO, NHIEMVU, MATKHAU, EMAIL, HINH) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            JdbcHelper.update(sql, entity.getMaNV(), entity.getHoTen(), entity.getVaiTro(), entity.getNhiemVu(), MD5.getMd5(entity.getMatKhau()), entity.getEmail(), entity.getHinh());
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(NhanVien entity) {
        String sql = "UPDATE NhanVien SET HOTEN=?, VAITRO=?, NHIEMVU=?, MATKHAU=?, EMAIL=?, HINH = ? WHERE MANV = ?";
        try {
            JdbcHelper.update(sql, entity.getHoTen(), entity.getVaiTro(), entity.getNhiemVu(), MD5.getMd5(entity.getMatKhau()), entity.getEmail(), entity.getHinh(), entity.getMaNV());
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateMatKhau(NhanVien entity) {
        String sql = "update NHANVIEN\n"
                + " set matkhau = ? \n"
                + " where email = ? ";
        try {
            JdbcHelper.update(sql, MD5.getMd5(entity.getMatKhau()), entity.getEmail());
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String MaNV) {
        String sql = "DELETE FROM NhanVien WHERE MaNV=?";
        try {
            JdbcHelper.update(sql, MaNV);
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<NhanVien> selectAll() {
        String sql = "SELECT * FROM NhanVien";
        return selectBySQL(sql);
    }

    @Override
    public NhanVien selectByID(String MaNV) {
        String sql = "SELECT * FROM NHANVIEN WHERE MANV=?";
        List<NhanVien> list = selectBySQL(sql, MaNV);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    protected List<NhanVien> selectBySQL(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.query(sql, args);
                while (rs.next()) {
                    NhanVien model = readFromResultSet(rs);
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (Exception e) {
        }
        return list;
    }

    public NhanVien selectByEmail(String Email) {
        String sql = "SELECT * FROM NHANVIEN WHERE Email=?";
        List<NhanVien> list = selectBySQL(sql, Email);
        return list.size() > 0 ? list.get(0) : null;
    }

    private NhanVien readFromResultSet(ResultSet rs) throws SQLException {
        NhanVien nv = new NhanVien();
        nv.setMaNV(rs.getString("MANV"));
        nv.setHoTen(rs.getString("HOTEN"));
        nv.setVaiTro(rs.getBoolean("VAITRO"));
        nv.setNhiemVu(rs.getString("NHIEMVU"));
        nv.setMatKhau(rs.getString("MATKHAU"));
        nv.setEmail(rs.getString("EMAIL"));
        nv.setHinh(rs.getString("HINH"));
        nv.setQR(rs.getString("QR"));
        return nv;
    }

    public NhanVien selectByQR(String QR) {
        String sql = "SELECT * FROM NHANVIEN WHERE QR=?";
        List<NhanVien> list = selectBySQL(sql, QR);
        return list.size() > 0 ? list.get(0) : null;
    }
}
