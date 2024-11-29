package com.eureka.labseq.controller;

import com.eureka.labseq.controller.api.SequenceControllerAPI;
import com.eureka.labseq.service.SequenceService;
import jakarta.inject.Inject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
@RequestMapping("/v1")
public class SequenceController implements SequenceControllerAPI {

    @Inject
    SequenceService sequenceService;

    @Override
    @ResponseStatus(HttpStatus.OK)
    public BigInteger calculateSequence(BigInteger index) {
        return sequenceService.calculateSequence(index);
    }
}
