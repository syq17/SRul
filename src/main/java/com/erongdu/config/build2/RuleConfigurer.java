package com.erongdu.config.build2;

import com.erongdu.config.rule2.Rule;
import com.erongdu.utils.RulePolicy;

import java.util.Map;

/**
 * Created by syq on 2016/12/18.
 */
public interface RuleConfigurer<H> extends Builder {

    /**
     * define the rule policy , is match all or match one
     *
     * @param rulePolicy
     * @return
     */
    RuleConfigurer<H> rulePolicy(RulePolicy rulePolicy);


    /**
     * load the string data to range the match value ,help machine to recognize
     *
     * @param map
     * @return
     */
    RuleConfigurer<H> preLoad(Map<H, Integer> map);


    RuleConfigurer<H> name(String name);


}
