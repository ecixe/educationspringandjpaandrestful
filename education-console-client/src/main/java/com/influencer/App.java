package com.influencer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import java.io.Closeable;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        try(CloseableHttpClient client = HttpClients.createDefault()){
            HttpGet request = new HttpGet("http://localhost:9090/education/teachers");
            HttpResponse response = client.execute(request);
            String responseString = EntityUtils.toString(response.getEntity());
            ObjectMapper mapper = new ObjectMapper();
            JavaTimeModule javaTimeModule = new JavaTimeModule();
            javaTimeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(
                    DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSSS")));
            mapper.registerModule(javaTimeModule);
            ApiResponse responseApi = mapper.readValue(responseString,ApiResponse.class);
            for (Person person : responseApi.getObject()){
                System.out.println(person.getEmail());
            }
//            System.out.println(responseString);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
