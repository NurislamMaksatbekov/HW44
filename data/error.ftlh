<#import "layout.ftlh" as main>
<@main.layout>
    <p><b>Ошибка!</b></p>
    <p>Пользователь с таким email уже существует</p>
    <a href="/register" class="btn btn-outline-success my-2 my-sm-0">Попробовать Заново</a>
    <p class="description mt-5">Если у вас уже есть аккаунт вы можете войти по кнопке "Войти"</p>
    <a href="/login" class="btn btn-outline-success my-2 my-sm-0">Войти</a>
</@main.layout>