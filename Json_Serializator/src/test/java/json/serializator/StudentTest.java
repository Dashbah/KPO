package json.serializator;

import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StudentTest {
    @Test
    void Serialize_NotAllFieldsHaveAnnotation_ReturnsCorrectJson() {
        class SimpleTestObject {
            @JsonProperty(name = "NAME")
            private final String name = "test";
            @JsonProperty(name =  "AGE")
            private final int age = 20;
            private final String address = "test address";
        }
        SimpleTestObject testObj = new SimpleTestObject();
        JSONObject jsonObject = Serializer.serialize(testObj);
        Assertions.assertEquals("{\"NAME\":\"test\",\"AGE\":20}", jsonObject.toString());
    }

    @Test
    void Serialize_NoFieldsHaveAnnotation_ReturnsEmptyJson() {
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
    void Serialize_FieldsDontHaveCustomizedFieldNamesAnnotation_ReturnsCorrectJson() {
        class SimpleTestObject {
            @JsonProperty
            private final String name = "test";
            @JsonProperty(name = "AGE")
            private final int age = 20;
            @JsonProperty
            private final String address = "test address";
        }
        SimpleTestObject testObj = new SimpleTestObject();
        JSONObject jsonObject = Serializer.serialize(testObj);
        Assertions.assertEquals("{\"address\":\"test address\",\"name\":\"test\",\"AGE\":20}",
                jsonObject.toString());
    }

    @Test
    void Serialize_NullObject_ThrowsNullPointerException() {
        Assertions.assertThrows(NullPointerException.class, () -> Serializer.serialize(null));
    }

    @Test
    void Serialize_ObjectHasNullFieldsToSerialize_ThrowsNullPointerException() {
        class TestObjectWithNull {
            @JsonProperty(name = "NUMBER")
            private final int number = 12;
            @JsonProperty(name = "NAME")
            private final String name = null;
        }
        TestObjectWithNull testObjWithNull = new TestObjectWithNull();
        Assertions.assertThrows(NullPointerException.class, () -> Serializer.serialize(testObjWithNull));
    }
}
