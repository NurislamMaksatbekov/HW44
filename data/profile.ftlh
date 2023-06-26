<#import "layout.ftlh" as main>
<@main.layout>
    <form action="/login" method="post">
        <div class="card" style="width: 18rem;">
            <p>Information about you</p>
            <ul class="list-group list-group-flush">
                <#if user?has_content>
                    <li><p><b>Your login: </b> ${user.email}</p></li>
                    <li><p><b>Your password: </b> ${user.password}</p></li>
                </#if>
            </ul>
        </div>
    </form>
</@main.layout>