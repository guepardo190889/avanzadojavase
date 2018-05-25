package com.blackdeath.amazonviewer.util;

import java.util.Scanner;

/**
 * @author Seth Luis
 *
 */
public class AmazonUtil {

	public static int validaRespuestaMenu(int minValido, int maxValido) {
		int respuesta = -1;

		Scanner sc = new Scanner(System.in);

		validaEntero(sc);

		respuesta = sc.nextInt();

		// Validar rango de respuesta
		while (respuesta < minValido || respuesta > maxValido) {
			// Solicitar de nuevo la respuesta
			System.out.println("No ingresaste una opción válida. \n Intenta de nuevo");

			validaEntero(sc);

			respuesta = sc.nextInt();
		}

		// System.out.println("Tu Respuesta fue: " + respuesta + "\n");
		return respuesta;
	}

	private static void validaEntero(Scanner sc) {
		while (!sc.hasNextInt()) {
			sc.next();
			System.out.println("No ingresaste una opción válida. \n Intenta de nuevo");
		}
	}
}
