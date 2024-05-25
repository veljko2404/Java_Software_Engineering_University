package exercises.zad25;

import exercises.zad06.Array;

import java.util.ArrayList;

/*
Knjiga Ilustrovanaistorija umetnosti se bavi pravcima u umetnosti, navodeći tekstualne
opise i ilustracije umetničkih dela istovremeno ih svrstavajući u pravce, njihove
podpravce, varijante,...
Elementarni delovi knjige su pasus, koji je u stvari niz karaktera zajedno sa visinom
jednog karaktera i visinom prostora posle njega, i slika, čije su osobine sirina, visina,
prostor posle nje i godina. Jedan ili više ovih elementarnih delova mogu da čine celinu
koja predstavlja opis umetničkog dela, a više celina veću celinu, i tako redom dok ne
dodjemo do najvećih celina koje zovemo pravac u umetnosi, od kojih je veća
celina knjiga.  Pravac u umetnosti ima osobine naziv i godinaOd i godinaDo u okviru kojih
su nastajala glavna dela koja ga odlikuju, ali neka dela mogu biti i izvan ovog opšteprihvaćenog okvira.
Celina ne može da se sastoji iz više od 10 delova. Biblioteka može da sadrži više knjiga.
Realizovati:
1.    Napisati funkciju za izračunavanje sume površina svih slika u svim knjima.
2.    Napisati funkciju za izračunavanje sume visina karaktera svih pasusa u svim knjima.
3.    Napisati funkciju za izračunavanje broja karaktera u pasusima koji se nalaze na parnoj dubini.
Knjiga1 → Celina1 → Celina2 → Pasus dubina je 4
Knjiga2 → Celina3 → Pasus   dubina je 3
1.    Funkciju za nalaženje godine tako da slika iz te godine može da pripada najvećem
broju opšte prihvaćenih okvira iz date knjige.
2.    Funkciju koja za datu knjigu nalazi broj godina koje pripadaju bar jednom opšte
prihvaćenom okviru.
Kreirati biblioteku:
Knjiga1:
Pravac1: (1600, 1800)\    Grana1 \Delo1    \Pasus1(1000, 8, 20)
                    \Slika1(50, 80, 1656, 20)
                \Delo2    \ Slika1(40, 50, 1595, 20)
Pravac2: (1780, 1850)\    Grana2 \Delo3    \Pasus2(100, 10, 20)
                    \ Pasus3(2000, 9, 20)
                    \ Slika1(50, 50, 1856, 20)
                \Delo4    \ Slika1(40, 40, 1795, 20)
Pasus (broj_karaktera, visina_karaktera, visina_prostora_posle_njega)
Slika (širina, visina, godina, visina_prostora_posle_nje)
Na standardnom izlazu prikazati vrednosti svih funkcija 1 do 3 za knjigu.
*/
interface Element {
    int povrsinaSvihSlika();
    int sumaKaraktera();
    int brojKarakteraNaParnojDubini(int d);
}

class Pasus implements Element {
    private int visina, visina_prostora_posle_njega, broj_karaktera;

    public Pasus(int visina, int visina_prostora_posle_njega, int broj_karaktera) {
        this.visina = visina;
        this.visina_prostora_posle_njega = visina_prostora_posle_njega;
        this.broj_karaktera = broj_karaktera;
    }

    @Override
    public int povrsinaSvihSlika() {
        return 0;
    }

    @Override
    public int sumaKaraktera() {
        return visina;
    }

    @Override
    public int brojKarakteraNaParnojDubini(int d) {
        if(d%2==0) return broj_karaktera;
        else return 0;
    }
}

class Slika implements Element {
    private int sirina, visina, visina_prostora_posle_nje, godina;

    public Slika(int sirina, int visina, int visina_prostora_posle_nje, int godina) {
        this.sirina = sirina;
        this.visina = visina;
        this.visina_prostora_posle_nje = visina_prostora_posle_nje;
        this.godina = godina;
    }

    @Override
    public int povrsinaSvihSlika() {
        return sirina * visina;
    }

    @Override
    public int sumaKaraktera() {
        return 0;
    }

    @Override
    public int brojKarakteraNaParnojDubini(int d) {
        return 0;
    }
}

class Celina implements Element {
    private ArrayList<Element> list;

    public Element getElement(int i) {
        return list.get(i);
    }

    public Celina(ArrayList<Element> list) {
        this.list = list;
    }

    public void dodajElement(Element e) {
        if (list.size() < 10) list.add(e);
    }

    @Override
    public int povrsinaSvihSlika() {
        int result = 0;
        for (int i = 0; i < list.size(); i++) result += list.get(i).povrsinaSvihSlika();
        return result;
    }

    @Override
    public int sumaKaraktera() {
        int result = 0;
        for (int i = 0; i < list.size(); i++) result += list.get(i).sumaKaraktera();
        return result;
    }

    @Override
    public int brojKarakteraNaParnojDubini(int d) {
        int result = 0;
        for (int i = 0; i < list.size(); i++) result += list.get(i).brojKarakteraNaParnojDubini(d+1);
        return result;
    }
}

class Pravac extends Celina {
    private String naziv;
    private int godinaOd, godinaDo;

    public Pravac(ArrayList<Element> list) {
        super(list);
    }
}

class Knjiga extends Celina {
    public Knjiga(ArrayList<Element> list) {
        super(list);
    }

    @Override
    public void dodajElement(Element e) {
        if (e instanceof Pravac) super.dodajElement(e);
    }
}
class Okvir{
    private int godinaOd,godinaDo;

    public Okvir(int godinaOd, int godinaDo) {
        this.godinaOd = godinaOd;
        this.godinaDo = godinaDo;
    }
}
//24:40

public class main {
    public static void main(String[] args) {

    }
}
