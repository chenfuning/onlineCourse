package com.ning.service.study.impl;

import com.ning.mapper.CourseUserStudyMapper;
import com.ning.pojo.CourseUserStudy;
import com.ning.pojo.CourseUserZan;
import com.ning.service.study.StudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Service
public class StudyServiceImpl implements StudyService {
    @Autowired
    private CourseUserStudyMapper courseUserStudyMapper;
    @Override
    public boolean queryStudy(CourseUserStudy courseUserStudy) {
        Example CourseUserStudyExample=new Example(CourseUserStudy.class);
        Example.Criteria criteria=CourseUserStudyExample.createCriteria();
        criteria.andLike("courseid", courseUserStudy.getCourseid());
        criteria.andLike("userid", courseUserStudy.getUserid());
        List<CourseUserStudy> courseUserStudys=courseUserStudyMapper.selectByExample(CourseUserStudyExample);
        if(courseUserStudys.size()>0)
            return true;
        else
            return false;
    }

    @Override
    public void addstudycourse(CourseUserStudy courseUserStudy) {
        courseUserStudy.setCreatetime(new Date());
        courseUserStudyMapper.insert(courseUserStudy);
        System.out.println("1");
    }
}
