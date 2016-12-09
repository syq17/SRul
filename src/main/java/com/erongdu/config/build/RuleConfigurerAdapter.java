package com.erongdu.config.build;

/**
 * 规则配置类的抽象适配器,主要功能是保存builder的实例
 * Created by syq on 2016/12/9.
 */
public abstract class RuleConfigurerAdapter<O, B extends RuleBuilder<O>> implements RuleConfigurer<O, B> {


    private B ruleBuilder;


    @Override
    public void init(B builder) throws Exception {
        /*builder的初始化*/
    }

    @Override
    public void configure(B builder) throws Exception {
        /*builder的*/
    }

    /**
     * 返回保存的builder，形成链式表达
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

    public void setBuilder(B builder) {
        this.ruleBuilder = builder;
    }


}
