package com.example.spring_basic.sample;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@ToString
@Log4j2
@Service
@RequiredArgsConstructor
public class SampleService {

    // 타입을 인터페이스 잡아주고
    // DAO와 같은 객체를 위한 어노테이션 파일에 인터페이스를 구현해놓으면
    // DAO 파일 코드만 수정하면 됨
    // Service 클래스에선 수정할 필요가 없어져서 좋다
    private final SampleDAO sampleDAO;
}
