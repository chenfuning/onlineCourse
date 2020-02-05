package com.ning.service.course.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ning.mapper.CourseMapper;
import com.ning.mapper.CourseSortMapper;
import com.ning.mapper.CourseZjMapper;
import com.ning.pojo.Course;
import com.ning.pojo.CourseSort;
import com.ning.pojo.CourseZj;
import com.ning.pojo.User;

import com.ning.service.course.CourseService;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
	private CourseSortMapper courseSortMapping;
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private CourseZjMapper courseZjMapper;
	@Override
	public List<CourseSort> queryfirstCode(int type) {
		Example courseSortExample=new Example(CourseSort.class);
		Criteria criteria=courseSortExample.createCriteria();
		if(type==0) 
		criteria.andEqualTo("parentCode", 0);
		else
		criteria.andNotEqualTo("parentCode", 0);
		List<CourseSort> result=courseSortMapping.selectByExample(courseSortExample);
		
		return result;
	}
	@Override
	public List<Course> queryCourseListByClassify(String courSeid) {
		Example courseExample=new Example(Course.class);
		Criteria criteria=courseExample.createCriteria();
		criteria.andLike("classify", courSeid);
		List<Course> result=courseMapper.selectByExample(courseExample);
		return result;
	}
	@Override
	public List<CourseZj> queryCourseZjListBycourseId(String courseId) {
		Example courseZJExample=new Example(CourseZj.class);
		Criteria criteria=courseZJExample.createCriteria();
		criteria.andLike("courseId", courseId);
		List<CourseZj> result=courseZjMapper.selectByExample(courseZJExample);
		return result;
	}
}
