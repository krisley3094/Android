package com.itbank.fragment01;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FirstFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        //fragment_first.xml을 view에 설정한 뒤 반환
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        return view;
    }
}
