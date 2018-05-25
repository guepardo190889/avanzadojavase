package com.blackdeath.amazonviewer.model;

import java.util.Date;

/**
 * @author Seth Luis
 *
 */
public interface IVisualizable {
	Date startToSee(Date dateI);

	void stopToSee(Date dateI, Date dateF);
}
