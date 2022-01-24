
package com.hevodemo.feignclient.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Datum {

     Integer id;
     String email;
     String firstName;
     String lastName;
     String avatar;

}
