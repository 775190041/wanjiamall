package com.nf.wanjiamall.utils.aliyun;

import com.aliyun.oas.utils.StringUtil;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.CannedAccessControlList;
import com.aliyun.oss.model.CreateBucketRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


@Slf4j
public class OssUtil {
    //外网地址
    private static String ENDPOINI = "oss-cn-beijing.aliyuncs.com";
    // 密钥
    private static String ACCESSKEYID = "LTAI4FdUENiw5u8Pe6AnHexK";
    //密钥密码
    private static String ACCESSKEYSECRET = "E8uyx08AHeQPIw5s16BcI2dGxYMX1A";
    //仓库名称
    private static String BUKETNSME = "killbug";
    //上传成功后返回URL
    private static String SUFFER_URL = "http://killbug.oss-cn-beijing.aliyuncs.com/";

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-");
    /**
     * 获取OSS连接
     * @return
     */
    public OSSClient getOSSClient(){
        //创建OSSlient 对象
        OSSClient ossClient = new OSSClient(ENDPOINI,ACCESSKEYID,ACCESSKEYSECRET);
        //判断仓库是否存在
        if(ossClient.doesBucketExist(BUKETNSME)){
            log.info("------>>buket创建成功");
        }else{
            log.info("------>>buket不存在，创建bucket:"+BUKETNSME);
            //创建一个oss的仓库
            CreateBucketRequest bucketRequest = new CreateBucketRequest(null);
            //设置仓库名称
            bucketRequest.setBucketName(BUKETNSME);
            //设置读写权限
            bucketRequest.setCannedACL(CannedAccessControlList.PublicReadWrite);
            ossClient.createBucket(bucketRequest);

        }
        return ossClient;
    }

    /**
     * 上传文件
     * @param file 需要上传的文件
     * @param folderName oss文件夹名称
     * @return
     */
    public String uploadDocument(MultipartFile file,String folderName){
        //获取oss 连接
        OSSClient ossClient = this.getOSSClient();
        //获取文件的后缀名称
        String ext  = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String fileName = getFileName(folderName, ext);
        //通过ossclient 来获取后返回的url
        String url = "";
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(file.getBytes());
            ossClient.putObject(BUKETNSME,fileName,byteArrayInputStream);
            url = SUFFER_URL+fileName;
            log.info("------>>上传资料成功,oss地址为："+url);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            ossClient.shutdown();
        }

        return url;
    }

    private String getFileName(String folderName, String ext) {
        String date = simpleDateFormat.format(new Date());
        //判断是否为空
        if(StringUtils.isEmpty(folderName)){
            folderName = "imgs";
        }
        String uuid = UUID.randomUUID().toString().replace("-","");
        String filename = folderName+"/"+date+uuid+ext;
        return filename;
    }
//    下列为测试代码
//    public static void main(String[] args) throws IOException {
//        File f = new File("E:\\qqbrowser\\QQ浏览器截图20200222111338.png");
//        FileInputStream inputStream = new FileInputStream(f);
//        MultipartFile multipartFile = new MockMultipartFile("QQ浏览器截图20200222111338.png","QQ浏览器截图20200222111338.png","png",inputStream);
//        new OssUtil().uploadDocument(multipartFile,"imgs");
//    }
}
