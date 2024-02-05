function solution(k, tangerine) {
    var size_count = {}
    tangerine.forEach(x=>isNaN(size_count[x])==true? size_count[x]=1:size_count[x]++)
    let CountOrder = Object.keys(size_count).sort((a,b)=>size_count[b]-size_count[a])
    let kinds = 0;
    while(k>0){k-=size_count[CountOrder[kinds++]]}
    return kinds
}