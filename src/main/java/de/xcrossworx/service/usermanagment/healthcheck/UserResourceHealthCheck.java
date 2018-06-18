package de.xcrossworx.service.usermanagment.healthcheck;

import com.codahale.metrics.health.HealthCheck;

public class UserResourceHealthCheck extends HealthCheck {

    private final String template = "TEST";

    @Override
    protected Result check() throws Exception {
        final String saying = String.format(template, "TEST");
        if (!saying.contains("TEST")) {
            return Result.unhealthy("template doesn't include a name");
        }
        return Result.healthy();
    }

}
