
package com.hevodemo.feignclient.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Datum {

     Integer id;
     String email;
     String firstName;
     String lastName;
     String avatar;

}
