//enum classlar nasıl gruplayabileceği sabitler ile çalışıyorsa sealed class da gruplayabileceği classlar ile çalışır.
//sealed classların mantığı -> kısıtlanmış bir sınıf hiyerarşisi oluşturmaktır. biz kendimiz de sealed kullanmadan bir sınıf
// hiyerarşisi yaratabiliriz fakat sealed classlar bu kuralları developerdan alarak idenin kontolüne verir.
// sealed classlar başka bir class ı miras alabilirler ve bir interface i implement edebilirler.

sealed class Error(val errorCode: Int) {
    // Her hata türü kendi hata mesajını içerir
    abstract fun errorString(): String

    class NoInternet : Error(100) {
        override fun errorString() =  "İnternet Bağlantısı Yok"
    }

    class ServerError : Error(200) {
        override fun errorString() = "Sunucu Hatası"
    }

    class FileNotFound : Error(400) {
        override fun errorString() = "Dosya Bulunamadı"
    }

}

fun handleError(error: Error) {
    println("Hata Kodu: ${error.errorCode}, Hata Mesajı: ${error.errorString()}")
}

fun main() {
    val error1: Error = Error.NoInternet()
    val error2: Error = Error.ServerError()
    val error3: Error = Error.FileNotFound()

    handleError(error1)
    handleError(error2)
    handleError(error3)

    //kısaca böyle de tanımlanabilir.
    handleError(Error.NoInternet())
    handleError(Error.ServerError())
    handleError(Error.FileNotFound())
}
