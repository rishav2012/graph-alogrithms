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
package com.rishav.github.undirectedgraph.bfs.service.impl;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.rishav.github.undirectedgraph.bfs.service.BFSService;
import com.rishav.github.undirectedgraph.ds.Graph;

public class BFSIterativeImpl implements BFSService {

	private boolean[] marked;
	private int[] edgeTo;
	private int s;
	
	public BFSIterativeImpl(Graph graph, int N, int source) {
		this.marked = new boolean[N];
		this.edgeTo = new int[N];
		this.s = source;
	}
		
	public void BFS(Graph graph, int s) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(s);
		marked[s] = true;
		while(!q.isEmpty()) {
			int v = q.remove();
			for(int w: graph.getAdjList().get(v)) {
				if(!marked[w]) {
					q.add(w);
					marked[w] = true;
					edgeTo[w] = v;
				}
			}
		}
	}

	public boolean hasPathTo(int v) {
		return marked[v];
	}

	public Iterable<Integer> pathTo(int v) {
		if(!hasPathTo(v)) return null;
		Stack<Integer> path = new Stack<Integer>();
		for(int x=v;x!=s;x=edgeTo[x]) {
			path.push(x);
		}
		path.push(s);		
		return path;
	}

}
