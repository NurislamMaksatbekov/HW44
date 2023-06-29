<#import "layout.ftlh" as main>
<@main.layout>
                <#if employee?has_content>
                    <div class="card" style="width: 18rem;">
                        <div class="card-header">
                            <b>THIS IS YOUR PROFILE</b>
                        </div>
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item">Name: ${employee.name}</li>
                            <li class="list-group-item">Surname: ${employee.surname}</li>
                            <li class="list-group-item">Email: ${employee.email}</li>
                        </ul>
                    </div>


                </#if>
            </ul>
        </div>
    </form>
</@main.layout>