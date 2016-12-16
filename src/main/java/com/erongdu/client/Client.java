package com.erongdu.client;

import com.erongdu.config.build.NumRuleBuilder;
import com.erongdu.config.build.StringRuleBuilder;
import com.erongdu.config.condition.ConditionItem;
import com.erongdu.config.core.RulesExecutor;
import com.erongdu.config.core.RulesLogic;
import com.erongdu.config.rule.Rule;
import com.erongdu.utils.RulePolicy;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by syq on 2016/12/11.
 */
public class Client {

    public static void main(String[] args) throws Exception {



        /*应该为，造出一个builder，这个builder可以为一类的rule进行多次的构建，不应该一个builder对应一条规则*/


        Map<String, Integer> load = new HashMap<>();
        load.put("博士", 3);
        load.put("硕士", 2);
        load.put("学士", 1);






        StringRuleBuilder stringRuleBuilder = new StringRuleBuilder(1, "education");

        ConditionItem<String> conditionItem = stringRuleBuilder.conditionItem();
        conditionItem.add(">=", "学士");
        conditionItem.add(">=", "博士");

        Rule<String> rule = stringRuleBuilder.rulePolicy(RulePolicy.MATCHONE).preLoad(load)
                .conditionManagement().createConditions(conditionItem).build();

        rule.matchTo("学士");
        System.out.println(rule.beginMatch());

        NumRuleBuilder numRuleBuilder = new NumRuleBuilder(2, "age");

        ConditionItem<BigDecimal> conditionItem2 = numRuleBuilder.conditionItem();
        conditionItem2.add(">=", new BigDecimal(20));
        conditionItem2.add(">=", new BigDecimal(30));

        Rule<BigDecimal> rule2 = numRuleBuilder.rulePolicy(RulePolicy.MATCHALL).conditionManagement().createConditions(conditionItem2).build();

        rule2.matchTo(new BigDecimal(30));


        System.out.println(rule2.beginMatch());


        rule2.beginMatch();

        List<Rule> list = new ArrayList<>();
        list.add(rule);
        list.add(rule2);

        RulesLogic rulesLogic = RulesExecutor.newNoneRelationRulesLogic();

        rulesLogic.doLogic(list);
        Map<Long, Boolean> resultMap = rulesLogic.rulesResult();
        System.out.println(resultMap);

    }


}
