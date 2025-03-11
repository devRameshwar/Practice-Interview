package interview;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentsOparations {

    public static void main(String[] args) {
        List<Students> studentsList = Arrays.asList(new Students(101, "SaiKishor", Arrays.asList("Hindhi", "Maths", "Computer")),
                new Students(102, "Ani", Arrays.asList("Hindhi", "Maths", "Computer", "Science")),
                new Students(103, "Ashok", Arrays.asList("Hindhi", "Social-Science", "Computer", "Art")),
                new Students(104, "Rani", Arrays.asList("Hindhi", "Maths", "Computer", "Science")),
                new Students(105, "Sweeta", Arrays.asList("Hindhi", "Maths", "Computer", "Art")),
                new Students(106, "Sivam", Arrays.asList("Hindhi", "Maths", "Computer", "Art")),
                new Students(107, "Riya", Arrays.asList("Hindhi", "Maths", "Computer")));

       // findStudentsNameStartWithA(studentsList);
        //findArtStudents(studentsList);
        //sortingStudentsWithName(studentsList);
        //margeTwoList();
        //searchAndReplace();
        sortStudentsNameLeanth(studentsList);
    }

    private static void sortStudentsNameLeanth(List<Students> studentsList) {
        List<String> list = studentsList.stream().sorted((s1, s2) -> s2.getName().length() - s1.getName().length()).map(Students::getName).collect(Collectors.toList());
        System.out.println(list);
    }

    private static void margeTwoList() {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        List<Character> characterList = Arrays.asList('a', 'c', 'w', 'l');

        //todo: marge two list
        List<? extends Serializable> list = Stream.of(integerList, characterList).flatMap(l -> l.stream()).toList();
        System.out.println(list);
        List<? extends Serializable> list1 = list.stream().sorted((e1,e2)->e2.hashCode()-e1.hashCode()).toList();
        System.out.println(list1);

    }
    private static void searchAndReplace(){
        String string="Apple";
        List<String> list = Arrays.asList("Banana", "Mango", "Grapes", "Apple");
        list.stream().filter(a -> a.contains("Apple")).map(s -> s.replaceAll(s,s.substring(0,3))).forEach(System.out::println);

    }

    private static void sortingStudentsWithName(List<Students> studentsList) {
        List<String> list = studentsList.stream().sorted((e1,e2)->e2.getName().compareTo(e1.getName())).map(Students::getName).toList();
        System.out.println(list);
    }

    private static void findArtStudents(List<Students> studentsList) {

        List<String> art = studentsList.stream().filter(e -> e.getSubjects().contains("Art")&e.getSubjects().contains("Social-Science")).map(e -> e.getName()).toList();
        System.out.println(art);
    }

    private static void findStudentsNameStartWithA(List<Students> studentsList) {
        List<String> list = studentsList.stream().filter(students -> students.getName().toLowerCase().startsWith("a")).map(s -> s.getName()).toList();
        System.out.println(list);
    }

}

class Students {
    int stdId;
    String name;
    List<String> subjects;

    public Students(int stdId, String name, List<String> subjects) {
        this.stdId = stdId;
        this.name = name;
        this.subjects = subjects;
    }

    public int getStdId() {
        return stdId;
    }

    public void setStdId(int stdId) {
        this.stdId = stdId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "Students{" + "stdId=" + stdId + ", name='" + name + '\'' + ", subjects=" + subjects + '}';
    }
}
