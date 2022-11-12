package com.bmin.springarticle.api;

import com.bmin.springarticle.entity.Section;
import com.bmin.springarticle.service.SectionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/section")
@CrossOrigin("*")
@Slf4j
public class SectionRestController {

    @Autowired
    SectionService sectionService;

    public SectionRestController() {

    }

    @RequestMapping("/list/all")
    public List<Section> allSections() {

        log.info("show the list of sections");

        return sectionService.allSections();
    }

    @PostMapping("/add")
    public Section addSection(@RequestBody Section section) {

        log.info("add a new section");

        return sectionService.addSection(section);
    }
}
