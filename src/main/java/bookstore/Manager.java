package bookstore;

public class Manager extends Worker {

    private int phoneNumber;
    private int hourlyRate;

    @Override
    public int getMonthlyWage() {

        return getHourlyRate()*160;
    }

    public Manager(String name, String surname, String email, int age, int phoneNumber, int hourlyRate) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.hourlyRate = hourlyRate;
    }

    public int getHourlyRate() {
        return hourlyRate;
    }

    @Override
    public String toString() {
        return "Manager: " +
                "name '" + name + '\'' +
                ", surname '" + surname + '\'' +
                ", email '" + email + '\'' +
                ", age " + age +
                ", phone number " + phoneNumber +
                ", hourly rate " + hourlyRate;
    }
}