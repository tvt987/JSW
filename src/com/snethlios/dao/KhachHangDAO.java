/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.snethlios.dao;

import com.snethlios.entity.KhachHang;
import com.snethlios.entity.NhanVien;
import com.snethlios.utils.JdbcHelper;
import java.sql.ResultSet;
import java.util.List;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class KhachHangDAO extends SnethliosDAO<KhachHang, String>{

    @Override
    public void insert(KhachHang entity) {
       String sql ="insert into KHACHHANG values (?,?,?,?,?,?,?,?,?)";
        try {
            JdbcHelper.update(sql,
                    entity.getMakh(),
                    entity.getTenkh(),
                    entity.getDiaChi(),
                    entity.getDienThoai(),
                    entity.getGioiTinh(),
                    entity.getGhichu(),
                    entity.getDiem(),
                    entity.getNgayTao(),
                    entity.getNgayHetHan());
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(KhachHang entity) {
       String sql="update KHACHHANG set TENKH = ?, DIACHI =?, SDT=?, GIOITINH=?,GHICHU=?, DIEM =?, NGAYTAO=?,NGAYHETHAN=? WHERE MAKH =?";
        try {
            JdbcHelper.update(sql,
                    entity.getTenkh(),
                    entity.getDiaChi(),
                    entity.getDienThoai(),
                    entity.getGioiTinh(),
                    entity.getGhichu(),
                    entity.getDiem(),
                    entity.getNgayTao(),
                    entity.getNgayHetHan(),
                    entity.getMakh());
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String key) {
       String sql = "delete from KHACHHANG where MAKH =?";
        try {
            JdbcHelper.update(sql, key);
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<KhachHang> selectAll() {
      String sql ="SELECT * from KHACHHANG";
      return selectBySQL(sql);
    }

    @Override
    public KhachHang selectByID(String makh) {
        String sql = "SELECT * FROM KHACHHANG WHERE MAKH =?";
        List<KhachHang> ls = selectBySQL(sql, makh);
        return ls.size() > 0 ? ls.get(0) : null;
    }

    @Override
    protected List<KhachHang> selectBySQL(String sql, Object... args) {
        List<KhachHang> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.query(sql, args);
                while (rs.next()) {
                    KhachHang model = readFromResultSet(rs);
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (Exception e) {
        }
        return list;
    }
    private KhachHang readFromResultSet(ResultSet rs) throws SQLException {
        KhachHang kh = new KhachHang();
        kh.setMakh(rs.getString("MAKH"));
        kh.setTenkh(rs.getString("TENKH"));
        kh.setDiaChi(rs.getString("DIACHI"));
        kh.setDienThoai(rs.getString("SDT"));
        kh.setGioiTinh(rs.getBoolean("GIOITINH"));
        kh.setGhichu(rs.getString("GHICHU"));
        kh.setDiem(rs.getInt("DIEM"));
        kh.setNgayTao(rs.getDate("NGAYTAO"));
        kh.setNgayHetHan(rs.getDate("NGAYHETHAN"));
        return kh;
    }

}
