/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {void} Do not return anything, modify head in-place instead.
 */
var reorderList = function(head) {
    if (!head || !head.next) return;

    // STEP 1: Find middle
    let slow = head, fast = head;
    while (fast && fast.next) {
        slow = slow.next;        // move 1 step
        fast = fast.next.next;   // move 2 steps
    }

    // STEP 2: Reverse second half
    let prev = null, curr = slow.next;
    slow.next = null; // split into two lists
    while (curr) {
        let next = curr.next;
        curr.next = prev;  // reverse link
        prev = curr;
        curr = next;
    }
    // prev = head of reversed second half

    // STEP 3: Merge two lists
    let first = head, second = prev;
    while (second) {
        let temp1 = first.next;
        let temp2 = second.next;

        first.next = second;
        second.next = temp1;

        first = temp1;
        second = temp2;
    }
};
