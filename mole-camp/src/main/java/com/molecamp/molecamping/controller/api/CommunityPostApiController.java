package com.molecamp.molecamping.controller.api;

import com.google.gson.JsonObject;
import com.molecamp.molecamping.config.auth.UserDetail;
import com.molecamp.molecamping.dto.ResponseDto;
import com.molecamp.molecamping.entity.community.CommunityPost;
import com.molecamp.molecamping.service.community.CommunityPostService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@RestController
public class CommunityPostApiController {

    @Autowired
    private CommunityPostService communityPostService;


    //게시글 저장
    @PostMapping("/api/community/post")
    public ResponseDto<Integer> save(CommunityPost post, @AuthenticationPrincipal UserDetail principal){
        System.out.println("postSaveApi working");
        communityPostService.savePost(post,principal.getUser());
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    //게시글 수정
    @PutMapping("/api/community/update/{id}")
    public ResponseDto<Integer> update(@PathVariable int id,CommunityPost post){
        System.out.println("postUpdateApi working");
        System.out.println(post);
        communityPostService.updatePost(id,post);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    //게시글 삭제
    @DeleteMapping("/api/community/delete/{id}")
    public ResponseDto<Integer> delete(@PathVariable int id){
        System.out.println("postDeleteApi working");
        communityPostService.deletePost(id);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    //사진 외부 경로에 저장 및 경로 return
    @PostMapping("/community/post/uploadImage")
    @ResponseBody
    public JsonObject uploadSummernoteImageFile(@RequestParam("file") MultipartFile multipartFile) {

        JsonObject jsonObject = new JsonObject();

        String fileRoot = "C:\\summernote_image\\";	//저장될 파일 경로
        String originalFileName = multipartFile.getOriginalFilename();	//오리지날 파일명
        String extension = originalFileName.substring(originalFileName.lastIndexOf("."));	//파일 확장자

        // 랜덤 UUID+확장자로 저장될 savedFileName
        String savedFileName = UUID.randomUUID() + extension;

        File targetFile = new File(fileRoot + savedFileName);
        System.out.println(targetFile);

        try {
            InputStream fileStream = multipartFile.getInputStream();
            FileUtils.copyInputStreamToFile(fileStream, targetFile);	//파일 저장
            jsonObject.addProperty("url", "/summernoteImage/"+savedFileName);
            jsonObject.addProperty("responseCode", "success");
            System.out.println(jsonObject);

        } catch (IOException e) {
            FileUtils.deleteQuietly(targetFile);	// 실패시 저장된 파일 삭제
            jsonObject.addProperty("responseCode", "error");
            e.printStackTrace();
        }
        System.out.println("파일 업로드");
        return jsonObject;
    }
}
