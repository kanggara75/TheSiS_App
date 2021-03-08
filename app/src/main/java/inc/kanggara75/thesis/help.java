package inc.kanggara75.thesis;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class help extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bott_nav);

        bottomNavigationView.setSelectedItemId(R.id.nav_place);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.nav_home:
                        startActivity(new Intent(getApplicationContext()
                                ,MainMenu.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.nav_place:
                        startActivity(new Intent(getApplicationContext()
                                ,map.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.nav_alarm:
                        startActivity(new Intent(getApplicationContext()
                                ,Guest.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.nav_help:
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
    }
}
