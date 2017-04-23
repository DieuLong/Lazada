package com.philong.lazada.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.TextView;

import com.philong.lazada.R;
import com.philong.lazada.model.object.LoaiSanPham;
import com.philong.lazada.model.trangchu.xulymenu.XuLyJSONMenu;

import java.util.List;

/**
 * Created by Long on 23/04/2017.
 */

public class ExpandAdapter extends BaseExpandableListAdapter {

    private List<LoaiSanPham> listLoaiSanPham;
    private Context context;

    public ExpandAdapter(Context context, List<LoaiSanPham> listLoaiSanPham){
        this.context = context;
        this.listLoaiSanPham = listLoaiSanPham;
        XuLyJSONMenu xuLyJSONMenu = new XuLyJSONMenu();
        int count = listLoaiSanPham.size();
        for (int i = 0; i < count; i++) {
            int maLoaiSanPham = listLoaiSanPham.get(i).getMaLoaiSP();
            listLoaiSanPham.get(i).setListCon(xuLyJSONMenu.layLoaiSanPhamTheoMaLoai(maLoaiSanPham));
        }
    }

    @Override
    public int getGroupCount() {
        return listLoaiSanPham.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return listLoaiSanPham.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return listLoaiSanPham.get(groupPosition).getListCon().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return listLoaiSanPham.get(groupPosition).getMaLoaiSP();
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return listLoaiSanPham.get(groupPosition).getListCon().get(childPosition).getMaLoaiSP();
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.custom_layout_group_cha, parent, false);
        TextView txtTenLoaiSanPham = (TextView) view.findViewById(R.id.txtTenLoaiSanPham);
        txtTenLoaiSanPham.setText(listLoaiSanPham.get(groupPosition).getTenLoaiSP());
        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        SecondExpanble secondExpanble = new SecondExpanble(context);
        SecondAdapter adapter = new SecondAdapter(listLoaiSanPham.get(groupPosition).getListCon());
        secondExpanble.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        return secondExpanble;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    public class SecondExpanble extends ExpandableListView{

        public SecondExpanble(Context context) {
            super(context);
        }

        @Override
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            Display display = windowManager.getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            int width = size.x;
            int height = size.y;
            widthMeasureSpec = MeasureSpec.makeMeasureSpec(width, MeasureSpec.AT_MOST);
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.AT_MOST);
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        }
    }

    public class SecondAdapter extends BaseExpandableListAdapter{

        private List<LoaiSanPham> listConLoaiSanPham;

        public SecondAdapter(List<LoaiSanPham> listConLoaiSanPham) {
            this.listConLoaiSanPham = listConLoaiSanPham;
            XuLyJSONMenu xuLyJSONMenu = new XuLyJSONMenu();
            int count = listConLoaiSanPham.size();
            for (int i = 0; i < count; i++) {
                int maLoaiSanPham = listConLoaiSanPham.get(i).getMaLoaiSP();
                this.listConLoaiSanPham.get(i).setListCon(xuLyJSONMenu.layLoaiSanPhamTheoMaLoai(maLoaiSanPham));
            }
        }

        @Override
        public int getGroupCount() {
            return listConLoaiSanPham.size();
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return listConLoaiSanPham.get(groupPosition).getListCon().size();
        }

        @Override
        public Object getGroup(int groupPosition) {
            return listConLoaiSanPham.get(groupPosition);
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return listConLoaiSanPham.get(groupPosition).getListCon().get(childPosition);
        }

        @Override
        public long getGroupId(int groupPosition) {
            return listConLoaiSanPham.get(groupPosition).getMaLoaiSP();
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return listConLoaiSanPham.get(groupPosition).getListCon().get(childPosition).getMaLoaiSP();
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.custom_layout_group_cha, parent, false);
            TextView txtTenLoaiSanPham = (TextView) view.findViewById(R.id.txtTenLoaiSanPham);
            txtTenLoaiSanPham.setText(listConLoaiSanPham.get(groupPosition).getTenLoaiSP());
            return view;
        }

        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            TextView tv = new TextView(context);
            tv.setText(listConLoaiSanPham.get(groupPosition).getListCon().get(childPosition).getTenLoaiSP());
            tv.setPadding(15, 5, 5, 5);
            tv.setBackgroundColor(Color.YELLOW);
            tv.setLayoutParams(new ListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            return tv;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return false;
        }
    }

}
