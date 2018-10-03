package com.fabrick.assignment.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by massimo.biancalani on 03/10/2018.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountBalanceForm implements Serializable {

    @NotNull
    @Min(1)
    @Max(999999999)
    private Long accountNumber;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @Digits(integer = 9, fraction = 2)
    private String balance;

    @Digits(integer = 9, fraction = 2)
    private String availableBalance;

    private String currency;
}
