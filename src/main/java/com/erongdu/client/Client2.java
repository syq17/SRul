package com.erongdu.client;

import com.erongdu.config.build2.RuleBuilder;
import com.erongdu.config.build2.RuleBuilderCreator;
import com.erongdu.config.condition.ConditionItem;
import com.erongdu.config.rule2.Rule;
import com.erongdu.utils.RulePolicy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by syq on 2016/12/18.
 */
public class Client2 {


    public static void main(String[] args) throws Exception{


        Map<String, Integer> load = new HashMap<>();
        load.put("博士", 3);
        load.put("硕士", 2);
        load.put("学士", 1);

        RuleBuilder<String> ruleBuilder = RuleBuilderCreator.stringRuleBuilder();
        ConditionItem<String> conditionItem = ruleBuilder.newConditionItems();

        conditionItem.add(">=", "学士");
        conditionItem.add(">=", "博士");

        Rule rule = ruleBuilder.init(1,"education",conditionItem).preLoad(load).rulePolicy(RulePolicy.MATCHALL).build();

        rule.matchTo("学士");

        System.out.println(rule.beginMatch());
    }


}
