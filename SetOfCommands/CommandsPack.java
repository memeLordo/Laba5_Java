package SetOfCommands;

import Parameters.Person;

import java.util.*;

public class CommandsPack {
    private static final Map<String, Command> map = new HashMap<>();
    public static boolean isDefaultCommand = false;
    public static Integer inputID = 0;
    private static Stack<Person> people_data = new Stack<>();

    public static void go() {

        Command help = new Help();
        Command info = new Info();
        Command show = new Show();
        Command add = new Add();
        Command exit = new Exit();
        Command head = new Head();
        Command update = new UpdateID();
        Command remove = new RemoveID();


        map.put(help.getName(), help);
        map.put(info.getName(), info);
        map.put(show.getName(), show);
        map.put(add.getName(), add);
        map.put(exit.getName(), exit);
        map.put(head.getName(), head);
        map.put(head.getName(), head);
        map.put(update.getName(), update);
        map.put(remove.getName(), remove);

        type();

    }

    public static Map<String, Command> getMap() {
        return map;
    }

    public static Stack<Person> getPeople_data() {
        return people_data;
    }

    public static boolean isPeopleDataEmpty() {
        if (people_data.empty()) System.out.println("В коллекции нет элементов.");
        return !people_data.empty();
    }

    public static void sortPeopleData() {
        Stack<Person> s1 = people_data;
        Stack<Person> s2 = new Stack<>();
        while (!s1.isEmpty()) {
            Person temp = s1.pop();


            while (!s2.isEmpty() && s2.peek().getId() <= temp.getId()) {
                if (s2.peek().getId().equals(temp.getId())) temp.setId(temp.getId() + 1);//если одинаковые id
                s1.push(s2.pop());
            }
            s2.push(temp);
        }
        people_data = s2;
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

    private static String mapFind(String textLine) {
        String command = null;
        String[] setOfCommands = textLine.split(" ");
        boolean flag = false;
        for (String check : setOfCommands) {
            for (Map.Entry<String, Command> set : CommandsPack.map.entrySet()) {
                command = check.equals(set.getKey()) ? check : command;
                isDefaultCommand = check.equals("def") || isDefaultCommand;
            }

//            System.out.println(check + " " + command);
            if (flag){
                try {
                    inputID = Integer.parseInt(check);
//                    System.out.println(check + " " + inputID);
                } catch (NumberFormatException e) {
                    System.err.println("Неверный ID.");
                }
            }

            if (Objects.equals(command, new UpdateID().getName()) | (Objects.equals(command, new RemoveID().getName())))
                flag = true;
//            command= Objects.equals(set.getKey(), textLine) ?textLine:command;
//            command= textLine.contains(set.getKey()) ? set.getKey():command;
//            System.out.println(set.getKey() +  " "+ textLine +" ^^ " + command);
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
                System.err.println("Неверная команда. Введите help для справки.");
            } else {
                map.get(path).go();
            }
        } while (!inputC.equals("exit"));
//        try{
//            inputC = console.nextLine();
//            path = mapFind(inputC);
//            if (path == null) {
//                throw new Exception("Неверная команда. Введите help для справки.");
//            }
//            map.get(path).go();
//            type();
//        }
//        catch (Exception e){
//            System.err.println(e.getMessage());
//            type();
//        }
    }
}
