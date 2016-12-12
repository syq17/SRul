package com.erongdu.config.rule;

import com.erongdu.config.condition.Condition;
import com.erongdu.exception.RuleValueException;
import com.erongdu.utils.RulePolicy;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by syq on 2016/12/11.
 */
public class NumRule extends AbstractRule<BigDecimal> {


    public NumRule(List<Condition<BigDecimal>> conditions, RulePolicy policy, Map<BigDecimal, Integer> preLoad) {
        super(conditions, policy, preLoad);
    }


    @Override
    public boolean beginMatch() throws RuleValueException {
        return false;
    }
}
