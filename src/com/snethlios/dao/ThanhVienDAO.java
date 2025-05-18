/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.snethlios.dao;

import com.snethlios.entity.KhachHang;
import com.snethlios.entity.ThanhVien;
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
public class ThanhVienDAO extends SnethliosDAO<ThanhVien, String>{

    @Override
    public void insert(ThanhVien entity) {
       String sql="insert into ThanhVien values (?,?,?,?) where MAKH = ?";
        try {
            JdbcHelper.update(sql,
                    entity.getMatv(),
                    entity.getDiem(),
                    entity.getNgayDK(),
                    entity.getNgayHH()
            );
        } catch (SQLException ex) {
            Logger.getLogger(ThanhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(ThanhVien entity) {
        String sql="update ThanhVien set DIEM=?,NGAYTAO=?,NGAYHETHAN=? where MATV=?";
        try { 
            JdbcHelper.update(sql,
                    entity.getDiem(),
                    entity.getNgayDK(),
                    entity.getNgayHH(),
                    entity.getMatv());
        } catch (SQLException ex) {
            Logger.getLogger(ThanhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String MAKH) {
        String sql ="DELETE FROM ThanhVien WHERE MAKH=?";
        try {
            JdbcHelper.update(sql, MAKH);
        } catch (SQLException ex) {
            Logger.getLogger(ThanhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<ThanhVien> selectAll() {
       String sql ="SELECT * from THANHVIEN";
      return selectBySQL(sql);
    }

    @Override
    public ThanhVien selectByID(String makh) {
      String sql = "SELECT * FROM THANHVIEN WHERE MAKH =?";
        List<ThanhVien> ls = selectBySQL(sql,makh);
        return ls.size() > 0 ? ls.get(0) : null;
    }

    @Override
    protected List<ThanhVien> selectBySQL(String sql, Object... args) {
     List<ThanhVien> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.query(sql, args);
                while (rs.next()) {
                    ThanhVien model = readFromResultSet(rs);
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (Exception e) {
        }
        return list;
    }

    private ThanhVien readFromResultSet(ResultSet rs) throws SQLException {
         ThanhVien kh = new ThanhVien();
        kh.setMatv(rs.getString("MATV"));
        kh.setDiem(rs.getInt("DIEM"));
        kh.setNgayDK(rs.getDate("NGAYTAO"));
        kh.setNgayHH(rs.getDate("NGAYHETHAN"));
        kh.setmakh(rs.getString("MAKH"));
        return kh;
    }
    // OverLoading
     public void insert(ThanhVien entity,String MaKH) {
       String sql="insert into ThanhVien values (?,?,?,?,?)";
        try {
            JdbcHelper.update(sql,
                    entity.getMatv(),
                    entity.getDiem(),
                    entity.getNgayDK(),
                    entity.getNgayHH(),
                    MaKH                
            );
        } catch (SQLException ex) {
            Logger.getLogger(ThanhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
