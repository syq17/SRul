package com.erongdu.config.build;

import com.erongdu.config.rule.StringRule;

/**
 * Created by syq on 2016/12/11.
 */
public final class StringRuleBuilder extends SimpleRuleBuilder<String, StringRule> {

    public StringRuleBuilder(long id, String column) {
        super(id, column);
    }

    @Override
    public SimpleRuleBuilder<String, StringRule> preLoad(String load) {
        //string类型的规则，可能需要对load内容进行特殊的处理
        this.load = load;
        return this;
    }
}
