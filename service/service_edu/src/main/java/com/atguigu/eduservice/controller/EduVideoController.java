package com.atguigu.eduservice.controller;


import com.atguigu.commonutils.R;
import com.atguigu.eduservice.client.VodClient;
import com.atguigu.eduservice.entity.EduVideo;
import com.atguigu.eduservice.service.EduVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 课程视频 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2021-12-03
 */
@RestController
@RequestMapping("/eduservice/edu-video")
@CrossOrigin
public class EduVideoController {

    @Autowired
    private EduVideoService eduVideoService;

    @Autowired
    private VodClient vodClient;

    // 添加小节的方法
    @PostMapping("/addVideo")
    public R addVideo(@RequestBody EduVideo eduVideo){
        boolean flag = eduVideoService.save(eduVideo);
        if (flag){
            return R.ok();
        }else {
            return R.error();
        }
    }

    // 根据id查询小节的方法
    @GetMapping("/getVideo/{videoId}")
    public R getVideo(@PathVariable String videoId){
        EduVideo eduVideo = eduVideoService.getById(videoId);
        if (eduVideo == null){
            return R.error();
        }else {
            return R.ok().data("video",eduVideo);
        }
    }

    // 修改小节的方法
    @PostMapping("/updateVideo")
    private R updateVideo(@RequestBody EduVideo eduVideo){
        boolean flag = eduVideoService.updateById(eduVideo);
        if (flag){
            return R.ok();
        }else {
            return R.error();
        }
    }

    // 删除小节的方法
    @DeleteMapping("/deleteVideo/{videoId}")
    public R deleteVideo(@PathVariable String videoId){
        // 根据小节id获取视频id,调用方法实现视频删除
        EduVideo eduVideo = eduVideoService.getById(videoId);
        String videoSourceId = eduVideo.getVideoSourceId();
        // 判断小节内是否有视频id
        if (!StringUtils.isEmpty(videoSourceId)){
            // 根据视频id，实现远程调用删除视频
            vodClient.removeAlyunVideo(videoSourceId);
        }
        eduVideoService.removeById(videoId);
        return R.ok();
    }


}

