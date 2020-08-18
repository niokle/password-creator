package com.klenio.controller;

import com.klenio.domain.InputParametersDictionary;
import com.klenio.domain.InputParametersPassword;
import com.klenio.dto.InputParametersDto;
import com.klenio.mapper.DtoToDomainMapper;
import com.klenio.service.SignsDictionaryService;
import com.klenio.service.PasswordService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1")
public class PasswordController {

    @GetMapping("/pass")
    @ResponseBody
    public String getPassword(@RequestBody InputParametersDto inputParametersDto, DtoToDomainMapper dtoToDomainMapper) {
        SignsDictionaryService signsDictionaryService = new SignsDictionaryService(dtoToDomainMapper.InputParametersDtoToInputParametersDictionary(inputParametersDto));
        PasswordService passwordService = new PasswordService(dtoToDomainMapper.InputParametersDtoToInputParametersPassword(inputParametersDto), signsDictionaryService);
        return passwordService.getPassword();
    }
}
