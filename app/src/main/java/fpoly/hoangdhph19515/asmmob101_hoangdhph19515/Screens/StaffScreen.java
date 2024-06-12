package fpoly.hoangdhph19515.asmmob101_hoangdhph19515.Screens;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

import fpoly.hoangdhph19515.asmmob101_hoangdhph19515.Adapters.StaffAdapter;
import fpoly.hoangdhph19515.asmmob101_hoangdhph19515.DataBases.InternalStorgeStaff;
import fpoly.hoangdhph19515.asmmob101_hoangdhph19515.MainActivity;
import fpoly.hoangdhph19515.asmmob101_hoangdhph19515.Models.Staff;
import fpoly.hoangdhph19515.asmmob101_hoangdhph19515.R;

public class StaffScreen extends AppCompatActivity {
    private Button btndelete,btnThemNV,btnBackkk;
    private ListView lvStaffs;
    private StaffAdapter staffAdapter;
    private ArrayList<Staff> Arrstaffs;
    private String id,name,phongBan;
    private InternalStorgeStaff fileHelper;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_staff_screen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Anhxa();
        fileHelper = new InternalStorgeStaff(StaffScreen.this);
        Arrstaffs = fileHelper.ReadFromFile("nhanvien.txt");

        if (Arrstaffs == null) {
            Arrstaffs = new ArrayList<>();
        }

        staffAdapter = new StaffAdapter(StaffScreen.this, Arrstaffs);
        lvStaffs.setAdapter(staffAdapter);

        btnThemNV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(StaffScreen.this, themNVScreen.class);
                startActivityForResult(i, 99);
                Toast.makeText(StaffScreen.this, "NEXT SCREEN", Toast.LENGTH_SHORT).show();

            }
        });
        btnBackkk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(StaffScreen.this, MainActivity.class);
                startActivity(i);
                finish();

            }
        });
    }






        @Override
        protected void onActivityResult ( int requestCode, int resultCode, @Nullable Intent data){
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == RESULT_OK && requestCode == 99) {
                if (data != null && data.hasExtra("id") && data.hasExtra("name") && data.hasExtra("phongBan")) {
                    String idNV = data.getStringExtra("id");
                    String nameNV = data.getStringExtra("name");
                    String phongBanNV = data.getStringExtra("phongBan");

                    Staff nstaff = new Staff(idNV, nameNV, phongBanNV);
                    Arrstaffs.add(nstaff);
                    staffAdapter.notifyDataSetChanged();
                    fileHelper.WriteToFile(Arrstaffs, "nhanvien.txt");
                    Toast.makeText(this, "Thêm thành công !", Toast.LENGTH_SHORT).show();
                }
            }
        }
    private void Anhxa() {
        lvStaffs = findViewById(R.id.lvStaffs);
        btnThemNV = findViewById(R.id.btnAddNV);
        btnBackkk = findViewById(R.id.btnBackkk);
    }

}