package com.blog.common.utils;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.util.logging.Logger;

/**
 * 七牛云上传工具类
 * @author liangxuanhao
 * @date 2018年03月26日  20:32
 */
@Service
public class QiniuUtil {

    //private static final Logger logger = (Logger) LoggerFactory.getLogger(QiniuUtil.class);


    //基本配置
    @Value("${qiniu.accessKey}")
    private String accessKey;

    @Value("${qiniu.secretKey}")
    private String secreKey;

    @Value("${qiniu.bucket}")
    private String bucket;

    @Value("${qiniu.path}")
    private String path;

    /**
     *上传图片到七牛云
     * @param file
     * @param key  保存在空间中的名字，如果为空会使用文件的hash值为文件名
     * @return
     */
    public String uploadImg(FileInputStream file, String key) {

        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone2());

        UploadManager uploadManager = new UploadManager(cfg);

        try {
            Auth auth = Auth.create(accessKey, secreKey);
            String upToken = auth.uploadToken(bucket);
            try {
                Response response = uploadManager.put(file, key, upToken, null, null);
                //解析上传成功后的结果
                DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
                String return_path = path+"/"+putRet.key;
//                System.out.println(return_path);
                return return_path;
            }catch (QiniuException qe) {

                Response r = qe.response;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



}
