/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.marjoriechimbo2025;

import java.util.Scanner;

/**
 *
 * @author IDC
 */
public class MarjorieChimbo2025 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] temperatura = new double[7];
        boolean salir = false;

        for (int i = 0; i < 7; i++) {
            double monto;
            do {
                System.out.print("Ingrese la temperatura a calcular, el rango debe de ser de (30,50 °c)" + (i + 1) + ": ");
                monto = scanner.nextDouble();
                if (monto < 0) {
                    System.out.println(" La temperatura debe ser un numero positivo. Intente de nuevo..");
                }

            } while (monto < 0);
            temperatura[i] = monto;
        }

        while (!salir) {
            System.out.println("Menu de Opciones:");
            System.out.println("1. Calcular el promedio semanal de la temperatura");
            System.out.println("2. Motrar cuantos dias estuvieron por encima del promedio");
            System.out.println("3. Indicar el dia mas caluroso y el mas frio");
            System.out.println("4. Mostrar la suma de temperaturas de los primeros tres y los ultimos tres dias");
            System.out.println("5. Salir ");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    double total = 0;
                    for (double t : temperatura) {
                        total += t;
                    }
                    System.out.println("Total del promedio de la temperatura de la semana es: " + total+ "°c");
                    break;

                case 2:
                    double promedio = 0;
                    double diferenciaMinima = Math.abs(temperatura[0] - promedio);
                    int diaEncima = 0;
                    for (int i = 1; i < 7; i++) {
                        double diferencia = Math.abs(temperatura[i] - promedio);
                        if (diferencia < diferenciaMinima) {
                            diferenciaMinima = diferencia;
                            diaEncima = i;
                        }
                    }
                    System.out.println("Dia con la temperatura por encima al promedio: Dia " + (diaEncima + 1));
                    break;
                case 3:
                    double temperaturaMax = temperatura[0];
                    double temperaturaMin = temperatura[0];
                    int diaMax = 0;
                    int diaMin = 0;
                    for (int i = 1; i < 7; i++) {
                        if (temperatura[i] > temperaturaMax) {
                            temperaturaMax = temperatura[i];
                            diaMax = i;
                        }
                        if (temperatura[i] < temperaturaMin) {
                            temperaturaMin = temperatura[i];
                            diaMin = i;
                        }
                    }
                    System.out.println("Dia con la temperatura mas altas " + (diaMax + 1)+"°c");
                    System.out.println("Dia con la temperatura mas baja " + (diaMin + 1)+"°c");
                    break;

                case 4:
                    double totalPrimeros3 = temperatura[0] + temperatura[1] + temperatura[2];
                    double totalUltimos3 = temperatura[3] + temperatura[5] + temperatura[6];
                    System.out.println("El total de la temperatura de  los tres primeros dias : " + totalPrimeros3);
                    System.out.println("el total de la temperatura de  los  ultimos Cuatro dias : " + totalUltimos3);
                    break;
                case 5:
                    salir = true;
                    System.out.println("Programa Finalizado.");
                    break;

                default:
                    System.out.println("Opcion invalida. Intente de nuevo.");
            }
        }
    }
}
