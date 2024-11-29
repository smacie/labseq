package com.eureka.labseq.service;

import com.eureka.labseq.application.exception.NegativeIndexException;
import jakarta.enterprise.context.RequestScoped;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

@RequestScoped
public class SequenceService {

    private static final Map<BigInteger, BigInteger> mapSequences = new HashMap<>(){{
        put(BigInteger.ZERO, BigInteger.ZERO);
        put(BigInteger.ONE, BigInteger.ONE);
        put(BigInteger.TWO, BigInteger.ZERO);
        put(BigInteger.valueOf(3), BigInteger.ONE);
    }};
    public BigInteger calculateSequence (BigInteger index) {
        if(index.compareTo(BigInteger.valueOf(0)) < 0){
            throw new NegativeIndexException(index);
        }

        if(mapSequences.containsKey(index)){
            return mapSequences.get(index);
        }

        fillMapSequences(index);
        return mapSequences.get(index);
    }

    private void fillMapSequences(BigInteger index) {
        BigInteger position = BigInteger.valueOf(4);

        while (position.compareTo(index) <= 0){
            if(!mapSequences.containsKey(position)){
                BigInteger positionValue = getPositionValue(position);
                mapSequences.put(position, positionValue);
            }
            position = position.add(BigInteger.ONE);
        }
    }

    private BigInteger getPositionValue(BigInteger position) {
        BigInteger firstValue = mapSequences.get(position.subtract(BigInteger.valueOf(4)));
        BigInteger secondValue = mapSequences.get(position.subtract(BigInteger.valueOf(3)));
        return  firstValue.add(secondValue);
    }

}
