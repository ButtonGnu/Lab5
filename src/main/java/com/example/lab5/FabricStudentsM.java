package com.example.lab5;

import com.example.lab5.users.User;
import com.example.lab5.users.UserType;

public class FabricStudentsM extends FabricStudents {
    public FabricStudentsM(UserGenerator UG) {
        super(UG);
        this.UT = UserType.STUDENT_MALE;
    }

    @Override
    public void setName(User u) {
        u.setUserName(UG.getArrayMaleNames()[random.nextInt(0, UG.getArrayMaleNames().length)]);
    }

    @Override
    public void setSex(User u) {
        u.setSex("Male");
    }
}
