package com.mjm;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.auth.oauth2.StoredCredential;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.DataStore;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DriveQuickstart {
    private static final String APPLICATION_NAME = "Google Drive API Java Quickstart";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final String TOKENS_DIRECTORY_PATH = "/Users/majunmin/IdeaProjects/exercise/src/main/resources/token/";
    private NetHttpTransport httpTransport;

    /**
     * Global instance of the scopes required by this quickstart.
     * If modifying these scopes, delete your previously saved tokens/ folder.
     */
    private static final List<String> SCOPES = Collections.singletonList(DriveScopes.DRIVE_METADATA_READONLY);
    private static final String CREDENTIALS_FILE_PATH = "credentials/client_secrets.json";
    static FileDataStoreFactory fileDataStoreFactory;
    GoogleClientSecrets clientSecrets;

    /**
     * Creates an authorized Credential object.
     * @param HTTP_TRANSPORT The network HTTP Transport.
     * @return An authorized Credential object.
     * @throws IOException If the credentials.json file cannot be found.
     */
    private static Credential getCredentials(String username, final NetHttpTransport HTTP_TRANSPORT) throws IOException {
        // Load client secrets.
        InputStream in = DriveQuickstart.class.getClassLoader().getResourceAsStream(CREDENTIALS_FILE_PATH);
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));
        java.io.File tokenDirFile = new java.io.File(TOKENS_DIRECTORY_PATH);
        fileDataStoreFactory = new FileDataStoreFactory(tokenDirFile);
        DataStore<StoredCredential> dataStore = fileDataStoreFactory.getDataStore(username);
        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setCredentialDataStore(dataStore)
                .setAccessType("offline") // accessType 为false, refreshToken 不会刷新
                .build();

        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
        // 生成的 token序列化文件
        return new MyAuthorizationCodeInstalledApp(flow, receiver).authorizeAfter("user");
    }

    public static void main(String... args) throws IOException, GeneralSecurityException {
        
//        String[] userNameArr = new String[]{"ali", "alisson", "chamberlain", "cole", "cristiano",
//                "fabinho", "firmino", "gomez", "iniesta", "kane", "keita",
//                "lallana", "lovre", "mane", "mason", "milner", "nic", "origi", "ronaldo", "salah", "sturridge",
//                "tobby", "neymar", "stevie"};

        String[] userNameArr = new String[]{"stevie"};

        for (String userName : Arrays.asList(userNameArr)) {
            // Build a new authorized API client service.
            try {
                final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
                Drive service = new Drive.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(userName, HTTP_TRANSPORT))
                        .setApplicationName(APPLICATION_NAME)
                        .build();

                createFolder(service, "109yFITPsRzyL84EI394ZGmki2D7fvSz1");

                // Print the names and IDs for up to 10 files.
                FileList result = service.files().list()
                        .setPageSize(10)
                        .setFields("nextPageToken, files(id, name)")
                        .execute();
                List<File> files = result.getFiles();

                System.out.println(userName);
                if (files == null || files.isEmpty()) {
                    System.out.println("No files found.");
                } else {
                    System.out.println("Files:");
                    for (File file : files) {
                        System.out.printf("%s (%s)\n", file.getName(), file.getId());
                    }
                }
            } catch (Exception ex){
                System.out.println("account error, userName = " + userName);
                ex.printStackTrace();
            }
        }
    }

    public static void createFolder(Drive service, String parent) throws IOException, InterruptedException {
        String query = "mimeType='application/vnd.google-apps.folder' and name='HelloWorld'";

        FileList fileList = service.files().list()
                .setQ(query)
                .setSpaces("drive")
                .setFields("files(id, name, parents)")
                .setPageToken(null)
                .execute();
        List<File> files;

        File file = new File();
        file.setName("HelloWorld");
        file.setParents(Collections.singletonList(parent));
        file.setPermissionIds(Collections.singletonList("anyoneWithLink"));
        file.setMimeType("application/vnd.google-apps.folder");
        file = service.files().create(file).execute();

        TimeUnit.SECONDS.sleep(5);
    }
}