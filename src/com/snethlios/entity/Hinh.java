/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.snethlios.entity;

/**
 *
 * @author thankhou
 */
public class Hinh {
    private String mahinh, hinha, hinhb;

    public Hinh() {
    }

    @Override
    public String toString() {
        return  mahinh ;
    }

    public Hinh(String mahinh, String hinha, String hinhb) {
        this.mahinh = mahinh;
        this.hinha = hinha;
        this.hinhb = hinhb;
    }

    public String getMahinh() {
        return mahinh;
    }

    public void setMahinh(String mahinh) {
        this.mahinh = mahinh;
    }

    public String getHinha() {
        return hinha;
    }

    public void setHinha(String hinha) {
        this.hinha = hinha;
    }

    public String getHinhb() {
        return hinhb;
    }

    public void setHinhb(String hinhb) {
        this.hinhb = hinhb;
    }
}
