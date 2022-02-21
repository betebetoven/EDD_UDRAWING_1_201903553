package com.company;

import java.util.ArrayList;

public class cliente {
    public int contadordeimaggenes,id_cliente,img_color,img_bw,fotos,contadordepasos;
    public String nombre_cliente ;
    public  imagen foto;
    public listaenlazada bn;
    public listaenlazada color;
    public cliente(int id_cliente, String nombre_cliente, int img_color, int img_bw)
    {
        this.id_cliente = id_cliente;
        this.nombre_cliente = nombre_cliente;
        this.img_color = img_color;
        this.img_bw = img_bw;
        this.contadordeimaggenes = 0;
        this.fotos = img_bw+img_color;



    }
    public void terminardeconstruir()
    {
        this.bn = new listaenlazada();
        this.color = new listaenlazada();
        this.fotos = this.img_color + this.img_bw;
        this.contadordepasos= (2*this.img_color)+(this.img_bw)+this.fotos+2;
    }
    public String vercliente()
    {


        return ("id:" +this.id_cliente+"  nombre: "+this.nombre_cliente+"  fotos color: "+this.img_color+"  fotos bn: "+this.img_bw+"  fotos: "+this.fotos);
    }
    public String getname()
    {
        String[]jefe ;
        jefe=this.nombre_cliente.split("\\s+");

        return (jefe[0]+"_"+jefe[1]);
    }
}
