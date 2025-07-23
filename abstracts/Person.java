package abstracts;
public abstract class Person {
    protected String name;
    protected int age;

    public Person(String name) {
        this.name = name;

    }
    public abstract String getName();

  
}