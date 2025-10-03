/**
 * @param {number[][]} trips
 * @param {number} capacity
 * @return {boolean}
 */
var carPooling = function(trips, capacity) {
    let loc=Array(1001).fill(0);

    for(let i=0;i<trips.length;i++){
        let [passengers,from,to]=trips[i];
        loc[from]=loc[from]+passengers;
        loc[to]=loc[to]-passengers;
    }

    let usedcapacity=0;

    for(let i=0;i<1001;i++){
        usedcapacity=usedcapacity+loc[i];
        if(usedcapacity>capacity){
            return false;
        }
    }
    return true;
};