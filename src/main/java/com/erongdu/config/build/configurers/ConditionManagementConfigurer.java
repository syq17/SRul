package com.erongdu.config.build.configurers;

import com.erongdu.config.build.RuleBuilder;

/**
 * condition 管理配置类
 * Created by syq on 2016/12/9.
 */
public final class ConditionManagementConfigurer<H extends RuleBuilder<H>>
        extends AbstractConditionConfigurer<ConditionManagementConfigurer<H>, H> {


    public ConditionManagementConfigurer() {

    }


    public ConditionManagementConfigurer<H> sessionCreationPolicy(SessionCreationPolicy sessionCreationPolicy) {
        Assert.notNull(sessionCreationPolicy, "sessionCreationPolicy cannot be null");
        this.sessionPolicy = sessionCreationPolicy;
        return this;
    }


}
