package org.cbenaveen.jpa.examples.composition.many2many.unidirectional;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityTransaction;

import org.cbenaveen.jpa.AbstractJunitTest;
import org.cbenaveen.jpa.composition.many2many.unidirectional.Author;
import org.cbenaveen.jpa.composition.many2many.unidirectional.Book;
import org.junit.Test;

public class Many2ManyUnidirectonalMappingJunitTest extends AbstractJunitTest {
    public Many2ManyUnidirectonalMappingJunitTest() {
        super("examples.composition.many2many.unidirectonal");
    }

    @Test
    public void test() {
        Author  pramodJSadalage = new Author();
        pramodJSadalage.setName("Pramod J. Sadalage");
        Author martinFowler = new Author();
        martinFowler.setName("Martin Fowler");
        Author  kentBeck = new Author();
        kentBeck.setName("Kent Beck");
        Author johnBrant = new Author();
        johnBrant.setName("John Brant");
        Author  wiliamOpdyke = new Author();
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
        //persist all books
        entityManager.persist(noSqlDistilled);
        entityManager.persist(refactoring);
        
        //persist all authors
        entityManager.persist(pramodJSadalage);
        entityManager.persist(martinFowler);
        entityManager.persist(kentBeck);
        entityManager.persist(johnBrant);
        entityManager.persist(wiliamOpdyke);
        entityManager.persist(donRoberts);
        tx.commit();
        entityManager.clear();
        
       findBookById(1l);//first book id would be generated as 1, hence querying using 1
       findBookById(4l);//second book id would be generated as 4, as authors would have been inserted, hence querying using 4
    }

    private void findBookById(long l) {
        Book aBook = entityManager.find(Book.class, l);
        System.out.println("===================================");
        System.out.println("Book Information");
        System.out.println("Title = " + aBook.getTitle());
        System.out.println("Authors:");
        for(Author authors: aBook.getAuthors()){
            System.out.println("\t" + authors.getName());
        }
        System.out.println("===================================");
    }
}
