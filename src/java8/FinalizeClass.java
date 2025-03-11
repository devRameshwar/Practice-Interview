package java8;

public class FinalizeClass {

    public static void main(String[] args) {

        System.out.println("_________Hello_________");

        FinalClass obj = new FinalClass(101, "Ram");
        System.out.println(obj.getId()+"\t"+obj.getName());

    }

}

class FinalClass {
    private final Integer id;

    private final String name;

    public FinalClass(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "FinalClass{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
