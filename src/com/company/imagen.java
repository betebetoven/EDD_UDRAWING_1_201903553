package com.company;

public class imagen {
public String color, dueño;
public int id,pasos;
public  imagen(String color, String dueño,int id,int pasos)
{
    this.color = color;
    this.dueño = dueño;
    this.id = id;
    this.pasos = pasos;
}

    public String getodo() {
        return "color: "+color+"  dueño:  "+dueño+"  di:  "+id;
    }
}
