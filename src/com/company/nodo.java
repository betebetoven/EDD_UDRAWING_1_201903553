package com.company;

public class nodo {
    public   Object value;
    public   nodo Next, Prev;
    public nodo(Object value){
        this.value = value;
        this.Next = null;
        this.Prev = null;

    }

    public Object getyou()
    {
        return value;
    }

}
