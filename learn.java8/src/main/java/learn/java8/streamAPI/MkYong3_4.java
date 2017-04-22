package learn.java8.streamAPI;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MkYong3_4 {

	public static void main(String[] args) {
		//p1();
		//p2();
		//p3();
		//p4();
        //p5();
		//p6();
		//p7();

    }

	private static void p7() {
		Map<String, String> sortedMap = new LinkedHashMap<>();

        List<String> zoneList = new ArrayList<>(ZoneId.getAvailableZoneIds());
        System.out.println(zoneList);
        //Get all ZoneIds
        Map<String, String> allZoneIds = getAllZoneIds(zoneList);

        //sort map by key
        //sort by value, descending order
        allZoneIds.entrySet().stream()
                .sorted(Map.Entry.<String, String>comparingByValue().reversed())
                .forEachOrdered(e -> sortedMap.put(e.getKey(), e.getValue()));

        // print map
        sortedMap.forEach((k, v) ->
        {
            String out = String.format("%35s (UTC%s) %n", k, v);
            System.out.printf(out);
        });

		System.out.println("\nTotal Zone IDs " + sortedMap.size());
	}

    private static Map<String, String> getAllZoneIds(List<String> zoneList) {

        Map<String, String> result = new HashMap<>();

        LocalDateTime dt = LocalDateTime.now();

        for (String zoneId : zoneList) {

            ZoneId zone = ZoneId.of(zoneId);
            ZonedDateTime zdt = dt.atZone(zone);
            ZoneOffset zos = zdt.getOffset();

            //replace Z to +00:00
            String offset = zos.getId().replaceAll("Z", "+00:00");

            result.put(zone.toString(), offset);

        }

        return result;

    }

	private static void p6() {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("HHmm, dd MMM yyyy");
        //Convert String to LocalDateTime
        String date = "2016-08-22 14:30";
        LocalDateTime ldt = LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        System.out.println("LocalDateTime : " + format.format(ldt));
        //Paris, 2016 Apr-Oct = DST, UTC+2, other months UTC+1
        //UTC+2
        ZonedDateTime parisDateTime = ldt.atZone(ZoneId.of("Europe/Paris"));
        System.out.println("Depart : " + format.format(parisDateTime));
        //hard code a zoneoffset like this, UTC-5
        ZoneOffset nyOffSet = ZoneOffset.of("-05:00");
        ZonedDateTime nyDateTime = parisDateTime.withZoneSameInstant(nyOffSet).plusHours(8).plusMinutes(10);
        System.out.println("Arrive : " + format.format(nyDateTime));

        System.out.println("\n---Detail---");
        System.out.println("Depart : " + parisDateTime);
        System.out.println("Arrive : " + nyDateTime.toString());
	}

	private static void p5() {
		ZoneId defaultZoneId = ZoneId.systemDefault();
        System.out.println("System Default TimeZone : " + defaultZoneId);

        //toString() append +8 automatically.
        Date date = new Date();
        System.out.println("date : " + date.toString());

        //1. Convert Date -> Instant
        Instant instant = date.toInstant();
        System.out.println("instant : " + instant); //Zone : UTC+0

        //2. Instant + system default time zone + toLocalDate() = LocalDate
        LocalDate localDate = instant.atZone(defaultZoneId).toLocalDate();
        System.out.println("localDate : " + localDate);

        //3. Instant + system default time zone + toLocalDateTime() = LocalDateTime
        LocalDateTime localDateTime = instant.atZone(defaultZoneId).toLocalDateTime();
        System.out.println("localDateTime : " + localDateTime);

        //4. Instant + system default time zone = ZonedDateTime
        ZonedDateTime zonedDateTime = instant.atZone(defaultZoneId);
        System.out.println("zonedDateTime : " + zonedDateTime);
	}

	private static void p4() {
		LocalDateTime dateTime = LocalDateTime.of(2016, Month.AUGUST, 18, 6, 17, 10);
        System.out.println("LocalDateTime : " + dateTime);
        // Convert LocalDateTime to Instant, UTC+0
        Instant instant = dateTime.toInstant(ZoneOffset.UTC);
        System.out.println("Instant : " + instant);
	}

	private static void p3() {
		String dateInString = "2016-08-16T15:23:01Z";
        Instant instant = Instant.parse(dateInString);
        System.out.println("Instant : " + instant);
        //get date time only
        LocalDateTime result = LocalDateTime.ofInstant(instant, ZoneId.of(ZoneOffset.UTC.getId()));
        //get localdate
        System.out.println("LocalDate : " + result.toLocalDate());
        //get date time + timezone
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.of("Asia/Tokyo"));
        System.out.println(zonedDateTime);
        //get date time + timezone
        ZonedDateTime zonedDateTime2 = instant.atZone(ZoneId.of("Europe/Athens"));
        System.out.println(zonedDateTime2);
	}

	private static void p2() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, MMM d yyyy");
		String date = "Tue, Aug 16 2016";
		LocalDate localDate = LocalDate.parse(date, formatter);
		System.out.println(localDate);
		System.out.println(formatter.format(localDate));
	}

	private static void p1() {
		DateTimeFormatter sdf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date1 = LocalDate.of(2009, 12, 31);
		LocalDate date2 = LocalDate.of(2010, 01, 31);

		System.out.println("date1 : " + sdf.format(date1));
		System.out.println("date2 : " + sdf.format(date2));

		System.out.println("Is...");
		if (date1.isAfter(date2)) {
			System.out.println("Date1 is after Date2");
		}

		if (date1.isBefore(date2)) {
			System.out.println("Date1 is before Date2");
		}

		if (date1.isEqual(date2)) {
			System.out.println("Date1 is equal Date2");
		}

		System.out.println("CompareTo...");
		if (date1.compareTo(date2) > 0) {
			System.out.println("Date1 is after Date2");
		} else if (date1.compareTo(date2) < 0) {
			System.out.println("Date1 is before Date2");
		} else if (date1.compareTo(date2) == 0) {
			System.out.println("Date1 is equal to Date2");
		} else {
			System.out.println("How to get here?");
		}
	}
}