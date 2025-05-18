/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snethlios.entity;

/**
 *
 * @author ASUS
 */
public class ChiTietPhieuXuat {

    private int soPX;
    private String maSp;
    private double giaBan;
    private int soLuong;
    private Double thanTien;

    public ChiTietPhieuXuat() {

    }

    public ChiTietPhieuXuat(int soPX, String maSp, double giaBan, int soLuong, Double thanTien) {
        this.soPX = soPX;
        this.maSp = maSp;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
        this.thanTien = thanTien;
    }

    public int getSoPX() {
        return soPX;
    }

    public void setSoPX(int soPX) {
        this.soPX = soPX;
    }

    public String getMaSp() {
        return maSp;
    }

    public void setMaSp(String maSp) {
        this.maSp = maSp;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Double getThanTien() {
        return soLuong * giaBan;
    }

    public void setThanTien(Double thanTien) {
        this.thanTien = thanTien;
    }

}
