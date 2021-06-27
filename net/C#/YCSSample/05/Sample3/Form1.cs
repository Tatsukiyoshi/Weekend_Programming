using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

// 5.3章 静的メンバ
// 5.2章とは異なり、Carクラスを別ソースとする
// （フォームデザイナが使えなくなるため）
namespace Sample3
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();

            Car c1 = new();

            PictureBox pb1 = new();
            pb1.Image = c1.GetImage();
            pb1.Top = c1.Top;
            pb1.Left = c1.Left;
            pb1.Parent = this;

            Car c2 = new();
            for (int i = 0; i < 10; i++) c2.Move();

            PictureBox pb2 = new();
            pb2.Image = c2.GetImage();
            pb2.Top = c2.Top;
            pb2.Left = c2.Left;
            pb2.Parent = this;

            Label lb = new();
            lb.Top = pb2.Bottom + 10;
            lb.Text = Car.CountCar();
            lb.Parent = this;
        }
    }
}
