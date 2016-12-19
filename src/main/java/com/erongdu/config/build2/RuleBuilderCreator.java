package com.erongdu.config.build2;


import com.erongdu.config.condition.Condition;
import com.erongdu.config.rule2.AbstractRule;
import com.erongdu.config.rule2.RuleBasic;
import com.erongdu.exception.RuleValueException;
import com.erongdu.utils.ConditionOpt;
import com.erongdu.utils.RulePolicy;

import java.util.HashSet;
import java.util.Set;

/**
 * builder factory single instance
 * Created by syq on 2016/12/17.
 */
public class RuleBuilderCreator {


    private static final RuleBuilder<String> stringRuleBuilder = new StringRuleBuilder();


    private static final RuleBuilder<Double> numRuleBuilder = new NumRuleBuilder();


    private RuleBuilderCreator() {

    }


    public static RuleBuilder<String> stringRuleBuilder() {
        return stringRuleBuilder;
    }


    public static RuleBuilder<Double> numRuleBuilder() {
        return numRuleBuilder;
    }


    private static final class StringRuleBuilder extends SimpleRuleBuilder<String, StringRule> {

        @Override
        protected RuleBasic<String> concrete() {
            StringRule rule = new StringRule();
            return rule;
        }
    }


    private static final class NumRuleBuilder extends SimpleRuleBuilder<Double, NumRule> {


        @Override
        protected RuleBasic<Double> concrete() {
            NumRule rule = new NumRule();
            return rule;
        }
    }


    final static class StringRule extends AbstractRule<String> {


        @Override
        public boolean beginMatch() throws RuleValueException {
            if (this.preLoad == null || this.preLoad.size() == 0) {
                throw new RuleValueException("StringRule must have preLoad! ");
            }
            Set<Boolean> matchSet = new HashSet<>();
            for (Condition<String> condition : this.conditions) {
                ConditionOpt opt = condition.getOpt();
                String value = condition.getValue();

                if (!preLoad.containsKey(value)) {
                    throw new RuleValueException("value : " + value + " is not in the preLoad! ");
                }
                Integer valueSortId = preLoad.get(value);

                Integer matchSortId = preLoad.get(matchTo);
                if(matchSortId == null) {
                    throw new RuleValueException("matchTo value : " + matchTo + " is not found! ");
                }

                switch (opt) {
                    case BIGGER:
                        matchSet.add(matchSortId > valueSortId);
                        break;
                    case BIGGER_EQUAL:
                        matchSet.add(matchSortId >= valueSortId);
                        break;
                    case SMALL:
                        matchSet.add(matchSortId < valueSortId);
                        break;
                    case SMALL_EQUAL:
                        matchSet.add(matchSortId <= valueSortId);
                        break;
                    case NOT_EQUAL:
                        matchSet.add(matchSortId != valueSortId);
                        break;
                    default:
                        throw new RuleValueException("opt : " + opt + " is not accepted! ");
                }
            }
            boolean isMatch = false;
            if (policy == RulePolicy.MATCHALL) {
                if (!matchSet.contains(false)) {
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


    final static class NumRule extends AbstractRule<Double> {


        @Override
        public boolean beginMatch() throws RuleValueException {
        /*数字类型的比对，较为简单，直接比对即可*/
            Set<Boolean> matchSet = new HashSet<>();
            for (Condition<Double> condition : this.conditions) {

                ConditionOpt opt = condition.getOpt();
                Double value = condition.getValue();

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
                if (!matchSet.contains(false)) {
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
}
