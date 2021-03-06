package bensoussan.test2;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A Datebook holds Events
 * 
 * 
 * You can obtain the day of week, day of month and day of year for a particular
 * Date by using the following code.
 * 
 * 
 * 
 * Date date = ... ; Calendar calendar = Calendar.getInstance();
 * calendar.setTime(date); int dayOf = calendar.get(field);
 * 
 * Where field is one of Calendar.DAY_OF_YEAR, Calendar.DAY_OF_MONTH,
 * Calendar.DAY_OF_WEEK
 * 
 * Refer to the code in DatebookTest on how to construct a Date object.
 * 
 * Refer to documentation on the Calendar class
 * https://docs.oracle.com/javase/7/docs/api/java/util/Calendar.html
 * 
 */

public class Datebook {

	private Map<Date, ArrayList<Event>> singles;
	private ArrayList<Event> daily;
	private Map<Integer, ArrayList<Event>> weekly;
	private Map<Integer, ArrayList<Event>> monthly;
	private Map<Integer, ArrayList<Event>> yearly;

	public Datebook() {
		singles = new HashMap<Date, ArrayList<Event>>();
		daily = new ArrayList<Event>();
		weekly = new HashMap<Integer, ArrayList<Event>>();
		monthly = new HashMap<Integer, ArrayList<Event>>();
		yearly = new HashMap<Integer, ArrayList<Event>>();
	}

	/**
	 * Add a single Event to the Datebook for a particular date. This is a
	 * non-recurring event.
	 * 
	 * @param event
	 * @param date
	 */
	public void addSingleEvent(Event event, Date date) {
		if (!singles.containsKey(date)) {
			singles.put(date, new ArrayList<Event>());
		}
		singles.get(date).add(event);
	}

	/**
	 * Adds an Event to a Datebook that is recurring every day. For instance, a
	 * wake up alarm.
	 */
	public void addDailyEvent(Event event) {
		daily.add(event);
	}

	/**
	 * Adds an Event to the Datebook that is recurring the same day every week.
	 * For instance, a class starts at the same time once a week.
	 * 
	 * @param dayOfWeek
	 *            This is a constant from the Calendar class. (ex.
	 *            Calendar.MONDAY, Calendar.TUESDAY...)
	 * 
	 */
	public void addWeeklyEvent(Event event, int dayOfWeek) {
		if (!weekly.containsKey(dayOfWeek)) {
			weekly.put(dayOfWeek, new ArrayList<Event>());
		}
		weekly.get(dayOfWeek).add(event);
	}

	/**
	 * Adds an Event to the Datebook that is recurring the same day every month.
	 * For instance, you always get paid on the 1st and the 15th of the month.
	 * 
	 * @param dayOfMonth
	 *            this is the day of the month starting with 1
	 */
	public void addMonthlyEvent(Event event, int dayOfMonth) {
		if (!monthly.containsKey(dayOfMonth)) {
			monthly.put(dayOfMonth, new ArrayList<Event>());
		}
		monthly.get(dayOfMonth).add(event);
	}

	/**
	 * Adds an Event to the Datebook that is recurring the same day every year.
	 * For instance, a birthday.
	 * 
	 * @param dayOfYear
	 *            this is the day of the year starting with 1 and ending with
	 *            365
	 */
	public void addYearlyEvent(Event event, int dayOfYear) {
		if (!yearly.containsKey(dayOfYear)) {
			yearly.put(dayOfYear, new ArrayList<Event>());
		}
		yearly.get(dayOfYear).add(event);
	}

	/**
	 * 
	 * @return a List of Events for the specified date. The Events should be
	 *         sorted by their timeOfDay. If no events occur on that day then an
	 *         empty List should be returned.
	 */
	public List<Event> getEvents(Date date) {
		List<Event> events = new ArrayList<Event>();
		if (!daily.isEmpty()) {
			events.addAll(daily);
		}
		if (!singles.isEmpty()) {
			if (singles.containsKey(date)) {
				events.addAll(singles.get(date));
			}
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int week = calendar.get(Calendar.DAY_OF_WEEK);
		if (weekly.containsKey(week)) {
			events.addAll(weekly.get(week));
		}
		int month = calendar.get(Calendar.DAY_OF_MONTH);
		if (monthly.containsKey(month)) {
			events.addAll(monthly.get(month));
		}
		int year = calendar.get(Calendar.DAY_OF_YEAR);
		if (yearly.containsKey(year)) {
			events.addAll(yearly.get(year));
		}
		Collections.sort(events);
		return events;
	}

}
