package aws.bootcamp.clase4.eje3_cl4;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StudentManager {
    private List<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
        loadStudents();
    }

    private void loadStudents() {
        students = Arrays.asList(
                new Student(1, "30312279", "Vicente", "Llanos", "Springboot", 10, 39),
                new Student(2, "15161561", "Name1", "LastName1", "Springboot", 7.5, 22),
                new Student(3, "00312165", "Name2", "LastName2", "Springboot", 8, 16),
                new Student(4, "12361561", "Name3", "LastName3", "Springboot", 10, 23),
                new Student(5, "32163516", "Daiana", "Martinez", "Springboot", 9.5, 39),
                new Student(6, "23015874", "Name5", "LastName5", "Springboot", 5.5, 25),
                new Student(7, "15849548", "Name6", "LastName6", "Springboot", 6, 20),
                new Student(8, "16546555", "Name7", "LastName7", "Springboot", 8, 20),
                new Student(9, "55645464", "Name8", "LastName8", "Springboot", 7, 19),
                new Student(10, "58963254", "Name9", "LastName9", "Springboot", 7.5, 50),
                new Student(11, "52456987", "Name10", "LastName10", "Springboot", 6, 18),
                new Student(12, "15235697", "Name11", "LastName11", "Springboot", 5, 20),
                new Student(13, "96584721", "Name12", "LastName12", "Springboot", 6.3, 32),
                new Student(14, "63256988", "Name13", "LastName14", "Springboot", 4, 25),
                new Student(15, "54879652", "Name14", "LastName14", "Springboot", 8, 30),
                new Student(16, "25123654", "Name15", "LastName15", "Springboot", 7.5, 25)

        );
    }

    public void printStudents() {
        System.out.println("\nlista de alumnos:");
        students.forEach(System.out::println);
    }

    public void sortByAge() {
        System.out.println("\nTodos los alumnos ordenados de menor a mayor por edad:");
        students.stream()
                .sorted(Comparator.comparingInt(Student::getAge))
                .toList()
                .forEach(System.out::println);
    }

    public void showByNameCharacter(char c) {
        System.out.println("\nAlumnos cuyo nombre empieza con el caracter: " + c);
        students.stream()
                .filter(student -> student.getName().toLowerCase().startsWith(String.valueOf(c).toLowerCase()))
                .forEach(System.out::println);
    }

    public void addTheAge() {
        int sum = students.stream()
                .mapToInt(Student::getAge)
                .sum();
        System.out.println("\nLa suma de las edades de los estudiantes es: " + sum );
    }
    public void listOfStudentsByGrade(){
        System.out.println("\nLista de alumnos segun la nota: ");
        Map<Double, List<Student>> map= students.stream()
                .collect(Collectors.groupingBy(Student::getNote));
        map.forEach((note, student) -> {
            System.out.println("Nota: " + note);
            student.forEach(System.out::println);
        });
    }
}
