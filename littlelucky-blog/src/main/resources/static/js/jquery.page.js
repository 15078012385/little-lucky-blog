(function ($) {
    var pageObj = {
        init: function (obj, args) {
            return (function () {
                pageObj.fillHtml(obj, args);
                pageObj.bindEvent(obj, args);
                if (typeof (args.backFn) == "function") {//回调第一页函数
                    // args.backFn(1);
                }
            })();
        },

        //填充html
        fillHtml: function (obj, args) {
            return (function () {
                obj.empty();
                //上一页
                if (args.current > 1) {
                    obj.append('<a href="javascript:void(0);" class="prevPage">上一页</a>');
                } else {
                    obj.remove('.prevPage');
                    obj.append('<span class="disabled">上一页</span>');
                }

                //中间页码起始坐标
                var start, end;
                if (args.current > 4) {
                    obj.append('<a href="javascript:void(0);" class="tcdNumber">' + 1 + '</a>');
                    obj.append('<span>...</span>');
                    start = args.current - 2;
                    end = args.current + 2 <= args.pageCount ? args.current + 2 : args.pageCount;
                } else {
                    if (args.current == 4) {
                        start = 1;
                    } else {
                        start = args.current - 2 > 0 ? args.current - 2 : 1;
                    }

                    end = args.current + 2 <= args.pageCount ? args.current + 2 : args.pageCount;
                }

                for (var i = start; i <= end; i++) {
                    if (args.current == i) {
                        obj.append('<span class="current">' + i + '</span>');
                    } else {
                        obj.append('<a href="javascript:void(0);" class="tcdNumber">' + i + '</a>');
                    }
                }
                //
                if (end + 1 < args.pageCount) {
                    obj.append('<span>...</span>');
                    obj.append('<a href="javascript:void(0);" class="tcdNumber">' + args.pageCount + '</a>');
                } else {
                    if (end + 1 == args.pageCount) {//添加最后一页
                        obj.append('<a href="javascript:void(0);" class="tcdNumber">' + args.pageCount + '</a>');
                    }
                }


                //下一页
                if (args.current < args.pageCount) {
                    obj.append('<a href="javascript:;" class="nextPage">下一页</a>');
                } else {
                    obj.remove('.nextPage');
                    obj.append('<span class="disabled">下一页</span>');
                }
            })();
        },


        //绑定事件
        bindEvent: function (obj, args) {
            return (function () {
                obj.on("click", "a.tcdNumber", function () {
                    var current = parseInt($(this).text());
                    pageObj.fillHtml(obj, {"current": current, "pageCount": args.pageCount});
                    if (typeof (args.backFn) == "function") {
                        args.backFn(current);
                    }
                });
                //上一页
                obj.on("click", "a.prevPage", function () {
                    var current = parseInt(obj.children("span.current").text());
                    pageObj.fillHtml(obj, {"current": current - 1, "pageCount": args.pageCount});
                    if (typeof (args.backFn) == "function") {
                        args.backFn(current - 1);
                    }
                });
                //下一页
                obj.on("click", "a.nextPage", function () {
                    var current = parseInt(obj.children("span.current").text());
                    pageObj.fillHtml(obj, {"current": current + 1, "pageCount": args.pageCount});
                    if (typeof (args.backFn) == "function") {
                        args.backFn(current + 1);
                    }
                });
            })();
        }
    }
    $.fn.createPage = function (options) {
        var args = $.extend({
            pageCount: 10,
            current: 1,
            backFn: function () {
            }
        }, options);
        pageObj.init(this, args);
    }
})(jQuery);
