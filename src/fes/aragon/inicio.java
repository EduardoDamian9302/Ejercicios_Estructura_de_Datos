/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fes.aragon;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author rostr
 */
public class inicio {

    static int filas;
    static int columnas;
    int filaCelula;
    int columnaCelula;
    int cantidadCelulas;
    static int generaciones;
    static int contadorVecinos = 0;
    static int i;
    static int j;
    static int k;
    static boolean[][] tablero;
    static int columnaX;
    static int filaY;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Escriba la cantidad de filas que desee(Minimo 5)");
        Scanner input = new Scanner(System.in);
        filas = input.nextInt();
        if (filas < 5) {
            System.out.println("Porfavor ingrese un valor mayor a 5");
        }
        filaY=filas-1;
        System.out.println("Escriba la cantidad de columnas que desee(Minimo 5)");
         columnas = input.nextInt();
         columnaX=columnas-1;
        if (columnas < 5) {
            System.out.println("Porfavor ingrese un valor mayor a 5");
        }
        tablero = new boolean[filas][columnas];
        System.out.println("Paso de eleccion celulas vivas");
        System.out.println("Cuantas celulas vivas ingresara?");
        int cantidadCelulas = input.nextInt();
        for (int i = 0; i <= cantidadCelulas; i++) {
            System.out.println("Ingrese coordenada X celula " + i);
            int columnaCelula = input.nextInt();
            System.out.println("Ingrese coordenada Y celula " + i);
            int filaCelula = input.nextInt();
            tablero[filaCelula - 1][columnaCelula - 1] = true;
        }
        System.out.println("Cuantas generaciones quiere Simular?");
        generaciones = input.nextInt();
        for ( k = 0; k < generaciones; k++) {
            imprimir(columnas, filas);
            for (i = 0; i < columnas; i++) {
                for (j = 0; j < filas; j++) {
                    
                    seleccion();
                }

            }
        }
    }

    // TODO code application logic here
    public static void imprimir(int columnas, int filas) {
        System.out.println("Generacion " + k);
        for (int i = 0; i < columnas; i++) {
            for (int j = 0; j < filas; j++) {
                if (tablero[i][j] == true) {
                    System.out.print(" V ");
                }
                if (tablero[i][j] == false) {
                    System.out.print(" M ");
                }
            }
            System.out.println("");
        }
    }

    public static void reglas(int filas) {
        switch (contadorVecinos) {
            case 2:
            case 3:
                if (tablero[i][j] == false && contadorVecinos == 3) {
                    tablero[i][j] = true;
                }
                if(tablero[i][j]==true){
                tablero[i][j] = true;
                }
                break;
            case 0:
            case 1:
                tablero[i][j] = false;
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                tablero[i][j] = false;
                break;
        }
        if (j == filaY) {
            ++i;
            j=0;
        }
        if (i==columnaX){
            i=0;
            ++k;
            imprimir(columnas, filas);
        }
        if(k==generaciones){
            System.exit(0);
        }
        else {
            ++j;
        }
        contadorVecinos = 0;
        seleccion();
    }

    public static void seleccion() {
        if (i==0 && j==0) {
            if (tablero[i + 1][j] == true) {
                contadorVecinos++;
            }
            if (tablero[i][j + 1] == true) {
                contadorVecinos++;
            }
            if (tablero[i + 1][j + 1] == true) {
                contadorVecinos++;
            }
            reglas(filas);
        }
        if (i == 0 && j<filaY && j>0) {
            if (tablero[i][j - 1] == true) {
                contadorVecinos++;
            }
            if (tablero[i][j + 1] == true) {
                contadorVecinos++;
            }
            if (tablero[i + 1][j - 1] == true) {
                contadorVecinos++;
            }
            if (tablero[i + 1][j] == true) {
                contadorVecinos++;
            }
            if (tablero[i + 1][j + 1] == true) {
                contadorVecinos++;
            }
            reglas(filas);
        }
        if (i==0 && j == filaY) {
            if (tablero[i][j - 1] == true) {
                contadorVecinos++;
            }
            if (tablero[i + 1][j - 1] == true) {
                contadorVecinos++;
            }
            if (tablero[i + 1][j] == true) {
                contadorVecinos++;
            }
            reglas(filas);
        }
        if (j == filaY && i<columnaX && i>0) {
            if (tablero[i - 1][j] == true) {
                contadorVecinos++;
            }
            if (tablero[i + 1][j] == true) {
                contadorVecinos++;
            }
            if (tablero[i - 1][j - 1] == true) {
                contadorVecinos++;
            }
            if (tablero[i][j - 1] == true) {
                contadorVecinos++;
            }
            if (tablero[i + 1][j - 1] == true) {
                contadorVecinos++;
            }
            reglas(filas);
        }
        if (j == 0 && i>0 && i<columnaX) {
            if (tablero[i - 1][j] == true) {
                contadorVecinos++;
            }
            if (tablero[i + 1][j] == true) {
                contadorVecinos++;
            }
            if (tablero[i - 1][j + 1] == true) {
                contadorVecinos++;
            }
            if (tablero[i][j + 1] == true) {
                contadorVecinos++;
            }
            if (tablero[i + 1][j + 1] == true) {
                contadorVecinos++;
            }
            reglas(filas);
        }
        if (i==columnaX && j == 0) {
            if (tablero[i - 1][j] == true) {
                contadorVecinos++;
            }
            if (tablero[i - 1][j + 1] == true) {
                contadorVecinos++;
            }
            if (tablero[i][j + 1] == true) {
                contadorVecinos++;
            }
            reglas(filas);
        }
        if (i == columnaX && j>0 && j<filaY) {
            if (tablero[i][j - 1] == true) {
                contadorVecinos++;
            }
            if (tablero[i][j + 1] == true) {
                contadorVecinos++;
            }
            if (tablero[i - 1][j - 1] == true) {
                contadorVecinos++;
            }
            if (tablero[i - 1][j] == true) {
                contadorVecinos++;
            }
            if (tablero[i - 1][j + 1] == true) {
                contadorVecinos++;
            }
            reglas(filas);
        }
        if (i==columnaX && j == filaY) {
            if (tablero[i - 1][j - 1] == true) {
                contadorVecinos++;
            }
            if (tablero[i - 1][j] == true) {
                contadorVecinos++;
            }
            if (tablero[i][j - 1] == true) {
                contadorVecinos++;
            }
            reglas(filas);
        } else {

        if (tablero[i - 1][j - 1] == true) {
                contadorVecinos++;
            }
            if (tablero[i - 1][j] == true) {
                contadorVecinos++;
            }
            if (tablero[i - 1][j + 1] == true) {
                contadorVecinos++;
            }
            if (tablero[i][j - 1] == true) {
                contadorVecinos++;
            }
            if (tablero[i][j + 1] == true) {
                contadorVecinos++;
            }
            if (tablero[i + 1][j - 1] == true) {
                contadorVecinos++;
            }
            if (tablero[i + 1][j] == true) {
                contadorVecinos++;
            }
            if (tablero[i + 1][j + 1] == true) {
                contadorVecinos++;
            }
            reglas(filas);
        }
    }
}
