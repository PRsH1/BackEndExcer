package net.skhu.model;

import lombok.Data;

@Data
public class Bmodel {
    int categoryId1=1;//Default 속성값은 1(소설) 내가 여기서 4로 바꾸면 과학이 된다
    int categoryId2=2;
    int categoryId3;
    int[] categoryId4;
    int[] categoryId5;
    boolean enabled;
}
