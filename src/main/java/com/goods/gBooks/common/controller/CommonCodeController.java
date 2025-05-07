package com.goods.gBooks.common.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goods.gBooks.books.dto.in.BooksInDto;
import com.goods.gBooks.books.dto.out.BooksOutDto;
import com.goods.gBooks.books.svc.BooksSvc;
import com.goods.gBooks.common.dto.in.CommonCodeDetailInDto;
import com.goods.gBooks.common.dto.in.CommonCodeInDto;
import com.goods.gBooks.common.dto.out.CommonCodeDetailOutDto;
import com.goods.gBooks.common.dto.out.CommonCodeOutDto;
import com.goods.gBooks.common.svc.CommonCodeSvc;

@RestController
@RequestMapping("/api/common")
public class CommonCodeController {
    @Autowired
    private CommonCodeSvc commonCodeSvc;

    @PostMapping("/resistercomcd")
    public CommonCodeOutDto registerCmcd(@RequestBody CommonCodeInDto inDto){
        CommonCodeOutDto outDto = commonCodeSvc.registerCommonCode(inDto);
        return outDto;
    }

    @PostMapping("/resistercomcddtl")
    public CommonCodeDetailOutDto registerCmcdDtl(@RequestBody CommonCodeDetailInDto inDto){
        CommonCodeDetailOutDto outDto = commonCodeSvc.registerCommonCodeDetail(inDto);
        return outDto;
    }

    @PostMapping("/getbygrpcd")
    public CommonCodeDetailOutDto getCommonCodeDetailByCodeGroupId(@RequestBody Map<String, String> request) {
        String grpcd = request.get("grpcd");
        try {
         return commonCodeSvc.getCommonCodeDetailByCodeGroupId(grpcd);
        } catch (Exception e) {
            // 로그 출력 (로그 라이브러리 사용 시 log.error(...)로 교체 가능)
            System.err.println("공통코드조회중  예외 발생: " + e.getMessage());
            e.printStackTrace();

            // 필요 시 커스텀 예외 던지기
            throw new RuntimeException("조회 실패", e);
        }
    }
}
