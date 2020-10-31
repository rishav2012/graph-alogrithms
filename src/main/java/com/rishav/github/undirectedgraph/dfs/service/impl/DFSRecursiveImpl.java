/*******************************************************************************
 * Copyright 2020 rishav.kumar
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.  You may obtain a copy
 * of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations under
 * the License.
 ******************************************************************************/
package com.rishav.github.undirectedgraph.dfs.service.impl;


import java.util.List;
import java.util.Stack;

import com.rishav.github.undirectedgraph.dfs.service.DFSService;
import com.rishav.github.undirectedgraph.ds.Graph;

public class DFSRecursiveImpl implements DFSService {

	private boolean[] marked;
	private int[] edgeTo;
	int s;
	
	public DFSRecursiveImpl(Graph graph, int N, int s) {
		this.marked = new boolean[N];
		this.edgeTo = new int[N];
		this.s = s;
	}
	
	
	public boolean hasPathTo(int v) {
		return marked[v];
	}
	
	public Iterable<Integer> pathTo(int v){
		if(!hasPathTo(v)) return null;
		Stack<Integer> path = new Stack<Integer>();
		for(int x=v;x!=s;x=edgeTo[x]) {
			path.push(x);
		}
		path.push(s);		
		return path;
	}

	public void DFS(Graph graph, int v) {
		marked[v] =  true;
		System.out.println(v + " ");
		List<Integer> adj = graph.getAdjList().get(v);
		for(Integer w: adj) {
			if(!marked[w]) {
				DFS(graph, w);
				edgeTo[w] = v;
			}
		}		
	}
	
}
