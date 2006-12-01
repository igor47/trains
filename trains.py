#!/usr/bin/python

import os, sys
import re

class AdjacencyList:
	def __init__(self):
		self._list = dict()
	
	def addEdge(self,V1,V2,D):
		if not self._list.has_key(V1):
			self._list[V1] = dict()
		if not self._list.has_key(V2):
			self._list[V2] = dict()

		self._list[V1][V2] = D
	
	def dist(self,V1,V2):
		if not self._list.has_key(V1):
			raise Exception, "No such node %s" % V1
		try:
			return self._list[V1][V2]
		except KeyError:
			raise Exception, "No such route"

class Graph:
	#the constructor parses the graph into adjacency-list representation
	def __init__(self,graphData):
		self.adjList = AdjacencyList()	
		graphData = re.sub("[^\w,]",'',graphData)	#strip invalid chars from data
		edges = graphData.split(',')
		for edge in edges:
			assert len(edge) >= 3
			distance = int(edge[2:])
			self.adjList.addEdge(edge[0],edge[1],distance)
		
	def routeDist(self,route):
		stops = route.split(',')
		dist = 0
		for i in range(len(stops)-1):
			try:
				d = self.adjList.dist(stops[i],stops[i+1])
			except Exception, e:
				return e
			dist = dist + d
		return dist
		

def main(gFilename):
	gfile = open(gFilename)
	gdata = gfile.read()
	gfile.close()
	
	try:
		graph = Graph(gdata)
		del gdata
	except:
		e = sys.exc_info()
		print "Error parsing graph data", sys.excepthook(e[0],e[1],e[2])
		return

	output = list()
	output.append(graph.routeDist("A,B,C"))
	output.append(graph.routeDist("A,D"))
	output.append(graph.routeDist("A,D,C"))
	output.append(graph.routeDist("A,E,B,C,D"))
	output.append(graph.routeDist("A,E,D"))

	for i in range(len(output)):
		print "Output #%i: " % (i+1), output[i]

if __name__ == "__main__":
	try:
		gfile = sys.argv[1]			#get the filename of graph file
		sys.exit(main(gfile))		
	except IndexError:
		e = sys.exc_info()
		print sys.excepthook(e[0],e[1],e[2])
		print "Usage: %s <filename>" % (sys.argv[0])
