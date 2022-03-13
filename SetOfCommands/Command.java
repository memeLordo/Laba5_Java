package SetOfCommands;

import java.io.File;

public abstract class Command {
    private final String name;
    private final String description;

    public Command(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public static void CreateFile(String name) {
        try {
            File f = new File(name);
            if (f.createNewFile())
                System.out.println("Инициализация файла...");
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public abstract void go();
}
