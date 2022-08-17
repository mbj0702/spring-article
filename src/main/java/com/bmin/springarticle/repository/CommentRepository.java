package com.bmin.springarticle.repository;

import com.bmin.springarticle.entity.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long> {
}
