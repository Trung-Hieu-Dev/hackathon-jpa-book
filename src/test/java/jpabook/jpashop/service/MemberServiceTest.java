package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class MemberServiceTest {
    @Autowired private MemberService memberService;
    
    @Test void join() {
        Member member = new Member();
        member.setName("Kim");
        
        Long savedId = memberService.join(member);
        Member findMember = memberService.findOne(savedId);
        
        Assertions.assertThat(findMember).isEqualTo(member);
    }
    
    @Test
    void DuplicateMember() {
        Member member1 = new Member();
        member1.setName("Kim");
        
        Member member2 = new Member();
        member2.setName("Kim");
        
        memberService.join(member1);
        
        assertThrows(IllegalStateException.class, () -> memberService.join(member2));
    }
    
    @Test void findMembers() {
    }
    
    @Test void findMember() {
    }
}