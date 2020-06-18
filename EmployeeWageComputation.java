import java.util.HashMap;

abstract class EmployeeTemplate{

    public int WagePerHour;
    public int HoursPerDay;
    public int PartTimeHours;

    public int WagePerDay;
    public int TotalWageForMonth;
    public int TotalWorkingHours;
    public int FullWorkingDays;
    public int PartTimeWorkingDays;
    public int AbsentDays;

    public static HashMap<String,Integer> companies=new HashMap<>();

    public EmployeeTemplate(int WagePerHour,int HoursPerDay,int PartTimeHours){
        this.WagePerHour=WagePerHour;
        this.HoursPerDay=HoursPerDay;
        this.PartTimeHours=PartTimeHours;
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

    public abstract void CalculateWagePerDay();

    public abstract void CalculateWagePerMonth();


    public void display(){
        System.out.println("#######################################################################");
        System.out.println("Total Wage Earned at the end of 20 days/100 hours: "+TotalWageForMonth);
        System.out.println("Total Full Working Days: "+FullWorkingDays);
        System.out.println("Total Part Time Working Days: "+PartTimeWorkingDays);
        System.out.println("Total Absent Days: "+AbsentDays);
        System.out.println("Total Hours Worked: "+TotalWorkingHours);
        System.out.println("#######################################################################");
    }
}

class Company1 extends EmployeeTemplate{

    Company1(int WagePerHour,int HoursPerDay,int PartTimeHours){
        super(WagePerHour,HoursPerDay,PartTimeHours);
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
}

class Company2 extends EmployeeTemplate{

    Company2(int WagePerHour,int HoursPerDay,int PartTimeHours){
        super(WagePerHour,HoursPerDay,PartTimeHours);
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
}

public class EmployeeWageComputation{
    public static void main(String arg[]){
        Company1 emp1=new Company1(20, 8,4);
        emp1.CalculateWagePerMonth();
        emp1.display();
    }
}