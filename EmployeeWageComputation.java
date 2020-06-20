import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Employee{

    private int WagePerHour;
    private int HoursPerDay;
    private int PartTimeHours;
    private String companyName;

    private int WagePerDay;
    private int TotalWageForMonth;
    private int TotalWorkingHours;
    private int FullWorkingDays;
    private int PartTimeWorkingDays;
    private int AbsentDays;
    // public int[] dailyWages;
    public ArrayList<Integer> dailyWages;

    public Employee(int WagePerHour,int HoursPerDay,int PartTimeHours){
        this.WagePerHour=WagePerHour;
        this.HoursPerDay=HoursPerDay;
        this.PartTimeHours=PartTimeHours;
        // this.companyName=companyName;
        WagePerDay=0;
        TotalWageForMonth=0;
        TotalWorkingHours=0;
        FullWorkingDays=0;
        PartTimeWorkingDays=0;
        AbsentDays=0;
        // dailyWages=new int[20];
        dailyWages=new ArrayList<>();
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
        for(int day=0;day<20;day++){
            while(this.TotalWorkingHours<100){
                CalculateWagePerDay();
                // this.dailyWages[day]=this.WagePerDay;
                dailyWages.add(this.WagePerDay);
                this.TotalWageForMonth+=this.WagePerDay;
                break;
            }
        }
    }

    public int getWagePerMonth(){
        return TotalWageForMonth;
    }

    public ArrayList<Integer> getDailyWages(){
        // for(int i=0;i<this.dailyWages.length;i++){
        //     System.out.println(this.dailyWages[i]);
        // }
        return dailyWages;
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
}

public class EmployeeWageComputation{
    public static void main(String arg[]){

        HashMap<String,ArrayList<Integer>> companies=new HashMap<>();

        System.out.println("Enter the number of companies");
        Scanner scanner=new Scanner(System.in);
        int numberOfCompanies=scanner.nextInt();
        for(int i=0;i<numberOfCompanies;i++){
            System.out.println("Enter the wage per hour");
            int WagePerHour=scanner.nextInt();
            System.out.println("Enter the full-time hours");
            int HoursPerDay=scanner.nextInt();
            System.out.println("Enter the part-time hours");
            int PartTimeHours=scanner.nextInt();
            System.out.println("Enter the name of the company");
            String CompanyName=scanner.next();
            Employee comp=new Employee(WagePerHour,HoursPerDay,PartTimeHours);
            comp.CalculateWagePerMonth();
            companies.put(CompanyName,comp.getDailyWages());
        }

        System.out.println(companies);

        System.out.println("Enter the name of the company to retrieve monthly wage");
        String searchCompany=scanner.next();

        if(companies.containsKey(searchCompany)){
            System.out.println("Daily Wage of: "+searchCompany+" is Rs."+companies.get(searchCompany));
        }else{
            System.out.println("No such company");
        }

    }
}