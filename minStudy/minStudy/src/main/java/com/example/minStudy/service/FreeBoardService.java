package com.example.minStudy.service;

import com.example.minStudy.dto.FreeBoardDto;
import com.example.minStudy.entity.FreeBoard;
import com.example.minStudy.repository.FreeBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FreeBoardService {

    @Autowired
    FreeBoardRepository freeBoardRepository;

    public List<FreeBoardDto> list() {
        //db에가서 select 해서 내용을 가지고 와서 list에 담는다
        //Page(=list)컬렉션과 제네릭
        Page<FreeBoard> pagelist = freeBoardRepository.findAll(PageRequest.of(0,5));
        //list에 담긴 freeboard를 freeboarddto로 변경해서 list에 다시 담는다.
        System.out.println("page = " + pagelist.toList());
        List<FreeBoard> dblist = pagelist.stream().toList();
        List<FreeBoardDto> dtolist = new ArrayList<>();
        for(FreeBoard fb : dblist){
            FreeBoardDto dto = FreeBoardDto.of(fb);
            dtolist.add(dto);
        }
        return dtolist;
    }
}
