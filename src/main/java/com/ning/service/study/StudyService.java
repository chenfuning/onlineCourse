package com.ning.service.study;

import com.ning.pojo.CourseUserStudy;

public interface StudyService {
    boolean queryStudy(CourseUserStudy courseUserStudy);

    void addstudycourse(CourseUserStudy courseUserStudy);
}
