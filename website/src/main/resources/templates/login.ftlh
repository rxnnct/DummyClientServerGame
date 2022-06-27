<#import "parts/general.ftlh" as c>
<#import "parts/login_form.ftlh" as l>

<@c.page>
    Log In
    <@l.login "/login" />
    <a href="/registration">Register</a>
</@c.page>