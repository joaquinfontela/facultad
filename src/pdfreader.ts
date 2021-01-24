const fs = require('fs');
const pdf = require('pdf-parse');

let dataBuffer = fs.readFileSync('../pdfs/Ingenieria Civil 2009.pdf');

pdf(dataBuffer).then(function (data: any) {

    console.log(data.numpages);
    console.log(data.numrender);
    console.log(data.info);
    console.log(data.metadata);
    console.log(data.version);
    console.log(data.text);

});

// I need a class that can act as a middleman between this backend and any client.
// All pdfs shall be on its folder and automatically parsed and read.

// There also needs to be some type of structure that can hold all the information
// in the graph.

// A parser must be able to feed the pdf information to said structure.