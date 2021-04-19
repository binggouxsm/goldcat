import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test2 {

	public static void main(String[] args) {
		File file = new File("d://账单//微信支付账单(20210301-20210331).csv");

//		String filename = file.getName().toLowerCase();
//		System.out.println(filename);
//
//		System.out.println();

		String aa ="起始时间：[2021-03-01 00:00:00] 终止时间：[2021-03-31 23:59:59]"; //  终止时间：[2021-03-31 23:59:59]

		Pattern pattern = Pattern.compile("起始时间：\\[([0-9\\: \\-]+)\\]");

		Pattern pattern2 = Pattern.compile("终止时间：\\[([0-9\\: \\-]+)\\]");

		System.out.println(aa.matches("起始时间：\\[[0-9\\: \\-]+\\]"));

		Matcher m = pattern2.matcher(aa);
		if(m.find()){
			System.out.println(m.group(0));
			System.out.println(m.group(1));
			System.out.println(m.group(2));
			System.out.println(m.group(3));
		}

//		RecordReader reader = new WeixinRecordReader();
//		List<Record> records = reader.getRecords(file);
//		for (Record record: records){
//			System.out.println(record);
//		}

	}
}
