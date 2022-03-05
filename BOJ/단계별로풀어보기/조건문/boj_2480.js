const fs = require("fs");
const filepath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = fs.readFileSync(filepath).toString().split(" ");

const d1 = parseInt(input[0]);
const d2 = parseInt(input[1]);
const d3 = parseInt(input[2]);

if (d1 === d2 && d2 === d3) {
  console.log(d1 * 1000 + 10000);
}
if ((d1 === d2 && d1 !== d3) || (d1 === d3 && d2 !== d3)) {
  console.log(1000 + d1 * 100);
}
if (d2 === d3 && d2 !== d1) {
  console.log(1000 + d2 * 100);
}
if (d1 !== d2 && d2 !== d3 && d1 !== d3) {
  const biggest = [d1, d2, d3].sort().pop();
  console.log(biggest * 100);
}
