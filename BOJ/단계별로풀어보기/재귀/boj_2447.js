const fs = require("fs");
const filepath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = fs.readFileSync(filepath).toString().trim().split("\n");

for (let i = 0; i < 3; i++) {
  console.log("*".repeat(3));
}

