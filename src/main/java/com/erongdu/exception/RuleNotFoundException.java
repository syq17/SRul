package com.erongdu.exception;

/**
 * Created by syq on 2016/12/14.
 */
public class RuleNotFoundException extends RuntimeException{

    public RuleNotFoundException(String message) {
        super(message);
    }
}
