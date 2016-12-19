package com.erongdu.client;

import com.erongdu.config.build.RuleBuilder;
import com.erongdu.config.build.RuleBuilderCreator;
import com.erongdu.config.condition.ConditionItem;
import com.erongdu.config.core.RulesExecutor;
import com.erongdu.config.core.RulesLogic;
import com.erongdu.config.rule.Rule;
import com.erongdu.utils.RulePolicy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by syq on 2016/12/18.
 */
public class Client {


    public static void main(String[] args) throws Exception {


        Map<String, Integer> load = new HashMap<>();
        load.put("博士", 3);
        load.put("硕士", 2);
        load.put("学士", 1);

        /*创建string类型的规则builder*/
        RuleBuilder<String> ruleBuilder = RuleBuilderCreator.stringRuleBuilder();

        /*创建条件项，该实例对应每一条规则*/
        ConditionItem stringItem = ruleBuilder.newConditionItems();
        stringItem.add(">=", "学士");
        stringItem.add(">=", "博士");


        /*构建规则对象，规则对象为不可变对象，无法重复使用*/
        Rule rule = ruleBuilder.newRule(1, "education", stringItem).preLoad(load).rulePolicy(RulePolicy.MATCHALL).build();
        rule.matchTo("硕士");
        /*单条规则可以直接使用beginMatch()方法获取判断结果*/
        System.out.println(rule.beginMatch());


        /*创建数字类型的规则builder*/
        RuleBuilder<Double> numRuleBuilder = RuleBuilderCreator.numRuleBuilder();

        /*接收数组类型 long, int ,float ,double */
        ConditionItem numItems = numRuleBuilder.newConditionItems();
        numItems.add(">=", 20);
        numItems.add(">=", 30);

        Rule rule2 = numRuleBuilder.newRule(2, "age", numItems).rulePolicy(RulePolicy.MATCHALL).build();
        rule2.matchTo(40);

        System.out.println(rule2.beginMatch());


        List<Rule> list = new ArrayList<>();
        list.add(rule);
        list.add(rule2);

        /*创建多规则的逻辑判断对象，这里创建的是规则和规则之间没有逻辑关系*/
        RulesLogic rulesLogic = RulesExecutor.newNoneRelationRulesLogic();
        /*执行逻辑判断*/
        rulesLogic.doLogic(list);

        /*获取各个规则的执行结果*/
        Map<Long, Boolean> resultMap = rulesLogic.rulesResult();
        System.out.println(resultMap);
    }


}
