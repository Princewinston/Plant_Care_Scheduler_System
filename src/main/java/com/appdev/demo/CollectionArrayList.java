package com.appdev.demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeSet;
import java.util.function.Consumer;

public class CollectionArrayList {

    private ArrayList<String> arrayListReference = new ArrayList<>();

    // Add elements
    public void understandingArrayMethods() {

        arrayListReference.add("Ajin");
        arrayListReference.add("Ajin2");
        arrayListReference.add("Ajin3");
        arrayListReference.add("Ajin4");

        arrayListReference.addAll(List.of("Hello", "Hello3"));
    }

    // Display methods
    public void display() {

        System.out.println("\nOriginal List:");
        System.out.println(arrayListReference);

        // Method Reference
        Consumer<Object> data = System.out::println;
        data.accept("Method Reference : " + arrayListReference);

        // Lambda Expression
        Consumer<Object> dataTwo = x -> System.out.println(x);
        dataTwo.accept("Lambda Expression : " + arrayListReference);

        // Stream
        System.out.println("\nPrinting using Stream");
        arrayListReference.forEach(x -> System.out.println("Element : " + x));
    }

    // contains()
    public void checkContains() {

        System.out.println("\nContains 'Ajin' ? "
                + arrayListReference.contains("Ajin"));

        System.out.println("Contains 'Java' ? "
                + arrayListReference.contains("Java"));
    }

    // Interview Questions
    public void interviewQuestions() {

        ArrayList<Integer> dup = new ArrayList<>(
                List.of(1, 2, 3, 4, 90, 56, 34, 2, 3, 4));

        System.out.println("\nOriginal List");
        System.out.println(dup);

        // Normal for-each
        System.out.println("\nNormal For-Each");
        for (Integer value : dup) {
            System.out.println(value);
        }

        // Lambda
        System.out.println("\nLambda");
        dup.forEach(x -> System.out.println(x));

        // Method Reference
        System.out.println("\nMethod Reference");
        dup.forEach(System.out::println);

        // Remove duplicates using contains()
        ArrayList<Integer> unique = new ArrayList<>();

        for (Integer value : dup) {
            if (!unique.contains(value)) {
                unique.add(value);
            }
        }

        System.out.println("\nUnique using contains()");
        System.out.println(unique);

        // TreeSet (Sorted + Unique)
        ArrayList<Integer> uniqueTree = new ArrayList<>(new TreeSet<>(dup));

        System.out.println("\nUnique + Sorted (TreeSet)");
        System.out.println(uniqueTree);

        // LinkedHashSet (Preserve Order + Unique)
        ArrayList<Integer> uniqueLinked = new ArrayList<>(new LinkedHashSet<>(dup));

        System.out.println("\nUnique + Preserve Order (LinkedHashSet)");
        System.out.println(uniqueLinked);

        // HashSet (Unique only)
        ArrayList<Integer> uniqueHash = new ArrayList<>(new HashSet<>(dup));

        System.out.println("\nUnique (HashSet)");
        System.out.println(uniqueHash);

        // Stream distinct
        System.out.println("\nDistinct using Stream");
        System.out.println(
                dup.stream()
                        .distinct()
                        .toList());

        // Sorted
        System.out.println("\nSorted");
        System.out.println(
                dup.stream()
                        .sorted()
                        .toList());

        // Reverse Sorted
        System.out.println("\nReverse Sorted");
        System.out.println(
                dup.stream()
                        .sorted(Comparator.reverseOrder())
                        .toList());

        // Intersection
        List<Integer> a = new ArrayList<>(List.of(1, 2, 3, 4));
        List<Integer> b = List.of(3, 4, 5, 6);

        List<Integer> common = new ArrayList<>(a);
        common.retainAll(b);

        System.out.println("\nIntersection");
        System.out.println(common);

        // Filter (>30)
        ArrayList<Integer> filtered = new ArrayList<>();

        for (Integer value : dup) {
            if (value > 30) {
                filtered.add(value);
            }
        }

        System.out.println("\nFiltered (>30)");
        System.out.println(filtered);

        // Remove using Iterator
        ArrayList<Integer> removeExample = new ArrayList<>(dup);

        Iterator<Integer> iterator = removeExample.iterator();

        while (iterator.hasNext()) {
            if (iterator.next() > 30) {
                iterator.remove();
            }
        }

        System.out.println("\nAfter Removing >30");
        System.out.println(removeExample);

        // Modern removeIf()
        ArrayList<Integer> removeIfExample = new ArrayList<>(dup);

        removeIfExample.removeIf(x -> x > 30);

        System.out.println("\nUsing removeIf()");
        System.out.println(removeIfExample);

        // replaceAll()
        ArrayList<Integer> replaceExample = new ArrayList<>(dup);

        replaceExample.replaceAll(x -> x * 10);

        System.out.println("\nreplaceAll(x -> x * 10)");
        System.out.println(replaceExample);

        // set()
        if (replaceExample.size() > 5) {
            replaceExample.set(5, 999);
        }

        System.out.println("\nAfter set(5,999)");
        System.out.println(replaceExample);
    }

    // Getter (useful for Spring Boot Controller)
    public List<String> getArrayListReference() {
        return arrayListReference;
    }
}