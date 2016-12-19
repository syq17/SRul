package com.erongdu.config.build;

import com.erongdu.config.rule.Rule;
import com.erongdu.config.rule.RuleBasic;

/**
 * Created by syq on 2016/12/18.
 */
public interface Builder {

    /**
     * storing the rules which  produced from each thread
     */
    ThreadLocal<RuleBasic> threadLocalRules = new ThreadLocal<>();


    /**
     * return the rule want to build
     *
     * @return
     * @throws Exception
     */
    Rule build() throws Exception;


}
