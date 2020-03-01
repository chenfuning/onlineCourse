package com.ning.service.comment;

import com.ning.pojo.BO.CommentBO;
import com.ning.pojo.Comment;

import java.util.List;

public interface CommentService {
    /**
     * 根据课程id查询comment列表
     * @param courseId
     * @return
     */
    List<Comment> queryCommentsBycourseId(String courseId);

    void addComment(CommentBO commentBO);
}
