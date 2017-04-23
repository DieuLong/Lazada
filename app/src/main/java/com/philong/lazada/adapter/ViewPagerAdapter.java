package com.philong.lazada.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.philong.lazada.view.trangchu.fragment.FragmentChuongTrinhKhuyenMai;
import com.philong.lazada.view.trangchu.fragment.FragmentDienTu;
import com.philong.lazada.view.trangchu.fragment.FragmentLamDep;
import com.philong.lazada.view.trangchu.fragment.FragmentMeVaBe;
import com.philong.lazada.view.trangchu.fragment.FragmentNhaCuaVaDoiSong;
import com.philong.lazada.view.trangchu.fragment.FragmentNoiBat;
import com.philong.lazada.view.trangchu.fragment.FragmentTheThaoVaDuLich;
import com.philong.lazada.view.trangchu.fragment.FragmentThoiTrang;
import com.philong.lazada.view.trangchu.fragment.FragmentThuongHieu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Long on 23/04/2017.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> listFragment = new ArrayList<>();
    private List<String> listTitle = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
        listFragment.add(new FragmentNoiBat());
        listFragment.add(new FragmentChuongTrinhKhuyenMai());
        listFragment.add(new FragmentDienTu());
        listFragment.add(new FragmentNhaCuaVaDoiSong());
        listFragment.add(new FragmentMeVaBe());
        listFragment.add(new FragmentLamDep());
        listFragment.add(new FragmentThoiTrang());
        listFragment.add(new FragmentTheThaoVaDuLich());
        listFragment.add(new FragmentThuongHieu());
        listTitle.add("Nổi bật");
        listTitle.add("Chương trình khuyến mãi");
        listTitle.add("Điện tử");
        listTitle.add("Nhà cửa & đời sống");
        listTitle.add("Mẹ & bé");
        listTitle.add("Làm đẹp");
        listTitle.add("Thời trang");
        listTitle.add("Thể thao & du lịch");
        listTitle.add("Thương hiệu");
    }

    @Override
    public Fragment getItem(int position) {
        return listFragment.get(position);
    }

    @Override
    public int getCount() {
        return listFragment.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return listTitle.get(position);
    }
}
