package com.atguigu.demo.excel;

import com.alibaba.excel.EasyExcel;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestEasyExcel {
    public static void main(String[] args) {
//        // 设置写入文件的具体资源路径
//        String fileName = "D:\\work\\write\\write.xlsx";
//        // 调用Excel里面的方法实现写的操作
//        EasyExcel.write(fileName,DemoData.class).sheet("学生列表").doWrite(getData());

        // 实现读取Excel文件的操作
        String fileName = "D:\\work\\write\\write.xlsx";

        EasyExcel.read(fileName,DemoData.class,new ExcelListener()).sheet().doRead();
    }

    public static List<DemoData> getData(){
        List<DemoData> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            DemoData data = new DemoData();
            data.setSno(i);
            data.setSname("tome"+i);
            list.add(data);
        }
        return list;
    }
}
