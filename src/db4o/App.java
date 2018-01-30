package db4o;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Predicate;
// import com.db4o.query.Query;

import db4o.model.*;

public class App{
	public static void main(String[] args) throws ParseException {
		ObjectContainer db = initDb();
		
		// showAllDB(db);
		// queryRRByCost(db, 10000);
		queryMechanicByName(db, "Виктор");
		
		db.close();
	}

	private static void printResults(ObjectSet<RepairReport> result, String header) {
		String line = "";
		for (int i = 0; i < header.length(); i++) { line += "~"; }
		System.out.printf("%s\n%s\n%s\n",line, header, line);
		
		if(result.isEmpty()) {
			System.out.println(" > Не найдено...");
		}
		else {
			for (RepairReport rr : result) {
				System.out.printf(" > %s \n", rr);
			}
		}
		System.out.println();
	}
	
	private static List<Driver> insertDriverList() {
		List<Driver> result = new ArrayList<>();
		
		result.add(new Driver(1, "Иван", "г. Ижевск ул. К.Маркса 96", "8 912 345 67 89"));
		result.add(new Driver(2, "Олег", "г. Глазов ул. Революции 12", "8 998 765 43 21"));
		result.add(new Driver(3, "Александр", "г. Ижевск ул. К.Маркса 96", "8 900 555 35 35"));
		
		return result;
	}
	private static List<Car> insertCarList() {
		List<Car> result = new ArrayList<>();
		List<Driver> driverList = insertDriverList();
		
		result.add(new Car(1, "LADA", 150, "10 декабря 2017", "Красный", driverList.get(0)));
		result.add(new Car(2, "Mitsubishi", 300, "15 декабря 2017", "Зеленый", driverList.get(1)));
		result.add(new Car(3, "Kia", 200, "12 декабря 2017", "Белый", driverList.get(2)));
		
		return result;
	}
	private static List<Workshop> insertWorkshopList() {
		List<Workshop> result = new ArrayList<>();
		
		result.add(new Workshop(1, "А", "г. Ижевск ул. Ленина 102", "8 926 874 56 98"));
		result.add(new Workshop(2, "Б", "г. Глазов ул. Пушкина 87", "8 925 255 14 98"));
		result.add(new Workshop(3, "В", "г. Сарапул ул. Гагарина 54", "8 954 268 54 36"));
		
		return result;
	}
	private static List<Mechanic> insertMechanicList() {
		List<Mechanic> result = new ArrayList<>();
		List<Workshop> workhopList = insertWorkshopList();
		
		result.add(new Mechanic(1, "Виктор", "г. Ижевск ул. Ленина 102", "8 987 546 25 65", 2, workhopList.get(0)));
		result.add(new Mechanic(2, "Борис", "г. Сарапул ул. Восточная 87", "8 912 265 48 25", 2, workhopList.get(1)));
		result.add(new Mechanic(3, "Анатолий", "г. Воткинск ул. Пушкина 54", "8 908 52 41 36", 1, workhopList.get(2)));
		
		return result;
	}
	private static List<RepairReport> insertRepairReportList() throws ParseException {
		List<RepairReport> result = new ArrayList<>();
		List<Mechanic> mechanicList = insertMechanicList();
		List<Car> carList = insertCarList();
		
		result.add(new RepairReport(1, 5000, "01.11.2017", "Ремонт", "10.11.2017", "09.11.2017", mechanicList.get(0), carList.get(0)));
		result.add(new RepairReport(2, 7000, "04.12.2017", "Ремонт", "16.12.2017", "17.12.2017", mechanicList.get(1), carList.get(1)));
		result.add(new RepairReport(3, 15000, "02.12.2017", "Осмотр", "10.12.2017", "09.12.2017", mechanicList.get(2), carList.get(2)));
	
		return result;
	}
	
	private static ObjectContainer initDb() throws ParseException {
		@SuppressWarnings("deprecation")
		ObjectContainer db = Db4o.openFile(Db4o.newConfiguration(), "data.db");
		List<RepairReport> list = insertRepairReportList();
		ObjectSet<RepairReport> result = db.query(RepairReport.class);
		
		boolean removeAll = list.removeAll(new HashSet<>(result));
		if(removeAll || result.size() == 0) {
			for (RepairReport rr : list) {
				db.store(rr);
			}
		}
			
		return db;
	}
	
	private static void showAllDB(ObjectContainer db) {
		ObjectSet<RepairReport> result = db.query(RepairReport.class);
		printResults(result, "Вся база данных");
	}
	private static void queryRRByCost(ObjectContainer db, final Integer cost) {
		ObjectSet<RepairReport> result = db.query(new Predicate<RepairReport>(){
			private static final long serialVersionUID = 10L;
			
			@Override
			public boolean match(RepairReport rr) {
				return rr.getCost() > cost;
			}
		});
		
		printResults(result, "Акты, чьи работы дороже " + cost);
	}
	private static void queryMechanicByName(ObjectContainer db, final String mName) {
		ObjectSet<RepairReport> result = db.query(new Predicate<RepairReport>(){
			private static final long serialVersionUID = 10L;
			
			@Override
			public boolean match(RepairReport rr) {
				Mechanic mechanic = rr.getMechanic();
				if (mechanic != null) {
					return mechanic.getName().equalsIgnoreCase(mName);	
				}
				return false;
			}
		});
		
		printResults(result, "Акты, выполненые механиком с именем " + mName);
	}
	
}