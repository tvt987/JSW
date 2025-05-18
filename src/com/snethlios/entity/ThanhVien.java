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
public class ThanhVien {
    private String matv;
    private int diem;
    private Date ngayDK;
    private Date ngayHH;
   private String makh;
   
    public ThanhVien() {
    }

    public ThanhVien(String matv, int diem, Date ngayDK, Date ngayHH,String makh) {
        this.matv = matv;
        this.diem = diem;
        this.ngayDK = ngayDK;
        this.ngayHH = ngayHH;
    }

    public String getMatv() {
        return matv;
    }

    public void setMatv(String matv) {
        this.matv = matv;
    }

    public int getDiem() {
        return diem;
    }

    public void setDiem(int diem) {
        this.diem = diem;
    }

    public Date getNgayDK() {
        return ngayDK;
    }

    public void setNgayDK(Date ngayDK) {
        this.ngayDK = ngayDK;
    }

    public Date getNgayHH() {
        return ngayHH;
    }

    public void setNgayHH(Date ngayHH) {
        this.ngayHH = ngayHH;
    }
    public String getmakh() {
        return makh;
    }

    public void setmakh(String makh) {
        this.makh = makh;
    }
}
