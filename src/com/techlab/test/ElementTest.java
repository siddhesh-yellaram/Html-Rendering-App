package com.techlab.test;

import java.io.FileWriter;
import java.io.IOException;

import com.techlab.model.*;

public class ElementTest {

	public static void main(String[] args)throws IOException {
		
		Element html = new Element("html");

		Element body = new Element("body");
		html.addChild(body);

		Element newHead = new Element("h1", "First Heading");
		body.addChild(newHead);

		Element newPara = new Element("p", "First paragraph");
		body.addChild(newPara);
		
		Element newPre = new Element("pre", "Text in a pre element");
		body.addChild(newPre);
		
		String str = "<!DOCTYPE html>" + System.getProperty("line.separator") + html.display();
		System.out.println(str);
		
		FileWriter fw = new FileWriter("src/Web/myHtml.html");
		fw.write(str);
		fw.close();
		
	}
}
