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
public class KhuyenMai {

    private String MAKM;
    private String TENKM;
    private int MUCGIAMGIA;
    private boolean TRANGTHAI;
    private Date BATDAUKM;
    private Date KETTHUCKM;

    @Override
    public String toString() {
        return MAKM;
    }

    
    public KhuyenMai() {
    }

    public KhuyenMai(String MAKM, String TENKM, int MUCGIAMGIA, boolean TRANGTHAI, Date BATDAUKM, Date KETTHUCKM) {
        this.MAKM = MAKM;
        this.TENKM = TENKM;
        this.MUCGIAMGIA = MUCGIAMGIA;
        this.TRANGTHAI = TRANGTHAI;
        this.BATDAUKM = BATDAUKM;
        this.KETTHUCKM = KETTHUCKM;
    }

    public String getMAKM() {
        return MAKM;
    }

    public void setMAKM(String MAKM) {
        this.MAKM = MAKM;
    }

    public String getTENKM() {
        return TENKM;
    }

    public void setTENKM(String TENKM) {
        this.TENKM = TENKM;
    }

    public int getMUCGIAMGIA() {
        return MUCGIAMGIA;
    }

    public void setMUCGIAMGIA(int MUCGIAMGIA) {
        this.MUCGIAMGIA = MUCGIAMGIA;
    }

    public boolean isTRANGTHAI() {
        return TRANGTHAI;
    }

    public void setTRANGTHAI(boolean TRANGTHAI) {
        this.TRANGTHAI = TRANGTHAI;
    }

    public Date getBATDAUKM() {
        return BATDAUKM;
    }

    public void setBATDAUKM(Date BATDAUKM) {
        this.BATDAUKM = BATDAUKM;
    }

    public Date getKETTHUCKM() {
        return KETTHUCKM;
    }

    public void setKETTHUCKM(Date KETTHUCKM) {
        this.KETTHUCKM = KETTHUCKM;
    }
    
    

    
    
    
}
