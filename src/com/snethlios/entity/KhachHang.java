/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.snethlios.entity;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class KhachHang {

    private String makh;
    private String tenkh;
    private String diaChi;
    private String dienThoai;
    private boolean gioiTinh;
    private String ghichu;
    private int diem;
    private Date ngayTao;
    private Date ngayHetHan;

    public KhachHang() {
    }

    public KhachHang(String makh, String tenkh, String diaChi, String dienThoai, boolean gioiTinh, String ghichu, int diem, Date ngayTao, Date ngayHetHan) {
        this.makh = makh;
        this.tenkh = tenkh;
        this.diaChi = diaChi;
        this.dienThoai = dienThoai;
        this.gioiTinh = gioiTinh;
        this.ghichu = ghichu;
        this.diem = diem;
        this.ngayTao = ngayTao;
        this.ngayHetHan = ngayHetHan;
    }

    public String getMakh() {
        return makh;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public String getTenkh() {
        return tenkh;
    }

    public void setTenkh(String tenkh) {
        this.tenkh = tenkh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public int getDiem() {
        return diem;
    }

    public void setDiem(int diem) {
        this.diem = diem;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(Date ngayHetHan) {
        this.ngayHetHan = ngayHetHan;
    }
    
    
  
    
}
