package com.atguigu.eduservice.service;

import com.atguigu.eduservice.entity.EduVideo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 课程视频 服务类
 * </p>
 *
 * @author testjava
 * @since 2021-12-03
 */
public interface EduVideoService extends IService<EduVideo> {

    /**
     * 删除小节的方法
     * @param courseId
     */
    void removeVideoByCourseId(String courseId);
}
