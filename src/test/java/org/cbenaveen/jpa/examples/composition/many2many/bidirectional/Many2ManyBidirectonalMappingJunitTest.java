package org.cbenaveen.jpa.examples.composition.many2many.bidirectional;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.cbenaveen.jpa.AbstractJunitTest;
import org.cbenaveen.jpa.composition.many2many.bidirectional.Author;
import org.cbenaveen.jpa.composition.many2many.bidirectional.Book;
import org.junit.Test;

public class Many2ManyBidirectonalMappingJunitTest extends AbstractJunitTest {
    public Many2ManyBidirectonalMappingJunitTest() {
        super("examples.composition.many2many.bidirectonal");
    }

    @Test
    public void test() {
        Author pramodJSadalage = new Author();
        pramodJSadalage.setName("Pramod J. Sadalage");
        Author martinFowler = new Author();
        martinFowler.setName("Martin Fowler");
        Author kentBeck = new Author();
        kentBeck.setName("Kent Beck");
        Author johnBrant = new Author();
        johnBrant.setName("John Brant");
        Author wiliamOpdyke = new Author();
        wiliamOpdyke.setName("William Opdyke");
        Author donRoberts = new Author();
        donRoberts.setName("Don Roberts");

        Book noSqlDistilled = new Book();
        noSqlDistilled.setTitle("NoSQL Distilled");
        Set<Author> noSqlDistilledAuthors = new HashSet<Author>();
        noSqlDistilledAuthors.add(pramodJSadalage);
        noSqlDistilledAuthors.add(martinFowler);
        noSqlDistilled.setAuthors(noSqlDistilledAuthors);

        Book refactoring = new Book();
        refactoring.setTitle("Refactoring");
        Set<Author> refactoringAuthors = new HashSet<Author>();
        refactoringAuthors.add(kentBeck);
        refactoringAuthors.add(martinFowler);
        refactoringAuthors.add(wiliamOpdyke);
        refactoringAuthors.add(donRoberts);
        refactoring.setAuthors(refactoringAuthors);

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        // persist all books
        entityManager.persist(noSqlDistilled);
        entityManager.persist(refactoring);

        // persist all authors
        entityManager.persist(pramodJSadalage);
        entityManager.persist(martinFowler);
        entityManager.persist(kentBeck);
        entityManager.persist(johnBrant);
        entityManager.persist(wiliamOpdyke);
        entityManager.persist(donRoberts);
        tx.commit();
        entityManager.clear();

        //Query Author "Marting Fowler" 
        Query martinFlowerQuery = entityManager.createQuery("Select a from Author a where a.name = 'Martin Fowler'", Author.class);
        Author mf = (Author) martinFlowerQuery.getSingleResult();
        StringBuffer buffer = new StringBuffer("Author Name = " + mf.getName());
        buffer.append("\nBooks Authored:");
        for (Book book : mf.getBooks()) {
            buffer.append("\n\t" + book.getTitle());
        }
        System.out.println(buffer.toString());
    }
}
