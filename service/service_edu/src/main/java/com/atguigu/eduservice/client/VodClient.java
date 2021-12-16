package com.atguigu.eduservice.client;

import com.atguigu.commonutils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("service-vod")
@Component
public interface VodClient {

    /**
     * 删除单个视频
     * @param id
     * @return
     */
    @DeleteMapping("/eduvod/video/removeAlyunVideo/{id}")
    public R removeAlyunVideo(@PathVariable("id") String id);

    /**
     * 删除多个视频
     * @param videoIdList
     * @return
     */
    @DeleteMapping("/eduvod/video/remove-multi")
    public R removeMultiAlyVideo(@RequestParam List<String> videoIdList);
}
