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

        Map<String,Integer> load = new HashMap<>();
        load.put("博士",3);
        load.put("硕士",2);
        load.put("学士",1);

        StringRuleBuilder stringRuleBuilder = new StringRuleBuilder(1, "education");


        Map<String, String> conditionMap = new HashMap<>();
        conditionMap.put(">=", "学士");
        conditionMap.put(">=", "博士");

        StringRule rule = stringRuleBuilder.rulePolicy(RulePolicy.MATCHONE).preLoad(load)
                .conditionManagement().createConditions(conditionMap).build();

        rule.matchTo("学士");

        rule.beginMatch();

        System.out.println(rule.result());


    }


}
