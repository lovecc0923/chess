package ai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cards {
	// public static int[] CardList = {
	// 0x0001, 0x0002, 0x0003, 0x0004, 0x0005, 0x0006, 0x0007, 0x0008, 0x0009,
	// 0x000A, 0x000B, 0x000C, 0x000D, // 方块 2 - A
	// 0x0101, 0x0102, 0x0103, 0x0104, 0x0105, 0x0106, 0x0107, 0x0108, 0x0109,
	// 0x010A, 0x010B, 0x010C, 0x010D, // 梅花 2 - A
	// 0x0201, 0x0202, 0x0203, 0x0204, 0x0205, 0x0206, 0x0207, 0x0208, 0x0209,
	// 0x020A, 0x020B, 0x020C, 0x020D, // 红桃 2 - A
	// 0x0301, 0x0302, 0x0303, 0x0304, 0x0305, 0x0306, 0x0307, 0x0308, 0x0309,
	// 0x030A, 0x030B, 0x030C, 0x030D, // 黑桃 2 - A
	// 0x0401, 0x0402,// 小鬼，大鬼
	// 0x0403,// 别杆
	// };

	public static int[] CardList = { 0x0001, 0x0002, 0x0003, 0x0004, 0x0005,
			0x0006, 0x0007, 0x0008, 0x0009, 0x000A,
			0x000B,
			0x000C,
			0x000D, // 方块 2 - A
			0x0101, 0x0102, 0x0103, 0x0104, 0x0105, 0x0106, 0x0107, 0x0108,
			0x0109, 0x010A, 0x010B,
			0x010C,
			0x010D, // 梅花 2 - A
			0x0201, 0x0202, 0x0203, 0x0204, 0x0205, 0x0206, 0x0207, 0x0208,
			0x0209, 0x020A, 0x020B, 0x020C,
			0x020D, // 红桃 2 - A
			0x0301, 0x0302, 0x0303, 0x0304, 0x0305, 0x0306, 0x0307, 0x0308,
			0x0309, 0x030A, 0x030B, 0x030C, 0x030D, // 黑桃 2 - A
			0x0401, 0x0402 // 小鬼，大鬼
	};

	public static void main(String[] args) {
		// String s = "3,4,5,6,7,8,9,10,11,12,13,14,15,16,17";
		//
		// String ss = "";
		//
		// for (int i = 3; i < 14; i++) {
		// for (int j = 0; j < 4; j++) {
		// ss += i + ",";
		// }
		// }
		// System.out.println(ss);
		//
		// //
		// System.out.println(0X0E);

		// System.out.println(GetCardValue(0x030D));
		// System.out.println(GetCardColor(0x030D));
		List<Integer> list = new ArrayList<Integer>();
		for (int card : CardList) {
			list.add(card);
		}
		System.out.println(list);
		Collections.shuffle(list);
		System.out.println(list);
	}

	/**
	 * 得到一个16bit数最低（最右边）那个字节
	 * 
	 * @param value
	 * @return
	 */
	static int LOBYTE(int value) {
		return (byte) value;
	}

	/**
	 * 得到一个16bit数最高（最左边）那个字节
	 * 
	 * @param value
	 * @return
	 */
	static int HIBYTE(int value) {
		return (value >> 8) & 0xFF;
	}

	/**
	 * 获取数值
	 * 
	 * @param value
	 * @return
	 */
	static int GetCardValue(int value) {
		return LOBYTE(value);
	}

	/**
	 * 获取花色
	 * 
	 * @param value
	 * @return
	 */
	static int GetCardColor(int value) {
		return HIBYTE(value);
	}

	static int GetCardLogicValue(int wCardData) {
		// 扑克属性
		int bCardColor = GetCardColor(wCardData);
		int bCardValue = GetCardValue(wCardData);

		// 转换数值
		if (bCardColor == 0x04)
			return bCardValue + 0x11;// 大小鬼,别杆
		if (bCardValue == 0x01)
			return 0x0E;// A
		if (bCardValue == 0x02)
			return 0x10;// 2

		return bCardValue;
	}
}
