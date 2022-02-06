package com.mycompany;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.mycompany.auth.ExampleAuthenticator;
import com.mycompany.auth.ExampleAuthorizer;
import com.mycompany.core.DummyEventRepository;
import com.mycompany.core.EventRepository;
import com.mycompany.resources.EventResource;

import org.eclipse.jetty.server.Authentication.User;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

import io.dropwizard.Application;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.AuthValueFactoryProvider;
import io.dropwizard.auth.basic.BasicCredentialAuthFilter;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class EventsApplication extends Application<EventsConfiguration> {

    public static void main(final String[] args) throws Exception {
        new EventsApplication().run(args);
    }

    @Override
    public String getName() {
        return "Events";
    }

    @Override
    public void initialize(final Bootstrap<EventsConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(EventsConfiguration configuration, Environment environment) {
        DateFormat eventDateFormat = new SimpleDateFormat(configuration.getDateFormat());
        environment.getObjectMapper().setDateFormat(eventDateFormat);

        EventRepository repository = new DummyEventRepository();
        EventResource eventResource = new EventResource(repository);
        environment.jersey().register(eventResource);

        // Basic Authentication
        environment.jersey().register(new AuthDynamicFeature(
                new BasicCredentialAuthFilter.Builder<User>()
                        .setAuthenticator(new ExampleAuthenticator())
                        .setAuthorizer(new ExampleAuthorizer())
                        .setRealm("SUPER SECRET STUFF")
                        .buildAuthFilter()));
        environment.jersey().register(RolesAllowedDynamicFeature.class);
        // If you want to use @Auth to inject a custom Principal type into your resource
        environment.jersey().register(new AuthValueFactoryProvider.Binder<>(User.class));
    }

}
