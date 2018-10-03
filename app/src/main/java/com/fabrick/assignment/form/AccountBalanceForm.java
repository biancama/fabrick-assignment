package com.fabrick.assignment.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by massimo.biancalani on 03/10/2018.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountBalanceForm implements Serializable {

    @NotNull
    @Min(1)
    @Max(999999999)
    private Long accountNumber;


    private LocalDate date;

    private String balance;

     private String availableBalance;

    private String currency;
}
