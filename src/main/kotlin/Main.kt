import biweekly.Biweekly
import biweekly.ICalendar
import biweekly.component.VEvent
import java.io.File
import java.sql.Date
import java.time.LocalDateTime
import java.time.ZoneOffset

fun main(args: Array<String>) {
    createEvent()
    createEventWithImage()
}

private fun createEvent() {
    val event = VEvent()
    // set start and end dates
    val startDateTime = LocalDateTime.of(2022, 1, 1, 10, 0)
    event.setDateStart(Date.from(startDateTime.toInstant(ZoneOffset.UTC)), true)
    val endDateTime = startDateTime.plusDays(2).plusHours(1).plusMinutes(30)
    event.setDateEnd(Date.from(endDateTime.toInstant(ZoneOffset.UTC)), true)
    // set summary, description and organizer
    event.setSummary("Awesome event")
    event.setDescription("Please join this awesome event")
    event.setOrganizer("organizer@awesome.com")
    // set the HTML content to X-ALT-DESC. We also need to set FMTTYPE parameter to text/html
    event.setExperimentalProperty(
        "X-ALT-DESC",
        "<!doctype html><html><body>" +
                "<h1 style='color:blue'>Awesome event</h1>" +
                "<p>Please join</p></body></html>"
    ).setParameter("FMTTYPE", "text/html")
    // create the iCalendar
    val ical = ICalendar()
    ical.addEvent(event)
    // Print it on the console
    print(Biweekly.write(ical).go())
    // Write to file
    val file = File("awesome-event.ics")
    Biweekly.write(ical).go(file)
}

private fun createEventWithImage() {
    val event = VEvent()
    val startDateTime = LocalDateTime.of(2023, 1, 1, 10, 0)
    event.setDateStart(Date.from(startDateTime.toInstant(ZoneOffset.UTC)), true)
    val endDateTime = startDateTime.plusDays(2).plusHours(1).plusMinutes(30)
    event.setDateEnd(Date.from(endDateTime.toInstant(ZoneOffset.UTC)), true)
    event.setSummary("Awesome event")
    event.setDescription("Please join this awesome event")
    event.setOrganizer("organizer@awesome.com")
    event.setExperimentalProperty(
        "X-ALT-DESC",
        "<!doctype html><html><body>" +
                "<h1 style='color:blue'>Awesome event</h1>" +
                "<p>Please join</p>" +
                "<img src=\"data:image/jpeg;base64,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\" alt=\"\" />" +
                "</body></html>"
    ).setParameter("FMTTYPE", "text/html")
    val ical = ICalendar()
    ical.addEvent(event)
    print(Biweekly.write(ical).go())
    Biweekly.write(ical).go(File("awesome-event-with-image.ics"))
}