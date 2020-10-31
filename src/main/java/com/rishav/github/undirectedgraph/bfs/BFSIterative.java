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
package com.rishav.github.undirectedgraph.bfs;

import java.util.Arrays;
import java.util.List;

import com.rishav.github.undirectedgraph.bfs.service.BFSService;
import com.rishav.github.undirectedgraph.bfs.service.impl.BFSIterativeImpl;
import com.rishav.github.undirectedgraph.ds.Edge;
import com.rishav.github.undirectedgraph.ds.Graph;

public class BFSIterative {

	public static void main(String[] args) {
		List<Edge> edges = Arrays.asList(
				new Edge(1, 2), new Edge(1, 7), new Edge(1, 8),
				new Edge(2, 3), new Edge(2, 6), new Edge(3, 4),
				new Edge(3, 5), new Edge(8, 9), new Edge(8, 12),
				new Edge(9, 10), new Edge(9, 11), new Edge(6,9));
		
		int N = edges.size()+1;
		
		Graph graph = new Graph(edges, N);
		boolean[] marked =  new boolean[N];
		
		BFSService bfsIterative = new BFSIterativeImpl(graph, N, 0);
		bfsIterative.BFS(graph, 0);
			
	}
}
