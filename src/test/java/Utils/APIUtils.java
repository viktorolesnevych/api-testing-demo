package Utils;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import POJOs.User;

public class APIUtils {

    private HttpResponse<JsonNode> jsonResponse;

    public HttpResponse<JsonNode> get_API(String url) throws UnirestException {
        jsonResponse = Unirest.get(url)
                .header("accept", "application/json")
                .asJson();
        return jsonResponse;
    }

    public HttpResponse<JsonNode> post_API(String url, User userInfo) throws UnirestException {
        String bodyJson = SerializationUtils.serealizeObject(userInfo);
        System.out.println(bodyJson);
        jsonResponse = Unirest.post(url)
                .header("accept", "application/json")
                .header("Content-Type", "application/json; charset=UTF-8")
                .body(bodyJson)
                .asJson();
        return jsonResponse;
    }

}
