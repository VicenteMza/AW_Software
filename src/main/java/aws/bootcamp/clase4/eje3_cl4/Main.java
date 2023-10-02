package aws.bootcamp.clase4.eje3_cl4;

public class Main {
    public static void main(String[] args){
        StudentManager manager = new StudentManager();
        manager.printStudents();
        manager.sortByAge();
        manager.showByNameCharacter('d');
        manager.addTheAge();
        manager.listOfStudentsByGrade();
    }
}
