package com.dxc.community.utils;

import com.dxc.community.constant.WebConst;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.html.parser.Parser;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Extension;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * description: DuDuUtils <br>
 * date: 2020/3/12 16:07 <br>
 * author: duxuecheng <br>
 * version: 1.0 <br>
 */
public class DuDuUtils {
    /**
     * 匹配邮箱正则
     */
    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    /**
     * 判断是否是邮箱
     *
     * @param emailStr
     * @return
     */
    public static boolean isEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

    /**
     * md5加密
     *
     * @param source 数据源
     * @return 加密字符串
     */
    public static String MD5encode(String source) {
        if (StringUtils.isBlank(source)) {
            return null;
        }
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ignored) {
        }
        byte[] encode = messageDigest.digest(source.getBytes());
        StringBuilder hexString = new StringBuilder();
        for (byte anEncode : encode) {
            String hex = Integer.toHexString(0xff & anEncode);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }


//    /**
//     * markdown转换为html
//     *
//     * @param markdown
//     * @return
//     */
//    public static String mdToHtml(String markdown) {
//        if (StringUtils.isBlank(markdown)) {
//            return "";
//        }
//        java.util.List<Extension> extensions = Arrays.asList(TablesExtension.create());
//        Parser parser = Parser.builder().extensions(extensions).build();
//        Node document = parser.parse(markdown);
//        HtmlRenderer renderer = HtmlRenderer.builder().extensions(extensions).build();
//        String content = renderer.render(document);
//        content = Commons.emoji(content);
//        return content;
//    }
//
//    /**
//     * 返回当前登录用户
//     *
//     * @return
//     */
//    public static UserDomain getLoginUser(HttpServletRequest request) {
//        HttpSession session = request.getSession();
//        if (null == session) {
//            return null;
//        }
//        return (UserDomain) session.getAttribute(WebConst.LOGIN_SESSION_KEY);
//    }


    /**
     * 获取cookie中的用户id
     *
     * @param request
     * @return
     */
    public static Integer getCookieUid(HttpServletRequest request) {
        if (null != request) {
            Cookie cookie = cookieRaw(WebConst.USER_IN_COOKIE, request);
            if (cookie != null && cookie.getValue() != null) {
                try {
                    return  Integer.parseInt(cookie.getValue());
                   // String uid = Tools.deAes(cookie.getValue(), WebConst.AES_SALT);
                   // return StringUtils.isNotBlank(uid) && Tools.isNumber(uid) ? Integer.valueOf(uid) : null;
                } catch (Exception e) {
                }
            }
        }
        return null;
    }

    /**
     * 从cookies中获取指定cookie
     *
     * @param name    名称
     * @param request 请求
     * @return cookie
     */
    private static Cookie cookieRaw(String name, HttpServletRequest request) {
        javax.servlet.http.Cookie[] servletCookies = request.getCookies();
        if (servletCookies == null) {
            return null;
        }
        for (javax.servlet.http.Cookie c : servletCookies) {
            if (c.getName().equals(name)) {
                return c;
            }
        }
        return null;
    }

    /**
     * 设置记住密码cookie
     *
     * @param response
     * @param uid
     */
    public static void setCookie(HttpServletResponse response, Integer uid) {
        try {
            String val = Tools.enAes(uid.toString(), WebConst.AES_SALT);
            boolean isSSL = false;
            Cookie cookie = new Cookie(WebConst.USER_IN_COOKIE, val);
            cookie.setPath("/");
            cookie.setMaxAge(60 * 30);
            cookie.setSecure(isSSL);
            response.addCookie(cookie);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
