package github.zayn.interesting;

/**
 * @ClassName question1
 * @DESCRIPTION 回文十进制数
 * @Author zhangjiayi07
 * @Date 2021/3/29 下午5:26
 **/
public class Question1 {
    public long reverseNumber() {
        int i = 10;
        while (true) {
            String binary = Integer.toBinaryString(i);
            String octal = Integer.toOctalString(i);
            String ten = String.valueOf(i);
            if (isReverse(binary) && isReverse(octal) && isReverse(ten)) {
                return i;
            } else {
                i++;
            }
        }
    }

    private Boolean isReverse(String str) {
        char[] arrayStr = str.toCharArray();
        int length = str.length();
        int top = 0;
        int end = length - 1;
        while (top < end) {
            if (arrayStr[top++] != arrayStr[end--]) {
                return false;
            }
        }
        return true;
    }

    private Boolean isReverse2(String str) {
        char[] arrayStr = str.toCharArray();
        int length = str.length();
        int mid = length / 2;
        int front;
        int back;
        if (length % 2 == 0) {
            front = mid - 1;
            back = mid;
        } else {
            front = mid - 1;
            back = mid + 1;
        }
        while (true) {
            if (arrayStr[front--] != arrayStr[back++]) {
                return false;
            }
            return true;
        }
    }


    public static void main(String[] args) {
        Question1 q1 = new Question1();
        long l = q1.reverseNumber();
        System.out.println(l);
    }
}
