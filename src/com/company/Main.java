package com.company;
import jdk.internal.org.objectweb.asm.tree.analysis.Value;
//import jdk.nashorn.internal.parser.JSONParser;
//import jdk.nashorn.internal.parser.JSONParser;
import jdk.nashorn.internal.runtime.JSONListAdapter;

import jdk.nashorn.internal.parser.JSONParser;

import  java.*;
import com.google.gson.*;
import java.io.FileWriter;
import java.io.FileReader;
import java.util.Set;
import java.util.HashSet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.security.Key;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import javax.print.DocFlavor;
import javax.swing.*;
import java.util.Random;
import javax.swing.plaf.synth.SynthTextAreaUI;

public class Main {
    public static Scanner input = new Scanner(System.in);

    public static imagen img;
    public static nodo n,fecha,poema;
    public static String[] nombre = {"alberto","josue","sofia","ada","roberto","oliver","diego","ernesto","emil","mafalda","maria","fernanda","bigail","lousi","christian","erick","esteban","jose","gabriel","benito","richard","rodrito","lesteer","amelia","judia","gloria","lista","golondrina","vrigida","walter","stevenks"};
    public static Random rndm = new Random();


    public static String partir = "a b c d e f g h i j k l m n ñ o p q r s t u v w x y z a1 a2 a3 a4 a5 a6 a7 a8 b1 b2 b3 b4 b5 b6 b7 b8 b9 c1 c2 c3 c4 c5 c6 c7 c8 c9 c10 d1 d2 d3 d4 d5 d6 d7 d8 d9 d10 z1 z2 z3 z4 z5 z6 z7 z8 z9 qwer asdf zvc rth sdfg ty sdf rth erg ";
    public static String[] apellido = partir.split("\\s+");
    public static ArrayList<cliente> clientes = new ArrayList<>();
    public static Gson gsus = new Gson();
    public static String dir = "C:\\Users\\Alberto\\Downloads\\generated.json";
    public static JFileChooser ventanita = new JFileChooser();
    public static listaenlazada cola_entrada = new listaenlazada();
    public static listaenlazada ventanillas = new listaenlazada();
    public static listaenlazada imp_color = new listaenlazada();
    public static listaenlazada imp_bn = new listaenlazada();
    public static listaenlazada sala_espera = new listaenlazada();
    public static listaenlazada listatotaldeclientes = new listaenlazada();
    public static cliente cientemaspasos = null;
    public static listaenlazada top5color = new listaenlazada();
    public static listaenlazada top5bn = new listaenlazada();
    public static String getContentOfFile(String pathname) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File(pathname);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            // Lectura del fichero
            String content = "";
            String linea;
            while ((linea = br.readLine()) != null) {
                content += linea + "\n";
            }
            return content;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            //otro cambio solo para hacerlo bien
            // que se cierra tanto si todo va bien como si salta
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return "";
    }

    //public  static JSONParser parsero = new JSONParser();
    //public static String[] jefa = {"v","j"};
    //revisaria lo demas pero ya no ay tiempo jejeje


    public static void main(String[] args) throws FileNotFoundException {
        ///////////CONVERSION DE JSON A JSONOBJECT Y GENERACION DE LA COLA DE RECEPCION(INSTANCIAS PRINCIPALES)
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(fileChooser.getParent());
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            dir = selectedFile.getAbsolutePath();
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());
        }
        Gson gsus = new Gson();
        JsonParser parsero = new JsonParser();
        JsonObject objetosito = (JsonObject)parsero.parse(getContentOfFile(dir));
        System.out.println(objetosito);
        Object keys = objetosito.keySet();
        System.out.println(objetosito.keySet());
        System.out.println(objetosito.keySet().getClass());
        Iterator<String> iter = objetosito.keySet().iterator();
        while (iter.hasNext()) {
            String key = iter.next();
            try {
                cliente clientee = gsus.fromJson(objetosito.get(key),cliente.class);
                clientee.terminardeconstruir();
                cola_entrada.agrega(clientee);
                listatotaldeclientes.agrega(clientee);
                System.out.println("\nlista: ");
                nodo m = cola_entrada.First;
                while (m != null)
                {
                    System.out.println(((cliente)m.value).vercliente());
                    m = m.Next;
                }//IMPRESION DE LA COLA
            } catch (Exception e) {
                // Something went wrong!
            }
        }////INGRESO DE DATOS A LISTA ENLAZADA DE COLA DE VENTANILLA
       //INSTANCIA DE CANTIDAD DE VENTANILLAS

        System.out.println("Ingrese la cantidad de ventanillas");
        int qv = Integer.parseInt(input.next());
        for (int i = 0; i<qv;i++)
        {
            vacio vc = new vacio();
            ventanillas.agrega(vc);
        }
        //nombre[0]="ALberto";nombre[1]="Sofia";nombre[5]="Roberto";nombre[6]="Oliver";nombre[7]="Diego";nombre[8]="Ernesto";nombre[9]="Emil";nombre[2]="Ada";nombre[3]="Josue";nombre[4]="Esperancita";
        //apellido[0]="Hernandez";apellido[1]="Armas";apellido[2]="Ruano";apellido[3]="Zamora";apellido[4]="Perez";
        boolean k = true;
        //////FIN DE INSTANCIA GENERAL
        //////YA SE TIENE LISTA DE JSON Y NUMERO DE VENTANILLAS
        //////CARGA GENERAL YA REALIZADA, PRIMEROS PUSH A REALIZARSE



        System.out.println("ver ventanillas");
        nodo ver1 = ventanillas.First;
        while (ver1 != null)
        {
            if(ver1.value.getClass()==cliente.class)
                System.out.println(((cliente)ver1.value).vercliente());
            else
            if (ver1.value.getClass()==vacio.class)
                System.out.println(ver1.value.getClass());
            ver1 = ver1.Next;
        }
        while (k) {


            System.out.println("1.Realizar paso");
            System.out.println("2.ver top 5 de color");
            System.out.println("3. ver top 5 blanco y negro");
            System.out.println("4.ver cliente que paso mas pasos(calculado al salir de la empresa)");
            System.out.println("5. ver informacion de cliente especifico");
            System.out.println("6. ver informacion del estudiante");
            System.out.println("7. salir");
            System.out.println("8. Reporte cola entrada");
            System.out.println("9. Reporte Sala espera");
            System.out.println("10. Reporte cola ventanillas");
            System.out.println("8. Impresora Color");
            String papanoel = input.next().toString();
            if (papanoel.equals("1"))
            {
                //  AHORA LOS PUSH DE LOS CLIENTES EN LA SALA DE ESPERA CON SU PUSH ESPECIFICO JAJUY
                nodo pafuera = sala_espera.First;
                cliente pafueraaux = null;
                while (pafuera != null)
                {
                    if(((cliente)pafuera.value).fotos==(((cliente)pafuera.value).color.tamaño+((cliente)pafuera.value).bn.tamaño))
                    {
                       pafueraaux =(cliente) sala_espera.popEspecifico(pafuera).value;


                       //top5color.agregatop5color(pafueraaux);
                       if(cientemaspasos == null)
                           cientemaspasos = pafueraaux;
                       else
                           if (pafueraaux.contadordepasos > cientemaspasos.contadordepasos)
                           {
                               cientemaspasos = pafueraaux;
                           }


                    }
                    pafuera = pafuera.Next;
                }









                //// REST DE PASOS EN LAS IMPRESORAS Y PUSH DE REGRESO CON SUS CLIENTES

                //PRIMERO EL DE COLOR
                nodo pepacolor = imp_color.First;
                if (pepacolor != null)
                    if(((imagen)pepacolor.value).pasos>0)
                    {
                        if(pepacolor.Next != null) {
                            pepacolor = pepacolor.Next;
                            ((imagen) pepacolor.Prev.value).pasos -=1;
                            pepacolor = pepacolor.Prev;
                        }
                        else
                        {
                            pepacolor = pepacolor.Prev;
                            ((imagen) pepacolor.Next.value).pasos -=1;
                            pepacolor = pepacolor.Next;


                        }
                    }
                    else
                    {
                        nodo buscadueño = sala_espera.First;
                        nodo fotitocolor = imp_color.popFirst();
                        while (buscadueño != null)
                        {
                            if(((cliente)buscadueño.value).nombre_cliente.equals(((imagen)fotitocolor.value).dueño))
                            {
                                if(buscadueño.Next != null)
                                {
                                    buscadueño = buscadueño.Next;
                                    ((cliente)buscadueño.Prev.value).color.agrega((imagen)fotitocolor.value);
                                    buscadueño = buscadueño.Prev;
                                    break;
                                }
                                else
                                if (buscadueño.Prev != null)
                                {
                                    buscadueño = buscadueño.Prev;
                                    ((cliente)buscadueño.Next.value).color.agrega((imagen)fotitocolor.value);
                                    buscadueño = buscadueño.Next;
                                    break;


                                }
                            }
                            buscadueño = buscadueño.Next;

                        }
                    }


                    ///AHORA TOCA BLANCO Y NEGRO

                nodo pepablanco = imp_bn.First;
                if (pepablanco != null)
                    if(((imagen)pepablanco.value).pasos>0)
                    {
                        if(pepablanco.Next != null) {
                            pepablanco = pepablanco.Next;
                            ((imagen) pepablanco.Prev.value).pasos -=1;
                            pepablanco = pepablanco.Prev;
                        }
                        else
                        {
                            pepablanco = pepablanco.Prev;
                            ((imagen) pepablanco.Next.value).pasos -=1;
                            pepablanco = pepacolor.Next;


                        }
                    }
                    else
                    {
                        nodo buscadueñoblanco = sala_espera.First;
                        nodo fotitoblanco = imp_bn.popFirst();
                        while (buscadueñoblanco != null)
                        {
                            if(((cliente)buscadueñoblanco.value).nombre_cliente.equals(((imagen)fotitoblanco.value).dueño))
                            {
                                if(buscadueñoblanco.Next != null)
                                {
                                    buscadueñoblanco = buscadueñoblanco.Next;
                                    ((cliente)buscadueñoblanco.Prev.value).color.agrega((imagen)fotitoblanco.value);
                                    buscadueñoblanco = buscadueñoblanco.Prev;
                                    break;
                                }
                                else
                                if (buscadueñoblanco.Prev != null)
                                {
                                    buscadueñoblanco = buscadueñoblanco.Prev;
                                    ((cliente)buscadueñoblanco.Next.value).color.agrega((imagen)fotitoblanco.value);
                                    System.out.println("mandandole su primera blanca a"+((cliente)buscadueñoblanco.value).nombre_cliente);
                                    buscadueñoblanco = buscadueñoblanco.Next;
                                    break;


                                }
                            }
                            buscadueñoblanco = buscadueñoblanco.Next;

                        }
                    }














                ///push para ventanillas y resta a cada cliente por cada paso(cuando iguala a cero push a sala de espera y a cada cola de impresion)
                nodo jaja = ventanillas.First;
                while (jaja != null)
                {
                    if(jaja.value.getClass()==cliente.class)
                    {
                        if(((cliente)jaja.value).img_color>0)
                        {
                            imagen img = new imagen("color",((cliente)jaja.value).nombre_cliente,((cliente)jaja.value).id_cliente,2);
                            //imp_color.agrega(img);

                            if(jaja.Next != null) {
                                jaja = jaja.Next;
                                ((cliente) jaja.Prev.value).color.agrega(img);

                                ((cliente) jaja.Prev.value).img_color -= 1;
                                jaja = jaja.Prev;
                            }
                            else
                            {
                                jaja = jaja.Prev;
                                ((cliente) jaja.Next.value).color.agrega(img);

                                ((cliente) jaja.Next.value).img_color -= 1;
                                jaja = jaja.Next;

                            }

                            System.out.println("lista de "+((cliente)jaja.value).nombre_cliente+" si deberia de agregar pero no se que peo"+((imagen)((cliente) jaja.value).color.First.value).getodo());
                        }
                        else
                            if(((cliente)jaja.value).img_bw>0)
                                {
                                    imagen img = new imagen("blanco y negro",((cliente)jaja.value).nombre_cliente,((cliente)jaja.value).id_cliente,1);
                                    //imp_bn.agrega(img);
                                    if(jaja.Next != null) {
                                        jaja = jaja.Next;
                                        ((cliente) jaja.Prev.value).bn.agrega(img);
                                        ((cliente) jaja.Prev.value).img_bw -= 1;
                                        jaja = jaja.Prev;
                                    }
                                    else
                                    {
                                        jaja = jaja.Prev;
                                        ((cliente) jaja.Next.value).bn.agrega(img);
                                        ((cliente) jaja.Next.value).img_bw -= 1;
                                        jaja = jaja.Next;

                                    }
                                }
                            else
                                if((((cliente)jaja.value).img_color==0)&&(((cliente)jaja.value).img_bw==0))
                                {
                                    nodo c = null;
                                   if(((cliente)jaja.value).color.tamaño != 0)
                                       c = ((cliente) jaja.value).color.First;

                                    while (c != null)
                                    {
                                    System.out.println("si entra al vaciado de color");
                                    if(((cliente)jaja.value).color.tamaño>0) {
                                        System.out.println("si ehubo un cambio"+((cliente)jaja.value).color.tamaño);
                                        imagen fc = (imagen) ((cliente) jaja.value).color.popFirst().value;
                                        imp_color.agrega(fc);
                                        c = ((cliente) jaja.value).color.First;
                                        if (c == null) break;
                                    }




                                    }
                                    nodo b = null;
                                    if(((cliente)jaja.value).bn.tamaño != 0)
                                        b = ((cliente) jaja.value).bn.First;

                                    while (b != null)
                                    {
                                    if(((cliente)jaja.value).bn.tamaño>0) {
                                        imagen fa = (imagen) ((cliente) jaja.value).bn.popFirst().value;

                                        imp_bn.agrega(fa);

                                        b = ((cliente) jaja.value).bn.First;
                                        if (b == null) break;
                                    }



                                }
                                    System.out.println("si agrega a saa espera");
                                    sala_espera.agrega(jaja.value);
                                    ventanillas.popEspecificoconreemplazo(jaja);

                                }

                    }
                    jaja = jaja.Next;
                }

                ///////////// despues de hacer resta a cada cliente de ventanilla




                nodo m = ventanillas.First;
                //////Reingreso a cola de entrada
                while (m!=null)
                {
                    if(m.value.getClass() != cola_entrada.First.value.getClass() )
                    {
                        ventanillas.reemplazar(m,cola_entrada.popFirst());
                        cliente nuevo = new cliente(rndm.nextInt(160),(nombre[rndm.nextInt(nombre.length)]+" "+apellido[rndm.nextInt(apellido.length)]),rndm.ints(1,4).findAny().getAsInt(), rndm.ints(1,4).findAny().getAsInt());
                        nuevo.terminardeconstruir();
                        cola_entrada.agrega(nuevo);
                        listatotaldeclientes.agrega(nuevo);
                        break;

                    }
                    m=m.Next;
                }

                //  impresion cola entrada
                System.out.println("\nver cola entrada");
                nodo m2 = cola_entrada.First;
                while (m2 != null)
                {
                    System.out.println(((cliente)m2.value).vercliente());
                    m2 = m2.Next;
                }//IMPRESION DE LA COLA
                System.out.println("ver ventanillas");
                nodo ver = ventanillas.First;
                while (ver != null)
                {
                    if(ver.value.getClass()==cliente.class)
                        System.out.println(((cliente)ver.value).vercliente());
                    else
                    if (ver.value.getClass()==vacio.class)
                        System.out.println(ver.value.getClass());
                    ver = ver.Next;
                }
                //impresion sala espera
                System.out.println("ver sala espera");
                nodo espera = sala_espera.First;
                while (espera != null) {
                    System.out.println(((cliente) espera.value).vercliente());
                    espera = espera.Next;
                }
                //impresion impresora color
                System.out.println("ver impresora color");
                nodo vercolor = imp_color.First;
                while (vercolor != null) {
                    System.out.println(((imagen) vercolor.value).getodo());
                    vercolor = vercolor.Next;
                }
                //impresion impresora blanco y negro
                System.out.println("ver impresora blanco y negro");
                nodo verbn = imp_bn.First;
                while (verbn != null) {
                    System.out.println(((imagen) verbn.value).getodo());
                    verbn = verbn.Next;
                }
            }
            else if(papanoel.equals("2"))
            {
                System.out.println("ver top 5 color" + top5color.tamaño);
                nodo revisiontop = top5color.First;
                for(int u = 0; u<5;u++)
                {

                    if(revisiontop != null) {
                        System.out.println((u + 1) + ": " + ((cliente) revisiontop.value).vercliente());
                        revisiontop = revisiontop.Next;
                    }

                }
            }
            else if(papanoel.equals("3"))
            {
                nodo avance = top5bn.First;
                while (avance.Next != null)
                    avance=avance.Next;
                for(int u = 0; u<5;u++)
                {
                    if(avance != null) {
                        System.out.println((u + 1) + ": " + ((cliente) avance.value).vercliente());
                        avance = avance.Prev;
                    }

                }
            }
            else if(papanoel.equals("4"))
            {
                if(cientemaspasos != null)
                System.out.println("El cliente con mas pasos es "+cientemaspasos.vercliente()+" y se tardo "+cientemaspasos.contadordepasos+" pasos." );
                else System.out.println("Todavia no ha salido nadie joven, venga dentro de un rato");
            }
            else if(papanoel.equals("5"))
            {
                System.out.println("Ingresar el nombre especifico");
                String busca = input.next().toString();
                nodo buscanodo = listatotaldeclientes.First;
                while (buscanodo != null)
                {
                    if(busca.equals(((cliente)buscanodo.value).nombre_cliente)) {
                        System.out.println(((cliente) buscanodo.value).vercliente());
                        break;
                    }
                    buscanodo = buscanodo.Next;

                }
            }
            else if(papanoel.equals("6"))
            {
                System.out.println("ALBERTO JOSUE HERNANDEZ ARMAS 201903553 \nESTRUCTURA DE DATOS FASE 1 ");
            }
            else if (papanoel.equals("8"))
            {
                cola_entrada.drawGraphviz();
            }
            else if (papanoel.equals("9"))
            {
                sala_espera.drawGraphviz();
            }
            else if (papanoel.equals("10"))
            {
                ventanillas.drawGraphviz();
            }
            else System.out.println("Ingrese un numero valido");




        }
    }

}
