const Graph = require('graphology');

const graph = new Graph();
graph.addNode('A');
graph.addNode('B');
graph.addEdge('A', 'B');
graph.addNode('C');

console.log('Number of nodes', graph.order);
console.log('Number of edges', graph.size);

graph.forEachNode((node: any) => {
    graph.forEachNeighbor(node, (neighbor: any) => console.log(node, neighbor));
});
