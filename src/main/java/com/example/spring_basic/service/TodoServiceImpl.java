package com.example.spring_basic.service;

import com.example.spring_basic.domain.TodoVO;
import com.example.spring_basic.dto.PageRequestDTO;
import com.example.spring_basic.dto.PageResponseDTO;
import com.example.spring_basic.dto.TodoDTO;
import com.example.spring_basic.mapper.TodoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
// 생성자 객체 주입. private final 로 선언된 참조변수에 객체를 저장하는 생성자 작성.
public class TodoServiceImpl implements TodoService {
    private final TodoMapper todoMapper; // 의존성 주입으로 생성자주입방식으로 객체생성을 하는데 하나의 인스턴스만 사용 하기 떄문에
    private final ModelMapper modelMapper;

    // @RequiredArgsConstructor 가 아래의 생성자를 만들어줌
//    public TodoServiceImpl(TodoMapper todoMapper, ModelMapper modelMapper) {
//        this.todoMapper = todoMapper;
//        this.modelMapper = modelMapper;
//    }

    /*
    스프링 프레임워크가 TodoServiceImpl 객체를 생성하는데 TodoMapper, ModelMapper 객체를 생성자를 통해 객체도 생성
    해준다.
     */
    @Override
    public void register(TodoDTO todoDTO) { // register 메소드 // DB에 데이터를 등록하는 메서드
        log.info(todoDTO);
        // 이건 일이 2가지. todoVO 객체를 생성하는데 TodoVO.class에 todoDTO의 값을 넣어준다. (원래라면 getter setter 을 이용해서 일일히 값을 넣어야 함)
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class); // todoVO 객체를 생성하는데 todoDTO의 값을  TodoVO 객체에 복사해준다.
        log.info(todoVO); //
        todoMapper.insert(todoVO);

    }

    @Override
    public PageResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO) {
        List<TodoVO> voList = todoMapper.selectList(pageRequestDTO);
//        List<TodoDTO> dtoList = new ArrayList<>(); // 반환형이 List<TodoDTO> 인 ArrayList 타입 변수 생성
//        for (TodoVO todoVO : voList) {
        // 개별 VO를 DTO로 변환
        // 하나씩 저장함
        List<TodoDTO> dtoList = new ArrayList<>();
        for (TodoVO todoVO : voList) {
            dtoList.add(modelMapper.map(todoVO, TodoDTO.class));
        }
        int total = todoMapper.getCount(pageRequestDTO);

        PageResponseDTO<TodoDTO> pageResponseDTO = PageResponseDTO.<TodoDTO>withAll()
                .dtoList(dtoList)
                .total(total)
                .pageRequestDTO(pageRequestDTO)
                .build();
        return pageResponseDTO;
//            TodoDTO todoDTO = modelMapper.map(todoVO, TodoDTO.class); //TodoDTO.class 객체를 만들면서 voList의 요소값을 todoDTO에 하나씩 저장
//            dtoList.add(todoDTO); //  dtoList 변수에 todoDTO 값을 저장 (DTO리스트에 저장)
//        }
//        return dtoList;
    }

//    @Override
//    public List<TodoDTO> getAll() { // todoVOList에 저장된 데이터를 -> ->
//        List<TodoVO> voList = todoMapper.selectAll();
//        List<TodoDTO> dtoList = new ArrayList<>(); // 반환형이 List<TodoDTO> 인 ArrayList 타입 변수 생성
//        for (TodoVO todoVO : voList) {
//            // 개별 VO를 DTO로 변환
//            // 하나씩 저장함
//            TodoDTO todoDTO = modelMapper.map(todoVO, TodoDTO.class); //TodoDTO.class 객체를 만들면서 voList의 요소값을 todoDTO에 하나씩 저장
//            dtoList.add(todoDTO); //  dtoList 변수에 todoDTO 값을 저장 (DTO리스트에 저장)
//        }
//        return dtoList;
//    }


    // vo를 dto로 반환
    @Override
    public TodoDTO getOne(Long tno) {
        TodoVO todoVO = todoMapper.selectOne(tno);
        TodoDTO todoDTO = modelMapper.map(todoVO, TodoDTO.class);
        return todoDTO;
    }


    // 삭제는 반환 X
    @Override
    public void remove(Long tno) {
        todoMapper.delete(tno);
    }

    @Override
    public void modify(TodoDTO todoDTO) {


        log.info(todoDTO);
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
        log.info(todoVO);

        todoMapper.update(todoVO);
    }
}
