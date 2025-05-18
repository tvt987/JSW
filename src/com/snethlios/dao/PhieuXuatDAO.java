package com.snethlios.dao;

import com.snethlios.entity.PhieuXuat;
import com.snethlios.entity.SanPham;
import com.snethlios.utils.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PhieuXuatDAO extends SnethliosDAO<PhieuXuat, Integer> {
    //insert into PHIEUXUAT values('2022-9-15',N'Không',N'Đã giao',N'Đặt hàng', 'HoanHD','KH001',930000)

    String insert = "insert into PHIEUXUAT (NGAYTAO,LYDOHUY,TRANGTHAI,HINHTHUCTHANHTOAN,MANV,MAKH,TONGTIEN,TONGGIAMGIA) values(?,?,?,?,?,?,?,?);";
    String update = "UPDATE PHIEUXUAT SET NGAYTAO=?, LYDOHUY=?, TRANGTHAI=?,HINHTHUCTHANHTOAN=?,MANV=?,MKH=? WHERE MAPX=?";
    String delete = "DELETE FROM PHIEUXUAT WHERE SOPX=?";
    String selectAll = "select * from PHIEUXUAT\n"
            + "order by PHIEUXUAT.SOPX DESC  ";
    String selectByID = "SELECT * FROM PHIEUXUAT WHERE SOPX = ?";
    String selectByTrangThai = "SELECT * FROM PHIEUXUAT WHERE TRANGTHAI=? order by SOPX DESC";
    String insert2 = "INSERT INTO PHIEUXUAT\n"
            + "                         (NGAYTAO, LYDOHUY, TRANGTHAI, HINHTHUCTHANHTOAN, MANV, TONGTIEN, TONGGIAMGIA)\n"
            + "VALUES(?,?,?,?,?,?,?)";

    @Override
    public void insert(PhieuXuat entity) {
        try {
            JdbcHelper.update(insert, entity.getNgayTao(), entity.getLyDoHuy(), entity.getTrangThai(), entity.getHinhThucThanhToan(), entity.getMaNV(), entity.getMaKH(), entity.getTongTien(), entity.getTongGiamGia());
        } catch (SQLException ex) {
            Logger.getLogger(PhieuXuatDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void insert2(PhieuXuat entity) throws SQLException {
        JdbcHelper.update(insert2, entity.getNgayTao(), entity.getLyDoHuy(), entity.getTrangThai(), entity.getHinhThucThanhToan(), entity.getMaNV(), entity.getTongTien(), entity.getTongGiamGia());
    }

    @Override
    public void update(PhieuXuat entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Integer key) {
        try {
            JdbcHelper.update(delete, key);
        } catch (SQLException ex) {
            Logger.getLogger(PhieuXuatDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<PhieuXuat> selectAll() {
        return this.selectBySQL(selectAll);
    }

    @Override
    public PhieuXuat selectByID(Integer key) {
        List<PhieuXuat> list = selectBySQL(selectByID, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public List<PhieuXuat> selectByCBO(String hang) {
        return selectBySQL(selectByTrangThai, hang);
    }

    @Override
    protected List<PhieuXuat> selectBySQL(String sql, Object... args) {
        List<PhieuXuat> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.query(sql, args);
                while (rs.next()) {
                    PhieuXuat model = readFromResultSet(rs);
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

    public List<Integer> selectYears() {
        String sql = "SELECT DISTINCT year(NgayTao) Year FROM PhieuXuat ORDER BY Year DESC";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    private PhieuXuat readFromResultSet(ResultSet rs) throws SQLException {
        PhieuXuat px = new PhieuXuat();
        px.setSoPX(rs.getInt("SOPX"));
        px.setMaNV(rs.getString("MANV"));
        px.setTrangThai(rs.getString("TRANGTHAI"));
        px.setMaKH(rs.getString("MAKH"));
        px.setTongGiamGia(rs.getDouble("TONGGIAMGIA"));
        px.setTongTien(rs.getDouble("TONGTIEN"));

        px.setNgayTao(rs.getDate("NGAYTAO"));
        px.setHinhThucThanhToan(rs.getString("HINHTHUCTHANHTOAN"));
        px.setLyDoHuy(rs.getString("LYDOHUY"));
        return px;
    }

    public List<String> selectAllHang() {
        String select_sql_loai = "Select TRANGTHAI from PHIEUXUAT group by TRANGTHAI";
        List<String> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(select_sql_loai);
            while (rs.next()) {
                list.add(rs.getString("TRANGTHAI"));
            }
            return list;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
