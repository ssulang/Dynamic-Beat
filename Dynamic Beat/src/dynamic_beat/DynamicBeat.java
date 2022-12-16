package dynamic_beat;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class DynamicBeat extends JFrame{
	
	private Image screenImage;
	private Graphics screenGraphic;
	
	private Image introBackgound;
	
	public DynamicBeat() {
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);//사이즈를 임의로 줄이는게 안됨
		setLocationRelativeTo(null);//화면이 컴퓨터 정중앙
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//창을끄면 프로그램 종료
		setVisible(true);//게임이 정상적이면 출력
	
		introBackgound = new ImageIcon(Main.class.getResource("../images/introBackground.jpg")).getImage();
		
		Music introMusic = new Music("../music/introMusic.mp3", true);
		introMusic.start();
	}
	
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0 , 0 , null);
	}
	
	public void screenDraw(Graphics g) {
		g.drawImage(introBackgound, 0, 0, null);
		this.repaint();
	}
}
