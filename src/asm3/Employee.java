package asm3;

public class Employee extends Staff implements ICalculator {

    private int overTime;
    // Format for display : Id, name, age , double , grade, dateOnBoard, department,
    // over time
    public static String fmtEmp = "%-10s|%-20s|%-5s|%-10s|%-20s|%-30s|%-10s|%-30f";

    public Employee(String id, String name, int age, double gradeSalary, String dateOnBoard, String department,
            int dayOff, double salary) {
        super(id, name, age, gradeSalary, dateOnBoard, department, dayOff, salary);
    }

    public int getOverTime() {
        return overTime;
    }

    public void setOverTime(int overTime) {
        this.overTime = overTime;
    }

    @Override
    public double calculateSalary() {
        // TODO Auto-generated method stub
        // Nhân viên: Hệ số lương * 3,000,000 + số giờ làm thêm * 200,000
        return (double) (getGradeSalary() * 3_000_000 + getOverTime() * 200_000);
    }

    @Override
    public void displayInformation() {
        // TODO Auto-generated method stub
        System.out.printf(fmtEmp, super.getId(), super.getName(), super.getAge(), super.getGradeSalary(),
                super.getDateOnBoard(), super.getDepartment(), super.getDayOff(), this.calculateSalary());

    }

}