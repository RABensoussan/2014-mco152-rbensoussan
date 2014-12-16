package bensoussan.test2;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class DatebookTest {

	/**
	 * 
	 * @param year
	 *            4 digit year
	 * @param month
	 *            Calendar.JANUARY, Calendar.FEBRUARY...
	 * @param dayOfMonth
	 *            starting from 1
	 * @return A Date from the specified parameters
	 */
	private Date getDate(int year, int month, int dayOfMonth) {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(year, month, dayOfMonth, 0, 0, 0);
		return calendar.getTime();
	}

	@Test
	/**
	 * After calling addSingleEvent() verify that the Event is returned when calling getEvents()
	 */
	public void testAddSingleEvent() {
		Datebook datebook = new Datebook();
		
		// given an event
		Event event = new Event("EVENT 1", 1200);
		Date today = getDate(2014, Calendar.NOVEMBER, 25);
		
		// when the event is added today
		datebook.addSingleEvent(event, today);

		// then the event is returned for today
		List<Event> list = datebook.getEvents(today);
		Assert.assertNotNull(list);
		Assert.assertEquals(1, list.size());
		Assert.assertSame(event, list.get(0));

		// then the event is not returned tomorrow
		Date tomorrow = getDate(2014, Calendar.NOVEMBER, 26);
		list = datebook.getEvents(tomorrow);
		Assert.assertNotNull(list);
		Assert.assertTrue(list.isEmpty());
	}

	@Test
	/**
	 * After calling addYearlyEvent() verify that the Event is returned when calling getEvents()
	 */
	public void testAddYearlyEvent() {
		Datebook datebook = new Datebook();
		Event event = new Event("EVENT 1", 1830);
		Date today = getDate(2014, Calendar.NOVEMBER, 25);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(today);
		datebook.addYearlyEvent(event, calendar.get(Calendar.DAY_OF_YEAR));
		Date nextYear = getDate(2022, Calendar.NOVEMBER, 25);
		List<Event> list = datebook.getEvents(nextYear);
		Assert.assertNotNull(list);
		Assert.assertEquals(1, list.size());
		Assert.assertSame(event, list.get(0));
		
	}

	@Test
	/**
	 * After calling addMonthlyEvent() verify that the Event is returned when calling getEvents()
	 */
	public void testAddMonthlyEvent() {
		Datebook datebook = new Datebook();
		Event event = new Event("EVENT 2", 1100);
		Date today = getDate(2014, Calendar.NOVEMBER, 25);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(today);
		datebook.addMonthlyEvent(event, calendar.get(Calendar.DAY_OF_MONTH));
		Date nextMonth = getDate(2015, Calendar.JANUARY, 25);
		List<Event> list = datebook.getEvents(nextMonth);
		Assert.assertNotNull(list);
		Assert.assertEquals(1, list.size());
		Assert.assertSame(event, list.get(0));
	}

	@Test
	/**
	 * After calling addWeeklyEvent() verify that the Event is returned when calling getEvents()
	 */
	public void testAddWeeklyEvent() {
		Datebook datebook = new Datebook();
		Event event = new Event("EVENT 1", 1830);
		Date today = getDate(2014, Calendar.NOVEMBER, 24);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(today);
		datebook.addWeeklyEvent(event, calendar.get(Calendar.DAY_OF_WEEK));
		Date nextWeek = getDate(2014, Calendar.DECEMBER, 1);
		List<Event> list = datebook.getEvents(nextWeek);
		Assert.assertNotNull(list);
		Assert.assertEquals(1, list.size());
		Assert.assertSame(event, list.get(0));
	}

	@Test
	/**
	 * After calling addDailyEvent() verify that the Event is returned when calling getEvents()
	 */
	public void testAddDailyEvent() {
		Datebook datebook = new Datebook();
		Event event = new Event("EVENT 1", 1830);
		Date today = getDate(2014, Calendar.NOVEMBER, 25);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(today);
		datebook.addDailyEvent(event);
		Date tomorrow = getDate(2022, Calendar.NOVEMBER, 26);
		List<Event> list = datebook.getEvents(tomorrow);
		Assert.assertNotNull(list);
		Assert.assertEquals(1, list.size());
		Assert.assertSame(event, list.get(0));
	}

	@Test
	/**
	 * After adding multiple Events, verify that they are all returned from getEvents() in the correct order.
	 */
	public void testGetEventsReturnsSortedList() {
		Datebook datebook = new Datebook();
		Event event = new Event("Event 1", 1200);
		Event event2 = new Event("Event 2", 1300);
		Event event3 = new Event("Event 3", 1400);
		Event event4 = new Event("Event 4", 1500);
		datebook.addDailyEvent(event3);
		datebook.addDailyEvent(event);
		datebook.addDailyEvent(event4);
		datebook.addDailyEvent(event2);
		Date today = getDate(2014, Calendar.NOVEMBER, 25);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(today);
		List<Event> list = datebook.getEvents(today);
		List<Event> listSorted = datebook.getEvents(today);
		Collections.sort(listSorted);
		Assert.assertEquals(listSorted, list);

		
	}

}
