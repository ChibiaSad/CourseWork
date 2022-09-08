public class Employee {
    private static int count = 1;
    public static final int DEPARTMENTS_COUNT = 5;
    private final String firstName;
    private final String lastName;
    private final String patronymic;
    private int department;
    private double salary;
    private final int id;

    public Employee(String lastName, String firstName, String patronymic, int department, double salary) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.department = department;
        this.salary = salary;
        id = count++;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public String getFullName(){
        return lastName + " " + firstName + " " + patronymic;
    }

    public void setDepartment(int department) {
        if(department > 0 && department <= Employee.DEPARTMENTS_COUNT){
            this.department = department;
        } else {
            throw new IllegalArgumentException("There is no department № " + department);
        }
    }

    public void setSalary(double salary){
        if (salary > 0) {
            this.salary = salary;
        } else {
            throw new IllegalArgumentException("Negative value of salary");
        }
    }

    @Override
    public String toString() {
        return "ID " + id + ": " + getFullName() + " Department: " + department + " Salary: " + String.format("%.2f",salary);
    }
}
