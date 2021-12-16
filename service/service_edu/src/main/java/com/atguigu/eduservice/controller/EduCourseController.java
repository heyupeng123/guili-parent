package com.atguigu.eduservice.controller;


import com.atguigu.commonutils.R;
import com.atguigu.eduservice.entity.EduCourse;
import com.atguigu.eduservice.entity.vo.CourseInfoVo;
import com.atguigu.eduservice.entity.vo.CoursePublishVo;
import com.atguigu.eduservice.service.EduCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2021-12-03
 */
@RestController
@RequestMapping("/eduservice/edu-course")
@CrossOrigin
public class EduCourseController {

    @Autowired
    private EduCourseService eduCourseService;

    /**
     * 添加课程基本信息的方法
     * @param courseInfoVo
     * @return
     */
    @PostMapping("/addCourseInfo")
    public R addCourseInfo(@RequestBody CourseInfoVo courseInfoVo){
        String id = eduCourseService.saveCourseInfo(courseInfoVo);
        return R.ok().data("courseId",id);
    }

    /**
     *
     * 根据id查询课程信息
     * @param courseId
     * @return
     */
    @GetMapping("/getCourseInfoById/{courseId}")
    public R getCourseInfoById(@PathVariable String courseId){
        CourseInfoVo courseInfoVo = eduCourseService.getCourseInfoById(courseId);
        return R.ok().data("courseInfoVo",courseInfoVo);
    }

    /**
     * 修改课程信息
     * @param courseInfoVo
     * @return
     */
    @PostMapping("/updateCourseInfo")
    public R updateCourseInfo(@RequestBody CourseInfoVo courseInfoVo){
        eduCourseService.updateCourseInfo(courseInfoVo);
        return R.ok();
    }

    // 根据id获取课程发布的信息
    @GetMapping("/getCoursePublishInfo/{coursePublishId}")
    public R getCoursePublishInfo(@PathVariable String coursePublishId){
        CoursePublishVo coursePublishVo = eduCourseService.coursePublishInfo(coursePublishId);
        return R.ok().data("coursePublish",coursePublishVo);
    }

    // 根据id修改课程的发布状态
    @PostMapping("/coursePublishById/{courseId}")
    public R coursePublishById(@PathVariable String courseId){
        EduCourse eduCourse = new EduCourse();
        eduCourse.setId(courseId);
        eduCourse.setStatus("Normal");
        boolean flag = eduCourseService.updateById(eduCourse);
        if (flag){
            return R.ok();
        }else {
            return R.error();
        }
    }

    // 删除课程
    @DeleteMapping("{courseId}")
    public R deleteCourse(@PathVariable("courseId") String courseId){
        eduCourseService.removeCourse(courseId);
        return R.ok();
    }

    // 课程列表查询
    @GetMapping("/getCourseList")
    public R getCourseList(){
        List<EduCourse> courseList = eduCourseService.list(null);
        return R.ok().data("courseList",courseList);
    }

}

