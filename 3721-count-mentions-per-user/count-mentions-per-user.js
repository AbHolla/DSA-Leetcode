/**
 * @param {number} numberOfUsers
 * @param {string[][]} events
 * @return {number[]}
 */

var countMentions = function (numberOfUsers, events) {
    const mentions = Array(numberOfUsers).fill(0);
    const offlineUntil = Array(numberOfUsers).fill(0); // 0 = online

    // Convert timestamps to numbers and sort by timestamp
    const ev = events.map(e => [e[0], Number(e[1]), e[2]]);
    ev.sort((a, b) => a[1] - b[1]);

    let i = 0;
    while (i < ev.length) {
        const t = ev[i][1];
        const group = [];

        // Collect all events with same timestamp t
        while (i < ev.length && ev[i][1] === t) {
            group.push(ev[i]);
            i++;
        }

        // 1. Auto-online users whose offline time ended at or before t
        for (let u = 0; u < numberOfUsers; u++) {
            if (offlineUntil[u] !== 0 && offlineUntil[u] <= t) {
                offlineUntil[u] = 0;
            }
        }

        // 2. Process ALL OFFLINE events at this timestamp
        for (const [type, _, val] of group) {
            if (type === "OFFLINE") {
                const id = Number(val);
                offlineUntil[id] = t + 60;
            }
        }

        // 3. Process MESSAGE events
        for (const [type, _, val] of group) {
            if (type !== "MESSAGE") continue;

            const tokens = val.split(" ");

            for (const tok of tokens) {
                if (tok === "ALL") {
                    for (let u = 0; u < numberOfUsers; u++) {
                        mentions[u]++;
                    }
                } else if (tok === "HERE") {
                    for (let u = 0; u < numberOfUsers; u++) {
                        if (offlineUntil[u] === 0) mentions[u]++;
                    }
                } else {
                    // id<number>
                    const id = Number(tok.slice(2));
                    mentions[id]++;
                }
            }
        }
    }

    return mentions;
};
