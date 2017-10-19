import java.util.Scanner ;

public class ToriTester {
    public static void main(String [] args){
        Scanner stdIn = new Scanner(System.in) ;
        
        // ひよことすずめのインスタンスの生成
        Hiyoko h = new Hiyoko("すみれ", 5.0) ;
        Suzume s = new Suzume(7.5) ;
        
        // 抽象メソッドを使ってみる
        System.out.println("ひよこ，鳴く") ;
        h.naku(4) ;
        System.out.println("すずめ，鳴く") ;
        s.naku(4) ;
        
        // えさをあげてみる
        h.food(10.0) ;
        s.food(10.0) ;
        
        // 独自のメソッドも使ってみる
        System.out.println("ひよこ") ;
        System.out.print(h.getName()) ;
        System.out.print(" : ") ;
        System.out.println(h.weight) ;
        System.out.print("すずめ") ;
        System.out.print(s.getName()) ;
        System.out.print(" : ") ;
        System.out.print(s.weight) ;
    }
}
