<#import "layout.ftlh" as main>
<@main.layout>
<table class="table table-striped table-dark">
    <thead class="thead-dark">
    <tr>
        <th scope="col">Имя</th>
        <th scope="col">Фамилия</th>
        <th scope="col">Адрес электронной почты</th>
    </tr>
    </thead>
    <tbody>
    <#list employee as employer>
        <tr>
            <td>${employer.name}</td>
            <td>${employer.surname}</td>
            <td>${employer.email}</td>
            <td><a type="button" class="btn btn-light" href="/employee">Подробнее</a></td>

        </tr>
    </#list>
    </tbody>
</table>
</@main.layout>