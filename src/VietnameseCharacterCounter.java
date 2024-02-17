import java.util.HashMap;
import java.util.Scanner;
public class VietnameseCharacterCounter {
    private static final HashMap<String, Character> telexToVietnamese = new HashMap<>();

    static {
        // Khởi tạo bảng tra cứu
        telexToVietnamese.put("aw", 'ă');
        telexToVietnamese.put("aa", 'â');
        telexToVietnamese.put("dd", 'đ');
        telexToVietnamese.put("ee", 'ê');
        telexToVietnamese.put("oo", 'ô');
        telexToVietnamese.put("ow", 'ơ');
        telexToVietnamese.put("w", 'ư');
    }

    public static int countVietnameseCharacters(String input) {
        int count = 0;

        // Duyệt qua từng ký tự trong chuỗi
        for (int i = 0; i < input.length(); i++) {
            // Nếu là ký tự cuối cùng thì không cần kiểm tra nữa
            if (i == input.length() - 1) break;

            // Lấy cặp ký tự liên tiếp
            String pair = input.substring(i, i + 2);

            // Kiểm tra xem cặp ký tự có trong bảng tra cứu không
            if (telexToVietnamese.containsKey(pair)) {
                count++;
                i++; // Di chuyển thêm một bước để bỏ qua ký tự tiếp theo
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập chuỗi chữ cái latin: ");
        String input = scanner.nextLine();
        scanner.close();

        int vietnameseCount = countVietnameseCharacters(input);
        System.out.println("Số lượng chữ cái Tiếng Việt trong chuỗi là: " + vietnameseCount);
    }
}
