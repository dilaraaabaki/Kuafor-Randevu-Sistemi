document.addEventListener('DOMContentLoaded', function () {
    var form = document.querySelector('form');

    form.addEventListener('submit', function (event) {
        event.preventDefault();

        // Kullanıcı adı ve şifreyi kontrol et
        var username = document.getElementById('username').value;
        var password = document.getElementById('password').value;

        // Örnek: Kullanıcı adı "admin" ve şifre "admin" ise yönlendir
        if (username === 'admin' && password === 'admin') {
            window.location.href = 'admin-panel.html';
        } else {
            alert('Hatalı kullanıcı adı veya şifre!');
        }
    });
});