package fpoly.hoangdhph19515.asmmob101_hoangdhph19515.Screens;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

import fpoly.hoangdhph19515.asmmob101_hoangdhph19515.DataBases.InternalStorgeUser;
import fpoly.hoangdhph19515.asmmob101_hoangdhph19515.MainActivity;
import fpoly.hoangdhph19515.asmmob101_hoangdhph19515.Models.User;
import fpoly.hoangdhph19515.asmmob101_hoangdhph19515.R;

public class LoginScreen extends AppCompatActivity {

    private EditText edUsername, edPasword;
    private Button btnLogin, btnRegister;
    private InternalStorgeUser docghifile;
    private ArrayList<User> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_screen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edUsername = findViewById(R.id.edUsername);
        edPasword = findViewById(R.id.edPasword);


        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i = new Intent(LoginScreen.this, MainActivity.class);
//                startActivity(i);
                String userInput = edUsername.getText().toString();
                String passInput = edPasword.getText().toString();

                if (userInput.isEmpty() || passInput.isEmpty()) {
                    Toast.makeText(LoginScreen.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                    return;
                }
                docghifile = new InternalStorgeUser(LoginScreen.this);
                list = docghifile.ReadFromFile("user.txt");

                if (list == null) {
                    Toast.makeText(LoginScreen.this, "Sai tài khoản hoặc mật khẩu", Toast.LENGTH_SHORT).show();
                    return;
                }
                boolean loginSuccess = false;

                for (User u : list) {
                    if (u.getName().equals(userInput) && u.getPass().equals(passInput)) {
                        loginSuccess = true;
                        break;
                    }
                }
                if (loginSuccess) {
                    Toast.makeText(LoginScreen.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginScreen.this, StaffScreen.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginScreen.this, "Sai tài khoản hoặc mật khẩu", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginScreen.this, RegisterScreen.class);
                startActivityForResult(intent,99);
            }
        });
    }
}