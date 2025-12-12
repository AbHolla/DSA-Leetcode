/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} k
 * @return {ListNode[]}
 */
var splitListToParts = function(head, k) {
    let result = new Array(k).fill(null);

    // Step 1: Count length
    let length = 0;
    let curr = head;
    while (curr) {
        length++;
        curr = curr.next;
    }

    // Step 2: Determine sizes
    let baseSize = Math.floor(length / k);
    let extra = length % k;

    curr = head;

    // Step 3: Split
    for (let i = 0; i < k; i++) {
        if (!curr) {
            result[i] = null;
            continue;
        }

        result[i] = curr;

        let partSize = baseSize + (extra > 0 ? 1 : 0);
        extra--;

        // Move to end of this part
        for (let j = 1; j < partSize; j++) {
            curr = curr.next;
        }

        // Break the chain
        let next = curr.next;
        curr.next = null;
        curr = next;
    }

    return result;
};
