package com.kw.rcl.common.pipeline;

/**
 * @author kinwey
 * @Date 2019-05-06
 */
public class PipelineContextDelegate implements PipelineContext {
    private boolean breakExecute = false;

    @Override
    public boolean isBreakExecute() {
        return breakExecute;
    }

    @Override
    public void setBreakExecute(boolean breakExecute) {
        this.breakExecute = breakExecute;
    }
}
