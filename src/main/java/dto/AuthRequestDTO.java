package dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder

public class AuthRequestDTO {

//    {
//            "username":"string",
//            "password":"string",
//
//    }

    private String username;
    private String password;



}
