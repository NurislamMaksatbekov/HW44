<#import "layout.ftlh" as main>
<@main.layout>
<table class="table table-warning">
    <thead>
    <tr>
        <th scope="col">Название</th>
        <th scope="col">Автор</th>
        <th scope="col">Статус</th>
    </tr>
    </thead>
    <tbody>
    <#list books as item>
        <tr class="bg-success">
            <td>${item.book.title}</td>
            <td>${item.book.author}</td>
            <td>${item.book.status?string('Свободна', 'Занята')}</td>
            <td><a type="button" class="btn btn-dark" href="/books/book?id=${item.book.id}">Подробнее</a></td>
        </tr>
    </#list>

    </tbody>
</table>
</@main.layout>