package com.erongdu.config.rule;

import com.erongdu.config.condition.Condition;
import com.erongdu.exception.RuleValueException;
import com.erongdu.utils.ConditionOpt;
import com.erongdu.utils.RulePolicy;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by syq on 2016/12/11.
 */
public class NumRule extends AbstractRule<BigDecimal> {


    public NumRule(List<Condition<BigDecimal>> conditions, RulePolicy policy) {
        this(conditions, policy, null);
    }

    public NumRule(List<Condition<BigDecimal>> conditions, RulePolicy policy, Map<BigDecimal, Integer> preLoad) {
        super(conditions, policy, preLoad);
    }


    @Override
    public boolean beginMatch() throws RuleValueException {
        /*数字类型的比对，较为简单，直接比对即可*/
        Set<Boolean> matchSet = new HashSet<>();
        for (Condition<BigDecimal> condition : this.conditions) {

            ConditionOpt opt = condition.getOpt();
            BigDecimal value = condition.getValue();

            switch (opt) {
                case BIGGER:
                    matchSet.add(matchTo.compareTo(value) == 1);
                    break;
                case BIGGER_EQUAL:
                    matchSet.add(matchTo.compareTo(value) != -1);
                    break;
                case SMALL:
                    matchSet.add(matchTo.compareTo(value) == -1);
                    break;
                case SMALL_EQUAL:
                    matchSet.add(matchTo.compareTo(value) != 1);
                    break;
                case NOT_EQUAL:
                    matchSet.add(matchTo.compareTo(value) != 0);
                    break;
                default:
                    throw new RuleValueException("opt : " + opt + " is not accepted! ");
            }

        }
        boolean isMatch = false;
        if (policy == RulePolicy.MATCHALL) {
            if(!matchSet.contains(false)){
                isMatch = true;
            }
        } else if (policy == RulePolicy.MATCHONE) {
            if (matchSet.contains(true)) {
                isMatch = true;
            }
        }
        return isMatch;
    }
}
