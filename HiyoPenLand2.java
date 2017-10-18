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

    //case1(住む)の操作
    void moveto(String name, int price, boolean hiyo){
        if(first == null){
            //1羽目が住むとき
            first = new HiyoPen(name, price, hiyo);
            last = first;
        }else{
            //2羽目以降が住むとき
            HiyoPen newhp = new HiyoPen(name, price, hiyo);
            last.setNext(newhp);
            last = newhp;
        }
        num ++;
        if(hiyo == true){
            hnum ++;
        }else{
            pnum ++;
        }
        System.out.println("＼(^▽^)／ようこそ" + name);
    }
    
    //case2(旅立つ)の操作
    boolean leave(int id){
    	boolean inai = true;
        if(0 < id && id <= last.getId()){
            HiyoPen byehp;
            HiyoPen byehp_before;
            if(id == 1){
                //1羽目が旅立つとき
                total += first.getPrice();
                System.out.println("(T_T)/ さよなら" + first.getName());
                num --;
                    if(first.getHiyo() == true){
                        hnum --;
                    }else{
                        pnum --;
                    }
                first = first.getNext();
            }else{
                //2羽目以降が旅立つとき
                byehp_before = first;
                byehp = byehp_before.getNext();
                while(id != byehp.getId()){
                    //指定されたIDのひよぺんにたどり着くまで繰り返す
                    byehp_before = byehp;
                    byehp = byehp.getNext();
                }
                total += byehp.getPrice();
                System.out.println("(T_T)/ さよなら" + byehp.getName());
                num --;
                if(byehp.getHiyo() == true){
                    hnum --;
                }else{
                    pnum --;
                }
                byehp_before.setNext(byehp.getNext());
            }
        }else{
		inai = false;
        }
	return inai;
    }
    
    //case3(一覧表示)の操作
    void list(int key){
        // 表示すべきひよぺんどもの配列を作る
        HiyoPen [] p = createArray(key) ;
        // もし価格順ならば並べ替えをする(それ以外はID順のまま)．
        if(key == 3){
            //値段順に並べる
            sort(p) ;
        }else if(key == 2){
            //ぺんぎんのみ並べる
            for(int i=0; i<p.length; i++){
                if(p[i].getHiyo() == false){
                    System.out.println("[" + p[i].getId() + "]" + "<(･｀彡　)з:" + p[i].getName()+"  (¥"+p[i].getPrice()+".-)");
                }
            }
        }else if(key == 1){
            //ひよこのみ並べる
            for(int i=0; i<p.length; i++){
                if(p[i].getHiyo() == true){
                    System.out.println("[" + p[i].getId() + "]" + "ヾ(・◇・)ﾉ :" + p[i].getName() + "  (¥"+p[i].getPrice()+".-)");
                }
            }
        }else{
            // 配列の先頭から順に表示する．
            printArray(p) ;
        }
    }
    
    //case0(終了)の操作
    int getTotal(){
    	return total;
    }
    
    
    //ひよぺんの配列を作る
    HiyoPen[] createArray(int key){
            HiyoPen [] p = new HiyoPen[num];
            for(int i=0; i<num; i++){
                if(i==0){
                    p[i] = first;
                }else{
                    p[i] = p[(i-1)].getNext();
                }
            }
        return p;
    }
    
    //case3(一覧表示)にて値段順に並べる
    void sort (HiyoPen [] p){
        HiyoPen [] p_sort = p;
        int min = 0;
        for(int j=0; j<num; j++){
            min = j;
            for(int i=0; i<num; i++){
                if(p_sort[min].getPrice() > p_sort[i].getPrice()){
                    HiyoPen kari = p_sort[min];
                    p_sort[min] = p_sort[i];
                    p_sort[i] = kari;
                }
            }
        }
        printArray(p_sort);
    }
    
    //case3(一覧表示)にて順番に表示する
    void printArray(HiyoPen [] p){
        for(int i=0; i<p.length; i++){
            System.out.print("[" + p[i].getId() + "] ") ;
            if(p[i].getHiyo()){
                System.out.print("ヾ(・◇・)ﾉ :");
            }else{
                System.out.print("<(･｀彡　)з:") ;
            }
            System.out.println(p[i].getName() + "  (¥" + p[i].getPrice() + ".-)") ;            
        }
    }

    //case4(修行)の操作
    void training(int n){
        if(0 < n && n <= last.getId()){
            HiyoPen fighthp;
            HiyoPen fighthp_before;
            if(n == 1){
                //1羽目が修行するとき
                fighthp = first;
                fighthp.getFightPrice();
            }else{
                //2羽目以降が修行するとき
                fighthp_before = first;
                fighthp = fighthp_before.getNext();
                while(n != fighthp.getId()){
                    //指定されたIDのひよぺんにたどり着くまで繰り返す
                    fighthp_before = fighthp;
                    fighthp = fighthp.getNext();
                }
                fighthp.getFightPrice();
            }
        }else{
            System.out.println("そんな子はいません．");
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

    String getName(){return name;}
    int getPrice(){return price;}
    int getId(){return id;}
    boolean getHiyo(){return hiyo;}

    void setNext(HiyoPen p){
        // 次のひよぺんをセット
        this.next = p ;
    }

    HiyoPen getNext(){
        // 次のひよぺんを返す
        return next ;
    }

    int getFightPrice(){
        //ひよぺんの値段に１〜１０００の数字をランダムで足す（追加機能）
        int ran = ((int)(Math.random() * 1000)) + 1;
        price = price + ran;
        System.out.println(ran + "円分のスキルアップに成功！");
        return price;
    }
}

public class HiyoPenLand2 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in) ;
        Island hp = new Island() ;
        int cmd = 0 ;
        do{
            System.out.print("1:住む 2:旅立つ 3:一覧表示 4:修行 0: 終了 => ") ;
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
                case 4 : // 修行（追加機能）
                    System.out.print("どの子を修行させますか？ => ");
                    int n = stdIn.nextInt();
                    hp.training(n);
                default :
                    break ;
            }
        }while(cmd!=0) ;
        System.out.println("この島から総額"+hp.getTotal()+"円分のひよぺんが旅立ちました．") ;
    }
}
