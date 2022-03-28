const Num = 10001;
let arr = new Array(Num).fill(0);

// for (let i = 1; i <= arr.length; i++) {
//   let number = 0;
//   if (i < 10) {
//     number = i + i; //2
//   } else if (10 <= i < 100) {
//     number = i + parseInt(i / 10) + (i % 10);
//   } else if (100 <= i < 1000) {
//     number = i + parseInt(i / 100) + parseInt((i % 100) / 10);
//   } else if (1000 <= i <= 10000) {
//     number = i + parseInt(i / 1000) + (i % 1000);
//   }
//   if (number < Num) {
//     arr[number] = 1;
//   }
// }
for (let i = 1; i <= arr.length; i++) {
  const first = parseInt(i / 1000);
  const second = parseInt((i % 1000) / 100);
  const third = parseInt(((i % 1000) % 100) / 10);
  const fourth = parseInt(((i % 1000) % 100) % 10);
  number = i + first + second + third + fourth;
  if (number < Num) {
    arr[number] = 1;
  }
}

for (let i = 1; i <= arr.length; i++) {
  if (arr[i] === 0) {
    console.log(i);
  }
}
