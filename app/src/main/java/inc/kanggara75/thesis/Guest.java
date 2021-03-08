package inc.kanggara75.thesis;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class Guest extends AppCompatActivity {
    Button Logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bott_nav_guest);

        bottomNavigationView.setSelectedItemId(R.id.nav_guest);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.nav_guest:
                        return true;
                    case R.id.nav_track:
                        startActivity(new Intent(getApplicationContext()
                                ,Splash.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_ghelp:
                        startActivity(new Intent(getApplicationContext()
                                ,Splash.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.nav_gest:
                        startActivity(new Intent(getApplicationContext()
                                , user.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });

        Logout = findViewById(R.id.logout);

        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intToLogin = new Intent(Guest.this, Login.class);
                startActivity(intToLogin);
            }
        });
    }
}
