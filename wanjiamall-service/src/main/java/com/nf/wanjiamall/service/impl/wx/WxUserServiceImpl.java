package com.nf.wanjiamall.service.impl.wx;

import com.nf.wanjiamall.dao.UserDao;
import com.nf.wanjiamall.entity.UserEntity;
import com.nf.wanjiamall.service.wx.WxUserService;
import com.nf.wanjiamall.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author lrc
 */
@Service
@Slf4j
public class WxUserServiceImpl implements WxUserService {
    @Autowired
    private UserDao userDao;

    @Override
    public Object getWxUserOpenid(String code) throws IOException {

        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=wxb2d02e2e5e9cbd4f" +
                "&secret=493c4f274ca8c9a51f737ab3e33d68f7&js_code="+code+"&grant_type=authorization_code";
        JSONObject jsonObject =doGetJson(url);
        String openid = jsonObject.getString("openid");
        String openId = openid.substring(0,16);
        UserEntity userEntity  = userDao.getOpenId(openId);
        if( jsonObject != null){
            if (userEntity == null){
                if (userDao.userInsert(openId) > 0){
                    return ResponseUtil.ok();
                }else {
                    return ResponseUtil.fail(505,"添加失败");
                }
            }
            return ResponseUtil.ok(userEntity);
        }else{
            return ResponseUtil.fail(505,"用户不存在");
        }
    }

    public  JSONObject doGetJson(String url) throws IOException {
        JSONObject jsonObject = null;
        DefaultHttpClient client = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);
        HttpResponse response = client.execute(httpGet);
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            String result = EntityUtils.toString(entity, "UTF-8");
            jsonObject = JSONObject.fromObject(result);
        }
        httpGet.releaseConnection();
        return jsonObject;
    }


    


}
