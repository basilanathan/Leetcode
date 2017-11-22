
public class ReverseInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// x = 542
//	public int reverse(int x) {
//		int result = 0;
//		int remainder;
//		while(x != 0) {
//			remainder = x % 10; //2 //4 //5
//			result = result * 10 + remainder; // 0 * 10 + 2 = 2 // 24 //245
//			x = x/10; //54 //5 //0
//		}
//		
//		return (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) ? 0 : (int) result;
//	}

    //1. use long to deal with overflow
    public int reverse(int x) {
        long result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
                return 0;
            x /= 10;
        }
        return (int)result;
    }
}
