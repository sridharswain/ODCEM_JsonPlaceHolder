package com.odcem.jsonplaceholderwithjwt.validator;

import com.odcem.jsonplaceholderwithjwt.dto.LimitDto;
import com.odcem.jsonplaceholderwithjwt.exception.InvalidParamException;
import com.odcem.jsonplaceholderwithjwt.exception.ParamNotFoundException;

public class LimitValidator extends BasicValidator {

    LimitDto limitDto;

    public LimitValidator(LimitDto limitDto){
        this.limitDto = limitDto;
    }

    @Override
    public void validate() {
        boolean paramUnavailable = (limitDto == null
            || limitDto.getLlimit() == null
            || limitDto.getUlimit() == null);

        if(paramUnavailable) throw  new ParamNotFoundException("Params unavailable.");

        int llimit = limitDto.getLlimit();
        int ulimit = limitDto.getUlimit();

        if(ulimit < 0) throw new InvalidParamException("ulimit should be non-negative");
        else if(llimit < 0) throw new InvalidParamException("llimit should be non-negative");
        else if(llimit > ulimit) throw new InvalidParamException("ulimit should be greater or equal to llimit");
    }
}
