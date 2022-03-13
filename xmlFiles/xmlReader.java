package xmlFiles;

import Parameters.Color;
import Parameters.Coordinates;
import Parameters.Location;
import Parameters.Person;
import SetOfCommands.Info;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.Stack;

import static java.lang.Double.parseDouble;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

public class xmlReader extends xmlData {
    public static Stack<Person> go() {
        Stack<Person> result = new Stack<>();
        Scanner sc = new Scanner(read());
        String[] type = new Info().getColumns();
        String[] fill = new String[8];
        while (sc.hasNext()) {
            String input = sc.nextLine();
            for (int i = 0; i < 8; i++)
                fill[i] = input.contains(type[i]) ? subString(input, type[i]) : fill[i];
            if (input.contains("</person>")){
                Person MrX = new Person(fill[1],
                        parseCoordinates(fill[2]),
                        parseLong(fill[3]),
                        parseDouble(fill[4]),
                        parseLDate(fill[5]),
                        parseColor(fill[6]),
                        parseLocation(fill[7]));
                MrX.setId(parseInt(fill[0]));
                result.push(MrX);
            }
        }
        return result;
    }

    static String subString(String s, String input) {
        int inputIndex = s.indexOf(input) + input.length() + 1;
        StringBuilder result = new StringBuilder();
        for (int i = inputIndex; ; i++) {
            if (s.charAt(i) == '<') break;
            result.append(s.charAt(i));
        }
        return result.toString();
    }

    static Coordinates parseCoordinates(String input) {
        String[] s = input.replaceAll("°", "").split(" . ");
        return new Coordinates(parseInt(s[0]), parseInt(s[1]));
    }

    static LocalDate parseLDate(String input) {
//        DateFormat df = new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy", Locale.ENGLISH);
        return LocalDate.parse(input);
    }

    static Color parseColor(String input) {
        return Color.valueOf(input);
    }

    static Location parseLocation(String input) {
        String[] r = input.trim().replaceAll("Место", "").split(":");
        return new Location(parseInt(r[0]), parseInt(r[1]), parseFloat(r[2]), r[3]);
    }

}
