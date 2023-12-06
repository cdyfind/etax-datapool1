package com.aisino.entity;

import lombok.*;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Records {

    private String id;

    private String brokerName;

    private String fileType;

    private String effectiveDate;

    private String createDate;
}
