package com.klenio.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Component
public class InputParametersPassword {
    private String userName;
    private String masterPassword;
    private String appName;
    private String appAddress;
    private int numberOfSigns;
}
