const fs = require("fs");
const filepath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = fs.readFileSync(filepath).toString().trim().split("\n");
const T = Number(input[0]);

for (let i = 1; i <= T; i++) {
  const myCase = input[i].split(" ");
  const H = Number(myCase[0]);
  const W = Number(myCase[1]);
  const N = Number(myCase[2]);

  let floor;
  let room;

  if (N % H === 0) {
    floor = H;
    room = parseInt(N / H);
  } else {
    floor = N % H;
    room = parseInt(N / H) + 1;
  }
  console.log(`${floor * 100 + room}`);
}
