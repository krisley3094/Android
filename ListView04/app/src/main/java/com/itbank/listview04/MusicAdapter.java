package com.itbank.listview04;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 연지점204강사 on 2017-06-17.
 */

public class MusicAdapter extends BaseAdapter{
    //MusicData를 관리할 List를 구현
    private List<MusicData> list = new ArrayList<>();
    public void add(MusicData music){
        list.add(music);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //[1] Context 정보 불러오기
        //[2] 화면 생성하기
        //[3] 정보 설정하기

        Context context = viewGroup.getContext();

        if(view == null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item, viewGroup, false);
        }

        MusicData data = list.get(i);

        ImageView image = (ImageView)view.findViewById(R.id.image);
        TextView rank = (TextView)view.findViewById(R.id.rank);
        TextView title = (TextView)view.findViewById(R.id.title);

        image.setImageDrawable(data.getImage());
        rank.setText(String.valueOf(data.getRank()));
        title.setText(data.getTitle());

        return view;
    }
}
