package org.cis1200;

import org.junit.jupiter.api.Test;
import java.io.StringReader;
import java.io.BufferedReader;

import static org.junit.jupiter.api.Assertions.*;

/** Tests for FileLineIterator */
public class FileLineIteratorTest {

    /*
     * Here's a test to help you out, but you still need to write your own.
     */

    @Test
    public void testHasNextAndNext() {

        // Note we don't need to create a new file here in order to test out our
        // FileLineIterator if we do not want to. We can just create a
        // StringReader to make testing easy!
        String words = "0, The end should come here.\n"
                + "1, This comes from data with no duplicate words!";
        StringReader sr = new StringReader(words);
        BufferedReader br = new BufferedReader(sr);
        FileLineIterator li = new FileLineIterator(br);
        assertTrue(li.hasNext());
        assertEquals("0, The end should come here.", li.next());
        assertTrue(li.hasNext());
        assertEquals("1, This comes from data with no duplicate words!", li.next());
        assertFalse(li.hasNext());
    }

    /* **** ****** **** WRITE YOUR TESTS BELOW THIS LINE **** ****** **** */
    @Test
    public void testNoNext() {
        String words = "0, Only one line.";
        StringReader sr = new StringReader(words);
        BufferedReader br = new BufferedReader(sr);
        FileLineIterator li = new FileLineIterator(br);
        assertTrue(li.hasNext());
        assertEquals("0, Only one line.", li.next());
        assertFalse(li.hasNext());
    }

    @Test
    public void testOnlyOneNext() {
        String words = "0, First line.\n"
                + "1, Second line.";
        StringReader sr = new StringReader(words);
        BufferedReader br = new BufferedReader(sr);
        FileLineIterator li = new FileLineIterator(br);
        assertTrue(li.hasNext());
        assertEquals("0, First line.", li.next());
        assertTrue(li.hasNext());
        assertEquals("1, Second line.", li.next());
        assertFalse(li.hasNext());
    }

    @Test
    public void testEmptyPhrase() {
        String words = "";
        StringReader sr = new StringReader(words);
        BufferedReader br = new BufferedReader(sr);
        FileLineIterator li = new FileLineIterator(br);
        assertFalse(li.hasNext());
    }

    @Test
    public void testSpace() {
        String words = " ";
        StringReader sr = new StringReader(words);
        BufferedReader br = new BufferedReader(sr);
        FileLineIterator li = new FileLineIterator(br);
        assertTrue(li.hasNext());
        assertEquals(" ", li.next());
        assertFalse(li.hasNext());
    }

    @Test
    public void testNothing() {
        String words = "0, First line.\n";
        StringReader sr = new StringReader(words);
        BufferedReader br = new BufferedReader(sr);
        FileLineIterator li = new FileLineIterator(br);
        assertTrue(li.hasNext());
        assertEquals("0, First line.", li.next());
        assertFalse(li.hasNext());
    }

}
