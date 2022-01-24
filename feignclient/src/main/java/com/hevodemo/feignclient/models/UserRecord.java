
package com.hevodemo.feignclient.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserRecord {

     Integer page;
     Integer perPage;
     Integer total;
     Integer totalPages;
     List<Datum> data = null;
     Support support;

}
