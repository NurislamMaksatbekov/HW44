<#import "layout.ftlh" as main>
<@main.layout>
<table class="table table-warning">
    <thead>
    <tr>
        <th scope="col">Название</th>
        <th scope="col">Автор</th>
        <th scope="col">Год выпуска</th>
        <th scope="col">Жанр</th>
        <th scope="col">Язык</th>
        <th scope="col">Статус</th>
    </tr>
    </thead>
    <tbody>
    <#list books as book>
        <tr class="bg-success">
            <td>${book.title}</td>
            <td>${book.author}</td>
            <td>${book.year}</td>
            <td>${book.genre}</td>
            <td>${book.language}</td>
            <#if book.status>
                <td>Свободна</td>
            <#else>
                <td>Занята</td>
            </#if>
            <td><a type="button" class="btn btn-dark" href="/book">Подробнее</a></td>
        </tr>
    </#list>
    </tbody>
</table>
</@main.layout>