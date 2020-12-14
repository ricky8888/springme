package com.ron.producer.controller.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@ToString
public class NewTaskRequest {
    @NotEmpty
    private String name;
    @NotEmpty
    private String content;

}
