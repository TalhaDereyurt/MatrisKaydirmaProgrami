/**
 * @file : MatrisKaydirmaProgrami.java
 * @description : Kullanicidan alinan satir, sutun ve 0 ile kac degerli arasinda
 * olmasi gerektigine gore matris olusturan ve bu matrisin kenar ve koselerinde
 * bulunan elemanlari belirlenen yon ve adet miktarinca donduren ve ekrana yazan
 * program.
 * @assignment : Proje 02
 * @date : 06.12.2020
 * @author : Talha Mahmut Dereyurt / talhamahmut.dereyurt@stu.fsm.edu.tr
 */
package matriskaydirmaprogrami;

import java.util.Scanner;

public class MatrisKaydirmaProgrami {

    // bu metot menude girilen secenek degerinin dogru mu girildigini kontrol ediyor.
    public static char secenekKontrol(String secenek) {
        Scanner input = new Scanner(System.in);
        char menuSecenek = secenek.charAt(0);
        if (secenek.length() != 1) {
            System.out.println("Lutfen gecerli bir secenek giriniz...");
            menuSecenek = 'H'; // 'H' hatayi belirtiyor.
        } else if (menuSecenek != '1' && menuSecenek != '2' && menuSecenek != '3' && menuSecenek != '4' && menuSecenek != '5') {
            System.out.println("Lutfen gecerli bir secenek giriniz...");
            menuSecenek = 'H'; // 'H' hatayi belirtiyor.
        } else if (menuSecenek == '1') {
            menuSecenek = '1';
        } else if (menuSecenek == '2') {
            menuSecenek = '2';
        } else if (menuSecenek == '3') {
            menuSecenek = '3';
        } else if (menuSecenek == '4') {
            menuSecenek = '4';
        } else if (menuSecenek == '5') {
            menuSecenek = '5';
        }
        while (menuSecenek == 'H') { // Hata oldugunda surekli secenegi sormasi icin while dongusu kullandim.
            System.out.println("1. Uygulamayi calistir");
            System.out.println("2. Matris olustur");
            System.out.println("3. Direction");
            System.out.println("4. Step number");
            System.out.println("5. Exit");
            System.out.print("Secenek: ");
            secenek = input.next();
            menuSecenek = secenekKontrol(secenek);
        }
        return menuSecenek;
    }

    //bu metotda matrisin bilgilerini tutan arrayi alip, istenilen matrisi olusturup return ediyor.
    public static int[][] bilgidenMatrisOlustur(int[] bilgiTutucu) {
        int[][] matris = new int[bilgiTutucu[0]][bilgiTutucu[1]];
        for (int i = 0; i < matris.length; i++) {
            for (int j = 0; j < matris[i].length; j++) {
                matris[i][j] = (int) (Math.random() * bilgiTutucu[3]);
            }
        }
        return matris;
    }

    // bu metot rakamlardan olusan string degeri integera cevirip integer olarak return ediyor.
    public static int stringToInt(String deger) {
        int sayi = 0;
        for (int i = 0; i < deger.length(); i++) {
            sayi = sayi * 10 + ((int) deger.charAt(i) - 48);
        }
        return sayi;
    }

