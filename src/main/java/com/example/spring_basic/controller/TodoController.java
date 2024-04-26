package com.example.spring_basic.controller;


import com.example.spring_basic.dto.PageRequestDTO;
import com.example.spring_basic.dto.TodoDTO;
import com.example.spring_basic.service.TodoService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@Log4j2
@RequestMapping("/todo") // 클래스 단위 todo 을 찾고 list를 찾음

// 2024-04-25 유효성검증을 위한 코드 추가
@RequiredArgsConstructor
public class TodoController {
    public final TodoService todoService; // 2024-04-25 유효성검증을 위한 코드 추가

    //    @RequestMapping("/list") //   클래스 매밉 / 메소드 매핑순으로 member.login 처럼 도 사용
//    public void list() {
//        log.info("todo list...");
//    }
//    @RequestMapping("/list") // 브라우저 주소가 /list 때 실행되는 자바 컨트롤러 메소드
//    public void list(Model model) {
//        log.info("todo list...");
//        model.addAttribute("dtoList", todoService.getAll());
//    }

    //    @RequestMapping(value = "/register", method = RequestMethod.GET)
    @GetMapping("/register") // 위방법은 이제 안쓴다. 이렇게 씀 // 동일한 URL인데 겟이냐 포스트냐에 따라 다르게 가도록함
    public void register() {
        log.info("todo register...");
    }
//    @PostMapping("/register")
//    public void registerPOST() {
//        log.info("POST todo register");
//    }
//    @PostMapping("/register")
//    public void registerPOST(TodoDTO todoDTO){
//        log.info(("POST todo register..."));
//        log.info(todoDTO);
//    }

//    @PostMapping("/register")
//    public String registerPOST(TodoDTO todoDTO){ // /t1odo/register 경로로 GET 요청이 들어올때 이 메소드를 호출한다.
//        log.info(("POST todo register..."));
//
//
//        log.info(todoDTO);
//        return "redirect:/todo/list";
//    }

//    @PostMapping("/register")
//    public String registerPOST(TodoDTO todoDTO){ // /t1odo/register 경로로 GET 요청이 들어올때 이 메소드를 호출한다.
//        log.info(("POST todo register..."));
////        log.info(todoDTO);
//        System.out.println(todoDTO);
//        return "redirect:/todo/list";
//    }


    // 2024-04-25 유효성 검증2
    @PostMapping("/register") // 브라우저 주소가 /register 때 실행되는 자바 컨트롤러 메소드
    // to1do/register 경로를 반환 하므로 실제 화면을 담당하는 뷰 코드도 작성해야 한다.
    // view 패키지에 to1do/register.jsp 작성을 하면 된다.

    public String registerPOST(@Valid TodoDTO todoDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) { // /t1odo/register 경로로 GET 요청이 들어올때 이 메소드를 호출한다.
        log.info(("POST todo register..."));

        if (bindingResult.hasErrors()) { // BindingResult 을 이용해 유효성 검사. 에러가 있는지 여부
            log.info("has error...");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/todo/register";
        }

        // 유효성 통과시
        log.info(todoDTO);

        todoService.register(todoDTO); // 실제 DB에 저장하는 코드 추가 2024-04-25

        return "redirect:/todo/list";
    }

//    @GetMapping("/`read")
//    public void read(Long tno, Model model) {
//        // 1) request로 전달 받은 tno를 서비스에 전달해서 TodoDTO를 반환받아서 view 에 전달
//        TodoDTO todoDTO = todoService.getOne(tno);
//        log.info(todoDTO);
//
//        model.addAttribute("dto", todoDTO);
//    }

    @GetMapping({"/read", "/modify"}) // 매핑은 매개변수로 하나만 받을 수 있기 때문에 중괄호로 묶어서(배열형태로) 콤마로 2개의 매개변수를 받을 수 있다.
    public void read(Long tno, Model model) {
        // 1) request로 전달 받은 tno를 서비스에 전달해서 TodoDTO를 반환받아서 view 에 전달
        TodoDTO todoDTO = todoService.getOne(tno);
        log.info(todoDTO);

        model.addAttribute("dto", todoDTO);
    }

    @PostMapping("/remove")
    public String remove(Long tno, RedirectAttributes redirectAttributes) {
        log.info("----------remove----------");
        log.info("tno: " + tno);

        todoService.remove(tno); //서비스단에 remove 쿼리 명령

        return "redirect:/todo/list";
    }

    @PostMapping("/modify")
    public String modify(@Valid TodoDTO todoDTO,
                         BindingResult bingBindingResult,
                         RedirectAttributes redirectAttributes) {
        if (bingBindingResult.hasErrors()) { // 유효성 검사 결과 에러가 있으면 수정페이지로 되돌아감
            log.info(("has error...에러뜸"));
            redirectAttributes.addFlashAttribute("errors", bingBindingResult.getAllErrors());
            redirectAttributes.addAttribute("tno", todoDTO.getTno()); // tno가 쿼리스트림으로 전달
            return "redirect:/todo/modify";
        }
        log.info("modify(정상) 코드실행");
        log.info(todoDTO);
        todoService.modify(todoDTO);
        return "redirect:/todo/list";
    }

    @GetMapping("/list")
    public void list(@Valid PageRequestDTO pageRequestDTO, BindingResult bindingResult, Model model){
        log.info(pageRequestDTO);

        if(bindingResult.hasErrors()){
            pageRequestDTO = pageRequestDTO.builder().build();
        }
        model.addAttribute("responseDTO",todoService.getList(pageRequestDTO));
    }
}
