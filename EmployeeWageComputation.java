public class EmployeeWageComputation{

    public static void CalculateWagePerMonth(int WagePerHour,int HoursPerDay,int PartTimeHours){
        int WagePerDay=0;
        int TotalWageForMonth=0;
        int TotalWorkingHours=0;
        int FullWorkingDays=0;
        int PartTimeWorkingDays=0;
        int AbsentDays=0;
        for(int day=1;day<=20;day++){
            while(TotalWorkingHours<100){
                int EmployeeAttendance=(int)(Math.random()*3);
                switch(EmployeeAttendance){
                    case 0:WagePerDay=0;
                        TotalWorkingHours+=0;
                        AbsentDays++;
                        break;
                    case 1:WagePerDay=WagePerHour*HoursPerDay;
                        TotalWorkingHours+=HoursPerDay;
                        FullWorkingDays++;
                        break;
                    case 2:WagePerDay=WagePerHour*PartTimeHours;
                        TotalWorkingHours+=PartTimeHours;
                        PartTimeWorkingDays++;
                        break;
                    default:
                        System.out.println("Error Occurred");
                }
                TotalWageForMonth+=WagePerDay;
                break;
            }
        }
        System.out.println("#######################################################################");
        System.out.println("Total Wage Earned at the end of 20 days/100 hours: "+TotalWageForMonth);
        System.out.println("Total Full Working Days: "+FullWorkingDays);
        System.out.println("Total Part Time Working Days: "+PartTimeWorkingDays);
        System.out.println("Total Absent Days: "+AbsentDays);
        System.out.println("Total Hours Worked: "+TotalWorkingHours);
        System.out.println("#######################################################################");
    }

    public static void main(String arg[]){
        System.out.println("Welcome to the Employee Wage Calculation Program");
        CalculateWagePerMonth(20, 8, 4);
        CalculateWagePerMonth(40, 6, 3);
    }
}