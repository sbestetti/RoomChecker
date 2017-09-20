package ie.distilled.bizops.roomchecker.tools;

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.calendar.CalendarScopes;

public class GoogleCredentialGenerator {
	
	/**
	public GoogleCredential getCredential() throws IOException {
		InputStream in = GoogleCredentialGenerator.class.getResourceAsStream("/app_key.json");
		GoogleCredential credential = GoogleCredential.fromStream(in)
				.createScoped(Collections.singleton(CalendarScopes.CALENDAR_READONLY));
	}
	 * @throws IOException 
	 * @throws GeneralSecurityException 
	**/
	
	public static GoogleCredential getCredential() {
		//InputStream in = GoogleCredentialGenerator.class.getResourceAsStream("/app_key.p12");
		GoogleCredential credential;
		try {
			credential = new GoogleCredential.Builder()
					.setTransport(GoogleNetHttpTransport.newTrustedTransport())
					.setJsonFactory(JacksonFactory.getDefaultInstance())
					.setServiceAccountId("aws-room-checker@room-booking-checker.iam.gserviceaccount.com")    //Check this if it fails
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
