package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclasifier.MedianAdapter;
import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedianAdapterTestSuite {
    @Test
    public void publicationYearMedianTest() {
        //Given
        MedianAdapter medianAdapter = new MedianAdapter();
        Set<Book> bookSet = new HashSet<>();
        Book book1 = new Book("Author1", "Title1", 2000, "Sig1");
        Book book2 = new Book("Author2", "Title2", 2010, "Sig2");
        Book book3 = new Book("Author3", "Title3", 2020, "Sig3");
        bookSet.add(book1);
        bookSet.add(book2);
        bookSet.add(book3);
        //When
        int medianValue = medianAdapter.publicationYearMedian(bookSet);
        //Then
        System.out.println(medianValue);
        assertEquals(2010, medianValue);
    }
}
