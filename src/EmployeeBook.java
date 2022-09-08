public class EmployeeBook {
    private final Employee[] book;
    private Employee currentEmployee;

    public EmployeeBook(Employee[] book) {
        this.book = book;
    }

    public void addEmployee(String lastName, String firstName, String patronymic, int department, int salary){
        for (int i = 0; i < book.length; i++) {
            if(book[i] == null){
                book[i] = new Employee(lastName, firstName, patronymic, department, salary);
                System.out.println("Employee added");
                return;
            }
        }
        System.out.println("Not enough place");
    }

    public void removeEmployee(int id){
        for (int i = 0; i < book.length; i++) {
            if(id == book[i].getId()){
                book[i] = null;
                System.out.println("Employee removed");
                return;
            }
        }
    }

    public void setSalary(int id, int salary) {
        for (Employee employee : book) {
            if (employee != null && employee.getId() == id) {
                employee.setSalary(salary);
                System.out.println("Salary changed to " + salary);
            }
        }
    }

    public void setDepartment(int id, int department) {
        for (Employee employee : book) {
            if (employee != null && employee.getId() == id) {
                employee.setDepartment(department);
                System.out.println("Department changed to " + department);
            }
        }
    }

    private String printSeparator(){
        return "-------------------------------------------------------------------\n";
    }

    public void printEmployees(){
        System.out.print(printSeparator());
        System.out.println("List of employees:");
        for (Employee employee : book) {
            if(employee != null){
                System.out.println(employee.getFullName());
            }
        }
        System.out.print(printSeparator());
    }

    public void printEmployeesByDepartments(){
        System.out.print(printSeparator());
        for (int i = 1; i <= Employee.DEPARTMENTS_COUNT; i++) {
            System.out.printf("List of employees of department №%d:\n", i);
            for (Employee employee : book) {
                if(employee != null && employee.getDepartment() == i){
                    System.out.println(employee.getFullName());
                }
            }
            System.out.println();
        }
        System.out.print(printSeparator());
    }

    public void printEmployeesData(int department) {
        System.out.print(printSeparator());
        System.out.printf("List of employees of department №%d:\n", department);
        for (Employee employee : book) {
            if(employee != null && employee.getDepartment() == department){
                System.out.println(employee.toString().replaceFirst(" Department: .", ""));
            }
        }
        System.out.print(printSeparator());
    }

    public double summarySalary(){
        double sum = 0;
        for (Employee employee : book) {
            if(employee != null){
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public double summarySalary(int department){
        double sum = 0;
        for (Employee employee : book) {
            if(employee != null && employee.getDepartment() == department){
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public double averageSalary(){
        int count = 0;
        for (Employee employee : book) {
            if(employee != null){
                count++;
            }
        }
        return summarySalary() / count;
    }

    public double averageSalary(int department){
        int count = 0;
        for (Employee employee : book) {
            if(employee != null && employee.getDepartment() == department){
                count++;
            }
        }
        return summarySalary(department) / count;
    }

    public void minSalaryEmployee(){
        double min = Double.MAX_VALUE;
        for (Employee employee : book) {
            if(employee == null){
                continue;
            }
            if(employee.getSalary() < min){
                min = employee.getSalary();
                currentEmployee = employee;
            }
        }
        System.out.println("Employee with minimal salary - " + currentEmployee);
    }

    public void minSalaryEmployee(int department){
        double min = Double.MAX_VALUE;
        for (Employee employee : book) {
            if(employee == null){
                continue;
            }
            if(employee.getDepartment() == department && employee.getSalary() < min){
                min = employee.getSalary();
                currentEmployee = employee;
            }
        }
        System.out.println("Employee with minimal salary at department № " + department + " - " + currentEmployee.toString().replaceFirst(" Department: .", ""));
    }

    public void maxSalaryEmployee(){
        double max = Double.MIN_VALUE;
        for (Employee employee : book) {
            if(employee == null){
                continue;
            }
            if(employee.getSalary() > max){
                max = employee.getSalary();
                currentEmployee = employee;
            }
        }
        System.out.println("Employee with maximum salary - " + currentEmployee);
    }

    public void maxSalaryEmployee(int department){
        double max = Double.MIN_VALUE;
        for (Employee employee : book) {
            if(employee == null){
                continue;
            }
            if(employee.getDepartment() == department && employee.getSalary() > max){
                max = employee.getSalary();
                currentEmployee = employee;
            }
        }
        System.out.println("Employee with maximum salary at department № " + department + " - " + currentEmployee.toString().replaceFirst(" Department: .", ""));
    }

    public void indexingSalary(double percent){
        for (Employee employee : book) {
            if(employee != null){
                employee.setSalary(employee.getSalary() * (1.0 + percent / 100));
            }
        }
        System.out.println("Indexing done");
    }

    public void indexingSalary(double percent, int department){
        for (Employee employee : book) {
            if(employee != null && employee.getDepartment() == department){
                employee.setSalary(employee.getSalary() * (1.0 + percent / 100));
            }
        }
        System.out.printf("Indexing of department №%d done\n", department);
    }

    public void employeesUnderThreshold(double threshold){
        System.out.print(printSeparator());
        System.out.printf("Employees with salary less than %s:\n", threshold);
        for (Employee employee : book) {
            if(employee != null && employee.getSalary() < threshold){
                System.out.println(employee.toString().replaceFirst(" Department: .", ""));
            }
        }
        System.out.print(printSeparator());
    }

    public void employeesOverThreshold(double threshold){
        System.out.print(printSeparator());
        System.out.printf("Employees with salary over %s:\n", threshold);
        for (Employee employee : book) {
            if(employee != null && employee.getSalary() >= threshold){
                System.out.println(employee.toString().replaceFirst(" Department: .", ""));
            }
        }
        System.out.print(printSeparator());
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(printSeparator());
        stringBuilder.append("List of employees:\n");
        for (Employee employee : book) {
            if(employee != null){
                stringBuilder.append(employee).append("\n");
            }
        }
        stringBuilder.append(printSeparator());
        return stringBuilder.toString();
    }
}
