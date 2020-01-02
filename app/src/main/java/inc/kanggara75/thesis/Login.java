package inc.kanggara75.thesis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Login extends AppCompatActivity {
    private ImageView loginiv1;
    private EditText loginiv2, loginiv3;
    private Button loginiv4;
    private TextView loginiv5;
    private LinearLayout loginll2;

    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginiv1 = (ImageView) findViewById(R.id.loginiv1);
        loginiv2 = (EditText) findViewById(R.id.loginiv2);
        loginiv3 = (EditText) findViewById(R.id.loginiv3);
        loginiv4 = (Button) findViewById(R.id.loginiv4);
        loginiv5 = (TextView) findViewById(R.id.loginiv5);
        loginll2 = (LinearLayout) findViewById(R.id.loginll2);

        animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.push_down);
        loginiv1.setAnimation(animation);
        loginiv5.setAnimation(animation);

        animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.pus_right);
        loginll2.setAnimation(animation);
    }
}
