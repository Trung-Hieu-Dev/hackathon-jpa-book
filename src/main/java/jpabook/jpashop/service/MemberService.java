package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true) // use for testing only. do not write DB
public class MemberService {
    private final MemberRepository memberRepository;
    
    // Join Member
    public Long join(Member member) {
        validateDuplicateMember(member);
        
        memberRepository.save(member);
        return member.getId(); // get inserted id
    }
    
    private void validateDuplicateMember(Member member) {
        List<Member> members = memberRepository.findByName(member.getName());
        if (!members.isEmpty()) {
            throw new IllegalStateException("This member already exist.");
        }
    }
    
    // find all member
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }
    
    
    // get single member
    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }
}
