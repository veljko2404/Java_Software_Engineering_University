package exercises.zad25;

import exercises.zad06.Array;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

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

    public ArrayList<Okvir> naciOkvire();

    public Par maxPravaca(ArrayList<Okvir> okviri);
}

class Par {
    private Slika slika;
    private int brojPravaca;

    public Par(Slika slika, int brojPravaca) {
        this.slika = slika;
        this.brojPravaca = brojPravaca;
    }

    public Slika getSlika() {
        return slika;
    }

    public int getBrojPravaca() {
        return brojPravaca;
    }
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
        if (d % 2 == 0) return broj_karaktera;
        else return 0;
    }

    @Override
    public ArrayList<Okvir> naciOkvire() {
        return new ArrayList<Okvir>();
    }

    @Override
    public Par maxPravaca(ArrayList<Okvir> okviri) {
        return null;
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

    @Override
    public ArrayList<Okvir> naciOkvire() {
        return new ArrayList<Okvir>();
    }

    @Override
    public Par maxPravaca(ArrayList<Okvir> okviri) {
        int broj = 0;
        for (int i = 0; i < okviri.size(); i++) {
            if (godina >= okviri.get(i).getGodinaOd() && godina <= okviri.get(i).getGodinaDo()) {
                broj++;
            }
        }
        return new Par(this, broj);
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

    public Celina() {
        list=new ArrayList<>();
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
        for (int i = 0; i < list.size(); i++) result += list.get(i).brojKarakteraNaParnojDubini(d + 1);
        return result;
    }

    @Override
    public ArrayList<Okvir> naciOkvire() {
        ArrayList<Okvir> okviri = new ArrayList<Okvir>();
        for (int i = 0; i < list.size(); i++) okviri.addAll(list.get(i).naciOkvire());
        return okviri;
    }

    @Override
    public Par maxPravaca(ArrayList<Okvir> okviri) {
        Par rezultat = new Par(null, 0);
        for (int i = 0; i < list.size(); i++) {
            Par par_i = list.get(i).maxPravaca(okviri);
            if (par_i != null) {
                if (par_i.getBrojPravaca() > -rezultat.getBrojPravaca()) {
                    rezultat = par_i;
                }
            }
        }
        if (rezultat.getSlika() == null)
            return null;
        else
            return new Par(rezultat.getSlika(), rezultat.getBrojPravaca());
    }
}

class Pravac extends Celina {
    private String naziv;
    private int godinaOd, godinaDo;

    public Pravac(String naziv, int godinaOd, int godinaDo) {
        super();
        this.naziv = naziv;
        this.godinaOd = godinaOd;
        this.godinaDo = godinaDo;
    }

    @Override
    public ArrayList<Okvir> naciOkvire() {
        ArrayList<Okvir> okviri = super.naciOkvire();
        okviri.add(new Okvir(godinaOd, godinaDo));
        return okviri;
    }
}

class Knjiga extends Celina {
    public Knjiga() {
        super();
    }

    @Override
    public void dodajElement(Element e) {
        if (e instanceof Pravac) super.dodajElement(e);
    }
}

class Okvir {
    private int godinaOd, godinaDo;

    public Okvir(int godinaOd, int godinaDo) {
        this.godinaOd = godinaOd;
        this.godinaDo = godinaDo;
    }

    public int getGodinaOd() {
        return godinaOd;
    }

    public int getGodinaDo() {
        return godinaDo;
    }
}

class Singleton{
    private static Singleton instanca = null;
    private Scanner s;
    private Singleton() throws FileNotFoundException {
        s=new Scanner(new File("ulaz.txt"));
    }
    public static Singleton getInstance() throws FileNotFoundException {
        if(instanca==null) {
            instanca = new Singleton();
        }
        return instanca;
    }
    public Element kreirajElement(String nazivElementa) throws FileNotFoundException {
        Singleton singleton = getInstance();
        if(nazivElementa=="Pasus"){
            int v=s.nextInt();
            int v_p=s.nextInt();
            int broj=s.nextInt();
            return new Pasus(v,v_p,broj);
        }
        if(nazivElementa=="Slika"){
            int sirina=s.nextInt();
            int visina=s.nextInt();
            int visina_p=s.nextInt();
            int godina=s.nextInt();
            return new Slika(sirina,visina,visina_p,godina);
        }
        if(nazivElementa=="Celina"){
            return new Celina();
        }

        if(nazivElementa=="Pravac"){
            String naziv = s.nextLine();
            int godinaOd=s.nextInt();
            int godinaDo=s.nextInt();
            return new Pravac(naziv,godinaOd,godinaDo);
        }
        if(nazivElementa=="Knjiga"){
            return new Knjiga();
        }
        return null;
    }
}

public class main {
    public static void main(String[] args) {

    }
}
