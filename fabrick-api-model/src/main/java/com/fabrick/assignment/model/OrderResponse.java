package com.fabrick.assignment.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * Created by massimo.biancalani on 03/10/2018.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderResponse {
    private Status status;
    private List<String> error;
    private Order payload;
}
