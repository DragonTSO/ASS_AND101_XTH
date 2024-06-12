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

import fpoly.hoangdhph19515.asmmob101_hoangdhph19515.DataBases.InternalStorgeStaff;
import fpoly.hoangdhph19515.asmmob101_hoangdhph19515.DataBases.InternalStorgeUser;
import fpoly.hoangdhph19515.asmmob101_hoangdhph19515.Models.Staff;
import fpoly.hoangdhph19515.asmmob101_hoangdhph19515.R;
import fpoly.hoangdhph19515.asmmob101_hoangdhph19515.Screens.StaffScreen;

public class StaffAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Staff> staff;
    private InternalStorgeStaff fileHelper;
    private static final String FILE_NAME = "nhanvien.txt";

    public StaffAdapter(Context context, ArrayList<Staff> staff) {
        this.context = context;
        this.staff = staff;
    }

    @Override
    public int getCount() {
        if (staff != null) return staff.size();
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
    public View getView(int i, View view, ViewGroup g) {
        view = LayoutInflater.from(context).inflate(R.layout.staff_items, g , false);
        ///
        TextView tvMaNv = view.findViewById(R.id.tvMaNv);
        TextView tvHoTen = view.findViewById(R.id.tvHoTen);
        TextView tvPhongBan = view.findViewById(R.id.tvPhongBan);
        ///
        Staff s = staff.get(i);
        tvMaNv.setText(s.getMaNV());
        tvHoTen.setText(s.getTenNV());
        tvPhongBan.setText(s.getPhongBan());
        ///
        ImageView imgEdit = view.findViewById(R.id.imgEdit);
        ImageView imgDelete = view.findViewById(R.id.imgDelete);

        imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowDialogDelete(i);

            }
        });
        return view;
    }
    private void ShowDialogDelete(int index) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Xóa Nhân Viên");
        builder.setMessage("Bạn có chắc chắn muốn xóa nhân viên này?");
        builder.setPositiveButton("Có", (dialog, which) -> {
            staff.remove(index);
            fileHelper.WriteToFile(staff, FILE_NAME);
            notifyDataSetChanged();
            Toast.makeText(context, "Nhân viên đã được xóa", Toast.LENGTH_SHORT).show();
        });
        builder.setNegativeButton("Không", null);
        builder.show();
    }
}
