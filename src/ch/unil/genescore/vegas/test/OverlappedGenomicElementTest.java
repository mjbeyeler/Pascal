
	package ch.unil.genescore.vegas.test;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import ch.unil.genescore.gene.Gene;
import ch.unil.genescore.gene.GenomicElement;
import ch.unil.genescore.vegas.OverlappedGenomicElement;

	public class OverlappedGenomicElementTest {
		// ============================================================================
			// SETUP
			
			@BeforeClass
			public static void testSetup() {
			}

			@AfterClass
			public static void testCleanup() { }
			
			
			// ============================================================================
			// TESTS

			/** Test test statistic */
			@Test			
			public void compareToTest(){
				// test whether overlap chromosome works as expected.
				Gene g1 = new Gene("g1");				
				Gene g2 = new Gene("g2");			
				
				OverlappedGenomicElement el1 = new OverlappedGenomicElement(g1);
				OverlappedGenomicElement el2 = new OverlappedGenomicElement(g2);
			
				g1.setPosition("chr22", 12, 500, true);
				g2.setPosition("chr22", 20, 500, true);
				assertTrue(el1.compareTo(el2)<0);				
				g1.setPosition("chr19", 20, 500, true);
				g2.setPosition("chr2", 20, 500, true);
				assertTrue(el1.compareTo(el2)<0);
				g1.setPosition("chr1", 20, 500, true);
				g2.setPosition("chr2", 1, 1200, true);
				assertTrue(el1.compareTo(el2)<0);
				g1.setPosition("chr2", 20, 500, true);
				g2.setPosition("chr2", 20, 1200, true);
				assertTrue(el1.compareTo(el2)<0);	
			}	
				
			//	OverlappedGenomicElement el = new OverlappedGenomicElement(g1);
			//	OverlappedGenomicElement el2 = new OverlappedGenomicElement(g2);
				
			//	assertTrue(el.isPastElement(el2));
				
				
				
			@Test
			public void runTest(){	
				
				Gene g1 = new Gene("g1");
				OverlappedGenomicElement el = new OverlappedGenomicElement(g1);
				assertTrue(el.getMainElement().id_.equals("g1"));
				assertTrue(el.getAllOverlappedElements().size()==0);
				assertTrue(el.getAllOverlappedElements()!=null);				
				LinkedList<GenomicElement> elList = el.getRecursiveOverlappedElementAtLevelN(0);			
				assertTrue(elList.size()==0);
				assertTrue(elList!=null);
				
				
				OverlappedGenomicElement elOv1 = new OverlappedGenomicElement(new GenomicElement("el1"));
				OverlappedGenomicElement elOv2 = new OverlappedGenomicElement(new GenomicElement("el2"));
				el.addToList(elOv1);
				el.addToList(elOv2);
				
				assertEquals(el.getRecursiveOverlappedElementAtLevelN(0).getFirst(),el.getAllOverlappedElements().getFirst());
				assertEquals(el.getRecursiveOverlappedElementAtLevelN(0).getLast(),el.getAllOverlappedElements().getLast());
				assertEquals(el.getRecursiveOverlappedElementAtLevelN(0),el.getAllOverlappedElements());
			
				assertTrue(el.getRecursiveOverlappedElementAtLevelN(1).isEmpty());
				OverlappedGenomicElement ov3 = new OverlappedGenomicElement(new GenomicElement("el3"));
				elOv1.addToList(ov3);
				assertTrue(el.getRecursiveOverlappedElementAtLevelN(1).size()==1);
				assertTrue(el.getRecursiveOverlappedElementAtLevelN(1).getFirst()==ov3.getMainElement());
				
				OverlappedGenomicElement ov4 = new OverlappedGenomicElement(new GenomicElement("el4"));
				elOv2.addToList(ov4);
				
				assertTrue(el.getRecursiveOverlappedElementAtLevelN(1).size()==2);
				assertTrue(el.getRecursiveOverlappedElementAtLevelN(1).getLast()==ov4.getMainElement());
				
				OverlappedGenomicElement ov5 = new OverlappedGenomicElement(new GenomicElement("el5"));
				ov4.addToList(ov5);
				
				assertTrue(el.getRecursiveOverlappedElementAtLevelN(1).size()==2);
				assertTrue(el.getRecursiveOverlappedElementAtLevelN(1).getLast()==ov4.getMainElement());				
				assertTrue(el.getRecursiveOverlappedElementAtLevelN(2).size()==1);
				assertTrue(el.getRecursiveOverlappedElementAtLevelN(2).getLast()==ov5.getMainElement());				
				assertTrue(el.getRecursiveOverlappedElementAtLevelN(3).isEmpty());
			}
	
}
