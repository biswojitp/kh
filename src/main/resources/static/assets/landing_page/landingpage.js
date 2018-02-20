    // ----------------------------------------------
    // Preloader
    // ----------------------------------------------
  (function () {
      $(window).load(function() {
          $('.loader_con').fadeOut();
          $('.loader').delay(350).fadeOut('slow');
      });
  }());


/******************************
        Text Animation
******************************/
jQuery(document).ready(function(s){function e(){a(s(".cd-headline.letters").find("b")),n(s(".cd-headline"))}function a(e){e.each(function(){var e=s(this),a=e.text().split(""),n=e.hasClass("is-visible");for(i in a)e.parents(".rotate-2").length>0&&(a[i]="<em>"+a[i]+"</em>"),a[i]=n?'<i class="in">'+a[i]+"</i>":"<i>"+a[i]+"</i>";var t=a.join("");e.html(t).css("opacity",1)})}function n(i){var e=h;i.each(function(){var i=s(this);if(i.hasClass("loading-bar"))e=u,setTimeout(function(){i.find(".cd-words-wrapper").addClass("is-loading")},p);else if(i.hasClass("clip")){var a=i.find(".cd-words-wrapper"),n=a.width()+10;a.css("width",n)}else if(!i.hasClass("type")){var d=i.find(".cd-words-wrapper b"),l=0;d.each(function(){var i=s(this).width();i>l&&(l=i)}),i.find(".cd-words-wrapper").css("width",l)}setTimeout(function(){t(i.find(".is-visible").eq(0))},e)})}function t(s){var i=o(s);if(s.parents(".cd-headline").hasClass("type")){var e=s.parent(".cd-words-wrapper");e.addClass("selected").removeClass("waiting"),setTimeout(function(){e.removeClass("selected"),s.removeClass("is-visible").addClass("is-hidden").children("i").removeClass("in").addClass("out")},m),setTimeout(function(){d(i,C)},w)}else if(s.parents(".cd-headline").hasClass("letters")){var a=s.children("i").length>=i.children("i").length?!0:!1;l(s.find("i").eq(0),s,a,f),r(i.find("i").eq(0),i,a,f)}else s.parents(".cd-headline").hasClass("clip")?s.parents(".cd-words-wrapper").animate({width:"2px"},v,function(){c(s,i),d(i)}):s.parents(".cd-headline").hasClass("loading-bar")?(s.parents(".cd-words-wrapper").removeClass("is-loading"),c(s,i),setTimeout(function(){t(i)},u),setTimeout(function(){s.parents(".cd-words-wrapper").addClass("is-loading")},p)):(c(s,i),setTimeout(function(){t(i)},h))}function d(s,i){s.parents(".cd-headline").hasClass("type")?(r(s.find("i").eq(0),s,!1,i),s.addClass("is-visible").removeClass("is-hidden")):s.parents(".cd-headline").hasClass("clip")&&s.parents(".cd-words-wrapper").animate({width:s.width()+10},v,function(){setTimeout(function(){t(s)},T)})}function l(i,e,a,n){if(i.removeClass("in").addClass("out"),i.is(":last-child")?a&&setTimeout(function(){t(o(e))},h):setTimeout(function(){l(i.next(),e,a,n)},n),i.is(":last-child")&&s("html").hasClass("no-csstransitions")){var d=o(e);c(e,d)}}function r(s,i,e,a){s.addClass("in").removeClass("out"),s.is(":last-child")?(i.parents(".cd-headline").hasClass("type")&&setTimeout(function(){i.parents(".cd-words-wrapper").addClass("waiting")},200),e||setTimeout(function(){t(i)},h)):setTimeout(function(){r(s.next(),i,e,a)},a)}function o(s){return s.is(":last-child")?s.parent().children().eq(0):s.next()}function c(s,i){s.removeClass("is-visible").addClass("is-hidden"),i.removeClass("is-hidden").addClass("is-visible")}var h=2500,u=3800,p=u-3e3,f=50,C=150,m=500,w=m+800,v=600,T=1500;e()});


