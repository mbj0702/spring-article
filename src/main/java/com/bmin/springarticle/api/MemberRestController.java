package com.bmin.springarticle.api;

import com.bmin.springarticle.entity.Member;
import com.bmin.springarticle.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
@CrossOrigin("*")
@Slf4j
public class MemberRestController {

    @Autowired
    MemberService memberService;

    public MemberRestController() {

    }

    @RequestMapping("/list/all")
    public List<Member> allMembers() {

        log.info("show the list of members");

        return memberService.allMembers();
    }


    @PostMapping("/add")
    public Member addMember(@RequestBody Member member) {

        log.info("add a new member");

        return memberService.addMember(member);
    }

}
