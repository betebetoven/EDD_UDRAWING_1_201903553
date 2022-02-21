package com.company;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;
import java.util.Set;
import java.util.HashSet;

public class listaenlazada {
    public nodo First, Last;
    public int tamaño;
    public  listaenlazada()
    {
        this.First = null;
        this.Last = null;
        this.tamaño = 0;
    }
    public void agrega(Object valor)
    {
        nodo mnodo = new nodo(valor);
        if (this.tamaño==0)
            this.First = mnodo;
        else
        {
            nodo ahora = this.First;
            while (ahora.Next != null)
                ahora = ahora.Next;
            ahora.Next = mnodo;
            ahora.Next.Prev = ahora;
        }
        this.tamaño += 1;


    }
    public void agregatop5bn(cliente comparador)
    {
        nodo mnodo = new nodo(comparador);
        if (this.tamaño == 0) {
            this.First = mnodo;
            this.tamaño = 1;
        }
        else
        {
            nodo ahora = this.First;
            while (ahora.Next != null)
            {
                if (((cliente)mnodo.value).bn.tamaño>((cliente)ahora.value).bn.tamaño && ahora == this.First)
                {
                    this.First = mnodo;
                    this.First.Next = ahora;
                    ahora.Prev = this.First;
                    this.tamaño +=1;
                    break;
                }
                else
                if (((cliente)mnodo.value).bn.tamaño<=((cliente)ahora.value).bn.tamaño && ((cliente)mnodo.value).bn.tamaño>((cliente)ahora.Next.value).bn.tamaño)
                {
                    ahora.Prev.Next.Next = mnodo;
                    ahora.Next.Prev = mnodo;
                    mnodo.Prev = ahora.Prev.Next;
                    mnodo.Next = ahora.Next;
                    ahora.Next = mnodo;
                    this.tamaño += 1;
                    break;

                }
                ahora = ahora.Next;

            }
            if(ahora.Next == null && ((cliente)mnodo.value).bn.tamaño <= ((cliente)ahora.value).bn.tamaño)
            {
                this.agrega(comparador);
            }
            else if (ahora.Next == null && ((cliente)mnodo.value).bn.tamaño>((cliente)ahora.value).bn.tamaño && ahora == this.First)
            {
                this.First = mnodo;
                this.tamaño += 1;
                this.agrega(ahora.value);

            }
        }
    }


    public void agregatop5color(cliente comparador)
    {
        nodo mnodo = new nodo(comparador);
        if (this.tamaño == 0) {
            this.First = mnodo;
            this.tamaño =1;
        }
        else
        {
            nodo ahora = this.First;
            while (ahora.Next != null)
            {
                if (((cliente)mnodo.value).color.tamaño>((cliente)ahora.value).color.tamaño && ahora == this.First)
                {
                    this.First = mnodo;
                    this.First.Next = ahora;
                    ahora.Prev = this.First;
                    this.tamaño +=1;
                    break;
                }
                else
                    if (((cliente)mnodo.value).color.tamaño<=((cliente)ahora.value).color.tamaño && ((cliente)mnodo.value).color.tamaño>((cliente)ahora.Next.value).color.tamaño)
                    {
                        ahora.Prev.Next.Next = mnodo;
                        ahora.Next.Prev = mnodo;
                        mnodo.Prev = ahora.Prev.Next;
                        mnodo.Next = ahora.Next;
                        ahora.Next = mnodo;
                        this.tamaño += 1;
                        break;

                    }
                    ahora = ahora.Next;

            }
            if(ahora.Next == null && ((cliente)mnodo.value).color.tamaño <= ((cliente)ahora.value).color.tamaño)
            {
                this.agrega(comparador);
            }
            else if (ahora.Next == null && ((cliente)mnodo.value).color.tamaño>((cliente)ahora.value).color.tamaño && ahora == this.First)
            {
                this.First = mnodo;
                this.tamaño += 1;
                this.agrega(ahora.value);

            }
        }

    }