jQuery(document).ready(function(){
   $('.web_name').mousemove(function(e){
     var rXP = (e.pageX - this.offsetLeft-$(this).width()/2);
     var rYP = (e.pageY - this.offsetTop-$(this).height()/2);
     $('.web_name').css('text-shadow', +rYP/10+'px '+rXP/80+'px rgb(9, 72, 95), '+rYP/8+'px '+rXP/60+'px rgb(0, 29, 39), '+rXP/70+'px '+rYP/12+'px rgb(0, 0, 0)');
   });
});


$(document).ready(function() {
var movementStrength = 50;
var height = movementStrength / $(window).height();
var width = movementStrength / $(window).width();
$(".main_con .background:first-child").mousemove(function(e){
          var pageX = e.pageX - ($(window).width() / 2);
          var pageY = e.pageY - ($(window).height() / 2);
          var newvalueX = width * pageX * -1 - 25;
          var newvalueY = height * pageY * -1 - 50;
          $('.main_con .background:first-child').css("background-position", newvalueX+"px     "+newvalueY+"px");
});
});

/* Circleslider */

!function(a){"function"==typeof define&&define.amd?define(["jquery"],a):"object"==typeof exports?module.exports=a(require("jquery")):a(jQuery)}(function(a){function b(b,e){function f(){return k(),w.append(x.first().clone()).css("width",B.width*(x.length+1)),g(),r(0),v.move(v.options.start,v.options.interval),v}function g(){G&&(b[0].ontouchstart=u,b[0].ontouchmove=q,b[0].ontouchend=s),y.bind("mousedown",u);var c=function(b){return b.preventDefault(),b.stopImmediatePropagation(),v.stop(),v.move(a(this).attr("data-slide-index")),!1};G&&b.delegate(".dot","touchstart",c),b.delegate(".dot","mousedown",c)}function h(a){E=setTimeout(function(){v.move(v.slideCurrent+1,!0)},a?50:v.options.intervalTime)}function i(a){return a*(Math.PI/180)}function j(a){return 180*a/Math.PI}function k(){var c=document.createDocumentFragment();z.remove(),x.each(function(b,d){var e=null,f=parseInt(a(d).attr("data-degrees"),10)||360*b/v.slidesTotal,g={top:-Math.cos(i(f))*v.options.radius+A.height/2-D.height/2,left:Math.sin(i(f))*v.options.radius+A.width/2-D.width/2};z.length>0&&(e=z.clone(),e.addClass(a(d).attr("data-classname")).css(g),c.appendChild(e[0])),v.dots.push({angle:f,slide:d,dot:e})}),v.dots.sort(function(a,b){return a.angle-b.angle}),a.each(v.dots,function(b,c){a(c.dot).length>0&&a(c.dot).addClass("dot-"+(b+1)).attr("data-slide-index",b).html("<span>"+(b+1)+"</span>")}),b.append(c),z=b.find(".dot")}function l(a,b){var c,d,e;return a>b?(c=a-b,d=-(b+360-a)):(c=a+360-b,d=-(b-a)),e=c<Math.abs(d)?c:d,[e,d,c]}function m(b){var c=9999,d=9999,e=9999,f=0,g=0,h=0;return a.each(v.dots,function(a,i){var j=l(i.angle,b);Math.abs(j[0])<Math.abs(e)&&(e=j[0],h=a),Math.abs(j[1])<Math.abs(c)&&(c=j[1],f=a),Math.abs(j[2])<Math.abs(d)&&(d=j[2],g=a)}),[[h,f,g],[e,c,d]]}function n(a){return 0>a?360+a%-360:a%360}function o(a,b,c){var d=a,e=!1;Math.abs(a)>Math.abs(b)?(d=-b,e=!0):I?requestAnimationFrame(function(){o(d,b+a)}):F=setTimeout(function(){o(d,b+a,.9*c)},c),v.angleCurrent=n(v.angleCurrent-d),r(v.angleCurrent,e)}function p(a){return{x:H?a.targetTouches[0].pageX:a.pageX||a.clientX,y:H?a.targetTouches[0].pageY:a.pageY||a.clientY}}function q(a){var c=b.offset(),d={left:p(a).x-c.left-A.width/2,top:p(a).y-c.top-A.height/2};return v.angleCurrent=n(j(Math.atan2(d.left,-d.top))),I||r(v.angleCurrent),!1}function r(a,c){closestSlidesAndAngles=m(a),closestSlides=closestSlidesAndAngles[0],closestAngles=closestSlidesAndAngles[1],w.css("left",-(closestSlides[1]*B.width+Math.abs(closestAngles[1])*B.width/(Math.abs(closestAngles[1])+Math.abs(closestAngles[2])))),y.css({top:-Math.cos(i(a))*v.options.radius+(A.height/2-C.height/2),left:Math.sin(i(a))*v.options.radius+(A.width/2-C.width/2)}),c&&b.trigger("move",[x[v.slideCurrent],v.slideCurrent])}function s(b){return a(b.target).hasClass("dot")?!1:(v.dragging=!1,b.preventDefault(),a(document).unbind("mousemove mouseup"),y.unbind("mouseup"),v.options.dotsHide&&z.stop(!0,!0).fadeOut("slow"),v.options.dotsSnap&&v.move(m(v.angleCurrent)[0][0]),void 0)}function t(){v.dragging&&(r(v.angleCurrent),requestAnimationFrame(function(){t()}))}function u(b){return b.preventDefault(),H="touchstart"==b.type,v.dragging=!0,a(b.target).hasClass("dot")?!1:(v.stop(),a(document).mousemove(q),a(document).mouseup(s),y.mouseup(s),v.options.dotsHide&&z.stop(!0,!0).fadeIn("slow"),I&&t(),void 0)}this.options=a.extend({},d,e),this._defaults=d,this._name=c;var v=this,w=(b.find(".viewport"),b.find(".overview")),x=w.children(),y=b.find(".thumb"),z=b.find(".dot"),A=(x.find("a"),{width:b.outerWidth(!0),height:b.outerHeight(!0)}),B={width:x.first().outerWidth(!0),height:x.first().outerHeight(!0)},C={width:y.outerWidth(!0),height:y.outerHeight(!0)},D={width:z.outerWidth(),height:z.outerHeight()},E=null,F=null,G="ontouchstart"in window,H=!1,I="requestAnimationFrame"in window;return this.dots=[],this.slideCurrent=0,this.angleCurrent=0,this.slidesTotal=x.length,this.intervalActive=!1,this.start=function(a){return v.options.interval&&(v.intervalActive=!0,h(a)),v},this.stop=function(){return v.intervalActive=!1,clearTimeout(E),v},this.move=function(a){var b=Math.max(0,isNaN(a)?v.slideCurrent:a);b>=v.slidesTotal&&(b=0);var c=v.dots[b]&&v.dots[b].angle,d=l(c,v.angleCurrent)[0],e=d>0?-2:2;return v.slideCurrent=b,o(e,d,50),v.start(),v},f()}var c="tinycircleslider",d={interval:!1,intervalTime:3500,dotsSnap:!1,dotsHide:!0,radius:165,start:0};a.fn[c]=function(d){return this.each(function(){a.data(this,"plugin_"+c)||a.data(this,"plugin_"+c,new b(a(this),d))})}});

    $(document).ready(function()
    {
      $('#rotatescroll').tinycircleslider({ interval: true, dotsSnap: true, dotsHide: false });
    });

