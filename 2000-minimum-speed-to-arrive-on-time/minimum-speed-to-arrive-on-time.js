/**
 * @param {number[]} dist
 * @param {number} hour
 * @return {number}
 */
var minSpeedOnTime = function(dist, hour) {
    const n = dist.length;

    if (n - 1 >= hour) return -1;

    let left = 1, right = 10_000_000;
    let ans = -1;

    const canReach = (speed) => {
        let time = 0;

        for (let i = 0; i < n - 1; i++) {
            time += Math.ceil(dist[i] / speed);
            if (time > hour) return false;
        }

        time += dist[n - 1] / speed;
        return time <= hour;
    };

    while (left <= right) {
        const mid = Math.floor((left + right) / 2);

        if (canReach(mid)) {
            ans = mid;
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }

    return ans;
};