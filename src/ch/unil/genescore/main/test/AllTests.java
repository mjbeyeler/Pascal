package ch.unil.genescore.main.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import ch.unil.genescore.gene.test.GenomicElementTest;
import ch.unil.genescore.pathway.test.RankSumTestTest;
import ch.unil.genescore.pathway.test.geneSetLibraryTest;
import ch.unil.genescore.vegas.test.AnalyticVegasTest;
import ch.unil.genescore.vegas.test.DistributionMethodsTest;
import ch.unil.genescore.vegas.test.FarebrotherTest;
import ch.unil.genescore.vegas.test.FileParserTest;
import ch.unil.genescore.vegas.test.GeneResultsNoScoreTest;
import ch.unil.genescore.vegas.test.GeneResultsSnpsOutOfBoundsTest;
import ch.unil.genescore.vegas.test.MTJConvenienceMethodsTest;
import ch.unil.genescore.vegas.test.MaxVegasTest;
import ch.unil.genescore.vegas.test.OverlappedCollectionStreamTest;
import ch.unil.genescore.vegas.test.OverlappedGenomicElementTest;
import ch.unil.genescore.vegas.test.SnpTest;
@RunWith(Suite.class)
//@SuiteClasses({ GenomicElementTest.class, SnpTest.class, AnalyticVegasTest.class, PathwayMainTest.class,MTJConvenienceMethodsTest.class})
@SuiteClasses({
	//TODO: classes not properly covered:
	//Main, PathwayMain,SnpWeightCreator, 
		

	//gene/test
	GenomicElementTest.class,
	
	//pathway/test/
	RankSumTestTest.class,
	geneSetLibraryTest.class,
	FarebrotherTest.class,
	AnalyticVegasTest.class,
	DistributionMethodsTest.class,
	
	MaxVegasTest.class,
	MTJConvenienceMethodsTest.class,
	OverlappedCollectionStreamTest.class,
	OverlappedGenomicElementTest.class,
	
	//ReferencePopulationTest.class, isn't proper unit test
	SnpTest.class,
	GeneResultsSnpsOutOfBoundsTest.class,
	GeneResultsNoScoreTest.class,
	FileParserTest.class,

	
	
	
})
public class AllTests {
	
}
