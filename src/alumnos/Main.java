/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package alumnos;

import java.util.Scanner;

/**
 *
 * @author francisco
 */
public class Main
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        JFrameAlumnos ventana = new JFrameAlumnos();
        ventana.setVisible(true);
    }
}


/*
        Scanner teclado = new Scanner(System.in);
        System.out.println("1.- Suma de dos números");
        System.out.println("2.- Multiplicación de dos números");
        System.out.print("Selecciona un opción: ");
        int cesar = teclado.nextInt();

        int a = 0;
        int b = 0;
        switch(cesar)
        {
            case 1:
                System.out.print("Dame el primer número: ");
                a = teclado.nextInt();
                System.out.print("Dame el segundo número: ");
                b = teclado.nextInt();
                int c = a + b;
                System.out.println("Resultado " + c);
                break;

            case 2:
                a = 5;
                b = 7;

                System.out.print(a * b);
                break;
            case 3:
                a = 9;
                b = 8;
                System.out.print(a / b);
                break;
            case 4:
                a = 19;
                b = 81;
                System.out.print(a - b);
                break;

        }

        System.out.println("Fin");

 */