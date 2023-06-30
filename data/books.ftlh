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
        <#list books as book>
            <tr class="bg-success">
                <td>${book.title}</td>
                <td>${book.author}</td>
                <td>${book.status?string('Свободна', 'Занята')}</td>
                <td><a type="button" class="btn btn-dark" href="/books/book?id=${book.id}">Подробнее</a></td>
            </tr>
        </#list>
        </tbody>
    </table>
</@main.layout>