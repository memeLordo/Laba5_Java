package SetOfCommands;


import xmlFiles.xmlWriter;

public class Save extends Command {
    public Save() {
        super("save", "сохранить коллекцию в файл");
    }



    @Override
    public void go() {
        CreateFile(xmlWriter.getPath());
        xmlWriter.go();
        System.out.println("Данные сохранены.");
    }



}
