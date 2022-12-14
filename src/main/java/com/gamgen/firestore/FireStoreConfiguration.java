package com.gamgen.firestore;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.IOException;

@Configuration
public class FireStoreConfiguration {

    @Value("${firestore.auth.file}")
    private String firestoreAuthFile;

    @Bean
    public Firestore firestore() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(firestoreAuthFile);
        GoogleCredentials googleCredentials = GoogleCredentials.fromStream(fileInputStream);

        return FirestoreOptions.newBuilder().setCredentials(googleCredentials).build().getService();
    }

}
