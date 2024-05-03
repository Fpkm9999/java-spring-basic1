package com.example.spring_basic.controller;

import com.example.spring_basic.dto.BoardDTO;
import com.example.spring_basic.dto.PasswdDTO;
import com.example.spring_basic.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 게시판 관련 HTTP 요청을 처리하는 컨트롤러.<br>
 * 게시판의 게시글 추가, 목록 조회 등의 요청을 처리합니다.
 */
@Log4j2
@Controller
@RequestMapping("/board")
@RequiredArgsConstructor // 생성자 주입을 통해 필수 의존성을 자동 주입받습니다.
public class BoardController {

    private final BoardService boardService; // 게시판 서비스 의존성


    /**
     * 게시글 추가 페이지로의 접근을 처리하는 메소드.
     * URL '/board/add'에 대한 GET 요청을 처리합니다.
     */
    @GetMapping("/add")
    public void add() {
        log.info("board/add 페이지 접속 성공");
    }

    /**
     * 게시글 추가 요청을 처리하는 메소드.
     * URL '/board/add'에 대한 POST 요청을 처리하며, 폼으로부터 받은 데이터를 게시글로 등록합니다.
     *
     * @param boardDTO 폼에서 전달된 게시글 데이터를 담은 DTO
     * @return 리다이렉트 URL, 게시글 리스트 페이지로 리다이렉션
     */
    @PostMapping("/add")
    public String addPost(BoardDTO boardDTO) {
        log.info("board/add post() 접속 성공!");
        log.info("DTO 값 확인 : " + boardDTO);

        boardService.register(boardDTO);

        return "redirect:/board/list";
    }

    /**
     * 게시글 목록 페이지로의 접근을 처리하는 메소드.
     * URL '/board/list'에 대한 GET 요청을 처리합니다.
     * 모든 게시글을 조회하여 모델에 추가합니다.
     *
     * @param model 뷰에 데이터를 전달하기 위한 모델 객체
     */
    @GetMapping("/list")
    public void list(Model model) {
        log.info("list 페이지 접근");

        log.info("BoardDTO list...");
        model.addAttribute("dtoList", boardService.getAll());
    }


    /**
     * 특정 게시글의 상세 정보 페이지로의 접근을 처리하는 메소드.<br>
     * URL '/board/read'에 대한 GET 요청을 처리합니다.<br>
     * 요청된 게시글 번호에 해당하는 게시글을 조회하여 모델에 추가합니다.<br><br>
     *
     * @param model 뷰에 데이터를 전달하기 위한 모델 객체<br>
     * @param no    게시글 번호
     */

    @GetMapping("/read")
    public void read(Model model, Integer no) {
        log.info("read 페이지 접근");

        log.info("BoardDTO getOne()...");
        model.addAttribute("dto", boardService.getOne(no));
    }

    /**
     * 게시글 수정 페이지로의 접근을 처리하는 메소드.<br>
     * URL '/board/modify'에 대한 GET 요청을 처리합니다.<br>
     * 요청된 게시글 번호에 해당하는 게시글을 조회하여 모델에 추가합니다.<br><br>
     *
     * @param model 뷰에 데이터를 전달하기 위한 모델 객체<br>
     * @param no    게시글 번호
     */
//    @GetMapping("/modify")
//    public void modify(Model model, Integer no) {
//        log.info("modify 페이지 접근");
//
//        BoardDTO boardDTO = boardService.getOne(no);
//        model.addAttribute("dto", boardDTO);
//
//    }

    /**
     * 게시글 수정을 처리하는 메소드<br>
     * URL '/board/modify'에 대한 POST 요청을 처리합니다.<br>
     * 폼으로부터 받은 데이터를 사용하여 게시글을 수정합니다.<br><br>
     *
     * @param boardDTO 수정할 게시글 데이터를 담은 DTO
     */
    @PostMapping("/modify")
    public void modifyPost(BoardDTO boardDTO) {
        log.info("DTO 객체 정보 : " + boardDTO);

        boardService.modify(boardDTO);
    }

    /**
     * 게시판 삭제 요청을 처리하는 메소드<br>
     * URL : /board/remove 에 대한 POST 요청을 처리합니다.<br>
     * 폼으로부터 받은 게시글 번호를 사용하여 게시글을 삭제합니다.<br><br>
     *
     *
     * @param no | 삭제할 게시글 정보를 담은 boardDTO 객체<br>
     * @return /board/list 로 리다이렉트
     *
     * @deprecated Get방식으로도 요청을 처리하기 위해 RequestMapping으로 변경함
     */
//    @PostMapping("/remove")
//    public String removePost(Integer no){
//        log.info("board removePost()...");
//        log.info("게시판 삭제 ing");
//        boardService.removeOne(no);
//
//        return "redirect:/board/list";
//    }


