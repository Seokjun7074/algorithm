function solution(n, costs) {
  let answer = 0;
  costs.sort((a, b) => a[2] - b[2]);

  const parents = [];
  for (let i = 0; i < n; i++) {
    parents.push(i);
  }

  const find = (x) => {
    if (parents[x] === x) {
      return x;
    }
    return (parents[x] = find(parents[x]));
  };

  const union = (a, b) => {
    const pa = find(a);
    const pb = find(b);

    if (pa !== pb) {
      if (pa < pb) {
        parents[pb] = pa;
      } else {
        parents[pa] = pb;
      }
      return true;
    }
    return false;
  };

  costs.forEach(([s, e, c]) => {
    if (union(s, e)) {
      answer += c;
    }
  });

  return answer;
}
