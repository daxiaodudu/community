package com.dxc.community.controller;

import com.dxc.community.constant.ErrorConstant;
import com.dxc.community.constant.WebConst;
import com.dxc.community.dto.UploadResultDTO;
import com.dxc.community.exception.BusinessException;
import com.dxc.community.pojo.UserDomain;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.Iterator;
import java.util.List;

/**
 * description: UploadController <br>
 * date: 2020/4/13 10:22 <br>
 * author: duxuecheng <br>
 * version: 1.0 <br>
 */
@RestController
public class UploadController {

    @PostMapping("/uploadImg")
    public Object uploadImg(HttpServletRequest httpServletRequest,
                            String guid) throws IOException {
        UserDomain userDomain = (UserDomain) httpServletRequest.getSession()
                .getAttribute(WebConst.LOGIN_SESSION_KEY);
        if (userDomain == null)
            throw new BusinessException(ErrorConstant.Common.LOGIN_IS_EMPTY);
        //系统当前目录
        String properties = System.getProperty("user.dir");
        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) httpServletRequest;

        Iterator<String> fileNames = multipartHttpServletRequest.getFileNames();

        String basicfileName = properties + "/src/main/resources/static/images/";
        String fileUrl = "/images/";
        while (fileNames.hasNext()) {
            String fileName = fileNames.next();
            MultipartFile file = multipartHttpServletRequest.getFile(fileName);
            InputStream inputStream = file.getInputStream();
         //   ((StandardMultipartHttpServletRequest.StandardMultipartFile) file).filename

            OutputStream outputStream = new FileOutputStream(basicfileName +  file.getOriginalFilename());
            fileUrl +=  file.getOriginalFilename();
            byte[] bytes = new byte[1024];
            while (inputStream.read(bytes) != -1) {
                outputStream.write(bytes);
            }

            outputStream.flush();
            outputStream.close();
            inputStream.close();
        }


        UploadResultDTO uploadResultDTO = UploadResultDTO.success("", fileUrl);


        //    file.transferTo();
        return uploadResultDTO;
    }
}
