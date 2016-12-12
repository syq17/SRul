package com.erongdu.config.build;

import com.erongdu.config.rule.Rule;

/**
 * 规则配置类的抽象适配器,主要功能是保存builder的实例
 * Created by syq on 2016/12/9.
 */
public abstract class RuleConfigurerAdapter<H, O extends Rule<H>, B extends RuleBuilder<H, O>> implements RuleConfigurer<H, O, B> {


    private B ruleBuilder;


    /**
     * 返回保存的builder，形成链式表达
     *
     * @return
     */
    public B and() {
        return getBuilder();
    }

    protected final B getBuilder() {
        if (ruleBuilder == null) {
            throw new IllegalStateException("ruleBuilder cannot be null");
        }
        return ruleBuilder;
    }

    protected void setBuilder(B builder) {
        this.ruleBuilder = builder;
    }
}
