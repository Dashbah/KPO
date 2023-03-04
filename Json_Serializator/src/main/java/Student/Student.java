package Student;

import json.serializator.JsonProperty;
import java.io.Serializable;
import java.util.List;

@JsonProperty
public class Student implements Serializable {
    String name = "Biba";

    @JsonProperty(name = "SURNAME")
    String surname = "Boba";

    @JsonProperty(name = "AGE")
    int age = 19;

    List<Integer> grades;
}
