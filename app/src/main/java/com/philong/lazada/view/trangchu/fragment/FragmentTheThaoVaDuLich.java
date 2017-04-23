package com.philong.lazada.view.trangchu.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.philong.lazada.R;

/**
 * Created by Long on 23/04/2017.
 */

public class FragmentTheThaoVaDuLich extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.the_thao_va_du_lich_fragment, container, false);
        return view;
    }
}