/* Circleslider End*/

/* Full Screen */
function toggleFullscreen(e){e=e||document.documentElement,document.fullscreenElement||document.mozFullScreenElement||document.webkitFullscreenElement||document.msFullscreenElement?document.exitFullscreen?document.exitFullscreen():document.msExitFullscreen?document.msExitFullscreen():document.mozCancelFullScreen?document.mozCancelFullScreen():document.webkitExitFullscreen&&document.webkitExitFullscreen():e.requestFullscreen?e.requestFullscreen():e.msRequestFullscreen?e.msRequestFullscreen():e.mozRequestFullScreen?e.mozRequestFullScreen():e.webkitRequestFullscreen&&e.webkitRequestFullscreen(Element.ALLOW_KEYBOARD_INPUT)}

document.getElementById('btnFullscreen').addEventListener('click', function() {
  toggleFullscreen();
});


/* Full Screen End*/

/******************************
    Social Media Menu
******************************/
 $('.trigger').on('click', function(){
  if($(this).closest('.social-media').find('.links').hasClass('closed')){
    $(this).addClass('open');
    $(this).closest('.social-media').find('.links').removeClass('closed').show().find('ul').animate({
      width: "13em"
    }, 1000, function(){
    });    
  } else {  
    $(this).closest('.social-media').find('.links').addClass('closed').find('ul').animate({
      width: "0"
    }, 1000, function(){
      $(this).closest('.links').hide();
      $(this).closest('.social-media').find('.trigger').removeClass('open');
    }); 
  }                 
});

