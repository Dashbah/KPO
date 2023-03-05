package Student;

import json.serializator.JsonProperty;
import java.io.Serializable;
import java.util.List;

@JsonProperty
public class Student implements Serializable {
    String name = "Biba";

    @JsonProperty
    String surname = "Boba";

    @JsonProperty
    int age = 19;

    List<Integer> grades;
}
