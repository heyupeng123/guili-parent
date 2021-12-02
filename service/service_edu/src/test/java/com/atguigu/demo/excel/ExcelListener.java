package com.atguigu.demo.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.Map;

public class ExcelListener extends AnalysisEventListener<DemoData> {

    /**
     * 读取表头的内容
     * @param headMap
     * @param context
     */
    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        System.out.println("表头："+headMap);
    }

    /**
     * 一行一行的读取Excel的内容
     * @param data
     * @param analysisContext
     */
    @Override
    public void invoke(DemoData data, AnalysisContext analysisContext) {
        System.out.println("********"+data);
    }

    /**
     * 读取完成之后要执行的操作
     * @param analysisContext
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
