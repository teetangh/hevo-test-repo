package com.mycompany.api;

// {
//     "id": 1,
//     "name": "Czech National Symphony Orchestra - I. Concert",
//     "description": "PERFORMERS: Libor Pešek - conductor, Natalie Clein - violoncello",
//     "location": "náměstí Republiky 5, Praha 1 - Staré Město, 110 00",
//     "date": "2016-10-25T19:30+0200"
// },

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Setter
@NoArgsConstructor

public class Event {
    private long id;
    private String name;
    private String description;
    private String location;
    private Date date;

}