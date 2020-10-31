/*
 * The MIT License
 * Copyright © 2020 Rishav Kumar
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
 */
package com.rishav.github.undirectedgraph.dfs;

import com.rishav.github.undirectedgraph.dfs.service.ConnectedComponents;
import com.rishav.github.undirectedgraph.ds.Graph;

public class CCImpl implements ConnectedComponents {
	
	private boolean[] marked;
	private int[] id;
	private int count;

	public void CC(Graph G, int N) {
		marked = new boolean[N];
		id = new int[N];
			
		for(int v=0; v < N; v++) {
			if(!marked[v]) {
				dfs(G, v);
				count++;
			}
		}
		
	}

	public int count() {
		return count;
	}

	public int id(int v) {
		return id[v];
	}
	
	private void dfs(Graph G, int v) {
		marked[v] =  true;
		id[v] = count;
		for(int w: G.getAdjList().get(v)) {
			if(!marked[w]) {
				dfs(G,w);
			}
		}
	}
	

}
