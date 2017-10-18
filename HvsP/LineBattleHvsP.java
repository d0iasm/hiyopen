import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class SwingDraw extends JPanel{
    //Graphicsクラスのオブジェクトに描画を指示すると、ディスプレイ上の適切な位置に実際に表示してくれる仲介をしてくれる
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        //paintをオーバーライドしてしまうとその中で呼ばれる各種描画メソッドが呼ばれなくなり、
        //コンポーネントの描画が正しく行われなくなる可能性がある。このため、何かを描画したい場合には、
        //paint内の、コンポーネント描画のために用意されているpaintComponentをオーバーライドして描画を行う。
        //ただし、これもsuperにメソッドを送るのを忘れると本来の描画が正しくなされないため、
        //かならずsuper.paintComponentしないといけない。

        //お絵描き
        Color black = new Color(0, 0, 0);
        Color white = new Color(255, 255, 255);
        Color red = new Color(255, 65, 25);
        Color yellow = new Color(255, 230, 0);
        Color orange = new Color(255, 127, 0);
        Color blue = new Color(9, 63, 134);

        //タイトル
        g.setColor(black);
        Font font1 = new Font("Arial", Font.BOLD, 25);
        g.setFont(font1);
        g.drawString("ひよぺん Line Battle", 510, 80);

        //ひよこ描画
        //足
        g.setColor(black);
        g.drawLine(550, 450, 550, 480);
        g.drawLine(540, 480, 550, 480);
        g.drawLine(580, 450, 580, 480);
        g.drawLine(570, 480, 580, 480);
        //身体
        g.setColor(yellow);
        g.fillOval(510, 350, 100, 110);
        g.fillArc(510, 350, 115, 110, 0, -95);
        //身体の線
        g.setColor(black);
        g.drawArc(510, 350, 100, 110, 0, 280);
        g.drawArc(510, 350, 115, 110, 0, -95);
        g.drawLine(610, 405, 625, 405);
        //顔
        g.setColor(orange);
        int[] xMouth = {510, 490, 513};
        int[] yMouth = {400, 410, 420};
        g.fillPolygon(xMouth, yMouth, 3);
        g.setColor(black);
        g.fillOval(530, 390, 15, 15);
        g.drawLine(510, 400, 490, 410);
        g.drawLine(513, 420, 490, 410);
        g.setColor(white);
        g.fillOval(535, 395, 8, 8);

        //ペンギン描画
        //身体
        g.setColor(blue);
        g.fillOval(670, 340, 70, 75);
        g.fillOval(665, 390, 80, 100);
        g.setColor(white);
        g.fillOval(680, 380, 50, 100);
        //身体の線
        g.setColor(black);
        g.drawArc(670, 340, 70, 75, -45, 270);
        g.drawArc(665, 390, 80, 100, 130, 280);
        //手
        g.setColor(blue);
        int[] xLeft = {680, 640, 670};
        int[] yLeft = {400, 450, 440};
        g.fillPolygon(xLeft, yLeft, 3);
        int[] xRight = {730, 770, 740};
        int[] yRight = {400, 450, 440};
        g.fillPolygon(xRight, yRight, 3);
        g.setColor(black);
        g.drawLine(678, 402, 640, 450);
        g.drawLine(665, 440, 640, 450);
        g.drawLine(732, 402, 770, 450);
        g.drawLine(745, 440, 770, 450);
        //足
        g.setColor(orange);
        g.fillOval(670, 485, 30, 15);
        g.fillOval(710, 485, 30, 15);
        //足の線
        g.setColor(black);
        g.drawArc(670, 485, 30, 15, 70, 300);
        g.drawArc(710, 485, 30, 15, 90, -260);
        //顔
        g.setColor(orange);
        g.fillOval(700, 373, 30, 15);
        g.setColor(black);
        g.fillOval(690, 360, 12, 12);
        g.fillOval(710, 360, 12, 12);
        g.setColor(white);
        g.fillOval(692, 362, 5, 5);
        g.fillOval(712, 362, 5, 5);

        //文字を描写するための背景
        g.setColor(white);
        g.fillRect(510, 110, 250, 170);

        //説明の文字
        g.setColor(black);
        Font font2 = new Font("Arial", Font.PLAIN, 15);
        g.setFont(font2);
        g.drawString("ひよこ　：黒", 520, 140);
        g.drawString("ペンギン：白", 520, 160);
        g.drawString("※背景の色は最初に選んでください", 510, 190);
        g.drawString("※スタートは一度だけ押してください", 510, 210);    
    }
}

class MenuTest extends JFrame{
    //MenuTestクラスにメンバ変数(クラス内のメソッドやクラス外から参照可能な変数)を追加
    //これで外からもアクセスできるようになる
    SwingDraw panel;
    JMenu file1;
    JMenu item1, item2;
    JMenuItem item3;
    JMenuItem bc1, bc2, bc3, bc4, bc5;
    JMenuItem hp1, hp2, hp3;
    JButton btn1, btn2;

