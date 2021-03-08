package inc.kanggara75.thesis;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class map extends FragmentActivity implements OnMapReadyCallback {

    GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bott_nav);

        bottomNavigationView.setSelectedItemId(R.id.nav_place);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.nav_home:
                        startActivity(new Intent(getApplicationContext()
                                ,Guest.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.nav_place:
                        return true;
                    case R.id.nav_alarm:
                        startActivity(new Intent(getApplicationContext(),Guest.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.nav_help:
                        startActivity(new Intent(getApplicationContext()
                                ,help.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.nav_user:
                        startActivity(new Intent(getApplicationContext()
                                , user.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;

        LatLng pku = new LatLng(0.470077, 101.363678);
        map.addMarker(new MarkerOptions().position(pku).title("Pekanbaru Panam"));
        map.moveCamera(CameraUpdateFactory.newLatLng(pku));
    }
}
