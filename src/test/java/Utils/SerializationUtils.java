package Utils;

import POJOs.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class SerializationUtils {

    public static String serealizeObject(Object objectToSerialize){
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        return  gson.toJson(objectToSerialize);
    }

    public static Object deserealize(String jsonBody, Object objectToDeserialize){
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        Object newObject = gson.fromJson(jsonBody, objectToDeserialize.getClass());
        return  newObject;
    }
}
