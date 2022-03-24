package xmlFiles;

import Exceptions.EmptyLineException;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Paths;
import java.util.Scanner;

import static java.lang.System.in;
import static java.nio.charset.StandardCharsets.UTF_8;

public abstract class xmlData {

    protected static String path = "example.xml";

    public static String getPath() {

        try{
            System.out.print("Введите название файла: ");
            path = new Scanner(in).nextLine();
            if(path.equals("")) throw new EmptyLineException("Имя файла");
        }catch (EmptyLineException e){
            System.out.println(e.getMessage());
            getPath();
        }
        return path + ".xml";
    }

    static void write(String text) {
        try (Writer translator = new OutputStreamWriter(new FileOutputStream(path), UTF_8)) {
            translator.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static String read() {
        StringBuilder line = new StringBuilder();
        try {
            Scanner fr = new Scanner(Paths.get(path));
            do {
                line.append(fr.nextLine()).append("\n");
            } while (fr.hasNext());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line.toString();
    }

}