    // bu metot menudeki 2. secenek secildiginde degerlerin dogru sekilde girilmesini kontrol ediyor.
    public static void menuMatrisOlustur(int[] bilgiTutucu) {
        Scanner input = new Scanner(System.in);
        System.out.print("Olusturmak istediginiz matrisin satir boyutunu giriniz: ");
        String satirBoyutu = input.nextLine();
        boolean satirKontrol = true;
        while (satirKontrol == true) {
            for (int i = 0; i < satirBoyutu.length(); i++) {
                if (((int) (satirBoyutu.charAt(i)) - 48) >= 0 && ((int) (satirBoyutu.charAt(i) - 48)) <= 9 // sadece rakam girilmesini ve
                        && ((int) satirBoyutu.charAt(i)) != 32 && stringToInt(satirBoyutu) >= 3) {       //bosluk olmamasini kontrol ediyor.
                    satirKontrol = false;
                    if (i == satirBoyutu.length() - 1 && ((int) satirBoyutu.charAt(i)) != 32) { // son rakama kadar dogru girildiyse
                        int satir = stringToInt(satirBoyutu);                   // stringi integera ceviren metodumla integera cevirip
                        bilgiTutucu[0] = satir;                                 // arrayde olmasi gereken yere degeri kopyaladim.
                    }
                } else { // yanlis deger girilmesi durumunda yeniden girmesini istiyoruz.
                    System.out.println("Yanlis deger girdiniz. Programin islevini gormek icin satir boyutu 3' den buyuk olmalidir ve arada bosluk olmamalidir.");
                    System.out.print("Satir boyutunu giriniz: ");
                    satirBoyutu = input.nextLine();
                    satirKontrol = true;
                    break;
                }
            }
        }
        System.out.print("Olusturmak istediginiz matrisin sutun boyutunu giriniz: ");
        String sutunBoyutu = input.nextLine();
        boolean sutunKontrol = true;
        while (sutunKontrol == true) {
            for (int i = 0; i < sutunBoyutu.length(); i++) {
                if (((int) (sutunBoyutu.charAt(i)) - 48) >= 0 && ((int) (sutunBoyutu.charAt(i) - 48)) <= 9 // sadece rakam girilmesini ve
                        && ((int) sutunBoyutu.charAt(i)) != 32 && stringToInt(sutunBoyutu) >= 3) {      //bosluk olmamasini kontrol ediyor.
                    sutunKontrol = false;
                    if (i == sutunBoyutu.length() - 1 && ((int) sutunBoyutu.charAt(i)) != 32) { // son rakama kadar dogru girildiyse
                        int sutun = stringToInt(sutunBoyutu);                   // stringi integera ceviren metodumla integera cevirip        
                        bilgiTutucu[1] = sutun;                                 // arrayde olmasi gereken yere degeri kopyaladim.
                    }
                } else { // yanlis deger girilmesi durumunda yeniden girmesini istiyoruz.
                    System.out.println("Yanlis deger girdiniz. Programin islevini gormek icin sutun boyutu 3' den buyuk olmalidir ve arada bosluk olmamalidir.");
                    System.out.print("Sutun boyutunu giriniz: ");
                    sutunBoyutu = input.nextLine();
                    sutunKontrol = true;
                    break;
                }
            }
        }
        System.out.print("Olusturmak istediginiz matrisin 0 ile kaç degerleri arasinda olması gerektigini giriniz: ");
        String aralik = input.nextLine();
        boolean aralikKontrol = true;
        while (aralikKontrol == true) {
            for (int i = 0; i < aralik.length(); i++) {
                if (((int) (aralik.charAt(i)) - 48) >= 0 && ((int) (aralik.charAt(i) - 48)) <= 9 // sadece rakam girilmesini ve
                        && ((int) aralik.charAt(i)) != 32) {                                 //bosluk olmamasini kontrol ediyor.
                    aralikKontrol = false;
                    if (i == aralik.length() - 1 && ((int) aralik.charAt(i)) != 32) { // son rakama kadar dogru girildiyse
                        int aralikDeger = stringToInt(aralik);                  // stringi integera ceviren metodumla integera cevirip
                        bilgiTutucu[3] = aralikDeger;                           // arrayde olmasi gereken yere degeri kopyaladim.
                    }
                } else { // yanlis deger girilmesi durumunda yeniden girmesini istiyoruz.
                    System.out.println("Yanlis deger girdiniz. Aralik degerinin 0'dan buyuk ve aralarinda bosluk olmadan girmelisiniz...");
                    System.out.print("Olusturmak istediginiz matrisin 0 ile kaç degerleri arasinda olması gerektigini giriniz: ");
                    aralik = input.nextLine();
                    aralikKontrol = true;
                    break;
                }
            }
        }
    }

    // bu metot menudeki 3. secenek secildiginde yon degerinin dogru sekilde girilmesini kontrol ediyor.
    public static void menuYonBelirle(int[] bilgiTutucu) {
        Scanner input = new Scanner(System.in);
        boolean kontrol = true;
        System.out.println("Matrisin hangi yonde dondurulecegini giriniz. Saat yonu icin '-1', saat yonunun tersi icin '1' girmelisiniz...");
        System.out.print("Yon giriniz: ");
        String yon = input.nextLine();
        while (kontrol == true) {
            if (yon.length() == 1 && (yon.charAt(0) - 48) == 1) { // girilen yonun uzunlugu 1 ise yon de 1 olmali.
                bilgiTutucu[2] = 1;
                kontrol = false;
            } else if (yon.length() == 2 && yon.charAt(0) == 45 && (yon.charAt(1) - 48) == 1) { // girilen yonun uzunlugu 2 ise yon
                bilgiTutucu[2] = -1;                                                            // -1 olmali.
                kontrol = false;
            } else {
                System.out.println("Yanlis yon girdiniz. Saat yonu icin '-1', saat yonunun tersi icin '1' girmelisiniz...");
                System.out.print("Yon giriniz: ");
                yon = input.nextLine();
            }
        }
    }

