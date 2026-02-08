package com.aayush.lad.hrms.core.result;

import lombok.Getter;

@Getter
public class Result<T> {

    private final int statusCode;
    private final T data;
    private final String error;
    private final boolean success;

    public Result(int statusCode, T data, String error) {
        this.statusCode = statusCode;
        this.data = data;
        this.error = error;
        this.success = statusCode < 400;
    }

    // Success with data
    public Result(int statusCode, T data) {
        this(statusCode, data, null);
    }

    // Success with no data
    public Result(int statusCode) {
        this(statusCode, null, null);
    }

    // Failure
    public Result(int statusCode, String error) {
        this(statusCode, null, error);
    }
}


