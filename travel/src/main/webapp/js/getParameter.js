//根据传递过来的参数name获取对应的值
function getParameter(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)","i");
    console.log(reg);
    var r = location.search.substr(1).match(reg);
    console.log(r);
    // console.log(r[0]);
    // console.log(r[1]);
    // console.log(r[2]);
    if (r!=null) return (r[2]); return null;
}