package com.bmin.springarticle.service;

import com.bmin.springarticle.entity.Member;
import com.bmin.springarticle.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public List<Member> allMembers() {

        final List<Member> findAllMembers = (ArrayList)memberRepository.findAll();

        return findAllMembers;
    }


    public Member addMember(Member newMember) {

        newMember.setCreatedDate(LocalDate.now());

        return memberRepository.save(newMember);

    }
}