    public void reemplazar(nodo comparador, nodo reemplaza )
    {
        nodo ahora = this.First;
        if(ahora.value.getClass() == comparador.value.getClass())
            this.First.value = reemplaza.value;
        else
        while  (ahora != null)
        {
            if(ahora.Next.value.getClass()== comparador.value.getClass()) {
                ahora.Next.value = reemplaza.value;
                break;
            }

            ahora = ahora.Next;


        }


    }
    public nodo popEspecifico(nodo comparador)
    {
        nodo ahora = this.First;
        if (ahora.value == comparador.value) {
            this.popFirst();
            return comparador;
        }

        else {
            ahora = ahora.Next;
            while (ahora != null) {


                if (ahora.value == comparador.value) {

                    if(ahora.Next != null) {
                        ahora.Prev.Next = ahora.Next;
                        ahora.Next.Prev = ahora.Prev;
                        ahora = null;
                        return comparador;
                    }
                    else
                    {
                        ahora.Prev.Next = null;
                        ahora=null;
                        return comparador;
                    }


                }
                ahora = ahora.Next;
            }
            return null;
        }
    }
    public nodo popEspecificoconreemplazo(nodo comparador)
    {
        vacio obj_vacio = new vacio();
        nodo ahora = this.First;
        if (ahora.value == comparador.value) {
            this.First.value = obj_vacio;

            return comparador;
        }
        else {

            while (ahora.Next != null) {


                if (ahora.Next.value == comparador.value) {
                    ahora.Next.value = obj_vacio;

                    return comparador;


                }
                ahora = ahora.Next;
            }
            return  null;
        }
    }
    public nodo popFirst()
    {
        if(this.tamaño ==1) {
            nodo k = this.First;
            this.First = null;

            this.tamaño = 0;
            return k;
        }
        else
        if (this.tamaño != 0)
        {
            nodo a = this.First;
            this.First = a.Next;
            this.First.Prev = null;
            this.tamaño -= 1;
            return a;
        }
        else return null;

    }


    public String getListFromGraphviz()
    {
        int contador = 0;
       String texto = "digraph G\n"
               +"{\n"
               +"        node[shape = circle]\n"
               +"        node[style = filled]\n"
               +"        node[fillcolor = \"#EEEEE\"]\n"
               +"        node[color = \"#EEEEE\"]\n"
               +"        node[color = \"#31CEF0\"]\n";
       nodo recorreg = this.First;
       while (recorreg!=null)
       {
           if(recorreg.value.getClass()==cliente.class)
           texto+=((cliente)recorreg.value).getname()+"->";
           else
               texto+="vacio_"+contador+ "_vacio->";


           recorreg = recorreg.Next;
           contador++;
       }
        recorreg = this.First;
        while (recorreg.Next!=null)
        {
            recorreg = recorreg.Next;
        }
        while (recorreg!=null)
        {
            if(recorreg.value.getClass()==cliente.class)
                texto+=((cliente)recorreg.value).getname()+"->";
            else
                texto+="vacio_"+contador+ "_vacio->";
            recorreg = recorreg.Prev;
            contador--;
        }
        texto+="NULL\n";
        texto+="rankdir = LR;\n"
                +"}";
        return texto;


    }
    public void   creaFile(String ruta, String contenido)
    {
        FileWriter fw =null;
        PrintWriter pw = null;
        try {
               fw = new FileWriter(ruta);
               pw = new PrintWriter(fw);
               pw.write(contenido);
               pw.close();
               fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (pw != null)
                pw.close();
        }

    }
    public void drawGraphviz()
    {
        try {


            creaFile("file.dot",getListFromGraphviz());
            ProcessBuilder pb;
            //"dot","-Tpng","-o","list.png","file.dot"
            pb = new ProcessBuilder( "dot", "-Tpng", "-o lista.png", "file.dot");
            pb.redirectErrorStream(true);
            pb.start();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    //public nodo popespecifico(nodo juan)
    {
        if (this.tamaño != 0)
        {

        }

    }



}
