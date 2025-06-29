package dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString

public class ContactDTO {

    private String id;
    private String name;
    private String lasrname;
    private String email;
    private String phone;
    private String address;
    private String description;
}
