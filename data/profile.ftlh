<#import "layout.ftlh" as main>
<@main.layout>
    <form action="/login" method="post">
        <div class="card" style="width: 18rem;">
            <p>Information about you</p>
            <ul class="list-group list-group-flush">
                <#if employee?has_content>
                    <li><p><b>Your login: </b> ${employee.email}</p></li>
                    <li><p><b>Your password: </b> ${employee.password}</p></li>
                </#if>
            </ul>
        </div>
    </form>
</@main.layout>