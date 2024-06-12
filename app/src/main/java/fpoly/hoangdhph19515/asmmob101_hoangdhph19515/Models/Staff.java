package fpoly.hoangdhph19515.asmmob101_hoangdhph19515.Models;

public class Staff {
    private String maNV, tenNV,phongBan;

    public Staff(String maNV, String tenNV, String phongBan) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.phongBan = phongBan;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(String phongBan) {
        this.phongBan = phongBan;
    }

    public Staff() {
    }
}
