package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        // 추가
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            Member member = new Member();
            member.setId(1L);
            member.setName("platanus");
            em.persist(member);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        // 검색
        EntityManager em2 = emf.createEntityManager();
        EntityTransaction tx2 = em2.getTransaction();
        tx2.begin();
        try {
            Member findMember = em2.find(Member.class, 1L);
            System.out.println("findMember.id : " + findMember.getId());
            System.out.println("findMember.name : " + findMember.getName());
            tx2.commit();
        } catch (Exception e) {
            tx2.rollback();
        } finally {
            em2.close();
        }

        //수정
        EntityManager em3 = emf.createEntityManager();
        EntityTransaction tx3 = em3.getTransaction();
        tx3.begin();
        try {
            Member findMember = em3.find(Member.class, 1L);
            findMember.setName("jongpak");
            // em.persist(findMember); // persist가 필요없음!
            tx3.commit();
        } catch (Exception e) {
            tx3.rollback();
        } finally {
            em3.close();
        }

        // 삭제
        EntityManager em4 = emf.createEntityManager();
        EntityTransaction tx4 = em4.getTransaction();
        tx4.begin();
        try {
            Member findMember = em4.find(Member.class, 1L);
            em4.remove(findMember);
            tx4.commit();
        } catch (Exception e) {
            tx4.rollback();
        } finally {
            em4.close();
        }

        emf.close();
    }
}
