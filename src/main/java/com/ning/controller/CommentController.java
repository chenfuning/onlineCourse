package com.ning.controller;

import com.ning.mapper.CommentMapper;
import com.ning.pojo.BO.CommentBO;
import com.ning.pojo.Comment;
import com.ning.pojo.Course;
import com.ning.service.comment.CommentService;
import com.ning.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("comment")
public class CommentController {
    @Autowired
    private CommentService commentService;
    @PostMapping("/querycomments")
    public JSONResult querycomments(String courseId) {
        List<Comment> result=commentService.queryCommentsBycourseId(courseId);
        return JSONResult.ok(result);
    }
    @PostMapping("/addComment")
    public JSONResult addComment(@RequestBody CommentBO commentBO){
        System.out.println("1");
        commentService.addComment(commentBO);
        return JSONResult.ok("发布成功，等待审核");
    }

}
