public class Bubble {
	
	private final class velocity {
		public int y;
		public int x;
	}
	
	private final class position {
		public int y;
		public int x;
	}

	public static enum SIZE {
		XL, // 48x40
		L,  // 33x26
		M,  // 16x14
		S   // 8x7
	}
	
	private SIZE size;
	private velocity velocity;
	private position position;
}