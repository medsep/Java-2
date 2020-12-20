package lesson4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;


public class Application {

	public static void main(String[] args) {
		
		ArrayList<Integer> list1 = new ArrayList<>();
		list1.add(12);
		list1.add(43);
		list1.add(15);
		list1.add(67);
		list1.add(43);
		
		ArrayList<Integer> newList = new ArrayList<>();
		newList.add(10);
		newList.add(67);
		newList.add(15);
		
		System.out.println("Does list1 have 67? " + list1.contains(67));
		
		list1.addAll(newList);//merge newList into list1
		System.out.println(list1);
		
		list1.removeAll(newList);//remove elements appeared in newList from list1
		System.out.println(list1);
		
		list1.addAll(newList);//merge newList into list1
		System.out.println(list1);

		list1.retainAll(newList);//retain whatever is inside newList and removew other elements from list1
		System.out.println(list1);
		
		list1.clear();
		System.out.println(list1);
		
		HashSet<Integer> hashSet = new HashSet<>();
		hashSet.add(1);
		hashSet.add(3);
		hashSet.add(12);
		hashSet.add(43);
		hashSet.add(15);
		hashSet.add(67);
		hashSet.add(43);//
		hashSet.add(666);
		System.out.println(hashSet);
		
		List<Integer> li = new ArrayList<>(hashSet);//convert HashSet into ArrayList
		li.add(666);
		System.out.println(li);
		Collections.sort(li);
		System.out.println(li);
		
		HashSet<Employee> employeesSet = new HashSet<>();
		employeesSet.add(new Employee("Peter", 6666, "Developer"));
		employeesSet.add(new Employee("Mike", 3500, "Admin"));
		employeesSet.add(new Employee("Paul", 2000, "Maint"));
		employeesSet.add(new Employee("Angel", 4500, "IT"));
		
		ArrayList<Employee> employeeList = new ArrayList<>(employeesSet);
		
		Collections.sort(employeeList);
		for (Employee employee : employeeList) {
			System.out.println(employee);
		}

	}

}
