package com.exporter.controller;

import com.exporter.dto.ExcelFileDTO;
import com.exporter.service.impl.FileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;


@Controller
public class MainController {
    private static final Logger LOGGER = Logger.getLogger(MainController.class.getName());

    @Autowired
    private FileServiceImpl fileService;

    @PreAuthorize("isAuthenticated()")
    @RequestMapping("/")
    public ModelAndView showMainPage() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("fileList", get_user_files());
        return modelAndView;
    }

    @PreAuthorize("isAnonymous()")
    @RequestMapping("/login")
    public ModelAndView userLogin(@RequestParam(value = "failed", defaultValue = "false")boolean failed,
                                  @RequestParam(value = "error", defaultValue = "false")boolean error) {
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("failed", failed);
        modelAndView.addObject("error", error);
        return modelAndView;
    }

    @PreAuthorize("isAuthenticated()")
    @ResponseBody
    @RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Map<String, String> uploadFile(@RequestParam("file") MultipartFile file) {
        Map<String, String> answer = new HashMap<>();
        String contentType = file.getContentType();
        if (!file.isEmpty() && (contentType.contains("vnd.ms-excel") || contentType.contains("vnd.openxmlformats-officedocument.spreadsheetml.sheet"))) {
            try {
                answer = fileService.readFile(file);
            } catch (IOException e) {
                answer.put("status", "Some error occurred while getting bytes..");
            }
        } else {
            answer.put("status", "Unsupported file");
        }
        return answer;
    }

    @PreAuthorize("isAuthenticated()")
    @ResponseBody
    @RequestMapping(value = "/get_files_list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<ExcelFileDTO> get_user_files() {
        return fileService.getFilesList();
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/content", method = RequestMethod.GET)
    public ModelAndView showFileContent() {
        ModelAndView modelAndView = new ModelAndView("content");
        modelAndView.addObject("rowsList", fileService.getRowItems());
        return modelAndView;
    }

}
