package ru.bms.swallow.dto;

import lombok.*;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SimpleResponse {
    private String message;
}
