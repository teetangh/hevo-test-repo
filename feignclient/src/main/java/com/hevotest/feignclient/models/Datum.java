
package com.hevotest.feignclient.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Datum {

    private Integer id;
    private String email;
    private String firstName;
    private String lastName;
    private String avatar;

}
