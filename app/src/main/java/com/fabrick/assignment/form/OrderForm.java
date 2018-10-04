package com.fabrick.assignment.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Created by massimo.biancalani on 03/10/2018.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderForm implements Serializable {

    @NotNull
    private String portalId;

    @NotNull
    private String investorId;
    @NotNull
    private String companyId;
    @NotNull
    private String campaignId;
    @NotNull
    private String iban;

    @NotNull
    private String item;

    @NotNull
    private String description;


    @NotNull
    @Digits(integer = 9, fraction = 2)
    private String totalAmount;

    @NotNull
    @Digits(integer = 9, fraction = 2)
    private String orderAmount;

    @NotNull
    @Pattern(regexp = "OVER_THRESHOLD|UNDER_THRESHOLD")
    private String radioThreshold;
    @NotNull
    @Pattern(regexp = "CARD|MONEYTRANSFER")
    private String radioChannel;


}
