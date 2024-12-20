package com.changhun.ggongdari_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback{

    private GoogleMap mgoogleMap;

    private Button calenderButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        supportMapFragment.getMapAsync(this);

        calenderButton = findViewById(R.id.calenderBtn);
        calenderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onMapReady(final GoogleMap googleMap){
        mgoogleMap = googleMap;
        final LatLng Pocheon = new LatLng(37.894936, 127.200344); //마커 추가 예시

        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(Pocheon);
        markerOptions.title("포천시청");   //마커 옵션 추가
        googleMap.addMarker(markerOptions);  //마커 등록

        googleMap.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() {
            @Override
            public void onMapLoaded() {
                mgoogleMap.moveCamera(CameraUpdateFactory.newLatLng(Pocheon));
                mgoogleMap.animateCamera(CameraUpdateFactory.zoomTo(10));
            }
        });//구글맵 로딩이 완료되면 카메라 위치 조정
    }

}


