package com.itbank.listview03;

import android.content.Context;
import android.graphics.drawable.Drawable;
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

/*
    ListAdapter         ListItem 여러개를 관리하며 화면에 뿌려주는 클래스
                              ListItem 여러개를 저장할 수 있는 저장소를 가지고 있어야 한다
                              어떤 기준으로 ListItem을 화면에 배치할지를 정의해야 한다(컴퓨터가 모르니까)

        - int getCount()
                데이터의 개수를 컴퓨터에게 알려주는 메소드
                컴퓨터는 여기서 나오는 개수를 기준으로 화면을 구성
        - Object getItem(int i)
                필요한 위치의 아이템을 컴퓨터에게 반환하는 메소드
                컴퓨터는 화면을 구성할 때 이 기능을 불러 아이템의 정보를 가져간다
        - long getItemId(int i)
                아이템의 ID를 반환하는 메소드
                우리는 아이템에 ID를 부여하지 않으므로 사용하지 않는다
        - View getView(int i, View view, ViewGroup viewGroup)
                실제로 화면을 구성하는 메소드
                i - position, 아이템의 위치
                view - 완성될 화면
                viewGroup - 완성될 화면이 배치될 자리
 */
public class ListAdapter extends BaseAdapter {
    //ListItem을 여러개 관리할 저장소
    private List<ListItem> list = new ArrayList<>();

    //list에 아이템을 등록하는 등록 메소드
    public void add(ListItem item){
        list.add(item);
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
        //화면을 만들고 정보까지 설정해서 반환하는 코드를 여기에 작성

        //소속 정보를 불러온다
        Context context = viewGroup.getContext();

        //view 생성 - LayoutInflater 이용
        if(view == null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(
                                                                    Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item, viewGroup, false);
        }

        //생성된 view에 데이터를 설정해 주는 코드

        ListItem data = list.get(i);//i번 위치의 데이터를 추출

        ImageView icon = (ImageView)view.findViewById(R.id.icon);
        TextView title = (TextView)view.findViewById(R.id.title);
        TextView detail = (TextView)view.findViewById(R.id.detail);
        TextView price = (TextView)view.findViewById(R.id.price);

        //data의 정보를 icon, title, detail, price에 배치
        icon.setImageDrawable(data.getIcon());
        title.setText(data.getTitle());
        detail.setText(data.getDetail());
        price.setText(data.getPrice()+"원");

        return view;
    }
}











