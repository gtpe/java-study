package w6.override_2;

public class Main {

    static void printSalary(Employee e) {
        System.out.println(e.salary());
    }

    public static void main(String[] args) {
        Employee employee_1 = new Manager();
        System.out.print("Manager's salary: ");
        printSalary(employee_1);

        Employee employee_2 = new Clerk();
        System.out.print("Clerk's salary: ");
        printSalary(employee_2);
    }

}
