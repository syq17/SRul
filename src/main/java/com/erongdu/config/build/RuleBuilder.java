package com.erongdu.config.build;

/**
 * Interface for building an Object
 *
 * Created by syq on 2016/12/8.
 */
public interface RuleBuilder<O> {


    /**
     * Builds the object and returns it or null.
     *
     * @return the Object to be built or null if the implementation allows it.
     * @throws Exception if an error occurred when building the Object
     */
    O build() throws Exception;

}
