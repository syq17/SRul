//package com.erongdu.config.rule;
//
//import com.erongdu.exception.RuleValueException;
//
///**
// * 规则类总接口
// * Created by syq on 2016/12/11.
// */
//public interface Rule<T> {
//
//
//    /**
//     * 需要去验证的值
//     *
//     * @param t
//     */
//    public void matchTo(T t) throws RuleValueException;
//
//
//    /**
//     * 获取该规则的id
//     *
//     * @return
//     */
//    public long id();
//
//
//    /**
//     * 获取该规则的目标字段名
//     *
//     * @return
//     */
//    public String column();
//
//    /**
//     * 获取该规则的名称
//     *
//     * @return
//     */
//    public String name();
//
//
//    public boolean beginMatch() throws RuleValueException;
//
//
//}
