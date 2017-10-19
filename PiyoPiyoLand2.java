import java.util.Scanner ;

class Hiyoko{
	private String name; //名前
	private double weight; //体重
	private int x; //X座標
	private int y; //Y座標
	private int nade; //なでられた回数
	
	String getName(){return name;}
	double getWeight(){return weight;}
	int getX(){return x;}
	int getY(){return y;}
	int getNade(){return nade;}
	
	//コンストラクタ
	Hiyoko(String nm, double w, int x, int y){
		this.name = nm;
		this.weight = w;
		this.x = x;
		this.y = y;
		this.nade = 0;
		
	}
	
	//えさをあげるメソッド
	void addFood(double weight){
		this.weight += weight;
		System.out.println("∈=∈= (^△^)/ぴよ！");
	}
	
	//なでなでするメソッド
	void nadenade(int n){
		weight -= 0.1 * n; //1回鳴くと0.1g体重減る
		nade += n;
		System.out.println("∈=∈= (・△・)/ぴよぴよ！");
	}
	
	//移動するメソッド
	void move(int dx, int dy){
		x = x + dx;
		y = y + dy;
		double d = Math.sqrt(dx*dx + dy*dy) ; // 移動距離の算出
		weight -= d ; // 距離1あたり1g体重が減る
	}
	
	//画面に出力する
	void print(){
		System.out.print("[1] "+name+" <"+weight+" g> ") ;
		System.out.println("@ ("+x+","+y+") 通算なでなで"+nade+"回") ;
	}
	
}


public class PiyoPiyoLand2 {

	static void specialMenu(Hiyoko p){
		// えさをあげ
		p.addFood(10.0);
		// なでなで
		p.nadenade(5);
		// 動かす
		p.move(3,3);
		}
		
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in) ;
		
		// ひよこたちの名前
		String name1, name2, name3 ;
		// ひよこたちの体重
		double weight1, weight2, weight3 ;
		// ひよこたちの位置(X座標)
		int x1, x2, x3 ;
		// ひよこたちの位置(Y座標)
		int y1, y2, y3 ;
		// ひよこたちの通算なでなで
		int nade1=0, nade2=0, nade3=0 ;
		
		Hiyoko [] piyo ;
		piyo = new Hiyoko[3];
		
		// 1匹目のひよこ
		System.out.print("ひよこ1匹目，入ります．") ;
		System.out.print("名前は？=> ") ;
		name1 = stdIn.next() ;
		System.out.print("体重は？=> ") ;
		weight1 = stdIn.nextDouble() ;
		System.out.print("X座標は？=> ") ;
		x1 = stdIn.nextInt() ;
		System.out.print("Y座標は？=> ") ;
		y1 = stdIn.nextInt() ;
		
		piyo[0] = new Hiyoko(name1, weight1, x1, y1);

		// 2匹目のひよこ
		System.out.print("ひよこ2匹目，入ります．") ;
		System.out.print("名前は？=> ") ;
		name2 = stdIn.next() ;
		System.out.print("体重は？=> ") ;
		weight2 = stdIn.nextDouble() ;
		System.out.print("X座標は？=> ") ;
		x2 = stdIn.nextInt() ;
		System.out.print("Y座標は？=> ") ;
		y2 = stdIn.nextInt() ;
		
		piyo[1] = new Hiyoko(name2, weight2, x2, y2);

		// 3匹目のひよこ
		System.out.print("ひよこ3匹目，入ります．") ;
		System.out.print("名前は？=> ") ;
		name3 = stdIn.next() ;
		System.out.print("体重は？=> ") ;
		weight3 = stdIn.nextDouble() ;
		System.out.print("X座標は？=> ") ;
		x3 = stdIn.nextInt() ;
		System.out.print("Y座標は？=> ") ;
		y3 = stdIn.nextInt() ;
		
		piyo[2] = new Hiyoko(name3, weight3, x3, y3);
		
		// ひよこがどの位置にいるのか
		double x = piyo[0].getX();
		double y = piyo[0].getY();
		double d = Math.sqrt(x*x + y*y);
		System.out.println(piyo[0].getName() + "ちゃんは原点から" + d + "離れた位置にいますよ");
		

		// 1匹目のひよこにえさをあげる
		System.out.print(name1+"にえさを何g？=> ") ;
		double w = stdIn.nextDouble() ;

		piyo[0].addFood(w);
		
		
		// 2匹目のひよこをなでなでする
		System.out.print(name2+"のなでなでは何回？=> ") ;
		int n = stdIn.nextInt() ;
		
		piyo[1].nadenade(n);
		
		
		// 3匹目のひよこを動かす
		System.out.println(name3+"を動かします．") ;
		System.out.print("X方向へ？=> ") ;
		int dx = stdIn.nextInt() ;
		System.out.print("Y方向へ？=> ") ;
		int dy = stdIn.nextInt() ;
		
		piyo[2].move(dx,dy);
		
		specialMenu(piyo[1]);
		specialMenu(piyo[2]);
		
		
		// ひよこ一覧の表示
		System.out.print("[1]");
		piyo[0].print();
		System.out.print("[2]");
		piyo[1].print();
		System.out.print("[3]");
		piyo[2].print();
		
		

		System.out.println() ;
		System.out.println("おしまい") ;
	}
}
