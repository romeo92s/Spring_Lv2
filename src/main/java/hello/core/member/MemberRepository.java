package hello.core.member;

public interface MemberRepository {

    void save(Member member);      //회원 저장

    Member finaById(Long memberId);  //회원찾기
}
