public class Main {
    public static void main(String[] args){
        EmployeeBook book = new EmployeeBook(new Employee[10]);
        book.addEmployee("Иванов", "Иван", "Макарыч", 2, 62000);
        book.addEmployee("Николаев", "Дмитрий", "Юрьевич", 3, 71000);
        book.addEmployee("Женская", "Мария", "Никитична", 1, 60000);
        book.addEmployee("Цаль", "Виталий", "Олегович", 5, 53000);
        book.addEmployee("Заозерский", "Кирилл", "Александрович", 3, 80000);
        book.addEmployee("Саксон", "Ольга", "Артуровна", 2, 68000);
        book.addEmployee("Мехова", "Александра", "Владимировна", 4, 60000);
        book.addEmployee("Богданов", "Богдан", "Богданович", 3, 55000);
        book.addEmployee("Бровный", "Андрюха-Лёха", "Петрович", 1, 65000);
        book.addEmployee("Пивной", "Человек", "Последнийвич", 5, 61500);
        book.addEmployee("Иванов", "Иван", "Макарыч", 2, 62000);
        System.out.println(book);

        book.removeEmployee(1);
        System.out.println(book);
        book.addEmployee("Иванов", "Иван", "Макарыч", 2, 62000);
        System.out.println(book);

        book.printEmployeesByDepartments();
        book.changeEmployeeData(11, 65000);
        book.changeEmployeeData(11, 4);
        book.printEmployeesByDepartments();
        book.printEmployeesData(4);

        book.indexingSalary(10);
        System.out.println(book);

        book.indexingSalary(5, 2);
        System.out.println(book);

        System.out.println("Сумма зарплат\t\t" + book.summarySalary());
        System.out.println("Средняя зарплата\t" + book.averageSalary());
        System.out.println("Сотрудник с минимальной зарплатой\t" + book.minSalaryEmployee());
        System.out.println("Сотрудник с максимальной зарплатой\t" + book.maxSalaryEmployee());
        System.out.println("Сотрудник с минимальной зарплатой в 3 отделе " + book.minSalaryEmployee(3));
        System.out.println("Сотрудник с максимальной зарплатой в 2 отделе " + book.maxSalaryEmployee(2));
        System.out.printf("Средняя зарплата в 3 отделе %.2f\n", book.averageSalary(3));

        book.employeesUnderThreshold(65000);
        book.employeesOverThreshold(65000);

        book.printEmployees();
//        Employee employee1 = new Employee("Иванов", "Иван", "Макарыч", 2, 62000);
//        Employee employee2 = new Employee("Николаев", "Дмитрий", "Юрьевич", 3, 71000);
//        Employee employee3 = new Employee("Женская", "Мария", "Никитична", 1, 60000);
//        Employee employee4 = new Employee("Цаль", "Виталий", "Олегович", 5, 53000);
//        Employee employee5 = new Employee("Заозерский", "Кирилл", "Александрович", 3, 80000);
//        Employee employee6 = new Employee("Саксон", "Ольга", "Артуровна", 2, 68000);
//        Employee employee7 = new Employee("Мехова", "Александра", "Владимировна", 4, 60000);
//        Employee employee8 = new Employee("Богданов", "Богдан", "Богданович", 3, 55000);
//        Employee employee9 = new Employee("Бровный", "Андрюха-Лёха", "Петрович", 1, 65000);
//        Employee employee10 = new Employee("Пивной", "Человек", "Последнийвич", 5, 61500)
    }
}