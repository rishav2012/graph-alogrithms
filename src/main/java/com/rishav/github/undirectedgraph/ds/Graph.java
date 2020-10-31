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
package com.rishav.github.undirectedgraph.ds;
import java.util.*;

public class Graph {

	private List<List<Integer>> adjList = null;
	
	public Graph(List<Edge> edges,int N){
		setAdjList(new ArrayList());
		
		for(int i=0;i<N;i++) {
			getAdjList().add(new ArrayList());
		}
		
		for(Edge edge: edges) {
			int src = edge.source;
			int dest = edge.dest;
			
			getAdjList().get(src).add(dest);
			getAdjList().get(dest).add(src);
		}
	}

	public List<List<Integer>> getAdjList() {
		return adjList;
	}

	public void setAdjList(List<List<Integer>> adjList) {
		this.adjList = adjList;
	}
}
