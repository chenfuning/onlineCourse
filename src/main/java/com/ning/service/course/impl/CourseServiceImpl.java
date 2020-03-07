package com.ning.service.course.impl;

import java.util.Comparator;
import java.util.Date;
import java.util.List;

import com.ning.mapper.CourseUserZanMapper;
import com.ning.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ning.mapper.CourseMapper;
import com.ning.mapper.CourseSortMapper;
import com.ning.mapper.CourseZjMapper;

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
    @Autowired
	private CourseUserZanMapper courseUserZanMapper;
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
		//结果根据sort排序
		result.sort(Comparator.comparing(CourseZj::getSort));
		return result;
	}

	@Override
	public List<Course> queryCourseBycourseId(String courseId) {
		Example courseExample=new Example(Course.class);
		Criteria criteria=courseExample.createCriteria();
		criteria.andLike("cid", courseId);
		List<Course> result=courseMapper.selectByExample(courseExample);
		return result;
	}

	@Override
	public List<Course> queryThreeCoursesByTime() {
		List<Course> result=courseMapper.queryThreeCoursesByTime();
		return result;
	}

	@Override
	public List<Course> queryThreeCoursesByZ() {
		List<Course> result=courseMapper.queryThreeCoursesByDZ();
		return result;
	}

	@Override
	public List<Course> queryThreeCoursesByGZ() {
		List<Course> result=courseMapper.queryThreeCoursesByGZ();
		return result;
	}

	@Override
	public boolean querycourseUserZanBycourseIdAndUserId(CourseUserZan courseUserZan) {
		Example CourseUserZanExample=new Example(CourseUserZan.class);
		Criteria criteria=CourseUserZanExample.createCriteria();
		criteria.andLike("courseid", courseUserZan.getCourseid());
		criteria.andLike("userid", courseUserZan.getUserid());
		List<CourseUserZan> courseUserZans=courseUserZanMapper.selectByExample(CourseUserZanExample);

		if(courseUserZans.size()>0)
			return true;
		else
			return false;
	}

	@Override
	public boolean addcourseUserZan(CourseUserZan courseUserZan) {
		courseUserZan.setCreatetime(new Date());
		courseUserZanMapper.insert(courseUserZan);
		return true;
	}

    @Override
    public boolean delcourseUserZan(CourseUserZan courseUserZan) {
        Example CourseUserZanExample=new Example(CourseUserZan.class);
        Criteria criteria=CourseUserZanExample.createCriteria();
        criteria.andLike("courseid", courseUserZan.getCourseid());
        criteria.andLike("userid", courseUserZan.getUserid());
	    int result=courseUserZanMapper.deleteByExample(CourseUserZanExample);

	    if(result==1)
        return true;
	    else
	    return false;
    }
}
