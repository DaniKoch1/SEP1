//$("#fish1Id").animate(function () {
//    swim(this);
//}, "slow", "linear");
//$("#fish2Id").animate(function () {
//    swim(this);
//}, "slow", "linear");
swim("#fish1Id");
swim("#fish2Id");

function randomX(IdRef) {
    var x;
    x = Math.floor(Math.random() * ($(window).width() - $(IdRef).width()));
    return x;
}

function randomY(IdRef) {
    var y;
    y = Math.floor(Math.random() * ($(window).height() - $(IdRef).height()));
    return y;
}
function swim(IdRef) {
    var x, y, v, moveX, moveY;
    x=randomX(IdRef);
    y=randomY(IdRef);
    moveX=x-$(IdRef).offset().left;
    moveY=y-$(IdRef).offset().top;
    
    if(IdRef==="#fish1Id")
        v=Math.sqrt(Math.pow(moveX,2)+Math.pow(moveY,2))*3;
    else
        v=Math.sqrt(Math.pow(moveX,2)+Math.pow(moveY,2))*17;
    $(IdRef).animate({left: x, top: y}, v, "linear", function(){swim(IdRef);});
}
//function swim(IdRef) {
//    var x, y;
//    x=randomX(IdRef);
//    y=randomY(IdRef);
//    $(IdRef).animate({
//        left: x,
//         top: y
//    },"slow", function() {
//        swim(IdRef);
//    });
//}