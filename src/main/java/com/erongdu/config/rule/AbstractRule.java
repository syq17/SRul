package com.erongdu.config.rule;

import com.erongdu.config.condition.Condition;
import com.erongdu.utils.RulePolicy;

import java.util.List;
import java.util.Map;

/**
 * Created by syq on 2016/12/12.
 */
public abstract class AbstractRule<T> implements Rule<T>, RuleInfo {


    protected List<Condition<T>> conditions;


    protected RulePolicy policy;

    protected Map<T, Integer> preLoad;


    public long id;

    public String name;

    public String column;

    protected T matchTo;


    public AbstractRule(List<Condition<T>> conditions, RulePolicy policy, Map<T, Integer> preLoad) {
        this.conditions = conditions;
        this.policy = policy;
        this.preLoad = preLoad;
    }


    @Override
    public long id() {
        return id;
    }

    @Override
    public String column() {
        return column;
    }

    @Override
    public String name() {
        return name;
    }


    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public void setColumn(String column) {
        this.column = column;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void matchTo(T s) {
        this.matchTo = s;
    }

}
