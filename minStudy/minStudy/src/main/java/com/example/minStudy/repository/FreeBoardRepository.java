package com.example.minStudy.repository;

import com.example.minStudy.entity.FreeBoard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;

public interface FreeBoardRepository extends JpaRepository<FreeBoard,Integer> {

}