    // bu metot menudeki 4. secenek secildiginde adim sayisinin dogru sekilde girilmesini kontrol ediyor.
    public static void menuAdimBelirle(int[] bilgiTutucu) {
        Scanner input = new Scanner(System.in);
        System.out.print("Matrisin kac kere kaydirilacagini giriniz: ");
        String kaydirmaSayisi = input.nextLine();
        boolean kontrol = true;
        while (kontrol == true) {
            for (int i = 0; i < kaydirmaSayisi.length(); i++) {
                if (((int) (kaydirmaSayisi.charAt(i)) - 48) >= 0 && ((int) (kaydirmaSayisi.charAt(i) - 48)) <= 9 // sadece rakam girilmesini ve
                        && ((int) kaydirmaSayisi.charAt(i)) != 32 && stringToInt(kaydirmaSayisi) > 0) {                                        //bosluk olmamasini kontrol ediyor.
                    kontrol = false;
                    if (i == kaydirmaSayisi.length() - 1 && ((int) kaydirmaSayisi.charAt(i)) != 32) { // son rakama kadar dogru girildiyse
                        int kaydirmaAdeti = stringToInt(kaydirmaSayisi);        // stringi integera ceviren metodumla integera cevirip
                        bilgiTutucu[4] = kaydirmaAdeti;                         // arrayde olmasi gereken yere degeri kopyaladim.
                    }
                } else {    // yanlis deger girilmesi durumunda yeniden girmesini istiyoruz.
                    System.out.print("Yanlis deger girdiniz. 0' buyuk bir sayi olacak sekilde matrisin kac kere kaydirilacagini giriniz: ");
                    kaydirmaSayisi = input.nextLine();
                    kontrol = true;
                    break;
                }
            }
        }
    }

    // bu metot matrisi duzgun bicimde ekrana yazdirmami sagliyor.
    public static void matrisYazdir(int[][] matris) {
        for (int i = 0; i < matris.length; i++) {
            for (int j = 0; j < matris[i].length; j++) {
                System.out.print(matris[i][j] + "\t");
            }
            System.out.println("\n");
        }
    }

