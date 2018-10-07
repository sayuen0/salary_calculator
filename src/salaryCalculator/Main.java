package salaryCalculator;
//給与計算アプリ
//時給　日給 週給　月給　年収　の対応パネル
//	どれかを入力すると全部まとめて出力してくれる
/*時給*8 =　日給
* 日給 *5 = 週給
* 　週給 * 4 = 月給
*  月給* 12 = 年収
*  の設定がデフォルト。変更可能。
* 
* todo 
* 給与入力後の操作をメソッドでまとめたい
* 残業代
* 控除額を超えるかどうか
* 
* */
import java.util.*;

public class Main {
	static double h,d,w,m,y;
	static double dwh=8.0,wwd=5.0,mww=4.0,ywm=12.0;
	static int select;
	public static void main(String[] args) {		

		Scanner sc = new java.util.Scanner(System.in);
		System.out.println("どの金額を入力しますか？[時給:1,日給:2,週給:3,月給:4,年収:5]");
		System.out.println("対応する数字を一つ入力してください。（半角全角問わず）");
		select = sc.nextInt();
		if(select != 1&& select != 2&&select != 3&&select != 4&&select != 5) {
			error();
			return;
		}
		decide();
		System.out.println("勤務時間設定は以下でよろしいですか？");
		System.out.println("[一日：8時間,"
				+"一週間：5日,"
				+"一ヶ月：4週間,"
				+"一年：12ヶ月]");
		System.out.println(	"よろしければ1,変更するなら2を入力してください。");	
		int i = sc.nextInt();
		if(i ==2) {
			System.out.println("一日の勤務時間を入力してください(~時間)");
			dwh = sc.nextDouble();
			System.out.println("週の勤務日数を入力してください(~日)");
			wwd = sc.nextDouble();
			System.out.println("一ヶ月の労働週数を入力してください(~週間)");
			mww = sc.nextDouble();
			System.out.println("年間の労働月数を入力してください(~ヶ月)");
			ywm = sc.nextDouble();
		}else if (i!=1 && i!=2) {
			error();
			return;
		}
		switch (select) {
		case 1:
			System.out.println("1:時給を入力してください(円)");
			h = sc.nextDouble();
			d = h*dwh;
			w = d*wwd/10000.0;
			m = w*mww;
			y = m*ywm;
			break;
		case 2:
			System.out.println("2:日給を入力してください(円)");
			d = sc.nextDouble();
			h = d/dwh;
			w = d*wwd/10000.0;
			m = w*mww;
			y = m*ywm;
			break;
		case 3:
			System.out.println("3:週給を入力してください(万円)");
			w = sc.nextDouble();
			d = w/wwd*10000;
			h = d/dwh;
			m = w*mww;
			y = m*ywm;
			break;
		case 4:
			System.out.println("4:月給を入力してください(万円)");
			m = sc.nextDouble();
			w = m/mww;
			d = w/wwd*10000;
			h = d/dwh;
			y = m*ywm;
			break;
		case 5:
			System.out.println("5:年収を入力してください(万円)");
			y = sc.nextDouble();
			m = y/ywm;
			w = m/mww;
			d = w/wwd*10000;
			h = d/dwh;
			break;			
		}
		System.out.println("時給:"+(int)h+"円");
		System.out.println("日給:"+(int)d+"円");
		System.out.println("週給:"+w*1.0+"万円");
		System.out.println("月給:"+m*1.0+"万円");
		System.out.println("年収:"+y*1.0+"万円");
		System.out.println("生涯賃金目安(年収×40年):"+(int)y*40/10000.0+"億円");
	}
	
	public static void error() {
		System.err.println("エラー。実行し直し、適切な数値を入力してください。");
		System.err.println("commmand + shift + F11 キー　または　画面上の▶️マークで実行ができます。");
			
	}
	public static void decide() {
		switch(select) {
		case 1:System.out.println("1：時給を入力します。");break;
		case 2:System.out.println("2：日給を入力します。");break;
		case 3:System.out.println("3：週給を入力します。");break;
		case 4:System.out.println("4：月給を入力します。");break;
		case 5:System.out.println("5：年収を入力します。");break;
		}
	}
}
