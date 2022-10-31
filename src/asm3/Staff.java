package asm3;

public abstract class Staff {
    // Thuộc tính: mã nhân viên, tên nhân viên, tuổi nhân viên, hệ số lương, ngày
    // vào làm, bộ phận làm việc, số ngày nghỉ phép
    private String id;
    private String name;
    private int age;
    private double gradeSalary;
    private String dateOnBoard;
    private String department;
    private int dayOff;
    private double salary;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Staff(String id, String name, int age, double gradeSalary, String dateOnBoard, String department,
            int dayOff, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gradeSalary = gradeSalary;
        this.dateOnBoard = dateOnBoard;
        this.department = department;
        this.dayOff = dayOff;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getGradeSalary() {
        return gradeSalary;
    }

    public String getDateOnBoard() {
        return dateOnBoard;
    }

    public String getDepartment() {
        return department;
    }

    public int getDayOff() {
        return dayOff;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGradeSalary(double gradeSalary) {
        this.gradeSalary = gradeSalary;
    }

    public void setDateOnBoard(String dateOnBoard) {
        this.dateOnBoard = dateOnBoard;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setDayOff(int dayOff) {
        this.dayOff = dayOff;
    }

    public abstract double calculateSalary();

    public abstract void displayInformation();

}
