package com.itheima.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.utils.JSONFileUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.net.URLEncoder;
import java.util.*;
@Controller
public class FileController {
    @RequestMapping("fileUpLoad")
    public String fileUpLoad(@RequestParam("file") MultipartFile file,
                             HttpServletRequest request)  {
        try {
            //上传的文件所存放的路径
            String path = request.getServletContext().getRealPath("/WEB-INF/files/");
            //记录文件的路径
            File jsonFile = new File(path + "files.json");
            ObjectMapper mapper = new ObjectMapper();
            //获取上传文件的名称
            String filename = file.getOriginalFilename();
            //读取files.json文件的内容
            String json = JSONFileUtils.readFile(jsonFile.getPath());
            Map<String, List<String>> map = new HashMap<>();
            List<String> names = new ArrayList<>();
            //如果记录文件中已经有记录，则判断是否存在同名的文件
            if (jsonFile.length() > 0) {
                //将files.json的内容转为集合
                map = mapper.readValue(json, Map.class);
                // 判断上传文件的名称在files.json中是否存在
                names = map.get("names");
                //如果有同名文件
                if (names.contains(filename)) {
                    request.setAttribute("msg", "(存在同名文件，上传失败，请重新上传！)");
                    return "file";
                }
            }
            //将上传文件的名称添加到集合中
            names.add(filename);
            //将文件名称的集合添加到map中
            map.put("names", names);
            // 保存上传的文件
            file.transferTo(new File(path + filename));
            //将map转换成JSON格式
            json = mapper.writeValueAsString(map);
            //将最新的文件名称信息保存在files.json文件中
            JSONFileUtils.writeFile(json, jsonFile.getPath());
            request.setAttribute("msg", "(上传成功)");
            return "file";
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("msg", "(上传失败)");
            return "file";
        }

    }

    @ResponseBody
    @RequestMapping(value = "/getFilesName",
            produces = "text/html;charset=utf-8")
    public String getFilesName(HttpServletRequest request,
                               HttpServletResponse response) throws Exception {
        String path = request.getServletContext().
                getRealPath("/WEB-INF/files/files.json");
        String json = JSONFileUtils.readFile(path);
        return json;
    }

    /**
     * 文件下载
     */
    @RequestMapping("/downLoad")
    public ResponseEntity<FileSystemResource> fileDownload(HttpServletRequest request,
                                                           @RequestParam("filename")String filename) throws Exception {
        // 要下载文件所在的路径
        String path = request.getServletContext().getRealPath("/WEB-INF/files/");
        // 要下载的文件
        File file = new File(path + File.separator + filename);
        // 创建响应头对象
        HttpHeaders headers = new HttpHeaders();
        //设置下载时文件名的编码
        String encodedFilename=URLEncoder.encode(filename,"UTF-8").replaceAll("\\+","%20");
        //设置Content-Disposition响应头的内容
        headers.setContentDispositionFormData("attachment",encodedFilename);
        // 定义以流的形式下载返回文件数据
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        FileSystemResource resource = new FileSystemResource(file);
        // 返回下载的数据
        return ResponseEntity.ok()
                .headers(headers)
                .body(resource);
    }
}
