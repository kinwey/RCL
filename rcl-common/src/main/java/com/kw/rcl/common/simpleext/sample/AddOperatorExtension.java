package com.kw.rcl.common.simpleext.sample;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * @author kinwey
 * @Date 2019-03-28
 */
@Component
public class AddOperatorExtension implements OperatorExtensionPoint<Number> {
    @Override
    public Number operate(Number a, Number b) {
        return a.longValue() + b.longValue();
    }

    @Override
    public List<String> applicationScenes() {
        return Collections.singletonList("ADD");
    }
}
