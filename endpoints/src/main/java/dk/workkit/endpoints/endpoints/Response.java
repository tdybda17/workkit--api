package dk.workkit.endpoints.endpoints;
import dk.workkit.endpoints.tools.Json;
import dk.workkit.endpoints.tools.Messages;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Map;


public class Response {
    private HttpStatus status;
    private String json;
    private Map<String, String> headers;

    public Response(HttpStatus status, String json) {
        this.status = status;
        this.json = json;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getJson() {
        return json;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public static Response success(HttpStatus status, String json) {
        return new Response(status, json);
    }

    public static Response error(HttpStatus status, String message) {
        Map<String, Object> map = Map.of(
                "timestamp", LocalDateTime.now().toString(),
                "status", status.value(),
                "message", message,
                "error", status.toString()
        );
        String json = Json.to(map);
        return new Response(status, json);
    }

    public static Response unauthorized() {
        return Response.error(HttpStatus.UNAUTHORIZED, Messages.UNAUTHORIZED.getText());
    }
}
