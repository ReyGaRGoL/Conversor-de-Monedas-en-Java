/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversor.de.monedas;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ReyGaRGoLa
 */
public class ConversorDeMonedas {

	public static void main(String[] args) {
		// TODO code application logic here

		List<Conversion> conversiones = new ArrayList<>();
		Scanner t = new Scanner(System.in);
		Funciones funciones = new Funciones();
		double cantidad = 0;

		try {
			outerLoop: while (true) {
				System.out.println("***********************************************");
				System.out.println("Bienvenido al conversor de monedas =)\n");
				System.out.println("1) Dolar =>> Peso Argentino");
				System.out.println("2) Peso Argentino =>> Dolar");
				System.out.println("3) Dolar =>> Real Brasileño");
				System.out.println("4) Real Brasileño =>> Dolar");
				System.out.println("5) Dolar =>> Peso Colombiano");
				System.out.println("6) Peso Colombiano =>> Dolar");
				System.out.println("7) Dolar =>> Peso Boliviano");
				System.out.println("8) Boliviano =>> Dolar");
				System.out.println("9) Dolar =>> Peso Chileno");
				System.out.println("10) Peso Chileno =>> Dolar");
				System.out.println("11) Mostrar historial de Conversiones");
				System.out.println("12) Salir");

				System.out.println("***********************************************");
				int opcion = t.nextInt();

				switch (opcion) {
				case 1:

					System.out.println("\nIngrese la cantidad de dolares a convertir: ");
					cantidad = t.nextDouble();

					conversiones.add(funciones.convertir(cantidad, "usd", "ars"));

					break;
				case 2:

					System.out.println("\nIngrese la cantidad de Pesos Argentinos a convertir: ");
					cantidad = t.nextDouble();

					conversiones.add(funciones.convertir(cantidad, "ars", "usd"));

					break;
				case 3:

					System.out.println("\nIngrese la cantidad de dolares a convertir: ");
					cantidad = t.nextDouble();

					conversiones.add(funciones.convertir(cantidad, "usd", "brl"));

					break;
				case 4:

					System.out.println("\nIngrese la cantidad de Reales Brasileños a convertir: ");
					cantidad = t.nextDouble();

					conversiones.add(funciones.convertir(cantidad, "brl", "usd"));

					break;
				case 5:
					System.out.println("\nIngrese la cantidad de dolares a convertir: ");
					cantidad = t.nextDouble();

					conversiones.add(funciones.convertir(cantidad, "usd", "cop"));

					break;
				case 6:
					System.out.println("\nIngrese la cantidad de Pesos Colombianos a convertir: ");
					cantidad = t.nextDouble();

					conversiones.add(funciones.convertir(cantidad, "cop", "usd"));

					break;
				case 7:
					System.out.println("\nIngrese la cantidad de dolares a convertir: ");
					cantidad = t.nextDouble();

					conversiones.add(funciones.convertir(cantidad, "usd", "bob"));

					break;
				case 8:
					System.out.println("\nIngrese la cantidad de Pesos Bolivianos a convertir: ");
					cantidad = t.nextDouble();

					conversiones.add(funciones.convertir(cantidad, "bob", "usd"));

					break;
				case 9:
					System.out.println("\nIngrese la cantidad de dolares a convertir: ");
					cantidad = t.nextDouble();

					conversiones.add(funciones.convertir(cantidad, "usd", "clp"));

					break;
				case 10:
					System.out.println("\nIngrese la cantidad de Pesos Chilenos a convertir: ");
					cantidad = t.nextDouble();

					conversiones.add(funciones.convertir(cantidad, "clp", "usd"));

					break;
				case 11:
					funciones.escribirHistorial(conversiones);
					System.out.println("***********************************************");
					System.out.println("\n\n" + conversiones.toString());
					break;
				case 12:

					System.out.println("***********************************************");
					System.out.println("Gracias por usar este aplicativo");
					System.out.println("Codigo realizado por Camilo Sotelo Maya desde Colombia");
					System.out.println("***********************************************");
					break outerLoop;

				}

			}
		} catch (InputMismatchException e) {
			System.out.println("Error: Debes ingresar solo números.");
		}

		funciones.escribirHistorial(conversiones);

	}
}
