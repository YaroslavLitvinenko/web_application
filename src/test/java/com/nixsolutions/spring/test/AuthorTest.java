package com.nixsolutions.spring.test;
import org.dbunit.Assertion;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.nixsolutions.spring.config.DBUnitConfig;
import com.nixsolutions.spring.model.db.entity.Author;
import com.nixsolutions.spring.model.service.AdminServ;
import com.nixsolutions.spring.model.service.AuthorServ;

import java.io.FileInputStream;
import java.sql.SQLException;
import java.util.Collection;

public class AuthorTest extends DBUnitConfig {
	@Autowired
	AuthorServ authorServ;
	
    public AuthorTest() throws SQLException, ClassNotFoundException {
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        FlatXmlDataSetBuilder flatXmlProducer = new FlatXmlDataSetBuilder();
        flatXmlProducer.setColumnSensing(false);
        beforeData = new FlatXmlDataSetBuilder().build(
        		AuthorTest.class.getResourceAsStream("/Author/Author.xml"));
        tester.setDataSet(beforeData);
        tester.onSetup();
    }

    @Test
    public void testCreate() throws Exception {
    	Author author = new Author(5L, "author51", "author52", "author53");
        authorServ.save(author);
        IDataSet expectedData = new FlatXmlDataSetBuilder().build(
        		AuthorTest.class.getResourceAsStream("/Author/AuthorC.xml"));
        ITable expectedTable = expectedData.getTable("author");
        IDataSet actualData = tester.getConnection().createDataSet();
        ITable actualTale = actualData.getTable("author");
        Assertion.assertEqualsIgnoreCols(expectedTable, actualTale, new String[]{"author_id"});
    }
    
    @Test
    public void testDelete() throws Exception {
    	Author author = new Author(4L);
    	author = authorServ.findByID(author);
        authorServ.delete(author);
        IDataSet expectedData = new FlatXmlDataSetBuilder().build(
        		AuthorTest.class.getResourceAsStream("/Author/AuthorD.xml"));
        ITable expectedTable = expectedData.getTable("author");
        IDataSet actualData = tester.getConnection().createDataSet();
        ITable actualTale = actualData.getTable("author");
        Assertion.assertEquals(expectedTable, actualTale);
    }
    
    @Test
    public void testUpdate() throws Exception {
    	Author author = new Author(4L);
    	author = authorServ.findByID(author);
    	author.setFirstName("author51");
    	author.setMiddleName("author53");
    	authorServ.update(author);
    	IDataSet expectedData = new FlatXmlDataSetBuilder().build(
        		AuthorTest.class.getResourceAsStream("/Author/AuthorU.xml"));
        ITable expectedTable = expectedData.getTable("author");
        IDataSet actualData = tester.getConnection().createDataSet();
        ITable actualTale = actualData.getTable("author");
        Assertion.assertEquals(expectedTable, actualTale);
    }
    
    @Test
    public void testGetAll() throws Exception {
        Collection<Author> assessments = authorServ.findAll();
        IDataSet expectedData = new FlatXmlDataSetBuilder().build(
        		AuthorTest.class.getResourceAsStream("/Author/Author.xml"));
        ITable expectedTable = expectedData.getTable("author");
        IDataSet actualData = tester.getConnection().createDataSet();
        ITable actualTale = actualData.getTable("author");
        Assertion.assertEquals(expectedTable, actualTale);
        Assert.assertEquals(expectedData.getTable("author").getRowCount(), assessments.size());
    }

}