    MenuTest(String title){
        super(title);
        //メニューのイベント処理
        MListener ml = new MListener(this);

        //メニューバーの作成
        JMenuBar menuBar = new JMenuBar();

        //メニューバーをFrameに追加
        setJMenuBar(menuBar);

        //Fileメニューの作成
        file1 = new JMenu("設定");
        menuBar.add(file1);

        //プルダウンメニュー作成
        //JMenuは子アイテムをもつメニュー項目
        item1 = new JMenu("背景");
        file1.add(item1);
        item2 = new JMenu("遊ぶ");
        file1.add(item2);
        item3 = new JMenuItem("終了");
        file1.add(item3);
        item3.addActionListener(ml);

        //背景色の設定
        //JMenuItemは子アイテムを持たないメニュー項目
        bc1 = new JMenuItem("赤色");
        item1.add(bc1);
        bc1.addActionListener(ml);
        bc2 = new JMenuItem("黄色");
        item1.add(bc2);
        bc2.addActionListener(ml);
        bc3 = new JMenuItem("緑色");
        item1.add(bc3);
        bc3.addActionListener(ml);
        bc4 = new JMenuItem("青色");
        item1.add(bc4);
        bc4.addActionListener(ml);
        bc5 = new JMenuItem("灰色");
        item1.add(bc5);
        bc5.addActionListener(ml);

        //遊ぶ設定
        hp1 = new JMenuItem("おしゃれ");
        item2.add(hp1);
        hp1.addActionListener(ml);
        hp2 = new JMenuItem("しかく");
        item2.add(hp2);
        hp2.addActionListener(ml);
        hp3 = new JMenuItem("まる");
        item2.add(hp3);
        hp3.addActionListener(ml);

        //パネル作成
        panel = new SwingDraw();
        Container cp = getContentPane();
        cp.add(panel);
        
        //ボタンの追加
        BListener bl = new BListener(this);
        btn1 = new JButton("ひよこからスタート");
        Font font2 = new Font("Arial", Font.PLAIN, 15);
        btn1.setFont(font2);
        btn1.setForeground(Color.black);
        btn1.addActionListener(bl);
        panel.add(btn1);

        btn2 = new JButton("ペンギンからスタート");
        btn2.setFont(font2);
        btn2.setForeground(Color.black);
        btn2.addActionListener(bl);
        panel.add(btn2);

        //マウスイベント
        MouseCheck ms = new MouseCheck(this);
        //パネルへのマウスリスナーの付与
        panel.addMouseListener(ms);
        //パネルへのマウスモーションリスナーの付与
        panel.addMouseMotionListener(ms);

    }
}

class BListener implements ActionListener{
    MenuTest frame;
    int x;
    int color = 1;
    Color gray = new Color(230, 230, 230);
    Color black = new Color(0, 0, 0);
    public static boolean start = false;

    //コンストラクタ
    BListener(MenuTest f){
        this.frame = f;
    }

    //イベントを処理するメソッド
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == frame.btn1){
            //ひよこからスタート
            //colorを1に設定、boardに記録
            color = 1;
            MouseCheck.board.setColor(color);
            
            //ボードの目
            Graphics g = frame.panel.getGraphics();
            g.setColor(black);
            //縦線 x方向へ30ずつ移動
            int x = 30;
            for(int i=0; i<16; i++){
                g.drawLine(x, 60, x, 510);
                x += 30;
            }
            //横線 y方向へ30ずつ移動
            int y = 60;
            for(int i=0; i<16; i++){
                g.drawLine(30, y, 480, y);
                y += 30;
            }

            //ボタンを押すと石が置けるようになる
            start = true;

        }else if(e.getSource() == frame.btn2){
            //ペンギンからスタート
            //colorを2に指定、boradに記録
            color = 2;
            MouseCheck.board.setColor(color);

            //ボードの目
            Graphics g = frame.panel.getGraphics();
            g.setColor(black);
            //縦線 x方向へ30ずつ移動
            int x = 30;
            for(int i=0; i<16; i++){
                g.drawLine(x, 60, x, 510);
                x += 30;
            }
            //横線 y方向へ30ずつ移動
            int y = 60;
            for(int i=0; i<16; i++){
                g.drawLine(30, y, 480, y);
                y += 30;
            }

            start = true;
        }
    }
}

class MListener implements ActionListener{
    MenuTest frame;
    int x = 0;
    boolean square = true;
    Color pink = new Color(223, 76, 148);
    public static boolean maru = false;

    MListener(MenuTest f){
        this.frame = f;
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == frame.item3){
            System.out.println("終了");
            //システムを終了させる
            frame.dispose();
        }

