package com.klenio.controller;

import com.klenio.dto.InputParametersDto;
import com.klenio.exception.EmptyDictionaryException;
import com.klenio.mapper.DtoToDomainMapper;
import com.klenio.service.SignsDictionaryService;
import com.klenio.service.PasswordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1")
public class PasswordController {
    Logger logger = LoggerFactory.getLogger(PasswordController.class);

    @PostMapping("/pass")
    @ResponseBody
    public String getPassword(@RequestBody InputParametersDto inputParametersDto, DtoToDomainMapper dtoToDomainMapper) throws EmptyDictionaryException {
        SignsDictionaryService signsDictionaryService = new SignsDictionaryService(dtoToDomainMapper.inputParametersDtoToInputParametersDictionary(inputParametersDto));
        PasswordService passwordService = new PasswordService(dtoToDomainMapper.inputParametersDtoToInputParametersPassword(inputParametersDto), signsDictionaryService);
        logger.info("Get password");
        return passwordService.getPassword();
    }
}
