package com.example.affablebeanbackend.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class ApiError {
    private int status;
    private String message;
    private String developerMessage;
}
