package DragonChar;

import java.io.Console;
import java.util.*;

public class Dragon {

    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private long age; //Значение поля должно быть больше 0
    private String description; //Поле может быть null
    private int weight; //Значение поля должно быть больше 0

    private DragonType type; //Поле не может быть null
    private DragonHead head;


    public Dragon(String name, double x, Long y, long age, String description, int weight, String Type, float eyes_count){

        this.id =(int)(Math.random()*1000);
        if (name.equals("") || name == null) name = "Unnamed";
        this.name = name;
        this.coordinates = new Coordinates(x,y);
        this.creationDate = new Date();
        if (age<=0) age = 1;
        this.age = age;
        if (description == null) description ="";
        this.description = description;
        if (weight<=0)weight=1;
        this.weight = weight;

        switch (Type){
            case "AIR":
                this.type = DragonType.AIR;
                break;
            case "WATER":
                this.type = DragonType.WATER;
                break;
            case "UNDERGROUND":
                this.type = DragonType.UNDERGROUND;
                break;
            case "FIRE":
                this.type = DragonType.FIRE;
                break;
            default:
                this.type = DragonType.FIRE;
                break;
        }

        this.head = new DragonHead(eyes_count);



    }


    public Date getCreationDate() {
        return creationDate;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public DragonHead getHead() {
        return head;
    }

    public DragonType getType() {
        return type;
    }

    public int getWeight() {
        return weight;
    }

    public long getAge() {
        return age;
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setHead(DragonHead head) {
        this.head = head;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(DragonType type) {
        this.type = type;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
