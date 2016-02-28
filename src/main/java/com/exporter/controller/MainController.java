package com.exporter.controller;

import com.exporter.model.ExcelFile;
import com.exporter.service.CustomerServiceImpl;
import com.exporter.service.ExcelFileServiceImpl;
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


@Controller
public class MainController {

    @Autowired
    private ExcelFileServiceImpl fileService;

    @Autowired
    private CustomerServiceImpl customerService;


    @PreAuthorize("isAuthenticated()")
    @RequestMapping("/")
    public ModelAndView showMainPage() {
        return new ModelAndView("index");
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
                answer = fileService.uploadFile(file);
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
    @RequestMapping(value = "/get_user_files_list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<ExcelFile> get_user_files() {
        return customerService.getCurrentCustomerFilesList();
    }

}
