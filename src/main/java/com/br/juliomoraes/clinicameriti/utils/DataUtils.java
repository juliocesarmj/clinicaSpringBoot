package com.br.juliomoraes.clinicameriti.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public abstract class DataUtils {

	public static String dataToString(final Date data) {

		final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(data);
	}

	public static String dataToStringPtBr(final Date data) {

		final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(data);
	}

	public static Date stringToDate(final String data) {

		final int year = Integer.parseInt(data.substring(0, 4));
		final int month = Integer.parseInt(data.substring(5, 7));
		final int day = Integer.parseInt(data.substring(8, 10));

		final Calendar cal = new GregorianCalendar(year, month - 1, day);
		return cal.getTime();
	}

	public static Date stringPtBrToDate(final String data) {

		final int year = Integer.parseInt(data.substring(6, 10));
		final int month = Integer.parseInt(data.substring(3, 5));
		final int day = Integer.parseInt(data.substring(0, 2));

		final Calendar cal = new GregorianCalendar(year, month - 1, day);
		return cal.getTime();
	}
}
