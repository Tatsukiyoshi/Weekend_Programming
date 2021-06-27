using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

// 5.2章 アクセスの制限
namespace Sample2
{
    class Car
    {
        // リソース（イメージ）格納先：実行ファイルからの相対パス
        // .NET 5プロジェクトでは、実行ファイルがプロジェクトのbin/<構成>/<TargetFramework>配下に生成されるため、
        // 5階層上のディレクトリにあるdataから取得することにする
        // ※.NET 4.7までは、プロジェクトのbin/<構成>配下
        private const string strImagePath = "..\\..\\..\\..\\..\\data\\";

        // privateを指定してクラスの外側からアクセスできないようにする
        private Image img;
        private int top;
        private int left;

        public Car()
        {
            img = Image.FromFile(strImagePath + "car.bmp");
            top = 0;
            left = 0;
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
            get { return top;  }
        }

        public int Left
        {
            set { left = value; }
            get { return left; }
        }
    }

    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();

            // new式単純化(IDE0090)
            PictureBox pb = new();

            // new式単純化(IDE0090)
            Car c = new();
            c.Move();
            c.Move();

            // ゲッターで取得するように変更
            pb.Image = c.GetImage();

            // プロパティで参照するように変更
            pb.Top = c.Top;
            pb.Left = c.Left;

            pb.Parent = this;
        }
    }
}
