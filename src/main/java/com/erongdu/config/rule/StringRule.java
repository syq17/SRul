//package com.erongdu.config.rule;
//
//import com.erongdu.config.condition.Condition;
//import com.erongdu.exception.RuleValueException;
//import com.erongdu.utils.ConditionOpt;
//import com.erongdu.utils.RulePolicy;
//
//import java.util.HashSet;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//
//
///**
// * 一个简单的字符串规则实体表达类
// * 该规则中只能对一个字符串含义的规则字段进行设置
// * Created by syq on 2016/12/11.
// */
//public final class StringRule extends AbstractRule<String> {
//
//
//    public StringRule(List<Condition<String>> conditions, RulePolicy policy, Map<String, Integer> preLoad) {
//        super(conditions, policy, preLoad);
//    }
//
//
//    @Override
//    public boolean beginMatch() throws RuleValueException {
//        if (this.preLoad == null || this.preLoad.size() == 0) {
//            throw new RuleValueException("StringRule must have preLoad! ");
//        }
//        Set<Boolean> matchSet = new HashSet<>();
//        for (Condition<String> condition : this.conditions) {
//            ConditionOpt opt = condition.getOpt();
//            String value = condition.getValue();
//
//            if(!preLoad.containsKey(value)){
//                throw new RuleValueException("value : " + value + " is not in the preLoad! ");
//            }
//            int valueSortId = preLoad.get(value);
//
//            int matchSortId = preLoad.get(matchTo);
//
//            switch (opt) {
//                case BIGGER:
//                    matchSet.add(matchSortId > valueSortId);
//                    break;
//                case BIGGER_EQUAL:
//                    matchSet.add(matchSortId >= valueSortId);
//                    break;
//                case SMALL:
//                    matchSet.add(matchSortId < valueSortId);
//                    break;
//                case SMALL_EQUAL:
//                    matchSet.add(matchSortId <= valueSortId);
//                    break;
//                case NOT_EQUAL:
//                    matchSet.add(matchSortId != valueSortId);
//                    break;
//                default:
//                    throw new RuleValueException("opt : " + opt + " is not accepted! ");
//            }
//        }
//        boolean isMatch = false;
//        if (policy == RulePolicy.MATCHALL) {
//            if(!matchSet.contains(false)){
//                isMatch = true;
//            }
//        } else if (policy == RulePolicy.MATCHONE) {
//            if (matchSet.contains(true)) {
//                isMatch = true;
//            }
//        }
//        return isMatch;
//    }
//
//
//}
