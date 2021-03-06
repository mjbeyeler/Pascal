/*******************************************************************************
 * Copyright (c) 2015 David Lamparter, Daniel Marbach
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 *******************************************************************************/
package ch.unil.genescore.vegas;

import java.util.ArrayList;

import ch.unil.genescore.main.Pascal;
import no.uib.cipr.matrix.DenseMatrix;
import no.uib.cipr.matrix.UpperSymmDenseMatrix;

public class MaxEffVegas extends MaxVegas {
	
	public MaxEffVegas(){
		super();
		pruningCutoff_=Pascal.set.maxPruningCutoff_;	
	}
	public MaxEffVegas(ArrayList<Double> snpScores, UpperSymmDenseMatrix ld, double[] weights) {			
		super(snpScores, ld, weights);
		}

	public MaxEffVegas(ArrayList<Double> snpScores, DenseMatrix ld,	double pruningCutoff) {
		super(snpScores, ld, pruningCutoff);
		
	}
	
	
	@Override
	protected void calculateGenescore(){	
	geneScore_=computeEffectivePval();	
	status_=Status.EFF_NR_OF_TEST_ADJ;
	
	}	
}
