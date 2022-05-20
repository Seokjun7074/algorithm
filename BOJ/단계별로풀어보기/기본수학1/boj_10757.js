const fs = require("fs");
const filepath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = fs.readFileSync(filepath).toString().trim().split(" ");

const A = BigInt(input[0]);
const B = BigInt(input[1]);

console.log((A + B).toString());

//BigIntBigInt는
//Number 원시 값이 안정적으로 나타낼 수 있는 최대치인 2^53 - 1보다
//큰 정수를 표현할 수 있는 내장 객체
