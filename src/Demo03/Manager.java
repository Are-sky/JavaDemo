package Demo03;

public class Manager extends Employee{
    private double bones;

    public Manager(String name, double salary, int year, int month, int day) {
        super(name, salary, year, month, day);
        bones = 0;
    }
}
