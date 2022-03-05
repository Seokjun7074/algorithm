const fs = require("fs");
const filepath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = fs.readFileSync(filepath).toString().split(" ");

const dan = parseInt(input[0]);

for (let i = 1; i < 10; i++) {
  console.log(`${dan} * ${i} = ${dan * i}`);
}
