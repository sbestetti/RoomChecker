package ie.distilled.bizops.roomchecker.tools;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.client.util.DateTime;

import com.google.api.services.calendar.CalendarScopes;
import com.google.api.services.calendar.model.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import javax.inject.Named;

@Named
public class GoogleAPI {

	/** Application name. */
	private static final String APPLICATION_NAME = "Google Calendar API Java Quickstart";

	/** Directory to store user credentials for this application. */
	private static final java.io.File DATA_STORE_DIR = new java.io.File(System.getProperty("user.home"),
			".credentials/calendar-java-quickstart");

	/** Global instance of the {@link FileDataStoreFactory}. */
	private static FileDataStoreFactory DATA_STORE_FACTORY;

	/** Global instance of the JSON factory. */
	private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();

	/** Global instance of the HTTP transport. */
	private static HttpTransport HTTP_TRANSPORT;

	/**
	 * Global instance of the scopes required by this quickstart.
	 *
	 * If modifying these scopes, delete your previously saved credentials at
	 * ~/.credentials/calendar-java-quickstart
	 */
	private static final List<String> SCOPES = Arrays.asList(CalendarScopes.CALENDAR_READONLY);

	static {
		try {
			HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
			DATA_STORE_FACTORY = new FileDataStoreFactory(DATA_STORE_DIR);
		} catch (Throwable t) {
			t.printStackTrace();
			System.exit(1);
		}
	}

	/**
	 * Creates an authorized Credential object.
	 * 
	 * @return an authorized Credential object.
	 * @throws IOException
	 */
	public static Credential authorize() throws IOException {
		// Load client secrets.
		InputStream in = GoogleAPI.class.getResourceAsStream("/client_secret.json");
		GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

		// Build flow and trigger user authorization request.
		GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(HTTP_TRANSPORT, JSON_FACTORY,
				clientSecrets, SCOPES).setDataStoreFactory(DATA_STORE_FACTORY).setAccessType("offline").build();
		Credential credential = new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("user");
		// System.out.println("Credentials saved to " +
		// DATA_STORE_DIR.getAbsolutePath());
		return credential;
	}

	/**
	 * Build and return an authorized Calendar client service.
	 * 
	 * @return an authorized Calendar client service
	 * @throws IOException
	 */
	public static com.google.api.services.calendar.Calendar getCalendarService() throws IOException {
		Credential credential = authorize();
		return new com.google.api.services.calendar.Calendar.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential)
				.setApplicationName(APPLICATION_NAME).build();
	}

	public static List<Event> getItems(String roomToCheck, String dateToCheck) throws IOException {
		
		String room = new String();
		
		switch (roomToCheck) {
			case "brittas":
				room = "distilled.ie_2d3535343537353130@resource.calendar.google.com";
				break;
			case "bull":
				room = "distilled.ie_2d3235333336363236323437@resource.calendar.google.com";
				break;
			case "cape":
				room = "distilled.ie_3735313434313434393930@resource.calendar.google.com";
				break;
			case "carl":
				room = "distilled.ie_2d3137303831303732353833@resource.calendar.google.com";
				break;
			case "conn":
				room = "distilled.ie_2d34313939353135373333@resource.calendar.google.com";
				break;
			case "dingle":
				room = "distilled.ie_2d38313039363136373834@resource.calendar.google.com";
				break;
			case "doolin":
				room = "distilled.ie_2d3236303330373037373238@resource.calendar.google.com";
				break;
			case "glen":
				room = "distilled.ie_2d3537353832373730393238@resource.calendar.google.com";
				break;
			case "kill":
				room = "distilled.ie_3736333330393738393731@resource.calendar.google.com";
				break;
			case "lach":
				room = "distilled.ie_2d3338363732303138323431@resource.calendar.google.com";
				break;
			case "new":
				room = "distilled.ie_2d3238313131333331313136@resource.calendar.google.com";
				break;
			case "liber":
				room = "distilled.ie_2d38353734373831393931@resource.calendar.google.com";
				break;
			case "tramore":
				room = "distilled.ie_2d32333231393139323538@resource.calendar.google.com";
				break;
			case "after":
				room = "distilled.ie_2d34343636383630322d353334@resource.calendar.google.com";
				break;
			case "bdeal":
				room = "distilled.ie_31343531333235322d323639@resource.calendar.google.com";
				break;
			case "bideas":
				room = "distilled.ie_2d3632383532303635323233@resource.calendar.google.com";
				break;
			case "camper":
				room = "distilled.ie_33373739373036312d363134@resource.calendar.google.com";
				break;
			case "cow":
				room = "distilled.ie_3939353638373235313733@resource.calendar.google.com";
				break;
			case "disco":
				room = "distilled.ie_2d35353133363731353836@resource.calendar.google.com";
				break;
			case "little":
				room = "distilled.ie_36363933303438392d373733@resource.calendar.google.com";
				break;
			case "ndeal":
				room = "distilled.ie_33383033313634363934@resource.calendar.google.com";
				break;
			default:
				room = null;
				break;
		}
		// String response = new String();

		// Build a new authorized API client service.
		// Note: Do not confuse this class with the
		// com.google.api.services.calendar.model.Calendar class.
		com.google.api.services.calendar.Calendar service = getCalendarService();

		// List the next 10 events from the primary calendar.
		// DateTime now = new DateTime(System.currentTimeMillis());
		// DateTime start = new DateTime(dateToCheck + "T00:00:00Z");
		// DateTime end = new DateTime(dateToCheck + "T23:59:59Z");
		Events events = service.events().list(room).setMaxResults(10)
				.setTimeMin(new DateTime(dateToCheck + "T00:00:00Z"))
				.setTimeMax(new DateTime(dateToCheck + "T23:59:59Z")).setOrderBy("startTime").setSingleEvents(true)
				.execute();
		return events.getItems();
		// if (items.size() == 0) {
		// response = "No upcoming events found.";
		// } else {
		// for (Event event : items) {
		// DateTime start = event.getStart().getDateTime();
		// if (start == null) {
		// start = event.getStart().getDate();
		// }
		// response += "<br>" + event.getSummary() + "</br>";
		// //System.out.printf("%s (%s)\n", event.getSummary(), start);
		// }
		// }
		// return response;
	}

}
