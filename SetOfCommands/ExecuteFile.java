package SetOfCommands;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class ExecuteFile extends Command{
    public ExecuteFile() {
        super("execute", "description");
    }

    @Override
    public void go() {
        String filename = "commands.txt";
        CreateFile(filename);
        ScanFile(filename);
    }
    private void ScanFile(String text){
        Scanner console = null;
        String path, err;
        try {
            console = new Scanner(Path.of(text));
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert console != null;
        console.useDelimiter(System.getProperty("line.separator"));
        while(console.hasNext()){
            try {
                path=CommandsPack.mapFind(console.nextLine());
                err = new ExecuteFile().getName();
                if(path.equals(err)){
                    System.err.print("Команда "+err+" не может присутствовать в файле.");
                    continue;
                }
                CommandsPack.getMap().get(path).go();
            }catch (Exception ignored){}

        }
    }
}
