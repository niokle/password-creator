package com.klenio.controller;

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
        SignsDictionaryService signsDictionaryService = new SignsDictionaryService(dtoToDomainMapper.inputParametersDtoToInputParametersDictionary(inputParametersDto));
        PasswordService passwordService = new PasswordService(dtoToDomainMapper.inputParametersDtoToInputParametersPassword(inputParametersDto), signsDictionaryService);
        return passwordService.getPassword();
    }
}
