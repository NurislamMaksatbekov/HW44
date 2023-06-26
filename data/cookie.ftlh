<#import "layout.ftlh" as main>
<@main.layout>
    <div style="margin-left: 20px;">
        <h1> Visited ${times} <#if times==1>time<#else>times</#if>
        </h1>

        <#if globalVisit??>
            <h2> Global visit counter ${globalVisit} <#if globalVisit==1>time<#else>times</#if> (until server restart)
            </h2>
        </#if>

        <#if cookies??>
            <ul>
                <#list cookies as name, value>
                    <li> <b>${name}</b> - <span style="background-color: lightgray;">${value}</span> </li>
                </#list>
            </ul>
        </#if>

    </div>
</@main.layout>