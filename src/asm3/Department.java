package asm3;

public class Department {
    // Thuộc tính: mã bộ phận, tên bộ phận, số lượng nhân viên hiện tại
    private String id;
    private String name;
    private int totalStaff;
    public static String fmtDept = "%-20s|%-20s|%-30s";

    public Department() {
    }

    public Department(String id, String name, int totalStaff) {
        this.id = id;
        this.name = name;
        this.totalStaff = totalStaff;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalStaff() {
        return totalStaff;
    }

    public void setTotalStaff(int totalStaff) {
        this.totalStaff = totalStaff;
    }

    public String toString() {
        return String.format(fmtDept, this.getId(), this.getName(), this.getTotalStaff());

    }

}
