package com.ning.controller;

import com.ning.pojo.CourseUserStudy;
import com.ning.pojo.CourseUserZan;
import com.ning.service.study.StudyService;
import com.ning.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("s")
public class StudyController {
    @Autowired
    private StudyService studyService;
    @PostMapping("/querystudy")
    public JSONResult querystudy(@RequestBody CourseUserStudy courseUserStudy) {
        boolean result=studyService.queryStudy(courseUserStudy);
        return JSONResult.ok(result);
    }
    @PostMapping("/addstudycourse")
    public JSONResult addstudycourse(@RequestBody CourseUserStudy courseUserStudy) {
        studyService.addstudycourse(courseUserStudy);
        return JSONResult.ok();
    }
}
