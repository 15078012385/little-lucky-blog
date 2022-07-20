//处理文章数据
function htmlHandle1(resp) {
    //    终于意识到.....采用模板引擎来操作这些数据、比拼接数据更简便。
    var articleList = "";
    //用户头像
    var userAvatar = "";
    //首图
    var firstImg = "";
    //回显数据
    // console.log(resp);
    // console.log("页数" + resp.pages);
    for (var i = 0; i < resp.data.length; i++) {
        //每一项
        console.log(resp.data[i].id)
        // console.log("标题：===>" + resp.data[i].title)
        // console.log("描述：===>" + resp.data[i].description)
        // console.log("头像：===>" + resp.data[i].userAvatar)
        // console.log("名字：===>" + resp.data[i].userNickname)
        // console.log("发布日期：===>" + resp.data[i].createTime)
        // console.log("浏览量====>" + resp.data[i].views)
        // console.log("首图地址====>" + resp.data[i].firstImg)
        //标题拼接
        articleList += '<!--    文章-->\n' +
            '<div class="jumbotron" style="width: 80%; margin: 0 auto; margin-top: 50px; height: 300px;">\n' +
            '\n' +
            '    <div class="left" style="float: left;display: inline-block; width: 65%; margin-left: 5%;">\n' +
            '        <!--          标题-->\n' +
            '        <a href="' +
            //点击标题跳转，在这改。
            'showArticle.html?id=' + resp.data[i].id +
            //↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑，这个地址带上文章ID。即可查看每一篇文章
            '" style="color: #546de5">\n' +
            '            <h3>';
        articleList += resp.data[i].title;

        //文章描述拼接
        articleList += '</h3>\n' +
            '        </a>\n' +
            '        <!--            缩略文、文章描述-->\n' +
            '        <font color="#636e72">';
        articleList += resp.data[i].description;

        articleList += ' </font>\n' +
            '        <br>\n' +
            '        <br>\n' +
            '        <br>';

        //用户头像单独拿出来，再进行拼接
        userAvatar += '<img src="' + resp.data[i].userAvatar + '" alt="" style="width: 32px; border-radius: 30px;">\n' +
            '        <!-- 作者 -->\n' +
            '        <font style="color: #54a0ff;">';
        //    拼接用户头像
        articleList += userAvatar;

        //拼接完头像后，将其属性赋空
        userAvatar = "";

        //    拼接作者
        articleList += resp.data[i].userNickname;

        articleList += '</font>\n' +
            '        <!-- 发布时间 -->\n' +
            '        <span class="glyphicon glyphicon-calendar" style="text-indent: 20px;"></span>     ';
        //拼接发布时间
        articleList += resp.data[i].createTime;

        articleList += ' <!-- 浏览量 -->\n' +
            '        <span class="glyphicon glyphicon-eye-open"></span>   ';
        // 拼接浏览量
        articleList += resp.data[i].views;
        articleList += '</div>\n' +
            '\n' +
            '    <!-- 文章封面 -->\n' +
            '    <div class="right" style="display: inline-block;width: 25%;">\n' +
            '        <!--          点击图片，会带上文章ID.-->\n' +
            '        <!-- 固定宽度、高，防变形 -->\n' +

            '        <a href="' +
            //点击图片跳转查看文章，在这改。
            'showArticle.html?id=' + resp.data[i].id +
            //↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑，将id放这里
            '">';
        //单独把首图拿出来。
        firstImg += '<img style="width: 100%;height: 200px;"\n' +
            '                                         src="';
        firstImg += resp.data[i].firstImg;
        firstImg += '"\n' +
            '                                         alt="">\n' +
            '        </a>\n' +
            '    </div>\n' +
            '</div>';
        articleList += firstImg;

        //首图 恢复""
        firstImg = "";
    }
    //处理后返回html
    return articleList;
}

