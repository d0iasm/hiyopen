import javax.swing.*;
import java.awt.*;

class SwingDraw extends JPanel{
	Image image;
	//画像オブジェクト
	
	SwingDraw(){
		//画像を読み込む
		Toolkit tk = Toolkit.getDefaultToolkit();
		image = tk.getImage("neko.jpeg");
		
		//コンストラクタで背景色の設定
		//背景色の設定
		Color bc = new Color(255, 200, 200);
		setBackground(bc);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		//画像を貼付ける
		g.drawImage(image, 210, 250, this);
		
		//お絵描き
		Color dc = new Color(0, 0, 0);
		g.setColor(dc);
		
		g.drawString("Nyanko", 50, 400);
		g.drawString("145017 DoiAsami", 50, 420);
		g.fillOval(70, 100, 200, 170);
		
		int[] xCord1 = {60, 90, 140};
		int[] yCord1 = {70, 150, 110};
		g.drawPolygon(xCord1, yCord1, 3);
		int[] xCord2 = {280, 250, 200};
		int[] yCord2 = {70, 150, 110};
		g.drawPolygon(xCord2, yCord2, 3);
		
		Color dc2 = new Color(255,255,255);
		g.setColor(dc2);
		
		g.fillArc(120, 180, 30, 30, 0, 360);
		g.fillArc(200, 180, 30, 30, 0, 360);
		
		int[] xCord3 = {165, 185, 175};
		int[] yCord3 = {220, 220, 230};
		g.fillPolygon(xCord3, yCord3, 3);
		
		g.setColor(dc);
		
		g.fillArc(125, 185, 20, 20, 0, 360);
		g.fillArc(205, 185, 20, 20, 0, 360);
	}
}

class MenuTest extends JFrame{
	MenuTest(String title){
		super(title);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu esa = new JMenu("えさ");
		menuBar.add(esa);
		JMenu nade = new JMenu("なでなで");
		menuBar.add(nade);
		JMenu end = new JMenu("おしまい");
		menuBar.add(end);
		
		JMenu item1, item2;
		item1 = new JMenu("たべもの");
		esa.add(item1);
		item2 = new JMenu("のみもの");
		esa.add(item2);
		
		JMenuItem item11, item12, item13;
		item11 = new JMenuItem("キャットフード");
		item1.add(item11);
		item12 = new JMenuItem("おさかな");
		item1.add(item12);
		item13 = new JMenuItem("肉");
		item1.add(item13);
		
		JMenuItem item21, item22;
		item21 = new JMenuItem("水");
		item2.add(item21);
		item22 = new JMenuItem("ミルク");
		item2.add(item22);
		
		JMenuItem item3, item4;
		item3 = new JMenuItem("頭");
		nade.add(item3);
		item4 = new JMenuItem("のど");
		nade.add(item4);
	}
}

public class Nyanko{
	public static void main(String[] args){
		//Scanner stdIn = new Scanner(System.in);
		//上はターミナルからのキーボード入力がなければ、なくても良い
		
		//ウィンドウ作成
		//JFrame frame = new JFrame("JFrameTest");
		MenuTest frame = new MenuTest("JFrameTest");
		//JFrame frame = ~~ を上書きする
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//パネル作成
		SwingDraw panel = new SwingDraw();
		//ペインを取得&ペインにJPanelを乗せる
		Container cp = frame.getContentPane();
		cp.add(panel);
		
		//ボタンの追加
		JButton itemA = new JButton("A");
		panel.add(itemA);
		JButton itemB = new JButton("B");
		panel.add(itemB);
		JButton itemC = new JButton("C");
		panel.add(itemC);
		
		frame.setSize(500, 500);
		frame.setVisible(true);
	}
}