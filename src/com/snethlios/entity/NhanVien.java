/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.snethlios.entity;

/**
 *
 * @author HUYNH DUC HOAN
 */
public class NhanVien {
    private String maNV;
    private String hoTen;
    private boolean vaiTro;
    private String nhiemVu;
    private String matKhau;
    private String email;
    private String hinh;
    private String QR;

    public NhanVien() {
    }

    public NhanVien(String maNV, String hoTen, boolean vaiTro, String nhiemVu, String matKhau, String email, String hinh, String QR) {
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.vaiTro = vaiTro;
        this.nhiemVu = nhiemVu;
        this.matKhau = matKhau;
        this.email = email;
        this.hinh = hinh;
        this.QR = QR;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public boolean getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(boolean vaiTro) {
        this.vaiTro = vaiTro;
    }

    public String getNhiemVu() {
        return nhiemVu;
    }

    public void setNhiemVu(String nhiemVu) {
        this.nhiemVu = nhiemVu;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public String getQR() {
        return QR;
    }

    public void setQR(String QR) {
        this.QR = QR;
    }

    

    
}
