const fs = require("fs");
const filepath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = fs.readFileSync(filepath).toString().trim();
//ljes=njak

let croatia = ["c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="];
for (let e of croatia) {
  input = input.split(e).join("0");
}
console.log(input.length);
