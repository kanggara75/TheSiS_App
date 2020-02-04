package inc.kanggara75.thesis;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class reset extends AppCompatActivity {

    private Button reset;
    private EditText email;
    private FirebaseAuth user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset);

        reset = findViewById(R.id.reset_btn);
        email = findViewById(R.id.email);
        user = FirebaseAuth.getInstance();

        email.setOnKeyListener(new View.OnKeyListener()
        {
            public boolean onKey(View v, int keyCode, KeyEvent event)
            {
                String mail = email.getText().toString().trim();
                if (event.getAction() == KeyEvent.ACTION_DOWN)
                {
                    switch (keyCode)
                    {
                        case KeyEvent.KEYCODE_DPAD_CENTER:
                        case KeyEvent.KEYCODE_ENTER:
                            if (mail.isEmpty()){
                                email.setError("Please Enter Your E-Mail...");
                                email.requestFocus();
                            }
                            else
                                user.sendPasswordResetEmail(mail).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()){
                                            new Handler().postDelayed(new Runnable() {
                                                @Override
                                                public void run() {
                                                    Toast.makeText(reset.this, "Please Check your email for set new Password", Toast.LENGTH_SHORT).show();
                                                    finish();
                                                    startActivity(new Intent(reset.this, Login.class));
                                                }
                                            }, 1500);
                                        }
                                        else {
                                            new Handler().postDelayed(new Runnable() {
                                                @Override
                                                public void run() {
                                                    Toast.makeText(reset.this, "Email not Sent Try Again", Toast.LENGTH_SHORT).show();
                                                }
                                            }, 1500);
                                        }
                                    }
                                });
                        default:
                            break;
                    }
                }
                return false;
            }
        });


        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail = email.getText().toString().trim();
                if (mail.isEmpty()){
                    email.setError("Please Enter Your E-Mail...");
                    email.requestFocus();
                }
                else
                    user.sendPasswordResetEmail(mail).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(reset.this, "Please Check your email for set new Password", Toast.LENGTH_SHORT).show();
                                        finish();
                                        startActivity(new Intent(reset.this, Login.class));
                                    }
                                }, 1500);
                            }
                            else {
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(reset.this, "Email not Sent Try Again", Toast.LENGTH_SHORT).show();
                                    }
                                }, 1500);
                            }
                        }
                    });
            }
        });
    }
}