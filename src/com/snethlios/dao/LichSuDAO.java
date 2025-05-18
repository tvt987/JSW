/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.snethlios.dao;

import com.snethlios.utils.JdbcHelper;
import form.LichSuJPanel;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HUYNH DUC HOAN
 */
public class LichSuDAO {

    public static double sum = 0;
    public static String lyDo = "";

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

    public List<Object[]> getPhieuXuat() {
        String sql = "{CALL sp_phieuxuat}";
        String[] cols = {"SOPX", "HOTEN", "TENKH", "NGAYTAO", "TRANGTHAI", "MANV", "SDT", "DIACHI"};
        return this.getListOfArray(sql, cols);
    }

    private List<Object[]> getListOfArray2(String sql, String[] cols, Object... args) {
        try {
            // 5 giam gia / 6 thanh tien
            List<Object[]> listtc = new ArrayList<>();
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                int x = 0;

                Object[] row = new Object[cols.length];
                for (int i = 0; i < cols.length; i++) {
                    row[i] = rs.getObject(cols[i]);
                    try {
                        if (i == 4) {
                            x = Integer.parseInt(String.valueOf(row[i]));
                        }
                    } catch (Exception e) {
                    }
                    if (i == 5) {
                        row[i] = Double.parseDouble(String.valueOf(row[i]));
                        sum += Double.parseDouble(String.valueOf(row[i]));
                    }
                    if(i == 7){
                        lyDo = String.valueOf(row[i]);
                    }
                }
                listtc.add(row);
            }

            rs.getStatement().getConnection().close();
            return listtc;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Object[]> getTTinSanPham(Integer sopx) {
        String sql = "{CALL sp_TTinSanPham(?)}";
        String[] cols = {"MASP", "TENSP", "SOLUONG", "DONGIA", "MUCGIAMGIA", "THANHTIEN", "TRANGTHAI", "LYDOHUY"};
        return this.getListOfArray2(sql, cols, sopx);
    }
}
