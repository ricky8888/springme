package com.ron.handler.model;

import lombok.*;

import java.io.Serializable;

@Builder
@Data
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Task implements Serializable {
    private Long id;
    private String name;
    private String content;
}
