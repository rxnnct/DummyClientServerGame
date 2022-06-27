<#import "parts/page_skeleton.ftlh" as c>
<#import "parts/login_form.ftlh" as l>

<@c.page>
    <div>
        <@l.logout />
        <span><a href="/user">User list</a></span>
    </div>
</@c.page>