<#import "layout.ftlh" as main>
<@main.layout>
    <div class="card" style="width: 18rem;">
        <img src="${book.image}" class="card-img-top" alt="${book.title}">
        <div class="card-body">
            <h5 class="card-title">${book.title}</h5>
        </div>
        <ul class="list-group list-group-flush">
            <li class="list-group-item">${book.author}</li>
            <li class="list-group-item">${book.status?string('Свободна', 'Занята')}</li>
        </ul>

            <#if book.status>
        <div class="card-body">
            <a href="#" class="btn btn-primary">TAKE</a>
        </div>
            </#if>
    </div>
</@main.layout>