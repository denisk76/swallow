package ru.bms.swallow.dto;

import lombok.*;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HelloResponse {
    private String message;
}
