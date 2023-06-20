<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<table class="table table-striped table-dark">
    <thead class="thead-dark">
    <tr>
        <th scope="col">Прочитанные</th>
        <th scope="col">Книги в сумек</th>
    </tr>
    </thead>
    <tbody>
    <#list readBook as read>
        <tr>
            <td>${read.title}</td>
        </tr>
    </#list>
    </tbody>
</table>
</body>
</html>