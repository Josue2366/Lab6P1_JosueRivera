/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab6p1_josuerivera;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author josue
 */
public class Lab6P1_JosueRivera {
static Scanner str = new Scanner (System.in);//String
static Scanner cs = new Scanner(System.in);//char
static Scanner sc = new Scanner (System.in);// int
static Random random = new Random();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("//////menu//////");
        System.out.println("introduzca su opcion");
        System.out.println("1. conjuntos");
        System.out.println("2. cuantos primos tienes?");
        int opcion = sc.nextInt();
        
        while (opcion < 0 || opcion > 2){
            System.out.println("error, opcion no valida "
                    + "introduzca una de las tresopciones");
            System.out.println("//////menu//////");
            System.out.println("introduzca su opcion");
            System.out.println("1. conjuntos");
            System.out.println("2.cuantos primos tienes? ");
            opcion = sc.nextInt();
        }
        while (opcion >= 1 && opcion <= 2){
            switch (opcion){
                case 1:
                    System.out.println("introduzca el size de SET1");
                    int size1 =sc.nextInt();
                    char set1 [] = new char [size1];
                    set1 = genRandCharArray(size1);
                    System.out.println("introduzca el size de SET2");
                    int size2 =sc.nextInt();
                    char set2 [] = new char [size2];
                    set2 = genRandCharArray(size2);
                    System.out.println("Conjunto ganarado");
                    System.out.println("SET 1");
                    imprimirchar(set1);
                    System.out.println("SET 2");
                    imprimirchar(set2);
                    System.out.println("operaciones");
                    System.out.println("1. interccion");
                    System.out.println("2. Diferencia");
                    int operaciones = sc.nextInt();
                    while (operaciones < 0 || operaciones > 2){
                        System.out.println("error, ingrese un valor "
                                + "valido entre 1 y 2");
                        operaciones = sc.nextInt();
                    }
                    switch (operaciones){
                        case 1:
                            interseccion(set1,set2);
                            imprimirpunt(interseccion(set1, set2));
                            break;
                            
                        case 2:
                            diferencia(set1,set2);
                            imprimirpunt(diferencia(set1,set2));
                            break;
                    }
                    System.out.println("");
                    System.out.println("ok1");
                    break;
                
                case 2:
                    System.out.println("ingrese el size");
                    int size = sc.nextInt();
                    System.out.println("Ingrese el limite inferior");
                    int menor = sc.nextInt();
                    System.out.println("Ingrese el limite superior");
                    int mayor = sc.nextInt();
                    int set [] = new int [size];
                    set = genRandArray(size,menor,mayor);
                    System.out.print("Arreglo generado:");
                    System.out.println(" ");
                    imprimir(set);
                    System.out.println(" ");
                    System.out.println("numero de divisores primos:");
                    System.out.println(" ");
                    int primos [] = new int [size];
                    primos = gettotalprimecount(set);
                    System.out.println(" ");
                    imprimir(primos);
                    System.out.println(" ");
                    System.out.println("ok2");
                    break;
                
            }
            System.out.println("//////menu//////");
            System.out.println("introduzca su opcion");
            System.out.println("1. conjuntos");
            System.out.println("2. Cuantos primos tienes?");
            System.out.println("3. Salir del programa");
            opcion = sc.nextInt();
        }
    }
        // TODO code application logic here
    public static char [] genRandCharArray(int size){
        char temporal [] = new char [size];
        for (int i = 0; i < size; i++){
            temporal [i] = (char) (random.nextInt((73-65)+1)+65);
        }
        return temporal;
    }
    public static void imprimirchar (char [] argumento){
        for (int i = 0; i < argumento.length; i++){
            System.out.print("["+ argumento[i]+"]");
        }
        System.out.println(" ");
    }
    public static char [] interseccion(char [] a,char [] b){
        int cont = 0;
        char temporal [] = new char [a.length];
        for (int y = 0; y < temporal.length; y++){
            temporal [y] = '/';
        }
        for (int i = 0; i < a.length; i++){
            for (int j = 0; j < b.length; j++){
                if (a [i] == b [j]){
                    cont++;
                }
            }
            if ( cont > 0){
                temporal [i] = a[i];
            }
            cont = 0;
        }
        return temporal;
    }
    public static void imprimirpunt (char [] a){
        for (int i = 0; i< a.length; i++){
            if (a [i]== '/'){
                continue;
            }
            else{
                System.out.print("["+a[i]+"]");
            }
        }
    }
    public static char [] diferencia (char [] a, char [] b){
        int cont = 0;
        int contadur = 0;
        int control = 0;
        char temporal [] = new char [a.length + b.length];
        for (int y = 0; y < temporal.length; y++){
            temporal [y] = '/';
        }
        for (int i = 0; i < a.length; i++){
            for (int j = 0; j < b.length; j++){
                if (a [i] == b [j]){
                    control++;
                }
            }
            if ( control == 0){
                temporal[cont] = a[i];
                cont++;
                control =0;
            }else{
                control = 0;
                cont++;
            }
        }
        for (int i = 0; i < b.length; i++){
            for (int j = 0; j < a.length; j++){
                if (b [i] == a [j]){
                    control++;
                }
            }
            if ( control == 0){
                temporal[cont] = b[i];
                cont++;
                control =0;
            }else{
                control = 0;
                cont++;
            }
        }
        for (int i = 0; i< temporal.length; i++){
            for (int j = 0; j < a.length; j++){
                if (temporal [i] == a [j]){
                    contadur++;
                    if (contadur > 1){
                        temporal[j]= '/';
                    }
                }
            }
            contadur = 0;
        }
        for (int i = 0; i< temporal.length; i++){
            for (int j = 0; j < b.length; j++){
                if (temporal [i] == b [j]){
                    contadur++;
                    if (contadur > 1){
                        temporal[j]= '/';
                    }
                }
            }
            contadur = 0;
        }
        
        return temporal;
                
    }
    public static int [] genRandArray (int size, int menor, int mayor){
        int temporal [] = new int [size];
        for (int i = 0; i < size; i++){
            temporal [i] = random.nextInt((mayor - menor)+ 1)+ menor;
        }
        return temporal;
    }
    public static void imprimir (int [] a){
        for (int i = 0; i < a.length; i++){
            System.out.print("["+a [i]+"]");
        }
    }
    public static int [] gettotalprimecount (int []a){
        int temporal [] = new int [a.length];
        for (int i = 0; i < a.length; i++){
            temporal [i] = countprimefactors(a [i]);
        }
        return temporal;
    }
    public static boolean isprime (int x){
        int a = 0;
        boolean primo;
        for (int i = 1; i <= x; i++){
            if (x%i == 0){
                a++;
            }
        }
        if (a == 2){
            primo = true;
        }
        else {
            primo = false;
        }
        return primo;
    }
    public static int countprimefactors (int a){
        int primo = 0;
        boolean esprimo;
        for (int i = 1; i <= a; i++){
            esprimo = isprime(i);
            if (esprimo == true && (a%i == 0))
                primo++;
        }
        return primo;
        
    }
    
}
