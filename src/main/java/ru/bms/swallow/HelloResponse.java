package ru.bms.swallow;

import lombok.*;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HelloResponse {
    private String message;
}
