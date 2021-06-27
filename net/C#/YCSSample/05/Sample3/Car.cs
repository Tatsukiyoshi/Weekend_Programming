using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

// 5.3章 静的メンバ
namespace Sample3
{
    class Car
    {
        // リソース（イメージ）格納先：実行ファイルからの相対パス
        // .NET 5プロジェクトでは、実行ファイルがプロジェクトのbin/<構成>/<TargetFramework>配下に生成されるため、
        // 5階層上のディレクトリにあるdataから取得することにする
        // ※.NET 4.7までは、プロジェクトのbin/<構成>配下
        private const string strImagePath = "..\\..\\..\\..\\..\\data\\";

        // 静的フィールドの定義
        public static int Count = 0;

        // privateを指定してクラスの外側からアクセスできないようにする
        private Image img;
        private int top;
        private int left;

        public Car()
        {
            // コンストラクタを呼び出されたときにCountの値を１増やす
            Count++;

            img = Image.FromFile(strImagePath + "car.bmp");
            top = 0;
            left = 0;
        }

        public static String CountCar()
        {
            return "車は" + Count + "台あります。";
        }

        public void Move()
        {
            // 複合代入を使用(IDE0054)
            // top = top + 10;
            // left = left + 10;
            top += 10;
            left += 10;
        }

        // ゲッターとセッターを宣言する
        public void SetImage(Image i)
        {
            img = i;
        }

        public Image GetImage()
        {
            return img;
        }

        // プロパティとしてアクセスできるようにする
        public int Top
        {
            set { top = value; }
            get { return top; }
        }

        public int Left
        {
            set { left = value; }
            get { return left; }
        }
    }
}
