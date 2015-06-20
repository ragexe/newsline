$( document ).ready(function() {
    if($(document).height() == $(window).height()){
        if($('body') + 80 > $(document).height()){
            $('.custom_footer').css("top", $('body') + 80);
        }
        $('.custom_footer').css("top", $(window).height()-80);
    } else {
        $('.custom_footer').css("top", $(document).height());
    }
});