    /**
     *
     * 1)
     * @param no
     * @param request
     * @param redirectAttributes
     * @return
     * @deprecated 아래에 3.4. 추가된 방식을 사용함
     */
//    @RequestMapping("/remove")
//    public String removePost(Integer no, HttpServletRequest request, RedirectAttributes redirectAttributes) {
//        log.info("board removerReQuestMapping()...");
//
//        // 1. 세션에 저장된 비밀번호를 불러옴.
//        HttpSession session = request.getSession();
//        String passwd = (String) session.getAttribute("passwd");
//
//        // 2. 비밀번호가 없으면 비밀번호 입력 페이지로 리다이렉트
//        if (passwd == null || passwd.isEmpty()) {
//            redirectAttributes.addAttribute("no", no);
//            redirectAttributes.addAttribute("mode", "remove");
//            return "redirect:/board/passwd";
//        }
//
//        log.info("board removePost()...");
//        log.info("게시판 삭제 ing");
//        boardService.removeOne(no);
//
//        return "redirect:/board/list";
//    }

    /**
     * 2) 비밀번호 입력페이지
     */
    @GetMapping("/passwd")
    public void passwd(Integer no, String mode, Model model) {
        model.addAttribute("no", no);
        model.addAttribute("mode", mode);
    }

    // passwd 폼에서 post를 넘기므로

    /**
     * 3) 비밀번호 처리
     * 비밀번호를 세션에 저장 후 해당 처리 페이지로 리다이렉트
     *
     * @param no
     * @param mode
     * @param passwd
     * @param request
     * @param redirectAttributes
     * @return
     */
    @PostMapping("/passwd")
    public String passwdPost(Integer no, String mode, String passwd, HttpServletRequest request,
                             RedirectAttributes redirectAttributes) {
        log.info("...passwdPost()");
        log.info(mode);

        // 1. 전달받은 비밀번호를 세션에 저장
        HttpSession session = request.getSession();
        session.setAttribute("passwd", passwd);

        // 2. 해당 처리 페이지로 리다이렉트
        redirectAttributes.addAttribute("no", no);
        return "redirect:/board/" + mode;
    }

    @RequestMapping("/remove")
    public String removePost(Integer no, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        log.info("board removerReQuestMapping()...");

        // 1. 세션에 저장된 비밀번호를 불러옴.
        HttpSession session = request.getSession();
        String passwd = (String) session.getAttribute("passwd");

        // 2. 비밀번호가 없으면 비밀번호 입력 페이지로 리다이렉트
        if (passwd == null || passwd.isEmpty()) {
            redirectAttributes.addAttribute("no", no);
            redirectAttributes.addAttribute("mode", "remove");
            return "redirect:/board/passwd";
        }

        // 3. 비밀번호가 틀리면 비밀번호 입력 페이지로 리다이렉트
        if (!boardService.isCurrentPasswd(PasswdDTO.builder().no(no).passwd(passwd).build())) {
            session.removeAttribute("passwd");
            redirectAttributes.addAttribute("no", no);
            redirectAttributes.addAttribute("mode", "remove");
            return "redirect:/board/passwd";
        }

        // 4. 게시물 삭제
        log.info("board removePost()...");
        log.info("게시판 삭제 ing");
        boardService.removeOne(no);

        // 5. 삭제 후 비밀번호 삭제
        session.removeAttribute("passwd");

        return "redirect:/board/list";
    }




    /**
     * 3. 수정 페이지 출력
     * 비밀번호가 맞으면 출력
     */
    @GetMapping("/modify")
    public String modify(Integer no, HttpServletRequest request, RedirectAttributes redirectAttributes,Model model) {
        log.info("board removerReQuestMapping()...");

        // 1. 세션에 저장된 비밀번호를 불러옴.
        HttpSession session = request.getSession();
        String passwd = (String) session.getAttribute("passwd");

        // 2. 비밀번호가 없으면 비밀번호 입력 페이지로 리다이렉트
        if (passwd == null || passwd.isEmpty()) {
            redirectAttributes.addAttribute("no", no);
            redirectAttributes.addAttribute("mode", "modify");
            return "redirect:/board/passwd";
        }

        // 3. 비밀번호가 틀리면 비밀번호 입력 페이지로 리다이렉트
        if (!boardService.isCurrentPasswd(PasswdDTO.builder().no(no).passwd(passwd).build())) {
            session.removeAttribute("passwd");
            redirectAttributes.addAttribute("no", no);
            redirectAttributes.addAttribute("mode", "modify");
            redirectAttributes.addFlashAttribute("reason", "incorrect");
            return "redirect:/board/passwd";
        }

        log.info("board modify()...");
        BoardDTO boardDTO = boardService.getOne(no);

        model.addAttribute("dto",boardDTO);
        return "/board/modify";

    }
}
