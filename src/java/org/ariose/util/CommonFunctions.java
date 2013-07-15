/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ariose.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
//import org.ariose.charging.uninor.StatusInfo;

/**
 * 
 * @author Sukhdeep
 */
public class CommonFunctions {

	private static Log log = LogFactory.getLog(CommonFunctions.class);
	private static final Object CONFIG_ERROR = "1";
	private static final Object CONTENT_NOT_PRESENT = "2";

	/*
	 * This method returns current Date and Time
	 */
	public static String getCurrentDateForFile() {
		Calendar currentDate = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yy_HH-mm-ss");
		String dateNow = formatter.format(currentDate.getTime());
		// log.info("Today the date is :=>  " + dateNow);
		return dateNow;
	}

	public static String getCurrentDate() {
		Calendar currentDate = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateNow = formatter.format(currentDate.getTime());
		// log.info("Today the date is :=>  " + dateNow);
		return dateNow;
	}

	static SimpleDateFormat onlyDateFormatter = new SimpleDateFormat(
			"yyyy-MM-dd");

	public static String getJustDateAndNotTime(Date date) {
		String dateNow = onlyDateFormatter.format(date.getTime());
		return dateNow;
	}

	public static String getCurrentDateOnly() {
		Calendar currentDate = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		String dateNow = formatter.format(currentDate.getTime());
		// log.info("Today the date is :=>  " + dateNow);
		dateNow = dateNow.replaceAll("/", "-");
		return dateNow;
	}

	public static String getLoginTime() {
		Calendar currentDate = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat(
				"dd/MM/yyyy hh:mm:ss a");
		String dateNow = formatter.format(currentDate.getTime());
		return dateNow;

	}

	/*
	 * This method returns Advance Date with given number of days added to
	 * current
	 */
	public static String getAdvanceDate(int days) {
		Date now = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		calendar.add(Calendar.DATE, days);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String dateNow = formatter.format(calendar.getTime());
		log.info("Date After +" + days + " ----> " + dateNow);
		return dateNow;
	}

	public int parseIntValue(String j) throws Exception {
		int i = Integer.parseInt(j);
		return i;
	}

	public static boolean validateMobileNumber(String j) throws Exception {
		if (j.length() < 10) {
			return true;
		} else {
			return false;
		}
	}

	public static int getCurrentDay() {
		Calendar cal = Calendar.getInstance();
		int dow = cal.get(Calendar.DAY_OF_WEEK);
		return dow;
	}

	public static int getCurrentHour() {
		Calendar cal = Calendar.getInstance();
		int hour24 = cal.get(Calendar.HOUR_OF_DAY);
		return hour24;

	}

	public static String getNextChargingDay(int[] day) {
		int dow = getCurrentDay();

		int startDay, flag = 0, NUM_DAYS_IN_WEEK = 7, selectedDay = 0;
		int loop = 0;
		boolean daySelected = false;
		Calendar cal = Calendar.getInstance();
		log.info("Day of Week: " + dow);

		// Step 1. Select the next day. If current day is end of the week
		// then next day starts from the first day of week that is 1.
		if ((dow % 7) == 0) {
			startDay = 1;
		} else {
			// start the loop from the next day to the end of week.
			startDay = dow + 1;
		}

		try {
			for (loop = startDay; loop <= NUM_DAYS_IN_WEEK; loop++) {

				// If day is marked selected then break
				if (1 == day[loop]) {
					daySelected = true;
					selectedDay = loop;
					break;
				}
			}

		} catch (ArrayIndexOutOfBoundsException e) {
		}

		// if no day was selected and we started from any other day than the
		// start of the week
		// then check for days before this day
		if (false == daySelected) {

			// Set startDay to start of the week;
			startDay = 1;

			for (loop = startDay; loop <= dow; loop++) {
				// If day is marked selected then break
				if (1 == day[loop]) {
					daySelected = true;
					selectedDay = loop;
					break;
				}
			}
		}

		if (false == daySelected) {
			// No charging day could be selected then return 0
			// This case will not happen.
		}

		// Determine the number of grace days that we are using\
		int numDays = 0;
		if (selectedDay > dow) {
			numDays = selectedDay - dow;
		} else {
			numDays = NUM_DAYS_IN_WEEK - dow;
			numDays += (selectedDay);
		}

		// numDays is the number of grace days to be subsctraced from the quota
		// if remaining grace days is less than numDays then move user to
		// DEACTIVATE
		// else reduce grece days. Set charging date as current Date + numDays.

		log.info("numDays ---> " + numDays);
		// return numDays;
		return numDays + "," + selectedDay;
	}

	public static String getAdvanceDateWithMorningTime(int days) {
		String nextDate = getAdvanceDate(days);
		nextDate = nextDate.substring(0, 10) + " 00:01:01";
		return nextDate;
	}

