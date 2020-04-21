package pageObjects;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import plainOldJavaObjects.User;

public class CommandsAPI {

    private HttpResponse<JsonNode> jsonResponse;

    public HttpResponse<JsonNode> get_API(String url) throws UnirestException {
        jsonResponse = Unirest.get(url)
                .header("accept", "application/json")
                .asJson();
        return jsonResponse;
    }

    public HttpResponse<JsonNode> post_API(String url, User userInfo) throws UnirestException {
        String bodyJson = this.serealiseData(userInfo);
        System.out.println(bodyJson);
        jsonResponse = Unirest.post(url)
                .header("accept", "application/json")
                .header("Content-Type", "application/json; charset=UTF-8")
                .body(bodyJson)
                .asJson();
        return jsonResponse;
    }

    public String serealiseData(User userInfo){
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String jsonInString = gson.toJson(userInfo);
        return  jsonInString;
    }

    public User deserealiseData(String jsonBody){
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        User user = gson.fromJson(jsonBody, User.class);
        return  user;
    }

}
