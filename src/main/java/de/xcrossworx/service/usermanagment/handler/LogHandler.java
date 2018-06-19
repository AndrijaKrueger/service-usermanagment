package de.xcrossworx.service.usermanagment.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.xcrossworx.service.usermanagment.model.LogMessage;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;



public class LogHandler {
    private static ObjectMapper mapper = new ObjectMapper();

    public static void logMessage(LogMessage logMessage){
        try{
            HttpClient httpClient = HttpClientBuilder.create().build(); //Use this instead
            HttpPost request = new HttpPost("http://localhost:9001/log-resource");
            request.addHeader("content-type", "application/json");

            StringEntity params =new StringEntity(mapper.writeValueAsString(logMessage));
            request.setEntity(params);

            HttpResponse response = httpClient.execute(request);
        }catch (Exception ex){

        }
    }
}
