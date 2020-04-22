<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Freemarker 入门小 DEMO</title>
    <style>
        html {
            font-size: 14px;
            font-weight: 400;
        }

        .exp {
            font-size: 12px;
            color: lightgray;
        }
    </style>
</head>
<body>
<h1>freemarker</h1><br>
<p>当前时间:${.now?string("yyyy-MM-dd HH:mm:ss")}</p><br>
<span class="exp">list长度:${list?size}</span><br>
<p>list列表:</p>
<#list list as item >
    ${item},索引:${item_index}
</#list>
    <br>
    <p>Map</p><br>
<#list map?keys as key>
    ${map[key]}
</#list>

    <dt>字符串</dt>
<dd>普通字符串：<span class="exp">${name}</span></dd>
<dd>空字符串：<span class="exp">${null?if_exists}</span></dd>
<dd>是否包含某个字符串：<span class="exp">${name?contains("wWw")?string}</span></dd>
<dd>split分割字符串：<span class="exp">
    <#list "a|b|c"?split("|") as item>
        ${item}
    </#list>
</dd>
<hr>
<#list mapJson?keys as key>
    <option value="${key}">${mapJson[key]}</option>
</#list>
<hr>
<table border="1px" cellpadding="0" cellspacing="0">
    <tr>
        <th>1</th>
        <th>2</th>
        <th>3</th>
        <th>4</th>
    </tr>
    <#list cities as city>
        <tr>
        <td>${city.id}</td>
        <td>${city.provinceId}</td>
        <td>${city.cityName}</td>
        <td>${city.description}</td>
        </tr>
    </#list>
</table>
<hr>
<table id="table" border="1">
    <tr>
        <td width="40%">结果值</td>
        <td width="40%">结果描述</td>
    </tr>

    <assign jsonObject=text?eval>
        <tr>
            <td>${jsonObject.code}</td>
            <td>${jsonObject.message}</td>
        </tr>
    </assign>
</table>
<hr>
<assign jsonString=text?eval>
    ${jsonString.cityName}
</assign>
</body>
</html>