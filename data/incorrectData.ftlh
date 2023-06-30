<#import "layout.ftlh" as main>
<@main.layout>
    <p><b>Ошибка</b></p>
    <p>Неправильный логин или пароль!</p>
    <a href="/login" class="btn btn-outline-success my-2 my-sm-0">Попробовать Заново</a>
    <p class="title mt-5">Если у вас нет аккаунта вы можете зарегестрироваться по кнопке "Регистрация"</p>
    <a href="/register" class="btn btn-outline-success my-2 my-sm-0">Регистрация</a>
</@main.layout>
