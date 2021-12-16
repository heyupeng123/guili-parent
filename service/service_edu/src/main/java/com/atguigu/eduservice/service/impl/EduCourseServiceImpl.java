package com.atguigu.eduservice.service.impl;

import com.atguigu.eduservice.entity.EduCourse;
import com.atguigu.eduservice.entity.EduCourseDescription;
import com.atguigu.eduservice.entity.vo.CourseInfoVo;
import com.atguigu.eduservice.entity.vo.CoursePublishVo;
import com.atguigu.eduservice.mapper.EduCourseMapper;
import com.atguigu.eduservice.service.EduChapterService;
import com.atguigu.eduservice.service.EduCourseDescriptionService;
import com.atguigu.eduservice.service.EduCourseService;
import com.atguigu.eduservice.service.EduVideoService;
import com.atguigu.servicebase.exceptionhandler.GuliException;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2021-12-03
 */
@Service
public class EduCourseServiceImpl extends ServiceImpl<EduCourseMapper, EduCourse> implements EduCourseService {

    @Autowired
    private EduCourseDescriptionService courseDescriptionService;

    @Autowired
    private EduVideoService videoService;

    @Autowired
    private EduChapterService chapterService;

    // 添加课程基本信息的方法
    @Override
    public String saveCourseInfo(CourseInfoVo courseInfoVo) {
        // 1 向课程基本信息表中添加基本信息
        EduCourse eduCourse = new EduCourse();
        BeanUtils.copyProperties(courseInfoVo,eduCourse);
        int insert = baseMapper.insert(eduCourse);
        if (insert <= 0){
            // 添加失败
            throw new GuliException(20001,"添加课程信息失败!");
        }

        // 获取添加后的课程id
        String cid = eduCourse.getId();
        // 2 向课程简介表中添加简介
        EduCourseDescription courseDescription = new EduCourseDescription();
        courseDescription.setDescription(courseInfoVo.getDescription());
        courseDescription.setId(cid);
        courseDescriptionService.save(courseDescription);

        return cid;
    }

    @Override
    public CourseInfoVo getCourseInfoById(String courseId) {
        EduCourse eduCourse = baseMapper.selectById(courseId);
        CourseInfoVo courseInfoVo = new CourseInfoVo();
        if (eduCourse != null){
            BeanUtils.copyProperties(eduCourse,courseInfoVo);
        }else {
            throw new GuliException(20001,"课程信息不存在！");
        }
        // 查询小节信息
        EduCourseDescription courseDescription = courseDescriptionService.getById(courseId);
        if (courseDescription !=null){
            courseInfoVo.setDescription(courseDescription.getDescription());
        }
        return courseInfoVo;
    }

    /**
     * 修改方法
     * @param courseInfoVo
     */
    @Override
    public void updateCourseInfo(CourseInfoVo courseInfoVo) {
        // 1 修改课程表
        EduCourse eduCourse = new EduCourse();
        BeanUtils.copyProperties(courseInfoVo,eduCourse);
        int update = baseMapper.updateById(eduCourse);
        if (update <=0){
            throw new GuliException(20001,"修改信息失败");
        }

        // 2 修改课程简介表
        EduCourseDescription courseDescription = new EduCourseDescription();
        BeanUtils.copyProperties(courseInfoVo,courseDescription);
        boolean update1 = courseDescriptionService.updateById(courseDescription);
        if (!update1){
            throw new GuliException(20001,"修改信息失败");
        }

    }

    @Override
    public CoursePublishVo getCoursePublishVoById(String id) {
        return null;
    }

    @Override
    public CoursePublishVo coursePublishInfo(String coursePublishId) {
        CoursePublishVo coursePublishInfo = baseMapper.getCoursePublishInfo(coursePublishId);
        return coursePublishInfo;
    }

    /**
     * 删除课程
     * @param courseId
     */
    @Override
    public void removeCourse(String courseId) {
        // 根据课程id删除小节
        videoService.removeVideoByCourseId(courseId);
        // 根据课程id删除章节
        chapterService.removeChapterByCourseId(courseId);
        // 根据课程id删除课程描述
        courseDescriptionService.removeCourseDescriptionByCourseId(courseId);
        // 根据课程id删除课程本身
        int result = baseMapper.deleteById(courseId);
        if (result==0){
            throw new GuliException(20001,"删除课程失败！");
        }

    }
}
