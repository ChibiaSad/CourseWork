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
        System.out.println("Not enough place");                 // можно добавить расширение массива если места нет
    }

    public void removeEmployee(int id){                         // не понимаю зачем нужен поиск по ФИО и id, если id уникальный, а ФИО нет
        for (int i = 0; i < book.length; i++) {
            if(id == book[i].getId()){
                book[i] = null;
                System.out.println("Employee removed");
                return;
            }
        }
    }

    public void changeEmployeeData(int id, int salaryOrDepart){
        for (Employee employee : book) {
            if (employee.getId() == id) {
                if(salaryOrDepart > 0 && salaryOrDepart <= Employee.DEPARTMENTS_COUNT){
                    employee.setDepartment(salaryOrDepart);
                    System.out.println("Department changed to " + salaryOrDepart);
                }else {
                    employee.setSalary(salaryOrDepart);
                    System.out.println("Salary changed to " + salaryOrDepart);
                }
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

    public void printEmployeesDate(int department) {
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

    public Employee minSalaryEmployee(){
        searchNotNull();
        for (Employee employee : book) {
            if(employee == null){
                continue;
            }
            if(employee.getSalary() < currentEmployee.getSalary()){
                currentEmployee = employee;
            }
        }
        return currentEmployee;
    }

    public Employee minSalaryEmployee(int department){
        searchNotNullInDepartment(department);
        for (Employee employee : book) {
            if(employee == null){
                continue;
            }
            if(employee.getDepartment() == department && employee.getSalary() < currentEmployee.getSalary()){
                currentEmployee = employee;
            }
        }
        return currentEmployee;
    }

    public Employee maxSalaryEmployee(){
        searchNotNull();
        for (Employee employee : book) {
            if(employee == null){
                continue;
            }
            if(employee.getSalary() > currentEmployee.getSalary()){
                currentEmployee = employee;
            }
        }
        return currentEmployee;
    }

    public Employee maxSalaryEmployee(int department){
        searchNotNullInDepartment(department);
        for (Employee employee : book) {
            if(employee == null){
                continue;
            }
            if(employee.getDepartment() == department && employee.getSalary() > currentEmployee.getSalary()){
                currentEmployee = employee;
            }
        }
        return currentEmployee;
    }

    private void searchNotNull(){
        for (Employee employee : book) {
            if(employee != null){
                currentEmployee = employee;
                return;
            }
        }
    }

    private void searchNotNullInDepartment(int department){
        for (Employee employee : book) {
            if(employee != null && employee.getDepartment() == department){
                currentEmployee = employee;
                return;
            }
        }
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
