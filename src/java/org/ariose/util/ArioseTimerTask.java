package org.ariose.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;



public class ArioseTimerTask extends TimerTask{
	private static Log log = LogFactory.getLog(ArioseTimerTask.class);

	String bombDateStr;
	CallerInterface caller;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private final static int HOUR = 23;
	private final static int MIN = 59;
	//dd/mm/yyyy
	public static void runme(CallerInterface caller, String date) throws Exception {
		log.warn(caller);
		log.warn(date);
		
		
		ArioseTimerTask att = new ArioseTimerTask();
		att.bombDateStr = date;
		att.caller = caller;
		
		
		Timer timer = new Timer();
		log.warn("Hey will start timer at.."+getCurrentDateAtGivenTime(Calendar.getInstance(), HOUR, MIN));
		timer.schedule(att, getCurrentDateAtGivenTime(Calendar.getInstance(), HOUR, MIN),
				24 * 60 * 60 * 1000);
		
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		Date currentDate = null;
		Date bombDate = null;
		try {
			currentDate = Calendar.getInstance().getTime();
			currentDate.setSeconds(0);
			currentDate.setHours(0);
			currentDate.setMinutes(0);
			
			bombDate = sdf.parse(bombDateStr);
			bombDate.setSeconds(0);
			bombDate.setHours(0);
			bombDate.setMinutes(0);
			
//			log.warn("currentDate.."+currentDate);
//			log.warn("bombDate.."+bombDate);	
			
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		
		int status = currentDate.compareTo(bombDate);
		log.warn("currentDate.compareTo(bombDate)...."+ status);
		if(status>=0){
			log.warn("status > 0 hence stopping senders n receivers..");
			caller.callback();
		}
	}

	
	private static Date getCurrentDateAtGivenTime(Calendar today, int hour, int minutes) {
		//Calendar today = new GregorianCalendar();
		Calendar result = new GregorianCalendar(today.get(Calendar.YEAR), today
				.get(Calendar.MONTH), today.get(Calendar.DATE), hour, minutes);
		return result.getTime();
	}
	
	
}
