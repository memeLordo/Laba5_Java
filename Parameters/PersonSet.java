package Parameters;
public interface PersonSet {
    Integer Id();
    String Name();
    Coordinates Coordinates() throws Exception;
    Long Height();
    java.time.LocalDate Birthday();
    Double Weight();
    Color Color();
    Location Location();
}
