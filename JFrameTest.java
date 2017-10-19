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
		Color bc = new Color(200, 200, 200);
		setBackground(bc);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		//画像を貼付ける
		g.drawImage(image, 210, 250, this);
		
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
	MenuTest(String title){
		super(title);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu file = new JMenu("File");
		menuBar.add(file);
		JMenuItem item1, item2, item3;
		item1 = new JMenuItem("Open");
		file.add(item1);
		item2 = new JMenuItem("Save");
		file.add(item2);
		item3 = new JMenuItem("Exit");
		file.add(item3);
	}
}

public class JFrameTest{
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