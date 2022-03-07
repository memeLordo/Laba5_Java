package Parameters;

import SetOfCommands.Generator;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Date;

public class Person {


    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private final String name; //Поле не может быть null, Строка не может быть пустой
    private final Coordinates coordinates; //Поле не может быть null
    private final java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private final Long height; //Поле не может быть null, Значение поля должно быть больше 0
    private final java.time.LocalDate birthday; //Поле не может быть null
    private final Double weight; //Поле не может быть null, Значение поля должно быть больше 0
    private final Color eyeColor; //Поле не может быть null
    private final Location location; //Поле не может быть null
    private final Generator generator = new Generator();


    public Person(String name, Coordinates coordinates, Long height, Double weight, LocalDate birthday, Color eyeColor, Location location) {

        this.id = generator.Id();
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = new Date();
        this.height = height;
        this.birthday = birthday;
        this.weight = weight;
        this.eyeColor = eyeColor;
        this.location = location;
    }
    public Person(){
        this.id = generator.Id();//изменить на генератор
        this.name = generator.Name();//из перечня имён
        this.coordinates = generator.Coordinates();// генерирует координаты
        this.creationDate = new Date();
        this.height = generator.Height();
        this.birthday = generator.Birthday(); //генератор дат
        this.weight = generator.Weight();
        this.eyeColor = generator.Color();
        this.location = generator.Location();
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCoordinates() {
        return coordinates.getX() + "° . " + coordinates.getY() +"°";
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Long getHeight() {
        return height;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Double getWeight() {
        return weight;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Color getEyeColor() {
        return eyeColor;
    }

    public String getLocation() {
        return " "+location.getX()+":"+location.getY()+":"+dF.format(location.getZ())+"\nМесто: "+location.getName();
    }
    DecimalFormat dF = new DecimalFormat( "#.##" );
}
