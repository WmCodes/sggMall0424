package xyz.drafter.gmall0424.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import xyz.drafter.gmall0424.util.FastDFSClientWrapper;

/**
 * @author drafter
 * @date 2020/4/27
 * @desciption
 */
@RestController
public class FileUploadController {

    @Value("${fileServer.url}")
    private String fileUlr;

    @Autowired
    private FastDFSClientWrapper fastDFSClientWrapper;


    @RequestMapping("fileUpload")
    public String fileUpload(MultipartFile file) throws Exception{
        if (file != null){
            byte[] bytes = file.getBytes();
            String originalFileName = file.getOriginalFilename();
            String extension = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
            String fileName = file.getName();
            long fileSize = file.getSize();
            System.out.println(originalFileName + "==========" + fileName + "===========" + fileSize + "===============" + extension + "====" + bytes.length);
            return fileUlr + fastDFSClientWrapper.uploadFile(bytes, fileSize, extension);
        }else {
            return "";
        }
    }
}
