<#import "layout.ftlh" as main>
<@main.layout>
<table class="table table-striped table-dark">
    <thead class="thead-dark">
    <tr>
        <th scope="col">Прочитанные</th>
        <th scope="col">Книги в сумке</th>
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
</@main.layout>
