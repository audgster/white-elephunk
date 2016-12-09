package com.audrey;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("No input file was provided");
            System.exit(1);
        }

        HashSet<String> uniquePeople = new HashSet<>();
        File file = new File(args[0]);

        try {
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                if (!uniquePeople.add(sc.nextLine()))
                    System.out.println("Oops, did you mean to have a duplicate?");
            }

        } catch(FileNotFoundException ex) {
            System.out.println("Oops that file name isn't valid");
            System.exit(1);
        }

        Object[] people = uniquePeople.toArray();

        for (int i = 0; i < people.length; i++) {
            int switchIndex = generateRandomNumberWithMax(people.length - 1);

            Object current = people[i];
            Object switcher = people[switchIndex];

            people[i] = switcher;
            people[switchIndex] = current;
        }

        for (int i = 0; i < people.length; i++) {
            System.out.println(people[i].toString());
        }

    }

    private static int generateRandomNumberWithMax(int max) {
        return (int) (Math.random() * max);
    }
}