        //メニューの背景の設定
        if(e.getSource() == frame.bc1){
            System.out.println("赤");
            Color red = new Color(249, 52, 76);
            frame.panel.setBackground(red);
        }else if(e.getSource() == frame.bc2) {
            System.out.println("黄");
            Color yellow = new Color(255, 242, 49);
            frame.panel.setBackground(yellow);
        }else if(e.getSource() == frame.bc3) {
            System.out.println("緑");
            Color grren = new Color(51, 166, 94);
            frame.panel.setBackground(grren);
        }else if(e.getSource() == frame.bc4) {
            System.out.println("青");
            Color blue = new Color(56, 108, 176);
            frame.panel.setBackground(blue);
        }else if(e.getSource() == frame.bc5) {
            System.out.println("灰");
            Color gray = new Color(230, 230, 230);
            frame.panel.setBackground(gray);
        }


        //メニューの遊ぶの設定
        if(e.getSource() == frame.hp1){
            //ひよことペンギンにオシャレをさせる
            Graphics g = frame.panel.getGraphics();
            g.setColor(pink);
            int[] xRibbon = {690, 690, 710, 730, 730};
            int[] yRibbon = {390, 410, 400, 390, 410};     
            g.fillPolygon(xRibbon, yRibbon, 5);
            int[] xHat = {600, 620, 605, 605, 590, 590, 570};
            int[] yHat = {380, 360, 360, 345, 345, 330, 350};     
            g.fillPolygon(xHat, yHat, 7);
        }else if(e.getSource() == frame.hp2) {
            //背景に四角を描写する
            Graphics g = frame.panel.getGraphics();
            g.setColor(pink);
            if(square){
                 g.fillRect(x, 520, 30, 30);
                 square = false;
            }else if(!square){
                g.drawRect(x, 520, 30, 30);
                square = true;
            }
            x += 50;
        }else if(e.getSource() == frame.hp3) {
            //マウスの動きに合わせて丸を描写する
            if(!maru){
                maru = true;
            }else{
                maru =false;
            }
        }
    }
}

class MouseCheck implements MouseListener, MouseMotionListener{
    MenuTest frame;

    //ボードクラスのインスタンスを生成
    public static Board board = new Board(16, 16, 5);

    //石を置く位置を決めるための範囲
    int xRange;
    int yRange;

    //石の置く位置(0~15)
    int xPut;
    int yPut;

    //石の色が黒(==1)か白(==2)か
    //初期設定は黒
    int color = 1;

    //ボタンによって色を一度だけ調節するための変数
    boolean once = true;

    Color black = new Color(0, 0, 0);
    Color red = new Color(255, 0, 0);
    Color white = new Color(255, 255, 255);
    Color yellow = new Color(255, 230, 0);
    Color orange = new Color(255, 127, 0);
    Color blue = new Color(9, 63, 134);
    Color pink = new Color(223, 76, 148);
    Font font3 = new Font("Arial", Font.BOLD, 50);
    Font font4 = new Font("Arial", Font.BOLD, 35);

    MouseCheck(MenuTest f){
        this.frame = f;
    }
    
    public void mouseMoved(MouseEvent e){
        //マウスが動いたときの処理

        //マウスの位置を取得し、その位置に丸を描写する
        if(MListener.maru){
            int x = e.getX();
            int y = e.getY();
            Graphics g = frame.panel.getGraphics();
            g.setColor(pink);
            g.fillOval(x, y, 5, 5);
        }
    }
    
    public void mouseDragged(MouseEvent e){
        //マウスがドラッグされたときの処理
    }
    
