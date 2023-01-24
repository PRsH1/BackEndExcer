package net.skhu.model;

import lombok.Data;

@Data
public class Pagination {
    int pg = 1;        // 현재 페이지 번호
    int sz = 15;       // 페이지 당 레코드 수
    int recordCount;   // 전체 레코드 수

    public int getFirstRecordIndex() {
    	//pg페이지의 첫 레코드의 인덱스 계산하는 메소드
        return (pg - 1) * sz;
        //1번 페이지이면 0 2번 페이지이면 15 3번 페이지이면 30
        
    }

    public String getQueryString() {
        return String.format("pg=%d&sz=%d", pg, sz);
        //URL쿼리 스트링 출력하는 메소드
    }
}
