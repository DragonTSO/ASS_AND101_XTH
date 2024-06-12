package fpoly.hoangdhph19515.asmmob101_hoangdhph19515.Screens;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

import java.text.BreakIterator;
import java.util.ArrayList;

import fpoly.hoangdhph19515.asmmob101_hoangdhph19515.DataBases.InternalStorgeUser;
import fpoly.hoangdhph19515.asmmob101_hoangdhph19515.Models.User;
import fpoly.hoangdhph19515.asmmob101_hoangdhph19515.R;

public class RegisterScreen extends AppCompatActivity {

    private Button btnRLogin,btnRBacktoLogin;
    private EditText edRUsername,edRPasword,edtRPassword;
    private InternalStorgeUser docghifile;
    private ArrayList<User> list = new ArrayList<>();
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register_screen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edRUsername = findViewById(R.id.edRUsername);
        edRPasword = findViewById(R.id.edRPasword);
        edtRPassword = findViewById(R.id.edRConfirmPassword);
        String name = edRUsername.getText().toString();
        String password = edRPasword.getText().toString();

        // ánh xạ
        btnRLogin = findViewById(R.id.btnRLogin);
        btnRBacktoLogin = findViewById(R.id.btnRBacktoLogin);

        btnRLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userInput = edRUsername.getText().toString();
                String passInput = edRPasword.getText().toString();
                String rePassInput = edtRPassword.getText().toString();
                if (userInput.isEmpty() || passInput.isEmpty() || rePassInput.isEmpty()) {
                    Toast.makeText(RegisterScreen.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!passInput.equals(rePassInput)) {
                    Toast.makeText(RegisterScreen.this, "Mật khẩu không khớp", Toast.LENGTH_SHORT).show();
                    return;
                }
                User newUser = new User(userInput, passInput);
                docghifile = new InternalStorgeUser(RegisterScreen.this);
                list = docghifile.ReadFromFile("user.txt");

                if (list == null) {
                    list = new ArrayList<>();
                }
                list.add(newUser);
                docghifile.WriteToFile(list, "user.txt");
                Toast.makeText(RegisterScreen.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();

                finish();
               /* // chck xem có rỗng ko
                if (edRPasword.equals(edtRPassword)) {
                        Intent i = new Intent();
                        Bundle b = new Bundle();
                        b.putString("name",name);
                        b.putString("password",password);
                        i.putExtras(b);
                        setResult(RESULT_OK,i);
                        finish();
                    }else Toast.makeText(RegisterScreen.this, "Mật khẩu không khớp", Toast.LENGTH_SHORT).show();

                // nếu không rỗng thì thực hiện chuyển dữ liệu qua activity đăng nhập
*/
            }
        });
        btnRBacktoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}