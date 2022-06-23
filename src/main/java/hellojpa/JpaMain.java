package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        // DB 트렌잭션 시작
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member member = new Member();
            member.setUsername("hello");

            em.persist(member);

            em.flush();
            em.clear();

            Member findMember = em.getReference(Member.class, member.getId());
            System.out.println("findMember.name = " + findMember.getUsername());
            System.out.println("findMember.name = " + findMember.getUsername());


            tx.commit();
        } catch (Exception e) {
            // 실패하면 롤백
            tx.rollback();
        } finally {
            // 트랙잭션 닫기
            em.close();
        }
        emf.close();
    }
}