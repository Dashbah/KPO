package json.serializator;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Serializer {
    public static JSONObject serialize(Object obj) throws NullPointerException{
        if (obj == null) {
            throw new NullPointerException();
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
                    if (Objects.equals(field.getAnnotation(JsonProperty.class).name(), "")) {
                        data.put(field.getName(), value);
                    } else {
                        data.put(field.getAnnotation(JsonProperty.class).name(), value);
                    }
                } catch (IllegalAccessException ignored) {
                }
            }
        }

        return new JSONObject(data);
    }
}