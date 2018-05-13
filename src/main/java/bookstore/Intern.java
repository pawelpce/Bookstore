package bookstore;

public class Intern extends Worker {

    private int workingHoursInAMonth;
    private final int hourlyRate = 10;

    @Override
    public int getMonthlyWage() {
        return hourlyRate*getWorkingHoursInAMonth();
    }

    public Intern(String name, String surname, String email, int age, int workingHoursInAMonth) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.age = age;
        this.workingHoursInAMonth = workingHoursInAMonth;
    }

    public int getWorkingHoursInAMonth() {
        return workingHoursInAMonth;
    }

    @Override
    public String toString() {
        return "Intern: " +
                "name '" + name + '\'' +
                ", surname '" + surname + '\'' +
                ", email '" + email + '\'' +
                ", age " + age +
                ", working hours in a month " + workingHoursInAMonth +
                ", hourly rate " + hourlyRate;
    }
}