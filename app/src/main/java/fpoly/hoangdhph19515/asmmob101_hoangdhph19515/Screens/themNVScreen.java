package fpoly.hoangdhph19515.asmmob101_hoangdhph19515.Screens;

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

import fpoly.hoangdhph19515.asmmob101_hoangdhph19515.R;

public class themNVScreen extends AppCompatActivity {

    private EditText edtMaNV,edtTenNV,edtPhongBan;
    private Button btnThem,btnTroVe;
    private String id,name,phongBan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_them_nvscreen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        AnhXa();


        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = edtMaNV.getText().toString();
                name = edtTenNV.getText().toString();
                phongBan = edtPhongBan.getText().toString();
                if (id.isEmpty() || name.isEmpty() || phongBan.isEmpty()) {
                    Toast.makeText(themNVScreen.this,"moi nhap day du thong tin",Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent i = new Intent();
                i.putExtra("id",id);
                i.putExtra("name",name);
                i.putExtra("phongBan",phongBan);
                setResult(RESULT_OK,i);
                finish();
            }
        });
    }



    private void AnhXa() {
        edtMaNV = findViewById(R.id.edtMaNV);
        edtTenNV = findViewById(R.id.edtTenNV);
        edtPhongBan = findViewById(R.id.edtPhongBan);
        btnThem = findViewById(R.id.btnThem);
        btnTroVe = findViewById(R.id.btnTroVe);
    }
}