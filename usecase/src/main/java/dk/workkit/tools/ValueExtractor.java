package dk.workkit.tools;

import java.util.Map;

public class ValueExtractor {

    public static String getStringOrDefault(Map<String, Object> map, String key) {
        return getStringOrDefault(map, key, null);
    }

    public static String getStringOrDefault(Map<String, Object> map, String key, String defaultValue) {
        var value = map.getOrDefault(key, defaultValue);
        return value == null ? null : value.toString();
    }

}
