package com.example.lab5;

import com.example.lab5.books.Book;
import com.example.lab5.users.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class UserGenerator {
    private ThreadLocalRandom random;
    private String[] arrayMaleNames;
    private String[] arrayMiddleNames;
    private String[] arraySurnames;
    private String[] arrayProfSurnames;
    private String[] arrayFemaleNames;

    private Reader uReader;

    public UserGenerator(File file) throws IOException, InvalidFormatException {
        this.random = ThreadLocalRandom.current();
        uReader = new Reader(file);
        setUp();
    }
    /*
    public User createUser(Map<Book, Boolean> books) {
        if (random.nextInt(0, 100) > 80) {
            if (random.nextInt(0, 100) > 70) {
                ProfFemale profFemale = (ProfFemale) GetUserFactory.getUser(UserType.PROFESSOR_FEMALE);
                profFemale.setUserName(arrayFemaleNames[random.nextInt(0, arrayFemaleNames.length)]);
                profFemale.setMiddleName(arrayMiddleNames[random.nextInt(0, arrayMiddleNames.length)]);
                profFemale.setUserSurname(arrayProfSurnames[random.nextInt(0, arraySurnames.length)]);
                profFemale.setBooks(generateBookSet(books));
                return profFemale;
            } else {
                ProfMale profMale = (ProfMale) GetUserFactory.getUser(UserType.PROFESSOR_MALE);
                profMale.setUserName(arrayMaleNames[random.nextInt(0, arrayMaleNames.length)]);
                profMale.setMiddleName(arrayMiddleNames[random.nextInt(0, arrayMiddleNames.length)]);
                profMale.setUserSurname(arrayProfSurnames[random.nextInt(0, arraySurnames.length)]);
                profMale.setBooks(generateBookSet(books));
                return profMale;
            }
        } else {
            if (random.nextInt(0, 100) > 70) {
                User studentFemale = GetUserFactory.getUser(UserType.STUDENT_FEMALE);
                studentFemale.setUserName(arrayFemaleNames[random.nextInt(0, arrayFemaleNames.length)]);
                studentFemale.setUserSurname(arraySurnames[random.nextInt(0, arraySurnames.length)]);
                studentFemale.setBooks(generateBookSet(books));
                return studentFemale;
            } else {
                User studentMale = GetUserFactory.getUser(UserType.STUDENT_MALE);
                studentMale.setUserName(arrayMaleNames[random.nextInt(0, arrayMaleNames.length)]);
                studentMale.setUserSurname(arraySurnames[random.nextInt(0, arraySurnames.length)]);
                studentMale.setBooks(generateBookSet(books));
                return studentMale;
            }
        }
    }
    */
    public User createUser(Map<Book, Boolean> books){
        Fabric fabric =  GetUserFactory.getFabric(this.random, this);
        fabric.setBooks(books);
        return fabric.CreateUser();
    }
    private void setUp() throws IOException, InvalidFormatException {
        arrayMaleNames = uReader.readData(0);
        arrayFemaleNames = uReader.readData(1);
        arraySurnames = uReader.readData(2);
        arrayProfSurnames = uReader.readData(3);
        arrayMiddleNames = buildMiddleNames();
        uReader.close();
    }

    private String[] buildMiddleNames() {
        String[] arrMiddleNames = new String[arrayMaleNames.length];
        int i = 0;
        for (String name : arrayMaleNames) {
            if (name.endsWith("ья")) {
                arrMiddleNames[i] = name.substring(0, name.length() - 1) + "ич";
            } else if (name.endsWith("ж") || name.endsWith("ш") || name.endsWith("ч") || name.endsWith("щ") || name.endsWith("ц") || name.endsWith("и") || name.endsWith("э") || name.endsWith("я") || name.endsWith("ю") || name.endsWith("е") || name.endsWith("ё")) {
                arrMiddleNames[i] = name + "евич";
            } else if (name.endsWith("н") || name.endsWith("р") || name.endsWith("м") || name.endsWith("л") || name.endsWith("с") || name.endsWith("б")) {
                arrMiddleNames[i] = name + "ович";
            } else if (name.endsWith("а") || name.endsWith("у") || name.endsWith("ы")) {
                arrMiddleNames[i] = name.substring(0, name.length() - 1) + "ович";
            } else if (name.endsWith("о")) {
                arrMiddleNames[i] = name.substring(0, name.length() - 1) + "вич";
            } else if (name.endsWith("ь") || name.endsWith("й")) {
                arrMiddleNames[i] = name.substring(0, name.length() - 1) + "евич";
            } else {
                arrMiddleNames[i] = name + "евич";
            }
            i++;
        }
        return arrMiddleNames;
    }

    public Set<Book> generateBookSet(Map<Book, Boolean> booksList) {
        int num = random.nextInt(3, 11);
        Set<Book> books = new HashSet<>();
        List<Book> freeBooks = new ArrayList<>();
        for (Map.Entry<Book, Boolean> bookBooleanEntry : booksList.entrySet()) {
            if (!bookBooleanEntry.getValue()) {
                freeBooks.add(bookBooleanEntry.getKey());
                for (int i = 0; i < num; i++) {
                    if (freeBooks.size() != 0) {
                        Book bookToTake = freeBooks.get(random.nextInt(0, freeBooks.size()));
                        books.add(bookToTake);
                        booksList.put(bookToTake, true);
                    }
                }
            }
        }
        return books;
    }

    public String[] getArrayMaleNames() {
        return arrayMaleNames;
    }

    public String[] getArrayMiddleNames() {
        return arrayMiddleNames;
    }

    public String[] getArraySurnames() {
        return arraySurnames;
    }

    public String[] getArrayProfSurnames() {
        return arrayProfSurnames;
    }

    public String[] getArrayFemaleNames() {
        return arrayFemaleNames;
    }
}