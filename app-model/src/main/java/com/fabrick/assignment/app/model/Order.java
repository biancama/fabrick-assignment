package com.fabrick.assignment.app.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Created by massimo.biancalani on 03/10/2018.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Order {
    private String investorId;
    private String companyId;
    private String campaignId;
    @JsonFormat
        (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime orderTimestamp;
    @JsonFormat
        (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime orderSubmissionTimestamp;
    private OrderThreshold orderThreshold;
    private InvestorAccount investorAccount;
    private BigDecimal totalAmount;
    private BigDecimal orderAmount;
    private BigDecimal feeAmount;
    private Currency currency;
    private Channel channel;
    private String description;
    private String item;
}
