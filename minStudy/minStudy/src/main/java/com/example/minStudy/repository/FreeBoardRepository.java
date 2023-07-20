package com.example.minStudy.repository;

import com.example.minStudy.entity.FreeBoard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FreeBoardRepository extends JpaRepository<FreeBoard, Integer> {

    //select * from freeboard where title likr '%title%' or content like '%content%' limit 0,5;
    Page<FreeBoard> findByTitleContainingOrContentContaining(String title, String content, Pageable pageable);

    @Query("select board from FreeBoard board where idx=?1")
    FreeBoard myQuery(int idx);

}
