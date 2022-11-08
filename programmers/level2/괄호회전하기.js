function solution(s) {
  var answer = 0;
  let arr = [...s];
  arr.forEach((e) => {
    const lotated = lotate(arr);
    const deleteResult = deleteArr(lotated).length;
    if (deleteResult === 0) answer++;
  });

  return answer;
}

const lotate = (arr) => {
  const first = arr.shift();
  arr.push(first);
  return [...arr];
};

const deleteArr = (arr) => {
  const inputLength = arr.length;
  for (let i = 0; i < arr.length; i++) {
    if (arr[i] === "(" && arr[i + 1] === ")") {
      arr[i] = 0;
      arr[i + 1] = 0;
    }
    if (arr[i] === "{" && arr[i + 1] === "}") {
      arr[i] = 0;
      arr[i + 1] = 0;
    }
    if (arr[i] === "[" && arr[i + 1] === "]") {
      arr[i] = 0;
      arr[i + 1] = 0;
    }
  }
  let str = "";
  arr.forEach((e) => {
    if (e !== 0) str += e;
  });

  if (inputLength === str.length) return str;
  else return deleteArr([...str]);
};

solution("}]()[{");
