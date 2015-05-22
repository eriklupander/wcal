package se.lu.wcal.factory;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

import se.lu.wcal.dto.WeatherType;
import biweekly.Biweekly;
import biweekly.ICalendar;
import biweekly.component.VEvent;
import biweekly.property.DateStart;
import biweekly.property.Summary;
import biweekly.util.Duration;

/**
 * Created by eriklupander on 2015-05-19.
 */
public class ICalFactory {

    public static String buildSingle(LocalDateTime date, float temperature, WeatherType weatherType, Integer windSpeed) {
        ICalendar ical = new ICalendar();

        VEvent event = new VEvent();

        Summary summary = event.setSummary(temperature + " C, " + weatherType + ". " + windSpeed + " m/s");
        summary.setLanguage("sv-se");

        Date start = Date.from(date.toInstant(ZoneOffset.UTC));
        event.setDateStart(new DateStart(start, false));
        event.setDuration(new Duration.Builder().minutes(10).build());


       // Recurrence recur = new Recurrence.Builder(Recurrence.Frequency.YEARLY).build();
      //  event.setRecurrenceRule(recur);

        ical.addEvent(event);
        return Biweekly.write(ical).go();
    }
}
