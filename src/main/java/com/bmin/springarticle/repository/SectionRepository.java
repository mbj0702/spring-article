package com.bmin.springarticle.repository;

import com.bmin.springarticle.entity.Article;
import com.bmin.springarticle.entity.Section;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionRepository extends CrudRepository<Section, Long> {
}
