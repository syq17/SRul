package com.erongdu.config.build;

/**
 * Created by syq on 2016/12/9.
 */
public interface RuleConfigurer<O, B extends RuleBuilder<O>> {


    void init(B builder) throws Exception;


    void configure(B builder) throws Exception;

}
