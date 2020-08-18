package com.klenio.mapper;

import com.klenio.domain.InputParametersDictionary;
import com.klenio.domain.InputParametersPassword;
import com.klenio.dto.InputParametersDto;

public class DtoToDomainMapper {
    public InputParametersDictionary InputParametersDtoToInputParametersDictionary(InputParametersDto inputParametersDto) {
        return new InputParametersDictionary(inputParametersDto.isSmallLetters(),
                inputParametersDto.isLargeLetters(),
                inputParametersDto.isNumbers(),
                inputParametersDto.isSpecialSigns());
    }

    public InputParametersPassword InputParametersDtoToInputParametersPassword(InputParametersDto inputParametersDto) {
        return new InputParametersPassword(inputParametersDto.getUserName(),
                inputParametersDto.getMasterPassword(),
                inputParametersDto.getAppName(),
                inputParametersDto.getAppAddress(),
                inputParametersDto.getNumberOfSigns());
    }
}
