$( document ).ready(function() {
    var docHeight = $('body').height() + 100;
    function setFooter(){
        if(docHeight <= $(window).height()){
            $('.custom_footer').css("top", $(window).height()-80);
        }
    }
    setFooter();
    $( window ).resize(function() {
        if(docHeight <= $(window).height()){
            $('.custom_footer').css("top", $(window).height()-80);
        }
    });
});