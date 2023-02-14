package com.ExBanking.pojos;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {

    private String email;
    private String  phone;
    private String firstname;
    private String lastName;
    private String dateOfBirth;
    private Address adress;


/*
{
"email": "example@email.com",
"phone": "123-456-7890",
"name": "John",
"surname": "Doe",
"dateOfBirth": "1990-01-01",
"address": {
"city": "New York",
"state": "NY",
"country": "USA",
"zipcode": "10001"
}
}
 */


}
