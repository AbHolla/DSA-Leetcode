var maxSlidingWindow = function(arr, k) {
  let res = [];
  let q = [];

  let i = j = 0;
  while (j < arr.length) {
    while (q.length && arr[j] > q[q.length - 1]) {
      q.pop();
    }
    q.push(arr[j]);

    if (j >= k - 1) {
      res.push(q[0]);
      if (arr[i] == q[0]) q.shift();
      ++i;
    }
    ++j;
  }
  return res;
};