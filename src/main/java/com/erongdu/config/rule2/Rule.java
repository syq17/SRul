package com.erongdu.config.rule2;

import com.erongdu.exception.RuleValueException;
import com.erongdu.utils.RulePolicy;

/**
 * user interface show method to use
 * Created by syq on 2016/12/17.
 */
public interface Rule {


    /**
     * set the obj to be matched
     *
     * @param o
     */
    void matchTo(Object o) throws RuleValueException;


    /**
     * start match logic and give the result
     *
     * @return
     */
    boolean beginMatch() throws RuleValueException;


    /**
     * get id
     *
     * @return
     */
    public long getId();

    /**
     * get column name
     *
     * @return
     */
    public String getColumn();

    /**
     * get rule name
     *
     * @return
     */
    public String getName();


}
