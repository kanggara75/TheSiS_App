package inc.kanggara75.thesis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Splash extends AppCompatActivity {

    private ImageView iv2;
    private ImageView iv3;

    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView iv1 = findViewById(R.id.iv1);
        iv2 = findViewById(R.id.iv2);
        iv3 = findViewById(R.id.iv3);

        animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.push_down);
        iv1.setAnimation(animation);

        animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.pus_right);
        iv2.setAnimation(animation);
        iv3.setAnimation(animation);

        Thread thread = new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    sleep(1000);
                    Intent intent = new Intent(getApplicationContext(), Login.class);
                    startActivity(intent);
                    finish();
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }

                super.run();
            }
        };
        thread.start();
    }
}
