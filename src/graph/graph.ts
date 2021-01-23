const Graph = require('graphology');

const graph = new Graph();
graph.addNode('A');
graph.addNode('B');
graph.addEdge('A', 'B');
graph.addNode('C');

console.log('Number of nodes', graph.order);
console.log('Number of edges', graph.size);

graph.forEachNode(node => {
    graph.forEachNeighbor(node, neighbor => console.log(node, neighbor));
});