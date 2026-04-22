package co.edu.uptc.cqrsquery.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String toJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error converting object to JSON", e);
        }
    }

    public static <T> T fromJson(String json, Class<T> clazz) {
    try {
        // Esto limpia el JSON si llega con comillas dobles al inicio y al final
        if (json != null && json.startsWith("\"") && json.endsWith("\"")) {
            json = json.substring(1, json.length() - 1).replace("\\\"", "\"");
        }
        return objectMapper.readValue(json, clazz);
    } catch (Exception e) {
        throw new RuntimeException("Error convirtiendo JSON: " + json, e);
    }
}
}