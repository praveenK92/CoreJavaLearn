package learn.java8.streamAPI;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.chrono.HijrahDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class MKYong4 {
	private static final String DATE_FORMAT = "yyyy/MM/dd HH:mm:ss";
	private static final DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
	private static final DateTimeFormatter dateFormat8 = DateTimeFormatter.ofPattern(DATE_FORMAT);

	public static void main(String[] args) {
		// p1();
		// p2();
		// p3();
		// p4();
		// p5();
		// p6();
		// p7();
	}

	private static void p7() {
		HijrahDate ramadan = HijrahDate.now().with(ChronoField.DAY_OF_MONTH, 1).with(ChronoField.MONTH_OF_YEAR, 9);
		System.out.println("HijrahDate : " + ramadan);

		// HijrahDate -> LocalDate
		System.out.println("\n--- Ramandan 2016 ---");
		System.out.println("Start : " + LocalDate.from(ramadan));

		// until the end of the month
		System.out.println("End : " + LocalDate.from(ramadan.with(TemporalAdjusters.lastDayOfMonth())));
	}

	private static void p6() {
		LocalDate localDate = LocalDate.now();
		System.out.println(localDate);
		localDate = localDate
				.with(temporal -> temporal.with(ChronoField.MONTH_OF_YEAR, 12).with(ChronoField.DAY_OF_MONTH, 25));
		System.out.println(localDate);
	}

	private static void p5() {
		LocalDate localDate = LocalDate.now();
		System.out.println("current date : " + localDate);

		LocalDate with = localDate.with(TemporalAdjusters.firstDayOfMonth());
		System.out.println("firstDayOfMonth : " + with);

		LocalDate with1 = localDate.with(TemporalAdjusters.lastDayOfMonth());
		System.out.println("lastDayOfMonth : " + with1);

		LocalDate with2 = localDate.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
		System.out.println("next monday : " + with2);

		LocalDate with3 = localDate.with(TemporalAdjusters.firstDayOfNextMonth());
		System.out.println("firstDayOfNextMonth : " + with3);
	}

	private static void p4() {
		Date currentDate = new Date();
		System.out.println("date : " + dateFormat.format(currentDate));

		// convert date to localdatetime
		LocalDateTime localDateTime = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		System.out.println("localDateTime : " + dateFormat8.format(localDateTime));

		// plus one
		localDateTime = localDateTime.plusYears(1).plusMonths(1).plusDays(1);
		localDateTime = localDateTime.plusHours(1).plusMinutes(2).minusMinutes(1).plusSeconds(1);

		// convert LocalDateTime to date
		Date currentDatePlusOneDay = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());

		System.out.println("\nOutput : " + dateFormat.format(currentDatePlusOneDay));
	}

	private static void p3() {
		LocalDateTime oldDate = LocalDateTime.of(1982, Month.AUGUST, 31, 10, 20, 55);
		LocalDateTime newDate = LocalDateTime.of(2016, Month.NOVEMBER, 9, 10, 21, 56);

		System.out.println(oldDate);
		System.out.println(newDate);

		// count between dates
		long years = ChronoUnit.YEARS.between(oldDate, newDate);
		long months = ChronoUnit.MONTHS.between(oldDate, newDate);
		long weeks = ChronoUnit.WEEKS.between(oldDate, newDate);
		long days = ChronoUnit.DAYS.between(oldDate, newDate);
		long hours = ChronoUnit.HOURS.between(oldDate, newDate);
		long minutes = ChronoUnit.MINUTES.between(oldDate, newDate);
		long seconds = ChronoUnit.SECONDS.between(oldDate, newDate);
		long milis = ChronoUnit.MILLIS.between(oldDate, newDate);
		long nano = ChronoUnit.NANOS.between(oldDate, newDate);

		System.out.println("\n--- Total --- ");
		System.out.println(years + " years");
		System.out.println(months + " months");
		System.out.println(weeks + " weeks");
		System.out.println(days + " days");
		System.out.println(hours + " hours");
		System.out.println(minutes + " minutes");
		System.out.println(seconds + " seconds");
		System.out.println(milis + " milis");
		System.out.println(nano + " nano");
	}

	private static void p2() {
		System.out.println("--- Examples --- ");

		Period tenDays = Period.ofDays(10);
		System.out.println(tenDays.getDays()); // 10

		Period oneYearTwoMonthsThreeDays = Period.of(1, 2, 3);
		System.out.println(oneYearTwoMonthsThreeDays.getYears()); // 1
		System.out.println(oneYearTwoMonthsThreeDays.getMonths()); // 2
		System.out.println(oneYearTwoMonthsThreeDays.getDays()); // 3

		System.out.println("\n--- Period.between --- ");
		LocalDate oldDate = LocalDate.of(1982, Month.AUGUST, 31);
		LocalDate newDate = LocalDate.of(2016, Month.NOVEMBER, 9);

		System.out.println(oldDate);
		System.out.println(newDate);

		// check period between dates
		Period period = Period.between(oldDate, newDate);

		System.out.print(period.getYears() + " years,");
		System.out.print(period.getMonths() + " months,");
		System.out.print(period.getDays() + " days");
	}

	private static void p1() {
		// Creating Durations
		System.out.println("--- Examples --- ");

		Duration oneHours = Duration.ofHours(1);
		System.out.println(oneHours.getSeconds() + " seconds");

		Duration oneHours2 = Duration.of(1, ChronoUnit.HOURS);
		System.out.println(oneHours2.getSeconds() + " seconds");

		// Test Duration.between
		System.out.println("\n--- Duration.between --- ");

		LocalDateTime oldDate = LocalDateTime.of(2016, Month.AUGUST, 31, 10, 20, 55);
		LocalDateTime newDate = LocalDateTime.of(2016, Month.NOVEMBER, 9, 10, 21, 56);

		System.out.println(oldDate);
		System.out.println(newDate);

		// count seconds between dates
		Duration duration = Duration.between(oldDate, newDate);

		System.out.println(duration.getSeconds() + " seconds");
	}

}
