function solution(s) {
  var answer = [];
  const word_list = s.split(" ");

  let tmp = "";
  word_list.forEach((word) => {
    for (let i = 0; i < word.length; i++) {
      tmp += i % 2 === 0 ? word[i].toUpperCase() : word[i].toLowerCase();
      //   console.log(tmp);
    }
    answer.push(tmp);
    tmp = "";
  });
  return answer.join(" ");
}

console.log(solution("try hello world"));
