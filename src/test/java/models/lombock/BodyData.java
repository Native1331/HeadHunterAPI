/**package models.lombock;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BodyData {
    @JsonProperty("data")
    private tests.lombock.Body Body;
}

**/