package hu.godenyd.aoc2022;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

public class App {
    public static void main(String[] args) throws Exception {
        List<Class<? extends Day>> classes = findAllClassesUsingReflectionsLibrary();

        List<String> collect = IntStream.range(0, classes.size())
                .mapToObj(index -> index + ":\t" + classes.get(index).getSimpleName())
                .collect(Collectors.toList());
        System.out.println("Please select day to run!");

        collect.forEach(System.out::println);

        int input = Integer.parseInt(new Scanner(System.in).nextLine());

        Class<?> day = Class.forName(classes.get(input).getName());

        day.getMethod("doTask").invoke(day.getDeclaredConstructor().newInstance());
    }

    public static List<Class<? extends Day>> findAllClassesUsingReflectionsLibrary() {
        Reflections reflections = new Reflections(
                "hu.godenyd.aoc2022.days",
                new SubTypesScanner(false));

        return reflections.getSubTypesOf(Day.class)
                .stream()
                .sorted((c1, c2) -> c1.getSimpleName().compareTo(c2.getSimpleName()))
                .collect(Collectors.toList());
    }
}
