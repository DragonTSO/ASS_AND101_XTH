package fpoly.hoangdhph19515.asmmob101_hoangdhph19515.Screens;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

import fpoly.hoangdhph19515.asmmob101_hoangdhph19515.Adapters.DepartmentAdapter;
import fpoly.hoangdhph19515.asmmob101_hoangdhph19515.Models.Department;
import fpoly.hoangdhph19515.asmmob101_hoangdhph19515.R;

public class DepartmentScreen extends AppCompatActivity {

    private ListView lvDepartments;
    private DepartmentAdapter departmentAdapter;
    private ArrayList<Department> arrDepartments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_department_screen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Anhxa();
        arrDepartments = new ArrayList<>();
        Department department = new Department(R.drawable.baseline_home_work_24, "Nhan Su");
        arrDepartments.add(department);
        Department department1 = new Department(R.drawable.baseline_home_work_24, "Hanh Chinh");
        arrDepartments.add(department1);
        Department department2 = new Department(R.drawable.baseline_home_work_24, "Dao Tao");
        arrDepartments.add(department2);


        departmentAdapter = new DepartmentAdapter(DepartmentScreen.this, arrDepartments);
        lvDepartments.setAdapter(departmentAdapter);




    }

    private void Anhxa() {
        lvDepartments = findViewById(R.id.lvDepartments);
    }
}