package hello.core.member;

//@Component
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

//    @Autowired // ac.getBean(MemberRepository.class)
//    public MemberServiceImpl(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // @Test
//    public MemberRepository getMemberRepository() {
//        return memberRepository;
//    }
}
