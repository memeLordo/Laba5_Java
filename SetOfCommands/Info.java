package SetOfCommands;

public class Info extends Command{

    public Info() {
        super("info", "вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
    }
    private final String[] columns ={"id","name", "coordinates", "height", "weight","birthday", "eyeColor", "location"};
    @Override
    public void go() {
        System.out.println("Info:");
        for (String x:columns) {
            System.out.println(x);
        }
    }

    public String[] getColumns() {
        return columns;
    }
}
