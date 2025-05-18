/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snethlios.entity;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class SanPham {

    private String maSp;
    private String tenSp;
    private String loai;
    private Double donGia;
    private int soLuong;
    private String mau;
    private int kichThuoc;
    private String hang;
    private Date ngayNhap;
    private String maHinh;
    private String maNV;
    private String maKM;
    private boolean trangThai;
    private int giamGia;

    public SanPham() {
    }

    public SanPham(String maSp, String tenSp, String loai, Double donGia, int soLuong, String mau, int kichThuoc, String hang, Date ngayNhap, String maHinh, String maNV, String maKM, boolean trangThai, int giamGia) {
        this.maSp = maSp;
        this.tenSp = tenSp;
        this.loai = loai;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.mau = mau;
        this.kichThuoc = kichThuoc;
        this.hang = hang;
        this.ngayNhap = ngayNhap;
        this.maHinh = maHinh;
        this.maNV = maNV;
        this.maKM = maKM;
        this.trangThai = trangThai;
        this.giamGia = giamGia;
    }

    public SanPham(String maSp, String tenSp, String loai, double donGia, int soluong, String mauSac, int KichThuoc, String hang, String hinh, Date ngayNhap, String maKM, String maNV, boolean trangThai, int mucGiamGia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getMaSp() {
        return maSp;
    }

    public void setMaSp(String maSp) {
        this.maSp = maSp;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public Double getDonGia() {
        return donGia;
    }

    public void setDonGia(Double donGia) {
        this.donGia = donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getMau() {
        return mau;
    }

    public void setMau(String mau) {
        this.mau = mau;
    }

    public int getKichThuoc() {
        return kichThuoc;
    }

    public void setKichThuoc(int kichThuoc) {
        this.kichThuoc = kichThuoc;
    }

    public String getHang() {
        return hang;
    }

    public void setHang(String hang) {
        this.hang = hang;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getMaHinh() {
        return maHinh;
    }

    public void setMaHinh(String maHinh) {
        this.maHinh = maHinh;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMaKM() {
        return maKM;
    }

    public void setMaKM(String maKM) {
        this.maKM = maKM;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public int getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(int giamGia) {
        this.giamGia = giamGia;
    }

    
}
