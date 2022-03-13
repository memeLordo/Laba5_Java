package SetOfCommands;

import Parameters.Person;
import SetOfComparators.PersonIdComparator;
import xmlFiles.xmlReader;

import java.util.*;

public class CommandsPack {
    private static final Map<String, Command> map = new HashMap<>();
    private static final List<String> defCommandSet = new LinkedList<>();
    public static boolean isDefaultCommand = false;
    public static Integer inputID = 0;
    private static Stack<Person> people_data = xmlReader.go();

    public static void go() {

        Command help = new Help();
        Command info = new Info();
        Command show = new Show();
        Command add = new Add();
        Command clear = new Clear();
        Command exit = new Exit();
        Command head = new Head();
        Command save = new Save();
        Command execute = new ExecuteFile();
        Command update = new UpdateID();
        Command remove = new RemoveID();
        Command remove1 = new RemoveFirst();
        Command removelow = new RemoveLower();

        map.put(help.getName(), help);
        map.put(info.getName(), info);
        map.put(show.getName(), show);
        map.put(add.getName(), add);
        map.put(clear.getName(), clear);
        map.put(exit.getName(), exit);
        map.put(head.getName(), head);
        map.put(save.getName(), save);
        map.put(execute.getName(), execute);
        map.put(update.getName(), update);
        map.put(remove.getName(), remove);
        map.put(remove1.getName(), remove1);
        map.put(removelow.getName(), removelow);

        defCommandSet.add(update.getName());
        defCommandSet.add(remove.getName());
        defCommandSet.add(removelow.getName());
        type();

    }

    public static Map<String, Command> getMap() {
        return map;
    }

    public static Stack<Person> getPeople_data() {
        return people_data;
    }

    public static void setPeople_data(Stack<Person> people_data) {
        CommandsPack.people_data = people_data;
    }

    public static boolean isPeopleDataEmpty() {
        if (people_data.empty()) System.out.println("В коллекции нет элементов.");
        return !people_data.empty();
    }

    public static void sortPeopleData() {
//        Stack<Person> s1 = people_data;
//        Stack<Person> s2 = new Stack<>();
//        while (!s1.isEmpty()) {
//            Person temp = s1.pop();
//
//
//            while (!s2.isEmpty() && s2.peek().getId() <= temp.getId()) {
//                if (s2.peek().getId().equals(temp.getId())) temp.setId(temp.getId() + 1);//если одинаковые id
//                s1.push(s2.pop());
//            }
//            s2.push(temp);
//        }
//        people_data = s2;
        people_data.sort(new PersonIdComparator());
    }

    public static void putPeopleDataUp(int id) {

        Stack<Person> s1 = people_data;
        Stack<Person> s2 = new Stack<>();
        while (!s1.isEmpty()) {
            Person temp = s1.pop();
            while (!s2.isEmpty() && s2.peek().getId() == id) {
                s1.push(s2.pop());
            }
            s2.push(temp);
        }
        people_data = s2;

    }

    public static String mapFind(String textLine) {
        String command = null;
        String[] setOfCommands = textLine.split(" ");
        boolean flag = false;
        for (String check : setOfCommands) {
            for (Map.Entry<String, Command> set : CommandsPack.map.entrySet()) {
                command = check.equals(set.getKey()) ? check : command;
                isDefaultCommand = check.equals("def") || isDefaultCommand;
            }


            if (flag){
                try {
                    inputID = Integer.parseInt(check);

                } catch (NumberFormatException e) {
                    System.err.println("Неверный ID.");
                }
            }
            for (String s : defCommandSet) flag = Objects.equals(command, s) || flag;
//            command = Objects.equals(set.getKey(), textLine) ? textLine : command;
//            command = textLine.contains(set.getKey()) ? set.getKey() : command;
//            System.out.println(set.getKey() + " " + textLine + " ^^ " + command);
        }
        return command;
    }

    private static void type() {
        Scanner console = new Scanner(System.in);
        String inputC;
        String path;
        do {
            inputC = console.nextLine();
            path = mapFind(inputC);
            if (path == null){
                System.err.println("Неверная команда. Для справки введите 'help'.");
            } else {
                map.get(path).go();
            }
        } while (!inputC.equals("exit"));

//        try{
//           String inputC = console.nextLine();
//           String path = mapFind(inputC);
//            if (path == null) {
//                throw new Exception("Неверная команда. Введите 'help' для справки.");
//            }
//            map.get(path).go();
//        }   catch (Exception e){
//            System.err.println(e.getMessage());
//        }   finally {
//            type();
//        }

    }
}
