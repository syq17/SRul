package com.erongdu.client;

import com.erongdu.config.build.SimpleRuleBuilder;
import com.erongdu.config.build.StringRuleBuilder;
import com.erongdu.config.rule.Rule;
import com.erongdu.config.rule.StringRule;
import com.erongdu.utils.ConditionOpt;
import com.erongdu.utils.RulePolicy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by syq on 2016/12/11.
 */
public class Client {

    public static void main(String[] args) throws Exception {

        String load = "a:1";

        StringRuleBuilder stringRuleBuilder = new StringRuleBuilder(1, "education");


        Map<String, String> conditionMap = new HashMap<>();
        conditionMap.put("<", "本科");
        conditionMap.put(">", "博士");

        StringRule rule = stringRuleBuilder.rulePolicy(RulePolicy.MATCHALL).preLoad(load)
                .conditionManagement().createConditions(conditionMap).build();
        rule.match("博士");


    }


}
