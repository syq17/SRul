package com.erongdu.config.build;

import com.erongdu.config.rule.StringRule;

/**
 * Created by syq on 2016/12/11.
 */
public final class StringRuleBuilder extends SimpleRuleBuilder<String, StringRule> {

    public StringRuleBuilder(long id, String column) {
        super(id, column);
    }

}
