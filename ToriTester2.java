
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hanawa
 */
public class ToriTester2 {
    public static void main(String [] args){
        Scanner stdIn = new Scanner(System.in) ;
        
        // ひよこ誕生
        Hiyoko h = new Hiyoko("すみれ", 5.0) ;
        
        // インタフェースで実装したメソッドを使ってみる
        System.out.println("ひよこ，飛ぶ") ;
        h.fly(10.0) ; // 10.0m飛ぶ        
        System.out.println(h.getName()) ;
        System.out.println(h.getWeight()) ;
        
        System.out.println("ひよこ，フライ") ;
        h.fry() ;
        System.out.println(s.getName()) ;
        System.out.println(s.getWeight()) ;
    }
    
}
