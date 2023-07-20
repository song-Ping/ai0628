package com.example.minStudy.service;

import com.example.minStudy.dto.FreeBoardDto;
import com.example.minStudy.entity.FreeBoard;
import com.example.minStudy.repository.FreeBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FreeBoardService {
    @Autowired
    FreeBoardRepository freeBoardRepository;

    public Page<FreeBoard> list(String searchText, String SearchText,Pageable pageable) {
//        Pageable pageable = PageRequest.of(0,5, Sort.by("idx").descending());
        Page<FreeBoard> pagelist = freeBoardRepository.findByTitleContainingOrContentContaining(
                searchText, SearchText, pageable);

//        System.out.println(pagelist.getContent());
        return pagelist;
    }

    public boolean insert(FreeBoardDto dto) {
        FreeBoard freeBoardEntity = freeBoardRepository.findById(dto.getIdx()).orElse(new FreeBoard());
        freeBoardEntity.setContent(dto.getContent());
        freeBoardEntity.setName(dto.getName());
        freeBoardEntity.setTitle(dto.getTitle());
        freeBoardRepository.save(freeBoardEntity);
        return true;
    }
    public FreeBoardDto getRow(FreeBoardDto freeBoardDto) {
        FreeBoard freeBoard = freeBoardRepository.findById(freeBoardDto.getIdx())
                .orElse(new FreeBoard());
        return FreeBoardDto.of(freeBoard);
    }
}
