package com.kw.rcl.common.pipeline;

import java.util.List;

/**
 * @author kinwey
 * @Date 2019-05-06
 */
public class Pipeline<T extends PipelineContext> {
    private List<Valve<T>> valves;

    public void setValves(List<Valve<T>> valves) {
        this.valves = valves;
    }

    public void execute(T context) {
        for (Valve<T> valve : valves) {
            valve.invoke(context);
            if (context.isBreakExecute()) {
                break;
            }
        }
    }
}
