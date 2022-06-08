package com.example.lab5.users;

import com.example.lab5.*;


import java.util.concurrent.ThreadLocalRandom;

import static com.example.lab5.users.UserType.STUDENT_MALE;

public class GetUserFactory {
    public static Fabric getFabric(ThreadLocalRandom random, UserGenerator UG){
        Fabric fabric;
        if (random.nextInt(0, 100) > 80) {
            if (random.nextInt(0, 100) > 70) {
                fabric = new FabricProfessorsF(UG);
            } else {
                fabric = new FabricProfessorsM(UG);
            }
        }
        else{
            if (random.nextInt(0, 100) > 70) {
                fabric = new FabricStudentsF(UG);
            }else{
                fabric = new FabricStudentsM(UG);
            }
        }
        return fabric;
    }

    public static User getUser(UserType userType){
        switch (userType){
            case STUDENT_MALE -> {
                return new StudentMale();
            }
            case STUDENT_FEMALE -> {
                return new StudentFemale();
            }
            case PROFESSOR_FEMALE -> {
                return new ProfFemale();
            }
            case PROFESSOR_MALE -> {
                return new ProfMale();
            }
            default -> {
                throw new RuntimeException("Wrong user type.");
            }
        }
    }
}
