package com.itbank.googlemap03;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback{

    private GoogleMap map;

    private EditText input;
    private ListView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = (EditText)findViewById(R.id.input);
        result = (ListView)findViewById(R.id.result);

        SupportMapFragment support =
                (SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map);
        support.getMapAsync(MainActivity.this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        //초기 위치를 시청으로 설정
        LatLng latLng = new LatLng(37.564264, 126.974676);
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(latLng, 15);
        map.moveCamera(update);
    }

    public void search(View view){
        try{
            //[1] 입력창의 글자를 가져온다
            //[2] 검색을 수행한다
            //[3] 결과를 ListView에 표시한다
            //[4] 결과를 map에 마커로 표시한다

            String text = input.getText().toString();

            Geocoder geocoder = new Geocoder(MainActivity.this);
            List<Address> list = geocoder.getFromLocationName(text, Integer.MAX_VALUE/* , 위도 하한선, 위도 상한선, 경도 하한선, 경도 상한선*/);
            if(list == null || list.size() == 0){
                Toast.makeText(getApplicationContext(), "검색 결과가 없습니다", Toast.LENGTH_SHORT).show();
                return;
            }

            Log.d("tmp", list.size()+"");
            Address addr = list.get(0);
            LatLng location = new LatLng(addr.getLatitude(), addr.getLongitude());
            CameraUpdate update = CameraUpdateFactory.newLatLngZoom(location, 15);
            map.animateCamera(update);

            map.clear();
            MarkerOptions marker = new MarkerOptions();
            marker.position(location);
            marker.title(addr.getFeatureName());
            marker.snippet(addr.getAddressLine(0));
            map.addMarker(marker);

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, R.layout.support_simple_spinner_dropdown_item);
            for(Address a : list){
                adapter.add("["+a.getFeatureName()+"] "+a.getAddressLine(0));
            }
            result.setAdapter(adapter);

        }catch(Exception e){
            Toast.makeText(getApplicationContext(), "오류 발생", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }
}











