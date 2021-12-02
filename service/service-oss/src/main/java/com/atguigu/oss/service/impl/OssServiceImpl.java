package com.atguigu.oss.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.atguigu.oss.service.OssService;
import com.atguigu.oss.utils.ConstantPropertiesUtils;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.UUID;

@Service
public class OssServiceImpl implements OssService {

    /**
     * 上传头像到oss的方法
     * @param file
     * @return
     */
    @Override
    public String uploadFileAvatar(MultipartFile file) {
        // yourEndpoint填写Bucket所在地域对应的Endpoint。以华东1（杭州）为例，Endpoint填写为https://oss-cn-hangzhou.aliyuncs.com。
        String endpoint = ConstantPropertiesUtils.END_POINT;
        // 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
        String accessKeyId = ConstantPropertiesUtils.ACCESS_KEY_ID;
        String accessKeySecret = ConstantPropertiesUtils.ACCESS_KEY_SECRET;
        // 填写Bucket名称，例如examplebucket。
        String bucketName = ConstantPropertiesUtils.BUCKET_NAME;
//        // 填写文件名。文件名包含路径，不包含Bucket名称。例如exampledir/exampleobject.txt。
//        String objectName = "exampledir/exampleobject.txt";

        OSS ossClient = null;
        try {
            // 创建OSSClient实例。
            ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
            // 获取上传文件的输入流
            InputStream inputStream = file.getInputStream();

            // 获取文件的真实名称
            String fileName = file.getOriginalFilename();

            // 随机生成一个字符串
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            fileName = uuid + fileName;

            // 获取当前时间
            String datePath = new DateTime().toString("yyyy/MM/dd");
            // 拼接
            fileName = datePath+"/"+fileName;
            // 调用oss的方法实现上传
            // 第一个参数 bucketName：对象存储的名称
            // 第二个参数 fileName：文件名称
            // 第三个参数 fileName：文件输入流
            ossClient.putObject(bucketName,fileName,inputStream);
            // https://heima-1010.oss-cn-beijing.aliyuncs.com/mn.jpg
            // 拼接上传头像的路径
            String url = "https://"+bucketName+"."+endpoint+"/"+fileName;
            return url;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        } finally {
            // 关闭OSSClient。
            ossClient.shutdown();
        }
    }
}
