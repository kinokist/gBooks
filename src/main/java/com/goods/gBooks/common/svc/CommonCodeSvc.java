package com.goods.gBooks.common.svc;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goods.gBooks.books.dto.in.BooksInDto;
import com.goods.gBooks.books.dto.out.BooksOutDto;
import com.goods.gBooks.books.entity.Books;
import com.goods.gBooks.books.repository.BooksRepository;
import com.goods.gBooks.common.dto.in.CommonCodeDetailInDto;
import com.goods.gBooks.common.dto.in.CommonCodeInDto;
import com.goods.gBooks.common.dto.out.CommonCodeDetailOutDto;
import com.goods.gBooks.common.dto.out.CommonCodeOutDto;
import com.goods.gBooks.common.entity.CommonCode;
import com.goods.gBooks.common.entity.CommonCodeDetail;
import com.goods.gBooks.common.repository.CommonCodeDetailRepository;
import com.goods.gBooks.common.repository.CommonCodeRepository;

@Service
public class CommonCodeSvc {

    @Autowired
    private CommonCodeRepository commonCodeRepository;

    @Autowired
    private CommonCodeDetailRepository commonCodeDetailRepository;


    public CommonCodeOutDto getCommonCode(String id) {
        CommonCode commonCode = commonCodeRepository.findByCodeGroupId(id);
        if (commonCode == null) {
            throw new IllegalArgumentException("해당 ID의 정보를 찾을 수 없습니다: " + id);
        }
        return CommonCodeOutDto.fromEntity(commonCode);
    }

    public CommonCodeOutDto getCommonCode(CommonCodeInDto inDto) {
        if (inDto == null || inDto.getCodeGroupId() == null || inDto.getCodeGroupId().isBlank()) {
            throw new IllegalArgumentException("ID가 누락되었습니다.");
        }
    
        return getCommonCode(inDto.getCodeGroupId());
    }

    public CommonCodeOutDto registerCommonCode(CommonCodeInDto inDto) {
        try {
            String id = getCommonId("GROUP");
            inDto.setCodeGroupId(id);

            return save(inDto);

        } catch (Exception e) {
            // 로그 출력 (로그 라이브러리 사용 시 log.error(...)로 교체 가능)
            System.err.println("공통코드 등록 중 예외 발생: " + e.getMessage());
            e.printStackTrace();

            // 필요 시 커스텀 예외 던지기
            throw new RuntimeException("공통코드 등록 실패", e);
        }
    }

    public CommonCodeOutDto updateCommonCode(CommonCodeInDto inDto) {
        try {

            if (inDto == null || inDto.getCodeGroupId() == null || inDto.getCodeGroupId().isBlank()) {
                throw new IllegalArgumentException("ID가 누락되었습니다.");
            }
            
            return save(inDto);

        } catch (Exception e) {
            // 로그 출력 (로그 라이브러리 사용 시 log.error(...)로 교체 가능)
            System.err.println("공통코드 등록 중 예외 발생: " + e.getMessage());
            e.printStackTrace();

            // 필요 시 커스텀 예외 던지기
            throw new RuntimeException("공통코드 등록 실패", e);
        }
    }

    public CommonCodeOutDto save(CommonCodeInDto inDto) {
        try {
            CommonCode commonCode = null;
            if (!commonCodeRepository.existsByCodeGroupId(inDto.getCodeGroupId())) {
                commonCode = commonCodeRepository.save(inDto.toEntity());
            }

            //Books book = booksRepository.getBooks(inDto.getId());
            if (commonCode == null) {
                throw new IllegalStateException("등록된 ID에 해당하는 데이터가 존재하지 않습니다: " + inDto.getCodeGroupId());
            }

            return CommonCodeOutDto.fromEntity(commonCode);

        } catch (Exception e) {
            // 로그 출력 (로그 라이브러리 사용 시 log.error(...)로 교체 가능)
            System.err.println("등록 중 예외 발생: " + e.getMessage());
            e.printStackTrace();

            // 필요 시 커스텀 예외 던지기
            throw new RuntimeException("등록 실패", e);
        }
    }



    public CommonCodeDetailOutDto getCommonCodeDetailByCodeId(String codeId) {
        CommonCodeDetail commonCodeDetail = commonCodeDetailRepository.findByCodeId(codeId);
        if (commonCodeDetail == null) {
            throw new IllegalArgumentException("해당 ID의 정보를 찾을 수 없습니다: " + codeId);
        }
        return CommonCodeDetailOutDto.fromEntity(commonCodeDetail);
    }

    public CommonCodeDetailOutDto getCommonCodeDetailByCodeGroupId(String codeGroupId) {
        CommonCodeDetail commonCodeDetail = commonCodeDetailRepository.findByCodeGroupId(codeGroupId);
        if (commonCodeDetail == null) {
            throw new IllegalArgumentException("해당 ID의 정보를 찾을 수 없습니다: " + codeGroupId);
        }
        return CommonCodeDetailOutDto.fromEntity(commonCodeDetail);
    }

