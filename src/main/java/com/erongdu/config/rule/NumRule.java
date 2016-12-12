package com.erongdu.config.rule;

import java.math.BigDecimal;

/**
 * Created by syq on 2016/12/11.
 */
public class NumRule extends AbstractRule<BigDecimal> {


    @Override
    public boolean result() {
        return false;
    }

    @Override
    public void match(BigDecimal bigDecimal) {

    }
}
