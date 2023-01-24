package net.skhu.model;

import lombok.Data;

@Data
public class Pagination {
    int pg = 1;        // 현재 페이지 번호
    int sz = 15;       // 페이지 당 레코드 수
    int di = 0;        // departmentId
    int od = 0;        // 정렬 순서, od 값이 0 이면, 학생 id 값 오름차순 1 이면, 학번 오름차순 2 이면, 학생 이름 오름차순 3 이면, 소속학과명 오름차순

    int recordCount;   // 전체 레코드 수

    public int getFirstRecordIndex() {
        return (pg - 1) * sz;
    }

    public String getQueryString() {
        return String.format("pg=%d&sz=%d&di=%d", pg, sz, di);
    }
}
