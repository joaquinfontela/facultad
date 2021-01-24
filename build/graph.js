"use strict";
var Graph = require('graphology');
var graph = new Graph();
graph.addNode('A');
graph.addNode('B');
graph.addEdge('A', 'B');
graph.addNode('C');
console.log('Number of nodes', graph.order);
console.log('Number of edges', graph.size);
graph.forEachNode(function (node) {
    graph.forEachNeighbor(node, function (neighbor) { return console.log(node, neighbor); });
});