	public static void sendPostRequest(String urlString, String data)
			throws Exception {
		log.info("Sending request to url.." + urlString + ", with data.."
				+ data);
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		OutputStreamWriter writer = null;
		try {
			URL url = new URL(urlString);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setRequestMethod("POST");
			writer = new OutputStreamWriter(conn.getOutputStream());

			// write parameters
			writer.write(data);
			writer.flush();

			/*
			 * get content from connection
			 */

			is = conn.getInputStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			StringBuffer sbData = new StringBuffer();
			while ((data = br.readLine()) != null) {
				sbData.append(data);
			}
			// log.info("Response received.."+sbData.toString());
		} catch (Exception e) {
			log.error(e.getMessage(), e.fillInStackTrace());
			throw e;
		} finally {
			try {
				if (is != null) {
					is.close();
				}
				if (isr != null) {
					isr.close();
				}
				if (br != null) {
					br.close();
				}
				if (writer != null) {
					writer.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

	public static String[] splitSMS(String data) {
		log.info("..data.length().." + data.length());
		String[] dataArray = null;
		int noOfSplits = 0;
		int reminder = 0;
		try {
			if (data.length() > GmlcConstants.SMSSize) {
				noOfSplits = data.length() / GmlcConstants.SMSSize;
				reminder = data.length() % GmlcConstants.SMSSize;
				if (reminder > 0) {
					noOfSplits += 1;
				}
				dataArray = new String[noOfSplits];
				int startIndex = 0;
				for (int i = 0; i < noOfSplits; i++) {
					if (i == (noOfSplits - 1)) {
						dataArray[i] = data.substring(startIndex);
					} else {
						dataArray[i] = data.substring(startIndex, startIndex
								+ GmlcConstants.SMSSize);
					}
					startIndex += dataArray[i].length();
				}
			} else {
				dataArray = new String[] { data };
			}

		} catch (Exception e) {
			log.error(e.getMessage(), e.fillInStackTrace());
		}

		log.info("dataArray.length.." + dataArray.length);
		for (int i = 0; i < dataArray.length; i++) {
			log.info("..data.." + i + "..is.." + dataArray[i]);
		}

		return dataArray;
	}

	public static void checkNull(String name, String value)
			throws ApplicationException {
		if (value == null || value.trim().equals("")) {
			throw new ApplicationException(name + " is NULL!");
		}
	}

	public static String[] getStartDateAndEndDateOfAWeek(Date date,
			String format) throws Exception {
		SimpleDateFormat sf = new SimpleDateFormat(format);
		String seDate[] = new String[2];
		Calendar c = Calendar.getInstance();
		if (date != null) {
			c.setTime(date);
			int WEEK_FIRST_DAY = c.getFirstDayOfWeek();
			if (WEEK_FIRST_DAY < c.get(Calendar.DAY_OF_WEEK)) {
				c.add(Calendar.DATE,
						-(c.get(Calendar.DAY_OF_WEEK) - WEEK_FIRST_DAY));
			} else if (WEEK_FIRST_DAY > c.get(Calendar.DAY_OF_WEEK)) {
				c.add(Calendar.DATE,
						-(c.get(Calendar.DAY_OF_WEEK) + (7 - WEEK_FIRST_DAY)));
			}
			seDate[0] = sf.format(c.getTime());
			c.add(Calendar.DATE, 6);
			seDate[1] = sf.format(c.getTime());
		}
		return seDate;
	}

	public static String getFirstDayOfMonth(Date date, String format)
			throws Exception {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		Date dddd = calendar.getTime();
		SimpleDateFormat sdf1 = new SimpleDateFormat(format);
		return sdf1.format(dddd);
	}

	public static String getLastDayOfMonth(Date date, String format)
			throws Exception {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH,
				calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		Date dddd = calendar.getTime();
		SimpleDateFormat sdf1 = new SimpleDateFormat(format);
		return sdf1.format(dddd);

	}

	/**
	 * 
	 * @param date
	 * @param format
	 * @return date in formatted string
	 */
	public static String getFormattedDate(Date date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	public static String sendPostRequest(String urlString) {
		StringBuffer sbData = new StringBuffer();
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {

			URL url = new URL(urlString);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			log.info("Connecting to URL [" + urlString + "]");
			conn.connect();
			log.info("done");

			/*
			 * get content from connection
			 */

			is = conn.getInputStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);

			String responsedata = null;
			while ((responsedata = br.readLine()) != null) {
				sbData.append(responsedata);
			}

			log.info("Response [" + sbData.toString() + "]");

			return sbData.toString();

		} catch (Exception e) {
			log.error(e.fillInStackTrace());
		} finally {
			try {
				is.close();
				isr.close();
				br.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

		return "35";
	}

	// parsing request parameters
	public static Map<String, String> parseRequest(Map reqParamMap) {
		Map<String, String> map = new HashMap<String, String>();
		Map params = reqParamMap;
		Set set = params.entrySet();
		Iterator iter = set.iterator();
		while (iter.hasNext()) {
			Entry n = (Entry) iter.next();// String[]
			log.info("Parameter MAP VALUESSSSS::::" + n.getKey().toString()
					+ "," + ((String[]) n.getValue())[0]);
			map.put(n.getKey().toString(), ((String[]) n.getValue())[0]);
		}
		return map;
	}

	public static Date getFormattedStringDate(String date, String format) {
		Date date1 = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			date1 = sdf.parse(date);
		} catch (Exception e) {
		}
		return date1;
	}

	public static String convert(SimpleDateFormat inputFormat,
			SimpleDateFormat outputFormat, String subscriptionCreationDate)
			throws Exception {
		log.info("input date " + subscriptionCreationDate);
		String outputDate = outputFormat.format(inputFormat
				.parse(subscriptionCreationDate));
		log.info("output date " + outputDate);
		return outputDate;
	}

	public static String getCurrentTime(SimpleDateFormat outputFormat) {
		return outputFormat.format(Calendar.getInstance().getTime());
	}

	public static String sendRequestToGateway(String strURL) throws Exception {

		String response = "000";

		// Prepare HTTP get
		GetMethod get = null;
		try {
			log.info("calling GetMethod.." + strURL);
			strURL = strURL.replace(" ", "%20");
			get = new GetMethod(strURL);
			log.info("called GetMethod..");
			log.info("setting request header..");
			get.setRequestHeader("Content-type",
					"text/html; charset=ISO-8859-1");

			// Get HTTP client
			log.info("creating http client..");
			HttpClient httpclient = new HttpClient();

			// Execute request

			log.info("executing http client..");
			int result = httpclient.executeMethod(get);
			response = result + get.getResponseBodyAsString();
		} catch (Exception e) {
			log.error(e.fillInStackTrace());
			throw e;
		} finally {
			// Release current connection to the connection pool
			// once you are done
			if (get != null) {
				get.releaseConnection();
			}
		}

		return response;
	}

	public static String getFormatedTime(int time) {
		String timeString = "00";
		if (String.valueOf(time).length() == 1) {
			timeString = "0" + String.valueOf(time);
		} else {
			timeString = String.valueOf(time);
		}
		return timeString + ":00:00";
	}

	public static String sendPostRequestToCMS(String urlString) {
		StringBuffer sbData = new StringBuffer();
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		String message = "";
		try {

			URL url = new URL(urlString);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			log.info("connecting to url:" + urlString);
			conn.connect();
			log.info("done");

			/*
			 * get content from connection
			 */

			is = conn.getInputStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);

			String responsedata = null;
			while ((responsedata = br.readLine()) != null) {
				sbData.append(responsedata);
			}

			log.info("http response -" + sbData.toString());

			if (sbData.toString().trim().equals("")) {
				message = "Error - Content received is empty.";

			} else if (sbData.toString().trim().equals(CONFIG_ERROR)) {
				message = "Configuration Error.";
			} else if (sbData.toString().trim().equals(CONTENT_NOT_PRESENT)) {
				message = "Content not available for this service.";
			} else {
				message = "Content is available for this service.";
			}

		} catch (Exception e) {
			log.error(e.fillInStackTrace());
		} finally {
			try {
				is.close();
				isr.close();
				br.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return message;
	}

	static SimpleDateFormat formatter = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	public static String addDaysInDate(int days) {
		Calendar currentDate = Calendar.getInstance();
		currentDate.add(Calendar.DATE, days);
		String dateNow = formatter.format(currentDate.getTime());
		// log.info("Today the date is :=>  " + dateNow);
		return dateNow;
	}

	public static String getPrerenewalDate(int days, String renewalDateStr) {
		// days will be -3,-2,-1
		try {
			Date renewalDate = formatter.parse(renewalDateStr);
			Calendar c = Calendar.getInstance();
			c.setTime(renewalDate);
			c.set(Calendar.HOUR_OF_DAY, 8);
			c.set(Calendar.MINUTE, 0);
			c.set(Calendar.SECOND, 0);

			c.add(Calendar.DATE, days);
			String dateNow = formatter.format(c.getTime());
			return dateNow;
		} catch (Exception e) {
			log.error(e);
		}

		return null;
	}

	public static String activatingUrl(String strURL)
			throws Exception {
		log.info("REQUEST ["+strURL+"]");
		strURL = strURL.replace(" ", "%20");
		GetMethod get = null;
		try {

			get = new GetMethod(strURL);
			get.setRequestHeader("Content-type", "text/xml; charset=ISO-8859-1");
			HttpClient httpclient = new HttpClient();
			int responseCode = httpclient.executeMethod(get);
			if(responseCode!=200){
				throw new Exception();
			}
			
			String response = get.getResponseBodyAsString();
			log.info("RESPONSE ["+response+"]");
			return response;
		} catch (Exception e) {
			throw e;
		} finally {
			// Release current connection to the connection pool
			// once you are done
			if (get != null)
				get.releaseConnection();
		}
	}

}
