package net.skhu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.skhu.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>  {

    @Query("SELECT s.studentNo, s.name, SIZE(s.sugangs) FROM Student s ORDER BY SIZE(s.sugangs) DESC")
    List<Object[]> findSugangCount();
    //학번, 이름, 수강 수 목록을 조회한다. 수강 수 내림차순.
    //조회 결과 각각의 레코드를 Object[] 배열에 저장한다. (학번, 이름, 수강 수) 배열.


    @Query("SELECT s FROM Student s JOIN s.sugangs g WHERE g.lecture.title = ?1")
    List<Student> findByLectureTite(String title);

    //어떤 강좌를 수강하는 학생 목록을 조회한다.
    //JPQL 에서 ?1 부분에 메소드 첫째 파라미터 값이 삽입되어 실행된다.

    @Query("SELECT s FROM Student s WHERE EXISTS (SELECT g.lecture FROM s.sugangs g"
         + "               WHERE g.lecture.professor.id = ?1 OR g.lecture.professor.name = ?2)")
    List<Student> findByProfessorIdOrProfessorName(int id, String name);
    //  어떤 교수의 강좌를 수강하는 학생 목록을 조회한다.
    //JPQL 에서 ?1 ?2 부분에 각각 메소드 첫째 파라미터 값, 둘때 파라미터 값이 삽입되어 실행된다.


    List<Student> findBySugangsLectureProfessorIdOrSugangsLectureProfessorName(int id, String name);

    @Query("SELECT s"
         + " FROM Student s"
         + " WHERE EXISTS (SELECT g.lecture"
         + "               FROM s.sugangs g"
         + "               WHERE g.lecture.professor.id = :id OR g.lecture.professor.name = :name)")
    List<Student> findByProfessorNameOrProfessorId(String name, int id);
    //어떤 교수의 강좌를 수강하는 학생 목록을 조회한다.
    //JPQL 에서 :id 부분에 id 파라미터 값이, :name 부분에 name 파라미터 값이 삽입되어 실행된다.


}
