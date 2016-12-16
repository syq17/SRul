package com.erongdu.config.build;

import com.erongdu.config.condition.Condition;
import com.erongdu.config.condition.ConditionItem;
import com.erongdu.config.rule.Rule;
import com.erongdu.exception.RuleBuildException;
import com.erongdu.utils.RulePolicy;

import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * 简单规则构造类
 * Created by syq on 2016/12/9.
 */
public abstract class SimpleRuleBuilder<H, O extends Rule<H>> extends AbstractRuleBuilder<H, O> {


    protected RulePolicy rulePolicy = RulePolicy.MATCHALL;//该规则的策略，可选项，默认为全匹配

    protected Map<H, Integer> load;//预加载项，可选项

    protected String name;//规则名称，可选项

    protected long id;//规则标识

    protected String column;//目标字段名

    protected Class<O> oClazz;

    private ConditionManagementConfigurer<H, O, SimpleRuleBuilder<H, O>> configurerAdapter;//条件配置器


    private ConditionItem<H> conditionItem;


    @SuppressWarnings("unchecked")
    public SimpleRuleBuilder(long id, String column) {
        super();
        this.id = id;
        this.column = column;

        Type type = getClass().getGenericSuperclass();
        this.oClazz = (Class<O>) ((ParameterizedType) type).getActualTypeArguments()[1];
    }


    /**
     * 获取条件管理器来配置条件的具体信息
     *
     * @return
     */
    public ConditionManagementConfigurer<H, O, SimpleRuleBuilder<H, O>> conditionManagement() {
        if (configurerAdapter == null) {
            this.configurerAdapter = new ConditionManagementConfigurer<>();
            this.configurerAdapter.setBuilder(this);
        }
        return this.configurerAdapter;
    }


    public ConditionItem<H> conditionItem() {
        if (this.conditionItem == null) {
            this.conditionItem = new ConditionItem<>();
        }
        return this.conditionItem;
    }


    /**
     * 该方法定义这条规则中的各个条件之间是什么关系模式，如必须全部条件都匹配，还是只要其中一个条件匹配即可
     *
     * @param policy
     * @return
     */
    public SimpleRuleBuilder<H, O> rulePolicy(RulePolicy policy) {
        if (policy == null) throw new RuleBuildException("policy cannot be null");
        this.rulePolicy = policy;
        return this;
    }


    /**
     * 规则的预加载数据，比如字符串比对时所依赖的判断依据
     *
     * @param loadMap
     * @return
     */
    public SimpleRuleBuilder<H, O> preLoad(Map<H, Integer> loadMap) {
        this.load = loadMap;
        return this;
    }


    /**
     * 规则名称
     *
     * @param name
     * @return
     */
    public SimpleRuleBuilder<H, O> name(String name) {
        this.name = name;
        return this;
    }


    @Override
    protected O doBuild() throws Exception {
        Constructor<O> constructor = this.oClazz.getConstructor(List.class, RulePolicy.class, Map.class);
        List<Condition<H>> list = this.configurerAdapter.getConditions();
        O oInstance = constructor.newInstance(list, this.rulePolicy, this.load);
        oInstance.setId(this.id);
        oInstance.setColumn(this.column);
        oInstance.setName(this.name);
        return oInstance;
    }


}
