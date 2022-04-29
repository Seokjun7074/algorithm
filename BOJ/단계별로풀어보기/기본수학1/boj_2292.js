const fs = require("fs");
const filepath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = fs.readFileSync(filepath).toString().trim().split(" ");

let N = Number(input);
let room = 1;
let sum = 1;
while (sum < N) {
  sum += 6 * room;
  room++;
}
console.log(room);
