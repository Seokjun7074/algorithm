const fs = require("fs");
const filepath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = fs.readFileSync(filepath).toString().split("\n");

// console.log(input);
//[ '2', '\n3 ABC', '\n5 /HTP' ]

// console.log(input[0].split(" "));
// console.log(input[1].split(" "));
// console.log(input[2].split(" "));
//
// [ '2\r' ]
// [ '3', 'ABC\r' ]
// [ '5', '/HTP' ]

const T = input[0];

for (let i = 1; i <= T; i++) {
  const R = input[i].split(" ")[0];
  const S = input[i].split(" ")[1].toString();
  let P = "";
  for (let i = 0; i < S.length; i++) {
    P += S[i].repeat(R);
  }
  console.log(P);
}
