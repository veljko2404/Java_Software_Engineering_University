package exercises.zad23;

/*
Data je matrica celih brojeva. Implementirati Singleton koji treba da obilazi matricu i da
ispisuje njene elemente. Singleton treba da ima dve strategije obilaska matrice:
 1. Obilazi prvo vrste pa kolone. Ako se singleton trenutno nalazi na polju (i, j) sledeci
element koji obilazi je (i, j+1) ili (i+1, 0) ako ne postoji kolona j+1, itd. Kada prebroji deset
neparnih brojeva onda menja strategiju.
 2. Obilazi prvo kolone pa vreste. Ako se singleton trenutno nalazi na polju (i, j) sledeci
element koji obilazi je (i+1, j) ili (i, j+1) ako ne postoji vrsta i+1, itd. Kada prebroji pet
parnih brojeva onda menja strategiju.
*/
public class main {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3,4,5,6},
                {2,3,4,5,6,7},
                {3,4,5,6,7,8},
                {4,5,6,7,8,9}
        };
        int n=4,m=6;
        Singleton singleton = Singleton.getInstance(matrix,n,m,Visit.Right);
        singleton.startVisiting();
    }
}
