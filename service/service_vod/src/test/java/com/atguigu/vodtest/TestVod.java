package com.atguigu.vodtest;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.vod.model.v20170321.GetPlayInfoRequest;
import com.aliyuncs.vod.model.v20170321.GetPlayInfoResponse;
import com.atguigu.vod.utils.InitVodClient;

import java.util.List;

public class TestVod {
    public static void main(String[] args) throws ClientException {

        // 创建初始化对象
        DefaultAcsClient client = InitVodClient.initVodClient("LTAI5tS5SEGnDHC3ooMuAMSs", "RnSMvy3IjewdAJcGLTHSBt0Yg50tEo");
        // 创建获取视频地址的response和request
        GetPlayInfoRequest request = new GetPlayInfoRequest();
        GetPlayInfoResponse response = new GetPlayInfoResponse();
        // 向request对象里面设置视频ID
        request.setVideoId("ce20ad8a53bc4f8bad145bd4083014a9");
        // 调用初始化对象里面的方法，传递request，获取数据
        response = client.getAcsResponse(request);

        List<GetPlayInfoResponse.PlayInfo> playInfoList = response.getPlayInfoList();
        // 获取播放地址
        for (GetPlayInfoResponse.PlayInfo playInfo:playInfoList) {
            System.out.println("PlayURL="+playInfo.getPlayURL()+"\n");
        }
        // Base信息
        System.out.println("VideoBase.Title="+response.getVideoBase().getTitle()+"\n");

    }
}
