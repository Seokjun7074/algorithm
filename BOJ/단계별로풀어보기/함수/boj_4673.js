const Num = 10001;
let arr = new Array(Num).fill(0);

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
