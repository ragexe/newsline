$( document ).ready(function() {
    function setFooter(){
        if($(document).height() <= $(window).height()){
            $('.custom_footer').css("top", $(window).height()-80);
        }
    }
    setFooter();
})();