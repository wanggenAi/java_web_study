package util;

/**
 * �ַ�����������
 * 
 * @author Administrator
 *
 */
public class StringUtil {

	/**
	 * ���ַ�������ĸתΪ��д
	 * @param str Ҫת���ַ���
	 * @return ����ת���������ĸ��д���ַ���
	 */
	public static String toUpper(String str) {
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}
}
