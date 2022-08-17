package com.bmin.springarticle.repository;

import com.bmin.springarticle.entity.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, Long> {
}
