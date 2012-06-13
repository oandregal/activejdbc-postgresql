/*
Copyright 2009-2010 Igor Polevoy

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

package activejdbc.ant.example;

import org.javalite.activejdbc.Base;

/**
 * @author Igor Polevoy
 */
public class Main {
    public static void main(String[] args) {
	Base.open("org.postgresql.Driver",
		"jdbc:postgresql://localhost:5432/activejdbc-postgresql",
		"postgres",
		"postgres");

	createEmployee();
	System.out.println("=========> Created employee:");
	selectEmployee();
	updateEmployee();
	System.out.println("=========> Updated employee:");
	selectAllEmployees();
	deleteEmployee();
	System.out.println("=========> Deleted employee:");
	selectAllEmployees();
	createEmployee();
	System.out.println("=========> Created employee:");
	selectEmployee();
	deleteAllEmployees();
	System.out.println("=========> Deleted all employees:");
	selectAllEmployees();

	createTeacher();
	System.out.println("=========> Created teacher:");
	selectTeacher();
	updateTeacher();
	System.out.println("=========> Updated teacher:");
	selectAllTeachers();
	deleteTeacher();
	System.out.println("=========> Deleted teacher:");
	selectAllTeachers();
	createTeacher();
	System.out.println("=========> Created teacher:");
	selectTeacher();
	deleteAllTeachers();
	System.out.println("=========> Deleted all teachers:");
	selectAllTeachers();

	Base.close();
    }

    private static void createEmployee() {
	Employee e = new Employee();
	e.set("first_name", "John");
	e.set("last_name", "Doe");
	e.saveIt();
    }

    private static void createTeacher() {
	Teacher t = new Teacher();
	t.set("name_first", "Jane");
	t.set("name_last", "Roe");
	t.saveIt();
    }

    private static void selectEmployee() {
	Employee e = Employee.findFirst("first_name = ?", "John");
	System.out.println(e);
    }

    private static void selectTeacher() {
	Teacher t = Teacher.findFirst("name_first = ?", "Jane");
	System.out.println(t);
    }

    private static void updateEmployee() {
	Employee e = Employee.findFirst("first_name = ?", "John");
	e.set("last_name", "Steinbeck").saveIt();
    }

    private static void updateTeacher() {
	Teacher t = Teacher.findFirst("name_first = ?", "Jane");
	t.set("name_last", "Goodall").saveIt();
    }

    private static void deleteEmployee() {
	Employee e = Employee.findFirst("first_name = ?", "John");
	e.delete();
    }

    private static void deleteTeacher() {
	Teacher t = Teacher.findFirst("name_first = ?", "Jane");
	t.delete();
    }

    private static void deleteAllEmployees() {
	Employee.deleteAll();
    }

    private static void deleteAllTeachers() {
	Teacher.deleteAll();
    }

    private static void selectAllEmployees() {
	System.out.println("Employees list: " + Employee.findAll());
    }

    private static void selectAllTeachers() {
	System.out.println("Teachers list: " + Teacher.findAll());
    }

}