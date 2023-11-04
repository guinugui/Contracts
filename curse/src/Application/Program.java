package Application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import Entities.Department;
import Entities.HourContract;
import Entities.Worker;
import Entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		System.out.print("Enter department name: ");
		String departmentName = sc.nextLine();
		System.out.print("Enter worker data: ");
		System.out.print("Name: ");
		String workerName = sc.nextLine();
		System.out.print("Level: ");
		String workerLevel = sc.nextLine();
		System.out.print("Base salary: ");
		double baseSalary = sc.nextDouble();
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));
		
		System.out.println("HOW MANY CONTRACTS TO THIS WORKER> ");
		int n = sc.nextInt();
		
		for(int i = 1; i<=n; i++) {
			System.out.println("enter contract #" + i + "data:");
			System.out.println("Date (dd/mm/yyyy): ");
			Date contractDate = sdf.parse(sc.next());
			System.out.print("Value per Hour: ");
			double valuePerHour = sc.nextDouble();
			System.out.print("Duration)horus: ");
			int hours = sc.nextInt();
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			worker.addContract(contract);
		}
		System.out.println();
		System.out.println("enter month and year to calculate income (MM/YYYY): ");
		String monthAndYear = sc.next();		
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		System.out.println("Name" + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		System.out.println("Income for" + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));
		
		sc.close();
    }
}

		
	
	

























