package com.blackdeath.amazonviewer.model;

import java.util.Date;

/**
 * @author Seth Luis
 *
 */
public interface IVisualizable {

	/**
	 * Este método captura el tiempo exacto de visualización
	 * 
	 * @param dateI
	 *            Es un objeto {@code Date} con el tiempo de inicio exacto
	 * @return Devuelve la fecha y hora captura
	 */
	Date startToSee(Date dateI);

	/**
	 * Este método captura el tiempo exacto de inicio y final de visualización
	 * 
	 * @param dateI
	 *            Es un objeto {@code Date} con el tiempo de inicio exacto
	 * @param dateF
	 *            Es un objeto {@code Date} con el tiempo de final exacto
	 */
	void stopToSee(Date dateI, Date dateF);
}
