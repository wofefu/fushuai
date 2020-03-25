 $(function () {
     $(".classify").hover(function () {
         $(".left_nav").show();
     }, function () {
         $(".left_nav").hide();
     });
     $(".left_nav").hover(function () {
         $(this).show();
     }, function () {
         $(this).hide();
     });
 })
