package java8;

import java.time.LocalDate;
import java.util.*;
import java.util.function.BiFunction;

public class StudentOperation {

    public static void findStudentNameStartWith(TreeMap<Integer,Students> studentsHashMap){
        Set<Map.Entry<Integer, Students>> entrySet = studentsHashMap.entrySet();
        Iterator<Map.Entry<Integer, Students>> iterator = entrySet.iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, Students> next = iterator.next();
            //System.out.println(next.getValue());
            //print name start with 'A'
            if(next.getValue().studentName.toLowerCase().startsWith("a")){
                System.out.println(next.getValue()+"and id: "+ next.getKey());
            }
        }
    }

    public static void main(String[] args) {

        TreeMap<Integer, Students> studentsHashMap = new TreeMap<>();
        //adding data in HashMap
        studentsHashMap.put(101, new Students(10, "Rameshwar", Arrays.asList("Hindhi", "English", "Maths"), LocalDate.of(2011, 11, 2)));
        studentsHashMap.put(102, new Students(11, "Anuj", Arrays.asList("Hindhi", "Art", "Maths"), LocalDate.of(2011, 11, 2)));
        studentsHashMap.put(103, new Students(12, "Asha", Arrays.asList("Science", "English", "Maths"), LocalDate.of(2011, 11, 2)));
        //printing the data
        //System.out.println(studentsHashMap);
        //findStudentNameStartWith(studentsHashMap);
        //todo:Lamda expresion
        Addition addition=(a,b)-> a+b;
        System.out.println("Lamda expression addition method called: "+addition.addition(10,20));

        //todo:method referencing
        Addition addition1=new Students()::addition;
        System.out.println("Method referencing called addition method: "+addition1.addition(30,10));

        //todo: calling addition method using pre-define functional interface
        BiFunction<Integer,Integer,Integer> function=new Students()::addition;
        System.out.println("calling addition method using BiFunction interface: "+function.apply(30,20));
    }
}

class Students {
    Integer id;
    String studentName;
    List<String> subjects;
    LocalDate joiningDate;

    Students(){

    }

    public Students(Integer id, String studentName, List<String> subjects, LocalDate joiningDate) {
        this.id = id;
        this.studentName = studentName;
        this.subjects = subjects;
        this.joiningDate = joiningDate;
    }

    int addition(int a,int b){
        return a+b;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

    @Override
    public String toString() {
        return "Students{" + "id=" + id + ", studentName='" + studentName + '\'' + ", subjects=" + subjects + ", joiningDate=" + joiningDate + '}';
    }
}
interface Addition{
    int addition(int a,int b);
}