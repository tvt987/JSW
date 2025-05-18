/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.snethlios.dao;

import com.snethlios.utils.JdbcHelper;
import java.util.*;
import java.sql.*;
import java.util.Date;


/**
 *
 * @author Admin
 */
public class ThongKeDAO {

    private List<Object[]> getListOfArray(String sql, String[] cols, Object... args) {
        try {
            List<Object[]> list = new ArrayList<>();
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                Object[] vals = new Object[cols.length];
                for (int i = 0; i < cols.length; i++) {
                    vals[i] = rs.getObject(cols[i]);
                }
                list.add(vals);
            }

            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Object[]> getDoanhThu(Integer year) {
        String sql = "{CALL sp_doanhthu(?)}";
        String[] cols = {"thang", "Tong so ban", "Tong gia ban", "TongGiamGia"};
        return this.getListOfArray(sql, cols, year);
    }

    public List<Object[]> getSanPham() {
        String sql = "{CALL sp_sanpham}";
        String[] cols = {"Ma SP", "Ten SP", "So luong da ban", "So luong con lai"};
        return this.getListOfArray(sql, cols);
    }
    
    public List<Object[]> getSanPhamTheoNgay(String tuNgay, String denNgay) {
        String sql = "{CALL sp_sanPhamTheoNgay(?, ?)}";
        String[] cols = {"Ma SP", "Ten SP", "So luong da ban", "So luong con lai"};
        return this.getListOfArray(sql, cols, tuNgay, denNgay);
    }
    
    public double doanhThuNam(int nam) throws SQLException{
        double dtn = 0;
        String doanhThuNam = "SELECT SUM(ct.GIABAN*ct.SOLUONG) dtn " +
                             " from PHIEUXUAT px inner join CTPX ct on px.SOPX = ct.SOPX" +
                             " WHERE YEAR(NGAYTAO) = ?";
        ResultSet rs = JdbcHelper.query(doanhThuNam, nam);
        while(rs.next()){
            dtn = rs.getDouble("dtn");
        }
        return dtn;
    }
    public double doanhThuTBThang(int nam) throws SQLException{
        double dtt = 0;
        String doanhThuTBThang = "SELECT SUM(ct.GIABAN*ct.SOLUONG) /12 dtt" +
                                 " from PHIEUXUAT px inner join CTPX ct on px.SOPX = ct.SOPX" +
                                 " WHERE YEAR(NGAYTAO) = ?";
        ResultSet rs = JdbcHelper.query(doanhThuTBThang, nam);
        while(rs.next()){
            dtt = rs.getDouble("dtt");
        }
        return dtt;
    }
    public double doanhThuTBNgay(int nam) throws SQLException{
        double dtt = 0;
        String doanhThuTBNgay = "SELECT SUM(ct.GIABAN*ct.SOLUONG) /365 dtngay" +
                                " from PHIEUXUAT px inner join CTPX ct on px.SOPX = ct.SOPX" +
                                " WHERE YEAR(NGAYTAO) = ?";
        ResultSet rs = JdbcHelper.query(doanhThuTBNgay, nam);
        while(rs.next()){
            dtt = rs.getDouble("dtngay");
        }
        return dtt;
    }
    
    public int tongKhachHang1Ngay() throws SQLException{
        int tongKhach = 0;
        String doanhThuTBNgay = "select count(distinct makh) tongKhachHang1Ngay" +
                                " from phieuxuat px" +
                                " where NGAYTAO = CONVERT(date,GETDATE(), 105)";
        ResultSet rs = JdbcHelper.query(doanhThuTBNgay);
        while(rs.next()){
            tongKhach = rs.getInt("tongKhachHang1Ngay");
        }
        return tongKhach;
    }
    
    public int tongHoaDon1Ngay() throws SQLException{
        int tongHoaDon = 0;
        String doanhThuTBNgay = "select count(*) as 'tongHoaDon1Ngay'" +
                                " from phieuxuat px" +
                                " where CONVERT(date,NGAYTAO) = CONVERT(date,GETDATE())";
        ResultSet rs = JdbcHelper.query(doanhThuTBNgay);
        while(rs.next()){
            tongHoaDon = rs.getInt("tongHoaDon1Ngay");
        }
        return tongHoaDon;
    }
    
}
