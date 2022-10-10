package asm3;

public class Manager extends Staff implements ICalculator {
    private String title;

    public Manager(String id, String name, int age, double gradeSalary, String dateOnBoard, String department,
            int dayOff, String title, double salary) {
        super(id, name, age, gradeSalary, dateOnBoard, department, dayOff, salary);
        this.title = title;
    }

    @Override
    public void displayInformation() {
        // TODO Auto-generated method stub

    }

    @Override
    public double calculateSalary() {
        // TODO Auto-generated method stub
        // Quản lý: Hệ số lương * 5,000,000 + lương trách nhiệm
        if (title.equals("Business Leader")) {
            return getGradeSalary() * 5_000_000 + 8_000_000;
        } else if (title.equals("Project Leader")) {
            return getGradeSalary() * 5_000_000 + 5_000_000;
        } else if (title.equals("Technical Leader")) {
            return getGradeSalary() * 5_000_000 + 6_000_000;
        }
        return 0;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
