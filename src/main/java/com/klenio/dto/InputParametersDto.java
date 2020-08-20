package com.klenio.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Component
public class InputParametersDto {
    private String userName;
    private String masterPassword;
    private String appName;
    private String appAddress;
    private int numberOfSigns;
    private boolean smallLetters;
    private boolean largeLetters;
    private boolean numbers;
    private boolean specialSigns;
}
