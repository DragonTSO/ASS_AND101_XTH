package fpoly.hoangdhph19515.asmmob101_hoangdhph19515.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import fpoly.hoangdhph19515.asmmob101_hoangdhph19515.Models.Department;
import fpoly.hoangdhph19515.asmmob101_hoangdhph19515.Models.Staff;
import fpoly.hoangdhph19515.asmmob101_hoangdhph19515.R;

public class DepartmentAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Department> arrayListDepartment;
    public DepartmentAdapter(Context context, ArrayList<Department> arrayListDepartment) {
        this.context = context;
        this.arrayListDepartment = arrayListDepartment;
    }

    @Override
    public int getCount() {
        if (arrayListDepartment != null) return arrayListDepartment.size();
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup group) {
        view = LayoutInflater.from(context).inflate(R.layout.department_items, group, false);
        TextView tvNameDepartment = view.findViewById(R.id.tvNameDepartment);
        ImageView imgAvataDepartment = view.findViewById(R.id.imgAvataDepartment);

        Department department = arrayListDepartment.get(i);
        tvNameDepartment.setText(department.getName());
        imgAvataDepartment.setImageResource(department.getAvata());
        return view;
    }

}
