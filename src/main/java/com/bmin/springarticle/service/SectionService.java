package com.bmin.springarticle.service;

import com.bmin.springarticle.entity.Section;
import com.bmin.springarticle.repository.SectionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class SectionService {

    @Autowired
    private SectionRepository sectionRepository;

    public List<Section> allSections() {

        final List<Section> findAllSections = (ArrayList)sectionRepository.findAll();

        return findAllSections;
    }

    public Section addSection(Section section) {

//        Section newSection = new Section(title);

        return sectionRepository.save(section);
    }
}
