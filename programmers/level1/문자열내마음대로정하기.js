function solution(strings, n) {
  return strings.sort((a, b) => {
    if (a[n] > b[n]) return 1;
    else if (a[n] < b[n]) return -1;
    else {
      console.log(a, b);
      return a > b ? 1 : -1;
    }
  });
}

solution(["abce", "abcd", "cdx"], 2);