    // bu metot kaydirma isleminin duzgun bicimde gerceklesmesini sagliyor.
    public static int[][] matrisKaydir(int[][] matris, int[] bilgiTutucu) {
        int[][] yeniMatris = new int[matris.length][matris[0].length]; //ilk once ilk matrisin satir ve sutun boyutuyla ayni yeni bi matris olusturuyoruz
        for (int i = 0; i < matris.length; i++) {         // degerlerini kopyaliyoruz.
            for (int j = 0; j < matris[i].length; j++) {
                yeniMatris[i][j] = matris[i][j];
            }
        }
        if (bilgiTutucu[2] == -1) { // saat yonunde olmasi durumunda buraya girmesini sagliyoruz.
            for (int i = 0; i < matris.length; i++) {
                for (int j = 0; j < matris[i].length; j++) {
                    int geciciSatir = i; // burada gecici satir ve gecici sutun olusturdum. Degisen satir ve sutun degerlerini
                    int geciciSutun = j; // bu degerleri degiserek tutatacagim ve her farkli sayida degismesini saglamak icin for icine yazdim.
                    for (int adimSayisi = bilgiTutucu[4]; adimSayisi > 0; adimSayisi--) {
                        if (geciciSatir == 0 && geciciSutun != matris[i].length - 1) { // burada matrisin ilk satirini kontrol ettim.
                            geciciSutun++;
                        } else if (geciciSutun == matris[i].length - 1 && geciciSatir != matris.length - 1) { // burada matrisin son sutununu kontrol ettim.
                            geciciSatir++;
                        } else if (geciciSatir == matris.length - 1 && geciciSutun != 0) { // burada matrisin son satirini kontrol ettim.
                            geciciSutun--;
                        } else if (geciciSutun == 0 && geciciSatir != 0) { // burada matrisin ilk sutununu kontrol ettim.
                            geciciSatir--;
                        }
                    }
                    yeniMatris[geciciSatir][geciciSutun] = matris[i][j]; // degisimleri yeni matriste yapiyoruz. Kontrolü ise ilk matrisimizde
                }                                                       // yapiyoruz.
            }
        } else if (bilgiTutucu[2] == 1) { // saat yonunun tersinde olmasi durumunda buraya girmesini sagliyoruz.
            for (int i = matris.length - 1; i >= 0; i--) {
                for (int j = matris[0].length - 1; j >= 0; j--) {
                    int geciciSatir = i;
                    int geciciSutun = j;
                    for (int adimSayisi = bilgiTutucu[4]; adimSayisi > 0; adimSayisi--) {
                        if (geciciSutun == matris[i].length - 1 && geciciSatir != 0) { // burada matrisin son satirini kontrol ettim.
                            geciciSatir--;
                        } else if (geciciSatir == 0 && geciciSutun != 0) { // burada matrisin ilk satirini kontrol ettim.
                            geciciSutun--;
                        } else if (geciciSutun == 0 && geciciSatir != matris.length - 1) { // burada matrisin ilk stununu kontrol ettim.
                            geciciSatir++;
                        } else if (geciciSatir == matris.length - 1 && geciciSutun != matris[i].length - 1) { // burada matrisin son satirini kontrol ettim.
                            geciciSutun++;
                        }
                    }
                    yeniMatris[geciciSatir][geciciSutun] = matris[i][j]; // degisimleri yeni matriste yapiyoruz. Kontrolü ise ilk matrisimizde
                }                                                       // yapiyoruz.
            }
        }
        return yeniMatris;
    }

    public static void main(String[] args) {
        int[] bilgiTutucu = {5, 5, -1, 100, 2}; // istenildigi gibi baslangic arrayin degerlerini set ettim.
        int[][] matris = bilgidenMatrisOlustur(bilgiTutucu);
        boolean programKontrol = true; // burada programdan cikilmak istenildiginde kullanmak icin boolean deger olusturdum.
        System.out.println("Cok boyutlu matrislerin koselerinde bulunan elemanlari istenilen yonde"
                + " ve sayida kaydiran uygulamaya hosgeldiniz...");
        while (programKontrol == true) {
            System.out.println("1. Uygulamayi calistir");
            System.out.println("2. Matris olustur");
            System.out.println("3. Direction");
            System.out.println("4. Step number");
            System.out.println("5. Exit");
            System.out.print("Secenek: ");
            Scanner input = new Scanner(System.in);
            String secenek = input.next();
            char menuSecenek = secenekKontrol(secenek);
            if (menuSecenek == '1') {
                System.out.println("Matrisin ilk hali: ");
                matrisYazdir(matris);
                System.out.println("-----------------------------------------");
                if (bilgiTutucu[2] == -1) {
                    System.out.println("Matrisin saat yonunde " + bilgiTutucu[4] + " defa dondurulmus hali: ");
                } else if (bilgiTutucu[2] == 1) {
                    System.out.println("Matrisin saat yonunun tersinde " + bilgiTutucu[4] + " defa dondurulmus hali: ");
                }
                int[][] yeniMatris = matrisKaydir(matris, bilgiTutucu);
                matrisYazdir(yeniMatris);
                for (int i = 0; i < yeniMatris.length; i++) {
                    for (int j = 0; j < yeniMatris[i].length; j++) {
                        matris[i][j] = yeniMatris[i][j];
                    }
                }
                continue;
            } else if (menuSecenek == '2') {
                menuMatrisOlustur(bilgiTutucu);
                matris = bilgidenMatrisOlustur(bilgiTutucu);
            } else if (menuSecenek == '3') {
                menuYonBelirle(bilgiTutucu);
            } else if (menuSecenek == '4') {
                menuAdimBelirle(bilgiTutucu);
            } else if (menuSecenek == '5') {
                System.out.println("Programdan cikis yapildi...");
                programKontrol = false;
                break;
            }
        }
    }
}
