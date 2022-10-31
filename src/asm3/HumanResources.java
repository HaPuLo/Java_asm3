package asm3;

import static asm3.Employee.fmtEmp;
import static asm3.Department.fmtDept;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class HumanResources {

    private static ArrayList<Department> departments;
    private static ArrayList<Staff> employees;

    static {
        departments = new ArrayList<>();
        employees = new ArrayList<>();

        // Add in Department

        departments.add(new Department("IT", "Cong nghe thong tin", 2));
        departments.add(new Department("MKT", "Maketing", 2));
        departments.add(new Department("MKT", "Hanh chinh nhan su", 2));

        // Add in Staffs
        // Thuộc tính: mã nhân viên, tên nhân viên, tuổi nhân viên, hệ số lương, ngày
        // vào làm, bộ phận làm việc, số ngày nghỉ phép
        // MSNV,Ten,Tuoi,He so LUong, Ngay vao lam, Phong ban, so ngay nghi
        employees.add(new Employee("E001", "Nguyen Van A", 23, 6.2, "23/01/2022", "Maketing", 4, 5, 0));
        employees.add(new Employee("E002", "Nguyen Van B", 25, 5.2, "23/01/2022", "Cong nghe thong tin", 4, 1, 0));
        employees.add(new Employee("E002", "Nguyen Van C", 25, 5.2, "23/01/2022", "Cong nghe thong tin", 4, 2, 0));
        employees.add(new Manager("M002", "Nguyen Van D", 40, 5.2, "23/01/2012", "Hanh chinh nhan su", 4,
                "Business Leader", 0));
    }

    // Display Department list
    public static void displayDepartment() {
        // Count nubmer of employee
        int totalEmployee = 0;
        for (int i = 0; i < departments.size(); i++) {
            for (int j = 0; j < employees.size(); j++) {
                if (employees.get(j).getDepartment().equals(departments.get(i).getName())) {
                    totalEmployee += 1;
                }
            }
            departments.get(i).setTotalStaff(totalEmployee);
            totalEmployee = 0;
        }
        System.out.printf(fmtDept, "Ma bo phan", "Ten Phong Ban", "So luong nhan vien hien tai");
        System.out.println();
        String dashLineDept = "-".repeat(70);
        System.out.println(dashLineDept);
        for (int i = 0; i < departments.size(); i++) {
            System.out.println(departments.get(i).toString());
        }
    }

    // Display Staff list
    public static void displayEmployee() {
        System.out.printf(fmtEmp, "MSNV", "Name", "Age", "Grade", "Day of Join", "Department", "Day Off", "OT/Title",
                "Salary");
        System.out.println();
        String dashLineEmp = "-".repeat(120);
        System.out.println(dashLineEmp);
        for (int i = 0; i < employees.size(); i++) {
            employees.get(i).displayInformation();
            System.out.println();
        }
    }

    public static void displayEmployeeAndDept() {
        for (int i = 0; i < departments.size(); i++) {
            System.out.println(departments.get(i).getName());
            System.out.printf(fmtEmp, "MSNV", "Name", "Age", "Grade", "Day of Join", "Department", "Day Off", "OT",
                    "Salary");
            String dashLineEmp = "-".repeat(120);
            System.out.println();
            System.out.println(dashLineEmp);
            for (int j = 0; j < employees.size(); j++) {
                if (employees.get(j).getDepartment().equals(departments.get(i).getName())) {
                    employees.get(j).displayInformation();
                    System.out.println();
                }
            }
        }
    }

    public static void addEmployees() {
        System.out.println("1. Them nhan vien thong thuong");
        System.out.println("2. Them nhan vien la cap quan ly (co them chuc vu).");

        Scanner input = new Scanner(System.in);

        int choiceAddStaff = -1;

        do {
            try {
                System.out.print("Ban chon: ");
                choiceAddStaff = Integer.parseInt(input.nextLine());
                System.out.println(choiceAddStaff);

            } catch (Exception ex) {
                System.out.println("Bạn nhap lỗi");

            }
        } while (choiceAddStaff != 1 && choiceAddStaff != 2);

        switch (choiceAddStaff) {
            case 1:
                System.out.println("Nhap ma nhan vien: ");

                String employeesId = input.nextLine();
                System.out.println("Nhap ten nhan vien: ");

                String employeeName = input.nextLine();
                System.out.println("Nhap tuoi nhan vien: ");

                int employeeAge = Integer.parseInt(input.nextLine());
                System.out.println("Nhap he so luong cua nhan vien: ");

                double employeeSalaryGrade = Double.parseDouble(input.nextLine());
                System.out.println("Nhap ngay vao lam cua nhan vien: ");
                String employeeOnboardDay = input.nextLine();

                System.out.println("Nhap so ngay nghi phep cua nhan vien: ");
                int employeeOffDay = Integer.parseInt(input.nextLine());

                System.out.println("Nhap so gio lam them: ");
                int employeeOT = Integer.parseInt(input.nextLine());

                System.out.println("1. HC - Hanh chinh nhan su");
                System.out.println("2. IT - Cong nghe thong tin");
                System.out.println("3. MKT - Marketing");
                System.out.println("Ban chon bo phan: ");

                int deptChoice = Integer.parseInt(input.nextLine());
                String employeeDept = "";
                if (deptChoice == 1) {
                    employeeDept = "Hanh chinh nhan su";
                } else if (deptChoice == 2) {
                    employeeDept = "Cong nghe thong tin";
                } else if (deptChoice == 3) {
                    employeeDept = "Marketing";
                }
                double employeeSalary = 0;

                // "MSNV", "Name", "Age", "Grade", "Day of Join", "Department", "Day Off",
                // "Salary");
                employees.add(new Employee(employeesId, employeeName, employeeAge,
                        employeeSalaryGrade, employeeOnboardDay, employeeDept, employeeOffDay, employeeOT,
                        employeeSalary));
                break;
            case 2:
                System.out.println("Nhap ma nhan vien: ");
                String managerId = input.nextLine();

                System.out.println("Nhap ten nhan vien: ");
                String managerName = input.nextLine();

                System.out.println("Nhap tuoi nhan vien: ");
                int ManagerAge = Integer.parseInt(input.nextLine());

                System.out.println("Nhap he so luong cua nhan vien: ");
                Double ManagerSalaryGrade = Double.parseDouble(input.nextLine());

                System.out.println("Nhap ngay vao lam cua nhan vien: ");

                String ManagerOnboardDay = input.nextLine();
                System.out.println("Nhap so ngay nghi phep cua nhan vien: ");
                int ManagerOffDay = Integer.parseInt(input.nextLine());

                System.out.println("1. HC - Hanh chinh nhan su");
                System.out.println("2. IT - Cong nghe thong tin");
                System.out.println("3. MKT - Marketing");
                System.out.println("Ban chon bo phan: ");

                int managerDeptChoice = Integer.parseInt(input.nextLine());
                String managerDept = "";
                if (managerDeptChoice == 1) {
                    managerDept = "Hanh chinh nhan su";
                } else if (managerDeptChoice == 2) {
                    managerDept = "Cong nghe thong tin";
                } else if (managerDeptChoice == 3) {
                    managerDept = "Marketing";
                }
                String managerTitle = "";
                System.out.println("Chuc danh: ");
                System.out.println("1. Business Leader");
                System.out.println("2. Project Leader");
                System.out.println("3. Technical Leader");
                int managerTitleChoice = Integer.parseInt(input.nextLine());
                if (managerTitleChoice == 1) {
                    managerTitle = "Business Leader";
                } else if (managerTitleChoice == 2) {
                    managerTitle = "Project Leader";
                } else if (managerTitleChoice == 3) {
                    managerTitle = "Technical Leader";
                }
                int managerSalary = 0;
                // Manager(String id, String name, int age, double gradeSalary, String
                // dateOnBoard, String department,
                // int dayOff, String title, double salary)
                employees.add(new Manager(managerId, managerName, ManagerAge, ManagerSalaryGrade, ManagerOnboardDay,
                        managerDept, ManagerOffDay, managerTitle, managerSalary));
        }

    }

    public static void searchingEmployee() {
        System.out.println("1. Tim nhan vien theo MSNV: ");
        System.out.println("2. Tim nhan vien theo ten: ");
        Scanner inputSearching = new Scanner(System.in);
        int choice = 0;
        do {
            try {
                System.out.print("Chi duoc chon 1 hoac 2: ");
                choice = Integer.parseInt(inputSearching.nextLine());

            } catch (Exception ex) {
                System.out.println("Ban nhap loi");

            }
        } while (choice != 0 && choice != 1 && choice != 2);

        switch (choice) {
            case 1:
                // Search by employee id
                System.out.println("Nhap ma nhan vien: ");
                String employeeId = inputSearching.nextLine();
                Boolean employeeCheckID = false;
                // Searching
                for (int i = 0; i < employees.size(); i++) {
                    if (employees.get(i).getId().equals(employeeId)) {
                        System.out.println("Nhan vien ban can tim: ");
                        System.out.printf(fmtEmp, "MSNV", "Name", "Age", "Grade", "Day of Join", "Department",
                                "Day Off", "OT/Title",
                                "Salary");
                        System.out.println();
                        String dashLineEmp = "-".repeat(120);
                        System.out.println(dashLineEmp);
                        employees.get(i).displayInformation();
                        System.out.println();
                        employeeCheckID = true;
                    }
                }
                if (employeeCheckID == false) { // There's no employee at all
                    System.out.println("Xin loi khong co thong tin nhan vien ban can tim ");
                }
                break;
            case 2:
                System.out.println("Nhap ten nhan vien");
                String employeeName = inputSearching.nextLine();
                Boolean employeeChecName = false;
                for (int i = 0; i < employees.size(); i++) {
                    if (employees.get(i).getName().contains(employeeName)) {
                        System.out.println("Nhan vien ban can tim: ");
                        System.out.printf(fmtEmp, "MSNV", "Name", "Age", "Grade", "Day of Join", "Department",
                                "Day Off", "OT/Title",
                                "Salary");
                        System.out.println();
                        String dashLineEmp = "-".repeat(120);
                        System.out.println(dashLineEmp);
                        employees.get(i).displayInformation();
                        System.out.println();
                        employeeChecName = true;
                    }
                }
                if (employeeChecName == false) { // There's no employee at all
                    System.out.println("Xin loi khong co thong tin nhan vien ban can tim ");
                }
                break;

        }
    }

    public static void displaySalaryAll() {
        Collections.sort(employees, new Comparator<Staff>() {
            @Override
            public int compare(Staff o1, Staff o2) {
                double value1 = o1.calculateSalary();
                double value2 = o2.calculateSalary();
                if (value1 > value2) {
                    return 1;
                } else if (value1 < value2) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        System.out.printf(fmtEmp, "MSNV", "Name", "Age", "Grade", "Day of Join", "Department",
                "Day Off", "OT/Title",
                "Salary");
        System.out.println();
        String dashLineEmp = "-".repeat(150);
        System.out.println(dashLineEmp);
        for (int i = 0; i < employees.size(); i++) {
            employees.get(i).displayInformation();
            System.out.println();
        }
    }

    public static void displaySalaryAllDecending() {
        Collections.sort(employees, new Comparator<Staff>() {
            @Override
            public int compare(Staff o1, Staff o2) {
                double value1 = o1.calculateSalary();
                double value2 = o2.calculateSalary();
                if (value1 < value2) {
                    return 1;
                } else if (value1 > value2) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        System.out.printf(fmtEmp, "MSNV", "Name", "Age", "Grade", "Day of Join", "Department",
                "Day Off", "OT/Title",
                "Salary");
        System.out.println();
        String dashLineEmp = "-".repeat(150);
        System.out.println(dashLineEmp);
        for (int i = 0; i < employees.size(); i++) {
            employees.get(i).displayInformation();
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        do {
            System.out.println("1. Hien thi danh sach cac nhan vien co trong cong ty.");
            System.out.println("2. Hien thi cac bo phan trong cong ty.");
            System.out.println("3. Hien thi cac nhan vien theo tung bo phan.");
            System.out.println("4. Them nhan vien moi vao cong ty.");
            System.out.println("5. Tim kiem thong tin nhan vien theo ten hoac ma nhan vien.");
            System.out.println("6. Hhien thi bang luong cua nhan vien toan cong ty.");
            System.out.println("7. Hien thi bang luong cua nhan vien toan cong ty theo thu tu tang dan.");
            System.out.println("8. Thoat chuong trinh.");

            int choice = 0;
            do {
                try {
                    System.out.print("Lua chon cua ban: ");
                    choice = Integer.parseInt(input.nextLine());

                } catch (Exception ex) {
                    System.out.println("Ban nhap loi");

                }

            } while (choice != 0 && choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5
                    && choice != 6
                    && choice != 7 && choice != 8);
            switch (choice) {
                case 1:
                    displayEmployee();
                    break;
                case 2:
                    displayDepartment();
                    break;
                case 3:
                    displayEmployeeAndDept();
                    break;
                case 4:
                    addEmployees();
                    break;
                case 5:
                    searchingEmployee();
                    break;
                case 6:
                    displaySalaryAll();
                    break;
                case 7:
                    displaySalaryAllDecending();
                    break;
                case 8:
                    System.exit(0);
            }

        } while (true);

    }

}
