package progressbar_thread;

import javax.swing.JProgressBar;

public class Hilo extends Thread {

	public boolean ended = false;
	private String name;
	private JProgressBar progressBar;

	public Hilo(JProgressBar progressBar, String name) {
		super(name);
		this.name = name;
		this.progressBar = progressBar;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		try {
			ended = false;
			for (int x = 0; x <= 100; x++) {
				progressBar.setValue(x);
				Thread.sleep(50);
			}
		} catch (InterruptedException e) {
			progressBar.setValue(100);
			System.out.print(String.format("Hilo {0} fue interrumpido", name));
		} finally {
			ended = true;	
		}
	}

}
