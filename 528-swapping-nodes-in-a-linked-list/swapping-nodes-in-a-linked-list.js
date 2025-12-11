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
 * @return {ListNode}
 */
var swapNodes = function(head, k) {
    let first=head;
    for(let i=1;i<k;i++){
        first=first.next;
    }
    let fast=head;
    for(let i=0;i<k;i++){
        fast=fast.next;
    }
    let second=head;
    while(fast!=null){
        fast=fast.next;
        second=second.next;
    }

    let temp=first.val;
    first.val=second.val;
    second.val=temp;

    return head;
};