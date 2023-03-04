package json.serializator;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;

public class Serializator {
    public static JSONObject serialize(Object obj) {
        if (obj == null) {
            throw new NullPointerException();
        }

        if (obj.getClass().getAnnotation(JsonProperty.class) == null) {
            throw new UnsupportedOperationException("Is not a Json Property");
        }

        Map<String, Object> data = new HashMap<String, Object>();

        for (var field : obj.getClass().getDeclaredFields()) {
            if (field.getAnnotation(JsonProperty.class) != null) {
                field.setAccessible(true);
                try {
                    var value = field.get(obj);
                    if (value == null) {
                        throw new NullPointerException(field.getName() + " field is null");
                    }
                    data.put(field.getName(), value);
                } catch (IllegalAccessException ignored) {
                }
            }
        }

        return new JSONObject(data);
    }
}