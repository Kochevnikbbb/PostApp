package kg.geektech.postapp.data.models;

public class Peoples {
    int id;
    String name;

    public Peoples() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Peoples(int id, String name) {
        this.id = id;
        this.name = name;


    }
}
