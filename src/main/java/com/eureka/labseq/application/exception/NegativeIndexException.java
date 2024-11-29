package com.eureka.labseq.application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.math.BigInteger;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class NegativeIndexException extends RuntimeException{

    private final BigInteger index;

    public NegativeIndexException(BigInteger index) {
        super();
        this.index = index;
    }

    public BigInteger getIndex() {
        return index;
    }


}
