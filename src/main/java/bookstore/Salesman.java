package bookstore;

public class Salesman extends Worker {

    private int monthlyWage;

    @Override
    public int getMonthlyWage() {
        return monthlyWage;
    }

    public Salesman(String name, String surname, String email, int age, int monthlyWage) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.age = age;
        this.monthlyWage = monthlyWage;
    }

    @Override
    public String toString() {
        return "Salesman: " +
                "name '" + name + '\'' +
                ", surname '" + surname + '\'' +
                ", email '" + email + '\'' +
                ", age " + age +
                ", monthly wage " + monthlyWage;
    }
}