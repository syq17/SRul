package com.erongdu.config.build2;

import com.erongdu.config.condition.Condition;
import com.erongdu.config.condition.ConditionItem;
import com.erongdu.config.rule.RuleInfo;
import com.erongdu.config.rule2.Rule;
import com.erongdu.config.rule2.RuleBasic;
import com.erongdu.utils.RulePolicy;

import java.util.Map;

/**
 * user interface , show the method to use
 * each type rule must have only one builder ,means builder should be the single also
 * Created by syq on 2016/12/17.
 */
public interface RuleBuilder<T> {





    /**
     * rule condition collect
     *
     * @return
     */
    ConditionItem<T> newConditionItems();


    /**
     * pass three param which rule must be needed
     *
     * @param id
     * @param column
     * @param conditionItem
     * @return
     */
    RuleConfigurer<T> init(long id, String column, ConditionItem<T> conditionItem) throws IllegalAccessException, InstantiationException;


}