//处理标签
function categoryHandle(resp) {
    var categoryHtml = ' <div class="jumbotron" style="width: 80%; margin: 0 auto; margin-top: 50px; ">\n' +
        '            <div style="width: 80%;margin: 0 auto">';
    //标签列表
    var aList = "";
    //  标签颜色type
    var tagType = ["label label-danger", "label label-primary", "label label-success", "label label-info", "label label-warning"];
    //    获取标签颜色
    // console.log(tagType[Math.floor(Math.random() * 3) + 0])

    for (let i = 0; i < resp.data.length; i++) {
        // console.log(resp.data[i].id);
        // console.log(resp.data[i].name);
        //点击标签，跳转查询在这里改
        aList += '<h3 style="display: inline-block;margin-left: 20px">';
        //      标签带ID查询
        aList += '<a href="categoryShow.html?category=' + resp.data[i].name +
            '">\n' +
            '                <span class="';
        //标签上色
        aList += tagType[Math.floor(Math.random() * 5) + 0];
        aList += '">';
        aList += resp.data[i].name;
        aList += '</span>\n' +
            '            </a>';
        aList += '</h3>';
        //    完成一个标签
    }
    //拼接a列表
    categoryHtml += aList;
    //拼接尾
    categoryHtml += '</div>\n' +
        '</div>';

    return categoryHtml;
}

//处理时间线
function timelineHandle(resp) {
    var timelineHtml = "";
    var tagType = ["panel-success", "panel-info", "panel-warning"];
    for (let i = 0; i < resp.data.length; i++) {
        // console.log(resp.data[i].nickName)
        // console.log(resp.data[i].content)
        // console.log(resp.data[i].createTime)
        timelineHtml += '  <div class="historyItem"  >';

        if (i % 2 === 0) {
            timelineHtml += ' <div class="txt" >\n' +
                '                                        <div class="txtContent">\n' +
                '                                            <div class="panel  ';
            timelineHtml += tagType[Math.floor(Math.random() * 3) + 0];
            timelineHtml += '">\n' +
                '                                                <div class="panel-heading">';
            timelineHtml += resp.data[i].nickName;
            timelineHtml += '</div>\n' +
                '                                                <div class="panel-body">';
            timelineHtml += resp.data[i].content;
            timelineHtml += '</div>\n' +
                '                                              </div>\n' +
                '                                        </div>\n' +
                '                                    </div>';
            // ----
            timelineHtml += ' <div class="month" ><span>';
            timelineHtml += resp.data[i].createTime;
            timelineHtml += '</span></div>';
        } else {
            timelineHtml += ' <div class="month" ><span>';
            timelineHtml += resp.data[i].createTime;
            timelineHtml += '</span></div>';

            timelineHtml += ' <div class="txt" >\n' +
                '                                        <div class="txtContent">\n' +
                '                                            <div class="panel  ';
            timelineHtml += tagType[Math.floor(Math.random() * 3) + 0];
            timelineHtml += '">\n' +
                '                                                <div class="panel-heading">';
            timelineHtml += resp.data[i].nickName;
            timelineHtml += '</div>\n' +
                '                                                <div class="panel-body">';
            timelineHtml += resp.data[i].content;
            timelineHtml += '</div>\n' +
                '                                              </div>\n' +
                '                                        </div>\n' +
                '                                    </div>';


        }


        timelineHtml += '</div>';

    }
    return timelineHtml;
}

function messageHandle(resp) {
    var messageHtml = "";
    for (let i = 0; i < resp.data.length; i++) {
        // console.log(resp.data[i].qqNickname);
        // console.log(resp.data[i].qqAvatar);
        // console.log(resp.data[i].messageContent);
        messageHtml += ' <div>\n' +
            '            <!--        头像-->\n' +
            '            <a href="#"> <img src="';
        //拼接头像地址
        messageHtml += resp.data[i].qlogo;
        messageHtml += '" width="70px" height="70px"\n' +
            '                              style="margin-left: 5%;margin-top: 20px;border-radius: 70px">\n' +
            '            </a>\n' +
            '            <!--        昵称、时间-->\n' +
            '            <div style="height: 60%;text-indent: 50px;color: #00a8c6">\n' +
            '                <strong>';
        //拼接昵称
        messageHtml += resp.data[i].name;
        messageHtml += '</strong> <font style="color: silver">' + resp.data[i].messageTime +
            '</font>\n' +
            '            </div>\n' +
            '            <!--        内容-->\n' +
            '            <div style="margin: 0 auto;margin-left: 50px;margin-right: 50px">';
        //    拼接留言内容
        messageHtml += resp.data[i].messageContent;
        messageHtml += '  </div>\n' +
            '        </div>';
    }
    return messageHtml;
}
