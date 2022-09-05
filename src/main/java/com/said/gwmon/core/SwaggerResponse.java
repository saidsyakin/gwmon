package com.said.gwmon.core;

import java.time.ZonedDateTime;

/**
 * Just to generate proper api-docs. Swagger can't dive into generics too deep.
 */
public class SwaggerResponse {
    public String status;
    public String error;
    public String errorMessage;
    public String path;
    public ZonedDateTime timestamp;
}
