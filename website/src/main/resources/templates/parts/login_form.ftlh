<#macro login path isRegisterForm>
    <form action="${path}" method="post">
        <div>
            <label>User Name :</label>
            <div>
                <input type="text" name="username" value="<#if user??>${user.username}</#if>"
                       class=class="form-control <#if (errorMap['textError'])??>is-invalid</#if>"
                       placeholder="User name" />
                <#if usernameError??>
                    <div class="invalid-feedback">
                        ${usernameError}
                    </div>
                </#if>
            </div>
        </div>
        <div class="form-group row">
            <label>Password:</label>
            <div>
                <input type="password" name="password"
                       class="form-control <#if (errorMap['textError'])??>is-invalid</#if>"
                       placeholder="Password" />
                <#if passwordError??>
                    <div class="invalid-feedback">
                        ${passwordError}
                    </div>
                </#if>
            </div>
        </div>
        <#if isRegisterForm>
            <div class="form-group row">
                <label>Password:</label>
                <div>
                    <input type="password" name="passwordConfirmation"
                           class="form-control <#if (errorMap['textError'])??>is-invalid</#if>"
                           placeholder="Retype password" />
                    <#if passwordConfirmationError??>
                        <div class="invalid-feedback">
                            ${passwordConfirmationError}
                        </div>
                    </#if>
                </div>
            </div>
        </#if>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <#if !isRegisterForm><a href="/registration">Add new user</a></#if>
        <button type="submit"><#if isRegisterForm>Create<#else>Sign In</#if></button>
    </form>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit">Sign Out</button>
    </form>
</#macro>

