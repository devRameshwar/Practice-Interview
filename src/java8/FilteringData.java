package java8;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilteringData {

    public static void main(String[] args) {

        List<Jobs> list = Arrays.asList(new Jobs(101, "developer", LocalDate.of(2023, 11, 15), Arrays.asList("Delhi", "Bangalore")),
                new Jobs(102, "Tester", LocalDate.of(2023, 10, 1), Arrays.asList("Delhi", "Bangalore", "Hyderabad")),
                new Jobs(103, "developer", LocalDate.of(2023, 9, 15), Arrays.asList("Delhi", "Hyderabad")),
                new Jobs(104, "developer", LocalDate.of(2022, 12, 12), Arrays.asList("Delhi", "Bangalore")),
                new Jobs(105, "Tester", LocalDate.of(2023, 11, 13), Arrays.asList("Delhi", "Bangalore")),
                new Jobs(106, "developer", LocalDate.of(2023, 8, 15), Arrays.asList("Hyderabad", "Bangalore")),
                new Jobs(107, "HR", LocalDate.of(2023, 12, 14), Arrays.asList("Delhi", "Bangalore", "Hyderabad")),
                new Jobs(108, "HR", LocalDate.of(2023, 11, 15), Arrays.asList("Delhi", "Hyderabad")));

        //findJobInBangalore(list);
        //captalize();
        //System.out.println(factorial(5));
        //findJobInBangalore(list);
        sortJobWithRespectToDate(list);

    }

    private static void sortJobWithRespectToDate(List<Jobs> list) {
        list.stream().sorted((e1,e2)->e2.getDate().compareTo(e1.getDate())).collect(Collectors.toList()).forEach(System.out::println);
    }

    private static void findJobInBangalore(List<Jobs> list) {

        List<String> hyderabad = list.stream().filter(s -> s.getLocation().contains("Hyderabad")).map(e -> e.getRole()).distinct().toList();

        System.out.println(hyderabad);

    }
    //todo find factorial of number
    public static int factorial(int n){
        if(n<1||n==1){
            return  1;
        }
        return n* factorial(n-1);
    }

    public static void captalize(){
        List<String> list = Arrays.asList("mango", "guava", "apple", "grapes", "orange");
        List<String> stringList = list.stream().map(l -> l.substring(0, 1).toUpperCase() + l.substring(1)).toList();
        System.out.println(stringList);
    }


}

class Jobs {
    Integer jobId;
    String role;
    LocalDate date;
    List<String> location;

    public Jobs(Integer jobId, String role, LocalDate date, List<String> location) {
        this.jobId = jobId;
        this.role = role;
        this.date = date;
        this.location = location;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<String> getLocation() {
        return location;
    }

    public void setLocation(List<String> location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Jobs{" + "jobId=" + jobId + ", role='" + role + '\'' + ", date=" + date + ", location=" + location + '}';
    }
}
