public class EmployeeWageComputation{
    private int WagePerHour;
    private int HoursPerDay;
    private int PartTimeHours;

    private int WagePerDay;
    private int TotalWageForMonth;
    private int TotalWorkingHours;
    private int FullWorkingDays;
    private int PartTimeWorkingDays;
    private int AbsentDays;

    public EmployeeWageComputation(){
        WagePerHour=20;
        HoursPerDay=8;
        PartTimeHours=4;

        WagePerDay=0;
        TotalWageForMonth=0;
        TotalWorkingHours=0;
        FullWorkingDays=0;
        PartTimeWorkingDays=0;
        AbsentDays=0;
    }

    public int CalculateAttendance(){
        return (int)(Math.random()*3);
    }

    public void CalculateWagePerDay(){
        int EmployeeAttendance=CalculateAttendance();
        switch(EmployeeAttendance){
            case 0:this.WagePerDay=0;
                this.TotalWorkingHours+=0;
                this.AbsentDays++;
                break;
            case 1:this.WagePerDay=this.WagePerHour*this.HoursPerDay;
                this.TotalWorkingHours+=this.HoursPerDay;
                this.FullWorkingDays++;
                break;
            case 2:this.WagePerDay=this.WagePerHour*this.PartTimeHours;
                this.TotalWorkingHours+=this.PartTimeHours;
                this.PartTimeWorkingDays++;
                break;
            default:
                System.out.println("Error Occurred");
        }
    }

    public void CalculateWagePerMonth(){
        for(int day=1;day<=20;day++){
            while(this.TotalWorkingHours<100){
                CalculateWagePerDay();
                this.TotalWageForMonth+=this.WagePerDay;
                break;
            }
        }
    }

    public void display(){
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
        EmployeeWageComputation emp =new EmployeeWageComputation();
        emp.CalculateWagePerMonth();
        emp.display();

    }
}