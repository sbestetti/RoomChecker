package ie.distilled.bizops.roomchecker.tools;

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.services.calendar.CalendarScopes;

public class GoogleCredentialFactory {
	
	public static GoogleCredential getCredential(HttpTransport transport, JsonFactory factory) {
		GoogleCredential credential;
		try {
			credential = new GoogleCredential.Builder()
					.setTransport(transport)
					.setJsonFactory(factory)
					.setServiceAccountId("aws-room-checker@room-booking-checker.iam.gserviceaccount.com")
					.setServiceAccountPrivateKeyFromP12File(new File("src/main/resources/app_key.p12"))
					.setServiceAccountScopes(Collections.singleton(CalendarScopes.CALENDAR))
					.setServiceAccountUser("sergio.bestetti@distilled.ie")
					.build();
			return credential;
		} catch (IOException e) {
			System.out.println("IOException from the credential builder :)");
		} catch (GeneralSecurityException e) {
			System.out.println("SecException from the credential builder :)");
		}
		return null;
	}

}
