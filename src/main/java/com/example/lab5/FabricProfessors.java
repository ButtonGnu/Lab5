package com.example.lab5;

import com.example.lab5.users.*;

public abstract class FabricProfessors extends Fabric {

    public FabricProfessors(UserGenerator UG) {
        super(UG);
    }

    public void setMiddleName(User u){
        try {
            u.setMiddleName(UG.getArrayMiddleNames()[random.nextInt(0, UG.getArrayMiddleNames().length)]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setSurname(User u) {
        u.setUserSurname(UG.getArrayProfSurnames()[random.nextInt(0, UG.getArrayProfSurnames().length)]);
    }

    @Override
    public User CreateUser() {
        User u = super.CreateUser();
        setMiddleName(u);
        return u;
    }
}
