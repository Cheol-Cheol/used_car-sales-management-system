package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 싱글톤 적용
public class DataInput {

	private static DataInput instance;
	private BufferedReader br;

	private DataInput() {
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	public static DataInput getInstance() {
		if (instance == null) {
			instance = new DataInput();
		}

		return instance;
	}

	public String readLine() throws IOException {
		return br.readLine();
	}

}
