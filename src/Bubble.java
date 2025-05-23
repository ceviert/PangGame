import java.util.ArrayList;

public class Bubble {
	
	public static enum SIZE {
		XL, // 48x40
		L,  // 33x26
		M,  // 16x14
		S   // 8x7
	}
	
	private SIZE size;
	private Vector velocity;
	private Vector position;
	
	public static ArrayList<Bubble> bubbles;  
	
	public Bubble(SIZE size, Vector velocity, Vector position) {
		this.size = size;
		this.velocity = velocity;
		this.position = position;
	}
	
	public void update() {
		updateVelocity();
		updatePosition();
	}
	
	private void updatePosition() {
		position = position.add(velocity);
	}

	private void updateVelocity() {
		velocity = velocity.add(GameSettings.GRAVITATIONAL_CONSTANT);
	}
}