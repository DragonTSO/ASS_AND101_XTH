package fpoly.hoangdhph19515.asmmob101_hoangdhph19515;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import fpoly.hoangdhph19515.asmmob101_hoangdhph19515.Screens.DepartmentScreen;
import fpoly.hoangdhph19515.asmmob101_hoangdhph19515.Screens.LoginScreen;
import fpoly.hoangdhph19515.asmmob101_hoangdhph19515.Screens.StaffScreen;

public class MainActivity extends AppCompatActivity {

    private LinearLayout imgDepartment,imgStaff,imgExit;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        imgDepartment = findViewById(R.id.imgDepartment);
        imgStaff = findViewById(R.id.imgStaff);
        imgExit = findViewById(R.id.imgExit);

        imgExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginScreen.class);
                startActivity(intent);
                finish();
            }
        });
        imgStaff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // chuyển qua màn  nhân viên
                Intent intent = new Intent(MainActivity.this, StaffScreen.class);
                startActivity(intent);

                // Code Here

                //Destroy màn này
                finish();
            }
        });
        imgDepartment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DepartmentScreen.class);
                startActivity(intent);
                // Code Here

                //Destroy màn này
                finish();
            }
        });
    }
}