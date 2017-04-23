package com.philong.lazada.model.object;

import java.util.List;

/**
 * Created by Long on 23/04/2017.
 */

public class LoaiSanPham {

    private int maLoaiSP;
    private int maLoaiCha;
    private String tenLoaiSP;
    private List<LoaiSanPham> listCon;

    public LoaiSanPham() {
    }

    public LoaiSanPham(int maLoaiSP, int maLoaiCha, String tenLoaiSP) {
        this.maLoaiSP = maLoaiSP;
        this.maLoaiCha = maLoaiCha;
        this.tenLoaiSP = tenLoaiSP;
    }

    public LoaiSanPham(int maLoaiSP, int maLoaiCha, String tenLoaiSP, List<LoaiSanPham> listCon) {
        this.maLoaiSP = maLoaiSP;
        this.maLoaiCha = maLoaiCha;
        this.tenLoaiSP = tenLoaiSP;
        this.listCon = listCon;
    }

    public int getMaLoaiSP() {
        return maLoaiSP;
    }

    public void setMaLoaiSP(int maLoaiSP) {
        this.maLoaiSP = maLoaiSP;
    }

    public int getMaLoaiCha() {
        return maLoaiCha;
    }

    public void setMaLoaiCha(int maLoaiCha) {
        this.maLoaiCha = maLoaiCha;
    }

    public String getTenLoaiSP() {
        return tenLoaiSP;
    }

    public void setTenLoaiSP(String tenLoaiSP) {
        this.tenLoaiSP = tenLoaiSP;
    }

    public List<LoaiSanPham> getListCon() {
        return listCon;
    }

    public void setListCon(List<LoaiSanPham> listCon) {
        this.listCon = listCon;
    }
}