/******************************
    On Click Parallax
******************************/

$("#home").click(function() {
  $("#section1").css("transform", "translate3d(0px, -15vh, 0px)");
  $("#section1 .content-wrapper").css("transform", "translateY(15vh)");

  $("#section2").css("transform", "translate3d(0px, -30vh, 0px)");
  $("#section2 .content-wrapper").css("transform", "translateY(30px)");

  $("#section3").css("transform", "translate3d(0px, -15vh, 0px)");
  $("#section3 .content-wrapper").css("transform", "translateY(15vh)");

  $("#section4").css("transform", "translate3d(0px, -15vh, 0px)");
  $("#section4 .content-wrapper").css("transform", "translateY(15vh)");

});

$("#about").click(function() {
  $("#section1").css("transform", "translate3d(0px, -130vh, 0px)");
  $("#section1 .content-wrapper").css("transform", "translateY(40px)");

  $("#section2").css("transform", "translate3d(0px, -15vh, 0px)");
  $("#section2 .content-wrapper").css("transform", "translateY(15vh)");
});

$("#services").click(function() {
  $("#section1").css("transform", "translate3d(0px, -130vh, 0px)");
  $("#section1 .content-wrapper").css("transform", "translateY(40px)");

  $("#section2").css("transform", "translate3d(0px, -130vh, 0px)");
  $("#section2 .content-wrapper").css("transform", "translateY(40px)");

  $("#section3").css("transform", "translate3d(0px, -15vh, 0px)");
  $("#section3 .content-wrapper").css("transform", "translateY(15vh)");
});

$("#contact").click(function() {
  $("#section1").css("transform", "translate3d(0px, -130vh, 0px)");
  $("#section1 .content-wrapper").css("transform", "translateY(40px)");

  $("#section2").css("transform", "translate3d(0px, -130vh, 0px)");
  $("#section2 .content-wrapper").css("transform", "translateY(40px)");

  $("#section3").css("transform", "translate3d(0px, -130vh, 0px)");
  $("#section3 .content-wrapper").css("transform", "translateY(40px)");

  $("#section4").css("transform", "translate3d(0px, -15vh, 0px)");
  $("#section4 .content-wrapper").css("transform", "translateY(15vh)");

});

/*****************************
    Responsive Clicks
*****************************/
function aboutnavR() {
  $("#aboutleft").fadeOut();
  $("#aboutright").fadeIn(1000);
  $("#aboutnavR").fadeOut();
  $("#aboutnavL").fadeIn(1000);
}
function aboutnavL() {
  $("#aboutleft").fadeIn(1000);
  $("#aboutright").fadeOut();
  $("#aboutnavR").fadeIn(1000);
  $("#aboutnavL").fadeOut();
}

function contactR() {
  $("#contactleft").fadeOut();
  $("#contactform").fadeIn(1000);
  $("#contactR").fadeOut();
  $("#contactL").fadeIn(1000);
}
function contactL() {
  $("#contactleft").fadeIn(1000);
  $("#contactform").fadeOut();
  $("#contactR").fadeIn(1000);
  $("#contactL").fadeOut();
}





















