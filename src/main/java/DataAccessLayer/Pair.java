package DataAccessLayer;

public class Pair<F, S> {
    public F first = null;
    public S second = null;


    public Pair(F first, S second){
        this.first = first;
        this.second = second;
    }


    public void imprimir(){
        System.out.println(this.first + " " + this.second);
    }

}
