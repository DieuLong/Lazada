package com.philong.lazada.model.trangchu.xulymenu;

import com.philong.lazada.connectinternet.DownloadJSON;
import com.philong.lazada.model.object.LoaiSanPham;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by Long on 23/04/2017.
 */

public class XuLyJSONMenu {

    public List<LoaiSanPham> parseJSONMenu(String json){
        List<LoaiSanPham> listLoaiSanPham = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray loaiSanPham = jsonObject.getJSONArray("LOAISANPHAM");
            int count = loaiSanPham.length();
            for (int i = 0; i < count; i++) {
                JSONObject sanpham = loaiSanPham.getJSONObject(i);
                String tenLoaiSP = sanpham.getString("TENLOAISP");
                int maLoaiSP = sanpham.getInt("MALOAISP");
                int maLoaiCha = sanpham.getInt("MALOAI_CHA");
                listLoaiSanPham.add(new LoaiSanPham(maLoaiSP, maLoaiCha, tenLoaiSP));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return listLoaiSanPham;
    }

    public List<LoaiSanPham> layLoaiSanPhamTheoMaLoai(int maLoaiSP){
        List<LoaiSanPham> listLoaiSanPham = new ArrayList<>();
        List<HashMap<String, String>> attrs = new ArrayList<>();
        String duongDan = "http://192.168.100.4/android/lazada/loaisanpham.php";
        HashMap<String, String>  hsMaLoaiCha = new HashMap<>();
        hsMaLoaiCha.put("maloaicha", String.valueOf(maLoaiSP));
        attrs.add(hsMaLoaiCha);
        DownloadJSON downloadJSON = new DownloadJSON(duongDan, attrs);
        try {
            String dataJson = downloadJSON.execute().get();
            XuLyJSONMenu xuLyJSONMenu = new XuLyJSONMenu();
            listLoaiSanPham = xuLyJSONMenu.parseJSONMenu(dataJson);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return listLoaiSanPham;
    }

}
