package com.atguigu.vodtest;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthRequest;
import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthResponse;
import com.atguigu.vod.utils.InitVodClient;

public class TestAuth {
    public static void main(String[] args) throws ClientException {
        // 创建初始化对象
        DefaultAcsClient client = InitVodClient.initVodClient("LTAI5tS5SEGnDHC3ooMuAMSs", "RnSMvy3IjewdAJcGLTHSBt0Yg50tEo");
        // 创建获取视频凭证的response和request对象
        GetVideoPlayAuthRequest request = new GetVideoPlayAuthRequest();
        GetVideoPlayAuthResponse response = new GetVideoPlayAuthResponse();
        // 向request中设置视频id
        request.setVideoId("ce20ad8a53bc4f8bad145bd4083014a9");
        // 调用初始化对象获取视频凭证
        response = client.getAcsResponse(request);

        // 获取凭证信息
        System.out.println("playAuth="+response.getPlayAuth()+"\n");
    }
}
