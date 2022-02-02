package com.mycompany;

import org.hibernate.validator.constraints.NotEmpty;

import io.dropwizard.Configuration;

public class EventsConfiguration extends Configuration {
    // TODO: implement service configuration
    @NotEmpty
    private String dateFormat;

    public String getDateFormat() {
        return dateFormat;
    }
}