    public void mousePressed(MouseEvent e){
        //マウスが押されたときの処理

        if (BListener.start) {
            //最初に一度だけボタンによって色の指定をする
            if (once) {
                color = board.getColor();
                once = false;
            }

            //石を置く操作
            int x = e.getX();
            int y = e.getY();
            Graphics g = frame.panel.getGraphics();

            //クリックした場所が碁盤の範囲内かどうか
            if(15 <= x && x < 495 && 45 <= y && y < 525){
                //石を置く場所を決める操作
                //xの範囲を一旦リセット
                //中のfor文で右端まで調べているため
                xRange = -15;
                //xを30ずつずらして、どの範囲に属しているか調べる
                for(int i=0; i<16; i++){
                    xRange = xRange + 30;
                    //yの範囲を一旦リセット
                    //中のfor文で一番下まで調べているため
                    yRange = 15;
                    //yを30ずつずらして、どの範囲に属しているか調べる
                    for(int j=0; j<16; j++){
                        yRange = yRange + 30;
                        //範囲に当てはまっていたら、石を置く値(0~15)を決める
                        if(xRange < x && x < (xRange+30) && yRange < y && y < (yRange+30)){
                            xPut = i;
                            yPut = j;
                        }
                    }
                }

                //置こうとしている場所にすでに置いてあるか確認
                if(board.getState(xPut, yPut)==1 || board.getState(xPut, yPut)==2){
                    System.out.println("すでに置いてあるため、操作しない");
                }else{
                    //黒を置くか白を置くか
                    if (color == 1) {
                        //Boardクラスのメソッドを使う
                        //石を置いて、ボードの状態を確認
                        board.put(xPut, yPut, color);
                        board.printBoard();

                        //石を描画する操作
                        //線の交差地点に石を置くために、x,yの値を調整
                        int xStone = 15;
                        int yStone = 45;
                        xStone = xStone + (30*xPut);
                        yStone = yStone + (30*yPut);
                        //石を置く
                        g.setColor(black);
                        g.fillOval(xStone, yStone, 30, 30);

                        //勝利判定
                        if(board.check(xPut, yPut, color)){
                            System.out.println("ひよこの勝利");
                            //文字の変化
                            g.setColor(white);
                            g.fillRect(510, 110, 250, 170);
                            g.setColor(red);
                            g.setFont(font3);
                            g.drawString("ひよこ", 550, 180);
                            g.setFont(font4);
                            g.drawString("の勝利", 570, 235);
                            //ひよこの変化
                            g.setColor(yellow);
                            g.fillOval(515, 355, 90, 100);
                            g.setColor(black);
                            g.drawArc(530, 390, 20, 20, 0, 180);
                            g.setColor(red);
                            g.drawLine(530, 340, 510, 300);
                            g.drawLine(540, 340, 530, 300);
                            g.drawLine(550, 340, 560, 300);
                            g.drawLine(560, 340, 580, 300);

                            //falseにすることによって石を置けなくする
                            BListener.start = false;
                        }

                        //黒を一度置いたら次は白へ
                        color = 2;

                    }else if(color == 2){
                        //Boardクラスのメソッドを使う
                        //石を置いて、ボードの状態を確認
                        board.put(xPut, yPut, color);
                        board.printBoard();

                        //石を描画する操作
                        //線の交差地点に石を置くために、x,yの値を調整
                        int xStone = 15;
                        int yStone = 45;
                        xStone = xStone + (30*xPut);
                        yStone = yStone + (30*yPut);
                        //石を置く
                        g.setColor(white);
                        g.fillOval(xStone, yStone, 30, 30);

                        //勝利判定
                        if(board.check(xPut, yPut, color)){
                            System.out.println("ペンギンの勝利");
                            g.setColor(white);
                            g.fillRect(510, 110, 250, 170);
                            g.setColor(red);
                            g.setFont(font3);
                            g.drawString("ペンギン", 540, 180);
                            g.setFont(font4);
                            g.drawString("の勝利", 570, 235);
                            //ペンギンの変化
                            g.setColor(blue);
                            g.fillOval(675, 345, 65, 70);
                            g.setColor(white);
                            g.fillOval(680, 380, 50, 100);
                            g.setColor(orange);
                            g.fillOval(700, 373, 30, 15);
                            g.setColor(black);
                            g.drawArc(690, 360, 15, 15, 0, 180);
                            g.drawArc(710, 360, 15, 15, 0, 180);
                            g.setColor(red);
                            g.drawLine(690, 330, 670, 300);
                            g.drawLine(700, 330, 690, 300);
                            g.drawLine(710, 330, 720, 300);
                            g.drawLine(720, 330, 740, 300);

                            BListener.start = false;
                        }

                        color = 1;
                    }
                }

                //引き分けの表示
                if (board.getNum() == 256) {
                    System.out.println("引き分け");
                    g.setColor(white);
                    g.fillRect(510, 110, 250, 170);
                    g.setColor(red);
                    g.setFont(font3);
                    g.drawString("引き分け", 540, 180);
                }
            }
        }
    }
    
    public void mouseReleased(MouseEvent e){
        //マウスが離れたときの処理
    }
    
    public void mouseClicked(MouseEvent e){
        //マウスのボタンがクリックされたときの処理
    }
    
    public void mouseEntered(MouseEvent e){
        //マウスカーソルがコンポーネントに入ったときの処理
    }
    
    public void mouseExited(MouseEvent e){
        //マウスカーソルがコンポーネントから出たときの処理
    }
}




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
    
    int color = 1;

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
    
    
    //既存のBoradクラスに追加
    //　先手を選ぶためのcolorの情報を置いておく
    void setColor(int color){
        this.color = color;
    }

    int getColor(){
        return this.color;
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



public class LineBattleHvsP{
    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        //上はターミナルからのキーボード入力がなければ、なくても良い

        //ウィンドウ作成
        MenuTest frame = new MenuTest("LineBattleHvsP");
        //ウィンドウを閉じるとアプリケーションも同時に終了する
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setSize(800, 600);
        frame.setVisible(true);

    }
}