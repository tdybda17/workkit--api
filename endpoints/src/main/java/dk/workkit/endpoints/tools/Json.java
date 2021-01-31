package dk.workkit.endpoints.tools;
import dk.workkit.endpoints.endpoints.exceptions.ObjectMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.Map;

public class Json {

    public static String to(Object value) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(value);
        } catch (IOException e) {
            throw new ObjectMappingException("Not able to map object into json: " + value.toString());
        }
    }

    public static String simple(String key, String value) {
        Map<String, Object> map = Map.of(key, value);
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(map);
        } catch (IOException e) {
            return "";
        }
    }

    public static String success(String message) {
        return simple("success", message);
    }

    public static String error(String message) {
        return simple("error", message);
    }

}
