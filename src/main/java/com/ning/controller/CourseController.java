package com.ning.controller;

import java.util.Iterator;
import java.util.List;

import com.ning.pojo.CourseUserZan;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
	 * @param csvideoListId
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

	/**
	 * 根据课程的id查询课程简介信息
	 * @param courseId
	 * @return
	 */
	@PostMapping("/querycourse")
	public JSONResult querycourse(String courseId) {
		List<Course> result=courseService.queryCourseBycourseId(courseId);
		return JSONResult.ok(result);
	}

	/**
	 * 查询最新发布的三门好课
	 * @return
	 */
	@PostMapping("/queryThreeCoursesByTime")
	public JSONResult queryThreeCoursesByTime() {
		List<Course> result=courseService.queryThreeCoursesByTime();
		return JSONResult.ok(result);
	}

	/**
	 * 查询最多赞的三门好课
	 * @param
	 * @return
	 */
	@PostMapping("/queryThreeCoursesByZ")
	public JSONResult queryThreeCoursesByZ() {
		List<Course> result=courseService.queryThreeCoursesByZ();
		return JSONResult.ok(result);
	}

	/**
	 * 查询最关注的三门好课
	 * @return
	 */
	@PostMapping("/queryThreeCoursesByGZ")
	public JSONResult queryThreeCoursesByGZ() {
		List<Course> result=courseService.queryThreeCoursesByGZ();
		return JSONResult.ok(result);
	}

	/**
	 * 查询用户是否点赞
	 * @param courseUserZan
	 * @return
	 */
	@PostMapping("/querycourseZ")
	public JSONResult querycourseZ(@RequestBody CourseUserZan courseUserZan) {
		boolean result=courseService.querycourseUserZanBycourseIdAndUserId(courseUserZan);
		return JSONResult.ok(result);
	}


    /**
     * 添加点赞
     * @param courseUserZan
     * @return
     */
	@PostMapping("/addzan")
	public JSONResult addzan(@RequestBody CourseUserZan courseUserZan) {
		boolean result=courseService.addcourseUserZan(courseUserZan);
		return JSONResult.ok(result);
	}

    /**
     * 取消点赞
     * @param courseUserZan
     * @return
     */
    @PostMapping("/delzan")
    public JSONResult delzan(@RequestBody CourseUserZan courseUserZan) {
        boolean result=courseService.delcourseUserZan(courseUserZan);
        return JSONResult.ok(result);
    }




}
