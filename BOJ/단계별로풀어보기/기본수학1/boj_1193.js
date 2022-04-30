const fs = require("fs");
const filepath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = parseInt(fs.readFileSync(filepath).toString());

console.log(input);

let group = 1;
let sum = 1;

while (k <= 5) {
  k++;
  sum += k;

  console.log(`k:${k}`);
  console.log(sum);
}
