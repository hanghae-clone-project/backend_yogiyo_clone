package com.yogiyo.clone.domain.temporary_admin.controller;

import com.yogiyo.clone.domain.temporary_admin.service.AwsS3Uploader;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminImageController {

    private final AwsS3Uploader awsS3Uploader;

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        String fileName = awsS3Uploader.upload(multipartFile, "store");
        return fileName;
    }

    @DeleteMapping("/delete")
    public String delete(@RequestBody String fileName) throws IOException{
        awsS3Uploader.delete(fileName);
        return "이미지 삭제";
    }
}
