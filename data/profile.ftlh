<#import "layout.ftlh" as main>
<@main.layout>
    <style>
        .title {
            color: white;
        }
    </style>
    <#if employee?has_content>
        <div class="mb-5 card bg-dark" style="width: 18rem;">
            <div class="card-header">
                <b class="title ">THIS IS YOUR PROFILE</b>
            </div>
            <ul class="list-group list-group-flush">
                <li class="list-group-item">Name: ${employee.name}</li>
                <li class="list-group-item">Surname: ${employee.surname}</li>
                <li class="list-group-item">Email: ${employee.email}</li>
            </ul>
        </div>
        <div class="card">
            <div class="card-body">
                <h5 class="card-title">READING BOOKS</h5>
                <#list employee.reading as reading>
                    <li class="d-flex justify-content-between mb-2">${reading.title}
                        <form action="/backBook" method="post">
                            <input type="hidden" name="bookId" id="${reading.id}">
                            <button type="button" class="btn btn-primary">BACK</button>
                        </form>
                    </li>
                </#list>
            </div>
        </div>
        <div class="mt-5 card">
        <div class="card-body">
            <h5 class="card-title">READ BOOKS</h5>
            <#list employee.read as read>
                <li>${read.title}</li>
            </#list>
        </div>
    </#if>
    </ul>
    </div>
    </form>
</@main.layout>