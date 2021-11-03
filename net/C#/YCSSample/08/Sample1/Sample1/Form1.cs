using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Sample1
{
    public partial class Form1 : Form
    {
        private Image im;

        public Form1()
        {
            InitializeComponent();

            im = Image.FromFile(Directory.GetCurrentDirectory() + "\\" + strImagePath + "car.bmp");
        }

        private void Form1_Paint(object sender, PaintEventArgs e)
        {
            Graphics g = e.Graphics;

            g.DrawImage(im, 1, 1);
        }

        private void Form1_Click(object sender, EventArgs e)
        {
            im.RotateFlip(RotateFlipType.Rotate90FlipNone);
            this.Invalidate();
        }
    }
}
