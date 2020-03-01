package com.ning.service.comment.impl;

import com.ning.mapper.CommentMapper;
import com.ning.pojo.BO.CommentBO;
import com.ning.pojo.Comment;
import com.ning.pojo.Course;
import com.ning.service.comment.CommentService;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private Sid sid;
    @Override
    public List<Comment> queryCommentsBycourseId(String courseId) {
        Example commentExample=new Example(Comment.class);
        Example.Criteria criteria=commentExample.createCriteria();
        criteria.andLike("commentcourseid", courseId);
        List<Comment> result=commentMapper.selectByExample(commentExample);
        return result;
    }

    @Override
    public void addComment(CommentBO commentBO) {
        Comment comment=new Comment();
//        String userid=commentBO.getUserid();
//        String username=commentBO.getUsername();
//        String course=commentBO.getCourse();
//        String msgtextComent=commentBO.getMsgtextComent();
        String commentId=sid.nextShort();
        comment.setCommentid(commentId);
        comment.setCommentcontent(commentBO.getMsgtextComent());
        comment.setCommentcourseid(commentBO.getCourse());
        comment.setCommentusernameid(commentBO.getUserid());
        comment.setCommentusername(commentBO.getUsername());
        comment.setCommenttime(new Date());
        //默认不让发布，要通过审核
        comment.setCommentstatus(false);
        commentMapper.insertSelective(comment);
    }

}
