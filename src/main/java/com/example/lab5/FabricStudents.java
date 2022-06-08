package com.example.lab5;

import com.example.lab5.users.*;

public abstract class FabricStudents extends Fabric {

    public FabricStudents(UserGenerator UG) {
        super(UG);
    }

    @Override
    public void setSurname(User u) {

        u.setUserSurname(UG.getArraySurnames()[random.nextInt(0, UG.getArraySurnames().length)]);
    }

}
