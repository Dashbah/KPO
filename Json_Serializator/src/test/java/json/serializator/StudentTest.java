package json.serializator;

import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StudentTest {
    @Test
    void Serialize_NotAllFieldsHaveAnnotation_ReturnsCorrectJson() {
        @JsonProperty
        class SimpleTestObject {
            @JsonProperty
            private final String name = "test";
            @JsonProperty
            private final int age = 20;
            private final String address = "test address";
        }
        SimpleTestObject testObj = new SimpleTestObject();
        JSONObject jsonObject = Serializer.serialize(testObj);
        Assertions.assertEquals("{\"name\":\"test\",\"age\":20}", jsonObject.toString());
    }

    @Test
    void Serialize_NoFieldsHaveAnnotation_ReturnsEmptyJson() {
        @JsonProperty
        class SimpleTestObject {
            private final String name = "test";
            private final int age = 20;
            private final String address = "test address";
        }
        SimpleTestObject testObj = new SimpleTestObject();
        JSONObject jsonObject = Serializer.serialize(testObj);
        Assertions.assertEquals("{}", jsonObject.toString());
    }

    @Test
    void Serialize_AllFieldsHaveAnnotation_ReturnsCorrectJson() {
        @JsonProperty
        class SimpleTestObject {
            @JsonProperty
            private final String name = "test";
            @JsonProperty
            private final int age = 20;
            @JsonProperty
            private final String address = "test address";
        }
        SimpleTestObject testObj = new SimpleTestObject();
        JSONObject jsonObject = Serializer.serialize(testObj);
        Assertions.assertEquals("{\"address\":\"test address\",\"name\":\"test\",\"age\":20}",
                jsonObject.toString());
    }

    @Test
    void Serialize_NullObject_ThrowsNullPointerException() {
        Assertions.assertThrows(NullPointerException.class, () -> Serializer.serialize(null));
    }

    @Test
    void Serialize_ObjectDoesntHaveAnnotation_ThrowsUnsupportedOperationException() {
        String name = "unsupported test";
        Assertions.assertThrows(UnsupportedOperationException.class, () -> Serializer.serialize(name));
    }

    @Test
    void Serialize_ObjectHasNullFieldsToSerialize_ThrowsNullPointerException() {
        @JsonProperty
        class TestObjectWithNull {
            @JsonProperty
            private final int number = 12;
            @JsonProperty
            private final String name = null;
        }
        TestObjectWithNull testObjWithNull = new TestObjectWithNull();
        Assertions.assertThrows(NullPointerException.class, () -> Serializer.serialize(testObjWithNull));
    }
}
