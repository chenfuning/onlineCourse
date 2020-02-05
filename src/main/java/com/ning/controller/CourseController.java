package com.ning.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ning.pojo.Course;
import com.ning.pojo.CourseSort;
import com.ning.pojo.CourseZj;

import com.ning.service.course.CourseService;
import com.ning.utils.JSONResult;

@RestController
@RequestMapping("c")
public class CourseController {
	@Autowired
	private CourseService courseService;
	
	/**
	 * 返回所有的课程第一菜单
	 * 
	 * @return
	 */
	@PostMapping("/querycourselist")
	public JSONResult querycourselist(int type) {
		
			// onlinecourse code为1，parent_code为0,二级parentcode！=0
		List<CourseSort> courseSortList = courseService.queryfirstCode(type);
//	    Iterator i = courseSortList.iterator();
//      while(i.hasNext())
//          System.out.println("我的值"+i.next().toString()+"type"+type);
		return JSONResult.ok(courseSortList);
		
	}
	/**
	 * 查询classify等于courSeid的courseList集合
	 * @param courSeid
	 * @return
	 */
	@PostMapping("/queryVideoLists")
	public JSONResult queryVideoLists(String csvideoListId) {
		List<Course> result=courseService.queryCourseListByClassify(csvideoListId);
		return JSONResult.ok(result);
	}
	/**
	 * 根据课程的id查询章节的所有信息
	 * @param courseId
	 * @return
	 */
	@PostMapping("/queryFirstVideo")
	public JSONResult queryFirstVideo(String courseId) {
		List<CourseZj> result=courseService.queryCourseZjListBycourseId(courseId);
		return JSONResult.ok(result);
	}
}
