package ie.distilled.bizops.roomchecker.tools;

import java.io.IOException;
import java.util.List;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.Events;

public class GoogleAPI {

	/** Application name. */
	private static final String APPLICATION_NAME = "Google Calendar API Java Quickstart";

	/** Global instance of the JSON factory. */
	private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();

	/** Global instance of the HTTP transport. */
	private static HttpTransport HTTP_TRANSPORT;

	static {
		try {
			HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
		} catch (Throwable t) {
			t.printStackTrace();
			System.exit(1);
		}
	}
	
	public static com.google.api.services.calendar.Calendar getCalendarService() throws IOException {
		Credential credential = GoogleCredentialFactory.getCredential(HTTP_TRANSPORT, JSON_FACTORY);
		return new com.google.api.services.calendar.Calendar.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential)
				.setApplicationName(APPLICATION_NAME).build();
	}

	public static List<Event> getEvents(String room, String dateToCheck) {
		// Build a new authorized API client service.
		// Note: Do not confuse this class with the
		// com.google.api.services.calendar.model.Calendar class.
		com.google.api.services.calendar.Calendar service;
		try {
			service = getCalendarService();
			Events events = service.events().list(room).setMaxResults(10)
					.setTimeMin(new DateTime(dateToCheck + "T00:00:00Z"))
					.setTimeMax(new DateTime(dateToCheck + "T23:59:59Z")).setOrderBy("startTime").setSingleEvents(true)
					.execute();
			List<Event> items = events.getItems();
			return items;
		} catch (IOException e) {
			System.out.println("From event list generator:\n" + e.getLocalizedMessage());
		}

		return null;
	}

}
