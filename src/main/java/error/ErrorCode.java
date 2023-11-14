package error;

/**
 * ErrorCode class for defining error codes and messages used in the application.
 * Each error code corresponds to a specific error scenario.
 * This class is developed by Cem AÇAR.
 * Last updated on 10.11.23
 */
public class ErrorCode {

    public static final String WEB_SITE_ACCESS_ERROR = "#00001 Web Sitesine Giriş Sağlanırken Hata İle Karşılaşıldı";
    public static final String LOGIN_ERROR = "#00002 Login İşlemi Sırasında Hata İle Karşılaşıldı";
    public static final String LOGIN_SUCESS_ERROR = "#00003 Kullanıcı Başarılı Bir Şekilde Login Olamadı Beklenmedik Hata";
    public static final String LOGIN_SUCESS_ERROR_2 = "#00004 Kullanıcı Başarılı Bir Şekilde Login Olamadı Kullanıcı Yada Şifre Hatası";
    public static final String POPULERBET_PAGE_ERROR = "#00005 Kullanıcı Populer Bahisler Sayfasına Giriş Yapamadı";
    public static final String POPULERBET_FUTBOL_PAGE_ERROR = "#00006 Kullanıcı Populer Bahisler Sayfasıda Futbol Sekmesine Giriş Yapamadı";
    public static final String POPULERBET_COMPARE = "#00007 İki Data Karşılaştırılırken Hata İle Karşılaşıldı";
}
