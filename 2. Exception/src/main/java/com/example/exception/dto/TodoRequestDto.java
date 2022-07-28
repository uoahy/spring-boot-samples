package com.example.exception.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class TodoRequestDto {

    @NotBlank(message = "Title must not be blank")
    private String title;

}
