package com.philong.lazada.presenter.trangchu.xulymenu;

import com.philong.lazada.connectinternet.DownloadJSON;
import com.philong.lazada.model.object.LoaiSanPham;
import com.philong.lazada.model.trangchu.xulymenu.XuLyJSONMenu;
import com.philong.lazada.view.trangchu.ViewXuLyMenu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by Long on 23/04/2017.
 */

public class PresenterLogicXuLyMenu implements IPresenterXuLyMenu {

    private ViewXuLyMenu viewXuLyMenu;

    public PresenterLogicXuLyMenu(ViewXuLyMenu viewXuLyMenu) {
        this.viewXuLyMenu = viewXuLyMenu;
    }

    @Override
    public void layDanhSachMenu() {
        //String duongDan = "http://192.168.100.4/android/lazada/loaisanpham.php?maloaicha=1";
        String duongDan = "http://192.168.100.4/android/lazada/loaisanpham.php";
        List<LoaiSanPham> listLoaiSanPham = new ArrayList<>();
        List<HashMap<String, String>> attrs = new ArrayList<>();
        HashMap<String, String>  hsMaLoaiCha = new HashMap<>();
        hsMaLoaiCha.put("maloaicha", "0");
        attrs.add(hsMaLoaiCha);
        DownloadJSON downloadJSON = new DownloadJSON(duongDan, attrs);
        try {
            String dataJson = downloadJSON.execute().get();
            XuLyJSONMenu xuLyJSONMenu = new XuLyJSONMenu();
            listLoaiSanPham = xuLyJSONMenu.parseJSONMenu(dataJson);
            viewXuLyMenu.hienThiDanhSachMenu(listLoaiSanPham);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
