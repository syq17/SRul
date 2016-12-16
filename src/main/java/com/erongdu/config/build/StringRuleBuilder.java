package com.erongdu.config.build;

import com.erongdu.config.rule.StringRule;

/**
 * Created by syq on 2016/12/11.
 */
public final class StringRuleBuilder extends SimpleRuleBuilder<String, StringRule> {

    public StringRuleBuilder(long id, String column) {
        super(id, column);
    }


    /*需要一个构造condition参数的方法，注意，不能是hashMap类型，不然操作符将会被覆盖掉*/







}