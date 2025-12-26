public class HourlyEmployee extends Employee // HourlyEmployee IS AN Employee
{
    private double hourlyPayRate;
    private double hours;

    public HourlyEmployee(String name, String birthDate, String hireDate, double hourlyPayRate, double hours)
    {
        super(name, birthDate, hireDate);
        this.hourlyPayRate = hourlyPayRate;
        this.hours = hours;
    }

    @Override
    public double collectPay()
    {
        return hours * hourlyPayRate;
    }

    public double getDoublePay()
    {
        return 2 * collectPay();
    }

}
