package inc.kanggara75.thesis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Login extends AppCompatActivity {

    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        LinearLayout loginll2 = findViewById(R.id.loginll2);
        animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.pus_right);
        loginll2.setAnimation(animation);
    }
}
