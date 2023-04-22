package com.example.student.utils;

import java.sql.Date;

public class DateUtils {
	public static Date convertDate(String date) {
		return Date.valueOf(date);
	}
}
