package code.code;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class CreateQrCode {

	public static void main(String[] args) {
		int width = 300;
		int height = 300;
		String format = "png";
		/* http://192.168.0.223:8080/overturn/login.htm */
		String content = "http://192.168.0.217:8089/shoe/page/index.htm";
		// 定义二维码的参数
		HashMap map = new HashMap();
		// 设置编码
		map.put(EncodeHintType.CHARACTER_SET, "utf-8");
		// 设置纠错等级
		map.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
		map.put(EncodeHintType.MARGIN, 2);
		try {
			// 生成二维码
			BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, map);
			Path file = new File("E:/file/images/1.png").toPath();
			MatrixToImageWriter.writeToPath(bitMatrix, format, file);
		} catch (WriterException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
