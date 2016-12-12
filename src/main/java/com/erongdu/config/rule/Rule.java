package com.erongdu.config.rule;

import com.erongdu.config.build.RuleBuilder;
import com.erongdu.config.build.RuleConfigurerAdapter;
import com.erongdu.config.condition.Condition;
import com.erongdu.exception.RuleValueException;
import com.erongdu.utils.RulePolicy;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * 规则类总接口
 * Created by syq on 2016/12/11.
 */
public interface Rule<T> {


    /**
     * 传入待验证的值，由实现类来决定是否匹配规则
     *
     * @return
     */
    public boolean result();


    /**
     * 需要去验证的值
     *
     * @param t
     */
    public void matchTo(T t) throws RuleValueException;


    /**
     * 获取该规则的id
     *
     * @return
     */
    public long id();


    /**
     * 获取该规则的目标字段名
     *
     * @return
     */
    public String column();

    /**
     * 获取该规则的名称
     *
     * @return
     */
    public String name();


    public void setId(long id);

    public void setColumn(String column);

    public void setName(String name);


    public boolean beginMatch() throws RuleValueException;


}
