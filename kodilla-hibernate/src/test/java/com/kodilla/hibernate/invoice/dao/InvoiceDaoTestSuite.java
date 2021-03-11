package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.math.BigDecimal;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    private InvoiceDao invoiceDao;
    @Autowired
    private ProductDao productDao;

    @Test
    void testInvoiceDaoSave() {
        //Given
        Product firstProduct = new Product("firstProduct");
        Product secondProduct = new Product("secondProduct");
        productDao.save(firstProduct);
        productDao.save(secondProduct);
        Item firstItem = new Item(firstProduct, new BigDecimal("2300"), 4, new BigDecimal("5000"));
        Item secondItem = new Item(secondProduct, new BigDecimal("4500"), 5, new BigDecimal("7000"));
        Item thirdItem = new Item(secondProduct, new BigDecimal("1350"), 2, new BigDecimal("3100"));
        Invoice testInvoice1 = new Invoice("1234");
        Invoice testInvoice2 = new Invoice("1235");
        Invoice testInvoice3 = new Invoice("1236");
        //When
        firstItem.setInvoice(testInvoice1);
        secondItem.setInvoice(testInvoice2);
        thirdItem.setInvoice(testInvoice3);
        testInvoice1.setItems(List.of(firstItem));
        testInvoice2.setItems(List.of(secondItem));
        testInvoice3.setItems(List.of(thirdItem));
        invoiceDao.save(testInvoice1);
        invoiceDao.save(testInvoice2);
        invoiceDao.save(testInvoice3);
        int id1 = testInvoice1.getId();
        int id2 = testInvoice2.getId();
        int id3 = testInvoice3.getId();
        //Then
        assertNotEquals(0, id1);
        assertNotEquals(0, id2);
        assertNotEquals(0, id3);
    }
}
