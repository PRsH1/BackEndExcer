package net.skhu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>  {

    Student findByStudentNo(String studentNo);
    List<Student> findByName(String name);
    //이름을 찾는 메서드,student 테이블에서 studentNo 필드로 레코드를 조회하여 리턴한다.
    //파라미터 변수 studentNo의 값과 필드 값 전체가 일치해야 한다

    List<Student> findByNameStartsWith(String name);
    /**student 테이블에서 name 필드로 레코드를 조회하여 리턴한다.
    파라미터 변수 name의 값이 필드 값 앞 부분과 일치하면 된다. 
    예를 들어 파라미터 변수 name의 값이 "김" 이면, 성이 김씨인 레코드 전체를 조회한다.
     **/
    List<Student> findByDepartmentName(String name);
    /**
     * student 테이블과 department 테이블을 조회하고,
    조인된 department 테이블의 name 필드로 조회하여 일치하는 student 테이블 레코드를 리턴한다.
    파라미터 변수 name의 값과 department.name 필드 값 전체가 일치해야 한다.

     */
    List<Student> findByDepartmentNameStartsWith(String name);
 /**
  * 위 findByDepartmentName 메소드의 설명과 동일하다.
    단 파라미터 변수 name의 값이, department.name 필드 값 앞 부분과 일치하면 된다. 

  * 
  */
    List<Student> findByOrderByName();
    //student 테이블의 전체 레코드를, 필드의 오름차순으로 정렬하여 리턴한다.
    List<Student> findByOrderByNameDesc();
    //student 테이블의 전체 레코드를, 필드의 내림차순으로 정렬하여 리턴한다.
    List<Student> findByDepartmentIdOrderByNameDesc(int id);
    /**
     * student 테이블과 department 테이블을 조회하고,
    조인된 department 테이블의 id 필드로 조회하여 일치하는 student 테이블 레코드를 리턴한다.
    조회 결과를 student 테이블의 name 필드의 내림차순으로 정렬하여 리턴한다.

     */

}

