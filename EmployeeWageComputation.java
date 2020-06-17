public class EmployeeWageComputation{
    public static void main(String arg[]){
        System.out.println("Welcome to the Employee Wage Calculation Program");
        int EmployeeAttendance=(int)(Math.random()*2);
        if(EmployeeAttendance==0){
            System.out.println("Employee is absent");
        }else{
            System.out.println("Employee is present");
        }
    }
}