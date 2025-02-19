﻿using System;
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
#if(NET5_0_OR_GREATER)
        private const string strImagePath = "..\\..\\..\\..\\..\\..\\data\\";
#else
        private const string strImagePath = "..\\..\\..\\..\\..\\data\\";
#endif
        private const string strImageFile = "car.bmp";
        private string strImageFullPath = Directory.GetCurrentDirectory() + "\\" + strImagePath + strImageFile;

        private Image im;

        public Form1()
        {
            InitializeComponent();

            im = Image.FromFile(strImageFullPath);
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
