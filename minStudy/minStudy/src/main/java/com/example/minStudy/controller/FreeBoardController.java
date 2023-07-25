package com.example.minStudy.controller;

import com.example.minStudy.dto.FreeBoardDto;
import com.example.minStudy.entity.FreeBoard;
import com.example.minStudy.repository.FreeBoardRepository;
import com.example.minStudy.service.FreeBoardService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/FreeBoard")
public class FreeBoardController {

    @Autowired
    FreeBoardService freeBoardService;

    @Autowired
    FreeBoardRepository freeBoardRepository;

    @GetMapping("Delete")
    public @ResponseBody String delete(FreeBoardDto freeBoardDto) {
        System.out.println(freeBoardDto);
        freeBoardRepository.deleteById(freeBoardDto.getIdx());
        return "success";//delete라는 문자열을 view.html에 스크립트부분에서 담아감
    }

    @GetMapping("View")
    public String view(@ModelAttribute @Valid FreeBoardDto freeBoardDto, BindingResult bindingResult, Model model) {
        System.out.println("idx = " + freeBoardDto.getIdx());

        FreeBoardDto dto = freeBoardService.getRow(freeBoardDto);
        model.addAttribute("freeBoardDto", dto);
        return "freeboard/view";
    }


    @GetMapping("WriteForm")
    public String writeForm(@ModelAttribute @Valid FreeBoardDto freeBoardDto, BindingResult bindingResult) {
        return "freeboard/writeform";
    }

    @GetMapping("UpdateForm")
    public String UpdateForm(@ModelAttribute @Valid FreeBoardDto freeBoardDto, BindingResult bindingResult, Model model) {
        System.out.println(freeBoardDto);

        FreeBoardDto dto = freeBoardService.getRow(freeBoardDto);
        model.addAttribute("freeBoardDto", dto);

        return "freeboard/updateform";
    }

    @PostMapping("WriteForm")
    public String pwriteForm(@ModelAttribute @Valid FreeBoardDto freeBoardDto, BindingResult bindingResult, Model model, HttpServletRequest request,
                             HttpSession session,
                             Authentication authentication) {
        System.out.println(request.getParameter("title"));
        System.out.println(session.getAttribute("username"));

        System.out.println("authentication = " + authentication);
        System.out.println("authentication = " + authentication.getPrincipal());
        if (authentication != null) {
            User user = (User) authentication.getPrincipal();
            freeBoardDto.setName(user.getUsername());
        }

        if (bindingResult.hasErrors()) {
            System.out.println("사이즈 문제 있음");
//            model.addAttribute("freeboarddto",dto);
            return "freeboard/writeform";
        } else {
            System.out.println(freeBoardDto);
            boolean result = freeBoardService.insert(freeBoardDto);
            if (result)
                return "redirect:/FreeBoard";
        }
        return "freeboard/writeform";
    }

    @PostMapping("UpdateForm")
    public String pUpdateForm(@ModelAttribute @Valid FreeBoardDto freeBoardDto, BindingResult bindingResult, Model model, Authentication authentication) {
        if (authentication != null) {
            User user = (User) authentication.getPrincipal();
            freeBoardDto.setName(user.getUsername());
        }
        if (bindingResult.hasErrors()) {
            System.out.println("사이즈 문제 있음");
//            model.addAttribute("freeboarddto",dto);
            return "freeboard/updateform";
        } else {
            System.out.println(freeBoardDto);
            boolean result = freeBoardService.insert(freeBoardDto);
            if (result)
                return "redirect:/FreeBoard";
        }
        return "freeboard/updateform";
    }

    @GetMapping("")
    public String index(Model model, @PageableDefault(
            size = 5,
            sort = "idx",
            direction = Sort.Direction.DESC,
            page = 0) Pageable pageable,
                        @RequestParam(required = false, defaultValue = "0") int page
            , @RequestParam(required = false, defaultValue = "") String searchText) {
        Page<FreeBoard> pagelist = freeBoardService.list(searchText, searchText, pageable);
//
////        총 행갯수
//        System.out.println(pagelist.getTotalElements());
////        총 페이지 갯수
//        System.out.println(pagelist.getTotalPages());

        List<FreeBoardDto> dtolist = new ArrayList<>();
        for (FreeBoard fb : pagelist) {
            FreeBoardDto dto = FreeBoardDto.of(fb);
            dtolist.add(dto);
        }

//        System.out.println(list);
        model.addAttribute("curPage", page + 1);
        model.addAttribute("totalPages", pagelist.getTotalPages());
        model.addAttribute("totalElements", pagelist.getTotalElements());

        model.addAttribute("list", dtolist);
        return "freeboard/index";
    }

}
