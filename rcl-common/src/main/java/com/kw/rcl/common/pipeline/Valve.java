package com.kw.rcl.common.pipeline;

/**
 * @author kinwey
 * @Date 2019-05-06
 */
public interface Valve<T extends PipelineContext> {
    void invoke(T context);
}
