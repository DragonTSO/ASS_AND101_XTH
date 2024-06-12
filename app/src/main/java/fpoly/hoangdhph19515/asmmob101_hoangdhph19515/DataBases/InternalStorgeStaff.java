package fpoly.hoangdhph19515.asmmob101_hoangdhph19515.DataBases;

import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import fpoly.hoangdhph19515.asmmob101_hoangdhph19515.Models.Staff;

public class InternalStorgeStaff {
    private Context mContext;

    public InternalStorgeStaff(Context mContext) {
        this.mContext = mContext;
    }
    public void WriteToFile(ArrayList<Staff> arrayList, String fileName) {
        File fieldDir = mContext.getFilesDir();
        File file = new File(fieldDir,fileName);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(arrayList);
            outputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<Staff> ReadFromFile(String fileName) {
        ArrayList<Staff> arrayList = null;
        try {
            File fieldDir = mContext.getFilesDir();
            File file = new File(fieldDir,fileName);
            if (file.exists()) {
                ObjectInputStream inputStream = new
                        ObjectInputStream(new FileInputStream(file));
                arrayList = (ArrayList<Staff>) inputStream.readObject();
                inputStream.close();
                return arrayList;
            }
        }catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return arrayList;
    }
}
