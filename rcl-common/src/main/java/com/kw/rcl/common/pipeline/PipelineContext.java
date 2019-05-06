package com.kw.rcl.common.pipeline;

/**
 * @author kinwey
 * @Date 2019-05-06
 */
public interface PipelineContext {
    boolean isBreakExecute();

    void setBreakExecute(boolean breakExecute);
}
