package com.dxc.community.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

/**
 * description: ImageDTO <br>
 * date: 2020/4/13 10:51 <br>
 * author: duxuecheng <br>
 * version: 1.0 <br>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UploadResultDTO {
    // success : 0 | 1,           // 0 表示上传失败，1 表示上传成功
    //    message : "提示的信息，上传成功或上传失败及错误信息等。",
    //    url     : "图片地址"        // 上传成功时才返回
    private Integer success;
    private String message;
    private String url;


    public static UploadResultDTO success(String message, String url) {
        if (StringUtils.isBlank(message))
            message = "上传成功";
        return new UploadResultDTO(1, message, url);
    }


    public static UploadResultDTO fail(String message, String url) {
        if (StringUtils.isBlank(message))
            message = "上传失败";
        return new UploadResultDTO(0, message, url);
    }
}
