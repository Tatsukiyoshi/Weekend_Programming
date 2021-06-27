using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

// 5.4章 新しいクラス
// 5.2章とは異なり、Carクラスを別ソースとする
// （フォームデザイナが使えなくなるため）
namespace Sample4
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();

            PictureBox[] pb = new PictureBox[2];

            for (int i = 0; i < pb.Length; i++)
            {
                pb[i] = new();
                pb[i].Parent = this;
            }

            Car[] c = new Car[2];
            c[0] = new Car();
            c[1] = new RacingCar();

            for(int i = 0; i < c.Length; i++)
            {
                c[i].Move();
                pb[i].Image = c[i].GetImage();
                pb[i].Top = c[i].Top;
                pb[i].Left = c[i].Left;
            }

            Label lb = new();
            lb.Text = Car.CountCar();
            lb.Top = pb[0].Bottom;
            lb.Parent = this;
        }
    }
}
