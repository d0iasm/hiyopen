import java.util.Scanner ;

class Island{
    private int num ; // ひよぺんの総数
    private int hnum ; // ひよ数
    private int pnum ; // ぺん数
    private int total ; // 総販売額
    private HiyoPen first ; // 最初のひよぺん
    private HiyoPen last ; // 最後のひよぺん
    Island(){
        num = 0 ;
        hnum = 0 ;
        pnum = 0 ;
        total = 0 ;
        first = null ;
        last = null ;
        System.out.println("ようこそひよぺんらんどへ") ;
        System.out.println("ここはひよことぺんぎんが仲良く住む島です．") ;
        System.out.println("時にはうれしい出会いもあり，時には悲しい別れもあります．") ;
    }

    void list(int key){
        // 表示すべきひよぺんどもの配列を作る
        HiyoPen [] p = createArray(key) ;
        // もし価格順ならば並べ替えをする(それ以外はID順のまま)．
        if(key==3)
            sort(p) ;
        // 配列の先頭から順に表示する．
        printArray(p) ;
    }
    
    void printArray(HiyoPen [] p){
        for(int i=0;i<p.length;i++){
            System.out.print("["+p[i].getId()+"] ") ;
            if(p[i].getHiyo())
                System.out.print("ヾ(・◇・)ﾉ :");
            else
                System.out.print("<(･｀彡　)з:") ;
            System.out.print(p[i].getName()+"  (\\"+p[i].getPrice()+".-)") ;            
        }
    }
}

class HiyoPen{
    private String name ; // 名前
    private int price ; // 値段
    private boolean hiyo ; // ひよこかどうか
    private int id ; // ID
    private HiyoPen next ; // 次のひよぺん
    private static int total = 1 ;
    HiyoPen(String name, int price, boolean hiyo){
        this.name = name ;
        this.price = price ;
        this.hiyo = hiyo ;
        this.next = null ;
        this.id = total ;
        total ++ ;
    }
    void setNext(HiyoPen p){
        // 次のひよぺんをセット
        this.next = p ;
    }
    HiyoPen getNext(){
        // 次のひよぺんを返す
        return next ;
    }
}

public class HiyoPenLand {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in) ;
        Island hp = new Island() ;
        int cmd = 0 ;
        do{
            System.out.print("1:住む 2:旅立つ 3:一覧表示 0: 終了 => ") ;
            cmd = stdIn.nextInt() ;
            switch(cmd){
                case 0 : // 終了する
                    System.out.println("終了します．") ;
                    break ;
                case 1 : // 住む
                    System.out.print("名前を入力して下さい => ") ;
                    String name = stdIn.next() ;
                    System.out.print("ひよこですか？ぺんぎんですか？ (0:ひよこ 1:ぺんぎん)=> ") ;
                    int x = stdIn.nextInt() ;
                    boolean hiyo = true ; // ひよこかどうか
                    if(x==1)
                        hiyo = false ; // ぺんぎん
                    System.out.print("販売価格を入力して下さい => ") ;
                    int price = stdIn.nextInt() ;
                    hp.moveto(name, price, hiyo) ;
                    break ;
                case 2 : // 旅立つ
                    System.out.print("どの子が旅立ちますか？ => ") ;
                    int id = stdIn.nextInt() ;
                    if(!hp.leave(id)){
                        System.out.println("そんな子はいません．") ;
                    }
                    break ;
                case 3 : // 一覧表示
                    System.out.print("何順に表示しますか？ (0:全部 1:ひよこ 2:ぺんぎん 3:値段順) => ") ;
                    int key = stdIn.nextInt() ;
                    hp.list(key) ;
                    break ;
                default :
                    break ;
            }
        }while(cmd!=0) ;
        System.out.println("この島から総額"+hp.getTotal()+"円分のひよぺんが旅立ちました．") ;
    }
}
