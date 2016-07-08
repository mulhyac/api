//原地址：http://kelp.phate.org/2011/11/kelp-json-view-json-syntax-highlighting.html
//Apiview增加了注释写法并修复了几处bug
//2014年11月5日 16:26:31
$.extend(jQuery, {
    // json 可傳入 json 或 JavaScript Object
    // container 為輸出的容器，jQuery Object
    JSONView: function(json, container) {
        var ob, comment = [],
            comment_num = 0;
        if (typeof json == 'string')
            ob = JSON.parse(json, function(key, value) {
                if (typeof value == "number" || typeof value == "boolean") {
                    comment.push("");
                }
                if (typeof value != "string") {
                    return value;
                } else {
                    current_value = value.split("###");
                    //存放注释
                    if (current_value.length > 1) {
                        comment.push(current_value[1]);
                    } else {
                        comment.push("");
                    }
                    value = current_value[0];
                    //如果是int类型数据
                    if ("$" == value[value.length - 1]) {
                        number = value.substr(0, value.length - 1);
                        return parseInt(number);
                    }
                    //如果是boolen类型数据
                    if ("true" == value) {
                        return Boolean(1);
                    }
                    if ("false" == value) {
                        return Boolean(0);
                    }
                    return current_value[0];
                }
            });
        else
            ob = json;
        var p, l = [],
            c = container;
        var repeat = function(s, n) { //產生 s 字元 n 次
            return new Array(n + 1).join(s);
        };
        //產生 JSON 結構資料的遞迴函數
        //o     來源物件
        //isar  資料是 true 的話代表這一次遞迴為陣列資料
        //s     遞迴階層數
        var r = function(o, isar, s) {
            for (var n in o) {
                var p = o[n];
                switch (typeof p) {
                    case 'function':
                        break;
                    case 'string':
                        p = p.replace(/</g, '&lt;');
                        p = p.replace(/>/g, '&gt;');
                        jinhao = comment[comment_num] ? "#" : "";
                        if (isar)
                            l.push({
                                Text: '<span class="jsonstring">"' + p + '"</span><span class="jsontag">,</span>',
                                Step: s
                            });
                        else
                            l.push({
                                Text: '<span class="jsonname">"' + n + '"</span><span class="jsontag">: </span><span class="jsonstring">"' + p + '"<span class="jsontag">,</span>&nbsp;&nbsp;<span class="jsonComment">' + jinhao + comment[comment_num] + '</span></span>',
                                Step: s
                            });
                        comment_num++;
                        break;
                    case 'boolean':
                        jinhao = comment[comment_num] ? "#" : "";
                        if (isar)
                            l.push({
                                Text: '<span class="jsonboolean">"' + p + '"</span><span class="jsontag">,</span>',
                                Step: s
                            });
                        else
                            l.push({
                                Text: '<span class="jsonname">"' + n + '"</span><span class="jsontag">: </span><span class="jsonboolean">' + p + '</span><span class="jsontag">,</span>&nbsp;&nbsp;<span class="jsonComment">' + jinhao + comment[comment_num] + '</span></span>',
                                Step: s
                            });
                        comment_num++;
                        break;
                    case 'number':
                        jinhao = comment[comment_num] ? "#" : "";
                        if (isar)
                            l.push({
                                Text: '<span class="jsonnumber">' + p + '</span><span class="jsontag">,</span>',
                                Step: s
                            });
                        else
                            l.push({
                                Text: '<span class="jsonname">"' + n + '"</span><span class="jsontag">: </span><span class="jsonnumber">' + p + '</span><span class="jsontag">,</span>&nbsp;&nbsp;<span class="jsonComment">' + jinhao + comment[comment_num] + '</span></span>',
                                Step: s
                            });
                        comment_num++;
                        break;
                    case 'object':
                        if (p === null) {
                            if (isar)
                                l.push({
                                    Text: '<span class="jsonnull">' + p + '</span><span class="jsontag">,</span>',
                                    Step: s
                                });
                            else
                                l.push({
                                    Text: '<span class="jsonname">"' + n + '"</span><span class="jsontag">: </span><span class="jsonnull">' + p + '</span><span class="jsontag">,</span>',
                                    Step: s
                                });
                        } else if (p.length == undefined) {
                            //object
                            if (!isar) {
                                l.push({
                                    Text: '<span class="jsonname">"' + n + '"</span><span class="jsontag">:</span>',
                                    Step: s
                                });
                            }
                            l.push({
                                Text: '<span class="jsontag">{</span>',
                                Step: s
                            });
                            r(p, false, s + 1);
                            l.push({
                                Text: '<span class="jsontag">},</span>',
                                Step: s
                            });
                        } else {
                            //array
                            if (!isar) {
                                l.push({
                                    Text: '<span class="jsonname">"' + n + '"</span><span class="jsontag">:</span>',
                                    Step: s
                                });
                            }
                            l.push({
                                Text: '<span class="jsontag">[</span>',
                                Step: s
                            });
                            r(p, true, s + 1);
                            l.push({
                                Text: '<span class="jsontag">],</span>',
                                Step: s
                            });
                        }
                        break;
                    default:
                        break;
                }
            }
            var last = l.pop();
            var ct = ',</span>';
            if (last.Text.substr(last.Text.length - ct.length) == ct)
                l.push({
                    Text: last.Text.replace(ct, '</span>'),
                    Step: last.Step
                });
            else
                l.push(last);
        };

        //將 JavaScript Object 格式化塞進 array 中
        if (ob.length == undefined) {
            //object
            l.push({
                Text: '<span class="jsontag">{</span>',
                Step: 0
            });
            r(ob, false, 1);
            l.push({
                Text: '<span class="jsontag">}</span>',
                Step: 0
            });
        } else {
            //array
            l.push({
                Text: '<span class="jsontag">[</span>',
                Step: 0
            });
            r(ob, true, 1);
            l.push({
                Text: '<span class="jsontag">]</span>',
                Step: 0
            });
        }

        //開始輸出
        var f = true; //true為奇數行
        c.html("");
        c.addClass('KelpJSONView');
        c.append('<ol></ol>');
        c = c.find('ol');
        for (var index in l) {
            var jobject = l[index];
            if (f) {
                c.append($('<li class="jsonhighlight">' + repeat(' &nbsp; &nbsp;&nbsp; &nbsp;', jobject.Step) + jobject.Text + '</li>'));
                f = false;
            } else {
                c.append($('<li>' + repeat(' &nbsp; &nbsp;&nbsp; &nbsp;', jobject.Step) + jobject.Text + '</li>'));
                f = true;
            }
        }
        //console.log(comment);
    }
});
