package ru.bms.swallow;

import lombok.*;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SimpleResponse {
    private String message;
}
