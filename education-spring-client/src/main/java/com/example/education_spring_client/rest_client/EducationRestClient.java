package com.example.education_spring_client.rest_client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.util.*;
/**
 * Hello world!
 *
 */
public class EducationRestClient
{
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    public static List<ApiResponse.Person> getTeachersFromApi() {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpGet request = new HttpGet("http://localhost:9090/education/teachers");
            HttpResponse response = client.execute(request);
            String responseString = EntityUtils.toString(response.getEntity());
            JavaTimeModule javaTimeModule = new JavaTimeModule();
            javaTimeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(
                    DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSSS")));
            OBJECT_MAPPER.registerModule(javaTimeModule);

            ApiResponse responseApi = OBJECT_MAPPER.readValue(responseString, ApiResponse.class);
            return responseApi.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

}
