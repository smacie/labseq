package com.eureka.labseq.controller.api;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.constraints.PositiveOrZero;
import java.math.BigInteger;

public interface
SequenceControllerAPI {

    @Operation(summary = "Calculates sequence value for given index.")
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "Sequence calculated successfully"),
            @APIResponse(responseCode = "400", description = "Supplied index not valid"),
            @APIResponse(responseCode = "500", description = "Internal Server Error")
    })
    @GetMapping(path = "/{index}")
    BigInteger calculateSequence(
            @Parameter(description = "Path variable for index of the sequence")
            @PathVariable(name = "index")
            @PositiveOrZero(message = "Index can't be negative") BigInteger index);


}
