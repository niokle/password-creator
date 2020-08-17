package com.klenio.controller;

import com.klenio.domain.InputParameters;
import com.klenio.initial.InitialData;
import com.klenio.service.PasswordService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1")
public class PasswordController {

    @GetMapping("/pass")
    @ResponseBody
    public String getPassword(@RequestBody InputParameters inputParameters) {
        InitialData initialData = new InitialData(inputParameters);
        PasswordService passwordService = new PasswordService(inputParameters, initialData);
        return passwordService.getPassword();
    }
}
