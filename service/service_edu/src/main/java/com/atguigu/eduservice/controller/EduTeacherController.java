package com.atguigu.eduservice.controller;


import com.atguigu.commonutils.R;
import com.atguigu.eduservice.entity.EduTeacher;
import com.atguigu.eduservice.entity.vo.TeacherQuery;
import com.atguigu.eduservice.service.EduTeacherService;
import com.atguigu.servicebase.exceptionhandler.GuliException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2021-11-16
 */
@RestController
@RequestMapping("/eduservice/teacher")
@CrossOrigin
public class EduTeacherController {

    @Autowired
    private EduTeacherService eduTeacherService;

    /**
     * 查询所有讲师的信息
     */
    @GetMapping(value = "/findAll")
    public R findAllTeacher(){
        List<EduTeacher> teachers = eduTeacherService.list(null);
        return R.ok().data("items",teachers);
    }

    @DeleteMapping(value = "/{id}")
    public R deleteTeacher(@PathVariable("id") String id){
        boolean flag = eduTeacherService.removeById(id);
        if (flag){
            return R.ok();
        }else {
            return R.error();
        }
    }

    /**
     * 分页查询讲师的方法
     * @param current 当前页
     * @param limit 每页的条数
     * @return
     */
    @GetMapping(value = "/pageTeacher/{current}/{limit}")
    public R pageListTeacher(@PathVariable("current") Long current,
                             @PathVariable("limit") Long limit){
        // 1 创建page对象
        Page<EduTeacher> pageTeacher = new Page<EduTeacher>(current,limit);

        eduTeacherService.page(pageTeacher, null);
        long total = pageTeacher.getTotal();  // 总记录数
        List<EduTeacher> records = pageTeacher.getRecords();  // 数据list集合
        return R.ok().data("total",total).data("rows",records);
    }

    /**
     * 分页条件查询讲师信息
     * @param current
     * @param limit
     * @param teacherQuery
     * @return
     */
    @PostMapping (value = "/pageTeacherCondition/{current}/{limit}")
    public R pageTeacherCondition(@PathVariable("current") Long current,
                                  @PathVariable("limit") Long limit,
                                  @RequestBody(required = false) TeacherQuery teacherQuery){
        Page<EduTeacher> teacherPage = new Page<EduTeacher>(current,limit);
        QueryWrapper<EduTeacher> wrapper = new QueryWrapper<>();
        String name = teacherQuery.getName(); // 讲师名称
        Integer level = teacherQuery.getLevel(); // 讲师等级
        String begin = teacherQuery.getBegin(); // 开始时间
        String end = teacherQuery.getEnd(); //  结束时间

        if (!StringUtils.isEmpty(name)){
            wrapper.like("name",name);
        }
        if (!StringUtils.isEmpty(level)){
            wrapper.eq("level",level);
        }
        if (!StringUtils.isEmpty(begin)){
            wrapper.ge("gmt_create",begin);
        }
        if (!StringUtils.isEmpty(end)){
            wrapper.le("gmt_modified",end);
        }
        // 排序
        wrapper.orderByDesc("gmt_create");

        eduTeacherService.page(teacherPage,wrapper);

        long total = teacherPage.getTotal();
        List<EduTeacher> records = teacherPage.getRecords();
        return R.ok().data("total",total).data("rows",records);
    }

    /**
     * 添加讲师
     * @param eduTeacher 讲师实体类
     * @return
     */
    @PostMapping(value = "/addTeacher")
    public R addTeacher(@RequestBody EduTeacher eduTeacher){
        boolean save = eduTeacherService.save(eduTeacher);
        if (save){
            return R.ok();
        }else {
            return R.error();
        }
    }

    /**
     * 通过id查询讲师的方法
     */
    @GetMapping(value = "/selectTeacherById/{id}")
    public R selectTeacherById(@PathVariable("id") String id){
        EduTeacher teacher = eduTeacherService.getById(id);
        if (teacher != null){
           return R.ok().data("teacher",teacher);
        }else {
            return R.error();
        }
    }

    @ApiOperation(value = "修改讲师")
    @PostMapping(value = "/updateTeacher")
    public R updateTeacher(@RequestBody EduTeacher eduTeacher){
        boolean flag = eduTeacherService.updateById(eduTeacher);
        if (flag){
            return R.ok();
        }else {
            return R.error();
        }
    }

}

