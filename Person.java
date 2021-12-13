public class Person {

    protected String name;
    protected char gender;
    protected String id;

    public Person() {
    }

    public Person(String n1, char g1, String id1) {
        name = n1;
        gender = g1;
        id = id1;
    }

    public Person(String name1) {
        name = name1;
    }

    public Person(String name1, char gender1) {
        name = name1;
        gender = gender1;
    }

    public String getName() {
        return name;
    }

    public char getGender() {
        return gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id1) {
        id = id1;
    }

    public void setGender(char gender1) {
        gender = gender1;
    }

    public void setName(String name1) {
        name = name1;
    }

    public String toString() {
        String s = name + " ( gender: " + gender;
        if (id != null)
            s += " and id: " + id;
        s += " ) ";
        return s;
    }
}
