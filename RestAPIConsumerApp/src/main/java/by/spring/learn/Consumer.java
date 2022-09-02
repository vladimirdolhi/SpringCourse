package by.spring.learn;

import by.spring.learn.response.ReqresResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class Consumer {

    public static void main(String[] args) throws JsonProcessingException {

        RestTemplate restTemplate = new RestTemplate();

        String url1 = "https://reqres.in/api/users/2";
        String response1 = restTemplate.getForObject(url1, String.class);
        System.out.println(response1);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode obj = mapper.readTree(response1);
        System.out.println("Data:\n" + "User:\nFirst name:" + obj.get("data").get("first_name") +"\nLast_name:" + obj.get("data").get("last_name")+"\nEmail:" + obj.get("data").get("email"));

        Map<String, String> jsonToSend = new HashMap<>();
        jsonToSend.put("name", "Test name");
        jsonToSend.put("job", "Test job");
        String url2 = "https://reqres.in/api/users";
        HttpEntity<Map<String, String>> request = new HttpEntity<>(jsonToSend);
        String response2 = restTemplate.postForObject(url2, request, String.class);
        System.out.println(response2);

        // with Jackson
        String url3 = "https://reqres.in/api/users/2";
        ReqresResponse reqresResponse = restTemplate.getForObject(url1, ReqresResponse.class);
        System.out.println("Data:\n" + "User:" +
                 "\nFirst name:" + reqresResponse.getData().getFirst_name()
                +"\nLast_name:" + reqresResponse.getData().getLast_name()
                +"\nEmail:" + reqresResponse.getData().getEmail());

    }
}
