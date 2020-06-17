public class EmployeeWageComputation{
    public static final int WagePerHour=20;
    public static final int HoursPerDay=8;
    public static final int PartTimeHours=4;
    public static void main(String arg[]){
        System.out.println("Welcome to the Employee Wage Calculation Program");
        int WagePerDay=0;

        int EmployeeAttendance=(int)(Math.random()*3);
        if(EmployeeAttendance==0){
            WagePerDay=WagePerHour*0;
            System.out.println("Employee is absent. Wage for the day: "+WagePerDay);
        }else if(EmployeeAttendance==1){
            WagePerDay=WagePerHour*HoursPerDay;
            System.out.println("Employee is present. Wage for the day: "+WagePerDay);
        }else{
            WagePerDay=WagePerHour*PartTimeHours;
            System.out.println("Employee is working part-time. Wage for the day: "+WagePerDay);
        }
    }
}