package com.example.lab5;

import com.example.lab5.users.User;
import com.example.lab5.users.UserType;

public class FabricProfessorsF extends FabricProfessors{

    public FabricProfessorsF(UserGenerator UG) {
        super(UG);
        this.UT = UserType.PROFESSOR_FEMALE;
    }

    @Override
    public void setName(User u) {
        u.setUserName(UG.getArrayFemaleNames()[random.nextInt(0, UG.getArrayFemaleNames().length)]);
    }

    @Override
    public void setSex(User u) {
        u.setSex("Female");
    }
}
