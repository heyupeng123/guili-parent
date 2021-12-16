package com.atguigu.vod.controller;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.vod.model.v20170321.DeleteVideoRequest;
import com.atguigu.commonutils.R;
import com.atguigu.servicebase.exceptionhandler.GuliException;
import com.atguigu.vod.service.VideoService;
import com.atguigu.vod.utils.ConstantPropertiesUtils;
import com.atguigu.vod.utils.InitVodClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/eduvod/video")
@CrossOrigin
public class VideoController {

    @Autowired
    private VideoService videoService;

    // 上传视频到阿里云
    @PostMapping("/uploadAlyunVideo")
    public R uploadAlyunVideo(MultipartFile file){
        String videoId = videoService.uploadAlyVideo(file);
        return R.ok().data("videoId",videoId);
    }

    // 根据id删除视频的方法
    @DeleteMapping("/removeAlyunVideo/{id}")
    public R removeAlyunVideo(@PathVariable String id){
        try {
            // 初始化对象
            DefaultAcsClient client = InitVodClient.initVodClient(ConstantPropertiesUtils.ACCESS_KEY_ID, ConstantPropertiesUtils.ACCESS_SECRET);
            // 创建删除视频的request对象
            DeleteVideoRequest request = new DeleteVideoRequest();
            // 设置视频id
            request.setVideoIds(id);
            // 调用初始化方法进行删除
            client.getAcsResponse(request);
            return R.ok();
        }catch (Exception e){
            e.printStackTrace();
            throw new GuliException(20001,"删除视频失败！");
        }
    }

    // 根据多个视频id删除视频的方法
    @DeleteMapping("/remove-multi")
    public R removeMultiAlyVideo(@RequestParam List<String> videoIdList){
        videoService.removeVideoByIds(videoIdList);
        return R.ok();
    }

}
