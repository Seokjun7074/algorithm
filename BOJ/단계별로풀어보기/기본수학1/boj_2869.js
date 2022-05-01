const fs = require("fs");
const filepath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = fs.readFileSync(filepath).toString().trim().split(" ");

const [A, B, V] = input.map((e) => Number(e));
//A: 낮에 올라가는 높이
//B: 밤에 미끄러지는 놏이
//V: 총 높이

const oneDay = A - B;
// let day = 1;
// while (true) {
//   if (oneDay * day + A >= V) {
//     day++;
//     break;
//   }
//   day++;
// }
// console.log(day);
//시간초과
let day = (V - A) / oneDay;

console.log(Math.ceil(day) + 1);
