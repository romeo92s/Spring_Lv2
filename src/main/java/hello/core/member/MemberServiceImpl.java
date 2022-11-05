package hello.core.member;

public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository ;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    //memberRepository의 설정을 해놓지않고, 생성자를 생성함으로써 생성자를 통해서 들어온 구현체를 설정

    @Override
    public void join(Member member) {
        memberRepository.save(member);

    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.finaById(memberId);
    }
}
