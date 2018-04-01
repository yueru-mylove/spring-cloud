package com.miracle.cloud.controller;


import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class FileUploadController {


    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody
    String upload(@RequestParam(value = "file", required = true) MultipartFile file) {
        byte[] bytes = new byte[0];
        File fileToSave = null;
        try {
            bytes = file.getBytes();
            fileToSave = new File(file.getOriginalFilename());
            FileCopyUtils.copy(bytes, fileToSave);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileToSave.getAbsolutePath();
    }

}
