<#import "parts/page_skeleton.ftlh" as c>
<#import "parts/login_form.ftlh" as l>

<@c.page>
    <div class="mb-1">Add new user</div>
    ${message?ifExists}
    <@l.login "/registration" true />
</@c.page>