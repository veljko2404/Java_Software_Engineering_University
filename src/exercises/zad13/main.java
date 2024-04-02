package exercises.zad13;

/*
Napisati klasu red koristeci dva Stack-a < int >.
*/
public class main {
    public static void main(String[] args) {
        Queue<Integer> q = new Queue<>();
        q.push(3);
        q.push(4);
        q.push(7);
        q.push(2);

        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.pop());
        q.push(9);
        System.out.println(q.pop());
        System.out.println(q.pop());
    }
}
