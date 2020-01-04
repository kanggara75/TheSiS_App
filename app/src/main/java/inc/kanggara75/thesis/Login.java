package inc.kanggara75.thesis;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity
{
    EditText username, password;
    Button signin;

    Animation animation;
    FirebaseAuth login;

    private FirebaseAuth.AuthStateListener loginListener;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        LinearLayout loginll2 = findViewById(R.id.loginll2);
        animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.pus_right);
        loginll2.setAnimation(animation);

        login = FirebaseAuth.getInstance();
        username = findViewById(R.id.loginiv2);
        password = findViewById(R.id.loginiv3);
        signin = findViewById(R.id.loginiv4);

        loginListener = new FirebaseAuth.AuthStateListener()
        {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth)
            {
                FirebaseUser userLogin = login.getCurrentUser();
                if (userLogin != null)
                {
                    Toast.makeText(Login.this, "Anda telah Log In",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Login.this, MainMenu.class);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(Login.this, "Please Log In",Toast.LENGTH_SHORT).show();
                }

            }
        };

        signin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                if(user.isEmpty())
                {
                    username.setError("Please Enter Your Username");
                    username.requestFocus();
                }
                else if(pass.isEmpty())
                {
                    password.setError("Your Password is Blank, Enter your password Please");
                    password.requestFocus();
                }
                else if(user.isEmpty() && pass.isEmpty())
                {
                    Toast.makeText(Login.this, "Field Are Empty!!",Toast.LENGTH_SHORT).show();
                }
                else if(!(user.isEmpty() && pass.isEmpty()))
                {
                    login.signInWithEmailAndPassword(user, pass).addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>()
                    {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task)
                        {
                            if (!task.isSuccessful())
                            {
                                Toast.makeText(Login.this, "Login Fail, Try Again",Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                Intent intToMainMenu = new Intent(Login.this, MainMenu.class);
                                startActivity(intToMainMenu);
                            }
                        }
                    });
                }
                else
                {
                    Toast.makeText(Login.this, "Error!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        login.addAuthStateListener(loginListener);
    }
}
