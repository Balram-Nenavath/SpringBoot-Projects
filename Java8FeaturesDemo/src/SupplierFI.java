
import java.util.Arrays;
import java.util.List;

public class SupplierFI {

	public static void main(String[] args) {


		List<String> list1 = Arrays.asList();

		System.out.println(list1.stream().findAny().orElseGet(() -> "Hello World"));
	}
}