    public CommonCodeDetailOutDto getCommonCodeDetailByCodeId(CommonCodeDetailInDto inDto) {
        if (inDto == null || inDto.getCodeId() == null || inDto.getCodeId().isBlank()) {
            throw new IllegalArgumentException("ID가 누락되었습니다.");
        }
    
        return getCommonCodeDetailByCodeId(inDto.getCodeId());
    }

    public CommonCodeDetailOutDto getCommonCodeDetailByCodeGroupId(CommonCodeDetailInDto inDto) {
        if (inDto == null || inDto.getCodeGroupId() == null || inDto.getCodeGroupId().isBlank()) {
            throw new IllegalArgumentException("ID가 누락되었습니다.");
        }
    
        return getCommonCodeDetailByCodeGroupId(inDto.getCodeGroupId());
    }

    public CommonCodeDetailOutDto registerCommonCodeDetail(CommonCodeDetailInDto inDto) {
        try {
            String id = getCommonId("CD");
            inDto.setCodeId(id);

            return save(inDto);

        } catch (Exception e) {
            // 로그 출력 (로그 라이브러리 사용 시 log.error(...)로 교체 가능)
            System.err.println("공통코드 상세 등록 중 예외 발생: " + e.getMessage());
            e.printStackTrace();

            // 필요 시 커스텀 예외 던지기
            throw new RuntimeException("공통코드 상세 등록 실패", e);
        }
    }

    public CommonCodeDetailOutDto updateCommonCodeDetail(CommonCodeDetailInDto inDto) {
        try {

            if (inDto == null || inDto.getCodeId() == null || inDto.getCodeId().isBlank()) {
                throw new IllegalArgumentException("ID가 누락되었습니다.");
            }
            
            return save(inDto);

        } catch (Exception e) {
            // 로그 출력 (로그 라이브러리 사용 시 log.error(...)로 교체 가능)
            System.err.println("공통코드 상세 등록 중 예외 발생: " + e.getMessage());
            e.printStackTrace();

            // 필요 시 커스텀 예외 던지기
            throw new RuntimeException("공통코드 상세 등록 실패", e);
        }
    }

    public CommonCodeDetailOutDto save(CommonCodeDetailInDto inDto) {
        try {
            CommonCodeDetail commonCodeDetail = null;
            if (!commonCodeDetailRepository.existsByCodeId(inDto.getCodeId())) {
                commonCodeDetail = commonCodeDetailRepository.save(inDto.toEntity());
            }

            //Books book = booksRepository.getBooks(inDto.getId());
            if (commonCodeDetail == null) {
                throw new IllegalStateException("등록된 ID에 해당하는 데이터가 존재하지 않습니다: " + inDto.getCodeId());
            }

            return CommonCodeDetailOutDto.fromEntity(commonCodeDetail);

        } catch (Exception e) {
            // 로그 출력 (로그 라이브러리 사용 시 log.error(...)로 교체 가능)
            System.err.println("등록 중 예외 발생: " + e.getMessage());
            e.printStackTrace();

            // 필요 시 커스텀 예외 던지기
            throw new RuntimeException("등록 실패", e);
        }
    }

        public String getCommonId(String flag) {
        String genId;
        try {
            if(flag=="GROUP"){
                do {
                    genId = idGeneratorTypeCommon("GRP",flag);  // ID 생성
                } while (commonCodeRepository.existsByCodeGroupId(genId));  // 존재하면 다시 생성
        
            }else if(flag=="CODE"){
                do {
                    genId = idGeneratorTypeCommon("CD",flag);  // ID 생성
                } while (commonCodeDetailRepository.existsByCodeId(genId));  // 존재하면 다시 생성

            }else{
                throw new RuntimeException("ID 생성 실패=====구분없음음");
            }
            
    
            return genId;
    
        } catch (Exception e) {
            // 로그 출력 (로그 라이브러리 사용 시 log.error(...)로 교체 가능)
            System.err.println("ID 생성 중 예외 발생: " + e.getMessage());
            e.printStackTrace();
    
            // 필요시 커스텀 예외 던지기
            throw new RuntimeException("ID 생성 실패", e);
        }
    }
    
    public String idGeneratorTypeCommon(String header,String flag) {
        try {
            Random random = new Random();
            int number = random.nextInt(100000); // 0 ~ 99999
            String fiveDigitNumber = String.format("%05d", number);
            if(flag=="GROUP"){
                    number = random.nextInt(1000); // 0 ~ 99999
                    fiveDigitNumber = String.format("%03d", number);
            }else if(flag=="CODE"){
                    number = random.nextInt(100000000); // 0 ~ 999 랜덤 숫자
                    fiveDigitNumber = String.format("%08d", number);
            }else{
                throw new RuntimeException("ID 생성 실패=====구분없음음");
            }
            
            return header + fiveDigitNumber;
    
        } catch (IllegalArgumentException e) {
            // 포맷팅 관련 오류 처리
            System.err.println("날짜 포맷팅 오류: " + e.getMessage());
            throw new RuntimeException("날짜 포맷팅 오류", e);
        } catch (Exception e) {
            // 다른 예외 처리
            System.err.println("랜덤 숫자 생성 중 오류 발생: " + e.getMessage());
            throw new RuntimeException("ID 생성 실패", e);
        }
    }
}
