package com.itbank.googlemap02;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback{

    //구글맵의 제어 객체를 구현
    private GoogleMap gmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //구글에서 정보를 불러와 등록하는 작업
        SupportMapFragment support =
                (SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map);
        support.getMapAsync(MainActivity.this);
    }

    public void moveLocation(View view){
        LatLng location = null;
        if(view.getId() == R.id.btn1){//시청      (위도:37.564264, 경도:126.974676)
            location = new LatLng(37.564264, 126.974676);
        }
        else if(view.getId() == R.id.btn2){//남산(위도:37.550947, 경도:126.989296)
            location = new LatLng(37.550947, 126.989296);
        }
        else if(view.getId() == R.id.btn3){//한라산 정상(위도:33.361240, 경도:126.535755)
            location = new LatLng(33.361240, 126.535755);
        }

        if(location == null) return;

        //지도의 화면(Camera)을 갱신
        //[1] 순간이동              .moveCamera()
        //[2] 부드럽게 이동       .animateCamera()
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(location, 15);//1~23
        //gmap.moveCamera(update);
        gmap.animateCamera(update);

        //마커를 만들어서 화면에 표시
        gmap.clear();
        MarkerOptions options = new MarkerOptions();
        options.position(location);//위치
        options.title("제목입니다");
        options.snippet("작은 설명을 적어주세요");
        gmap.addMarker(options);

        //이벤트 설정
        gmap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                Toast.makeText(getApplicationContext(), "마커 선택됨", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        gmap = googleMap;
        //gmap의 초기상태를 설정

    }
}
