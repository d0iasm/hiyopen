import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class SwingDraw extends JPanel{
	Image image;
	//画像オブジェクト
	
	SwingDraw(){
		//画像を読み込む
		Toolkit tk = Toolkit.getDefaultToolkit();
		image = tk.getImage("neko.jpeg");
		
		//コンストラクタで背景色の設定
		//背景色の設定
		Color bc = new Color(100, 100, 100);
		setBackground(bc);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		//画像を貼付ける
		g.drawImage(image, 150, 150, this);
		
		//お絵描き
		Color dc = new Color(255, 0, 255);
		g.setColor(dc);
		
		g.drawString("Hello world", 10, 40);
		g.fillOval(200, 50, 100, 50);
		g.drawRect(150, 10, 100, 50);
		
		int[] xCord1 = {100, 130, 160, 190, 220};
		int[] yCord1 = {300, 350, 320, 350, 300};
		g.drawPolygon(xCord1, yCord1, 5);
	}
}

class MenuTest extends JFrame{

	JMenuItem item_f1;
	JMenuItem item_f2;
	JMenuItem item_f3;
	
	SwingDraw panel;
	
	JButton itemA;
	JButton itemB;
	JButton itemC;
	
	MenuTest(String title){
		super(title);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu file = new JMenu("File");
		menuBar.add(file);
		
		//JMenuItem item1, item2, item3;
		MListener ml = new MListener(this);
		item_f1 = new JMenuItem("Open");
		file.add(item_f1);
		item_f1.addActionListener(ml);
		item_f2 = new JMenuItem("Save");
		file.add(item_f2);
		item_f2.addActionListener(ml);
		item_f3 = new JMenuItem("Exit");
		file.add(item_f3);
		item_f3.addActionListener(ml);
		
		//パネル生成
		panel = new SwingDraw();
		//ペインの取得
		Container cp = getContentPane();
		//Container cp = frame.getContentPane();
		//↑これは削除する
		//ペインにパネルを追加
		cp.add(panel);

		//ボタンの追加
		BListener bl = new BListener(this);
		
		itemA = new JButton("Button A");
		Font fontA = new Font("Arial", Font.ITALIC, 18);
		itemA.setFont(fontA);
		itemA.addActionListener(bl);
		panel.add(itemA);
		
		itemB = new JButton("ぼたんB");
		Font fontB = new Font("Default", Font.BOLD, 10);
		itemB.setFont(fontB);
		itemB.addActionListener(bl);
		panel.add(itemB);
		
		itemC = new JButton("ボタンC");
		itemC.setBackground(Color.black);
		itemC.setForeground(Color.white);
		itemC.addActionListener(bl);
		panel.add(itemC);
		
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
	int x = 0;
	
	//コンストラクタ
	BListener(MenuTest f){
		this.frame = f;
	}
	
	//イベントを処理するメソッド
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == frame.itemA){
			System.out.println("ボタンAが押された");
			Graphics g = frame.panel.getGraphics();
			Color gray = new Color(200, 200, 200);
			g.setColor(gray);
			g.fillRect(x, 100, 50, 200);
			x += 60;
		}else if(e.getSource() == frame.itemB){
			System.out.println("ボタンBが押された");
			Graphics g = frame.panel.getGraphics();
			Color yellow = new Color(255, 255, 0);
			g.setColor(yellow);
			g.drawArc(400, 380, 50, 50, 0, 360);
		}else if(e.getSource() == frame.itemC){
			System.out.println("ボタンCが押された");
		}
		
	}
}

class MListener implements ActionListener{
	MenuTest frame;
	
	MListener(MenuTest f){
		this.frame = f;
	}
	
	//イベントを追加するメソッド
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == frame.item_f1){
			System.out.println("Open");
		}else if(e.getSource() == frame.item_f2){
			System.out.println("Save");
		}else if(e.getSource() == frame.item_f3){
			System.out.println("Exit");
		}
	}
}

class MouseCheck implements MouseListener, MouseMotionListener{
	MenuTest frame;
	int x0; //直前のx座標
	int y0; //直前のy座標
	MouseCheck(MenuTest f){
		this.frame = f;
	}
	
	public void mouseMoved(MouseEvent e){
		int x = e.getX();
		int y = e.getY();
		System.out.println("カーソルが(" + x + "," + y + ")へ移動しました");
	}
	
	public void mouseDragged(MouseEvent e){
		int x = e.getX();
		int y = e.getY();
		System.out.println("(" + x + "," + y + ")へドラッグしました");
		
		Graphics2D g = (Graphics2D)frame.panel.getGraphics();
		BasicStroke w = new BasicStroke(5);
		g.setStroke(w);
		g.setColor(Color.black);
		//直前の座標と現在の座標の間に直線を引く
		g.drawLine(x0, y0, x, y);
		//現在の座標を直前の点として登録
		x0 = x;
		y0 = y;
	}
	
	public void mousePressed(MouseEvent e){
		System.out.print("ボタン");
		int p = e.getButton();
		int q = 0;
		/*switch(p){
			case MouseEvent.BUTTON1:q = 1;break;
			case MouseEvent.BUTTON2:q = 2;break;
			case MouseEvent.BUTTON3:q = 3;break;
			case MouseEvent.NOBUTTON:q = -1;break;
			default: break;
		}*/
		switch(p){
			case MouseEvent.BUTTON1:q = 1;
			//始点を登録
			x0 = e.getX();
			y0 = e.getY();
			break;
			case MouseEvent.BUTTON2:q = 2;break;
			case MouseEvent.BUTTON3:q = 3;break;
			case MouseEvent.NOBUTTON:q = -1;break;
			default: break;
		}
		System.out.println(q + "が押されました");
	}
	
	public void mouseReleased(MouseEvent e){
		System.out.println("ボタンが離されました");
	}
	
	public void mouseClicked(MouseEvent e){
		int x = e.getX();
		int y = e.getY();
		System.out.println("マウスが(" + x + "," + y + ")でクリックされました");
	}
	
	public void mouseEntered(MouseEvent e){
		if(e.getSource() == frame.panel){
			System.out.println("パネルに入りました");
		}
	}
	
	public void mouseExited(MouseEvent e){
		System.out.println("出ました");
	}
}

public class JFrameTest3{
	public static void main(String[] args){
		//Scanner stdIn = new Scanner(System.in);
		//上はターミナルからのキーボード入力がなければ、なくても良い
		
		//ウィンドウ作成
		//JFrame frame = new JFrame("JFrameTest");
		MenuTest frame = new MenuTest("JFrameTest");
		//JFrame frame = ~~ を上書きする
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setSize(500, 500);
		frame.setVisible(true);
	}
}