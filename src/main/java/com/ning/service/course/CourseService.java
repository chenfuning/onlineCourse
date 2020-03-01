package com.ning.service.course;

import java.util.List;

import com.ning.pojo.Course;
import com.ning.pojo.CourseSort;
import com.ning.pojo.CourseUserZan;
import com.ning.pojo.CourseZj;

public interface CourseService {
	/**
	 * 查询所有第一导航栏的消息
	 * @return
	 */
	public List<CourseSort> queryfirstCode(int type);
	/**
	 * 通过课程分类id信息查询课程列表
	 * @param courSeid
	 * @return
	 */
	public List<Course> queryCourseListByClassify(String courSeid);
	/**
	 * 通过课程id查询课程章节列表
	 * @param courseId
	 * @return
	 */
	public List<CourseZj> queryCourseZjListBycourseId(String courseId);

	/**
	 * 根据课程的id查询课程简介信息
	 * @param courseId
	 * @return
	 */
    List<Course> queryCourseBycourseId(String courseId);

	/**
	 * 查询最新发布的三门好课
	 * @return
	 */
    List<Course> queryThreeCoursesByTime();

	/**
	 * 查询用户是否点赞
	 * @param courseUserZan
	 * @return
	 */
	boolean querycourseUserZanBycourseIdAndUserId(CourseUserZan courseUserZan);

    /**
     * 添加点赞
     * @param courseUserZan
     * @return
     */
	boolean addcourseUserZan(CourseUserZan courseUserZan);

    /**
     * 取消点赞
     * @param courseUserZan
     * @return
     */
    boolean delcourseUserZan(CourseUserZan courseUserZan);
}
