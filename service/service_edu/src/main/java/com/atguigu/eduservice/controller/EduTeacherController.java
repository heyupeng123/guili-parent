package com.atguigu.eduservice.controller;


import com.atguigu.eduservice.entity.EduTeacher;
import com.atguigu.eduservice.service.EduTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class EduTeacherController {

    @Autowired
    private EduTeacherService eduTeacherService;

    /**
     * 查询所有讲师的信息
     */
    @GetMapping(value = "/findAll")
    public List<EduTeacher> findAllTeacher(){
        List<EduTeacher> teachers = eduTeacherService.list(null);
        return teachers;

    }

    @DeleteMapping(value = "/{id}")
    public boolean deleteTeacher(@PathVariable("id") String id){
        boolean result = eduTeacherService.removeById(id);
        return result;
    }

}

