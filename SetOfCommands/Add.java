package SetOfCommands;

import Exceptions.EmptyLineException;
import Parameters.*;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Add extends Command {


    public Add() {

        super("add", "добавить новый элемент в коллекцию");

    }

    @Override
    void go() {
        if (CommandsPack.isDefaultCommand) {
            Person bebra = new Person();
            CommandsPack.getPeople_data().push(bebra);
            CommandsPack.sortPeopleData();
            CommandsPack.isDefaultCommand = false;
            System.out.println("Добавлен новый стандартный пользователь");
        } else {
            Person bebraPerson = Add.PersonSet();
            CommandsPack.getPeople_data().push(bebraPerson);
            CommandsPack.sortPeopleData();
            System.out.println("Добавлен новый пользователь");
        }
    }
    public static Person PersonSet(){
        Setter s = new Setter();
        return new Person(s.Name(), s.Coordinates(), s.Height(), s.Weight(), s.Birthday(), s.Color(), s.Location());
    }
    public static Person PersonSet(int id){
        Setter s = new Setter();
        Person p = new Person(s.Name(), s.Coordinates(), s.Height(), s.Weight(), s.Birthday(), s.Color(), s.Location());
        p.setId(id);
        return p;
    }
    private static class Setter implements PersonSet {
        private static boolean flag = true;
        private final Scanner console = new Scanner(System.in);

        @Override
        public Integer Id() {
            return new Generator().Id();
        }

        @Override
        public String Name() {
            String name;

            try {
                System.out.print("Имя: ");
                name = console.nextLine();
                if (name.equals("")) throw new EmptyLineException("Имя");
            } catch (EmptyLineException e) {
                System.out.println(e);
                return new Setter().Name();
            }

            return name;
        }

        @Override
        public Coordinates Coordinates() {
            long x = 0, y = 0;

            try {
                System.out.print("Координаты: ");
                x = Long.parseLong(console.next().strip());
                y = Long.parseLong(console.nextLine().strip());
            } catch (RuntimeException e) {
                System.out.println("Неверный тип ввода. +");
                new Setter().Coordinates();
            }
            return new Coordinates(x, y);
        }

        @Override
        public Long Height() {
            long h = 1;

            try {
                System.out.print("Рост: ");
                h = Long.parseLong(console.nextLine());
                if (h <= 0) throw new RuntimeException("Рост не может быть равен 0 или ниже.");
            } catch (InputMismatchException e) {
                System.out.println("Неверный тип ввода. ");
                new Setter().Height();
            } catch (RuntimeException e1) {
                System.out.println(e1.getMessage());
                return new Setter().Height();
            }

            return h;
        }

        @Override
        public Double Weight()throws EmptyLineException {

            double w = 1;
            try {
                System.out.print("Вес: ");
                w = Float.parseFloat(console.nextLine());
                if (w <= 0) throw new RuntimeException("Вес не может быть равен 0 или ниже.");
            } catch (InputMismatchException e) {
                System.out.println("Неверный тип ввода. ");
                new Setter().Weight();
            } catch (RuntimeException e1) {
                System.out.println(e1.getMessage());
                return new Setter().Weight();
            }

            return w;
        }

        @Override
        public LocalDate Birthday() {

            int day, month, year;

            try {
                System.out.print("Введите дату рождения (день-месяц-год): ");
                day = Integer.parseUnsignedInt(console.next().strip());
                month = Integer.parseUnsignedInt(console.next().strip());
                year = Integer.parseUnsignedInt(console.nextLine().strip());
                if (!(day > 0 && month > 0 && year > 0 && day <= 31 && month <= 12))
                    throw new RuntimeException("Неверные границы дат.");
            } catch (InputMismatchException e) {
                System.out.println("Неверный тип ввода. ");
                return new Setter().Birthday();
            } catch (RuntimeException e1) {
                System.out.println(e1.getMessage());
                return new Setter().Birthday();
            }
            return LocalDate.of(year, month, day);

        }

        @Override
        public Color Color() {
            Color answer;
            if (flag) {
                System.out.println("Введите цвет глаз из доступных: ");
                for (Color colors : Color.values()) {
                    System.out.println(colors.getName());
                }
                flag = false;
            }

            try {
                System.out.print("Цвет: ");
                console.reset();
                answer = Color.find(console.nextLine());
                if (answer == null)
                    throw new RuntimeException("Нет такого цвета.");
                flag = true;

            } catch (RuntimeException e1) {
                System.out.println(e1.getMessage());
                return new Setter().Color();
            }
            return answer;
        }


        @Override
        public Location Location() {
            String name;
            try {
                System.out.print("Введите название локации: ");
                name = console.nextLine();
                if (name.equals("")) throw new EmptyLineException("Локация");
            } catch (EmptyLineException e) {
                System.out.println(e);
                return new Setter().Location();
            }
            int x = new Random().nextInt(180);
            int y = new Random().nextInt(180);
            float z = new Random().nextFloat() * 100;

            System.out.printf("%s° : %s° : %s \n", x, y, z);
            return new Location(x, y, z, name);
        }


    }


}
