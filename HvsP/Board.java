// X目並べ作成用のクラスたち by D. Hanawa (2015)
// X目並べにおける盤面の情報のハンドリング，勝利判定などを，
// 2次元配列を知らない人でも扱えるように作ってみたクラスたちです．
// 改変は自由に行って頂いて結構です．

// Line Battleを行うためのクラス
// X目並べを行うためのインスタンスを生成できます．
// このクラスには石を置いたり，勝利判定をしたりするメソッドが定義されています．
// 基本的には，ルールに合わせてインスタンスを生成後，
// 置く石の色と場所が決まったらgetStateメソッドで石が置けそうか確認し，
// 置ければputで石を置き，checkで勝利判定をする，
// という処理を先手・後手交互に行えばよいでしょう．
// CGなどの描画も上記の処理に連動させて行うことになるかと思います．
// デバッグ用のメソッドも用意しておきました．

class Board {
    static final int Empty=0 ; // 空のマス
    static final int Black=1 ; // 黒石
    static final int White=2 ; // 白石
    
    private final int width ; // ボードの幅
    private final int height ; // ボードの高さ

    private final int tab [][] ; // ボード
    private final int win ; // 何個並べたら勝ちか
    
    private int num ; // 置いた石の数
    private final Log [] log ; // ログ
    
    private final char ch[] = {' ', 'O', 'X'} ;
    
    // コンストラクタ
    // width: ボードの横のマス数
    // height: ボードの縦のマス数
    // win: 何目並べにするか(何マス並べたら勝ちか)
    // 例えば16x16のボードで五目並べをしたい場合は，
    // Board board = new Board(16, 16, 5) ;
    // とすれば，16x16の五目並べ用のインスタンスが生成されます．
    Board(int width, int height, int win){
        this.tab = new int[width][height] ;
        this.log = new Log[width*height] ;
        this.width = width ;
        this.height = height ;
        this.win = win ;
        this.num = 0 ;
    }
    
    // 石をおくメソッド
    // x: 横
    // y: 縦
    // color: 置く石の色(Borad.BlackかBorad.Whiteを指定する)
    // 戻り値： 正常に置けた場合はtrue, 置けなかった場合はfalse
    // 指定されたマスに石を置きます．
    // 
    boolean put(int x, int y, int color){
        // 座標が範囲外かどうかチェック
        if(x<0||x>=width||y<0||y>=height)
            return false ;
        // 石の色をチェック
        if(color!=Black&&color!=White)
            return false ;
        // 既に石があるかチェック
        if(tab[x][y]!=Empty)
            return false ;
        // 石を置く
        tab[x][y] = color ;
        // ログへ記録
        log[num++] = new Log(x,y,color) ;

        return true ;
    }

    // 勝利判定をするメソッド
    // x: 横
    // y: 縦
    // color: 置く石の色
    // 戻り値： 勝つ場合はtrue, それ以外はfalse
    // 指定したマスに石を置いた場合に，
    // 縦，横，斜めのいずれかで5個以上，同色の石が並ぶかを判定します．
    boolean check(int x, int y, int color){
        // 座標が範囲外かどうかチェック
        if(x<0||x>=width||y<0||y>=height)
            return false ;
        // 石の色をチェック
        if(color!=Black&&color!=White)
            return false ;

        // 横方向
        int horz=1 ; 
        // 右方向
        for(int i=x+1;i<width;i++,horz++)
            if(tab[i][y]!=color)
                break ;
        // 左方向
        for(int i=x-1;i>=0;i--,horz++)
            if(tab[i][y]!=color)
                break ;
        
        // 縦方向
        int virt=1 ;
        // 上方向
        for(int j=y-1;j>=0;j--,virt++)
            if(tab[x][j]!=color)
                break ;
        // 下方向
        for(int j=y+1;j<height;j++,virt++)
            if(tab[x][j]!=color)
                break ;
        
        // ななめ(右上から左下)
        int nesw=1 ;
        // 右上
        for(int i=x+1, j=y-1;i<width&&j>=0;i++,j--,nesw++)
            if(tab[i][j]!=color)
                break ;
        // 左下
        for(int i=x-1, j=y+1;i>=0&&j<height;i--,j++,nesw++)
            if(tab[i][j]!=color)
                break ;
        
        // ななめ(右上から左下)
        int nwse=1 ;
        // 左上
        for(int i=x-1, j=y-1;i>=0&&j>=0;i--,j--,nwse++)
            if(tab[i][j]!=color)
                break ;
        // 右下
        for(int i=x+1, j=y+1;i<width&&j<height;i++,j++,nwse++)
            if(tab[i][j]!=color)
                break ;

        // 判定結果のリターン
        return (horz >= win || virt >= win || nesw >= win || nwse>=win) ;
    }
    
    // 現在のボードの状態をターミナル上に出力するメソッド
    // どこのマスにどの石があるかをターミナルへ表示してくれる，
    // 主にデバッグ用のメソッドです．
    // 左上が(0,0)，右上が(width-1,0)，左下が(0, height-1)，右下が(width-1, height-1)となるように出力します．
    void printBoard(){
        for(int y=0;y<height;y++){
            for(int x=0;x<width;x++){
                System.out.print(ch[tab[x][y]]) ;
            }
            System.out.println() ;
        }
    }
    
    // 指定したマスの状態を見るメソッド
    // x: 横
    // y: 縦
    // 戻り値: 黒が置いてあればBoard.Black, 白がおいてあればBorad.White, 何もなければBoard.Empty
    // 何がおいてあるのかを確認するのに使用します．
    int getState(int x, int y){
        return tab[x][y] ;
    }

    // 石を置いた順番をターミナル上に出力するメソッド
    // 何手目にどこへ何色の石を置いたかをターミナルへ表示してくれる，
    // 主にデバッグ用のメソッドです．
    void printLog(){
        for(int i=0;i<num;i++){
            System.out.print("["+(i+1)+"] ") ;
            System.out.print("("+log[i].getX()+","+log[i].getY()+") ") ;
            System.out.println(ch[log[i].getColor()]) ;
        }
    }
    // ボードの横幅を返すメソッド
    int getWidth(){
        return this.width ;
    }
    // ボードの縦幅を返すメソッド
    int getHeight(){
        return this.height ;
    }
    // 何目並べると勝つかを返すメソッド
    int getWin(){
        return this.win ;
    }
    // 何個石が置かれたかを返すメソッド
    int getNum(){
        return this.num ;
    }
    
}

// Boardクラスで何手目にどこへ何色の石を置いたかを記憶するのに必要なクラスです．
class Log{
    private final int x ;
    private final int y ;
    private final int color ;
    Log(int x, int y, int color){
        this.x = x ;
        this.y = y ;
        this.color = color ;
    }
    int getX(){
        return x ;
    }
    int getY() {
        return y ;
    }
    int getColor(){
        return color ;
    }
}

