package com.example.tutorials.repository;


import com.example.tutorials.model.TutorialsVO;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface TutorialRepository extends MongoRepository<TutorialsVO, String> {
    List<TutorialsVO> findByPublishedTrue();
    List<TutorialsVO> findAll();
    Optional<TutorialsVO> getTutorialById(String id);
    List<TutorialsVO> findByTitleContaining(String title);
    List<TutorialsVO> findByPublished(Boolean published);

}
