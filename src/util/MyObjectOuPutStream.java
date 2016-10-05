package util;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MyObjectOuPutStream extends ObjectOutputStream {

	public MyObjectOuPutStream(OutputStream out) throws IOException {
		super(out);
		// TODO 自动生成的构造函数存根
	}

	@Override
	protected void writeStreamHeader() throws IOException {
		// TODO 自动生成的方法存根
		return;
	}


}
