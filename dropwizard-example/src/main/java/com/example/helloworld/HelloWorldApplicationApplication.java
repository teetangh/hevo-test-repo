package com.example.helloworld;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class HelloWorldApplicationApplication extends Application<HelloWorldApplicationConfiguration> {

    public static void main(final String[] args) throws Exception {
        new HelloWorldApplicationApplication().run(args);
    }

    @Override
    public String getName() {
        return "HelloWorldApplication";
    }

    @Override
    public void initialize(final Bootstrap<HelloWorldApplicationConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final HelloWorldApplicationConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
    }

}
