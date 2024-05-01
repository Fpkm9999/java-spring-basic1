package com.example.spring_basic.service;

import com.example.spring_basic.domain.BoardVO;
import com.example.spring_basic.domain.TodoVO;
import com.example.spring_basic.dto.BoardDTO;
import com.example.spring_basic.mapper.BoardMapper;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Log4j2
@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;
    private final ModelMapper modelMapper;

    @Override
    public void register(BoardDTO boardDTO) {
        log.info(boardDTO);

        // 이건 일이 2가지. todoVO 객체를 생성하는데 TodoVO.class에 todoDTO의 값을 넣어준다. (원래라면 getter setter 을 이용해서 일일히 값을 넣어야 함)
        BoardVO boardVO = modelMapper.map(boardDTO, BoardVO.class); // todoVO 객체를 생성하는데 todoDTO의 값을  TodoVO 객체에 복사해준다.
        log.info(boardVO); //
        boardMapper.insert(boardVO);
    }

    @Override
    public List<BoardDTO> getAll() {
        List<BoardVO> boardVOList = boardMapper.selectAll();
        List<BoardDTO> boardDTOList = new ArrayList<BoardDTO>();

        for (BoardVO boardVO : boardVOList) {
            // 개별 VO를 DTO 로 변환
            BoardDTO boardDTO = modelMapper.map(boardVO, BoardDTO.class);

            boardDTOList.add(boardDTO);

        }

        return boardDTOList;
    }
}
