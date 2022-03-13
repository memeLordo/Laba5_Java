package xmlFiles;

import Parameters.Person;
import SetOfCommands.Info;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Stack;

import static SetOfCommands.CommandsPack.getPeople_data;
import static SetOfCommands.CommandsPack.setPeople_data;


public class xmlWriter extends xmlData {

    public static void go() {
        DecimalFormat dF = new DecimalFormat("#.##", new DecimalFormatSymbols(Locale.US));
        String[] type = new Info().getColumns();
        String input = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
        Stack<Person> s1 = getPeople_data();
        Stack<Person> s2 = new Stack<>();
        input = input + "<set>\n";
        while (!s1.empty()) {
            input = input + "\t<person>\n";
            input = input + "\t\t<" + type[0] + ">" + s1.peek().getId() + "</" + type[0] + ">\n";
            input = input + "\t\t<" + type[1] + ">" + s1.peek().getName() + "</" + type[1] + ">\n";
            input = input + "\t\t<" + type[2] + ">" + s1.peek().getCoordinates() + "</" + type[2] + ">\n";
            input = input + "\t\t<creation_date>" + s1.peek().getCreationDate() + "</creation_date>\n";
            input = input + "\t\t<" + type[3] + ">" + dF.format(s1.peek().getHeight()) + "</" + type[3] + ">\n";
            input = input + "\t\t<" + type[4] + ">" + dF.format(s1.peek().getWeight()) + "</" + type[4] + ">\n";
            input = input + "\t\t<" + type[5] + ">" + s1.peek().getBirthday() + "</" + type[5] + ">\n";
            input = input + "\t\t<" + type[6] + ">" + s1.peek().getEyeColor() + "</" + type[6] + ">\n";
            input = input + "\t\t<" + type[7] + ">" + s1.peek().getLocation() + "</" + type[7] + ">\n";
            input = input + "\t</person>\n";
            s2.push(s1.pop());
        }
        input = input + "</set>\n";
        write(input);
        setPeople_data(s2);
    }


}
