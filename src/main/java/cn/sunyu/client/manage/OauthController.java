package cn.sunyu.client.manage;

import cn.hutool.http.HttpUtil;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * @Author: hrqx
 * @Date: 2019/4/3 15:45
 */
@RestController
public class OauthController {
    private final static org.slf4j.Logger log = LoggerFactory.getLogger(OauthController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getToken(@RequestParam String code, HttpServletRequest request, HttpServletResponse response) {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("grant_type", "authorization_code");
        paramMap.put("code", code);
        paramMap.put("client_id", "declaration");
        paramMap.put("client_secret", "oauth_client_secret");
        //客户端回调地址
        paramMap.put("redirect_uri", "http://192.168.59.128/");
        //资源服务器认证地址（此时资源服务器为认证服务器）
        String token = null;
        try {
            token = HttpUtil.post("http://192.168.59.1:8080/oauth/token", paramMap);

            System.err.println("===========================token" + token + "token===========================");
            System.err.println("===========================token" + token + "token===========================");
            System.err.println("===========================token" + token + "token===========================");
        } catch (Exception e) {
            System.err.println("==========================="+e.getMessage()+"===========================");
            System.err.println("==========================="+e.getMessage()+"===========================");
            System.err.println("==========================="+e.getMessage()+"===========================");
            log.error(e.getMessage());
        }
        return token;
    }

}
