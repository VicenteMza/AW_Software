package aws.bootcamp.clase4.eje3_cl4;
/*
       Streams & Lambdas:

Defina la clase Alumno con los siguientes campos:
int id
string dni
string name
string lastName
string curso
double nota
int edad

Cree un Lista y carge un numero considerable de alumnos para que el ejercicio sea viable (15 o mas) con valores a azar.

a) Muestre todos los alumnos de la lista
b) Muestre todos los alumnos ordenados de menor a mayor por edad
c) Muestre aquellos alumnos cuyo nombre empieza con un caracter dado (elegir el caracter en base a la lista de nombre que se utilizo)
d) Sume la edad de todos los alumnos
e) Obtenga un mapa donde la clave sea la nota y el valor sea una lista de alumnos que tienen esa nota
*/

public class Student{
    private int id;
    private String dni;
    private String name;
    private String lastName;
    private String course;
    private double note;
    private int age;

    public Student(int id, String dni, String name, String lastName, String course, double note, int age) {
        this.id = id;
        this.dni = dni;
        this.name = name;
        this.lastName = lastName;
        this.course = course;
        this.note = note;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", dni='" + dni + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", course='" + course + '\'' +
                ", note=" + note +
                ", age=" + age +
                '}';
    }
}
