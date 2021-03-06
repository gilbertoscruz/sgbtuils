/**
 * @project: SGBCookMobile
 * @user: Gilberto Sanches Cruz
 * @date: 23/10/2012
 * @hour: 18:42:20
 */
package br.com.sgb.sgbutil.util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author egilcru
 * 
 */
public class UtilsXML {

	public static Element getRoot(String xml, String charset) {
		try {
			InputStream in = null;
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			factory.setValidating(false);
			byte[] bytes = xml.getBytes();
			in = new ByteArrayInputStream(bytes);

			DocumentBuilder buider = factory.newDocumentBuilder();
			Document dom = buider.parse(in);
			Element root = dom.getDocumentElement();

			if (root == null) {
				throw new RuntimeException("XML invlido.");
			}

			return root;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	public static String getText(Node node, String tag) {
		Node n = getChild(node, tag);

		if (n != null) {
			Node text = n.getFirstChild();

			if (text != null) {
				String s = text.getNodeValue();
				return s.trim();
			}
		}

		return "";
	}

	public static List<Node> getChildren(Node node, String name) {
		List<Node> children = new ArrayList<Node>();
		NodeList nodes = node.getChildNodes();

		if (nodes != null && nodes.getLength() >= 1) {
			for (int i = 0; i < nodes.getLength(); i++) {
				Node n = nodes.item(i);

				if (name.equals(n.getNodeName())) {
					children.add(n);
				}
			}
		}

		return children;
	}

	/**
	 * @param node
	 * @param tag
	 * @return
	 */
	public static Node getChild(Node node, String tag) {
		if (node == null) {
			return null;
		}

		NodeList childNodes = node.getChildNodes();
		if (childNodes == null) {
			return null;
		}

		for (int i = 0; i < childNodes.getLength(); i++) {
			Node item = childNodes.item(i);

			if (item != null) {
				String name = item.getNodeName();
				if (tag.equalsIgnoreCase(name)) {
					return item;
				}
			}
		}

		return null;
	}
}
