Feature: Nesine.com Web Otomasyon Case Study
    Scenario: Kullanıcı Nesine.com'a Login Olur
        Given Kullanıcı "https://www.nesine.com" adresine gider
        When Kullanıcı kullanıcı adı  ve şifre ile giriş yapar
        Then Kullanıcı başarıyla giriş yapmış olmalıdır

        And Kullanıcı popüler bahis adresine tıklar
        When Kullanıcı "Futbol" sekmesine tıkladığında
        Then Popüler bahis listesindeki değerle servisteki değerlerin eşit olması beklenir

