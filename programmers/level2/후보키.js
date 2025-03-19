function solution(relation) {
  let answer = 0;
  const colNum = relation[0].length;
  const col = [];
  for (let i = 0; i < colNum; i++) {
    col.push(i);
  }
  let combinations = [];
  for (let i = 1; i <= colNum; i++) {
    const comb = combination(col, i);
    combinations.push(...comb);
  }
  combinations = checkUniqueness(relation, combinations);
  answer = checkDuplications(combinations).filter((e) => e).length;

  return answer;
}

function checkUniqueness(relation, combinations) {
  const results = []; // 유일성을 만족하는 조합

  combinations.forEach((combination) => {
    const set = new Set();
    relation.forEach((rel) => {
      set.add(combination.map((combi) => rel[combi]).join(","));
    });
    if (set.size == relation.length) {
      results.push(combination);
    }
  });
  return results;
}

function isSubset(setA, setB) {
  for (let elem of setA) {
    if (!setB.has(elem)) {
      return false;
    }
  }
  return true;
}

function checkDuplications(combinations) {
  const checkList = new Array(combinations.length).fill(true);
  const setCombi = combinations.map((e) => new Set(e));
  for (let i = 0; i < combinations.length; i++) {
    if (!checkList[i]) {
      continue;
    }
    for (let j = i + 1; j < combinations.length; j++) {
      if (isSubset(setCombi[i], setCombi[j])) {
        checkList[j] = false;
      }
    }
  }
  return checkList;
}

function combination(inputArray, num) {
  const result = [];

  function recur(arr, n) {
    if (arr.length === num) {
      result.push(arr);
      return;
    }
    for (let i = n; i < inputArray.length; i++) {
      recur([...arr, inputArray[i]], i + 1);
    }
  }
  recur([], 0);
  return result;
}
