package com.said.gwmon.core;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.ZonedDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class APIResponse<T> {

    public static <T> APIResponse<T> apiOk() {
        return new APIResponse<>();
    }

    public static <T> APIResponse<T> apiOk(T result) {
        return new APIResponse<>(result);
    }

    public static <T> APIResponse<T> apiError() {
        return new APIResponse<T>()
                .setStatus(Status.error)
                .setError("Unknown error");
    }

    public enum Status {
        success,
        error
    }

    public APIResponse() {
    }

    public APIResponse(T result) {
        this.result = result;
    }

    private Status status = Status.success;
    private String error;
    private String errorMessage;
    private String path;
    private ZonedDateTime timestamp = ZonedDateTime.now();
    private T result;

    public Status getStatus() {
        return status;
    }

    public APIResponse<T> setStatus(Status status) {
        this.status = status;
        return this;
    }

    public String getError() {
        return error;
    }

    public APIResponse<T> setError(String error) {
        this.error = error;
        return this;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public APIResponse<T> setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }

    public Object getResult() {
        return result;
    }

    public APIResponse<T> setResult(T result) {
        this.result = result;
        return this;
    }

    public String getPath() {
        return path;
    }

    public APIResponse<T> setPath(String path) {
        this.path = path;
        return this;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public APIResponse<T> setTimestamp(ZonedDateTime timestamp) {
        this.timestamp = timestamp;
        return this;
    }
}
