using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Sample1
{
    class Car
    {
        // リソース（イメージ）格納先
        // 実行ファイルはプロジェクトのbin/<構成>/<TargetFramework>配下になるため、
        // 5階層上のディレクトリにあるdataから取得することになる
        private const string strImagePath = "..\\..\\..\\..\\..\\data\\";

        public Image img;
        public int top;
        public int left;

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
    }

    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();

            // new式単純化(IDE0090)
            // PictureBox pb = new PictureBox();
            PictureBox pb = new();

            Car c = new Car();
            c.Move();
            c.Move();

            pb.Image = c.img;
            pb.Top = c.top;
            pb.Left = c.left;
            pb.Parent = this;
        }

    }
}
