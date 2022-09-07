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
        book.setSalary(11, 65000);
        book.setDepartment(11, 4);
        book.printEmployeesByDepartments();
        book.printEmployeesData(4);

        book.indexingSalary(10);
        System.out.println(book);

        book.indexingSalary(5, 2);
        System.out.println(book);

        System.out.println("Sum of salaries\t" + book.summarySalary());
        System.out.println("Average salary\t" + book.averageSalary());
        book.minSalaryEmployee();
        book.maxSalaryEmployee();
        book.minSalaryEmployee(3);
        book.maxSalaryEmployee(2);
        System.out.printf("Average salary at department 3 - %.2f\n", book.averageSalary(3));

        book.employeesUnderThreshold(65000);
        book.employeesOverThreshold(65000);

        book.printEmployees();
    }
}