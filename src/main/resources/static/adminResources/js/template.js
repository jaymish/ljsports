if("undefined"==typeof jQuery)throw new Error("template requires jQuery");!function(t){"use strict";var e="fabadmin.layout",n={slimscroll:!0,resetHeight:!0},o=".wrapper",i=".content-wrapper",s=".layout-boxed",a=".main-footer",r=".main-header",c=".sidebar",l=".control-sidebar",d=".sidebar-menu",h=".main-header .logo",f="fixed",p="hold-transition",u=function(t){this.options=t,this.bindedResize=!1,this.activate()};function g(o){return this.each(function(){var i=t(this),s=i.data(e);if(!s){var a=t.extend({},n,i.data(),"object"==typeof o&&o);i.data(e,s=new u(a))}if("string"==typeof o){if(void 0===s[o])throw new Error("No method named "+o);s[o]()}})}u.prototype.activate=function(){this.fix(),this.fixSidebar(),t("body").removeClass(p),this.options.resetHeight&&t("body, html, "+o).css({height:"auto","min-height":"100%"}),this.bindedResize||(t(window).resize(function(){this.fix(),this.fixSidebar(),t(h+", "+c).one("webkitTransitionEnd otransitionend oTransitionEnd msTransitionEnd transitionend",function(){this.fix(),this.fixSidebar()}.bind(this))}.bind(this)),this.bindedResize=!0),t(d).on("expanded.tree",function(){this.fix(),this.fixSidebar()}.bind(this)),t(d).on("collapsed.tree",function(){this.fix(),this.fixSidebar()}.bind(this))},u.prototype.fix=function(){t(s+" > "+o).css("overflow","hidden");var e=t(a).outerHeight()||0,n=t(r).outerHeight()+e,d=t(window).height(),h=t(c).height()||0;if(t("body").hasClass(f))t(i).css("min-height",d-e);else{var p;d>=h?(t(i).css("min-height",d-n),p=d-n):(t(i).css("min-height",h),p=h);var u=t(l);void 0!==u&&u.height()>p&&t(i).css("min-height",u.height())}},u.prototype.fixSidebar=function(){t("body").hasClass(f)?this.options.slimscroll&&void 0!==t.fn.slimScroll&&(t(c).slimScroll({destroy:!0}).height("auto"),t(c).slimScroll({height:t(window).height()-t(r).height()+"px",color:"rgba(0,0,0,0.2)",size:"3px"})):void 0!==t.fn.slimScroll&&t(c).slimScroll({destroy:!0}).height("auto")};var m=t.fn.layout;t.fn.layout=g,t.fn.layout.Constuctor=u,t.fn.layout.noConflict=function(){return t.fn.layout=m,this},t(window).on("load",function(){g.call(t("body"))})}(jQuery),function(t){"use strict";var e="fabadmin.pushmenu",n={collapseScreenSize:767,expandOnHover:!1,expandTransitionDelay:200},o=".sidebar-collapse",i=".main-sidebar",s=".content-wrapper",a=".sidebar-form .form-control",r='[data-toggle="push-menu"]',c=".sidebar-mini",l=".sidebar-expanded-on-hover",d=".fixed",h="sidebar-collapse",f="sidebar-open",p="sidebar-expanded-on-hover",u="sidebar-mini-expand-feature",g="expanded.pushMenu",m="collapsed.pushMenu",b=function(t){this.options=t,this.init()};function v(o){return this.each(function(){var i=t(this),s=i.data(e);if(!s){var a=t.extend({},n,i.data(),"object"==typeof o&&o);i.data(e,s=new b(a))}"toggle"==o&&s.toggle()})}b.prototype.init=function(){(this.options.expandOnHover||t("body").is(c+d))&&(this.expandOnHover(),t("body").addClass(u)),t(s).on(function(){t(window).width()<=this.options.collapseScreenSize&&t("body").hasClass(f)&&this.close()}.bind(this)),t(a).on(function(t){t.stopPropagation()})},b.prototype.toggle=function(){var e=t(window).width(),n=!t("body").hasClass(h);e<=this.options.collapseScreenSize&&(n=t("body").hasClass(f)),n?this.close():this.open()},b.prototype.open=function(){t(window).width()>this.options.collapseScreenSize?t("body").removeClass(h).trigger(t.Event(g)):t("body").addClass(f).trigger(t.Event(g))},b.prototype.close=function(){t(window).width()>this.options.collapseScreenSize?t("body").addClass(h).trigger(t.Event(m)):t("body").removeClass(f+" "+h).trigger(t.Event(m))},b.prototype.expandOnHover=function(){t(i).hover(function(){t("body").is(c+o)&&t(window).width()>this.options.collapseScreenSize&&this.expand()}.bind(this),function(){t("body").is(l)&&this.collapse()}.bind(this))},b.prototype.expand=function(){setTimeout(function(){t("body").removeClass(h).addClass(p)},this.options.expandTransitionDelay)},b.prototype.collapse=function(){setTimeout(function(){t("body").removeClass(p).addClass(h)},this.options.expandTransitionDelay)};var x=t.fn.pushMenu;t.fn.pushMenu=v,t.fn.pushMenu.Constructor=b,t.fn.pushMenu.noConflict=function(){return t.fn.pushMenu=x,this},t(document).on("click",r,function(e){e.preventDefault(),v.call(t(this),"toggle")}),t(window).on("load",function(){v.call(t(r))})}(jQuery),function(t){"use strict";var e="fabadmin.tree",n={animationSpeed:500,accordion:!0,followLink:!1,trigger:".treeview a"},o=".treeview",i=".treeview-menu",s=".menu-open, .active",a='[data-widget="tree"]',r=".active",c="menu-open",l="tree",d="collapsed.tree",h="expanded.tree",f=function(e,n){this.element=e,this.options=n,t(this.element).addClass(l),t(o+r,this.element).addClass(c),this._setUpListeners()};function p(o){return this.each(function(){var i=t(this);if(!i.data(e)){var s=t.extend({},n,i.data(),"object"==typeof o&&o);i.data(e,new f(i,s))}})}f.prototype.toggle=function(t,e){var n=t.next(i),s=t.parent(),a=s.hasClass(c);s.is(o)&&(this.options.followLink&&"#"!=t.attr("href")||e.preventDefault(),a?this.collapse(n,s):this.expand(n,s))},f.prototype.expand=function(e,n){var o=t.Event(h);if(this.options.accordion){var a=n.siblings(s),r=a.children(i);this.collapse(r,a)}n.addClass(c),e.slideDown(this.options.animationSpeed,function(){t(this.element).trigger(o)}.bind(this))},f.prototype.collapse=function(e,n){var i=t.Event(d);e.find(s).removeClass(c),n.removeClass(c),e.slideUp(this.options.animationSpeed,function(){e.find(s+" > "+o).slideUp(),t(this.element).trigger(i)}.bind(this))},f.prototype._setUpListeners=function(){var e=this;t(this.element).on("click",this.options.trigger,function(n){e.toggle(t(this),n)})};var u=t.fn.tree;t.fn.tree=p,t.fn.tree.Constructor=f,t.fn.tree.noConflict=function(){return t.fn.tree=u,this},t(window).on("load",function(){t(a).each(function(){p.call(t(this))})})}(jQuery),function(t){"use strict";var e="fabadmin.controlsidebar",n={slide:!0},o=".control-sidebar",i='[data-toggle="control-sidebar"]',s=".control-sidebar-open",a=".control-sidebar-bg",r=".wrapper",c=".layout-boxed",l="control-sidebar-open",d="collapsed.controlsidebar",h="expanded.controlsidebar",f=function(t,e){this.element=t,this.options=e,this.hasBindedResize=!1,this.init()};function p(o){return this.each(function(){var i=t(this),s=i.data(e);if(!s){var a=t.extend({},n,i.data(),"object"==typeof o&&o);i.data(e,s=new f(i,a))}"string"==typeof o&&s.toggle()})}f.prototype.init=function(){t(this.element).is(i)||t(this).on("click",this.toggle),this.fix(),t(window).resize(function(){this.fix()}.bind(this))},f.prototype.toggle=function(e){e&&e.preventDefault(),this.fix(),t(o).is(s)||t("body").is(s)?this.collapse():this.expand()},f.prototype.expand=function(){this.options.slide?t(o).addClass(l):t("body").addClass(l),t(this.element).trigger(t.Event(h))},f.prototype.collapse=function(){t("body, "+o).removeClass(l),t(this.element).trigger(t.Event(d))},f.prototype.fix=function(){t("body").is(c)&&this._fixForBoxed(t(a))},f.prototype._fixForBoxed=function(e){e.css({position:"absolute",height:t(r).height()})};var u=t.fn.controlSidebar;t.fn.controlSidebar=p,t.fn.controlSidebar.Constructor=f,t.fn.controlSidebar.noConflict=function(){return t.fn.controlSidebar=u,this},t(document).on("click",i,function(e){e&&e.preventDefault(),p.call(t(this),"toggle")})}(jQuery),function(t){"use strict";var e="fabadmin.boxwidget",n={animationSpeed:500,collapseTrigger:'[data-widget="collapse"]',removeTrigger:'[data-widget="remove"]',collapseIcon:"fa-minus",expandIcon:"fa-plus",removeIcon:"fa-times"},o=".box",i=".collapsed-box",s=".box-body",a=".box-footer",r=".box-tools",c="collapsed-box",l="collapsed.boxwidget",d="expanded.boxwidget",h="removed.boxwidget",f=function(t,e){this.element=t,this.options=e,this._setUpListeners()};function p(o){return this.each(function(){var i=t(this),s=i.data(e);if(!s){var a=t.extend({},n,i.data(),"object"==typeof o&&o);i.data(e,s=new f(i,a))}if("string"==typeof o){if(void 0===s[o])throw new Error("No method named "+o);s[o]()}})}f.prototype.toggle=function(){!t(this.element).is(i)?this.collapse():this.expand()},f.prototype.expand=function(){var e=t.Event(d),n=this.options.collapseIcon,o=this.options.expandIcon;t(this.element).removeClass(c),t(this.element).find(r).find("."+o).removeClass(o).addClass(n),t(this.element).find(s+", "+a).slideDown(this.options.animationSpeed,function(){t(this.element).trigger(e)}.bind(this))},f.prototype.collapse=function(){var e=t.Event(l),n=this.options.collapseIcon,o=this.options.expandIcon;t(this.element).find(r).find("."+n).removeClass(n).addClass(o),t(this.element).find(s+", "+a).slideUp(this.options.animationSpeed,function(){t(this.element).addClass(c),t(this.element).trigger(e)}.bind(this))},f.prototype.remove=function(){var e=t.Event(h);t(this.element).slideUp(this.options.animationSpeed,function(){t(this.element).trigger(e),t(this.element).remove()}.bind(this))},f.prototype._setUpListeners=function(){var e=this;t(this.element).on("click",this.options.collapseTrigger,function(t){t&&t.preventDefault(),e.toggle()}),t(this.element).on("click",this.options.removeTrigger,function(t){t&&t.preventDefault(),e.remove()})};var u=t.fn.boxWidget;t.fn.boxWidget=p,t.fn.boxWidget.Constructor=f,t.fn.boxWidget.noConflict=function(){return t.fn.boxWidget=u,this},t(window).on("load",function(){t(o).each(function(){p.call(t(this))})})}(jQuery),function(t){"use strict";var e="fabadmin.todolist",n={iCheck:!1,onCheck:function(){},onUnCheck:function(){}},o={data:'[data-widget="todo-list"]'},i="done",s=function(t,e){this.element=t,this.options=e,this._setUpListeners()};function a(o){return this.each(function(){var i=t(this),a=i.data(e);if(!a){var r=t.extend({},n,i.data(),"object"==typeof o&&o);i.data(e,a=new s(i,r))}if("string"==typeof a){if(void 0===a[o])throw new Error("No method named "+o);a[o]()}})}s.prototype.toggle=function(t){t.parents(o.li).first().toggleClass(i),t.prop("checked")?this.check(t):this.unCheck(t)},s.prototype.check=function(t){this.options.onCheck.call(t)},s.prototype.unCheck=function(t){this.options.onUnCheck.call(t)},s.prototype._setUpListeners=function(){var e=this;t(this.element).on("change ifChanged","input:checkbox",function(){e.toggle(t(this))})};var r=t.fn.todoList;t.fn.todoList=a,t.fn.todoList.Constructor=s,t.fn.todoList.noConflict=function(){return t.fn.todoList=r,this},t(window).on("load",function(){t(o.data).each(function(){a.call(t(this))})})}(jQuery),function(t){"use strict";var e="fabadmin.directchat",n='[data-widget="chat-pane-toggle"]',o=".direct-chat",i="direct-chat-contacts-open",s=function(t){this.element=t};function a(n){return this.each(function(){var o=t(this),i=o.data(e);i||o.data(e,i=new s(o)),"string"==typeof n&&i.toggle(o)})}s.prototype.toggle=function(t){t.parents(o).first().toggleClass(i)};var r=t.fn.directChat;t.fn.directChat=a,t.fn.directChat.Constructor=s,t.fn.directChat.noConflict=function(){return t.fn.directChat=r,this},t(document).on("click",n,function(e){e&&e.preventDefault(),a.call(t(this),"toggle")}),t(".inner-content-div").slimScroll({height:"200"}),t(".sm-scrol").slimScroll({height:"250"}),t(".direct-chat-messages").slimScroll({height:"310"}),t(".search-box a, .search-box .app-search .srh-btn").on("click",function(){t(".app-search").toggle(200)}),t(document).on("click",".box-btn-close",function(){t(this).parents(".box").fadeOut(600,function(){1==t(this).parent().children().length?t(this).parent().remove():t(this).remove()})}),t(document).on("click",".box-btn-slide",function(){t(this).toggleClass("rotate-180").parents(".box").find(".box-content, .box-body").slideToggle()}),t(document).on("click",".box-btn-maximize",function(){t(this).parents(".box").toggleClass("box-maximize").removeClass("box-fullscreen")}),t(document).on("click",".box-btn-fullscreen",function(){t(this).parents(".box").toggleClass("box-fullscreen").removeClass("box-maximize")}),t(document).on("click",'a[href="#"]',function(t){t.preventDefault()}),t(".open-left-block").on("click",function(){t(".left-block").toggleClass("open-panel"),t(".open-left-block").toggleClass("mdi-menu")}),t(document).on("click",".file-browser",function(){var e=t(this);if(e.hasClass("form-control"))setTimeout(function(){e.closest(".file-group").find('[type="file"]').trigger("click")},300);else{var n=e.closest(".file-group").find('[type="file"]');n.on("click",function(t){t.stopPropagation()}),n.trigger("click")}}),t(document).on("change",'.file-group [type="file"]',function(){for(var e=t(this)[0],n=e.files.length,o="",i=0;i<n;++i)o+=e.files.item(i).name+", ";o=o.substr(0,o.length-2),t(this).closest(".file-group").find(".file-value").val(o).text(o).focus()}),t(document).on("change",".custom-file-input",function(){var e=t(this).val().split("\\").pop();t(this).next(".custom-file-control").attr("data-input-value",e)}),t(".custom-file-control:not([data-input-value])").attr("data-input-value","Choose file..."),t(".todo-list").todoList({onCheck:function(){window.console.log(t(this),"The element has been checked")},onUnCheck:function(){window.console.log(t(this),"The element has been unchecked")}})}(jQuery);