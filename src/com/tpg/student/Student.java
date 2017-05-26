package com.tpg.student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Student implements Comparable<Student> {
	int id;
	String name;
	double gpa;

	public Student(int id, String name, double gpa) {
		this.name = name;
		this.id = id;
		this.gpa = gpa;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public double getGpa() {
		return gpa;
	}

	public String toString() {
		return id + " : " + name + " : " + gpa;
	}

	public int compareTo(Student s) {
		return getName().compareTo(s.getName());
	}

	static class gpaComparator implements Comparator<Student> {
		public int compare(Student s1, Student s2) {
			double gpa1 = s1.getGpa();
			double gpa2 = s2.getGpa();

			if (gpa1 == gpa2) {
				return (s1.getId() - s2.getId() == 0 ? s1.compareTo(s2) : s1.getId() - s2.getId());
			} else if (gpa1 > gpa2)
				return 1;
			else
				return -1;
		}
	}

	public static void main(String[] args) {
		List<Student> students = new ArrayList<Student>();
		students.add(new Student(1, "seshu", 8.1));
		students.add(new Student(7, "Persi", 35.2));
		students.add(new Student(4, "Jesse", 1.5));
		students.add(new Student(9, "Chitti", 1.5));
		students.add(new Student(9, "Nisa", 1.5));

		Collections.sort(students, Collections.reverseOrder(new Student.gpaComparator()));
		System.out.println("Sort using gpa Comparator");
		System.out.println("\t" + students);

	}
}