package jpabook.jpashop.repository;

import jakarta.persistence.EntityManager;
import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor // auto create constructor for EntityManager entityManager
public class MemberRepository {
    private final EntityManager entityManager;
    
    // save
    public void save(Member member) {
        entityManager.persist(member);
    }
    
    // findOne
    public Member findOne(Long id) {
        return entityManager.find(Member.class, id);
    }
    
    // findAll
    public List<Member> findAll() {
        return entityManager
                .createQuery("select m from Member m", Member.class)
                .getResultList();
    }
    
    
    // findByName
    public List<Member> findByName(String name) {
        return entityManager
                .createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }
}
